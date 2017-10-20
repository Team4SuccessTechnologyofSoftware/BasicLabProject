-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 16 Οκτ 2017 στις 01:47:46
-- Έκδοση διακομιστή: 10.1.26-MariaDB
-- Έκδοση PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `projecttl`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `brands`
--

CREATE TABLE `brands` (
  `BrandID` int(11) NOT NULL,
  `BrandName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `category`
--

CREATE TABLE `category` (
  `CategoryID` int(11) NOT NULL,
  `CategoryName` varchar(50) NOT NULL,
  `SubCategoryName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `customers`
--

CREATE TABLE `customers` (
  `CustomerID` int(11) NOT NULL,
  `Country` int(50) NOT NULL,
  `City` int(50) NOT NULL,
  `Address` int(50) NOT NULL,
  `PostalCode` int(20) NOT NULL,
  `PhoneNumber` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `products`
--

CREATE TABLE `products` (
  `ProductID` int(11) NOT NULL,
  `BrandID` int(11) NOT NULL,
  `CategoryID` int(11) NOT NULL,
  `CustomerID` int(11) NOT NULL,
  `VendorID` int(11) NOT NULL,
  `ProductName` varchar(50) NOT NULL,
  `ProductDescription` text NOT NULL,
  `Price` decimal(8,2) NOT NULL,
  `Size` varchar(20) NOT NULL,
  `Color` varchar(20) NOT NULL,
  `Discount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `vendors`
--

CREATE TABLE `vendors` (
  `VendorID` int(11) NOT NULL,
  `CompanyName` varchar(50) NOT NULL,
  `Phone1` varchar(20) NOT NULL,
  `Phone2` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `brands`
--
ALTER TABLE `brands`
  ADD PRIMARY KEY (`BrandID`);

--
-- Ευρετήρια για πίνακα `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CategoryID`);

--
-- Ευρετήρια για πίνακα `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Ευρετήρια για πίνακα `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ProductID`),
  ADD KEY `CustomerID` (`CustomerID`),
  ADD KEY `VendorID` (`VendorID`),
  ADD KEY `CategoryID` (`CategoryID`),
  ADD KEY `BrandID` (`BrandID`);

--
-- Ευρετήρια για πίνακα `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- Ευρετήρια για πίνακα `vendors`
--
ALTER TABLE `vendors`
  ADD PRIMARY KEY (`VendorID`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `brands`
--
ALTER TABLE `brands`
  MODIFY `BrandID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT για πίνακα `category`
--
ALTER TABLE `category`
  MODIFY `CategoryID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT για πίνακα `products`
--
ALTER TABLE `products`
  MODIFY `ProductID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT για πίνακα `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `customers`
--
ALTER TABLE `customers`
  ADD CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `users` (`ID`);

--
-- Περιορισμοί για πίνακα `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customers` (`CustomerID`),
  ADD CONSTRAINT `products_ibfk_2` FOREIGN KEY (`VendorID`) REFERENCES `vendors` (`VendorID`),
  ADD CONSTRAINT `products_ibfk_3` FOREIGN KEY (`CategoryID`) REFERENCES `category` (`CategoryID`),
  ADD CONSTRAINT `products_ibfk_4` FOREIGN KEY (`BrandID`) REFERENCES `brands` (`BrandID`);

--
-- Περιορισμοί για πίνακα `vendors`
--
ALTER TABLE `vendors`
  ADD CONSTRAINT `vendors_ibfk_1` FOREIGN KEY (`VendorID`) REFERENCES `users` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
