<?php
require_once('connectDatabase.php');
if($_SERVER['REQUEST_METHOD']=='POST'){
$username=$_POST['Username'];
$email= $_POST['Email'];
$password= $_POST['Password'];
$firstName=$_POST['firstName'];
$lastName= $_POST['lastName'];
$PhoneNumber= $_POST['PhoneNumber'];
$sql= "insert into users (Username,Password,Email,Firstname,LastName,PhoneNumber) VALUES ('$username','$password','$email','$firstName','$lastName','$PhoneNumber')";
if(mysqli_query($conn,$sql))
echo "Successfully registered";
else
echo mysqli_error($conn);
}
else
echo mysqli_error($conn);

?>
