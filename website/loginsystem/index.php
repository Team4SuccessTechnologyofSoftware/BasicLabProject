<?php  
	include_once 'header.php';
?>

<section class="main-container">
	<div class="main-wrapper">
		<h2>Home</h2>
		<?php
			if (isset($_SESSION['u_id'])) {
				echo "You have logged in successfully"; // can use echo $_SESSION['u_id'] if i want to print users inf
			}
		 ?>
	</div>
</section>

<?php 
	include_once 'footer.php';
?>