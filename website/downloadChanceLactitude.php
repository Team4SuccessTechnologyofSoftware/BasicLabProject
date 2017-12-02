<?php
require_once('connectDatabase.php');


$sql0 = "select Lactitude from products";
$result = $conn->query($sql0);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
    $lact= $row["Lactitude"];
    echo "$lact"." ";
    }
} else {
    die ("no lactitude found...");
}

$conn->close();

?>