<?php 
	if (isset($_POST['submit'])) {
		$file = $_FILES['image'];

		$fileName = $_FILES['image']['name'];
		$fileTmpName = $_FILES['image']['tmp_name'];
		$fileSize = $_FILES['image']['size'];
		$fileError = $_FILES['image']['error'];
		$fileType = $_FILES['image']['type'];

		$fileExt = explode('.' , $fileName);
		$fileActualExt = strtolower(end($fileExt));

		$allowed = array('jpg', 'jpeg', 'png');

		if (in_array($fileActualExt, $allowed)) {
			if ($fileError === 0) {
				if ($fileSize < 1000000) {
					$fileNameNew = uniqid('', true).".".$fileActualExt;
					$fileDestination = 'uploads/'.$fileNameNew;
					move_uploaded_file($fileTmpName, $fileDestination);
					header("Location: ../index.php?upload=success");
				} else {
					echo "Your image is too big.";
				}
			} else {
				echo "There was an error uploading your image.";
			}
		} else {
			echo "You cannot upload files of this type.";
		}
	}
 ?>