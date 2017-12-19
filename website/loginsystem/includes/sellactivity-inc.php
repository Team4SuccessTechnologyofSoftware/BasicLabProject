<?php
   if(isset($_POST['submit']))
   {
    //Do all the submission part or storing in DB work and all here
    include 'dbh-inc.php';
    $desc = mysqli_real_escape_string($conn, $_POST['desc']);
	$price = mysqli_real_escape_string($conn, $_POST['price']);
	$disc = mysqli_real_escape_string($conn, $_POST['disc']);
	$cat = mysqli_real_escape_string($conn, $_POST['cat']);
	$sub = mysqli_real_escape_string($conn, $_POST['sub']);
	$lat = mysqli_real_escape_string($conn, $_POST['lat']);
	$lng = mysqli_real_escape_string($conn, $_POST['lng']);
	$image = mysqli_real_escape_string($conn, $_POST['image']);

	if (empty($desc) || empty($pwd) || empty($disc) || empty($cat) || empty($sub) || empty($lat) || empty($lng) || empty($image)) {
		header("Location: ../sell.php?sell=empty");
		exit();
	} else {
		$sql = "INSERT INTO products (ProductDesctription, Price, Discount, categoryName, subCategoryName, Lactitude, Longtitude, productImage) VALUES ('$desc', '$price', '$disc','cat', 'sub', 'lat','lng', '$image');";
		mysqli_query($conn, $sql);
		header("Location: ../sell.php?sell=success");
		exit();
   }
} else {
	header("Location: ../sell.php");
	exit();
}