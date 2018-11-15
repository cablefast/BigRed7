CREATE SCHEMA `br7`;



DROP TABLE IF EXISTS `BR7`.`Room`;

CREATE TABLE `BR7`.`Room` (

  `RmNum` VARCHAR(6) NOT NULL,

  `BldNum` VARCHAR(6) NOT NULL,

  PRIMARY KEY (`RmNum`, `BldNum`),

  INDEX (`BldNum`, `RmNum`)

);



DROP TABLE IF EXISTS `BR7`.`Support`;

CREATE TABLE `BR7`.`Support` (

  `SNum` VARCHAR(25) NOT NULL default '',

  `SName` VARCHAR(10) NOT NULL default '',

  `Desc` VARCHAR(255) NOT NULL default '',

  INDEX (`SNum`),
  
  PRIMARY KEY (`SNum`)

);



DROP TABLE IF EXISTS `BR7`.`Asset`;

CREATE TABLE `BR7`.`Asset` (

  `DSerNum` VARCHAR(40) NOT NULL,

  `Make` VARCHAR(20) NOT NULL default '',

  `Model` VARCHAR(20) NOT NULL default '',

  `PurchaseDate` DATE NOT NULL default '1990-01-01',

  `WarrantyEndDate` DATE NOT NULL default '1990-01-01',

  `BldNum` VARCHAR(6) NOT NULL default '',

  `RmNum` VARCHAR(6) NOT NULL default '',

  PRIMARY KEY (`DSerNum`),

  INDEX (`BldNum`, `RmNum`, `DSerNum`),

  FOREIGN KEY (`BldNum`, `RmNum`)

	REFERENCES `Room`(`BldNum`, `RmNum`)

	ON UPDATE CASCADE

);



DROP TABLE IF EXISTS `BR7`.`Storage`;

CREATE TABLE `BR7`.`Storage` (

  `SSerNum` VARCHAR(40) NOT NULL,
  `DSerNum` VARCHAR(40) NOT NULL,

  `Size` INT(10) NOT NULL,

  `Class` VARCHAR(10) NOT NULL default 'UNKNOWN',

  `WinName` VARCHAR(20) NOT NULL default '',

  INDEX (`DSerNum`),
 
  PRIMARY KEY (`SSerNum`),

  FOREIGN KEY (`DSerNum`)
 
	REFERENCES `Asset`(`DSerNum`)

);

DROP TABLE IF EXISTS `BR7`.`MTOE`;

CREATE TABLE `BR7`.`MTOE` (

  `Para` INT(3) NOT NULL default '000',

  `Ln` INT(2) NOT NULL default '00',

  `Pos` INT(3) NOT NULL default '000',

  `SNum` VARCHAR(25) NOT NULL default '',

  PRIMARY KEY (`Para`, `Ln`, `Pos`),

  INDEX (`Para`, `Ln`, `Pos`),

  FOREIGN KEY (`SNum`)

	REFERENCES `Support`(`SNum`)

);



DROP TABLE IF EXISTS `BR7`.`MTOE_Asset`;

CREATE TABLE `BR7`.`MTOE_Asset` (

  `DSerNum` VARCHAR(20) NOT NULL default '',

  `Para` INT(3) NOT NULL default '000',

  `Ln` INT(2) NOT NULL default '00',

  `Pos` INT(3) NOT NULL default '00',

  PRIMARY KEY (`DSerNum`, `Para`, `Ln`, `Pos`),

  INDEX (`DSerNum`, `Para`, `Ln`, `Pos`),

  FOREIGN KEY (`Para`, `Ln`, `Pos`)

	REFERENCES `MTOE`(`Para`, `Ln`, `Pos`),

  FOREIGN KEY (`DSerNum`)

	REFERENCES `Asset`(`DSerNum`)

	ON UPDATE CASCADE

);



DROP TABLE IF EXISTS `BR7`.`User`;

CREATE TABLE `BR7`.`User` (

  `EDIPI` INT(10) NOT NULL,

  `FName` VARCHAR(35) NOT NULL default '',

  `LName` VARCHAR(35) NOT NULL default '',

  `Para` INT(3) NOT NULL default '000',

  `Ln` INT(2) NOT NULL default '00',

  `Pos` INT(3) NOT NULL default '000',

  PRIMARY KEY (`EDIPI`),

  INDEX (`Para`, `Ln`, `Pos`),

  FOREIGN KEY (`Para`, `Ln`, `Pos`)

	REFERENCES `MTOE`(`Para`, `Ln`, `Pos`)

);