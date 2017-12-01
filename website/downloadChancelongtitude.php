<?php
require_once('connectDatabase.php');


$sql0 = "select Longtitude from products";
$result = $conn->query($sql0);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
    $longt= $row["Longtitude"];
    echo "$longt"." ";
    }
} else {
    die ("no longtutude found...");
}

$conn->close();

?>