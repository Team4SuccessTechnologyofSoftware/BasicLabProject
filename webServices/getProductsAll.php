<?php
require_once('connectDatabase.php');
if($_SERVER['REQUEST_METHOD']=='POST'){
$productDescription=$_POST['productDescription'];
$final = ltrim($productDescription);
$sql= "select *  from products where ProductDesctription='".$final."'";
$result = $conn->query($sql);
$counter=0;
while($row = mysqli_fetch_array($result))
{
     echo $row["ProductName"].",".$row["ProductDesctription"].",".$row["Price"].",".$row["Lactitude"].",".$row["Longtitude"].",".$row["productImage"].",".$row["ProductID"];

}

}
else{
echo mysqli_error($conn);
}
?>