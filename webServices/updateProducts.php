<?php
require_once('connectDatabase.php');
if($_SERVER['REQUEST_METHOD']=='POST'){
$productDescription=$_POST['productDescription'];
$productName=$_POST['productName'];
$productPrice=$_POST['productPrice'];
$productID=$_POST['productID'];
$final = ltrim($productID);
echo ltrim($productID);
$sql= "UPDATE products SET ProductName='".$productName."' , ProductDesctription='".$productDescription."', Price='".$productPrice."'  where ProductID=".$final."";
$result = $conn->query($sql);
}
else{
echo mysqli_error($conn);
}
?>