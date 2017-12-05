<?php
require_once('connectDatabase.php');


$sql0 = "select productImage from products";
$result = $conn->query($sql0);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
    $photo= $row["productImage"];
    echo "$photo"." ";
    }
} else {
    die ("no photo found...");
}

$conn->close();

?>