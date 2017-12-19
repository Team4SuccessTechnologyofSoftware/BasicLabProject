<?php

session_start();

if (isset($_POST['submit'])) {
	
	include 'dbh-inc.php';

	$uid = mysqli_real_escape_string($conn, $_POST['uid']);
	$pwd = mysqli_real_escape_string($conn, $_POST['pwd']);

	//Error handles
	//Check if inputs are empty
	if (empty($uid) || empty($pwd)) {
		header("Location: ../index.php?login=empty");
		exit();
	}
	else {
		$sql = "SELECT * FROM users WHERE Username='$uid' OR Email='$uid'";
		$result = mysqli_query($conn, $sql);
		$resultCheck = mysqli_num_rows($result);
		if ($resultCheck < 1) {
			header("Location: ../index.php?login=error");
			exit();
		}
		else {
			if ($row = mysqli_fetch_assoc($result)) {
				//De-hashing the password
				$hashedPwdCheck = password_verify($pwd, $row['Password']);
				if ($hashedPwdCheck == false) {
					header("Location: ../index.php?login=error");
					exit();
				}
				elseif ($hashedPwdCheck == true) {
					//User log in
					$_SESSION['u_uid'] = $row['Username'];
					$_SESSION['u_id'] = $row['ID'];
					$_SESSION['u_first'] = $row['FirstName'];
					$_SESSION['u_last'] = $row['LastName'];
					$_SESSION['u_email'] = $row['Email'];
					$_SESSION['u_phone'] = $row['PhoneNumber'];
					header("Location: ../index.php?login=success");
					exit();
				}
			}
		}
	}
}
else {
	header("Location: ../index.php?login=error");
	exit();
} 