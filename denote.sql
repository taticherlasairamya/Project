CREATE TABLE `denote`.`user` (
`userid` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`password` VARCHAR(45) NOT NULL,
`email` VARCHAR(45) NOT NULL,
`phoneno` BIGINT(10) NULL,
`gender` VARCHAR(45) NULL,
`dob` DATE NULL,
PRIMARY KEY (`userid`));

CREATE TABLE `denote`.`category` (
`categoryid` INT NOT NULL AUTO_INCREMENT,
`categoryname` VARCHAR(45) NULL,
`categoryicon` VARCHAR(45) NULL,
PRIMARY KEY (`categoryid`));

CREATE TABLE `denote`.`tag` (
`tagid` INT NOT NULL AUTO_INCREMENT,
`tagname` VARCHAR(45) NULL,
PRIMARY KEY (`tagid`));

CREATE TABLE `denote`.`expenses` (
`expensesid` INT NOT NULL AUTO_INCREMENT,
`categoryid` INT NULL,
`tagid` INT NULL,
`amount` INT NULL,
`date` DATE NULL,
PRIMARY KEY (`expensesid`));

ALTER TABLE `denote`.`expenses`
ADD INDEX `tagid_idx` (`tagid` ASC) VISIBLE,
ADD INDEX `categoryid_idx` (`categoryid` ASC) VISIBLE;

ALTER TABLE `denote`.`expenses`
ADD CONSTRAINT `tagid`
FOREIGN KEY (`tagid`)
REFERENCES `denote`.`tag` (`tagid`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
ADD CONSTRAINT `categoryid`
FOREIGN KEY (`categoryid`)
REFERENCES `denote`.`category` (`categoryid`)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
