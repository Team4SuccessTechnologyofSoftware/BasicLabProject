<?php
require_once('connectDatabase.php');
if($_SERVER['REQUEST_METHOD']=='POST'){
$productDescription=$_POST['productDescription'];
$final = ltrim($productDescription);
$sql= "DELETE FROM products where ProductDesctription='$final'";
$result = $conn->query($sql);
echo "Item : ".$productDescription." has been deleted successful!";
}
else{
echo "Hello world".mysqli_error($conn);
}
?>