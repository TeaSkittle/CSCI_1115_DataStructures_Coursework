;; Practical Common Lisp
;; CD Database
;;
;; stopped at Querying the Database

;; make-cd function
(defun make-cd (title artist rating ripped)
	(list :title title :artist artist 
		:rating rating :ripped ripped))

;; Create databe variable
;; defvar *db*, the ** is for global variables
(defvar *db* nil)

;; add-record function, using push
(defun add-record (cd) (push cd *db*))

;; dump-db function, cleaner output
(defun dump-db () ;; void function
	(dolist (cd *db*) ;; loop over all items in list, binding each element to variable cd
		;; similar to % in printf
		(format t "~{~a:~10t~a~%~}~%" cd)))

;; prompt-read function
(defun prompt-read (prompt)
	(format *query-io* "~a: " prompt) ;; format, like above
	(force-output *query-io*) ;; helps avoid waiting for newline
	(read-line *query-io*)) ;; read sinlge line of text

;; prompt-for-cd, combing make-cd and prompt-read
(defun prompt-for-cd ()
	(make-cd
		(prompt-read "Title")
		(prompt-read "Artist")
		;; read integer, not string
		(or ( parse-integer 
			(prompt-read "Rating") :junk-allowed t)
			0)
		(y-or-n-p "ripped [y/n")))

;; add-cds, loop until stopped by user
(defun add-cds ()
	(loop (add-record (prompt-for-cd))
		(if (not (y-or-n-p "Another? [y/n]: "))
			(return))))
			
;; save-db, save *db* to file
(defun save-db (filename)
	(with-open-file ;; opens file, execute expressions, and close file
				(out filename
					:direction :output ;; tell lisp to open file for writing
					:if-exists :supersede) ;; tell lisp to overwrite file
		(with-standard-io-syntax
			(print *db* out))))

;; load *db*
(defun load-db (filename)
	(with-open-file (in filename)
		(with-standard-io-synatx
			;; setf, lisps main assignment op
			;; sets the 1st arg to evaluation of the
			;; 2nd arg
			(setf *db* (read in)))))


;; DEBUGGING
(add-record (make-cd "Roses" "Kathy Mattea" 7 t))
;;(add-cds)
;;(save-sb "~/my-cds.db")
(dump-db)