<?php
require_once('connectDatabase.php');


$sql0 = "select * from users Inner Join products on users.ID = products.ID";
$result = $conn->query($sql0);

$d = array();

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $d[] = array(
            "ID" => "$row[ID]",
            "FirstName" => "$row[FirstName]",
            "LastName" => "$row[LastName]",
            "Email" => "$row[Email]",
            "PhoneNumber" => "$row[PhoneNumber]",
            "productID" => "$row[ProductID]",
            "Lactitude" => "$row[Lactitude]",
            "Longtitude" => "$row[Longtitude]",
            "Description" => "$row[ProductDesctription]",
            "productImage" => "$row[productImage]",
            "price" => "$row[Price]",
            "subcate" => "$row[subCategoryName]",
            "ProductName" => "$row[ProductName]"
        );
//echo ." "."$row[ID]"."$row[Lactitude]"." "."$row[ProductDesctription]"." "."$row[productImage]"." "."$row[Price]"." "//."$row[ProductName]"." "."$row[subCategoryName]"." "."$row[Longtitude]";
}
$json = json_encode($d);
echo $json;
} else {
    echo "0 results";
}

$conn->close();

?>