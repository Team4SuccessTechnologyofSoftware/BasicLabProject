 <?php
$servername = "localhost";
$username = "id3277532_project4semester";
$password = "team4success";

// Create connection
$conn = new mysqli($servername, $username, $password);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
echo "Connected successfully";
?> 