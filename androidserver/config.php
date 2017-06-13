<?php 
$server	="localhost";
$user	="root";
$pass	="root";
$db		="db_portalberita";
mysql_connect($server, $user, $pass) or die("Server Tidak ditemukan");
mysql_select_db($db) or die("Database tidak ditemukan");
?>