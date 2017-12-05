<?php
require_once('connectDatabase.php');


$sql0 = "select Price from products";
$result = $conn->query($sql0);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
    $price= $row["Price"];
    echo "$price"."::";
    }
} else {
    die ("no price found...");
}

$conn->close();

?>