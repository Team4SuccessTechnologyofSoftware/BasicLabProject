<?php 
	if (isset($_POST['submit'])) {
	include_once 'dbh-inc.php';

	$desc = mysqli_real_escape_string($conn, $_POST['desc']);
	$price = mysqli_real_escape_string($conn, $_POST['price']);
	$disc = mysqli_real_escape_string($conn, $_POST['disc']);
	$image = mysqli_real_escape_string($conn, $_POST['image']);
	

?>