<?php
mysql_connect("localhost","root","");
mysql_select_db("loginsystem");
if(isset($_REQUEST["submit"]))
{
	if(isset($_FILES['image'])){
    echo $_FILES['image']['tmp_name'];
}
	$price=$_REQUEST["price"];
	$description=$_REQUEST["description"];
	$discount=$_REQUEST["discount"];
	$hom=$_REQUEST["hom"];
	$vehicle=$_REQUEST["vehicle"];
	$computer=$_REQUEST["computer"];
	$musical=$_REQUEST["musical"];
	$personal=$_REQUEST["personal"];
	$clothes=$_REQUEST["clothes"];
	
	mysql_query("insert into categories(Homes,Vehicles,Computers,Musical,Personal,Clothes,Price,Description,Discount,Image)values('$hom','$vehicle','$computer','$musical','$personal','$clothes','$price','$description','$discount','image')");
	}
?>
<!DOCTYPE html>
<html>
<head>
<title>Choose your items to sell</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link href="form.css" rel="stylesheet"> 
</head>
<body>
<div id="main">
<div id="first">
<h1><br>Choose your items to sell or click <a href="index.php">HERE </a>to go back</h1></br>
<form method="post">
<label>Description :</label>
<input class="description" type="text" name ="description" cols="60" placeholder="Describe your item">
<label>Price :</label>
<input class="price" type="text" name="price" cols="60" placeholder="Price it!">
<label>Discount:</label>
<input class="discount" type="text" name="discount" cols="60" placeholder="Type the discount">
<label>Homes :</label>
<select name="hom">
<option value="">Choose your home from here</option>
<option>Apartment</option>
<option>Residence</option>
<option>Country house</option>
</select>
<label3>Vehicles :</label3>
<select name="vehicle">
<option value="">Choose your vehicle from here</option>
<option>Car</option>
<option>Motorbikes</option>
<option>Bicycles</option>
</select>
<label4>Computers :</label4>
<select name="computer">
<option value="">Choose your computer from here</option>
<option>PC</option>
<option>Laptop</option>
<option>Computer/Laptop parts</option>
<option>Mobile Phones</option>
</select>
<label5>Musical Organs :</label5>
<select name="musical">
<option value="">Choose your musical organ from here</option>
<option>Guitars</option>
<option>Basses</option>
<option>Drums</option>
<option>Pneumatics</option>
<option>Classical Organs</option>
</select>
<label6>Personal Objects :</label6>
<select name="personal">
<option value="">Choose your personal object from here</option>
<option>Furnitures</option>
<option>Home Devices</</option>
<option>Jewells</option>
<option>Design</option>
<option>Hobbies</option>
</select>
<label7>Clothes :</label7>
<select name="clothes">
<option value="">Choose your clothes from here</option>
<option>Women</option>
<option>Men</option>
<option>Girls</option>
<option>Boys</option>
</select>
<br></br>
<b><center><label>Upload an image of your item:</label></center></b>
<input class="image" type="file" name ="image" placeholder="Upload an image of your item">
<input class="submit" type="submit" value="Submit" name="submit">
</form>
</div>
</div>
</body>
</html>