<?php
require_once('connectDatabase.php');


$sql0 = "select ProductName from products";
$result = $conn->query($sql0);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
    $title= $row["ProductName"];
    echo "$title"."::";
    }
} else {
    die ("no title found...");
}

$conn->close();

?>