<?php
require_once('connectDatabase.php');
if($_SERVER['REQUEST_METHOD']=='POST'){
$username=$_POST['Username'];
$password= $_POST['Password'];
$sql= "select ID from users where Password LIKE '$password' AND Username LIKE '$username'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "logged successfully";
    }
} else
    echo "no user";
}
else
echo mysqli_error($conn);
?>