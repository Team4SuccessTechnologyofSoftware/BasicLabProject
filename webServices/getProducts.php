<?php
require_once('connectDatabase.php');
if($_SERVER['REQUEST_METHOD']=='POST'){
$userID=$_POST['UserID'];
$sql= "select ProductDesctription from products where ID=".$userID."";
$result = $conn->query($sql);
$counter=0;
while($row = mysqli_fetch_array($result))
{
        if($counter==0){
            echo $row["ProductDesctription"].",";
            $counter=1;
        }else{
            echo $row["ProductDesctription"].",";
         
        }

}

}
else{
echo mysqli_error($conn);
}
?>