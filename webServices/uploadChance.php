<?php
require_once('connectDatabase.php');
if($_SERVER['REQUEST_METHOD']=='POST'){

$username=$_POST['Username'];
$prodName= $_POST['ProductName'];
$price = $_POST['Price'];
$desc = $_POST['ProductDescription'];
$category = $_POST['Category'];
$subCat = $_POST['subCategory'];
$longi=$_POST['Longtitude'];
$lacti=$_POST['Lactitude'];



$sql0 = "select ID from users where Username LIKE '$username'";
$result = $conn->query($sql0);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $id= $row["ID"];
    }
} else {
    die ("user not found...");
}


$sql = "INSERT INTO products (ProductName, Price, ProductDesctription, ID,Lactitude, Longtitude)
VALUES ('$prodName', '$price', '$desc','$id', $lacti, $longi)";

$sql1 = "INSERT INTO category (CategoryName, subCategoryName)
VALUES ('$category', '$subCat')";



if ($conn->query($sql) === TRUE AND $conn->query($sql1) === TRUE) {
    echo "New record created successfully";
}else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}



//echo ($username." ".$prodName." ".$price." ".$desc." ".$category." ".$subCat);

$conn->close();

}
?>