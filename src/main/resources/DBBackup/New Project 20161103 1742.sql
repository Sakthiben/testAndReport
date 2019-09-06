-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.9


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema erpnextgeneration
--

CREATE DATABASE IF NOT EXISTS erpnextgeneration;
USE erpnextgeneration;

--
-- Definition of table `accgenledge001mb`
--

DROP TABLE IF EXISTS `accgenledge001mb`;
CREATE TABLE `accgenledge001mb` (
  `accglId` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(50) NOT NULL,
  `fromDate` varchar(40) NOT NULL,
  `toDate` varchar(40) NOT NULL,
  `partyType` varchar(40) NOT NULL,
  `partyName` varchar(40) NOT NULL,
  `grpbyVoucher` varchar(20) DEFAULT NULL,
  `grobyAccount` varchar(20) DEFAULT NULL,
  `letterHead` varchar(40) NOT NULL,
  `postingDate` varchar(40) NOT NULL,
  `accountName` varchar(60) NOT NULL,
  `debit` decimal(12,4) DEFAULT NULL,
  `credit` decimal(12,4) DEFAULT NULL,
  `voucherCode` varchar(50) NOT NULL,
  `voucherType` varchar(50) NOT NULL,
  `againstAmt` varchar(50) DEFAULT NULL,
  `projectname` varchar(50) NOT NULL,
  `costCenter` varchar(40) NOT NULL,
  `againvcType` varchar(50) NOT NULL,
  `againvcName` varchar(60) NOT NULL,
  PRIMARY KEY (`accglId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accgenledge001mb`
--

/*!40000 ALTER TABLE `accgenledge001mb` DISABLE KEYS */;
INSERT INTO `accgenledge001mb` (`accglId`,`company`,`fromDate`,`toDate`,`partyType`,`partyName`,`grpbyVoucher`,`grobyAccount`,`letterHead`,`postingDate`,`accountName`,`debit`,`credit`,`voucherCode`,`voucherType`,`againstAmt`,`projectname`,`costCenter`,`againvcType`,`againvcName`) VALUES 
 (1,'Dell','12/12/2014','12/12/2015','Customer','irin','1','0','Finance Manager','11/11/2015','Sales','10000.0000','0.0000','VC-001','Stock Entry','0','Intellor','SPL','No','Yes');
/*!40000 ALTER TABLE `accgenledge001mb` ENABLE KEYS */;


--
-- Definition of table `accountchart001mb`
--

DROP TABLE IF EXISTS `accountchart001mb`;
CREATE TABLE `accountchart001mb` (
  `chartId` int(11) NOT NULL AUTO_INCREMENT,
  `chartName` varchar(100) NOT NULL,
  PRIMARY KEY (`chartId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accountchart001mb`
--

/*!40000 ALTER TABLE `accountchart001mb` DISABLE KEYS */;
INSERT INTO `accountchart001mb` (`chartId`,`chartName`) VALUES 
 (1,'Equity'),
 (2,'Income');
/*!40000 ALTER TABLE `accountchart001mb` ENABLE KEYS */;


--
-- Definition of table `accountspayable001mb`
--

DROP TABLE IF EXISTS `accountspayable001mb`;
CREATE TABLE `accountspayable001mb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `postingdate` varchar(45) NOT NULL,
  `supplier` varchar(45) NOT NULL,
  `suppliertype` varchar(45) NOT NULL,
  `vouchertype` varchar(45) NOT NULL,
  `vouchernumber` varchar(45) NOT NULL,
  `duedate` varchar(45) NOT NULL,
  `billno` varchar(45) NOT NULL,
  `billdate` varchar(45) NOT NULL,
  `invoicedamount` int(10) unsigned NOT NULL,
  `paidamount` int(10) unsigned NOT NULL,
  `outstandingamount` int(10) unsigned NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `uptothirty` int(10) unsigned NOT NULL,
  `uptosixty` int(10) unsigned NOT NULL,
  `uptoninety` int(10) unsigned NOT NULL,
  `ninetyabove` int(10) unsigned NOT NULL,
  `currency` varchar(45) NOT NULL,
  `remarks` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accountspayable001mb`
--

/*!40000 ALTER TABLE `accountspayable001mb` DISABLE KEYS */;
INSERT INTO `accountspayable001mb` (`id`,`postingdate`,`supplier`,`suppliertype`,`vouchertype`,`vouchernumber`,`duedate`,`billno`,`billdate`,`invoicedamount`,`paidamount`,`outstandingamount`,`age`,`uptothirty`,`uptosixty`,`uptoninety`,`ninetyabove`,`currency`,`remarks`) VALUES 
 (3,'01/10/2016','Asiatic Solution','Distributor','test','32423','04/10/2016','234234','04/10/2016',234,234,234,23,2,3,4,5,'USD','test');
/*!40000 ALTER TABLE `accountspayable001mb` ENABLE KEYS */;


--
-- Definition of table `accountsreceivable001mb`
--

DROP TABLE IF EXISTS `accountsreceivable001mb`;
CREATE TABLE `accountsreceivable001mb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `postingdate` varchar(45) NOT NULL,
  `customer` varchar(45) NOT NULL,
  `vouchertype` varchar(45) NOT NULL,
  `voucherno` varchar(45) NOT NULL,
  `duedate` varchar(45) NOT NULL,
  `invoicedamount` int(10) unsigned NOT NULL,
  `paidamount` int(10) unsigned NOT NULL,
  `outstandingamount` int(10) unsigned NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `uptothirty` int(10) unsigned NOT NULL,
  `uptosixty` int(10) unsigned NOT NULL,
  `uptoninety` int(10) unsigned NOT NULL,
  `ninetyabove` int(10) unsigned NOT NULL,
  `currency` varchar(45) NOT NULL,
  `territory` varchar(45) NOT NULL,
  `remarks` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accountsreceivable001mb`
--

/*!40000 ALTER TABLE `accountsreceivable001mb` DISABLE KEYS */;
INSERT INTO `accountsreceivable001mb` (`id`,`postingdate`,`customer`,`vouchertype`,`voucherno`,`duedate`,`invoicedamount`,`paidamount`,`outstandingamount`,`age`,`uptothirty`,`uptosixty`,`uptoninety`,`ninetyabove`,`currency`,`territory`,`remarks`) VALUES 
 (1,'10-10-2016','mithra','voucher','voucher','20-10-2016',100,100,100,20,5,6,7,8,'100','territory','remarks'),
 (2,'14/10/2016','maya','voucher','voucher','05/10/2016',100,100,100,25,5,8,4,9,'rupee','territory','good'),
 (6,'15/10/2016','maya','voucher','voucher','06/10/2016',100,100,100,2,10,10,10,10,'RUPEE','territory','good');
/*!40000 ALTER TABLE `accountsreceivable001mb` ENABLE KEYS */;


--
-- Definition of table `appraisal001mb`
--

DROP TABLE IF EXISTS `appraisal001mb`;
CREATE TABLE `appraisal001mb` (
  `apprId` int(11) NOT NULL AUTO_INCREMENT,
  `series` varchar(30) NOT NULL,
  `appraisalTemp` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`apprId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appraisal001mb`
--

/*!40000 ALTER TABLE `appraisal001mb` DISABLE KEYS */;
INSERT INTO `appraisal001mb` (`apprId`,`series`,`appraisalTemp`) VALUES 
 (1,'SER_001','Mode_1'),
 (2,'SER_002','LTT');
/*!40000 ALTER TABLE `appraisal001mb` ENABLE KEYS */;


--
-- Definition of table `apprtemp001mb`
--

DROP TABLE IF EXISTS `apprtemp001mb`;
CREATE TABLE `apprtemp001mb` (
  `apptmpId` int(11) NOT NULL AUTO_INCREMENT,
  `appraisalTemp` varchar(40) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`apptmpId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `apprtemp001mb`
--

/*!40000 ALTER TABLE `apprtemp001mb` DISABLE KEYS */;
INSERT INTO `apprtemp001mb` (`apptmpId`,`appraisalTemp`,`description`) VALUES 
 (1,'Mode_1','Hard Work'),
 (2,'LTT','Full Attendance');
/*!40000 ALTER TABLE `apprtemp001mb` ENABLE KEYS */;


--
-- Definition of table `asset001mb`
--

DROP TABLE IF EXISTS `asset001mb`;
CREATE TABLE `asset001mb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `asset` varchar(45) NOT NULL,
  `depreciationdate` varchar(45) NOT NULL,
  `purchaseamount` int(10) unsigned NOT NULL,
  `depreciationamount` int(10) unsigned NOT NULL,
  `accumulateddepreciationamount` int(10) unsigned NOT NULL,
  `amountafterdepreciation` int(10) unsigned NOT NULL,
  `depreciationentry` varchar(45) NOT NULL,
  `assetcategory` varchar(45) NOT NULL,
  `currentstatus` varchar(45) NOT NULL,
  `depreciationmethod` varchar(45) NOT NULL,
  `purchasedate` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asset001mb`
--

/*!40000 ALTER TABLE `asset001mb` DISABLE KEYS */;
INSERT INTO `asset001mb` (`id`,`asset`,`depreciationdate`,`purchaseamount`,`depreciationamount`,`accumulateddepreciationamount`,`amountafterdepreciation`,`depreciationentry`,`assetcategory`,`currentstatus`,`depreciationmethod`,`purchasedate`) VALUES 
 (2,'Asset','10/11/2016',100,100,100,100,'asset','asset','STATUS','deprc','10/27/2016');
/*!40000 ALTER TABLE `asset001mb` ENABLE KEYS */;


--
-- Definition of table `assetmovement001mb`
--

DROP TABLE IF EXISTS `assetmovement001mb`;
CREATE TABLE `assetmovement001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `asset` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `targetwarehouse` varchar(255) DEFAULT NULL,
  `transactiondate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assetmovement001mb`
--

/*!40000 ALTER TABLE `assetmovement001mb` DISABLE KEYS */;
INSERT INTO `assetmovement001mb` (`id`,`asset`,`company`,`targetwarehouse`,`transactiondate`) VALUES 
 (2,'Asset','karya tech','target','10/06/2016');
/*!40000 ALTER TABLE `assetmovement001mb` ENABLE KEYS */;


--
-- Definition of table `bom001mb`
--

DROP TABLE IF EXISTS `bom001mb`;
CREATE TABLE `bom001mb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bom` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bom001mb`
--

/*!40000 ALTER TABLE `bom001mb` DISABLE KEYS */;
INSERT INTO `bom001mb` (`id`,`bom`,`type`) VALUES 
 (1,'BOM - Windmill A series','BOM'),
 (2,'BOM - Bearing Assembly','BOM'),
 (3,'BOM - Wing Sheet','BOM'),
 (4,'BOM - Base Plate','BOM'),
 (5,'BOM - Wind Turbine - S001','BOM'),
 (6,'BOM - Base Bearing Plate 001','BOM'),
 (7,'BOM - Base Bearing Plate 002','BOM'),
 (8,'BOM - Wind Turbine - S002','BOM'),
 (9,'BOM - Windmill B series','BOM'),
 (10,'BOM - Wind Turbine - S001','BOM'),
 (11,'BOM - Windmill B series','BOM'),
 (12,'BOM - Windmill B series','BOM'),
 (13,'BOM - Windmill B series','BOM'),
 (14,'BOM - Base Plate','BOM'),
 (15,'BOM - Wing Sheet','BOM'),
 (16,'BOM - Windmill B series','BOM'),
 (17,'BOM - Wind Turbine - S001','BOM '),
 (18,'BOM - Windmill B series','BOM '),
 (19,'BOM - Wind Turbine - S001','BOM '),
 (20,'BOM - Wind Turbine - S001','BOM '),
 (21,'BOM ','BOM '),
 (22,'BOM ','BOM ');
/*!40000 ALTER TABLE `bom001mb` ENABLE KEYS */;


--
-- Definition of table `bomtype001mb`
--

DROP TABLE IF EXISTS `bomtype001mb`;
CREATE TABLE `bomtype001mb` (
  `bomId` int(11) NOT NULL AUTO_INCREMENT,
  `bomName` varchar(100) NOT NULL,
  `bomType` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`bomId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bomtype001mb`
--

/*!40000 ALTER TABLE `bomtype001mb` DISABLE KEYS */;
INSERT INTO `bomtype001mb` (`bomId`,`bomName`,`bomType`) VALUES 
 (1,'BOM-WindMillSeries-001','BOM'),
 (2,'BOM-WindMillSeries-003','BOM');
/*!40000 ALTER TABLE `bomtype001mb` ENABLE KEYS */;


--
-- Definition of table `branch001mb`
--

DROP TABLE IF EXISTS `branch001mb`;
CREATE TABLE `branch001mb` (
  `branchId` int(11) NOT NULL AUTO_INCREMENT,
  `branchName` varchar(30) NOT NULL,
  PRIMARY KEY (`branchId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch001mb`
--

/*!40000 ALTER TABLE `branch001mb` DISABLE KEYS */;
INSERT INTO `branch001mb` (`branchId`,`branchName`) VALUES 
 (1,'CS'),
 (3,'Checker');
/*!40000 ALTER TABLE `branch001mb` ENABLE KEYS */;


--
-- Definition of table `brand001mb`
--

DROP TABLE IF EXISTS `brand001mb`;
CREATE TABLE `brand001mb` (
  `brandId` int(11) NOT NULL AUTO_INCREMENT,
  `brandName` varchar(30) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`brandId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `brand001mb`
--

/*!40000 ALTER TABLE `brand001mb` DISABLE KEYS */;
INSERT INTO `brand001mb` (`brandId`,`brandName`,`description`) VALUES 
 (1,'Top','Too Expense'),
 (2,'Normal','Still rate is too high');
/*!40000 ALTER TABLE `brand001mb` ENABLE KEYS */;


--
-- Definition of table `communication001mb`
--

DROP TABLE IF EXISTS `communication001mb`;
CREATE TABLE `communication001mb` (
  `commId` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(50) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `sentrec` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`commId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `communication001mb`
--

/*!40000 ALTER TABLE `communication001mb` DISABLE KEYS */;
INSERT INTO `communication001mb` (`commId`,`subject`,`status`,`sentrec`) VALUES 
 (1,'Sample','Open','Sent'),
 (2,'Normal','Replied','Received');
/*!40000 ALTER TABLE `communication001mb` ENABLE KEYS */;


--
-- Definition of table `companyaccount001mb`
--

DROP TABLE IF EXISTS `companyaccount001mb`;
CREATE TABLE `companyaccount001mb` (
  `caId` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(100) NOT NULL,
  `country` varchar(60) NOT NULL,
  `abbreviation` varchar(50) NOT NULL,
  `companyDomain` varchar(60) NOT NULL,
  `defholList` varchar(50) NOT NULL,
  `defCurrency` varchar(50) NOT NULL,
  `accchartType` varchar(50) NOT NULL,
  `defbankAccount` varchar(50) NOT NULL,
  `defcashAccount` varchar(50) NOT NULL,
  `defpayAccount` varchar(50) NOT NULL,
  `defincomeAccount` varchar(50) NOT NULL,
  `rndoffCenter` varchar(50) NOT NULL,
  PRIMARY KEY (`caId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `companyaccount001mb`
--

/*!40000 ALTER TABLE `companyaccount001mb` DISABLE KEYS */;
INSERT INTO `companyaccount001mb` (`caId`,`companyName`,`country`,`abbreviation`,`companyDomain`,`defholList`,`defCurrency`,`accchartType`,`defbankAccount`,`defcashAccount`,`defpayAccount`,`defincomeAccount`,`rndoffCenter`) VALUES 
 (1,'IBM','United States','WPL','IT','2015','USD','Standard','National Bank','Cash','Creditors','Sales','Main');
/*!40000 ALTER TABLE `companyaccount001mb` ENABLE KEYS */;


--
-- Definition of table `compprodorder001mb`
--

DROP TABLE IF EXISTS `compprodorder001mb`;
CREATE TABLE `compprodorder001mb` (
  `prodId` int(11) NOT NULL AUTO_INCREMENT,
  `prorderCode` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `itemtoManufacture` varchar(40) NOT NULL,
  `toProduce` varchar(30) DEFAULT NULL,
  `produced` varchar(30) NOT NULL,
  `empCompany` varchar(30) NOT NULL,
  PRIMARY KEY (`prodId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `compprodorder001mb`
--

/*!40000 ALTER TABLE `compprodorder001mb` DISABLE KEYS */;
INSERT INTO `compprodorder001mb` (`prodId`,`prorderCode`,`date`,`itemtoManufacture`,`toProduce`,`produced`,`empCompany`) VALUES 
 (1,'PRO_00084','10/20/2016','Balleett','10','6','Dell');
/*!40000 ALTER TABLE `compprodorder001mb` ENABLE KEYS */;


--
-- Definition of table `crmmintoresp001mb`
--

DROP TABLE IF EXISTS `crmmintoresp001mb`;
CREATE TABLE `crmmintoresp001mb` (
  `mrpId` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(30) NOT NULL,
  `mintoresp` varchar(20) NOT NULL,
  PRIMARY KEY (`mrpId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `crmmintoresp001mb`
--

/*!40000 ALTER TABLE `crmmintoresp001mb` DISABLE KEYS */;
INSERT INTO `crmmintoresp001mb` (`mrpId`,`date`,`mintoresp`) VALUES 
 (1,'12/12/2015','60'),
 (2,'10/10/2014','10'),
 (3,'10/12/2016','20'),
 (8,'10/11/2016','35');
/*!40000 ALTER TABLE `crmmintoresp001mb` ENABLE KEYS */;


--
-- Definition of table `crmspcontact001mb`
--

DROP TABLE IF EXISTS `crmspcontact001mb`;
CREATE TABLE `crmspcontact001mb` (
  `contId` int(11) NOT NULL AUTO_INCREMENT,
  `leadName` varchar(50) NOT NULL,
  `status` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`contId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `crmspcontact001mb`
--

/*!40000 ALTER TABLE `crmspcontact001mb` DISABLE KEYS */;
INSERT INTO `crmspcontact001mb` (`contId`,`leadName`,`status`) VALUES 
 (1,'Rodriguez','Passive'),
 (2,'Jenson','Open'),
 (3,'Benzema','Replied');
/*!40000 ALTER TABLE `crmspcontact001mb` ENABLE KEYS */;


--
-- Definition of table `crmspcust001mb`
--

DROP TABLE IF EXISTS `crmspcust001mb`;
CREATE TABLE `crmspcust001mb` (
  `custId` int(11) NOT NULL AUTO_INCREMENT,
  `customername` varchar(50) NOT NULL,
  `status` varchar(30) DEFAULT NULL,
  `customergroup` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`custId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `crmspcust001mb`
--

/*!40000 ALTER TABLE `crmspcust001mb` DISABLE KEYS */;
INSERT INTO `crmspcust001mb` (`custId`,`customername`,`status`,`customergroup`) VALUES 
 (1,'Mithra','Open','QAS'),
 (3,'Dhiksha','Dormant','QAS');
/*!40000 ALTER TABLE `crmspcust001mb` ENABLE KEYS */;


--
-- Definition of table `crmsplead001mb`
--

DROP TABLE IF EXISTS `crmsplead001mb`;
CREATE TABLE `crmsplead001mb` (
  `slineId` int(11) NOT NULL AUTO_INCREMENT,
  `personName` varchar(50) NOT NULL,
  `orgName` varchar(50) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`slineId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `crmsplead001mb`
--

/*!40000 ALTER TABLE `crmsplead001mb` DISABLE KEYS */;
INSERT INTO `crmsplead001mb` (`slineId`,`personName`,`orgName`,`status`) VALUES 
 (1,'Shankar','Rhodes Furniture','Lead'),
 (2,'Judy','Nippon Paints','Open'),
 (3,'James','Epic','Interested');
/*!40000 ALTER TABLE `crmsplead001mb` ENABLE KEYS */;


--
-- Definition of table `crmspoppo001mb`
--

DROP TABLE IF EXISTS `crmspoppo001mb`;
CREATE TABLE `crmspoppo001mb` (
  `oppId` int(11) NOT NULL AUTO_INCREMENT,
  `oppSeries` varchar(50) NOT NULL,
  `oppType` varchar(40) DEFAULT NULL,
  `oppFrom` varchar(40) DEFAULT NULL,
  `status` varchar(40) DEFAULT NULL,
  `withitems` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`oppId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `crmspoppo001mb`
--

/*!40000 ALTER TABLE `crmspoppo001mb` DISABLE KEYS */;
INSERT INTO `crmspoppo001mb` (`oppId`,`oppSeries`,`oppType`,`oppFrom`,`status`,`withitems`) VALUES 
 (1,'OPSER-001','Sales','Lead','Open','1'),
 (2,'OPSER-002','Maintainance','Customer','Converted','0'),
 (3,'OPSER-008','Sales','Customer','Converted','0');
/*!40000 ALTER TABLE `crmspoppo001mb` ENABLE KEYS */;


--
-- Definition of table `customeracquisition001mb`
--

DROP TABLE IF EXISTS `customeracquisition001mb`;
CREATE TABLE `customeracquisition001mb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `year` int(10) unsigned NOT NULL,
  `month` varchar(45) NOT NULL,
  `newcustomers` int(10) unsigned NOT NULL,
  `repeatcustomers` int(10) unsigned NOT NULL,
  `total` int(10) unsigned NOT NULL,
  `newcustomersrevenue` mediumtext NOT NULL,
  `repeatcustomersrevenue` mediumtext NOT NULL,
  `totalrevenue` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customeracquisition001mb`
--

/*!40000 ALTER TABLE `customeracquisition001mb` DISABLE KEYS */;
INSERT INTO `customeracquisition001mb` (`id`,`year`,`month`,`newcustomers`,`repeatcustomers`,`total`,`newcustomersrevenue`,`repeatcustomersrevenue`,`totalrevenue`) VALUES 
 (1,2005,'jan',1,1,2,'100','100','300');
/*!40000 ALTER TABLE `customeracquisition001mb` ENABLE KEYS */;


--
-- Definition of table `customercreditbalance001mb`
--

DROP TABLE IF EXISTS `customercreditbalance001mb`;
CREATE TABLE `customercreditbalance001mb` (
  `ccid` int(11) NOT NULL AUTO_INCREMENT,
  `customer` varchar(45) DEFAULT NULL,
  `creditlimit` mediumtext NOT NULL,
  `outstandingamount` mediumtext NOT NULL,
  `creditbalance` mediumtext NOT NULL,
  `id` int(11) NOT NULL,
  `Customername` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ccid`),
  KEY `id` (`id`),
  CONSTRAINT `customercreditbalance001mb_ibfk_1` FOREIGN KEY (`id`) REFERENCES `customerdetails001mb` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customercreditbalance001mb`
--

/*!40000 ALTER TABLE `customercreditbalance001mb` DISABLE KEYS */;
INSERT INTO `customercreditbalance001mb` (`ccid`,`customer`,`creditlimit`,`outstandingamount`,`creditbalance`,`id`,`Customername`) VALUES 
 (1,'maya','100','200','1000',2,'Dhiksha'),
 (10,NULL,'1000','200','100',4,'irin');
/*!40000 ALTER TABLE `customercreditbalance001mb` ENABLE KEYS */;


--
-- Definition of table `customerdetails001mb`
--

DROP TABLE IF EXISTS `customerdetails001mb`;
CREATE TABLE `customerdetails001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` varchar(45) NOT NULL,
  `customername` varchar(45) NOT NULL,
  `customergroup` varchar(45) NOT NULL,
  `addressline1` varchar(45) NOT NULL,
  `addressline2` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `postalcode` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `isprimaryaddress` tinyint(1) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `mobilenumber` varchar(45) NOT NULL,
  `emailid` varchar(45) NOT NULL,
  `isprimarycontact` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customerdetails001mb`
--

/*!40000 ALTER TABLE `customerdetails001mb` DISABLE KEYS */;
INSERT INTO `customerdetails001mb` (`id`,`customerid`,`customername`,`customergroup`,`addressline1`,`addressline2`,`city`,`state`,`postalcode`,`country`,`isprimaryaddress`,`firstname`,`lastname`,`phone`,`mobilenumber`,`emailid`,`isprimarycontact`) VALUES 
 (1,'KT01','Mithra','QAS','Chennai','Chennai','Chennai','Tamilnadu','600028','INDIA',1,'Mithra','V','123456789','123456789','mithra',1),
 (2,'KT02','Dhiksha','QAS','Madurai','Madurai','Madurai','Tamilnadu','600000','INDIA',1,'Dhiksha','G','1524367','142536','dhikash',1),
 (3,'KT03','shaasha','QAS','chennai','chennai','chennai','TN','600000','INDIA',1,'shaasha','shaasha','1235682','1245639','shaashagmail',1),
 (4,'KT04','irin','','chenai','chennai','chennai','tn','4000','india',1,'jj','jj','15421','4523','gmail',0);
/*!40000 ALTER TABLE `customerdetails001mb` ENABLE KEYS */;


--
-- Definition of table `dailytimesheet001mb`
--

DROP TABLE IF EXISTS `dailytimesheet001mb`;
CREATE TABLE `dailytimesheet001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timesheet` varchar(45) NOT NULL,
  `employee` varchar(45) NOT NULL,
  `employeename` varchar(45) NOT NULL,
  `fromdatetime` varchar(50) NOT NULL,
  `todatetime` varchar(50) NOT NULL,
  `hours` varchar(50) NOT NULL,
  `activitytype` varchar(50) NOT NULL,
  `task` varchar(50) NOT NULL,
  `project` varchar(45) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dailytimesheet001mb`
--

/*!40000 ALTER TABLE `dailytimesheet001mb` DISABLE KEYS */;
INSERT INTO `dailytimesheet001mb` (`id`,`timesheet`,`employee`,`employeename`,`fromdatetime`,`todatetime`,`hours`,`activitytype`,`task`,`project`,`status`) VALUES 
 (2,'timesheet','EMP_06,2','Harish','10/07/2016','10/12/2016','8hrs','testing','Intellor Testing','veriato','open'),
 (3,'timesheet','EMP_06,2','Harish','10/12/2016','10/13/2016','8 hrs','testing','Intellor Testing','Intellor','initated'),
 (4,'te','EMP_08,11','naresh','10/13/2016','10/13/2016','2 hrs','act','Intellor Dev','Intellor','initated'),
 (5,'task','EMP_07,7','Vakhita Ryzaev','10/07/2016','10/14/2016','2 hrs','activity','Intellor Testing','Intellor','initated'),
 (6,'task','EMP_05,10','venkat','10/14/2016','10/07/2016','2 hrs','activity','Intellor Dev','Intellor','initated'),
 (8,'task','EMP_04,8,Select','Charmaine Gaudreau','09/28/2016','10/05/2016','2 hrs','`act','Intellor Dev','Intellor','initated,1');
/*!40000 ALTER TABLE `dailytimesheet001mb` ENABLE KEYS */;


--
-- Definition of table `delnotetrends001mb`
--

DROP TABLE IF EXISTS `delnotetrends001mb`;
CREATE TABLE `delnotetrends001mb` (
  `dntrendId` int(11) NOT NULL AUTO_INCREMENT,
  `period` varchar(50) NOT NULL,
  `basedOn` varchar(40) NOT NULL,
  `fiscalYear` varchar(30) NOT NULL,
  `company` varchar(60) NOT NULL,
  `itemCode` varchar(50) NOT NULL,
  `janQty` varchar(40) DEFAULT NULL,
  `janAmt` decimal(12,4) DEFAULT NULL,
  `febQty` varchar(40) DEFAULT NULL,
  `febAmt` decimal(12,4) DEFAULT NULL,
  `marQty` varchar(30) DEFAULT NULL,
  `marAmt` decimal(12,4) DEFAULT NULL,
  `aprQty` varchar(40) NOT NULL,
  `aprAmt` decimal(12,4) DEFAULT NULL,
  `mayQty` varchar(40) DEFAULT NULL,
  `mayAmt` decimal(12,4) DEFAULT NULL,
  `junQty` varchar(40) DEFAULT NULL,
  `junAmt` decimal(12,4) DEFAULT NULL,
  `julQty` varchar(40) DEFAULT NULL,
  `julAmt` decimal(12,4) DEFAULT NULL,
  `augQty` varchar(40) DEFAULT NULL,
  `augAmt` decimal(12,4) DEFAULT NULL,
  `sepQty` varchar(40) DEFAULT NULL,
  `sepAmt` decimal(12,4) DEFAULT NULL,
  `octQty` varchar(40) DEFAULT NULL,
  `octAmt` decimal(12,4) DEFAULT NULL,
  `novQty` varchar(40) DEFAULT NULL,
  `novAmt` decimal(12,4) DEFAULT NULL,
  `decQty` varchar(40) DEFAULT NULL,
  `decAmt` decimal(12,4) DEFAULT NULL,
  `totalQty` varchar(30) DEFAULT NULL,
  `totalAmt` decimal(12,4) DEFAULT NULL,
  `augQtyt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dntrendId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `delnotetrends001mb`
--

/*!40000 ALTER TABLE `delnotetrends001mb` DISABLE KEYS */;
INSERT INTO `delnotetrends001mb` (`dntrendId`,`period`,`basedOn`,`fiscalYear`,`company`,`itemCode`,`janQty`,`janAmt`,`febQty`,`febAmt`,`marQty`,`marAmt`,`aprQty`,`aprAmt`,`mayQty`,`mayAmt`,`junQty`,`junAmt`,`julQty`,`julAmt`,`augQty`,`augAmt`,`sepQty`,`sepAmt`,`octQty`,`octAmt`,`novQty`,`novAmt`,`decQty`,`decAmt`,`totalQty`,`totalAmt`,`augQtyt`) VALUES 
 (1,'Monthly','Item','2015','Dell','Table','12','3400.0000','10','2450.0000','','0.0000','','0.0000','','0.0000','','0.0000','','0.0000','','0.0000','6','4500.0000','7','5600.0000','','0.0000','14','16000.0000','100','1000000.0000',NULL),
 (2,'Weekly','Supplier Type','2011','Dell','Internal Disc','2','200.0000','1','100.0000','3','300.0000','4','400.0000','1','100.0000','1','100.0000',NULL,'600.0000',NULL,'700.0000','4','400.0000','3','300.0000','3','300.0000','2','200.0000','16','16000.0000','2');
/*!40000 ALTER TABLE `delnotetrends001mb` ENABLE KEYS */;


--
-- Definition of table `department001mb`
--

DROP TABLE IF EXISTS `department001mb`;
CREATE TABLE `department001mb` (
  `deptid` int(11) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`deptid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department001mb`
--

/*!40000 ALTER TABLE `department001mb` DISABLE KEYS */;
INSERT INTO `department001mb` (`deptid`,`deptName`) VALUES 
 (1,'Legal'),
 (2,'Marketing Accounts'),
 (3,'Research & Development'),
 (4,'Quality Management'),
 (6,'Management'),
 (7,'Human Resources'),
 (8,'Customer Service'),
 (9,'Dispatch'),
 (10,'Production'),
 (11,'Operations');
/*!40000 ALTER TABLE `department001mb` ENABLE KEYS */;


--
-- Definition of table `designation001mb`
--

DROP TABLE IF EXISTS `designation001mb`;
CREATE TABLE `designation001mb` (
  `designId` int(11) NOT NULL AUTO_INCREMENT,
  `designation` varchar(30) NOT NULL,
  PRIMARY KEY (`designId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `designation001mb`
--

/*!40000 ALTER TABLE `designation001mb` DISABLE KEYS */;
INSERT INTO `designation001mb` (`designId`,`designation`) VALUES 
 (1,'Project Manager'),
 (2,'Researcher');
/*!40000 ALTER TABLE `designation001mb` ENABLE KEYS */;


--
-- Definition of table `email001mb`
--

DROP TABLE IF EXISTS `email001mb`;
CREATE TABLE `email001mb` (
  `emailId` int(11) NOT NULL AUTO_INCREMENT,
  `emailFrom` varchar(50) NOT NULL,
  `emailTo` varchar(50) NOT NULL,
  `emailCC` text NOT NULL,
  `emailBCC` text NOT NULL,
  `emailDate` varchar(30) DEFAULT NULL,
  `emailSubject` varchar(100) DEFAULT NULL,
  `emailBody` text,
  `emailCurrentPlace` varchar(30) DEFAULT NULL,
  `isEmailViewed` varchar(30) DEFAULT NULL,
  `isEmailAttachmentExists` varchar(10) DEFAULT NULL,
  `multipleEmailId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emailId`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `email001mb`
--

/*!40000 ALTER TABLE `email001mb` DISABLE KEYS */;
INSERT INTO `email001mb` (`emailId`,`emailFrom`,`emailTo`,`emailCC`,`emailBCC`,`emailDate`,`emailSubject`,`emailBody`,`emailCurrentPlace`,`isEmailViewed`,`isEmailAttachmentExists`,`multipleEmailId`) VALUES 
 (58,'siva','kabirulm@karyatech.com','venkata@karyatech.com','naresh@karyatech.com','Tue Nov 01 11:21:23 IST 2016','This is test email subject','Kabirul, This the is email body.This the is email body.This the is email body.This the is email body.This the is email body.This the is email body.This the is email body. This the is email body.This the is email body.This the is email body.This the is email body.This the is email body.This the is email body. Thanks,Kabirul Islam','inbox','yes','yes',NULL),
 (87,'siva','kabirulm@karyatech.com','venkata@karyatech.com','naresh@karyatech.com','Tue Nov 01 16:04:52 IST 2016','This is test email subject','<div>Hi Kabirul,</div><div>This is email body.<b>This is email body</b>.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.</div><div>Please find the attachment below.</div><div>Link :&nbsp;<a href=\"http://www.karyatech.com\" target=\"_blank\">Attach Link</a></div><div><br></div><div>Thanks,</div><div>Kabirul Islam</div>','trash','yes','yes',NULL),
 (88,'siva','kabirulm@karyatech.com','venkata@karyatech.com','naresh@karyatech.com','Tue Nov 01 16:08:01 IST 2016','This is test email subject','<div>Hi Kabirul,</div><div>This is email body.<span style=\"font-weight: bold;\">This is email body</span>.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.</div><div>Please find the attachment below.</div><div>Link :&nbsp;<a href=\"http://www.karyatech.com\" target=\"_blank\">Attach Link</a></div><div><br></div><div>Thanks,</div><div>Kabirul Islam</div>','sent','yes','yes',NULL),
 (89,'siva','kabirulm@karyatech.com','venkata@karyatech.com','naresh@karyatech.com','Tue Nov 01 16:25:25 IST 2016','This is test email subject','<div>Hi Kabirul,</div><div style=\"text-align: justify;\">This is email body.This is email body.<b>This is email body</b>.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.This is email body.</div><div style=\"text-align: justify;\">Please find the attachment below.</div><div style=\"text-align: justify;\"><br></div><div>Thanks,</div><div>Kabirul Islam</div>','inbox','yes','yes',NULL),
 (91,'siva','','','','Tue Nov 01 16:39:44 IST 2016','This is test email subject','<img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAMAAADDpiTIAAAB9VBMVEUAAABEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBEREBNTU1MTExNTU1LS0tLS0tNTU1NTU1LS0pLS0tMTEtKSkpMTExLS0tMTExMTExLS0tMTExmZmZ/f39NTU1LS0tUVFRNTU1LS0sAAABMTExNTU1RUVFNTU1LS0s/Pz9LS0tLS0tMTExLS0tLS0tMTExMTExMTExNTU1MTExMTExNTU1NTU1MTExMTExOTk5ISEhLS0tOTk5NTU1LS0tNTUpKSkdMTExMTEtNTUxNTU1PT09LS0tMTExNTU1LS0tNTU1LS0tLS0pLS0pMTExMTExNTU1NTU1NTU1KSkpNTU1NTU1LS0tLS0tMTExMTEtISEZMTExMTExMTExMTExMTExNTU1LS0hKSkpLS0tLS0tNTU1LS0tNTU1LS0tOTk5NTU1NTU1NTU1LS0tNTU1MTExLS0pMTExNTU1NTU1VVVVNTU1NTU1MTExNTU1NTU1LS0pMTExDQ0BLS0tLS0pLS0pMTEtMTExLS0tJSUZLS0pMTExHR0NLS0tMTEtLS0tMTExNTU1NTU1NTU1NTU1LS0tLS0pNTU1NTU1NTUxMTEyS6h4CAAAAo3RSTlMAAQIDAwEEBQEFBgEHCAEICQIKCwILDA4MAg8OAiR8vOj9/uvHjT0pscg+dPmQBQKbugmesAFy9BmN7AR6maSmpaGgneCwsa2sqntEB+8abacSEYX6La4dnG6r0eTo6emTaiH3pBj7qOXRrXIm+6kja5afEKWgn9CpbBsnd6Vj6YcU4a2pOwOhoqeRcUbrE5DzJHWethX9jhK/QCJ4ueP4vYY3603lewAADkRJREFUeNrtnel7G1cdRhVbsWzZsmUrlmwnwCQshSbFBTcUKMTxlKYUKEvZaa1QCjSEtU0b1rKlkJZ93/ex/XfyoY4y9jOtpdHcmd+979EnnuMvmnumPMqr82hqNV680q9jExMTx2BSLP2arNfrkzAplnodn2o0GlPHYUIs/ZqeaTabM9MwIZZ+zc61Wq25WZgQS7/mF9rt9sI8TIjVUp8HF5c6nc7S4oE/w8JmxycnBv/7xHK3210+ceDvsLDZ9FR9cAMsLvd6vZXVA39fXYGFzGZnGoMbYH6p21s7eerA30+dXFuDhcvm55qN+v5ngNmFTrfHGUmxxYVWs7G/CU3PtTvdFc5IiZ1YareaU/ufBWda7c7yKmckxFaXO+3WzP4mONVstZdOcEZKbKXbac/tb4KTjWZrYZEzkmK9bmdhfxM8Vm805+ZFz+NVr35NdPrMa1/3+jeI3RO97tIt5xP1xsyspv873ngmSZJkZ3dvb+9Nd0qdQW958P/5E/WpaU3/Z88lA/+7O2fuerPQGazc/sw3MXlc0v/63Unaf5Ikb3mrzhmsZn4fJOV/47D/JLnnvOZnQvy/5D9J3oZ/af/JvW/Hv7L/JHkH/qX9J++8D//K/pPkTvxL+995l5j/1L8BV/Gf7Oy+W8r/gSZwBf87u3sXlPwfagLxv7u3tynkX7EJPMr/3kWaQGn/u1sy/hWbwKP978Qq/hWbwCH8J7GIf8UmcBj/6RuAJlDQf+oGoAlU9H/7BqAJlPQ/uAFoAjX937oBaAJF/e/fADSBqv5fugFoAmT9JzH+pf0nMf6l/Scx/qX9JzH+pf0nW/iX9r9zkSZQ2v/uJk2gtP+9TZpAaf80geL+aQLF/dMEivunCRT3TxMo7p8mUNw/TaC4f5pAcf80geL+aQLF/dMEivunCRT3TxMo7p8mUNw/TaC4f5pAcf80geL+aQLF/dMEivunCRT3TxMo7p8mUNw/TaC4f5pAcf80geL+aQLF/dMEendN5wv1TxPonf/7C/VPEyjunyZQ3D9NoLh/mkBx/zSB4v5pAsX90wSK+6cJFPdPEyjunyZQ3D9NoLh/mkBx/zSB4v5pAsX90wSK+6cJFPdPEyjunyZQ3D9NoLh/mkBx/zSB4v5pAsX90wSK+6cJFPdPEyjunyZQ3D9NoLh/mkBx/zSB4v5pAsX90wSK+6cJFPdPEyjunyZQ3D9NoLh/mkBx/zSB4v5pAsX90wSK+6cJFPdPEyjunyZQ3D9NoLh/mkBx/zSB4v5pAsX90wSK+6cJFPefvOeBS5cuPfDge9OvB31mD93/vvd/AP/a7OG7PuhJE4h/R+zeD3nRBOLfHfvwR+w3gfh3yS49Yr0JxL9b9lHjTSD+HbOPfdx0E4h/5+wTlptA/Ltnpz9ptwk8/yl8uWefNtsE4r8U9hmrTSD+y2GPGm0C8V8Se8xmE4j/slhksgnEf2ksstgE4r88Fhn8Thj/JbII/9oswr82i/Cvzbbxr836+Ndml001gfgvnV221ATiv3x22VATiP8KWN9OE4j/Kti2mSYQ/5WwyEoTiP9qWGSkCcR/RSyy0QTivyoWmWgC8V8Ziyw0gfivjkUGmkD8V8ii6ptA/Gs3gfjXbgLxr90E4l+7CcS/dhOIf+0mEP/Vs238a7M+/rVZdU0g/k2wyppA/NtgVTWB+DfCKmoC8W+FVdME4t8Mq6QJxL8dVkUTiH9DrIImEP+WWPlNIP5NsdKbQPzbYmU3gfg3xkpuAvFvjZXbBOLfHCu1CcS/PVZmE4h/gyzCP00g/oVZhH+aQPwLsz7+tVk5TSD+zbJSmkD822VlNIH4N8xKaALxb5m5bwLP382ZG2bOm0D822aum0D8G2eOm0D8W2dum0D8m2dOm0D822cum0D8e8AcNoH494G5awLx7wVz1gTi3w/mqgnEvycswj9NIP6FWYR/mkD8C7M+/rVZ8U0g/r1ihTeB+PeLFd0E4t8zVnATiH/fWLFNIP69Y4U2gfj3jxXZBOLfQ1ZgE4h/H1lxTSD+vWSFNYH495MV1QTi31NWUBOIf19ZMU0g/r1lhTSB+PeXFdEE4t9jFuGfJhD/wizCP00g/oVZH//abLwmEP/es7GaQPz7z8ZpAvEfABujCcR/CCx/E4j/IFjuJhD/YbC8TSD+A2E5m0D8h8LyNYH4D4blagLxHw7L0wTiPyCWownEf0hs9CYQ/0GxkZtA/IfFRm0C8R8Yi/BPE4h/YRbhnyYQ/8Ksj39tNkIT+FnOLUA2fBP4OOcWIhu6CfzcE5xbiGzoJvDznFuQbNgm8Atf5NyCZMM2gY9zbmGyYZvAJzm3MNmwTeCjnFuYbNgm8Arnlkg3gVc4N+0m8Eucm3YTeJVz024Cv8y5aTeBX/kq56bdBH6Nc9NuAr/+BOem3QR+g3MLkY3QBD7FuQXIRmgC1zc4t/DYKL8TuH8HcG6yvxO4vsG5hcZG+53A9Q3OLZH+ncD1pzk37d8JvHaBc9P+ncBHLnBu2r8TeO1pzk37dwIHewBnGQDL8zuBqTuAs5T8nUA2wXBYvmcHswkGw3I+O5hNMBSW99nBbIKBsNzPDmYTTDR/J5BNMCw2xrOD2QTVnx3MJqj+7GA2QfVnB7MJes/GfHYwm6DvbMxnB7MJ+s7Ge3Ywm6D3bKxnB7MJ+s/GeXYwm2AAbIxnB7MJhsDyPzuYTTAIlvvZwWyCYbC8zw5mEwyE5Xx2MJtgKCzfs4PZBINh+ZpANsFgWM4mkE0wFJa3CWQTDITlbgLZBBPxJpBNUL0JZBNUbwLZBNWbQDZB9SaQTdB7tl20fzZBv1i/cP9sgl6xsZtANkG/2fhNIJug16yAJpBNMBFvAtkE1ZtANkH1JpBNUL0JZBNUbwLZBD1lhTWBbIJ+suKaQDZBL1mBTSCboI+syCaQTdBDVmgTyCaYiDeBbILqTWDmJvgMZ67TBGZugs9y5jpNYOYmeJ0zt8qiEvzXaqk7gDMPvgnM3ASvc+Y2Wb8U/4M7gDOXaAIzN8HrnLlF5qYJzNwEr3PmiUwTmLkJPsuZ6zSBmZvgM5y5ThPIJqjeBLIJqjeBbILqTSCboAfMaRPIJmifuW0C2QTNM8dNIJugdea6CWQTNM6cN4Fsgol4E8gmqN4EsgmqN4FsgupNIJugehPIJmiWbVfln03QButX5p9N0AQrrQlkE7TJymsC2QRNshKbQDbBRLwJZBNUbwLZBNWbQDZB9SaQTVC9CWQTNMZKbwLZBG2x8ptANkFTrIImkE3QEquiCWQTNMQqaQLZBBPxJpBNUL0JZBNUbwLZBNWbQDZB9SaQTdAE27bkn02wfNY35Z9NsHRWaRPIJlg9q7YJZBOsnFXcBLIJqjeBbILqTSCboHoTyCao3gSyCao3gWyCFbLHLDSBbILVsW+aaALZBCtj37LRBLIJVsW+baQJzNwEY3y5Zqe/Y6UJzNwEt/DlmD1UM9MEZm6Cm/hyys59t1ar1U6dNPadcGoT3MSXS/Y94/7X1q5t4csde+68df8nT63H+HLFNu6z779WS90BOCySPfz9mg/+U3cADgtkP/jhjzzxP7gDKju3H9+4cePq80+mX89f9Zk999TZn/z0Zc++4iYwcxOMK/3vZtPCGZTGKm8C7W2Cm0r+DTSB5jbBTSH/JppAa5vgRR3/RppAY5vglox/M02grU0wVvFvqAk0tQnGIv5NNYGWNsFYw7+xJtDQJhhr+LfWBNrZBGMN/+aaQDObYKzh314TaGUTjDX8G2wCjWyCsYZ/i02gjU0w1vBv/DvhCjfBGP+23mvZm2CMf2PvteRNMMa/tfda7iYY49/cey11E9zCv/YmeFHMv70msOJNkCZQfBOkCRTfBGkCxTdBmkDxTZAmUHwTpAkU3wRpAsU3QZpA8U2QJlB8E6QJtP3+nW+CNIHG37/rTZAm0Pr7d7wJ0gSaf/9uN0GaQPvv3+kmSBPowft3uQnSBPrw/h1ugjSBXrx/d5sgTaAf79/ZJkgT6Mn7d7UJ0gSKb4I0geKbIE2g+CZIEyi+CdIEim+CNIHimyBNoPgmSBMovgnSBHq3Cd6kCczBPG0CMzfBmzSBozNfm8DMTfAmTeDIzNsmMHMTvEkTWJNpAjM3wRdoAnWawMxN8EWaQMXvhFOb4Is0gcr+19auvUATqOz/5KnBHkATKOk/tQjRBEr6L2gTpAn0+JqK2ARpAsU3QZpA8U2QJlB8E6QJFN8EaQLFN0GaQPFNkCZQfBOkCRTfBGkCxTdBmkDxTZAmMIzrzL0J0gQGcp15N0GawFCuM+cmSBMYzHXm2wRpAsO5zlybIE1gQNeZZxOkCQzpOnNsgjSBQV3n6JsgTWBY1znyJkgTGNh1jroJ0gSKb4I0geKbIE2g+CZIEyi+CdIEim+CNIHimyBNoPgmSBMovgnSBIpvgjSB4psgTWC41z7UJkgTGPC1D7MJ0gSGfO1DbII0gUFf+9GbIE1g2Nd+5CZIExj4tR+1CdIEhn7tR2yCG/gP/dpfeRP8Gf6Dv/ZX3AR/jn/tTfAXNIHSm+Avf0UTKL0J/nqNJlB5E/zNb9doApU3wd8pnYFQEzjsJnhDyb9UE5i5Cf7+sP8//FHIv1gTmMnOnkv7/9Of/yLkX64JzGR33HNm4P+vf5P6DKTXBGazv//jn//697kr//nv/6T+/SfZBMLSTLEJhKWYZBMIu800m0BYTbwJhPGdMAz/sJf1v7rS6/VWVmFC7MA+vNztdpdPwITYge+HljqdztIiTIilX/ML7XZ7YR4mxNL/Bpyda7Vacwc3QVjYLN0ETs80m82Zg5sgLHCWagKPTzUajamDmyAseHb7Bpis1+uThz4UwMJntz4DHJuYmDi0CcMk2P8BpwYz8bnreFcAAAAASUVORK5CYII=\">','inbox','yes','no',NULL),
 (92,'siva','sivakumark@karyatech.com','','','Wed Nov 02 20:15:58 IST 2016','Testing Email','Hi Kabir,<div><br></div><div>Good Work and keep it up.</div><div><br></div><div><span style=\"font-weight: bold; font-family: garamond, serif;\"><br></span></div><div><span style=\"font-weight: bold; font-family: garamond, serif;\">Thanks,</span></div><div><span style=\"font-weight: bold; font-family: garamond, serif;\">AK.Sivakumar</span></div>','inbox','yes','yes',NULL);
/*!40000 ALTER TABLE `email001mb` ENABLE KEYS */;


--
-- Definition of table `emailattachment001mb`
--

DROP TABLE IF EXISTS `emailattachment001mb`;
CREATE TABLE `emailattachment001mb` (
  `emailattachmentid` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(100) NOT NULL,
  `filesize` varchar(45) NOT NULL,
  `contenttype` varchar(255) NOT NULL,
  `content` longblob,
  `emailid` int(11) NOT NULL,
  PRIMARY KEY (`emailattachmentid`),
  KEY `emailattachment001mb_ibfk_1` (`emailid`),
  CONSTRAINT `emailattachment001mb_ibfk_1` FOREIGN KEY (`emailid`) REFERENCES `email001mb` (`emailId`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emailattachment001mb`
--

/*!40000 ALTER TABLE `emailattachment001mb` DISABLE KEYS */;
INSERT INTO `emailattachment001mb` (`emailattachmentid`,`filename`,`filesize`,`contenttype`,`content`,`emailid`) VALUES 
 (36,'testRedBus.html','28298 kb','text/html',0x3C21444F43545950452068746D6C3E0D0A3C68746D6C3E0D0A3C212D2D3C215B656E6469665D2D2D3E0D0A3C686561642069643D224865616431223E0D0A202020203C212D2D203C6C696E6B2072656C3D227365617263682220747970653D226170706C69636174696F6E2F6F70656E7365617263686465736372697074696F6E2B786D6C22207469746C653D227265644275732220687265663D226F70656E7365617263682E786D6C22202F3E202D2D3E0D0A202020203C212D2D5B69662049455D3E203C6D65746120687474702D65717569763D22582D55412D436F6D70617469626C652220636F6E74656E743D2249453D65646765223E3C73637269707420747970653D22746578742F6A617661736372697074223E77696E646F772E4E5245554D7C7C284E5245554D3D7B7D293B4E5245554D2E696E666F203D207B22626561636F6E223A2262616D2E6E722D646174612E6E6574222C226572726F72426561636F6E223A2262616D2E6E722D646174612E6E6574222C226C6963656E73654B6579223A2236396139323961303733222C226170706C69636174696F6E4944223A223334313832383734222C227472616E73616374696F6E4E616D65223A225A564D485A784658576B5A5155425A5A5756775A4D45454B475564515545454257413D3D222C22717565756554696D65223A302C226170706C69636174696F6E54696D65223A382C22747447756964223A2245323330353436464435343836434245222C226167656E74223A22227D3C2F7363726970743E3C73637269707420747970653D22746578742F6A617661736372697074223E77696E646F772E4E5245554D7C7C284E5245554D3D7B7D292C5F5F6E725F726571756972653D66756E6374696F6E28742C652C6E297B66756E6374696F6E2072286E297B69662821655B6E5D297B766172206F3D655B6E5D3D7B6578706F7274733A7B7D7D3B745B6E5D5B305D2E63616C6C286F2E6578706F7274732C66756E6374696F6E2865297B766172206F3D745B6E5D5B315D5B655D3B72657475726E2072286F7C7C65297D2C6F2C6F2E6578706F727473297D72657475726E20655B6E5D2E6578706F7274737D6966282266756E6374696F6E223D3D747970656F66205F5F6E725F726571756972652972657475726E205F5F6E725F726571756972653B666F7228766172206F3D303B6F3C6E2E6C656E6774683B6F2B2B2972286E5B6F5D293B72657475726E20727D287B313A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228297B7D66756E6374696F6E206F28742C652C6E297B72657475726E2066756E6374696F6E28297B72657475726E206928742C5B286E65772044617465292E67657454696D6528295D2E636F6E636174287528617267756D656E747329292C653F6E756C6C3A746869732C6E292C653F766F696420303A746869737D7D76617220693D74282268616E646C6522292C613D742832292C753D742833292C633D742822656522292E676574282274726163657222292C663D4E5245554D3B22756E646566696E6564223D3D747970656F662077696E646F772E6E657772656C69632626286E657772656C69633D66293B76617220733D5B2273657450616765566965774E616D65222C22736574437573746F6D417474726962757465222C227365744572726F7248616E646C6572222C2266696E6973686564222C22616464546F5472616365222C22696E6C696E65486974225D2C703D226170692D222C6C3D702B2269786E2D223B6128732C66756E6374696F6E28742C65297B665B655D3D6F28702B652C21302C2261706922297D292C662E61646450616765416374696F6E3D6F28702B2261646450616765416374696F6E222C2130292C652E6578706F7274733D6E657772656C69632C662E696E746572616374696F6E3D66756E6374696F6E28297B72657475726E286E65772072292E67657428297D3B76617220643D722E70726F746F747970653D7B6372656174655472616365723A66756E6374696F6E28742C65297B766172206E3D7B7D2C723D746869732C6F3D2266756E6374696F6E223D3D747970656F6620653B72657475726E2069286C2B22747261636572222C5B446174652E6E6F7728292C742C6E5D2C72292C66756E6374696F6E28297B696628632E656D697428286F3F22223A226E6F2D22292B22666E2D7374617274222C5B446174652E6E6F7728292C722C6F5D2C6E292C6F297472797B72657475726E20652E6170706C7928746869732C617267756D656E7473297D66696E616C6C797B632E656D69742822666E2D656E64222C5B446174652E6E6F7728295D2C6E297D7D7D7D3B6128227365744E616D652C7365744174747269627574652C736176652C69676E6F72652C6F6E456E642C676574436F6E746578742C656E642C676574222E73706C697428222C22292C66756E6374696F6E28742C65297B645B655D3D6F286C2B65297D292C6E657772656C69632E6E6F746963654572726F723D66756E6374696F6E2874297B22737472696E67223D3D747970656F662074262628743D6E6577204572726F72287429292C692822657272222C5B742C286E65772044617465292E67657454696D6528295D297D7D2C7B7D5D2C323A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228742C65297B766172206E3D5B5D2C723D22222C693D303B666F72287220696E2074296F2E63616C6C28742C72292626286E5B695D3D6528722C745B725D292C692B3D31293B72657475726E206E7D766172206F3D4F626A6563742E70726F746F747970652E6861734F776E50726F70657274793B652E6578706F7274733D727D2C7B7D5D2C333A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228742C652C6E297B657C7C28653D30292C22756E646566696E6564223D3D747970656F66206E2626286E3D743F742E6C656E6774683A30293B666F722876617220723D2D312C6F3D6E2D657C7C302C693D4172726179286F3C303F303A6F293B2B2B723C6F3B29695B725D3D745B652B725D3B72657475726E20697D652E6578706F7274733D727D2C7B7D5D2C65653A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228297B7D66756E6374696F6E206F2874297B66756E6374696F6E20652874297B72657475726E207426267420696E7374616E63656F6620723F743A743F7528742C612C69293A6928297D66756E6374696F6E206E286E2C722C6F297B74262674286E2C722C6F293B666F722876617220693D65286F292C613D6C286E292C753D612E6C656E6774682C633D303B633C753B632B2B29615B635D2E6170706C7928692C72293B76617220733D665B6D5B6E5D5D3B72657475726E20732626732E70757368285B772C6E2C722C695D292C697D66756E6374696F6E207028742C65297B675B745D3D6C2874292E636F6E6361742865297D66756E6374696F6E206C2874297B72657475726E20675B745D7C7C5B5D7D66756E6374696F6E20642874297B72657475726E20735B745D3D735B745D7C7C6F286E297D66756E6374696F6E207628742C65297B6328742C66756E6374696F6E28742C6E297B653D657C7C2266656174757265222C6D5B6E5D3D652C6520696E20667C7C28665B655D3D5B5D297D297D76617220673D7B7D2C6D3D7B7D2C773D7B6F6E3A702C656D69743A6E2C6765743A642C6C697374656E6572733A6C2C636F6E746578743A652C6275666665723A767D3B72657475726E20777D66756E6374696F6E206928297B72657475726E206E657720727D76617220613D226E7240636F6E74657874222C753D742822676F7322292C633D742832292C663D7B7D2C733D7B7D2C703D652E6578706F7274733D6F28293B702E6261636B6C6F673D667D2C7B7D5D2C676F733A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228742C652C6E297B6966286F2E63616C6C28742C65292972657475726E20745B655D3B76617220723D6E28293B6966284F626A6563742E646566696E6550726F706572747926264F626A6563742E6B657973297472797B72657475726E204F626A6563742E646566696E6550726F706572747928742C652C7B76616C75653A722C7772697461626C653A21302C656E756D657261626C653A21317D292C727D63617463682869297B7D72657475726E20745B655D3D722C727D766172206F3D4F626A6563742E70726F746F747970652E6861734F776E50726F70657274793B652E6578706F7274733D727D2C7B7D5D2C68616E646C653A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228742C652C6E2C72297B6F2E627566666572285B745D2C72292C6F2E656D697428742C652C6E297D766172206F3D742822656522292E676574282268616E646C6522293B652E6578706F7274733D722C722E65653D6F7D2C7B7D5D2C69643A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E20722874297B76617220653D747970656F6620743B72657475726E21747C7C226F626A65637422213D3D6526262266756E6374696F6E22213D3D653F2D313A743D3D3D77696E646F773F303A6128742C692C66756E6374696F6E28297B72657475726E206F2B2B7D297D766172206F3D312C693D226E72406964222C613D742822676F7322293B652E6578706F7274733D727D2C7B7D5D2C6C6F616465723A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228297B69662821682B2B297B76617220743D792E696E666F3D4E5245554D2E696E666F2C653D732E676574456C656D656E747342795461674E616D65282273637269707422295B305D3B696628742626742E6C6963656E73654B65792626742E6170706C69636174696F6E4944262665297B63286D2C66756E6374696F6E28652C6E297B745B655D7C7C28745B655D3D6E297D293B766172206E3D226874747073223D3D3D672E73706C697428223A22295B305D7C7C742E73736C466F72487474703B792E70726F746F3D6E3F2268747470733A2F2F223A22687474703A2F2F222C7528226D61726B222C5B226F6E6C6F6164222C6128295D2C6E756C6C2C2261706922293B76617220723D732E637265617465456C656D656E74282273637269707422293B722E7372633D792E70726F746F2B742E6167656E742C652E706172656E744E6F64652E696E736572744265666F726528722C65297D7D7D66756E6374696F6E206F28297B22636F6D706C657465223D3D3D732E7265616479537461746526266928297D66756E6374696F6E206928297B7528226D61726B222C5B22646F6D436F6E74656E74222C6128295D2C6E756C6C2C2261706922297D66756E6374696F6E206128297B72657475726E286E65772044617465292E67657454696D6528297D76617220753D74282268616E646C6522292C633D742832292C663D77696E646F772C733D662E646F63756D656E742C703D226164644576656E744C697374656E6572222C6C3D226174746163684576656E74222C643D662E584D4C48747470526571756573742C763D642626642E70726F746F747970653B4E5245554D2E6F3D7B53543A73657454696D656F75742C43543A636C65617254696D656F75742C5848523A642C5245513A662E526571756573742C45563A662E4576656E742C50523A662E50726F6D6973652C4D4F3A662E4D75746174696F6E4F627365727665727D2C742831293B76617220673D22222B6C6F636174696F6E2C6D3D7B626561636F6E3A2262616D2E6E722D646174612E6E6574222C6572726F72426561636F6E3A2262616D2E6E722D646174612E6E6574222C6167656E743A226A732D6167656E742E6E657772656C69632E636F6D2F6E722D3937342E6D696E2E6A73227D2C773D642626762626765B705D2626212F4372694F532F2E74657374286E6176696761746F722E757365724167656E74292C793D652E6578706F7274733D7B6F66667365743A6128292C6F726967696E3A672C66656174757265733A7B7D2C786872577261707061626C653A777D3B735B705D3F28735B705D2822444F4D436F6E74656E744C6F61646564222C692C2131292C665B705D28226C6F6164222C722C213129293A28735B6C5D28226F6E726561647973746174656368616E6765222C6F292C665B6C5D28226F6E6C6F6164222C7229292C7528226D61726B222C5B22666972737462797465222C6128295D2C6E756C6C2C2261706922293B76617220683D307D2C7B7D5D7D2C7B7D2C5B226C6F61646572225D293B3C2F7363726970743E3C73637269707420747970653D22746578742F6A617661736372697074223E77696E646F772E4E5245554D7C7C284E5245554D3D7B7D293B4E5245554D2E696E666F203D207B22626561636F6E223A2262616D2E6E722D646174612E6E6574222C226572726F72426561636F6E223A2262616D2E6E722D646174612E6E6574222C226C6963656E73654B6579223A2236396139323961303733222C226170706C69636174696F6E4944223A223334313832383734222C227472616E73616374696F6E4E616D65223A225A564D485A784658576B5A5155425A5A5756775A4B475567475764515545454257485664574246424446705955454D634B3135535630343D222C22717565756554696D65223A302C226170706C69636174696F6E54696D65223A342C22747447756964223A2241413839423737353834313636433532222C226167656E74223A22227D3C2F7363726970743E3C73637269707420747970653D22746578742F6A617661736372697074223E77696E646F772E4E5245554D7C7C284E5245554D3D7B7D292C5F5F6E725F726571756972653D66756E6374696F6E28742C652C6E297B66756E6374696F6E2072286E297B69662821655B6E5D297B766172206F3D655B6E5D3D7B6578706F7274733A7B7D7D3B745B6E5D5B305D2E63616C6C286F2E6578706F7274732C66756E6374696F6E2865297B766172206F3D745B6E5D5B315D5B655D3B72657475726E2072286F7C7C65297D2C6F2C6F2E6578706F727473297D72657475726E20655B6E5D2E6578706F7274737D6966282266756E6374696F6E223D3D747970656F66205F5F6E725F726571756972652972657475726E205F5F6E725F726571756972653B666F7228766172206F3D303B6F3C6E2E6C656E6774683B6F2B2B2972286E5B6F5D293B72657475726E20727D287B313A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228297B7D66756E6374696F6E206F28742C652C6E297B72657475726E2066756E6374696F6E28297B72657475726E206928742C5B286E65772044617465292E67657454696D6528295D2E636F6E636174287528617267756D656E747329292C653F6E756C6C3A746869732C6E292C653F766F696420303A746869737D7D76617220693D74282268616E646C6522292C613D742832292C753D742833292C633D742822656522292E676574282274726163657222292C663D4E5245554D3B22756E646566696E6564223D3D747970656F662077696E646F772E6E657772656C69632626286E657772656C69633D66293B76617220733D5B2273657450616765566965774E616D65222C22736574437573746F6D417474726962757465222C227365744572726F7248616E646C6572222C2266696E6973686564222C22616464546F5472616365222C22696E6C696E65486974225D2C703D226170692D222C6C3D702B2269786E2D223B6128732C66756E6374696F6E28742C65297B665B655D3D6F28702B652C21302C2261706922297D292C662E61646450616765416374696F6E3D6F28702B2261646450616765416374696F6E222C2130292C652E6578706F7274733D6E657772656C69632C662E696E746572616374696F6E3D66756E6374696F6E28297B72657475726E286E65772072292E67657428297D3B76617220643D722E70726F746F747970653D7B6372656174655472616365723A66756E6374696F6E28742C65297B766172206E3D7B7D2C723D746869732C6F3D2266756E6374696F6E223D3D747970656F6620653B72657475726E2069286C2B22747261636572222C5B446174652E6E6F7728292C742C6E5D2C72292C66756E6374696F6E28297B696628632E656D697428286F3F22223A226E6F2D22292B22666E2D7374617274222C5B446174652E6E6F7728292C722C6F5D2C6E292C6F297472797B72657475726E20652E6170706C7928746869732C617267756D656E7473297D66696E616C6C797B632E656D69742822666E2D656E64222C5B446174652E6E6F7728295D2C6E297D7D7D7D3B6128227365744E616D652C7365744174747269627574652C736176652C69676E6F72652C6F6E456E642C676574436F6E746578742C656E642C676574222E73706C697428222C22292C66756E6374696F6E28742C65297B645B655D3D6F286C2B65297D292C6E657772656C69632E6E6F746963654572726F723D66756E6374696F6E2874297B22737472696E67223D3D747970656F662074262628743D6E6577204572726F72287429292C692822657272222C5B742C286E65772044617465292E67657454696D6528295D297D7D2C7B7D5D2C323A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228742C65297B766172206E3D5B5D2C723D22222C693D303B666F72287220696E2074296F2E63616C6C28742C72292626286E5B695D3D6528722C745B725D292C692B3D31293B72657475726E206E7D766172206F3D4F626A6563742E70726F746F747970652E6861734F776E50726F70657274793B652E6578706F7274733D727D2C7B7D5D2C333A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228742C652C6E297B657C7C28653D30292C22756E646566696E6564223D3D747970656F66206E2626286E3D743F742E6C656E6774683A30293B666F722876617220723D2D312C6F3D6E2D657C7C302C693D4172726179286F3C303F303A6F293B2B2B723C6F3B29695B725D3D745B652B725D3B72657475726E20697D652E6578706F7274733D727D2C7B7D5D2C65653A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228297B7D66756E6374696F6E206F2874297B66756E6374696F6E20652874297B72657475726E207426267420696E7374616E63656F6620723F743A743F7528742C612C69293A6928297D66756E6374696F6E206E286E2C722C6F297B74262674286E2C722C6F293B666F722876617220693D65286F292C613D6C286E292C753D612E6C656E6774682C633D303B633C753B632B2B29615B635D2E6170706C7928692C72293B76617220733D665B6D5B6E5D5D3B72657475726E20732626732E70757368285B772C6E2C722C695D292C697D66756E6374696F6E207028742C65297B675B745D3D6C2874292E636F6E6361742865297D66756E6374696F6E206C2874297B72657475726E20675B745D7C7C5B5D7D66756E6374696F6E20642874297B72657475726E20735B745D3D735B745D7C7C6F286E297D66756E6374696F6E207628742C65297B6328742C66756E6374696F6E28742C6E297B653D657C7C2266656174757265222C6D5B6E5D3D652C6520696E20667C7C28665B655D3D5B5D297D297D76617220673D7B7D2C6D3D7B7D2C773D7B6F6E3A702C656D69743A6E2C6765743A642C6C697374656E6572733A6C2C636F6E746578743A652C6275666665723A767D3B72657475726E20777D66756E6374696F6E206928297B72657475726E206E657720727D76617220613D226E7240636F6E74657874222C753D742822676F7322292C633D742832292C663D7B7D2C733D7B7D2C703D652E6578706F7274733D6F28293B702E6261636B6C6F673D667D2C7B7D5D2C676F733A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228742C652C6E297B6966286F2E63616C6C28742C65292972657475726E20745B655D3B76617220723D6E28293B6966284F626A6563742E646566696E6550726F706572747926264F626A6563742E6B657973297472797B72657475726E204F626A6563742E646566696E6550726F706572747928742C652C7B76616C75653A722C7772697461626C653A21302C656E756D657261626C653A21317D292C727D63617463682869297B7D72657475726E20745B655D3D722C727D766172206F3D4F626A6563742E70726F746F747970652E6861734F776E50726F70657274793B652E6578706F7274733D727D2C7B7D5D2C68616E646C653A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228742C652C6E2C72297B6F2E627566666572285B745D2C72292C6F2E656D697428742C652C6E297D766172206F3D742822656522292E676574282268616E646C6522293B652E6578706F7274733D722C722E65653D6F7D2C7B7D5D2C69643A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E20722874297B76617220653D747970656F6620743B72657475726E21747C7C226F626A65637422213D3D6526262266756E6374696F6E22213D3D653F2D313A743D3D3D77696E646F773F303A6128742C692C66756E6374696F6E28297B72657475726E206F2B2B7D297D766172206F3D312C693D226E72406964222C613D742822676F7322293B652E6578706F7274733D727D2C7B7D5D2C6C6F616465723A5B66756E6374696F6E28742C652C6E297B66756E6374696F6E207228297B69662821682B2B297B76617220743D792E696E666F3D4E5245554D2E696E666F2C653D732E676574456C656D656E747342795461674E616D65282273637269707422295B305D3B696628742626742E6C6963656E73654B65792626742E6170706C69636174696F6E4944262665297B63286D2C66756E6374696F6E28652C6E297B745B655D7C7C28745B655D3D6E297D293B766172206E3D226874747073223D3D3D672E73706C697428223A22295B305D7C7C742E73736C466F72487474703B792E70726F746F3D6E3F2268747470733A2F2F223A22687474703A2F2F222C7528226D61726B222C5B226F6E6C6F6164222C6128295D2C6E756C6C2C2261706922293B76617220723D732E637265617465456C656D656E74282273637269707422293B722E7372633D792E70726F746F2B742E6167656E742C652E706172656E744E6F64652E696E736572744265666F726528722C65297D7D7D66756E6374696F6E206F28297B22636F6D706C657465223D3D3D732E7265616479537461746526266928297D66756E6374696F6E206928297B7528226D61726B222C5B22646F6D436F6E74656E74222C6128295D2C6E756C6C2C2261706922297D66756E6374696F6E206128297B72657475726E286E65772044617465292E67657454696D6528297D76617220753D74282268616E646C6522292C633D742832292C663D77696E646F772C733D662E646F63756D656E742C703D226164644576656E744C697374656E6572222C6C3D226174746163684576656E74222C643D662E584D4C48747470526571756573742C763D642626642E70726F746F747970653B4E5245554D2E6F3D7B53543A73657454696D656F75742C43543A636C65617254696D656F75742C5848523A642C5245513A662E526571756573742C45563A662E4576656E742C50523A662E50726F6D6973652C4D4F3A662E4D75746174696F6E4F627365727665727D2C742831293B76617220673D22222B6C6F636174696F6E2C6D3D7B626561636F6E3A2262616D2E6E722D646174612E6E6574222C6572726F72426561636F6E3A2262616D2E6E722D646174612E6E6574222C6167656E743A226A732D6167656E742E6E657772656C69632E636F6D2F6E722D3937342E6D696E2E6A73227D2C773D642626762626765B705D2626212F4372694F532F2E74657374286E6176696761746F722E757365724167656E74292C793D652E6578706F7274733D7B6F66667365743A6128292C6F726967696E3A672C66656174757265733A7B7D2C786872577261707061626C653A777D3B735B705D3F28735B705D2822444F4D436F6E74656E744C6F61646564222C692C2131292C665B705D28226C6F6164222C722C213129293A28735B6C5D28226F6E726561647973746174656368616E6765222C6F292C665B6C5D28226F6E6C6F6164222C7229292C7528226D61726B222C5B22666972737462797465222C6128295D2C6E756C6C2C2261706922293B76617220683D307D2C7B7D5D7D2C7B7D2C5B226C6F61646572225D293B3C2F7363726970743E203C215B656E6469665D2D2D3E0D0A202020203C212D2D5B6966206C742049452031305D3E0D0A2020202020202020202020203C64697620636C6173733D224D42223E3C7020636C6173733D2262726F7773656861707079223E596F7520617265207573696E6720616E203C7374726F6E673E6F757464617465643C2F7374726F6E673E2062726F777365722E20506C65617365203C6120687265663D22687474703A2F2F62726F77736568617070792E636F6D2F223E7570677261646520796F75722062726F777365723C2F613E20746F20696D70726F766520796F757220657870657269656E63652E3C2F703E3C2F6469763E0D0A20202020202020203C215B656E6469665D2D2D3E0D0A0D0A202020203C6D657461206E616D653D2276696577706F72742220636F6E74656E743D2277696474683D6465766963652D77696474682C20696E697469616C2D7363616C653D312E30223E0D0A202020203C7469746C653E4F6E6C696E6520427573207469636B65747320426F6F6B696E672C20414320566F6C766F20426F6F6B696E672C2032353020494E52204342204F6E20427573205265736572766174696F6E3C2F7469746C653E0D0A202020203C212D2D20444E53207072656665746368202D2D3E0D0A202020203C6C696E6B2072656C3D22646E732D70726566657463682220687265663D222F2F73312E726462757A2E636F6D22202F3E0D0A202020203C6C696E6B2072656C3D22646E732D70726566657463682220687265663D222F2F73322E726462757A2E636F6D22202F3E0D0A202020203C6C696E6B2072656C3D22646E732D70726566657463682220687265663D222F2F73332E726462757A2E636F6D22202F3E0D0A0D0A202020203C6C696E6B20687265663D222E2E2F2E2E2F2E2E2F66617669636F6E2E69636F222072656C3D2273686F72746375742069636F6E22202F3E0D0A202020203C212D2D5B6966206C7420494520395D3E0D0A202020203C736372697074207372633D2268747470733A2F2F68746D6C35736869762E676F6F676C65636F64652E636F6D2F73766E2F7472756E6B2F68746D6C352E6A73223E3C2F7363726970743E0D0A202020203C215B656E6469665D2D2D3E0D0A202020203C6D657461206E616D653D224B6579776F7264732220636F6E74656E743D226F6E6C696E6520627573207469636B657420626F6F6B696E672C2062757320626F6F6B696E672C20766F6C766F2061632062757320626F6F6B696E672C20627573207469636B657420626F6F6B696E672C20627573207469636B65747322202F3E0D0A202020203C6D657461206E616D653D226465736372697074696F6E2220636F6E74656E743D227265644275732E696E20576F726C649273204C6172676574204F6E6C696E6520427573205469636B65747320506C6174666F726D206F66666572732062696720696E76656E746F7279206F66206F70657261746F72732C20726F757465732026616D703B2052544373207769746820545241434B4D594255532C5245535453544F5053202066656174757265732E2055736520636F75706F6E20636F64652C2067657420646973636F756E747320616E6420626F6F6B20796F757220627573207469636B65742E22202F3E0D0A202020203C6D6574612069643D22706167655F6E616D652220636F6E74656E743D2253454152434822202F3E0D0A202020203C6C696E6B2072656C3D2263616E6F6E6963616C2220687265663D2268747470733A2F2F7777772E7265646275732E696E2F736561726368223E0D0A0D0A0D0A0D0A202020200D0A202020200D0A202020200D0A0D0A202020203C6C696E6B20687265663D222F2F73322E726462757A2E636F6D2F7765622F7374796C657368656574732F7365617263682E35626265366637316234613939353732656330382E62756E646C652E637373222072656C3D227374796C65736865657422202F3E0D0A0D0A202020203C7363726970743E0D0A20202020202020207661722070616765203D2027534541524348273B0D0A202020203C2F7363726970743E0D0A3C2F686561643E0D0A3C626F64793E0D0A202020203C73656374696F6E2069643D2272685F6D61696E223E0D0A20202020202020203C6469762069643D22737469636B795F7068616E746F6D2220636C6173733D2268696465223E0D0A20202020202020203C2F6469763E0D0A0D0A0D0A200D0A0D0A20202020202020203C6865616465722069643D2272685F6865616465722220636C6173733D22686F6D652D6F6E6C792D68656164657220666978657231223E0D0A0D0A2020202020202020202020203C64697620636C6173733D226D61696E2D6865616465722D726F77223E0D0A202020202020202020202020202020203C64697620636C6173733D226D61696E2D68656164657220636C656172666978223E0D0A202020203C6120687265663D222F2220636C6173733D227265646275732D6C6F676F223E7265646275733C2F613E0D0A202020203C64697620636C6173733D22666C20636C656172666978222069643D22706167655F6D61696E5F686561646572223E0D0A20202020202020203C6E617620636C6173733D2270726F647563742D6E617620666C223E0D0A2020202020202020202020203C756C3E0D0A202020202020202020202020202020202020202020202020202020203C6C693E3C6120687265663D222F22207469746C653D72656442757320636C6173733D73656C656374656442757320736974652D6C696E6B733E425553205449434B4554533C2F613E3C2F6C693E0D0A202020202020202020202020202020202020202020202020202020203C6C693E3C6120687265663D2268747470733A2F2F7777772E7265646275732E696E2F686F74656C732F22207469746C653D72656442757320486F74656C7320636C6173733D736974652D6C696E6B733E484F54454C533C2F613E3C2F6C693E0D0A202020202020202020202020202020202020202020202020202020203C6C693E3C6120687265663D2268747470733A2F2F7777772E7265646275732E696E2F627573686972653F75746D5F736F757263653D7765627369746526616D703B75746D5F6D656469756D3D726566657272616C26616D703B75746D5F63616D706169676E3D486F6D65706167655F627573686972655F62616E6E657222207469746C653D72656442757320427573204869726520636C6173733D736974652D6C696E6B733E42555320484952453C2F613E3C2F6C693E0D0A0D0A2020202020202020202020203C2F756C3E0D0A20202020202020203C2F6E61763E0D0A0D0A202020203C2F6469763E0D0A202020203C64697620636C6173733D22636F726E65722D77726170706572206672223E0D0A20202020202020202020202020202020202020203C64697620636C6173733D22667220636F6E6669672D6469762220746162696E6465783D2230222069643D2273656C6563745F626F785F7369676E223E0D0A2020202020202020202020202020202020202020202020203C6469762069643D227369676E696E5F6464223E0D0A202020202020202020202020202020202020202020202020202020203C64697620636C6173733D226672207369676E696E2D626C6F636B222069643D227369676E696E2D626C6F636B223E0D0A20202020202020202020202020202020202020202020202020202020202020203C6920636C6173733D2269636F6E2D70726F66696C652D6E65772D756E7369676E6564223E3C2F693E3C64697620636C6173733D2269636F6E2D646F776E2069636F6E2069636820646962223E0D0A2020202020202020202020202020202020202020202020202020202020202020202020203C64697620636C6173733D226869642D636F6E6669672D7369676E2068696465222069643D226863223E0D0A202020202020202020202020202020202020202020202020202020202020202020202020202020203C64697620636C6173733D27746F706172726F77686561642D7369676E273E3C2F6469763E0D0A202020202020202020202020202020202020202020202020202020202020202020202020202020203C756C20636C6173733D22636F6E6669672D6C697374223E0D0A0D0A2020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020203C6C692069643D227369676E496E4C696E6B2220636C6173733D22636F6E6669672D6F7074696F6E73223E5369676E20496E2F5369676E2055703C2F6C693E0D0A0D0A0D0A202020202020202020202020202020202020202020202020202020202020202020202020202020203C2F756C3E0D0A2020202020202020202020202020202020202020202020202020202020202020202020203C2F6469763E0D0A20202020202020202020202020202020202020202020202020202020202020203C2F6469763E0D0A202020202020202020202020202020202020202020202020202020203C2F6469763E0D0A2020202020202020202020202020202020202020202020203C2F6469763E0D0A20202020202020202020202020202020202020203C2F6469763E0D0A0D0A0D0A20202020202020203C64697620636C6173733D22636F6E6669672D77726170706572206672223E0D0A0D0A0D0A20202020202020202020202020202020202020203C6469762069643D22636861742D776974682D75732220636C6173733D22667220736974652D6C696E6B73223E3C7370616E3E3C2F7370616E3E577269746520546F2055733C2F6469763E0D0A0D0A0D0A20202020202020202020202020202020202020203C6469762069643D2263616C6C2D75732D61742220636C6173733D22667220736974652D6C696E6B73223E3C7370616E3E3C2F7370616E3E43616C6C2055732041743C2F6469763E0D0A20202020202020202020202020202020202020203C6469762069643D22636F6E746163744C6973742220636C6173733D2268696465223E0D0A2020202020202020202020202020202020202020202020203C64697620636C6173733D22746F702D68656164696E67223E3C68323E484F572043414E2057452048454C5020594F553F3C2F68323E3C2F6469763E0D0A2020202020202020202020202020202020202020202020203C64697620636C6173733D22636F6E746163742D636F6E7461696E657220636C656172666978223E0D0A2020202020202020202020202020202020202020202020203C2F6469763E0D0A20202020202020202020202020202020202020203C2F6469763E0D0A0D0A20202020202020202020202020202020202020203C6469762069643D2263616E63656C6C6174696F6E2220636C6173733D22667220736974652D6C696E6B73223E3C6120687265663D222F43616E63656C6C6174696F6E223E43616E63656C205469636B65743C2F613E3C2F6469763E0D0A0D0A20202020202020202020202020202020202020203C64697620636C6173733D226672207072696E742D736D73207072696E742D736D732D636F6E7420736974652D6C696E6B73223E3C612069643D222220636C6173733D22646962207072696E742D736D732220687265663D222F486F6D652F5072696E745469636B6574223E5072696E742F534D53205469636B65743C2F613E3C2F6469763E0D0A0D0A0D0A20202020202020203C2F6469763E0D0A202020203C2F6469763E0D0A3C2F6469763E0D0A0D0A2020202020202020202020203C2F6469763E0D0A20202020202020203C2F6865616465723E0D0A0D0A0D0A20202020202020203C6469762069643D226D4257726170706572223E0D0A2020202020202020202020200D0A0D0A0D0A0D0A0D0A3C6469762069643D227365617263685F77726170706572223E3C2F6469763E0D0A3C64697620636C6173733D2268696465222069643D22706167655F6F7665726C6179223E3C2F6469763E0D0A3C64697620636C6173733D2268696465222069643D226D6F646966795F6F7665726C6179223E3C2F6469763E0D0A0D0A0D0A0D0A20202020202020203C2F6469763E0D0A20202020202020203C666F6F7465722069643D2272685F666F6F746572223E0D0A2020202020202020202020203C64697620636C6173733D22666F6F7465722D726F77223E0D0A202020203C64697620636C6173733D22636C6561726669782070726F6D6F74696F6E20206D61696E2D626F6479207265737431223E0D0A20202020202020203C64697620636C6173733D22772D31303020705220666C20666F6F7465722D6C696E6B73223E0D0A2020202020202020202020203C64697620636C6173733D226672207269676874732D636F6E74223E0D0A202020202020202020202020202020203C64697620636C6173733D22696D672D636F6E74223E0D0A20202020202020202020202020202020202020203C696D67207372633D2268747470733A2F2F73332E726462757A2E636F6D2F7765622F696D616765732F686F6D652F7367702F725F6C6F676F2E706E6722202F3E0D0A202020202020202020202020202020203C2F6469763E0D0A202020202020202020202020202020203C6469763E0D0A20202020202020202020202020202020202020207265644275732069732074686520776F726C64262333393B73206C617267657374206F6E6C696E6520627573207469636B657420626F6F6B696E6720736572766963652074727573746564206279206F7665722038206D696C6C696F6E20686170707920637573746F6D65727320676C6F62616C6C792E20726564427573206F666665727320627573207469636B657420626F6F6B696E67207468726F7567682069747320776562736974652C694F5320616E6420416E64726F6964206D6F62696C65206170707320666F7220616C6C206D616A6F7220726F757465732E0D0A202020202020202020202020202020203C2F6469763E0D0A20202020202020202020202020202020202020203C6469762069643D22736F6369616C2D6D65646961223E0D0A2020202020202020202020202020202020202020202020200D0A2020202020202020202020202020202020202020202020203C696D67207372633D222F2F73312E726462757A2E636F6D2F7765622F696D616765732F686F6D652F46616365626F6F6B2E706E672220636C6173733D226C696E6B2D626C6F636B732220646174612D6C696E6B3D2268747470733A2F2F7777772E66616365626F6F6B2E636F6D2F7265646275732E696E2F22202F3E0D0A2020202020202020202020202020202020202020202020203C696D67207372633D222F2F73322E726462757A2E636F6D2F7765622F696D616765732F686F6D652F547769747465722E706E672220636C6173733D226C696E6B2D626C6F636B7320747769747465722D666F6F7465722220646174612D6C696E6B3D2268747470733A2F2F747769747465722E636F6D2F7265644275735F696E22202F3E0D0A20202020202020202020202020202020202020203C2F6469763E0D0A202020202020202020202020202020203C646976207374796C653D22666C6F61743A206C656674223E0D0A20202020202020202020202020202020202020203C7370616E3E2623393430303B3C2F7370616E3E0D0A20202020202020202020202020202020202020203C7370616E3E203230313620696269626F67726F757020416C6C207269676874732072657365727665643C2F7370616E3E0D0A202020202020202020202020202020203C2F6469763E0D0A2020202020202020202020203C2F6469763E2020202020202020202020200D0A20202020202020203C2F6469763E0D0A202020203C2F6469763E0D0A3C2F6469763E0D0A0D0A20202020202020203C2F666F6F7465723E0D0A202020203C2F73656374696F6E3E0D0A202020203C64697620636C6173733D226D73672D686561646572223E0D0A20202020202020203C64697620636C6173733D226D73672D73756363657373223E0D0A2020202020202020202020203C6469763E0D0A202020202020202020202020202020203C656D3E3F3C2F656D3E0D0A202020202020202020202020202020203C7370616E2069643D226E665F73756363657373223E3C2F7370616E3E0D0A2020202020202020202020203C2F6469763E0D0A2020202020202020202020203C6120687265663D226A6176617363726970743A766F69642830293B2220636C6173733D226E662D636C6F7365223E3F3C2F613E0D0A20202020202020203C2F6469763E0D0A20202020202020203C64697620636C6173733D226D73672D6572726F72223E0D0A2020202020202020202020203C6469763E0D0A202020202020202020202020202020203C656D3E3F3C2F656D3E0D0A202020202020202020202020202020203C7370616E2069643D226E665F6572726F72223E3C2F7370616E3E0D0A2020202020202020202020203C2F6469763E0D0A2020202020202020202020203C6120687265663D226A6176617363726970743A766F69642830293B2220636C6173733D226E662D636C6F7365223E3F3C2F613E0D0A20202020202020203C2F6469763E0D0A20202020202020203C64697620636C6173733D226D73672D696E666F223E0D0A2020202020202020202020203C6469763E0D0A202020202020202020202020202020203C656D3EA13C2F656D3E0D0A202020202020202020202020202020203C7370616E2069643D226E665F696E666F223E3C2F7370616E3E0D0A2020202020202020202020203C2F6469763E0D0A2020202020202020202020203C6120687265663D226A6176617363726970743A766F69642830293B2220636C6173733D226E662D636C6F7365223E3F3C2F613E0D0A20202020202020203C2F6469763E0D0A20202020202020203C64697620636C6173733D226D73672D6E6F74696365223E0D0A2020202020202020202020203C6469763E0D0A202020202020202020202020202020203C656D3E3F3C2F656D3E0D0A202020202020202020202020202020203C7370616E2069643D226E665F6E6F74696365223E3C2F7370616E3E0D0A2020202020202020202020203C2F6469763E0D0A2020202020202020202020203C6120687265663D226A6176617363726970743A766F69642830293B2220636C6173733D226E662D636C6F7365223E3F3C2F613E0D0A20202020202020203C2F6469763E0D0A202020203C2F6469763E0D0A202020203C212D2D20476F6F676C6520546167204D616E61676572202D2D3E0D0A202020203C6E6F7363726970743E0D0A20202020202020203C696672616D65207372633D222F2F7777772E676F6F676C657461676D616E616765722E636F6D2F6E732E68746D6C3F69643D47544D2D544346545837220D0A202020202020202020202020202020206865696768743D2230222077696474683D223022207374796C653D22646973706C61793A6E6F6E653B7669736962696C6974793A68696464656E223E3C2F696672616D653E0D0A202020203C2F6E6F7363726970743E0D0A202020203C7363726970743E0D0A20202020202020202866756E6374696F6E2028772C20642C20732C206C2C206929207B0D0A202020202020202020202020775B6C5D203D20775B6C5D207C7C205B5D3B20775B6C5D2E70757368287B0D0A202020202020202020202020202020202767746D2E7374617274273A0D0A202020202020202020202020202020206E6577204461746528292E67657454696D6528292C206576656E743A202767746D2E6A73270D0A2020202020202020202020207D293B207661722066203D20642E676574456C656D656E747342795461674E616D652873295B305D2C0D0A2020202020202020202020206A203D20642E637265617465456C656D656E742873292C20646C203D206C20213D2027646174614C6179657227203F2027266C3D27202B206C203A2027273B206A2E6173796E63203D20747275653B206A2E737263203D0D0A0D0A202020202020202020202020272F2F7777772E676F6F676C657461676D616E616765722E636F6D2F67746D2E6A733F69643D27202B2069202B20646C3B20662E706172656E744E6F64652E696E736572744265666F7265286A2C2066293B0D0A20202020202020207D292877696E646F772C20646F63756D656E742C2027736372697074272C2027646174614C61796572272C202747544D2D54434654583727293B3C2F7363726970743E0D0A202020203C212D2D20456E6420476F6F676C6520546167204D616E61676572202D2D3E0D0A202020203C7363726970743E0D0A202020202020202076617220697352657761726473456E61626C6564203D20747275653B0D0A202020203C2F7363726970743E0D0A202020203C736372697074207372633D222F2F73312E726462757A2E636F6D2F7765622F6A617661736372697074732F76656E646F722E37313139633261393161376432323266396335322E62756E646C652E6A732220747970653D22746578742F6A617661736372697074223E3C2F7363726970743E0D0A202020203C736372697074207372633D222F2F73322E726462757A2E636F6D2F7765622F6A617661736372697074732F6C61796F75742E63376230333934346638633736646330653562332E62756E646C652E6A732220747970653D22746578742F6A617661736372697074223E3C2F7363726970743E0D0A202020200D0A202020203C73637269707420747970653D22746578742F6A617661736372697074223E0D0A20202020766172206C616E67756167654A534F4E203D207B226F6E776172644C626C223A226F6E77617264222C2272657475726E4C626C223A2272657475726E222C22736F727454726176656C734C626C223A224F70657261746F72222C22736F72744465706172744C626C223A22446570617274757265222C22736F72744475726174696F6E4C626C223A224475726174696F6E222C22736F72744172726976654C626C223A224172726976616C222C22736F7274526174696E67734C626C223A22526174696E6773222C22736F727453656174734C626C223A22536561747320417661696C61626C65222C22736F7274466172654C626C223A2246617265222C226D6F64696679427574746F6E4C626C223A224D6F64696679222C2267726F7570696E6753746172744C626C223A22537461727473206174222C2262757353656174734C626C223A225365617473222C22627573536561747357696E646F774C626C223A2257696E646F77222C2262757350726F636565644C626C223A2250726F63656564222C226275735669657753656174734C626C223A2256696577205365617473222C226E6F536561744C61796F757453656C65637450617373656E6765724C626C223A22506C656173652073656C656374204E6F206F662070617373656E67657273222C22736561744C61796F7574427053656C656374223A2253656C65637420426F617264696E6720506F696E74222C22736561744C61796F7574447053656C656374223A2253656C6563742044726F7070696E6720506F696E74222C22736561744C61796F75744465636B55707065724C626C223A225570706572204465636B222C22736561744C61796F75744465636B4C6F7765724C626C223A224C6F776572204465636B222C22736561744C61796F75744465636B557070657253656C6563744C626C223A225570706572222C22736561744C61796F75744465636B4C6F77657253656C6563744C626C223A224C6F776572222C22736561744C61796F757466617265734C626C223A224641524553222C22736561744C61796F7574536561747353656C65637465644C626C223A225345415453222C22736572766963656E6F74654C626C223A2253455256494345204E4F5445222C22736561744C61796F757453686F77427574746F6E4C626C223A2253686F77204C61796F7574222C227365617470726963654C626C223A2253656174205072696365222C2273686F7766617265627265616B75704C626C223A2253686F77204661726520427265616B5570222C226869646566617265627265616B75704C626C223A2248696465204661726520427265616B5570222C2273656C6563746C6F636174696F6E4C626C223A2253656C65637420796F757220426F617264696E6720506F696E74222C2272746353656C656374596F75724C6F636174696F6E4C626C223A2253656C65637420796F757220426F617264696E672F44726F7070696E6720506F696E74222C227265644465616C734C626C223A22524544204445414C53222C227265644465616C7342616E6E6572547874223A22524544204445414C5320617661696C61626C6520696E207468697320726F757465222C22766965774C626C223A2256494557222C22636C6561724C626C223A22434C454152222C226B6E6F776D6F72654C626C223A224B6E6F77206D6F7265222C226B6E6F776C6573734C626C223A224B6E6F77206C657373222C226F6E74696D6547756172616E7465654C626C223A224F6E2054696D65206F72204D6F6E6579204261636B222C2273756D6D6172794C626C223A6E756C6C2C2262757350616E656C42704C626C223A22424F415244494E4720504F494E54222C2262757350616E656C44704C626C223A2244524F5050494E4720504F494E54222C2262757350616E656C416D656E744C626C223A22416D656E6974696573222C2262757350616E656C526576696577734C626C223A2252657669657773222C2262757350616E656C427044704C626C223A22426F617264696E6720506F696E74205C75303032362044726F7070696E6720506F696E74222C224E756D6265724F66427573657354657874223A224275736573222C227365617263684C6162656C223A22536561726368222C226869646553656174734C6162656C223A2248494445205345415453222C2263616E63656C6C6174696F6E506F6C6963796C6162656C223A2243616E63656C6C6174696F6E20506F6C696379222C2262757350616E656C4F6E74696D654C626C223A224F6E2054696D65222C2263757374496E666F4D6F64656C223A7B2270617373656E6765725469746C65223A2250617373656E6765722044657461696C73222C22636F6E746163745469746C65223A22436F6E746163742044657461696C73222C226D616B655061796D656E744C626C223A2250726F6365656420746F20706179222C22636F6E746163744275734F7074223A22436F6E74616374696E6720627573206F70657261746F722E2E2E222C22696E737572616E63655469746C65223A22496E737572616E6365222C227072696D61727950617373656E6765724C626C223A225072696D6172792050617373656E676572222C22636F50617373656E6765724C626C223A22436F2D50617373656E676572222C2253656174223A2253656174222C22746F74616C416D6F756E744C626C223A22546F74616C20416D6F756E74222C2266617265427265616B75704C626C223A224661726520427265616B7570222C2266656D616C654E6F7465223A22526573657276656420666F722066656D616C652070617373656E67657273206F6E6C79227D2C22736561744C61796F75744270223A22426F617264696E67222C22736561744C61796F75744470223A2244726F7070696E67222C226D6F6469667946726F6D223A2246524F4D222C226D6F64696679546F223A22546F222C226D6F64696679536561726368223A22534541524348222C226D6F6469667943616E63656C223A2243616E63656C222C226D6F6469667944617465223A2244415445222C226D6F646966795372634572726F724C626C223A22456E74657220736F75726365222C226D6F64696679446573744572726F724C626C223A22456E7465722044657374222C226D6F64696679446174654572726F724C626C223A224F6E7761726420646174652073686F756C64206265206265666F72652072657475726E2064617465222C226D6F646966795365617263684C626C223A226D6F6469667920736561726368222C22426F6F6B4E6F774C626C223A22424F4F4B204E4F57222C2262704470546F6F6C7469704C626C223A2253656C65637420426F617264696E6720506F696E74202F2044726F7070696E6720506F696E74222C22736561744C61796F75744572726F724C626C223A2253656C65637465642073657276696365206973206E6F206C6F6E67657220617661696C61626C6520666F7220626F6F6B696E672E20506C656173652063686F6F736520616E6F7468657220736572766963652E222C22536561746C61796F75744C6567656E64223A7B22736561744C6567656E644C626C223A2273656174206C6567656E64222C22617661696C4C626C223A22617661696C61626C65222C22756E417661696C4C626C223A22756E617661696C61626C65222C226C61646965734C626C223A226C6164696573222C22736C65657065724C626C223A22736C6565706572227D2C2246696C7465724D6F64656C223A7B2266696C74657244657461696C7354726176656C5048223A224F50455241544F52222C2266696C74657244657461696C734465706172745048223A224445504152545552452054494D45222C2266696C74657244657461696C7342705048223A22424F415244494E4720504F494E54222C2266696C74657244657461696C7344705048223A2244524F5050494E4720504F494E54222C2266696C74657244657461696C734275736573466F756E644C626C223A22427573657320666F756E64222C2266696C74657244657461696C735265736574223A22526573657420416C6C222C2266696C74657244657461696C73446F6E65223A22446F6E65222C2266696C746572734C626C223A2246696C746572204259222C22627573547970654C626C223A22425553205459504553222C22536F727442794C424C223A22534F5254204259227D2C2243757374496E666F4D6F64656C223A6E756C6C2C22466172654F626A656374223A7B22616D6F756E74223A224164756C742046617265222C226E6574223A22426173652046617265222C226368696C6446617265223A224368696C6420466172652028322D313220596561727329222C226368696C644661726554657874223A224368696C6472656E2062656C6F772032207965617273206F662061676520646F206E6F74206E6565642073657065726174652073656174732E227D2C2266726F6D436974794E616D65223A6E756C6C2C22746F436974794E616D65223A6E756C6C2C226C626C4F6F707354657874223A224F6F707321204E6F20627573657320666F756E642E222C226C626C4E6F4275734F6E526F757465223A22546865726520617265206E6F20627573657320666F756E64206F6E207468697320726F757465206F662073656C656374656420444F4A2E20506C6561736520747279206120646966666572656E7420726F757465206F722064617465222C226C626C4E6F4275734F6E46696C746572223A22546865726520617265206E6F20726573756C747320666F72207468652073656C656374656420636F6D62696E6174696F6E206F662062757320747970652C20626F617264696E6720706F696E742C2064726F7070696E6720706F696E742C206465706172747572652074696D6520616E6420616D656E69746965732E222C226270647056696577496E4D61704C626C223A225669657720696E204D6170222C2264657461696C734C626C223A2244657461696C73222C227374426876724C626C223A225374616666204265686176696F72222C2270756E634C626C223A2270756E637475616C697479222C22627573514C626C223A22627573207175616C697479222C22736B69704C626C223A22736B69702072657475726E20616E642070726F63656564222C2272657475726E517565734C626C223A224865792C2061726520796F752072657475726E696E67206F6E207468652073616D6520646179222C2272657475726E5965734C626C223A22796573222C2272657475726E4E6F4C626C223A226E6F222C22636C656172416C6C4C626C223A22636C65617220616C6C222C2263616E63656C54696D654C626C223A2274696D65206F662063616E63656C6C6174696F6E222C22726566756E644C626C223A2243616E63656C6C6174696F6E204368617267652070657263656E74616765222C22726566756E64416D744C626C223A2243616E63656C6C6174696F6E2043686172676520616D6F756E74222C2264657461696C73434D4C626C223A22596F752063616E20736565206D6F72652064657461696C732061626F757420656163682062757320627920636C69636B696E67206F6E2074686573652074616273222C2266696C74657273434D4C626C223A224C6F6F6B20666F72206275736573206261736564206F6E20626F617264696E6720706F696E74732C2074696D6520616E6420616D656E6974696573222C22676F7449744C626C223A22476F74204974222C226D7469636B65744C626C223A224D2D7469636B657420537570706F72746564222C226E6F6D7469636B65744C626C223A224D2D7469636B657420204E6F7420537570706F72746564222C226D7469636B65745469746C65223A224D2D7469636B657420417661696C61626C65222C226E6F6D7469636B65745469746C65223A224D2D7469636B657420204E6F7420417661696C61626C65222C2273686F77525443536561746C61796F75744D7367223A2253656C65637420426F617264696E6720616E642044726F7070696E6720506F696E747320746F2073686F772073656174206C61796F7574222C2253686F77536F7572636544657374223A66616C73652C224F6E54696D6547756172616E746565223A7B226F6E54696D654865616465724C626C223A224F6E2054696D652047756172616E746565206F72204D6F6E6579204261636B222C226F6E54696D6550617231223A2248696768207175616C6974792062757365732077697468206C69766520747261636B696E6720616E642043435456222C226F6E54696D6550617232223A22222C227465726D734865616465724C626C223A225465726D73205C753030323620436F6E646974696F6E73222C227465726D7350617231223A2232352520526566756E64202D203330206D696E732064656C617920696E207069636B2D75702066726F6D2031737420626F617264696E6720706F696E74222C227465726D7350617232223A223135302520526566756E64202D204275732043616E63656C6C65642077697468204E6F20616C7465726E61746520617272616E67656D656E74222C227465726D7350617233223A22333030202520526566756E64202D2042757320627265616B646F776E2077697468206E6F20616C7465726E61746976652077697468696E203620686F757273227D2C227265644465616C546F6F6C746970223A22546865736520617265206F6666657273207468617420636F6D652066726F6D206F70657261746F7273206578636C75736976656C79206F6E207468652072656442757320706C6174666F726D2E205468657365206F666665727320676574206170706C696564206F76657220616E642061626F7665206F7468657220636F75706F6E2D626173656420616E6420706172746E6572206F66666572732E205468657365206F666665727320646F206E6F74207265717569726520616E7920636F75706F6E20636F64652E222C224C61796F7574223A7B22486561646572223A7B22506167654E616D65223A22534541524348222C226C6F676F223A7B22737263223A222F696D616765732F686F6D652F7367702F6C61796F75745F6C6F676F2E706E67222C227469746C65223A227265644275732E696E20496E6469615C7530303237732023312042757320426F6F6B696E672053697465222C22616C74223A227265644275732E696E222C226C696E6B223A222F227D2C2270726F6475637473223A5B7B226C696E6B223A222F222C226C6162656C223A22425553205449434B455453222C227469746C65223A22726564427573227D2C7B226C696E6B223A2268747470733A2F2F7777772E7265646275732E696E2F686F74656C732F222C226C6162656C223A22484F54454C53222C227469746C65223A2272656442757320486F74656C73227D2C7B226C696E6B223A2268747470733A2F2F7777772E7265646275732E696E2F627573686972653F75746D5F736F757263653D776562736974655C753030323675746D5F6D656469756D3D726566657272616C5C753030323675746D5F63616D706169676E3D486F6D65706167655F627573686972655F62616E6E6572222C226C6162656C223A224255532048495245222C227469746C65223A22726564427573204275732048697265227D5D2C2268656C7054657874223A224E6565642048656C703F222C2268656C704E6F223A5B222B36352D3331353832383838225D2C2268656C70456D61696C4964223A22737570706F7274407265646275732E7367222C2268656C704E6F54657874223A2243616C6C2055732061743A20222C22686F77746F4F7264657254657874223A22486F7720746F206F72646572222C2268656C70456D61696C54657874223A22456D61696C20746F3A20222C225072696E74534D53223A225072696E742F534D53205469636B6574222C225072696E74534D5348726566223A222F486F6D652F5072696E745469636B6574222C226C626C43616C6C55734174223A2243616C6C205573204174222C22696D6743616C6C55734174223A2268747470733A2F2F73332E726462757A2E636F6D2F5765622F496D616765732F63616C6C5F6E65772E706E67222C226C626C43616C6C5573417448656C70223A22484F572043414E2057452048454C5020594F553F222C226C626C43616E63656C223A2243616E63656C205469636B6574222C226C626C5772697465546F5573223A22577269746520546F205573222C22696D675772697465546F5573223A2268747470733A2F2F73332E726462757A2E636F6D2F5765622F496D616765732F77726974652E706E67222C22636F756E74727944726F70446F776E223A5B7B2276616C7565223A224D5953222C226C6162656C223A224D616C6179736961222C226C696E6B223A2268747470733A2F2F73746167652E7265646275732E6D79227D2C7B2276616C7565223A22534750222C226C6162656C223A2253696E6761706F7265222C226C696E6B223A2268747470733A2F2F73746167652E7265646275732E7367227D2C7B2276616C7565223A2249444E222C226C6162656C223A22496E646F6E65736961222C226C696E6B223A2268747470733A2F2F73746167652E7265646275732E6964227D5D2C226C616E677561676544726F70446F776E223A5B7B2276616C7565223A22656E222C226C6162656C223A22456E676C697368227D5D2C2263757272656E637944726F70446F776E223A5B7B2276616C7565223A22494E52222C226C6162656C223A22494E52222C22636F756E747279223A22496E6469616E205275706565227D5D2C224973557365725369676E6564496E223A66616C73652C226865616465724163746976654C696E6B73223A5B7B2246656174757265223A224973506572736F6E616C697A6174696F6E222C2276616C7565223A747275657D2C7B2246656174757265223A2249734C616E67756167654444222C2276616C7565223A66616C73657D2C7B2246656174757265223A22497343757272656E63794444222C2276616C7565223A66616C73657D2C7B2246656174757265223A2249735072696E74534D53222C2276616C7565223A747275657D2C7B2246656174757265223A2249734E65656448656C70222C2276616C7565223A66616C73657D2C7B2246656174757265223A22497343616C6C5573222C2276616C7565223A747275657D2C7B2246656174757265223A2249735772697465546F5573222C2276616C7565223A747275657D2C7B2246656174757265223A22497343616E63656C6C6174696F6E222C2276616C7565223A747275657D2C7B2246656174757265223A224973486F77546F4F72646572222C2276616C7565223A66616C73657D5D2C22706572736F6E616C697A6174696F6E223A5B7B226964223A226D74222C22646973706C61794E616D65223A224D79205472697073222C226C696E6B223A226D7970726F66696C65237472697073227D2C7B226964223A227763222C22646973706C61794E616D65223A2257616C6C6574732F4361726473222C226C696E6B223A226D7970726F66696C652377616C6C6574227D2C7B226964223A226D70222C22646973706C61794E616D65223A224D792050726F66696C65222C226C696E6B223A226D7970726F66696C65227D2C7B226964223A22736F222C22646973706C61794E616D65223A225369676E204F7574222C226C696E6B223A22227D2C7B226964223A227369222C22646973706C61794E616D65223A225369676E20496E2F5369676E205570222C226C696E6B223A22227D5D2C224973524257616C6C657446656174757265456E61626C6564223A747275657D2C22466F6F746572223A7B2273656F4C696E6B73223A5B7B22686561646572223A22546F702042757320526F75746573222C227375624C696E6B73223A5B7B226C6162656C223A2248796465726162616420746F2042616E67616C6F726520427573222C226C696E6B223A222F6275732D7469636B6574732F6879646572616261642D746F2D62616E67616C6F72652E61737078227D2C7B226C6162656C223A2242616E67616C6F726520746F204368656E6E616920427573222C226C696E6B223A222F6275732D7469636B6574732F62616E67616C6F72652D746F2D6368656E6E61692E61737078227D2C7B226C6162656C223A2250756E6520746F2042616E67616C6F726520427573222C226C696E6B223A222F6275732D7469636B6574732F70756E652D746F2D62616E67616C6F72652E61737078227D2C7B226C6162656C223A224D756D62616920746F2042616E67616C6F726520427573222C226C696E6B223A222F6275732D7469636B6574732F6D756D6261692D746F2D62616E67616C6F72652E61737078227D2C7B226C6162656C223A224D6F7265205C7530303365222C226C696E6B223A222F6275732D7469636B6574732F726F757465732D6469726563746F72792E61737078227D5D7D2C7B22686561646572223A22546F7020436974696573222C227375624C696E6B73223A5B7B226C6162656C223A22487964657261626164222C226C696E6B223A222F62757365732F6879646572616261642D6275732D7469636B6574732E61737078227D2C7B226C6162656C223A2242616E67616C6F7265222C226C696E6B223A222F62757365732F62616E67616C6F72652D6275732D7469636B6574732E61737078227D2C7B226C6162656C223A224368656E6E6169222C226C696E6B223A222F62757365732F6368656E6E61692D6275732D7469636B6574732E61737078227D2C7B226C6162656C223A2250756E65222C226C696E6B223A222F62757365732F70756E652D6275732D7469636B6574732E61737078227D2C7B226C6162656C223A224D6F7265205C7530303365222C226C696E6B223A222F62757365732F6369746965732D6469726563746F72792E61737078227D5D7D2C7B22686561646572223A22546F7020427573204F70657261746F7273222C227375624C696E6B73223A5B7B226C6162656C223A225352532054726176656C73222C226C696E6B223A222F74726176656C732F7372732D74726176656C732D7372732E61737078227D2C7B226C6162656C223A2256524C2054726176656C73222C226C696E6B223A222F74726176656C732F76726C2D74726176656C732D76726C2E61737078227D2C7B226C6162656C223A224B504E2054726176656C73222C226C696E6B223A222F74726176656C732F6B706E2D74726176656C732D6B706E2E61737078227D2C7B226C6162656C223A224B616C6C6164612054726176656C73222C226C696E6B223A222F74726176656C732F6B616C6C6164612D74726176656C732D6B616C6C6164612E61737078227D2C7B226C6162656C223A224D6F7265205C7530303365222C226C696E6B223A222F74726176656C732F6F70657261746F72732D6469726563746F72792E61737078227D5D7D2C7B22686561646572223A22546F70205254435C753030323773222C227375624C696E6B73223A5B7B226C6162656C223A22415053525443222C226C696E6B223A222F6F6E6C696E652D626F6F6B696E672F6170737274632E61737078227D2C7B226C6162656C223A224D53525443222C226C696E6B223A222F6F6E6C696E652D626F6F6B696E672F6D737274632E61737078227D2C7B226C6162656C223A2248525443222C226C696E6B223A222F6F6E6C696E652D626F6F6B696E672F687274632E61737078227D2C7B226C6162656C223A22555053525443222C226C696E6B223A222F6F6E6C696E652D626F6F6B696E672F7570737274632E61737078227D2C7B226C6162656C223A224D6F72655C753030336520222C226C696E6B223A222F6F6E6C696E652D626F6F6B696E672F7274632D6469726563746F72792E61737078227D5D7D5D2C226C6F676F223A7B22696D67223A2268747470733A2F2F73332E726462757A2E636F6D2F7765622F696D616765732F686F6D652F7367702F725F6C6F676F2E706E67222C2264657363223A227265644275732069732074686520776F726C645C753030323773206C617267657374206F6E6C696E6520627573207469636B657420626F6F6B696E6720736572766963652074727573746564206279206F7665722038206D696C6C696F6E20686170707920637573746F6D65727320676C6F62616C6C792E20726564427573206F666665727320627573207469636B657420626F6F6B696E67207468726F7567682069747320776562736974652C694F5320616E6420416E64726F6964206D6F62696C65206170707320666F7220616C6C206D616A6F7220726F757465732E227D2C22736F6369616C4D65646961223A5B7B22696D67223A222F2F73312E726462757A2E636F6D2F7765622F696D616765732F686F6D652F46616365626F6F6B2E706E67222C226C696E6B223A2268747470733A2F2F7777772E66616365626F6F6B2E636F6D2F7265646275732E696E2F227D2C7B22696D67223A222F2F73322E726462757A2E636F6D2F7765622F696D616765732F686F6D652F547769747465722E706E67222C226C696E6B223A2268747470733A2F2F747769747465722E636F6D2F7265644275735F696E227D5D2C22466F6F7465724C696E6B73223A5B7B22686561646572223A2241626F757420526564627573222C227375624C696E6B73223A5B7B226C6162656C223A2241626F7574205573222C226C696E6B223A222F696E666F2F61626F75747573227D2C7B226C6162656C223A22436F6E74616374205573222C226C696E6B223A222F696E666F2F636F6E746163747573227D2C7B226C6162656C223A224D6F62696C652056657273696F6E222C226C696E6B223A222F2F6D2E7265646275732E696E227D2C7B226C6162656C223A22726564427573206F6E204D6F62696C65222C226C696E6B223A222F696E666F2F6D6F62696C65227D2C7B226C6162656C223A22536974656D6170222C226C696E6B223A222F736974656D61702E68746D6C227D2C7B226C6162656C223A224F6666657273222C226C696E6B223A222F696E666F2F4F666665725465726D73227D2C7B226C6162656C223A2243617265657273222C226C696E6B223A22687474703A2F2F636172656572732E7265646275732E696E2F227D5D7D2C7B22686561646572223A22496E666F222C227375624C696E6B73223A5B7B226C6162656C223A2254205C75303032362043222C226C696E6B223A222F696E666F2F7465726D73636F6E646974696F6E227D2C7B226C6162656C223A225072697661637920506F6C696379222C226C696E6B223A222F696E666F2F70726976616379706F6C696379227D2C7B226C6162656C223A22464151222C226C696E6B223A222F696E666F2F666171227D2C7B226C6162656C223A22426C6F67222C226C696E6B223A22687474703A2F2F626C6F672E7265646275732E696E2F227D2C7B226C6162656C223A224167656E7420526567697374726174696F6E222C226C696E6B223A2268747470733A2F2F7777772E7265646275732E696E2F4167656E746C6F67696E2E61737078227D5D7D2C7B22686561646572223A22476C6F62616C205369746573222C227375624C696E6B73223A5B7B226C6162656C223A22496E646961222C226C696E6B223A2268747470733A2F2F7777772E7265646275732E696E227D2C7B226C6162656C223A2253696E6761706F7265222C226C696E6B223A2268747470733A2F2F7777772E7265646275732E7367227D2C7B226C6162656C223A224D616C6179736961222C226C696E6B223A2268747470733A2F2F7777772E7265646275732E6D79227D2C7B226C6162656C223A22496E646F6E65736961222C226C696E6B223A2268747470733A2F2F7777772E7265646275732E6964227D5D7D5D7D2C2252657761726473223A747275652C22626F6F6C417070766972616C69747942616E6E6572223A66616C73652C2253656F54616773223A7B227469746C65223A224F6E6C696E6520427573207469636B65747320426F6F6B696E672C20414320566F6C766F20426F6F6B696E672C2032353020494E52204342204F6E20427573205265736572766174696F6E222C226465736372697074696F6E223A227265644275732E696E20576F726C649273204C6172676574204F6E6C696E6520427573205469636B65747320506C6174666F726D206F66666572732062696720696E76656E746F7279206F66206F70657261746F72732C20726F75746573205C75303032362052544373207769746820545241434B4D594255532C5245535453544F5053202066656174757265732E2055736520636F75706F6E20636F64652C2067657420646973636F756E747320616E6420626F6F6B20796F757220627573207469636B65742E222C2263616E6F6E6963616C223A2268747470733A2F2F7777772E7265646275732E696E2F736561726368222C224B6579776F726473223A226F6E6C696E6520627573207469636B657420626F6F6B696E672C2062757320626F6F6B696E672C20766F6C766F2061632062757320626F6F6B696E672C20627573207469636B657420626F6F6B696E672C20627573207469636B657473222C224D656469615F746167223A2268747470733A2F2F6D2E7265646275732E696E2F222C22676F6F676C6573697465766572696669636174696F6E223A2278463655764F4A5763445553656E737342723854397547615F6874572D3268335862553946417639735138222C224F7267616E697A6174696F6E616C536368656D61223A7B22636F6E7465787456616C7565223A2268747470733A2F2F7777772E736368656D612E6F7267222C227479706556616C7565223A224F7267616E697A6174696F6E222C226E616D6556616C7565223A2272656442757320496E646961222C2275726C56616C7565223A2268747470733A2F2F7777772E7265646275732E696E2F227D2C22526F626F74734D657461223A7B226E616D65223A22726F626F7473222C22636F6E74656E74223A226E6F6F6470227D7D2C2253315F43444E223A222F2F73312E726462757A2E636F6D2F7765622F222C2253325F43444E223A222F2F73322E726462757A2E636F6D2F7765622F222C2253335F43444E223A222F2F73332E726462757A2E636F6D2F7765622F222C2244656661756C744C616E6775616765223A22656E222C224F666665725365617473436F6E666967223A6E756C6C2C22466561747572654C697374223A7B224973524257616C6C657446656174757265456E61626C6564223A747275652C2249735361766564436172647346656174757265456E61626C6564223A747275657D2C22617070566972616C69747942616E6E6572547874223A22496E7669746520796F757220667269656E6473205C75303032362066616D696C7920746F206A6F696E2072656442757320616E64206561726E206578636974696E6720726577617264732E222C22617070566972616C69747942616E6E6572436C69636B223A22434C49434B2048455245222C22697352657475726E223A747275657D7D3B0D0A202020203C2F7363726970743E0D0A202020203C736372697074207372633D222F2F73312E726462757A2E636F6D2F7765622F6A617661736372697074732F7365617263682E35626265366637316234613939353732656330382E62756E646C652E6A73223E3C2F7363726970743E0D0A202020200D0A0D0A3C2F626F64793E0D0A3C2F68746D6C3E,89),
 (37,'Menu 20161025 1739','2716 kb','application/octet-stream',0x2D2D204D7953514C2041646D696E6973747261746F722064756D7020312E340A2D2D0A2D2D202D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D0A2D2D205365727665722076657273696F6E09352E352E390A0A0A2F2A2134303130312053455420404F4C445F4348415241435445525F5345545F434C49454E543D40404348415241435445525F5345545F434C49454E54202A2F3B0A2F2A2134303130312053455420404F4C445F4348415241435445525F5345545F524553554C54533D40404348415241435445525F5345545F524553554C5453202A2F3B0A2F2A2134303130312053455420404F4C445F434F4C4C4154494F4E5F434F4E4E454354494F4E3D4040434F4C4C4154494F4E5F434F4E4E454354494F4E202A2F3B0A2F2A21343031303120534554204E414D45532075746638202A2F3B0A0A2F2A2134303031342053455420404F4C445F554E495155455F434845434B533D4040554E495155455F434845434B532C20554E495155455F434845434B533D30202A2F3B0A2F2A2134303031342053455420404F4C445F464F524549474E5F4B45595F434845434B533D4040464F524549474E5F4B45595F434845434B532C20464F524549474E5F4B45595F434845434B533D30202A2F3B0A2F2A2134303130312053455420404F4C445F53514C5F4D4F44453D404053514C5F4D4F44452C2053514C5F4D4F44453D274E4F5F4155544F5F56414C55455F4F4E5F5A45524F27202A2F3B0A0A0A2D2D0A2D2D2043726561746520736368656D61206572706E65787467656E65726174696F6E0A2D2D0A0A435245415445204441544142415345204946204E4F5420455849535453206572706E65787467656E65726174696F6E3B0A555345206572706E65787467656E65726174696F6E3B0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606D656E753030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606D656E753030316D62603B0A435245415445205441424C4520606D656E753030316D626020280A2020606D656E7569646020696E7428313029204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606D656E756E616D6560207661726368617228323529204E4F54204E554C4C2C0A2020606D656E756C696E6B602076617263686172283735292044454641554C54204E554C4C2C0A2020606D656E75747970656020656E756D28274D61696E2D4D656E75272C274368696C642D4D656E75272C27506167652D4D61696E2D4D656E75272C27506167652D4368696C642D4D656E7527292044454641554C54204E554C4C2C0A202060706172656E7469646020696E74283130292044454641554C54202730272C0A202060706172656E746E616D65602076617263686172283235292044454641554C54204E554C4C2C0A202060646F6D61696E60207661726368617228323529204E4F54204E554C4C2C0A20205052494D415259204B45592028606D656E75696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D392044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606D656E753030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606D656E753030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606D656E753030316D62602028606D656E756964602C606D656E756E616D65602C606D656E756C696E6B602C606D656E7574797065602C60706172656E746964602C60706172656E746E616D65602C60646F6D61696E60292056414C554553200A2028312C274D616E75666163747572696E67272C4E554C4C2C274D61696E2D4D656E75272C302C4E554C4C2C274D616E75666163747572696E6727292C0A2028322C2750726F64756374696F6E272C272F54657374416E645265706F727453747564696F2F50726F644F7264657244657461696C732F70726F646F72646572272C274368696C642D4D656E75272C312C274D616E75666163747572696E67272C274D616E75666163747572696E6727292C0A2028332C2742696C6C206F66204D6174657269616C73272C272F54657374416E645265706F727453747564696F2F426F6D44657461696C732F62696C6C6F666D6174657269616C3F6D656E756C696E6B3D6D616E75666163747572696E67272C274368696C642D4D656E75272C312C274D616E75666163747572696E67272C274D616E75666163747572696E6727292C0A2028342C27546F6F6C73272C272F54657374416E645265706F727453747564696F2F426F6D44657461696C732F6D616E7566616374757265746F6F6C73272C274368696C642D4D656E75272C312C274D616E75666163747572696E67272C274D616E75666163747572696E6727292C0A2028352C275365745570272C272F54657374416E645265706F727453747564696F2F4D616E756661637475726544657461696C732F6D616E7566616374757265272C274368696C642D4D656E75272C312C274D616E75666163747572696E67272C274D616E75666163747572696E6727292C0A2028362C275365745570272C272F54657374416E645265706F727453747564696F2F4D616E756661637475726544657461696C732F6D616E7566616374757265272C274368696C642D4D656E75272C312C274D616E75666163747572696E67272C274D616E75666163747572696E6727292C0A2028372C275265706F727473272C272F54657374416E645265706F727453747564696F2F50726F64756374696F6E5265706F727444657461696C732F6F70656E70726F72646572272C274368696C642D4D656E75272C312C274D616E75666163747572696E67272C274D616E75666163747572696E6727292C0A2028382C2748656C70272C4E554C4C2C274368696C642D4D656E75272C312C274D616E75666163747572696E67272C274D616E75666163747572696E6727293B0A2F2A21343030303020414C544552205441424C4520606D656E753030316D626020454E41424C45204B455953202A2F3B0A0A0A0A0A2F2A213430313031205345542053514C5F4D4F44453D404F4C445F53514C5F4D4F4445202A2F3B0A2F2A2134303031342053455420464F524549474E5F4B45595F434845434B533D404F4C445F464F524549474E5F4B45595F434845434B53202A2F3B0A2F2A2134303031342053455420554E495155455F434845434B533D404F4C445F554E495155455F434845434B53202A2F3B0A2F2A21343031303120534554204348415241435445525F5345545F434C49454E543D404F4C445F4348415241435445525F5345545F434C49454E54202A2F3B0A2F2A21343031303120534554204348415241435445525F5345545F524553554C54533D404F4C445F4348415241435445525F5345545F524553554C5453202A2F3B0A2F2A2134303130312053455420434F4C4C4154494F4E5F434F4E4E454354494F4E3D404F4C445F434F4C4C4154494F4E5F434F4E4E454354494F4E202A2F3B0A2F2A21343031303120534554204348415241435445525F5345545F434C49454E543D404F4C445F4348415241435445525F5345545F434C49454E54202A2F3B0A,92);
/*!40000 ALTER TABLE `emailattachment001mb` ENABLE KEYS */;


--
-- Definition of table `empattendance001mb`
--

DROP TABLE IF EXISTS `empattendance001mb`;
CREATE TABLE `empattendance001mb` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `sNo` int(11) DEFAULT NULL,
  `empNumber` varchar(30) DEFAULT NULL,
  `clTaken` varchar(20) DEFAULT NULL,
  `clBalance` varchar(20) DEFAULT NULL,
  `compoffTaken` varchar(20) DEFAULT NULL,
  `compoffBalance` varchar(20) DEFAULT NULL,
  `lwtoutpTaken` varchar(20) DEFAULT NULL,
  `lwtoutpBalance` varchar(20) DEFAULT NULL,
  `mtlvTaken` varchar(20) DEFAULT NULL,
  `mtlvBalance` varchar(20) DEFAULT NULL,
  `ptyTaken` varchar(20) DEFAULT NULL,
  `ptyBalance` varchar(20) DEFAULT NULL,
  `pvglvTaken` varchar(20) DEFAULT NULL,
  `pvglvBalance` varchar(20) DEFAULT NULL,
  `sklvTaken` varchar(20) DEFAULT NULL,
  `sklBalance` varchar(20) DEFAULT NULL,
  `vcTaken` varchar(20) DEFAULT NULL,
  `vcBalance` varchar(20) DEFAULT NULL,
  `sklvBalance` varchar(255) DEFAULT NULL,
  `empName` varchar(255) DEFAULT NULL,
  `deptName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `empattendance001mb`
--

/*!40000 ALTER TABLE `empattendance001mb` DISABLE KEYS */;
INSERT INTO `empattendance001mb` (`Id`,`sNo`,`empNumber`,`clTaken`,`clBalance`,`compoffTaken`,`compoffBalance`,`lwtoutpTaken`,`lwtoutpBalance`,`mtlvTaken`,`mtlvBalance`,`ptyTaken`,`ptyBalance`,`pvglvTaken`,`pvglvBalance`,`sklvTaken`,`sklBalance`,`vcTaken`,`vcBalance`,`sklvBalance`,`empName`,`deptName`) VALUES 
 (32,NULL,'EMP_02','2','4','2','1','1','0','1','1','2','1','1','1','2',NULL,'1','1','4','Manikandan','Legal'),
 (33,NULL,'EMP_06','1','1','0','1','2','1','1','1','1','2','1','2','1',NULL,'1','0','1',' Dikman Shervashidze Shervashidze','Marketing Accounts'),
 (34,NULL,'EMP_011','3','1','1','1','1','1','1','1','1','1','1','1','1',NULL,'0','2','1','Zukutakitoteka','Research & Development'),
 (35,NULL,'EMP_07','2','1','1','2','1','1','1','1','1','0','1','2','2',NULL,'2','2','2','Hatsue Kashiwagi','Quality Management'),
 (36,NULL,'EMP_04','5','2','2','1','2','2','2','2','1','1','1','1','2',NULL,'1','1','1','Nuran Verkleij','Management'),
 (37,NULL,'EMP_03','1','2','1','0','2','1','2','1','2','1','2','1','2',NULL,'2','1','1','Tilde Lindqvist','Human Resources'),
 (38,NULL,'EMP_05','2','1','2','5','1','2','1','2','1','2','1','1','1',NULL,'2','1','1','Michal Sobczak','Customer Service'),
 (39,NULL,'EMP_08','2','1','2','1','1','2','1','2','1','2','1','2','1',NULL,'1','2','2','Gabrielle Loftus','Dispatch'),
 (40,NULL,'EMP_09','2','1','1','2','2','1','2','1','2','2','1','2','2',NULL,'2','2','2','Vakhita Ryzaev','Production'),
 (41,NULL,'EMP_010','2','2','1','2','2','1','2','1','2','1','4','2','2',NULL,'2','2','2','Charmaine Gaudreau','Operations'),
 (42,NULL,'EMP_02','1','1','1','1','1','1','1','1','1','1','1','1','1',NULL,'1','1','1','Manikandan','Legal');
/*!40000 ALTER TABLE `empattendance001mb` ENABLE KEYS */;


--
-- Definition of table `employee001mb`
--

DROP TABLE IF EXISTS `employee001mb`;
CREATE TABLE `employee001mb` (
  `sNo` int(11) NOT NULL AUTO_INCREMENT,
  `empNumber` varchar(30) NOT NULL,
  `empName` varchar(40) NOT NULL,
  `empDob` varchar(40) DEFAULT NULL,
  `empDoj` varchar(30) DEFAULT NULL,
  `empDesign` varchar(40) DEFAULT NULL,
  `empGender` varchar(20) DEFAULT NULL,
  `empCompany` varchar(40) DEFAULT NULL,
  `empStatus` varchar(20) DEFAULT NULL,
  `empId` int(11) DEFAULT NULL,
  `deptId` int(11) DEFAULT NULL,
  `deptName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`sNo`),
  KEY `deptId` (`deptId`),
  CONSTRAINT `employee001mb_ibfk_1` FOREIGN KEY (`deptId`) REFERENCES `department001mb` (`deptid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee001mb`
--

/*!40000 ALTER TABLE `employee001mb` DISABLE KEYS */;
INSERT INTO `employee001mb` (`sNo`,`empNumber`,`empName`,`empDob`,`empDoj`,`empDesign`,`empGender`,`empCompany`,`empStatus`,`empId`,`deptId`,`deptName`) VALUES 
 (3,'EMP_011','Zukutakitoteka','08/19/1994','08/08/2016','Android Developer','Female','IBM','Active',NULL,3,'Research & Development'),
 (7,'EMP_07','Hatsue Kashiwagi','10/20/2016','10/20/2016','Junior Engineer','Male','Wheels India','Active',NULL,4,'Quality Management'),
 (8,'EMP_04','Nuran Verkleij','03/29/1990','03/22/2015','Junior Engineer','Male','Karya','Active',NULL,NULL,'Management'),
 (9,'EMP_03','Tilde Lindqvist','08/12/1989','01/12/2001','Owner','Male','CTS','Active',NULL,7,'Human Resources'),
 (10,'EMP_05','Michal Sobczak','01/05/1984','01/20/2016','Junior Engineer','Male','IBM','Active',NULL,8,'Customer Service'),
 (11,'EMP_08','Gabrielle Loftus','01/04/1984','01/19/2016','Junior Engineer','Male','Agile','Active',NULL,NULL,'Dispatch'),
 (12,'EMP_09','Vakhita Ryzaev','10/05/1994','10/03/2016','Trainee','Male','Intellor','Active',NULL,10,'Production'),
 (13,'EMP_010','Charmaine Gaudreau','10/01/1990','01/18/2016','Project Manager','Male','TCS','Active',NULL,NULL,'Operations'),
 (14,'EMP_013','sivakumar','11/02/1982','06/03/2016','Porject Lead','Male','Karya Technology','Active',NULL,NULL,'Quality Management'),
 (15,'EMP_14','venkat','01/06/1987','01/20/2016','Trainee','Male','Karya Technology','Active',NULL,NULL,'Quality Management'),
 (16,'EMP_14','naresh','10/04/2016','10/04/2016','programmer','Male','karya','Active',NULL,NULL,'Quality Management'),
 (17,'EMP10','maya','10/04/2016','10/25/2016','DO','Female','KARYA','Active',NULL,NULL,'Research & Development'),
 (18,'             ','employee1','02/01/2016','11/18/2016','supervisor','Male','empcom','Active',NULL,NULL,'Legal');
/*!40000 ALTER TABLE `employee001mb` ENABLE KEYS */;


--
-- Definition of table `employmenttype001mb`
--

DROP TABLE IF EXISTS `employmenttype001mb`;
CREATE TABLE `employmenttype001mb` (
  `etypeId` int(11) NOT NULL AUTO_INCREMENT,
  `employmentType` varchar(30) NOT NULL,
  PRIMARY KEY (`etypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employmenttype001mb`
--

/*!40000 ALTER TABLE `employmenttype001mb` DISABLE KEYS */;
INSERT INTO `employmenttype001mb` (`etypeId`,`employmentType`) VALUES 
 (1,'Full Time'),
 (2,'Part Time'),
 (3,'Probation'),
 (4,'Contract Basis');
/*!40000 ALTER TABLE `employmenttype001mb` ENABLE KEYS */;


--
-- Definition of table `expensesclm001mb`
--

DROP TABLE IF EXISTS `expensesclm001mb`;
CREATE TABLE `expensesclm001mb` (
  `expclmId` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(30) NOT NULL,
  `totalclmAmt` decimal(12,4) DEFAULT NULL,
  `expCode` varchar(30) DEFAULT NULL,
  `expType` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`expclmId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expensesclm001mb`
--

/*!40000 ALTER TABLE `expensesclm001mb` DISABLE KEYS */;
INSERT INTO `expensesclm001mb` (`expclmId`,`status`,`totalclmAmt`,`expCode`,`expType`) VALUES 
 (1,'Draft','200.0000','EXP_001','Medical'),
 (2,'Submitted','450.0020','EXP_009','Travel'),
 (4,'Submitted','345.0900','EXP_006','Calls');
/*!40000 ALTER TABLE `expensesclm001mb` ENABLE KEYS */;


--
-- Definition of table `filemanager001mb`
--

DROP TABLE IF EXISTS `filemanager001mb`;
CREATE TABLE `filemanager001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginuser` varchar(30) NOT NULL,
  `category` varchar(30) NOT NULL,
  `filename` varchar(30) NOT NULL,
  `size` varchar(30) NOT NULL,
  `contenttype` varchar(255) NOT NULL,
  `content` longblob,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `filemanager001mb`
--

/*!40000 ALTER TABLE `filemanager001mb` DISABLE KEYS */;
INSERT INTO `filemanager001mb` (`id`,`loginuser`,`category`,`filename`,`size`,`contenttype`,`content`,`created`) VALUES 
 (16,'siva','Employee','Project Document.txt','1985Kb','text/plain',0x446576205365727665722044657461696C730D0A2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D0D0A49502061646472657373206F6620646576207365727665723A2035322E342E322E37310D0A557365726E616D653A20736976610D0A50617373776F72643A33333631390D0A596F75722063616D70206973203A202F686F6D652F736976612F63616D7031370D0A2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D0D0A546F206163636573732074686520554920666F7220796F75722063616D703A0D0A4D61702074686520666F6C6C6F77696E6720696E20796F757220686F7374732066696C653A2035322E342E322E37312031372E656D7363616D702E696E74656C6C6F722E636F6D0D0A090D0A757365723A696E74656C6C6F722070617373776F72643A746573746572230D0A2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D0D0A417426742073797374656D0D0A68747470733A2F2F636F6E6E65637432382E75632E6174742E636F6D2F4576656E74456E7472792F57656273697465732F3F5661636349643D617474636573636F6D2645784576656E7449443D3839343337333233200D0A2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D0D0A546F72746F697365202D2053564E0D0A73766E2B7373683A2F2F656D732F686F6D652F73766E2F656D732F656D732E73766E2F7472756E6B0D0A2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D0D0A46696C65732044657461696C730D0A46696C6573207468617420617265207573656420696E2074686520726567697374726174696F6E2070726F636573733A0D0A656D732F6C69622F656D732F72656769737465722E706D0D0A656D732F6C69622F656D732F7365745F6C616E64696E675F706167655F746167732E706D0D0A656D732F6C69622F656D732F737562737469747574655F746167732E706D0D0A656D732F6C69622F656D732F7365745F726567697374726174696F6E5F6C696E6B2E706D0D0A656D732F6C69622F656D732F656D61696C5765626D61737465722E706D0D0A656D732F6C69622F656D732F73656E645F6D61785F656D61696C732E706D0D0A656D732F6C69622F656D732F6C6F61642D617474656E6465655F64657461696C732E706D0D0A656D732F6C69622F656D732F72656C6F61645F617474656E6465655F64657461696C732E706D0D0A2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D0D0A687474703A2F2F716367746573743A383038302F54657374416E645265706F727453747564696F0D0A0D0A4C6F6767657220666F6C64657220706174680D0A2F686F6D652F736976612F63616D7031372F68747470642F6C6F67730D0A207072696E742022736976616B756D61722074657374696E67207375636365737320696E207468652073637265656E206C6576656C223B0D0A0D0A23726566726573685F75726C28247461677B526567697374726174696F6E4C696E6B7D293B0D0A0D0A0D0A68747470733A2F2F6769746875622E636F6D2F6B736976616B756D6172303231312F54657374416E645265706F727453747564696F2E6769740D0A68747470733A2F2F6769746875622E636F6D2F6B736976616B756D6172303231312F54657374416E645265706F727453747564696F0D0A557365724E616D65203A206B736976616B756D6172303231310D0A50617373776F7264203A205370617274616E732132330D0A0D0A687474703A2F2F3139322E3136382E332E3139333A383038302F54657374416E645265706F727453747564696F2F6C6F67696E0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A0D0A,'2016-10-01 01:48:38'),
 (17,'siva','Employee','menu.jsp','9574Kb','application/octet-stream',0x3C2540207461676C6962207572693D22687474703A2F2F6A6176612E73756E2E636F6D2F6A73702F6A73746C2F636F726522207072656669783D22632220253E0D0A3C2540207461676C6962207572693D22687474703A2F2F7777772E737072696E676672616D65776F726B2E6F72672F746167732F666F726D22207072656669783D22666F726D2220253E0D0A0D0A3C212D2D2053696465626172204E617669676174696F6E2053544152542D2D3E0D0A3C64697620636C6173733D22726F77223E0D0A202020203C64697620636C6173733D22736964652D6D656E7520636F6C2D6D642D3320636F6C2D6C672D33223E202020200D0A20202020202020203C6E617620636C6173733D226E6176626172206E61766261722D64656661756C742220726F6C653D226E617669676174696F6E223E2020200D0A20202020093C212D2D204D61696E204D656E75202D2D3E0D0A20202009093C64697620636C6173733D22736964652D6D656E752D636F6E7461696E6572223E0D0A20202020202020203C756C20636C6173733D226E6176206E61766261722D6E6176223E0D0A2020202020202020203C6C6920636C6173733D2270616E656C2070616E656C2D64656661756C74222069643D2264726F70646F776E223E0D0A202020202020202020202020202020203C6120646174612D746F67676C653D22636F6C6C617073652220687265663D22234D616E75666163747572696E67223E0D0A20202020202020202020202020202020202020203C6920636C6173733D2266612066612D696E647573747279223E3C2F693E204D616E75666163747572696E67203C7370616E20636C6173733D226361726574223E3C2F7370616E3E0D0A202020202020202020202020202020203C2F613E0D0A2020202020202020203C6469762069643D224D616E75666163747572696E672220636C6173733D2270616E656C2D636F6C6C6170736520636F6C6C61707365223E0D0A202020202020202020202020203C64697620636C6173733D2270616E656C2D626F6479223E0D0A202020202020202020202020202020203C756C20636C6173733D226E6176206E61766261722D6E6176223E0D0A2020202020202020202020090909203C6C693E50726F64756374696F6E3C2F6C693E0D0A0909090909202020203C6C693E42696C6C206F66204D6174657269616C733C2F6C693E0D0A0909090909202020203C6C693E546F6F6C733C2F6C693E0D0A0909090909202020203C6C693E53657455703C2F6C693E200D0A0909090909202020203C6C693E5265706F7274733C2F6C693E0D0A0909090909202020203C6C693E48656C703C2F6C693E202020200D0A2020202020202020202020090909203C2F756C3E0D0A20202020202020202020202020202020202020203C2F6469763E0D0A202020202020202020202020202020203C2F6469763E0D0A202020202020202020203C2F6C693E0D0A0909200D0A202020202020202020203C6C693E3C6120687265663D222F54657374416E645265706F727453747564696F2F616464456D706C6F796565223E3C6920636C6173733D2266612066612D75736572223E3C2F693E20456D706C6F7965653C2F613E3C2F6C693E0D0A202020202020202020200D0A202020202020202020203C6C693E3C6120687265663D222F54657374416E645265706F727453747564696F2F706F73223E3C6920636C6173733D2266612066612D73686F7070696E672D63617274223E3C2F693E20504F533C2F613E3C2F6C693E0D0A202020202020202020200D0A202020202020202020203C6C693E3C6120687265663D222F54657374416E645265706F727453747564696F2F6974656D6474223E3C6920636C6173733D2266612066612D70726F647563742D68756E74223E3C2F693E204974656D3C2F613E3C2F6C693E0D0A202020202020202020200D0A202020202020202020203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D68616E642D6F2D7269676874223E3C2F693E20546F446F3C2F613E3C2F6C693E0D0A202020202020202020200D0A202020202020202020203C6C693E3C6120687265663D222F54657374416E645265706F727453747564696F2F637573746F6D6572223E3C6920636C6173733D2266612066612D75736572223E3C2F693E20437573746F6D65723C2F613E3C2F6C693E0D0A202020202020202020200D0A202020202020202020203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D7461736B73223E3C2F693E2050726F6A656374203C2F613E3C2F6C693E0D0A09090D0A093C6C6920636C6173733D2270616E656C2070616E656C2D64656661756C74222069643D2264726F70646F776E223E0D0A202020202020202020202020202020203C6120646174612D746F67676C653D22636F6C6C617073652220687265663D222348756D616E52656F737572636573223E0D0A20202020202020202020202020202020202020203C6920636C6173733D2266612066612D75736572732066612D6C67223E3C2F693E2048756D616E205265736F75726365733C7370616E20636C6173733D226361726574223E3C2F7370616E3E0D0A202020202020202020202020202020203C2F613E0D0A2020202020202020203C6469762069643D2248756D616E52656F7375726365732220636C6173733D2270616E656C2D636F6C6C6170736520636F6C6C61707365223E0D0A202020202020202020202020203C64697620636C6173733D2270616E656C2D626F6479223E0D0A202020202020202020202020202020203C756C20636C6173733D226E6176206E61766261722D6E6176223E0D0A20202020202020202020200909093C6C693E456D706C6F79656520616E6420417474656E64616E63653C2F6C693E0D0A09090909202020203C6C693E526563727569746D656E743C2F6C693E0D0A09090909202020203C6C693E4C656176657320616E6420486F6C696461793C2F6C693E0D0A09090909202020203C6C693E50617920526F6C6C3C2F6C693E200D0A09090909202020203C6C693E457870656E736520436C61696D733C2F6C693E0D0A09090909202020203C6C693E41707072616973616C733C2F6C693E0D0A09090909202020203C6C693E53657455703C2F6C693E0D0A09090909202020203C6C693E5265706F7274733C2F6C693E0D0A09090909202020203C6C693E48656C703C2F6C693E0D0A2020202020202020202020092020203C2F756C3E0D0A202020202020202020202020203C2F6469763E0D0A20202020202020203C2F6469763E0D0A2020202020203C2F6C693E09090D0A2020202020200D0A2020202020203C6C693E3C6120687265663D222F54657374416E645265706F727453747564696F2F66696C656D616E61676572223E3C6920636C6173733D2266612066612D66696C65223E3C2F693E2046696C65204D616E616765723C2F613E3C2F6C693E0D0A09090D0A0920203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D74616773223E3C2F693E2053616C6573204F72646572203C2F613E3C2F6C693E0909200D0A09090D0A0920203C6C693E3C6120687265663D2223223E203C6920636C6173733D2266612066612D75736572223E3C2F693E204C656164203C2F613E3C2F6C693E2009090D0A09090909200D0A0920203C6C6920636C6173733D2270616E656C2070616E656C2D64656661756C74222069643D2264726F70646F776E223E0D0A202020202020202020202020202020203C6120646174612D746F67676C653D22636F6C6C617073652220687265663D2223427579696E67223E0D0A20202020202020202020202020202020202020203C6920636C6173733D2266612066612D73686F7070696E672D63617274223E3C2F693E20427579696E673C7370616E20636C6173733D226361726574223E3C2F7370616E3E0D0A202020202020202020202020202020203C2F613E0D0A2020202020202020203C6469762069643D22427579696E672220636C6173733D2270616E656C2D636F6C6C6170736520636F6C6C61707365223E0D0A202020202020202020202020203C64697620636C6173733D2270616E656C2D626F6479223E0D0A202020202020202020202020202020203C756C20636C6173733D226E6176206E61766261722D6E6176223E0D0A2020202020202020202020090920203C6C693E50757263686173696E673C2F6C693E0D0A0909090920203C6C693E537570706C6965723C2F6C693E0D0A0909090920203C6C693E53657455703C2F6C693E0D0A0909090920203C6C693E4974656D7320616E642050726963696E673C2F6C693E0D0A0909090920203C6C693E416E616C79746963733C2F6C693E0D0A0909090920203C6C693E4F74686572205265706F7274733C2F6C693E0D0A0909090920203C6C693E48656C703C2F6C693E0D0A2020202020202020202020092020203C2F756C3E0D0A202020202020202020202020203C2F6469763E0D0A20202020202020203C2F6469763E0D0A2020202020203C2F6C693E09090D0A202020202020203C6C6920636C6173733D2270616E656C2070616E656C2D64656661756C74222069643D2264726F70646F776E223E0D0A202020202020202020202020202020203C6120646174612D746F67676C653D22636F6C6C617073652220687265663D222353656C6C696E67223E0D0A2020202020202020202020202020202020202020203C6920636C6173733D2266612066612D696E72223E3C2F693E202053656C6C696E67203C7370616E20636C6173733D226361726574223E3C2F7370616E3E0D0A202020202020202020202020202020203C2F613E0D0A2020202020202020203C6469762069643D2253656C6C696E672220636C6173733D2270616E656C2D636F6C6C6170736520636F6C6C61707365223E0D0A202020202020202020202020203C64697620636C6173733D2270616E656C2D626F6479223E0D0A202020202020202020202020202020203C756C20636C6173733D226E6176206E61766261722D6E6176223E0D0A2020202020202020202020090920203C6C693E53616C65733C2F6C693E0D0A0909090920203C6C693E437573746F6D6572733C2F6C693E0D0A0909090920203C6C693E4974656D7320616E642050726963696E673C2F6C693E0D0A0909090920203C6C693E53616C657320706172746E65727320616E64205465727269746F72793C2F6C693E0D0A0909090920203C6C693E53657455703C2F6C693E0D0A0909090920203C6C693E416E616C79746963733C2F6C693E0D0A0909090920203C6C693E4F74686572205265706F7274733C2F6C693E0D0A0909090920203C6C693E48656C703C2F6C693E0D0A2020202020202020202020092020203C2F756C3E0D0A202020202020202020202020203C2F6469763E0D0A20202020202020203C2F6469763E0D0A2020202020203C2F6C693E09090D0A202020202020203C6C6920636C6173733D2270616E656C2070616E656C2D64656661756C74222069643D2264726F70646F776E223E0D0A202020202020202020202020202020203C6120646174612D746F67676C653D22636F6C6C617073652220687265663D222343524D223E0D0A20202020202020202020202020202020202020203C6920636C6173733D2266612066612D66696C652D74657874223E3C2F693E2043524D203C7370616E20636C6173733D226361726574223E3C2F7370616E3E0D0A202020202020202020202020202020203C2F613E0D0A2020202020202020203C6469762069643D2243524D2220636C6173733D2270616E656C2D636F6C6C6170736520636F6C6C61707365223E0D0A202020202020202020202020203C64697620636C6173733D2270616E656C2D626F6479223E0D0A202020202020202020202020202020203C756C20636C6173733D226E6176206E61766261722D6E6176223E0D0A2020202020202020202020090920203C6C693E53616C657320506970656C696E653C2F6C693E0D0A0909090920203C6C693E5265706F7274733C2F6C693E0D0A0909090920203C6C693E436F6D6D756E69636174696F6E3C2F6C693E0D0A0909090920203C6C693E53657455703C2F6C693E0D0A0909090920203C6C693E48656C703C2F6C693E0D0A2020202020202020202020092020203C2F756C3E0D0A202020202020202020202020203C2F6469763E0D0A20202020202020203C2F6469763E0D0A2020202020203C2F6C693E09090D0A2020202020203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D73686F7070696E672D63617274223E3C2F693E205075726368617365204F7264657220203C2F613E3C2F6C693E0D0A2020202020203C6C6920636C6173733D2270616E656C2070616E656C2D64656661756C74222069643D2264726F70646F776E223E0D0A202020202020202020202020202020203C6120646174612D746F67676C653D22636F6C6C617073652220687265663D222350726F6A65637473223E0D0A20202020202020202020202020202020202020203C6920636C6173733D2266612066612D7461736B73223E3C2F693E202050726F6A65637473203C7370616E20636C6173733D226361726574223E3C2F7370616E3E0D0A202020202020202020202020202020203C2F613E0D0A2020202020202020203C6469762069643D2250726F6A656374732220636C6173733D2270616E656C2D636F6C6C6170736520636F6C6C61707365223E0D0A202020202020202020202020203C64697620636C6173733D2270616E656C2D626F6479223E0D0A202020202020202020202020202020203C756C20636C6173733D226E6176206E61766261722D6E6176223E0D0A2020202020202020202020090920203C6C693E50726F6A656374203C2F6C693E0D0A0909090920203C6C693E54696D6520547261636B696E673C2F6C693E0D0A0909090920203C6C693E5265706F7274733C2F6C693E0D0A0909090920203C6C693E48656C703C2F6C693E0D0A2020202020202020202020092020203C2F756C3E0D0A202020202020202020202020203C2F6469763E0D0A20202020202020203C2F6469763E0D0A2020202020203C2F6C693E09090D0A202020202020203C6C6920636C6173733D2270616E656C2070616E656C2D64656661756C74222069643D2264726F70646F776E223E0D0A202020202020202020202020202020203C6120646174612D746F67676C653D22636F6C6C617073652220687265663D222353757070706F7274223E0D0A20202020202020202020202020202020202020203C6920636C6173733D2266612066612D6C6966652D72696E67223E3C2F693E2020537570706F7274203C7370616E20636C6173733D226361726574223E3C2F7370616E3E0D0A202020202020202020202020202020203C2F613E0D0A2020202020202020203C6469762069643D22537570706F72742220636C6173733D2270616E656C2D636F6C6C6170736520636F6C6C61707365223E0D0A202020202020202020202020203C64697620636C6173733D2270616E656C2D626F6479223E0D0A202020202020202020202020202020203C756C20636C6173733D226E6176206E61766261722D6E6176223E0D0A20202020202020202020200909203C6C693E4973737565733C2F6C693E0D0A0909090920203C6C693E57617272616E74793C2F6C693E0D0A0909090920203C6C693E5265706F7274733C2F6C693E0D0A2020202020202020202020092020203C2F756C3E0D0A202020202020202020202020203C2F6469763E0D0A20202020202020203C2F6469763E0D0A2020202020203C2F6C693E090D0A2020202020203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D696E647573747279223E3C2F693E2050726F64756374696F6E204F72646572203C2F613E3C2F6C693E090D0A2020202020203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D757364223E3C2F693E20424F4D203C2F613E3C2F6C693E0D0A202020202020203C6C6920636C6173733D2270616E656C2070616E656C2D64656661756C74222069643D2264726F70646F776E223E0D0A202020202020202020202020202020203C6120646174612D746F67676C653D22636F6C6C617073652220687265663D222353746F636B223E0D0A20202020202020202020202020202020202020203C6920636C6173733D2266612066612D6461746162617365223E3C2F693E2053746F636B203C7370616E20636C6173733D226361726574223E3C2F7370616E3E0D0A202020202020202020202020202020203C2F613E0D0A2020202020202020203C6469762069643D2253746F636B2220636C6173733D2270616E656C2D636F6C6C6170736520636F6C6C61707365223E0D0A202020202020202020202020203C64697620636C6173733D2270616E656C2D626F6479223E0D0A202020202020202020202020202020203C756C20636C6173733D226E6176206E61766261722D6E6176223E0D0A2020202020202020202020090920203C6C693E53746F636B205472616E73616374696F6E733C2F6C693E0D0A0909090920203C6C693E53746F636B205265706F7274733C2F6C693E0D0A0909090920203C6C693E4974656D7320616E642050726963696E673C2F6C693E0D0A0909090920203C6C693E53657269616C206E6F20616E642042617463683C2F6C693E0D0A0909090920203C6C693E546F6F6C733C2F6C693E0D0A0909090920203C6C693E53657455703C2F6C693E0D0A0909090920203C6C693E416E616C79746963733C2F6C693E0D0A0909090920203C6C693E5265706F7274733C2F6C693E0D0A0909090920203C6C693E48656C703C2F6C693E0D0A2020202020202020202020092020203C2F756C3E0D0A202020202020202020202020203C2F6469763E0D0A20202020202020203C2F6469763E0D0A2020202020203C2F6C693E090D0A092020203C6C6920636C6173733D2270616E656C2070616E656C2D64656661756C74222069643D2264726F70646F776E223E0D0A202020202020202020202020202020203C6120646174612D746F67676C653D22636F6C6C617073652220687265663D2223546F6F6C73223E0D0A20202020202020202020202020202020202020203C6920636C6173733D2266612066612D7772656E6368223E3C2F693E20546F6F6C73203C7370616E20636C6173733D226361726574223E3C2F7370616E3E0D0A202020202020202020202020202020203C2F613E0D0A2020202020202020203C6469762069643D22546F6F6C732220636C6173733D2270616E656C2D636F6C6C6170736520636F6C6C61707365223E0D0A202020202020202020202020203C64697620636C6173733D2270616E656C2D626F6479223E0D0A202020202020202020202020202020203C756C20636C6173733D226E6176206E61766261722D6E6176223E0D0A20202020202020202020200909203C6C693E546F6F6C733C2F6C693E0D0A2020202020202020202020092020203C2F756C3E0D0A202020202020202020202020203C2F6469763E0D0A20202020202020203C2F6469763E0D0A2020202020203C2F6C693E090D0A202020202020203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D75736572223E3C2F693E20537570706C696572203C2F613E3C2F6C693E0D0A0920203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D7175657374696F6E223E3C2F693E204973737565203C2F613E3C2F6C693E09090D0A0920203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D6461746162617365223E3C2F693E2053746F636B20456E747279203C2F613E3C2F6C693E200D0A0920203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D706C7573223E3C2F693E2050726F66697420616E64204C6F73732053746174656D656E74203C2F613E3C2F6C693E090D0A0920203C6C693E3C6120687265663D222F54657374416E645265706F727453747564696F2F6164647461736B223E3C6920636C6173733D2266612066612D7461736B73223E3C2F693E205461736B203C2F613E3C2F6C693E0D0A0920203C6C6920636C6173733D2270616E656C2070616E656C2D64656661756C74222069643D2264726F70646F776E223E0D0A202020202020202020202020202020203C6120646174612D746F67676C653D22636F6C6C617073652220687265663D22234C6561726E223E0D0A20202020202020202020202020202020202020203C6920636C6173733D2266612066612D626F6F6B223E3C2F693E204C6561726E203C7370616E20636C6173733D226361726574223E3C2F7370616E3E0D0A202020202020202020202020202020203C2F613E0D0A2020202020202020203C6469762069643D224C6561726E2220636C6173733D2270616E656C2D636F6C6C6170736520636F6C6C61707365223E0D0A202020202020202020202020203C64697620636C6173733D2270616E656C2D626F6479223E0D0A202020202020202020202020202020203C756C20636C6173733D226E6176206E61766261722D6E6176223E0D0A2020202020202020202020090920203C6C693E47656E6572616C3C2F6C693E0D0A0909090920203C6C693E53657455703C2F6C693E0D0A0909090920203C6C693E4163636F756E74733C2F6C693E0D0A0909090920203C6C693E43524D3C2F6C693E0D0A0909090920203C6C693E53656C6C696E673C2F6C693E0D0A0909090920203C6C693E53746F636B3C2F6C693E0D0A0909090920203C6C693E427579696E673C2F6C693E0D0A0909090920203C6C693E4D616E75666163747572696E673C2F6C693E0D0A0909090920203C6C693E48756D616E205265736F757263653C2F6C693E0D0A0909090920203C6C693E50726F6A656374733C2F6C693E0D0A0909090920203C6C693E576562736974653C2F6C693E0D0A2020202020202020202020092020203C2F756C3E0D0A202020202020202020202020203C2F6469763E0D0A20202020202020203C2F6469763E0D0A2020202020203C2F6C693E090D0A2020202020203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D696E72223E3C2F693E204275646765742056617269616E6365205265706F72743C2F613E3C2F6C693E0D0A0920203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D636C6F636B2D6F223E3C2F693E204461696C792054696D652D73686565742053756D6D6172793C2F613E3C2F6C693E090D0A0920203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D72656769737465726564223E3C2F693E204974656D20576973652053616C65732052656769737465723C2F613E3C2F6C693E0D0A0920203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D6261722D6368617274223E3C2F693E204974656D205265706F72743C2F613E3C2F6C693E090D0A0920203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D75736572223E3C2F693E20437573746F6D6572205265706F72743C2F613E3C2F6C693E090D0A0920203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D66696C65223E3C2F693E2046696C653C2F613E3C2F6C693E0D0A0920203C6C6920636C6173733D2270616E656C2070616E656C2D64656661756C74222069643D2264726F70646F776E223E0D0A202020202020202020202020202020203C6120646174612D746F67676C653D22636F6C6C617073652220687265663D22234163636F756E7473223E0D0A20202020202020202020202020202020202020203C6920636C6173733D2266612066612D75736572223E3C2F693E204163636F756E7473203C7370616E20636C6173733D226361726574223E3C2F7370616E3E0D0A202020202020202020202020202020203C2F613E0D0A2020202020202020203C6469762069643D224163636F756E74732220636C6173733D2270616E656C2D636F6C6C6170736520636F6C6C61707365223E0D0A202020202020202020202020203C64697620636C6173733D2270616E656C2D626F6479223E0D0A202020202020202020202020202020203C756C20636C6173733D226E6176206E61766261722D6E6176223E0D0A2020202020202020202020090920203C6C693E42696C6C696E673C2F6C693E0D0A0909090920203C6C693E436F6D70616E7920616E64204163636F756E74733C2F6C693E0D0A0909090920203C6C693E4D6173746572733C2F6C693E0D0A0909090920203C6C693E4163636F756E74696E672053746174656D656E74733C2F6C693E0D0A0909090920203C6C693E42616E6B696E67205061796D656E74733C2F6C693E0D0A0909090920203C6C693E54617865733C2F6C693E0D0A0909090920203C6C693E42756467657420616E6420436F73742043656E7465723C2F6C693E0D0A0909090920203C6C693E546F6F6C733C2F6C693E0D0A0909090920203C6C693E53657455703C2F6C693E0D0A0909090920203C6C693E546F2042696C6C3C2F6C693E0D0A0909090920203C6C693E416E616C79746963733C2F6C693E0D0A0909090920203C6C693E4F74686572205265706F7274733C2F6C693E0D0A0909090920203C6C693E2048656C703C2F6C693E0D0A2020202020202020202020092020203C2F756C3E0D0A202020202020202020202020203C2F6469763E0D0A20202020202020203C2F6469763E0D0A2020202020203C2F6C693E090D0A2020202020203C6C693E3C6120687265663D2223223E3C6920636C6173733D2266612066612D657870616E64223E3C2F693E204578706C6F7265203C2F613E3C2F6C693E0D0A20202020203C2F756C3E0D0A202020203C2F6469763E3C212D2D202F2E6E61766261722D636F6C6C61707365202D2D3E0D0A3C2F6E61763E0D0A3C2F6469763E2020200D0A3C2F6469763E0D0A0D0A0D0A0D0A0909090920,'2016-10-01 01:49:08'),
 (18,'siva','Employee','New Project 20161016','87165Kb','application/octet-stream',0x2D2D204D7953514C2041646D696E6973747261746F722064756D7020312E340A2D2D0A2D2D202D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D0A2D2D205365727665722076657273696F6E09352E352E390A0A0A2F2A2134303130312053455420404F4C445F4348415241435445525F5345545F434C49454E543D40404348415241435445525F5345545F434C49454E54202A2F3B0A2F2A2134303130312053455420404F4C445F4348415241435445525F5345545F524553554C54533D40404348415241435445525F5345545F524553554C5453202A2F3B0A2F2A2134303130312053455420404F4C445F434F4C4C4154494F4E5F434F4E4E454354494F4E3D4040434F4C4C4154494F4E5F434F4E4E454354494F4E202A2F3B0A2F2A21343031303120534554204E414D45532075746638202A2F3B0A0A2F2A2134303031342053455420404F4C445F554E495155455F434845434B533D4040554E495155455F434845434B532C20554E495155455F434845434B533D30202A2F3B0A2F2A2134303031342053455420404F4C445F464F524549474E5F4B45595F434845434B533D4040464F524549474E5F4B45595F434845434B532C20464F524549474E5F4B45595F434845434B533D30202A2F3B0A2F2A2134303130312053455420404F4C445F53514C5F4D4F44453D404053514C5F4D4F44452C2053514C5F4D4F44453D274E4F5F4155544F5F56414C55455F4F4E5F5A45524F27202A2F3B0A0A0A2D2D0A2D2D2043726561746520736368656D612074657374616E647265706F72740A2D2D0A0A435245415445204441544142415345204946204E4F54204558495354532074657374616E647265706F72743B0A5553452074657374616E647265706F72743B0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606163636F756E747372656365697661626C653030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606163636F756E747372656365697661626C653030316D62603B0A435245415445205441424C4520606163636F756E747372656365697661626C653030316D626020280A20206069646020696E742831302920756E7369676E6564204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060706F7374696E676461746560207661726368617228343529204E4F54204E554C4C2C0A202060637573746F6D657260207661726368617228343529204E4F54204E554C4C2C0A202060766F75636865727479706560207661726368617228343529204E4F54204E554C4C2C0A202060766F75636865726E6F60207661726368617228343529204E4F54204E554C4C2C0A2020606475656461746560207661726368617228343529204E4F54204E554C4C2C0A202060696E766F69636564616D6F756E746020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A20206070616964616D6F756E746020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A2020606F75747374616E64696E67616D6F756E746020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A2020606167656020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A2020607570746F7468697274796020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A2020607570746F73697874796020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A2020607570746F6E696E6574796020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A2020606E696E65747961626F76656020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A20206063757272656E637960207661726368617228343529204E4F54204E554C4C2C0A2020607465727269746F727960207661726368617228343529204E4F54204E554C4C2C0A20206072656D61726B7360207661726368617228343529204E4F54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D372044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606163636F756E747372656365697661626C653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606163636F756E747372656365697661626C653030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606163636F756E747372656365697661626C653030316D62602028606964602C60706F7374696E6764617465602C60637573746F6D6572602C60766F756368657274797065602C60766F75636865726E6F602C6064756564617465602C60696E766F69636564616D6F756E74602C6070616964616D6F756E74602C606F75747374616E64696E67616D6F756E74602C60616765602C607570746F746869727479602C607570746F7369787479602C607570746F6E696E657479602C606E696E65747961626F7665602C6063757272656E6379602C607465727269746F7279602C6072656D61726B7360292056414C554553200A2028312C2731302D31302D32303136272C276D6974687261272C27766F7563686572272C27766F7563686572272C2732302D31302D32303136272C3130302C3130302C3130302C32302C352C362C372C382C27313030272C277465727269746F7279272C2772656D61726B7327292C0A2028322C2731342F31302F32303136272C276D617961272C27766F7563686572272C27766F7563686572272C2730352F31302F32303136272C3130302C3130302C3130302C32352C352C382C342C392C277275706565272C277465727269746F7279272C27676F6F6427292C0A2028362C2731352F31302F32303136272C276D617961272C27766F7563686572272C27766F7563686572272C2730362F31302F32303136272C3130302C3130302C3130302C322C31302C31302C31302C31302C275255504545272C277465727269746F7279272C27676F6F6427293B0A2F2A21343030303020414C544552205441424C4520606163636F756E747372656365697661626C653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206061707072616973616C3030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206061707072616973616C3030316D62603B0A435245415445205441424C45206061707072616973616C3030316D626020280A2020606170707249646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206073657269657360207661726368617228333029204E4F54204E554C4C2C0A20206061707072616973616C54656D70602076617263686172283430292044454641554C54204E554C4C2C0A20205052494D415259204B455920286061707072496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D332044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206061707072616973616C3030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206061707072616973616C3030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206061707072616973616C3030316D6260202860617070724964602C60736572696573602C6061707072616973616C54656D7060292056414C554553200A2028312C275345525F303031272C274D6F64655F3127292C0A2028322C275345525F303032272C274C545427293B0A2F2A21343030303020414C544552205441424C45206061707072616973616C3030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606170707274656D703030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606170707274656D703030316D62603B0A435245415445205441424C4520606170707274656D703030316D626020280A202060617070746D7049646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206061707072616973616C54656D7060207661726368617228343029204E4F54204E554C4C2C0A2020606465736372697074696F6E60207661726368617228313030292044454641554C54204E554C4C2C0A20205052494D415259204B4559202860617070746D70496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D332044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606170707274656D703030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606170707274656D703030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606170707274656D703030316D6260202860617070746D704964602C6061707072616973616C54656D70602C606465736372697074696F6E60292056414C554553200A2028312C274D6F64655F31272C274861726420576F726B27292C0A2028322C274C5454272C2746756C6C20417474656E64616E636527293B0A2F2A21343030303020414C544552205441424C4520606170707274656D703030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206061737365743030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206061737365743030316D62603B0A435245415445205441424C45206061737365743030316D626020280A20206069646020696E742831302920756E7369676E6564204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060617373657460207661726368617228343529204E4F54204E554C4C2C0A202060646570726563696174696F6E6461746560207661726368617228343529204E4F54204E554C4C2C0A2020607075726368617365616D6F756E746020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A202060646570726563696174696F6E616D6F756E746020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A202060616363756D756C61746564646570726563696174696F6E616D6F756E746020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A202060616D6F756E746166746572646570726563696174696F6E6020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A202060646570726563696174696F6E656E74727960207661726368617228343529204E4F54204E554C4C2C0A202060617373657463617465676F727960207661726368617228343529204E4F54204E554C4C2C0A20206063757272656E7473746174757360207661726368617228343529204E4F54204E554C4C2C0A202060646570726563696174696F6E6D6574686F6460207661726368617228343529204E4F54204E554C4C2C0A20206070757263686173656461746560207661726368617228343529204E4F54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D332044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206061737365743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206061737365743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206061737365743030316D62602028606964602C606173736574602C60646570726563696174696F6E64617465602C607075726368617365616D6F756E74602C60646570726563696174696F6E616D6F756E74602C60616363756D756C61746564646570726563696174696F6E616D6F756E74602C60616D6F756E746166746572646570726563696174696F6E602C60646570726563696174696F6E656E747279602C60617373657463617465676F7279602C6063757272656E74737461747573602C60646570726563696174696F6E6D6574686F64602C6070757263686173656461746560292056414C554553200A2028322C274173736574272C2731302F31312F32303136272C3130302C3130302C3130302C3130302C276173736574272C276173736574272C27535441545553272C276465707263272C2731302F32372F3230313627293B0A2F2A21343030303020414C544552205441424C45206061737365743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060626F6D3030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060626F6D3030316D62603B0A435245415445205441424C452060626F6D3030316D626020280A20206069646020696E742831302920756E7369676E6564204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060626F6D60207661726368617228343529204E4F54204E554C4C2C0A2020607479706560207661726368617228343529204E4F54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D32332044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060626F6D3030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060626F6D3030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060626F6D3030316D62602028606964602C60626F6D602C607479706560292056414C554553200A2028312C27424F4D202D2057696E646D696C6C204120736572696573272C27424F4D27292C0A2028322C27424F4D202D2042656172696E6720417373656D626C79272C27424F4D27292C0A2028332C27424F4D202D2057696E67205368656574272C27424F4D27292C0A2028342C27424F4D202D204261736520506C617465272C27424F4D27292C0A2028352C27424F4D202D2057696E642054757262696E65202D2053303031272C27424F4D27292C0A2028362C27424F4D202D20426173652042656172696E6720506C61746520303031272C27424F4D27292C0A2028372C27424F4D202D20426173652042656172696E6720506C61746520303032272C27424F4D27292C0A2028382C27424F4D202D2057696E642054757262696E65202D2053303032272C27424F4D27292C0A2028392C27424F4D202D2057696E646D696C6C204220736572696573272C27424F4D27292C0A202831302C27424F4D202D2057696E642054757262696E65202D2053303031272C27424F4D27292C0A202831312C27424F4D202D2057696E646D696C6C204220736572696573272C27424F4D27292C0A202831322C27424F4D202D2057696E646D696C6C204220736572696573272C27424F4D27292C0A202831332C27424F4D202D2057696E646D696C6C204220736572696573272C27424F4D27292C0A202831342C27424F4D202D204261736520506C617465272C27424F4D27292C0A202831352C27424F4D202D2057696E67205368656574272C27424F4D27292C0A202831362C27424F4D202D2057696E646D696C6C204220736572696573272C27424F4D27292C0A202831372C27424F4D202D2057696E642054757262696E65202D2053303031272C27424F4D2027292C0A202831382C27424F4D202D2057696E646D696C6C204220736572696573272C27424F4D2027292C0A202831392C27424F4D202D2057696E642054757262696E65202D2053303031272C27424F4D2027292C0A202832302C27424F4D202D2057696E642054757262696E65202D2053303031272C27424F4D2027292C0A202832312C27424F4D20272C27424F4D2027292C0A202832322C27424F4D20272C27424F4D2027293B0A2F2A21343030303020414C544552205441424C452060626F6D3030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060626F6D747970653030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060626F6D747970653030316D62603B0A435245415445205441424C452060626F6D747970653030316D626020280A202060626F6D49646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060626F6D4E616D656020766172636861722831303029204E4F54204E554C4C2C0A202060626F6D54797065602076617263686172283430292044454641554C54204E554C4C2C0A20205052494D415259204B4559202860626F6D496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D342044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060626F6D747970653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060626F6D747970653030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060626F6D747970653030316D6260202860626F6D4964602C60626F6D4E616D65602C60626F6D5479706560292056414C554553200A2028312C27424F4D2D57696E644D696C6C5365726965732D303031272C27424F4D27292C0A2028322C27424F4D2D57696E644D696C6C5365726965732D303033272C27424F4D27293B0A2F2A21343030303020414C544552205441424C452060626F6D747970653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606272616E63683030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606272616E63683030316D62603B0A435245415445205441424C4520606272616E63683030316D626020280A2020606272616E636849646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606272616E63684E616D6560207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B45592028606272616E6368496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D342044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606272616E63683030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606272616E63683030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606272616E63683030316D62602028606272616E63684964602C606272616E63684E616D6560292056414C554553200A2028312C27435327292C0A2028332C27436865636B657227293B0A2F2A21343030303020414C544552205441424C4520606272616E63683030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060636F6D7070726F646F726465723030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060636F6D7070726F646F726465723030316D62603B0A435245415445205441424C452060636F6D7070726F646F726465723030316D626020280A20206070726F6449646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206070726F72646572436F646560207661726368617228333029204E4F54204E554C4C2C0A2020606461746560207661726368617228333029204E4F54204E554C4C2C0A2020606974656D746F4D616E756661637475726560207661726368617228343029204E4F54204E554C4C2C0A202060746F50726F64756365602076617263686172283330292044454641554C54204E554C4C2C0A20206070726F647563656460207661726368617228333029204E4F54204E554C4C2C0A202060656D70436F6D70616E7960207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B455920286070726F64496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D332044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060636F6D7070726F646F726465723030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060636F6D7070726F646F726465723030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060636F6D7070726F646F726465723030316D626020286070726F644964602C6070726F72646572436F6465602C6064617465602C606974656D746F4D616E7566616374757265602C60746F50726F64756365602C6070726F6475636564602C60656D70436F6D70616E7960292056414C554553200A2028312C2750524F5F3030303834272C2731302F32302F32303136272C2742616C6C65657474272C273130272C2736272C2744656C6C27293B0A2F2A21343030303020414C544552205441424C452060636F6D7070726F646F726465723030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060637573746F6D65726163717569736974696F6E3030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060637573746F6D65726163717569736974696F6E3030316D62603B0A435245415445205441424C452060637573746F6D65726163717569736974696F6E3030316D626020280A20206069646020696E742831302920756E7369676E6564204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060796561726020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A2020606D6F6E746860207661726368617228343529204E4F54204E554C4C2C0A2020606E6577637573746F6D6572736020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A202060726570656174637573746F6D6572736020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A202060746F74616C6020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A2020606E6577637573746F6D657273726576656E756560206D656469756D74657874204E4F54204E554C4C2C0A202060726570656174637573746F6D657273726576656E756560206D656469756D74657874204E4F54204E554C4C2C0A202060746F74616C726576656E756560206D656469756D74657874204E4F54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D322044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060637573746F6D65726163717569736974696F6E3030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060637573746F6D65726163717569736974696F6E3030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060637573746F6D65726163717569736974696F6E3030316D62602028606964602C6079656172602C606D6F6E7468602C606E6577637573746F6D657273602C60726570656174637573746F6D657273602C60746F74616C602C606E6577637573746F6D657273726576656E7565602C60726570656174637573746F6D657273726576656E7565602C60746F74616C726576656E756560292056414C554553200A2028312C323030352C276A616E272C312C312C322C27313030272C27313030272C2733303027293B0A2F2A21343030303020414C544552205441424C452060637573746F6D65726163717569736974696F6E3030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060637573746F6D657263726564697462616C616E63653030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060637573746F6D657263726564697462616C616E63653030316D62603B0A435245415445205441424C452060637573746F6D657263726564697462616C616E63653030316D626020280A202060636369646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060637573746F6D6572602076617263686172283435292044454641554C54204E554C4C2C0A2020606372656469746C696D697460206D656469756D74657874204E4F54204E554C4C2C0A2020606F75747374616E64696E67616D6F756E7460206D656469756D74657874204E4F54204E554C4C2C0A20206063726564697462616C616E636560206D656469756D74657874204E4F54204E554C4C2C0A20206069646020696E7428313129204E4F54204E554C4C2C0A202060437573746F6D65726E616D65602076617263686172283430292044454641554C54204E554C4C2C0A20205052494D415259204B45592028606363696460292C0A20204B45592060696460202860696460292C0A2020434F4E53545241494E542060637573746F6D657263726564697462616C616E63653030316D625F6962666B5F316020464F524549474E204B455920286069646029205245464552454E4345532060637573746F6D657264657461696C733030316D6260202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D31312044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060637573746F6D657263726564697462616C616E63653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060637573746F6D657263726564697462616C616E63653030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060637573746F6D657263726564697462616C616E63653030316D626020286063636964602C60637573746F6D6572602C606372656469746C696D6974602C606F75747374616E64696E67616D6F756E74602C6063726564697462616C616E6365602C606964602C60437573746F6D65726E616D6560292056414C554553200A2028312C276D617961272C27313030272C27323030272C2731303030272C322C274468696B73686127292C0A202831302C4E554C4C2C2731303030272C27323030272C27313030272C342C276972696E27293B0A2F2A21343030303020414C544552205441424C452060637573746F6D657263726564697462616C616E63653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060637573746F6D657264657461696C733030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060637573746F6D657264657461696C733030316D62603B0A435245415445205441424C452060637573746F6D657264657461696C733030316D626020280A20206069646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060637573746F6D6572696460207661726368617228343529204E4F54204E554C4C2C0A202060637573746F6D65726E616D6560207661726368617228343529204E4F54204E554C4C2C0A202060637573746F6D657267726F757060207661726368617228343529204E4F54204E554C4C2C0A202060616464726573736C696E653160207661726368617228343529204E4F54204E554C4C2C0A202060616464726573736C696E653260207661726368617228343529204E4F54204E554C4C2C0A2020606369747960207661726368617228343529204E4F54204E554C4C2C0A202060737461746560207661726368617228343529204E4F54204E554C4C2C0A202060706F7374616C636F646560207661726368617228343529204E4F54204E554C4C2C0A202060636F756E74727960207661726368617228343529204E4F54204E554C4C2C0A20206069737072696D61727961646472657373602074696E79696E74283129204E4F54204E554C4C2C0A20206066697273746E616D6560207661726368617228343529204E4F54204E554C4C2C0A2020606C6173746E616D6560207661726368617228343529204E4F54204E554C4C2C0A20206070686F6E6560207661726368617228343529204E4F54204E554C4C2C0A2020606D6F62696C656E756D62657260207661726368617228343529204E4F54204E554C4C2C0A202060656D61696C696460207661726368617228343529204E4F54204E554C4C2C0A20206069737072696D617279636F6E74616374602074696E79696E74283429204E4F54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D352044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060637573746F6D657264657461696C733030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060637573746F6D657264657461696C733030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060637573746F6D657264657461696C733030316D62602028606964602C60637573746F6D65726964602C60637573746F6D65726E616D65602C60637573746F6D657267726F7570602C60616464726573736C696E6531602C60616464726573736C696E6532602C6063697479602C607374617465602C60706F7374616C636F6465602C60636F756E747279602C6069737072696D61727961646472657373602C6066697273746E616D65602C606C6173746E616D65602C6070686F6E65602C606D6F62696C656E756D626572602C60656D61696C6964602C6069737072696D617279636F6E7461637460292056414C554553200A2028312C274B543031272C274D6974687261272C27514153272C274368656E6E6169272C274368656E6E6169272C274368656E6E6169272C2754616D696C6E616475272C27363030303238272C27494E444941272C312C274D6974687261272C2756272C27313233343536373839272C27313233343536373839272C276D6974687261272C31292C0A2028322C274B543032272C274468696B736861272C27514153272C274D616475726169272C274D616475726169272C274D616475726169272C2754616D696C6E616475272C27363030303030272C27494E444941272C312C274468696B736861272C2747272C2731353234333637272C27313432353336272C276468696B617368272C31292C0A2028332C274B543033272C2773686161736861272C27514153272C276368656E6E6169272C276368656E6E6169272C276368656E6E6169272C27544E272C27363030303030272C27494E444941272C312C2773686161736861272C2773686161736861272C2731323335363832272C2731323435363339272C2773686161736861676D61696C272C31292C0A2028342C274B543034272C276972696E272C27272C276368656E6169272C276368656E6E6169272C276368656E6E6169272C27746E272C2734303030272C27696E646961272C312C276A6A272C276A6A272C273135343231272C2734353233272C27676D61696C272C30293B0A2F2A21343030303020414C544552205441424C452060637573746F6D657264657461696C733030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606461696C7974696D6573686565743030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606461696C7974696D6573686565743030316D62603B0A435245415445205441424C4520606461696C7974696D6573686565743030316D626020280A20206069646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206074696D65736865657460207661726368617228343529204E4F54204E554C4C2C0A202060656D706C6F79656560207661726368617228343529204E4F54204E554C4C2C0A202060656D706C6F7965656E616D6560207661726368617228343529204E4F54204E554C4C2C0A20206066726F6D6461746574696D6560207661726368617228353029204E4F54204E554C4C2C0A202060746F6461746574696D6560207661726368617228353029204E4F54204E554C4C2C0A202060686F75727360207661726368617228353029204E4F54204E554C4C2C0A20206061637469766974797479706560207661726368617228353029204E4F54204E554C4C2C0A2020607461736B60207661726368617228353029204E4F54204E554C4C2C0A20206070726F6A65637460207661726368617228343529204E4F54204E554C4C2C0A20206073746174757360207661726368617228353029204E4F54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D342044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606461696C7974696D6573686565743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606461696C7974696D6573686565743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606461696C7974696D6573686565743030316D62602028606964602C6074696D657368656574602C60656D706C6F796565602C60656D706C6F7965656E616D65602C6066726F6D6461746574696D65602C60746F6461746574696D65602C60686F757273602C60616374697669747974797065602C607461736B602C6070726F6A656374602C6073746174757360292056414C554553200A2028322C2774696D657368656574272C27454D505F30362C32272C27486172697368272C2731302F30372F32303136272C2731302F31322F32303136272C2738687273272C2774657374696E67272C27496E74656C6C6F722054657374696E67272C277665726961746F272C276F70656E27292C0A2028332C2774696D657368656574272C27454D505F30362C32272C27486172697368272C2731302F31322F32303136272C2731302F31332F32303136272C273820687273272C2774657374696E67272C27496E74656C6C6F722054657374696E67272C27496E74656C6C6F72272C27696E69746174656427293B0A2F2A21343030303020414C544552205441424C4520606461696C7974696D6573686565743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606465706172746D656E743030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606465706172746D656E743030316D62603B0A435245415445205441424C4520606465706172746D656E743030316D626020280A2020606465707469646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060646570744E616D6560207661726368617228323535292044454641554C54204E554C4C2C0A20205052494D415259204B455920286064657074696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D31322044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606465706172746D656E743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606465706172746D656E743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606465706172746D656E743030316D6260202860646570746964602C60646570744E616D6560292056414C554553200A2028312C274C6567616C27292C0A2028322C274D61726B6574696E67204163636F756E747327292C0A2028332C275265736561726368202620446576656C6F706D656E7427292C0A2028342C275175616C697479204D616E6167656D656E7427292C0A2028362C274D616E6167656D656E7427292C0A2028372C2748756D616E205265736F757263657327292C0A2028382C27437573746F6D6572205365727669636527292C0A2028392C27446973706174636827292C0A202831302C2750726F64756374696F6E27292C0A202831312C274F7065726174696F6E7327293B0A2F2A21343030303020414C544552205441424C4520606465706172746D656E743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206064657369676E6174696F6E3030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206064657369676E6174696F6E3030316D62603B0A435245415445205441424C45206064657369676E6174696F6E3030316D626020280A20206064657369676E49646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206064657369676E6174696F6E60207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B455920286064657369676E496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D332044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206064657369676E6174696F6E3030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206064657369676E6174696F6E3030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206064657369676E6174696F6E3030316D626020286064657369676E4964602C6064657369676E6174696F6E60292056414C554553200A2028312C2750726F6A656374204D616E6167657227292C0A2028322C275265736561726368657227293B0A2F2A21343030303020414C544552205441424C45206064657369676E6174696F6E3030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060656D70617474656E64616E63653030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060656D70617474656E64616E63653030316D62603B0A435245415445205441424C452060656D70617474656E64616E63653030316D626020280A20206049646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060734E6F6020696E74283131292044454641554C54204E554C4C2C0A202060656D704E756D626572602076617263686172283330292044454641554C54204E554C4C2C0A202060636C54616B656E602076617263686172283230292044454641554C54204E554C4C2C0A202060636C42616C616E6365602076617263686172283230292044454641554C54204E554C4C2C0A202060636F6D706F666654616B656E602076617263686172283230292044454641554C54204E554C4C2C0A202060636F6D706F666642616C616E6365602076617263686172283230292044454641554C54204E554C4C2C0A2020606C77746F75747054616B656E602076617263686172283230292044454641554C54204E554C4C2C0A2020606C77746F75747042616C616E6365602076617263686172283230292044454641554C54204E554C4C2C0A2020606D746C7654616B656E602076617263686172283230292044454641554C54204E554C4C2C0A2020606D746C7642616C616E6365602076617263686172283230292044454641554C54204E554C4C2C0A20206070747954616B656E602076617263686172283230292044454641554C54204E554C4C2C0A20206070747942616C616E6365602076617263686172283230292044454641554C54204E554C4C2C0A2020607076676C7654616B656E602076617263686172283230292044454641554C54204E554C4C2C0A2020607076676C7642616C616E6365602076617263686172283230292044454641554C54204E554C4C2C0A202060736B6C7654616B656E602076617263686172283230292044454641554C54204E554C4C2C0A202060736B6C42616C616E6365602076617263686172283230292044454641554C54204E554C4C2C0A202060766354616B656E602076617263686172283230292044454641554C54204E554C4C2C0A202060766342616C616E6365602076617263686172283230292044454641554C54204E554C4C2C0A202060736B6C7642616C616E636560207661726368617228323535292044454641554C54204E554C4C2C0A202060656D704E616D6560207661726368617228323535292044454641554C54204E554C4C2C0A202060646570744E616D6560207661726368617228323535292044454641554C54204E554C4C2C0A20205052494D415259204B4559202860496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D34322044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060656D70617474656E64616E63653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060656D70617474656E64616E63653030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060656D70617474656E64616E63653030316D62602028604964602C60734E6F602C60656D704E756D626572602C60636C54616B656E602C60636C42616C616E6365602C60636F6D706F666654616B656E602C60636F6D706F666642616C616E6365602C606C77746F75747054616B656E602C606C77746F75747042616C616E6365602C606D746C7654616B656E602C606D746C7642616C616E6365602C6070747954616B656E602C6070747942616C616E6365602C607076676C7654616B656E602C607076676C7642616C616E6365602C60736B6C7654616B656E602C60736B6C42616C616E6365602C60766354616B656E602C60766342616C616E6365602C60736B6C7642616C616E6365602C60656D704E616D65602C60646570744E616D6560292056414C554553200A202833322C4E554C4C2C27454D505F3032272C2732272C2734272C2732272C2731272C2731272C2730272C2731272C2731272C2732272C2731272C2731272C2731272C2732272C4E554C4C2C2731272C2731272C2734272C274D616E696B616E64616E272C274C6567616C27292C0A202833332C4E554C4C2C27454D505F3036272C2731272C2731272C2730272C2731272C2732272C2731272C2731272C2731272C2731272C2732272C2731272C2732272C2731272C4E554C4C2C2731272C2730272C2731272C272044696B6D616E20536865727661736869647A6520536865727661736869647A65272C274D61726B6574696E67204163636F756E747327292C0A202833342C4E554C4C2C27454D505F303131272C2733272C2731272C2731272C2731272C2731272C2731272C2731272C2731272C2731272C2731272C2731272C2731272C2731272C4E554C4C2C2730272C2732272C2731272C275A756B7574616B69746F74656B61272C275265736561726368202620446576656C6F706D656E7427292C0A202833352C4E554C4C2C27454D505F3037272C2732272C2731272C2731272C2732272C2731272C2731272C2731272C2731272C2731272C2730272C2731272C2732272C2732272C4E554C4C2C2732272C2732272C2732272C27486174737565204B6173686977616769272C275175616C697479204D616E6167656D656E7427292C0A202833362C4E554C4C2C27454D505F3034272C2735272C2732272C2732272C2731272C2732272C2732272C2732272C2732272C2731272C2731272C2731272C2731272C2732272C4E554C4C2C2731272C2731272C2731272C274E7572616E205665726B6C65696A272C274D616E6167656D656E7427292C0A202833372C4E554C4C2C27454D505F3033272C2731272C2732272C2731272C2730272C2732272C2731272C2732272C2731272C2732272C2731272C2732272C2731272C2732272C4E554C4C2C2732272C2731272C2731272C2754696C6465204C696E647176697374272C2748756D616E205265736F757263657327292C0A202833382C4E554C4C2C27454D505F3035272C2732272C2731272C2732272C2735272C2731272C2732272C2731272C2732272C2731272C2732272C2731272C2731272C2731272C4E554C4C2C2732272C2731272C2731272C274D696368616C20536F62637A616B272C27437573746F6D6572205365727669636527292C0A202833392C4E554C4C2C27454D505F3038272C2732272C2731272C2732272C2731272C2731272C2732272C2731272C2732272C2731272C2732272C2731272C2732272C2731272C4E554C4C2C2731272C2732272C2732272C274761627269656C6C65204C6F66747573272C27446973706174636827292C0A202834302C4E554C4C2C27454D505F3039272C2732272C2731272C2731272C2732272C2732272C2731272C2732272C2731272C2732272C2732272C2731272C2732272C2732272C4E554C4C2C2732272C2732272C2732272C2756616B686974612052797A616576272C2750726F64756374696F6E27292C0A202834312C4E554C4C2C27454D505F303130272C2732272C2732272C2731272C2732272C2732272C2731272C2732272C2731272C2732272C2731272C2734272C2732272C2732272C4E554C4C2C2732272C2732272C2732272C27436861726D61696E65204761756472656175272C274F7065726174696F6E7327293B0A2F2A21343030303020414C544552205441424C452060656D70617474656E64616E63653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060656D706C6F7965653030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060656D706C6F7965653030316D62603B0A435245415445205441424C452060656D706C6F7965653030316D626020280A202060734E6F6020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060656D704E756D62657260207661726368617228333029204E4F54204E554C4C2C0A202060656D704E616D6560207661726368617228343029204E4F54204E554C4C2C0A202060656D70446F62602076617263686172283430292044454641554C54204E554C4C2C0A202060656D70446F6A602076617263686172283330292044454641554C54204E554C4C2C0A202060656D7044657369676E602076617263686172283430292044454641554C54204E554C4C2C0A202060656D7047656E646572602076617263686172283230292044454641554C54204E554C4C2C0A202060656D70436F6D70616E79602076617263686172283430292044454641554C54204E554C4C2C0A202060656D70537461747573602076617263686172283230292044454641554C54204E554C4C2C0A202060656D7049646020696E74283131292044454641554C54204E554C4C2C0A2020606465707449646020696E74283131292044454641554C54204E554C4C2C0A202060646570744E616D65602076617263686172283330292044454641554C54204E554C4C2C0A20205052494D415259204B4559202860734E6F60292C0A20204B455920606465707449646020286064657074496460292C0A2020434F4E53545241494E542060656D706C6F7965653030316D625F6962666B5F316020464F524549474E204B45592028606465707449646029205245464552454E43455320606465706172746D656E743030316D626020286064657074696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D31352044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060656D706C6F7965653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060656D706C6F7965653030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060656D706C6F7965653030316D6260202860734E6F602C60656D704E756D626572602C60656D704E616D65602C60656D70446F62602C60656D70446F6A602C60656D7044657369676E602C60656D7047656E646572602C60656D70436F6D70616E79602C60656D70537461747573602C60656D704964602C60646570744964602C60646570744E616D6560292056414C554553200A2028312C27454D505F3032272C274D616E696B616E64616E272C2730312F30312F31393931272C2731302F31322F32303133272C2753616C6573204F666669636572272C274D616C65272C2744656C6C272C27416374697665272C4E554C4C2C312C274C6567616C27292C0A2028322C27454D505F3036272C272044696B6D616E20536865727661736869647A6520536865727661736869647A65272C2730332F30392F31393839272C2730352F31372F32303136272C274A722E456E67696E656572272C274D616C65272C274879756E64616920707674204C7464272C27416374697665272C4E554C4C2C322C274D61726B6574696E67204163636F756E747327292C0A2028332C27454D505F303131272C275A756B7574616B69746F74656B61272C2730382F31392F31393934272C2730382F30382F32303136272C27416E64726F696420446576656C6F706572272C2746656D616C65272C2749424D272C27416374697665272C4E554C4C2C332C275265736561726368202620446576656C6F706D656E7427292C0A2028372C27454D505F3037272C27486174737565204B6173686977616769272C2731302F32302F32303136272C2731302F32302F32303136272C274A756E696F7220456E67696E656572272C274D616C65272C27576865656C7320496E646961272C27416374697665272C4E554C4C2C342C275175616C697479204D616E6167656D656E7427292C0A2028382C27454D505F3034272C274E7572616E205665726B6C65696A272C2730332F32392F31393930272C2730332F32322F32303135272C274A756E696F7220456E67696E656572272C274D616C65272C274B61727961272C27416374697665272C4E554C4C2C362C274D616E6167656D656E7427292C0A2028392C27454D505F3033272C2754696C6465204C696E647176697374272C2730382F31322F31393839272C2730312F31322F32303031272C274F776E6572272C274D616C65272C27435453272C27416374697665272C4E554C4C2C372C2748756D616E205265736F757263657327292C0A202831302C27454D505F3035272C274D696368616C20536F62637A616B272C2730312F30352F31393834272C2730312F32302F32303136272C274A756E696F7220456E67696E656572272C274D616C65272C2749424D272C27416374697665272C4E554C4C2C382C27437573746F6D6572205365727669636527292C0A202831312C27454D505F3038272C274761627269656C6C65204C6F66747573272C2730312F30342F31393834272C2730312F31392F32303136272C274A756E696F7220456E67696E656572272C274D616C65272C274167696C65272C27416374697665272C4E554C4C2C392C27446973706174636827292C0A202831322C27454D505F3039272C2756616B686974612052797A616576272C2731302F30352F31393934272C2731302F30332F32303136272C27547261696E6565272C274D616C65272C27496E74656C6C6F72272C27416374697665272C4E554C4C2C31302C2750726F64756374696F6E27292C0A202831332C27454D505F303130272C27436861726D61696E65204761756472656175272C2731302F30312F31393930272C2730312F31382F32303136272C2750726F6A656374204D616E61676572272C274D616C65272C27544353272C27416374697665272C4E554C4C2C31312C274F7065726174696F6E7327293B0A2F2A21343030303020414C544552205441424C452060656D706C6F7965653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060656D706C6F796D656E74747970653030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060656D706C6F796D656E74747970653030316D62603B0A435245415445205441424C452060656D706C6F796D656E74747970653030316D626020280A202060657479706549646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060656D706C6F796D656E745479706560207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B45592028606574797065496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D352044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060656D706C6F796D656E74747970653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060656D706C6F796D656E74747970653030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060656D706C6F796D656E74747970653030316D626020286065747970654964602C60656D706C6F796D656E745479706560292056414C554553200A2028312C2746756C6C2054696D6527292C0A2028322C27506172742054696D6527292C0A2028332C2750726F626174696F6E27292C0A2028342C27436F6E747261637420426173697327293B0A2F2A21343030303020414C544552205441424C452060656D706C6F796D656E74747970653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060657870656E736573636C6D3030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060657870656E736573636C6D3030316D62603B0A435245415445205441424C452060657870656E736573636C6D3030316D626020280A202060657870636C6D49646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206073746174757360207661726368617228333029204E4F54204E554C4C2C0A202060746F74616C636C6D416D746020646563696D616C2831322C34292044454641554C54204E554C4C2C0A202060657870436F6465602076617263686172283330292044454641554C54204E554C4C2C0A20206065787054797065602076617263686172283330292044454641554C54204E554C4C2C0A20205052494D415259204B4559202860657870636C6D496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D352044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060657870656E736573636C6D3030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060657870656E736573636C6D3030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060657870656E736573636C6D3030316D6260202860657870636C6D4964602C60737461747573602C60746F74616C636C6D416D74602C60657870436F6465602C606578705479706560292056414C554553200A2028312C274472616674272C273230302E30303030272C274558505F303031272C274D65646963616C27292C0A2028322C275375626D6974746564272C273435302E30303230272C274558505F303039272C2754726176656C27292C0A2028342C275375626D6974746564272C273334352E30393030272C274558505F303036272C2743616C6C7327293B0A2F2A21343030303020414C544552205441424C452060657870656E736573636C6D3030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206066696C656D616E616765723030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206066696C656D616E616765723030316D62603B0A435245415445205441424C45206066696C656D616E616765723030316D626020280A20206069646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606C6F67696E7573657260207661726368617228333029204E4F54204E554C4C2C0A20206063617465676F727960207661726368617228333029204E4F54204E554C4C2C0A20206066696C656E616D6560207661726368617228333029204E4F54204E554C4C2C0A20206073697A6560207661726368617228333029204E4F54204E554C4C2C0A202060636F6E74656E74747970656020766172636861722832353529204E4F54204E554C4C2C0A202060636F6E74656E7460206C6F6E67626C6F622C0A20206063726561746564602074696D657374616D70204E4F54204E554C4C2044454641554C542043555252454E545F54494D455354414D502C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D31382044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206066696C656D616E616765723030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206066696C656D616E616765723030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206066696C656D616E616765723030316D62602028606964602C606C6F67696E75736572602C6063617465676F7279602C6066696C656E616D65602C6073697A65602C60636F6E74656E7474797065602C60636F6E74656E74602C606372656174656460292056414C554553200A202831362C2773697661272C27456D706C6F796565272C2750726F6A65637420446F63756D656E742E747874272C27313938354B62272C27746578742F706C61696E272C3078343436353736323035333635373237363635373232303434363537343631363936433733304430413244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324430443041343935303230363136343634373236353733373332303646363632303634363537363230373336353732373636353732334132303335333232453334324533323245333733313044304135353733363537323645363136443635334132303733363937363631304430413530363137333733373736463732363433413333333333363331333930443041353936463735373232303633363136443730323036393733323033413230324636383646364436353246373336393736363132463633363136443730333133373044304132443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244304430413534364632303631363336333635373337333230373436383635323035353439323036363646373232303739364637353732323036333631364437303341304430413444363137303230373436383635323036363646364336433646373736393645363732303639364532303739364637353732323036383646373337343733323036363639364336353341323033353332324533343245333232453337333132303331333732453635364437333633363136443730324536393645373436353643364336463732324536333646364430443041303930443041373537333635373233413639364537343635364336433646373232303730363137333733373736463732363433413734363537333734363537323233304430413244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324430443041343137343236373432303733373937333734363536443044304136383734373437303733334132463246363336463645364536353633373433323338324537353633324536313734373432453633364636443246343537363635364537343435364537343732373932463537363536323733363937343635373332463346353636313633363334393634334436313734373436333635373336333646364432363435373834353736363536453734343934343344333833393334333333373333333233333230304430413244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244304430413534364637323734364636393733363532303244323035333536344530443041373337363645324237333733363833413246324636353644373332463638364636443635324637333736364532463635364437333246363536443733324537333736364532463734373237353645364230443041324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443044304134363639364336353733323034343635373436313639364337333044304134363639364336353733323037343638363137343230363137323635323037353733363536343230363936453230373436383635323037323635363736393733373437323631373436393646364532303730373236463633363537333733334130443041363536443733324636433639363232463635364437333246373236353637363937333734363537323245373036443044304136353644373332463643363936323246363536443733324637333635373435463643363136453634363936453637354637303631363736353546373436313637373332453730364430443041363536443733324636433639363232463635364437333246373337353632373337343639373437353734363535463734363136373733324537303644304430413635364437333246364336393632324636353644373332463733363537343546373236353637363937333734373236313734363936463645354636433639364536423245373036443044304136353644373332463643363936323246363536443733324636353644363136393643353736353632364436313733373436353732324537303644304430413635364437333246364336393632324636353644373332463733363536453634354636443631373835463635364436313639364337333245373036443044304136353644373332463643363936323246363536443733324636433646363136343244363137343734363536453634363536353546363436353734363136393643373332453730364430443041363536443733324636433639363232463635364437333246373236353643364636313634354636313734373436353645363436353635354636343635373436313639364337333245373036443044304132443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443244324432443044304136383734373437303341324632463731363336373734363537333734334133383330333833303246353436353733373434313645363435323635373036463732373435333734373536343639364630443041304430413443364636373637363537323230363636463643363436353732323037303631373436383044304132463638364636443635324637333639373636313246363336313644373033313337324636383734373437303634324636433646363737333044304132303730373236393645373432303232373336393736363136423735364436313732323037343635373337343639364536373230373337353633363336353733373332303639364532303734363836353230373336333732363536353645323036433635373636353643323233423044304130443041323337323635363637323635373336383546373537323643323832343734363136373742353236353637363937333734373236313734363936463645344336393645364237443239334230443041304430413044304136383734373437303733334132463246363736393734363837353632324536333646364432463642373336393736363136423735364436313732333033323331333132463534363537333734343136453634353236353730364637323734353337343735363436393646324536373639373430443041363837343734373037333341324632463637363937343638373536323245363336463644324636423733363937363631364237353644363137323330333233313331324635343635373337343431364536343532363537303646373237343533373437353634363936463044304135353733363537323445363136443635323033413230364237333639373636313642373536443631373233303332333133313044304135303631373337333737364637323634323033413230353337303631373237343631364537333231333233333044304130443041363837343734373033413246324633313339333232453331333633383245333332453331333933333341333833303338333032463534363537333734343136453634353236353730364637323734353337343735363436393646324636433646363736393645304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430413044304130443041304430412C27323031362D31302D30312030313A34383A333827292C0A202831372C2773697661272C27456D706C6F796565272C276D656E752E6A7370272C27393537344B62272C276170706C69636174696F6E2F6F637465742D73747265616D272C307833433235343032303734363136373643363936323230373537323639334432323638373437343730334132463246364136313736363132453733373536453245363336463644324636413733373032463641373337343643324636333646373236353232323037303732363536363639373833443232363332323230323533453044304133433235343032303734363136373643363936323230373537323639334432323638373437343730334132463246373737373737324537333730373236393645363736363732363136443635373736463732364232453646373236373246373436313637373332463636364637323644323232303730373236353636363937383344323236363646373236443232323032353345304430413044304133433231324432443230353336393634363536323631373232303445363137363639363736313734363936463645323035333534343135323534324432443345304430413343363436393736323036333643363137333733334432323732364637373232334530443041323032303230323033433634363937363230363336433631373337333344323237333639363436353244364436353645373532303633364636433244364436343244333332303633364636433244364336373244333332323345323032303230323030443041323032303230323032303230323032303343364536313736323036333643363137333733334432323645363137363632363137323230364536313736363236313732324436343635363636313735364337343232323037323646364336353344323236453631373636393637363137343639364636453232334532303230323030443041323032303230323030393343323132443244323034443631363936453230344436353645373532303244324433453044304132303230323030393039334336343639373632303633364336313733373333443232373336393634363532443644363536453735324436333646364537343631363936453635373232323345304430413230323032303230323032303230323033433735364332303633364336313733373333443232364536313736323036453631373636323631373232443645363137363232334530443041323032303230323032303230323032303230334336433639323036333643363137333733334432323730363136453635364332303730363136453635364332443634363536363631373536433734323232303639363433443232363437323646373036343646373736453232334530443041323032303230323032303230323032303230323032303230323032303230323033433631323036343631373436313244373436463637363736433635334432323633364636433643363137303733363532323230363837323635363633443232323334443631364537353636363136333734373537323639364536373232334530443041323032303230323032303230323032303230323032303230323032303230323032303230323032303343363932303633364336313733373333443232363636313230363636313244363936453634373537333734373237393232334533433246363933453230344436313645373536363631363337343735373236393645363732303343373337303631364532303633364336313733373333443232363336313732363537343232334533433246373337303631364533453044304132303230323032303230323032303230323032303230323032303230323032303343324636313345304430413230323032303230323032303230323032303343363436393736323036393634334432323444363136453735363636313633373437353732363936453637323232303633364336313733373333443232373036313645363536433244363336463643364336313730373336353230363336463643364336313730373336353232334530443041323032303230323032303230323032303230323032303230323033433634363937363230363336433631373337333344323237303631364536353643324436323646363437393232334530443041323032303230323032303230323032303230323032303230323032303230323033433735364332303633364336313733373333443232364536313736323036453631373636323631373232443645363137363232334530443041323032303230323032303230323032303230323032303039303930393230334336433639334535303732364636343735363337343639364636453343324636433639334530443041303930393039303930393230323032303230334336433639334534323639364336433230364636363230344436313734363537323639363136433733334332463643363933453044304130393039303930393039323032303230323033433643363933453534364636463643373333433246364336393345304430413039303930393039303932303230323032303343364336393345353336353734353537303343324636433639334532303044304130393039303930393039323032303230323033433643363933453532363537303646373237343733334332463643363933453044304130393039303930393039323032303230323033433643363933453438363536433730334332463643363933453230323032303230304430413230323032303230323032303230323032303230323030393039303932303343324637353643334530443041323032303230323032303230323032303230323032303230323032303230323032303230323032303343324636343639373633453044304132303230323032303230323032303230323032303230323032303230323032303343324636343639373633453044304132303230323032303230323032303230323032303343324636433639334530443041303930393230304430413230323032303230323032303230323032303230334336433639334533433631323036383732363536363344323232463534363537333734343136453634353236353730364637323734353337343735363436393646324636313634363434353644373036433646373936353635323233453343363932303633364336313733373333443232363636313230363636313244373537333635373232323345334332463639334532303435364437303643364637393635363533433246363133453343324636433639334530443041323032303230323032303230323032303230323030443041323032303230323032303230323032303230323033433643363933453343363132303638373236353636334432323246353436353733373434313645363435323635373036463732373435333734373536343639364632463730364637333232334533433639323036333643363137333733334432323636363132303636363132443733363836463730373036393645363732443633363137323734323233453343324636393345323035303446353333433246363133453343324636433639334530443041323032303230323032303230323032303230323030443041323032303230323032303230323032303230323033433643363933453343363132303638373236353636334432323246353436353733373434313645363435323635373036463732373435333734373536343639364632463639373436353644363437343232334533433639323036333643363137333733334432323636363132303636363132443730373236463634373536333734324436383735364537343232334533433246363933453230343937343635364433433246363133453343324636433639334530443041323032303230323032303230323032303230323030443041323032303230323032303230323032303230323033433643363933453343363132303638373236353636334432323233323233453343363932303633364336313733373333443232363636313230363636313244363836313645363432443646324437323639363736383734323233453343324636393345323035343646343436463343324636313345334332463643363933453044304132303230323032303230323032303230323032303044304132303230323032303230323032303230323032303343364336393345334336313230363837323635363633443232324635343635373337343431364536343532363537303646373237343533373437353634363936463246363337353733373436463644363537323232334533433639323036333643363137333733334432323636363132303636363132443735373336353732323233453343324636393345323034333735373337343646364436353732334332463631334533433246364336393345304430413230323032303230323032303230323032303230304430413230323032303230323032303230323032303230334336433639334533433631323036383732363536363344323232333232334533433639323036333643363137333733334432323636363132303636363132443734363137333642373332323345334332463639334532303530373236463641363536333734323033433246363133453343324636433639334530443041303930393044304130393343364336393230363336433631373337333344323237303631364536353643323037303631364536353643324436343635363636313735364337343232323036393634334432323634373236463730363436463737364532323345304430413230323032303230323032303230323032303230323032303230323032303230334336313230363436313734363132443734364636373637364336353344323236333646364336433631373037333635323232303638373236353636334432323233343837353644363136453532363536463733373537323633363537333232334530443041323032303230323032303230323032303230323032303230323032303230323032303230323032303343363932303633364336313733373333443232363636313230363636313244373537333635373237333230363636313244364336373232334533433246363933453230343837353644363136453230353236353733364637353732363336353733334337333730363136453230363336433631373337333344323236333631373236353734323233453343324637333730363136453345304430413230323032303230323032303230323032303230323032303230323032303230334332463631334530443041323032303230323032303230323032303230334336343639373632303639363433443232343837353644363136453532363536463733373537323633363537333232323036333643363137333733334432323730363136453635364332443633364636433643363137303733363532303633364636433643363137303733363532323345304430413230323032303230323032303230323032303230323032303230334336343639373632303633364336313733373333443232373036313645363536433244363236463634373932323345304430413230323032303230323032303230323032303230323032303230323032303230334337353643323036333643363137333733334432323645363137363230364536313736363236313732324436453631373632323345304430413230323032303230323032303230323032303230323030393039303933433643363933453435364437303643364637393635363532303631364536343230343137343734363536453634363136453633363533433246364336393345304430413039303930393039323032303230323033433643363933453532363536333732373536393734364436353645373433433246364336393345304430413039303930393039323032303230323033433643363933453443363536313736363537333230363136453634323034383646364336393634363137393343324636433639334530443041303930393039303932303230323032303343364336393345353036313739323035323646364336433343324636433639334532303044304130393039303930393230323032303230334336433639334534353738373036353645373336353230343336433631363936443733334332463643363933453044304130393039303930393230323032303230334336433639334534313730373037323631363937333631364337333343324636433639334530443041303930393039303932303230323032303343364336393345353336353734353537303343324636433639334530443041303930393039303932303230323032303343364336393345353236353730364637323734373333433246364336393345304430413039303930393039323032303230323033433643363933453438363536433730334332463643363933453044304132303230323032303230323032303230323032303230303932303230323033433246373536433345304430413230323032303230323032303230323032303230323032303230334332463634363937363345304430413230323032303230323032303230323033433246363436393736334530443041323032303230323032303230334332463643363933453039303930443041323032303230323032303230304430413230323032303230323032303343364336393345334336313230363837323635363633443232324635343635373337343431364536343532363537303646373237343533373437353634363936463246363636393643363536443631364536313637363537323232334533433639323036333643363137333733334432323636363132303636363132443636363936433635323233453343324636393345323034363639364336353230344436313645363136373635373233433246363133453343324636433639334530443041303930393044304130393230323033433643363933453343363132303638373236353636334432323233323233453343363932303633364336313733373333443232363636313230363636313244373436313637373332323345334332463639334532303533363136433635373332303446373236343635373232303343324636313345334332463643363933453039303932303044304130393039304430413039323032303343364336393345334336313230363837323635363633443232323332323345323033433639323036333643363137333733334432323636363132303636363132443735373336353732323233453343324636393345323034433635363136343230334332463631334533433246364336393345323030393039304430413039303930393039323030443041303932303230334336433639323036333643363137333733334432323730363136453635364332303730363136453635364332443634363536363631373536433734323232303639363433443232363437323646373036343646373736453232334530443041323032303230323032303230323032303230323032303230323032303230323033433631323036343631373436313244373436463637363736433635334432323633364636433643363137303733363532323230363837323635363633443232323334323735373936393645363732323345304430413230323032303230323032303230323032303230323032303230323032303230323032303230323033433639323036333643363137333733334432323636363132303636363132443733363836463730373036393645363732443633363137323734323233453343324636393345323034323735373936393645363733433733373036313645323036333643363137333733334432323633363137323635373432323345334332463733373036313645334530443041323032303230323032303230323032303230323032303230323032303230323033433246363133453044304132303230323032303230323032303230323033433634363937363230363936343344323234323735373936393645363732323230363336433631373337333344323237303631364536353643324436333646364336433631373037333635323036333646364336433631373037333635323233453044304132303230323032303230323032303230323032303230323032303343363436393736323036333643363137333733334432323730363136453635364332443632364636343739323233453044304132303230323032303230323032303230323032303230323032303230323032303343373536433230363336433631373337333344323236453631373632303645363137363632363137323244364536313736323233453044304132303230323032303230323032303230323032303230303930393230323033433643363933453530373537323633363836313733363936453637334332463643363933453044304130393039303930393230323033433643363933453533373537303730364336393635373233433246364336393345304430413039303930393039323032303343364336393345353336353734353537303343324636433639334530443041303930393039303932303230334336433639334534393734363536443733323036313645363432303530373236393633363936453637334332463643363933453044304130393039303930393230323033433643363933453431364536313643373937343639363337333343324636433639334530443041303930393039303932303230334336433639334534463734363836353732323035323635373036463732373437333343324636433639334530443041303930393039303932303230334336433639334534383635364337303343324636433639334530443041323032303230323032303230323032303230323032303039323032303230334332463735364333453044304132303230323032303230323032303230323032303230323032303343324636343639373633453044304132303230323032303230323032303230334332463634363937363345304430413230323032303230323032303343324636433639334530393039304430413230323032303230323032303230334336433639323036333643363137333733334432323730363136453635364332303730363136453635364332443634363536363631373536433734323232303639363433443232363437323646373036343646373736453232334530443041323032303230323032303230323032303230323032303230323032303230323033433631323036343631373436313244373436463637363736433635334432323633364636433643363137303733363532323230363837323635363633443232323335333635364336433639364536373232334530443041323032303230323032303230323032303230323032303230323032303230323032303230323032303230334336393230363336433631373337333344323236363631323036363631324436393645373232323345334332463639334532303230353336353643364336393645363732303343373337303631364532303633364336313733373333443232363336313732363537343232334533433246373337303631364533453044304132303230323032303230323032303230323032303230323032303230323032303343324636313345304430413230323032303230323032303230323032303343363436393736323036393634334432323533363536433643363936453637323232303633364336313733373333443232373036313645363536433244363336463643364336313730373336353230363336463643364336313730373336353232334530443041323032303230323032303230323032303230323032303230323033433634363937363230363336433631373337333344323237303631364536353643324436323646363437393232334530443041323032303230323032303230323032303230323032303230323032303230323033433735364332303633364336313733373333443232364536313736323036453631373636323631373232443645363137363232334530443041323032303230323032303230323032303230323032303039303932303230334336433639334535333631364336353733334332463643363933453044304130393039303930393230323033433643363933453433373537333734364636443635373237333343324636433639334530443041303930393039303932303230334336433639334534393734363536443733323036313645363432303530373236393633363936453637334332463643363933453044304130393039303930393230323033433643363933453533363136433635373332303730363137323734364536353732373332303631364536343230353436353732373236393734364637323739334332463643363933453044304130393039303930393230323033433643363933453533363537343535373033433246364336393345304430413039303930393039323032303343364336393345343136453631364337393734363936333733334332463643363933453044304130393039303930393230323033433643363933453446373436383635373232303532363537303646373237343733334332463643363933453044304130393039303930393230323033433643363933453438363536433730334332463643363933453044304132303230323032303230323032303230323032303230303932303230323033433246373536433345304430413230323032303230323032303230323032303230323032303230334332463634363937363345304430413230323032303230323032303230323033433246363436393736334530443041323032303230323032303230334332463643363933453039303930443041323032303230323032303230323033433643363932303633364336313733373333443232373036313645363536433230373036313645363536433244363436353636363137353643373432323230363936343344323236343732364637303634364637373645323233453044304132303230323032303230323032303230323032303230323032303230323032303343363132303634363137343631324437343646363736373643363533443232363336463643364336313730373336353232323036383732363536363344323232333433353234443232334530443041323032303230323032303230323032303230323032303230323032303230323032303230323032303343363932303633364336313733373333443232363636313230363636313244363636393643363532443734363537383734323233453343324636393345323034333532344432303343373337303631364532303633364336313733373333443232363336313732363537343232334533433246373337303631364533453044304132303230323032303230323032303230323032303230323032303230323032303343324636313345304430413230323032303230323032303230323032303343363436393736323036393634334432323433353234443232323036333643363137333733334432323730363136453635364332443633364636433643363137303733363532303633364636433643363137303733363532323345304430413230323032303230323032303230323032303230323032303230334336343639373632303633364336313733373333443232373036313645363536433244363236463634373932323345304430413230323032303230323032303230323032303230323032303230323032303230334337353643323036333643363137333733334432323645363137363230364536313736363236313732324436453631373632323345304430413230323032303230323032303230323032303230323030393039323032303343364336393345353336313643363537333230353036393730363536433639364536353343324636433639334530443041303930393039303932303230334336433639334535323635373036463732373437333343324636433639334530443041303930393039303932303230334336433639334534333646364436443735364536393633363137343639364636453343324636433639334530443041303930393039303932303230334336433639334535333635373435353730334332463643363933453044304130393039303930393230323033433643363933453438363536433730334332463643363933453044304132303230323032303230323032303230323032303230303932303230323033433246373536433345304430413230323032303230323032303230323032303230323032303230334332463634363937363345304430413230323032303230323032303230323033433246363436393736334530443041323032303230323032303230334332463643363933453039303930443041323032303230323032303230334336433639334533433631323036383732363536363344323232333232334533433639323036333643363137333733334432323636363132303636363132443733363836463730373036393645363732443633363137323734323233453343324636393345323035303735373236333638363137333635323034463732363436353732323032303343324636313345334332463643363933453044304132303230323032303230323033433643363932303633364336313733373333443232373036313645363536433230373036313645363536433244363436353636363137353643373432323230363936343344323236343732364637303634364637373645323233453044304132303230323032303230323032303230323032303230323032303230323032303343363132303634363137343631324437343646363736373643363533443232363336463643364336313730373336353232323036383732363536363344323232333530373236463641363536333734373332323345304430413230323032303230323032303230323032303230323032303230323032303230323032303230323033433639323036333643363137333733334432323636363132303636363132443734363137333642373332323345334332463639334532303230353037323646364136353633373437333230334337333730363136453230363336433631373337333344323236333631373236353734323233453343324637333730363136453345304430413230323032303230323032303230323032303230323032303230323032303230334332463631334530443041323032303230323032303230323032303230334336343639373632303639363433443232353037323646364136353633373437333232323036333643363137333733334432323730363136453635364332443633364636433643363137303733363532303633364636433643363137303733363532323345304430413230323032303230323032303230323032303230323032303230334336343639373632303633364336313733373333443232373036313645363536433244363236463634373932323345304430413230323032303230323032303230323032303230323032303230323032303230334337353643323036333643363137333733334432323645363137363230364536313736363236313732324436453631373632323345304430413230323032303230323032303230323032303230323030393039323032303343364336393345353037323646364136353633373432303343324636433639334530443041303930393039303932303230334336433639334535343639364436353230353437323631363336423639364536373343324636433639334530443041303930393039303932303230334336433639334535323635373036463732373437333343324636433639334530443041303930393039303932303230334336433639334534383635364337303343324636433639334530443041323032303230323032303230323032303230323032303039323032303230334332463735364333453044304132303230323032303230323032303230323032303230323032303343324636343639373633453044304132303230323032303230323032303230334332463634363937363345304430413230323032303230323032303343324636433639334530393039304430413230323032303230323032303230334336433639323036333643363137333733334432323730363136453635364332303730363136453635364332443634363536363631373536433734323232303639363433443232363437323646373036343646373736453232334530443041323032303230323032303230323032303230323032303230323032303230323033433631323036343631373436313244373436463637363736433635334432323633364636433643363137303733363532323230363837323635363633443232323335333735373037303730364637323734323233453044304132303230323032303230323032303230323032303230323032303230323032303230323032303230334336393230363336433631373337333344323236363631323036363631324436433639363636353244373236393645363732323345334332463639334532303230353337353730373036463732373432303343373337303631364532303633364336313733373333443232363336313732363537343232334533433246373337303631364533453044304132303230323032303230323032303230323032303230323032303230323032303343324636313345304430413230323032303230323032303230323032303343363436393736323036393634334432323533373537303730364637323734323232303633364336313733373333443232373036313645363536433244363336463643364336313730373336353230363336463643364336313730373336353232334530443041323032303230323032303230323032303230323032303230323033433634363937363230363336433631373337333344323237303631364536353643324436323646363437393232334530443041323032303230323032303230323032303230323032303230323032303230323033433735364332303633364336313733373333443232364536313736323036453631373636323631373232443645363137363232334530443041323032303230323032303230323032303230323032303039303932303343364336393345343937333733373536353733334332463643363933453044304130393039303930393230323033433643363933453537363137323732363136453734373933433246364336393345304430413039303930393039323032303343364336393345353236353730364637323734373333433246364336393345304430413230323032303230323032303230323032303230323030393230323032303343324637353643334530443041323032303230323032303230323032303230323032303230323033433246363436393736334530443041323032303230323032303230323032303343324636343639373633453044304132303230323032303230323033433246364336393345303930443041323032303230323032303230334336433639334533433631323036383732363536363344323232333232334533433639323036333643363137333733334432323636363132303636363132443639364536343735373337343732373932323345334332463639334532303530373236463634373536333734363936463645323034463732363436353732323033433246363133453343324636433639334530393044304132303230323032303230323033433643363933453343363132303638373236353636334432323233323233453343363932303633364336313733373333443232363636313230363636313244373537333634323233453343324636393345323034323446344432303343324636313345334332463643363933453044304132303230323032303230323032303343364336393230363336433631373337333344323237303631364536353643323037303631364536353643324436343635363636313735364337343232323036393634334432323634373236463730363436463737364532323345304430413230323032303230323032303230323032303230323032303230323032303230334336313230363436313734363132443734364636373637364336353344323236333646364336433631373037333635323232303638373236353636334432323233353337343646363336423232334530443041323032303230323032303230323032303230323032303230323032303230323032303230323032303343363932303633364336313733373333443232363636313230363636313244363436313734363136323631373336353232334533433246363933453230353337343646363336423230334337333730363136453230363336433631373337333344323236333631373236353734323233453343324637333730363136453345304430413230323032303230323032303230323032303230323032303230323032303230334332463631334530443041323032303230323032303230323032303230334336343639373632303639363433443232353337343646363336423232323036333643363137333733334432323730363136453635364332443633364636433643363137303733363532303633364636433643363137303733363532323345304430413230323032303230323032303230323032303230323032303230334336343639373632303633364336313733373333443232373036313645363536433244363236463634373932323345304430413230323032303230323032303230323032303230323032303230323032303230334337353643323036333643363137333733334432323645363137363230364536313736363236313732324436453631373632323345304430413230323032303230323032303230323032303230323030393039323032303343364336393345353337343646363336423230353437323631364537333631363337343639364636453733334332463643363933453044304130393039303930393230323033433643363933453533373436463633364232303532363537303646373237343733334332463643363933453044304130393039303930393230323033433643363933453439373436353644373332303631364536343230353037323639363336393645363733433246364336393345304430413039303930393039323032303343364336393345353336353732363936313643323036453646323036313645363432303432363137343633363833433246364336393345304430413039303930393039323032303343364336393345353436463646364337333343324636433639334530443041303930393039303932303230334336433639334535333635373435353730334332463643363933453044304130393039303930393230323033433643363933453431364536313643373937343639363337333343324636433639334530443041303930393039303932303230334336433639334535323635373036463732373437333343324636433639334530443041303930393039303932303230334336433639334534383635364337303343324636433639334530443041323032303230323032303230323032303230323032303039323032303230334332463735364333453044304132303230323032303230323032303230323032303230323032303343324636343639373633453044304132303230323032303230323032303230334332463634363937363345304430413230323032303230323032303343324636433639334530393044304130393230323032303343364336393230363336433631373337333344323237303631364536353643323037303631364536353643324436343635363636313735364337343232323036393634334432323634373236463730363436463737364532323345304430413230323032303230323032303230323032303230323032303230323032303230334336313230363436313734363132443734364636373637364336353344323236333646364336433631373037333635323232303638373236353636334432323233353436463646364337333232334530443041323032303230323032303230323032303230323032303230323032303230323032303230323032303343363932303633364336313733373333443232363636313230363636313244373737323635364536333638323233453343324636393345323035343646364636433733323033433733373036313645323036333643363137333733334432323633363137323635373432323345334332463733373036313645334530443041323032303230323032303230323032303230323032303230323032303230323033433246363133453044304132303230323032303230323032303230323033433634363937363230363936343344323235343646364636433733323232303633364336313733373333443232373036313645363536433244363336463643364336313730373336353230363336463643364336313730373336353232334530443041323032303230323032303230323032303230323032303230323033433634363937363230363336433631373337333344323237303631364536353643324436323646363437393232334530443041323032303230323032303230323032303230323032303230323032303230323033433735364332303633364336313733373333443232364536313736323036453631373636323631373232443645363137363232334530443041323032303230323032303230323032303230323032303039303932303343364336393345353436463646364337333343324636433639334530443041323032303230323032303230323032303230323032303039323032303230334332463735364333453044304132303230323032303230323032303230323032303230323032303343324636343639373633453044304132303230323032303230323032303230334332463634363937363345304430413230323032303230323032303343324636433639334530393044304132303230323032303230323032303343364336393345334336313230363837323635363633443232323332323345334336393230363336433631373337333344323236363631323036363631324437353733363537323232334533433246363933453230353337353730373036433639363537323230334332463631334533433246364336393345304430413039323032303343364336393345334336313230363837323635363633443232323332323345334336393230363336433631373337333344323236363631323036363631324437313735363537333734363936463645323233453343324636393345323034393733373337353635323033433246363133453343324636433639334530393039304430413039323032303343364336393345334336313230363837323635363633443232323332323345334336393230363336433631373337333344323236363631323036363631324436343631373436313632363137333635323233453343324636393345323035333734364636333642323034353645373437323739323033433246363133453343324636433639334532303044304130393230323033433643363933453343363132303638373236353636334432323233323233453343363932303633364336313733373333443232363636313230363636313244373036433735373332323345334332463639334532303530373236463636363937343230363136453634323034433646373337333230353337343631373436353644363536453734323033433246363133453343324636433639334530393044304130393230323033433643363933453343363132303638373236353636334432323246353436353733373434313645363435323635373036463732373435333734373536343639364632463631363436343734363137333642323233453343363932303633364336313733373333443232363636313230363636313244373436313733364237333232334533433246363933453230353436313733364232303343324636313345334332463643363933453044304130393230323033433643363932303633364336313733373333443232373036313645363536433230373036313645363536433244363436353636363137353643373432323230363936343344323236343732364637303634364637373645323233453044304132303230323032303230323032303230323032303230323032303230323032303343363132303634363137343631324437343646363736373643363533443232363336463643364336313730373336353232323036383732363536363344323232333443363536313732364532323345304430413230323032303230323032303230323032303230323032303230323032303230323032303230323033433639323036333643363137333733334432323636363132303636363132443632364636463642323233453343324636393345323034433635363137323645323033433733373036313645323036333643363137333733334432323633363137323635373432323345334332463733373036313645334530443041323032303230323032303230323032303230323032303230323032303230323033433246363133453044304132303230323032303230323032303230323033433634363937363230363936343344323234433635363137323645323232303633364336313733373333443232373036313645363536433244363336463643364336313730373336353230363336463643364336313730373336353232334530443041323032303230323032303230323032303230323032303230323033433634363937363230363336433631373337333344323237303631364536353643324436323646363437393232334530443041323032303230323032303230323032303230323032303230323032303230323033433735364332303633364336313733373333443232364536313736323036453631373636323631373232443645363137363232334530443041323032303230323032303230323032303230323032303039303932303230334336433639334534373635364536353732363136433343324636433639334530443041303930393039303932303230334336433639334535333635373435353730334332463643363933453044304130393039303930393230323033433643363933453431363336333646373536453734373333433246364336393345304430413039303930393039323032303343364336393345343335323444334332463643363933453044304130393039303930393230323033433643363933453533363536433643363936453637334332463643363933453044304130393039303930393230323033433643363933453533373436463633364233433246364336393345304430413039303930393039323032303343364336393345343237353739363936453637334332463643363933453044304130393039303930393230323033433643363933453444363136453735363636313633373437353732363936453637334332463643363933453044304130393039303930393230323033433643363933453438373536443631364532303532363537333646373537323633363533433246364336393345304430413039303930393039323032303343364336393345353037323646364136353633373437333343324636433639334530443041303930393039303932303230334336433639334535373635363237333639373436353343324636433639334530443041323032303230323032303230323032303230323032303039323032303230334332463735364333453044304132303230323032303230323032303230323032303230323032303343324636343639373633453044304132303230323032303230323032303230334332463634363937363345304430413230323032303230323032303343324636433639334530393044304132303230323032303230323033433643363933453343363132303638373236353636334432323233323233453343363932303633364336313733373333443232363636313230363636313244363936453732323233453343324636393345323034323735363436373635373432303536363137323639363136453633363532303532363537303646373237343343324636313345334332463643363933453044304130393230323033433643363933453343363132303638373236353636334432323233323233453343363932303633364336313733373333443232363636313230363636313244363336433646363336423244364632323345334332463639334532303434363136393643373932303534363936443635324437333638363536353734323035333735364436443631373237393343324636313345334332463643363933453039304430413039323032303343364336393345334336313230363837323635363633443232323332323345334336393230363336433631373337333344323236363631323036363631324437323635363736393733373436353732363536343232334533433246363933453230343937343635364432303537363937333635323035333631364336353733323035323635363736393733373436353732334332463631334533433246364336393345304430413039323032303343364336393345334336313230363837323635363633443232323332323345334336393230363336433631373337333344323236363631323036363631324436323631373232443633363836313732373432323345334332463639334532303439373436353644323035323635373036463732373433433246363133453343324636433639334530393044304130393230323033433643363933453343363132303638373236353636334432323233323233453343363932303633364336313733373333443232363636313230363636313244373537333635373232323345334332463639334532303433373537333734364636443635373232303532363537303646373237343343324636313345334332463643363933453039304430413039323032303343364336393345334336313230363837323635363633443232323332323345334336393230363336433631373337333344323236363631323036363631324436363639364336353232334533433246363933453230343636393643363533433246363133453343324636433639334530443041303932303230334336433639323036333643363137333733334432323730363136453635364332303730363136453635364332443634363536363631373536433734323232303639363433443232363437323646373036343646373736453232334530443041323032303230323032303230323032303230323032303230323032303230323033433631323036343631373436313244373436463637363736433635334432323633364636433643363137303733363532323230363837323635363633443232323334313633363336463735364537343733323233453044304132303230323032303230323032303230323032303230323032303230323032303230323032303230334336393230363336433631373337333344323236363631323036363631324437353733363537323232334533433246363933453230343136333633364637353645373437333230334337333730363136453230363336433631373337333344323236333631373236353734323233453343324637333730363136453345304430413230323032303230323032303230323032303230323032303230323032303230334332463631334530443041323032303230323032303230323032303230334336343639373632303639363433443232343136333633364637353645373437333232323036333643363137333733334432323730363136453635364332443633364636433643363137303733363532303633364636433643363137303733363532323345304430413230323032303230323032303230323032303230323032303230334336343639373632303633364336313733373333443232373036313645363536433244363236463634373932323345304430413230323032303230323032303230323032303230323032303230323032303230334337353643323036333643363137333733334432323645363137363230364536313736363236313732324436453631373632323345304430413230323032303230323032303230323032303230323030393039323032303343364336393345343236393643364336393645363733433246364336393345304430413039303930393039323032303343364336393345343336463644373036313645373932303631364536343230343136333633364637353645373437333343324636433639334530443041303930393039303932303230334336433639334534443631373337343635373237333343324636433639334530443041303930393039303932303230334336433639334534313633363336463735364537343639364536373230353337343631373436353644363536453734373333433246364336393345304430413039303930393039323032303343364336393345343236313645364236393645363732303530363137393644363536453734373333433246364336393345304430413039303930393039323032303343364336393345353436313738363537333343324636433639334530443041303930393039303932303230334336433639334534323735363436373635373432303631364536343230343336463733373432303433363536453734363537323343324636433639334530443041303930393039303932303230334336433639334535343646364636433733334332463643363933453044304130393039303930393230323033433643363933453533363537343535373033433246364336393345304430413039303930393039323032303343364336393345353436463230343236393643364333433246364336393345304430413039303930393039323032303343364336393345343136453631364337393734363936333733334332463643363933453044304130393039303930393230323033433643363933453446373436383635373232303532363537303646373237343733334332463643363933453044304130393039303930393230323033433643363933453230343836353643373033433246364336393345304430413230323032303230323032303230323032303230323030393230323032303343324637353643334530443041323032303230323032303230323032303230323032303230323033433246363436393736334530443041323032303230323032303230323032303343324636343639373633453044304132303230323032303230323033433246364336393345303930443041323032303230323032303230334336433639334533433631323036383732363536363344323232333232334533433639323036333643363137333733334432323636363132303636363132443635373837303631364536343232334533433246363933453230343537383730364336463732363532303343324636313345334332463643363933453044304132303230323032303230334332463735364333453044304132303230323032303343324636343639373633453343323132443244323032463245364536313736363236313732324436333646364336433631373037333635323032443244334530443041334332463645363137363345304430413343324636343639373633453230323032303044304133433246363436393736334530443041304430413044304130443041303930393039303932302C27323031362D31302D30312030313A34393A303827293B0A2F2A21343030303020414C544552205441424C45206066696C656D616E616765723030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206067726F737370726F6669743030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206067726F737370726F6669743030316D62603B0A435245415445205441424C45206067726F737370726F6669743030316D626020280A20206069646020696E742831302920756E7369676E6564204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206073616C6573696E766F69636560207661726368617228343529204E4F54204E554C4C2C0A202060637573746F6D657260207661726368617228343529204E4F54204E554C4C2C0A202060706F7374696E676461746560207661726368617228343529204E4F54204E554C4C2C0A2020606974656D6E616D6560207661726368617228343529204E4F54204E554C4C2C0A2020606465736372697074696F6E60207661726368617228343529204E4F54204E554C4C2C0A20206077617265686F75736560207661726368617228343529204E4F54204E554C4C2C0A20206070726F6A65637460207661726368617228343529204E4F54204E554C4C2C0A20206063757272656E637960207661726368617228343529204E4F54204E554C4C2C0A2020607175616E746974796020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A2020606176657261676573656C6C696E67726174656020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A20206061766572616765627579696E67726174656020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A20206073656C6C696E67616D6F756E746020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A202060627579696E67616D6F756E746020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A20206067726F737370726F6669746020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A20206067726F737370657263656E746167656020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D362044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206067726F737370726F6669743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206067726F737370726F6669743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206067726F737370726F6669743030316D62602028606964602C6073616C6573696E766F696365602C60637573746F6D6572602C60706F7374696E6764617465602C606974656D6E616D65602C606465736372697074696F6E602C6077617265686F757365602C6070726F6A656374602C6063757272656E6379602C607175616E74697479602C606176657261676573656C6C696E6772617465602C6061766572616765627579696E6772617465602C6073656C6C696E67616D6F756E74602C60627579696E67616D6F756E74602C6067726F737370726F666974602C6067726F737370657263656E7461676560292056414C554553200A2028312C274B543034383737272C276972696E272C2731302F30352F32303136272C2754455354272C27676F6F66272C276B61727461272C276B61727961272C277275706565272C352C32302C31352C3130302C37352C32352C30292C0A2028322C274B543030383933272C274468696B736861272C2731302F30362F32303136272C2754455354272C276767272C274747272C276868272C276868272C352C31302C352C35302C32352C32352C313030292C0A2028342C274B543038383135272C2773686161736861272C2731302F30352F32303136272C2742412D424154272C27676F6F66272C27676F6F64272C27726570272C277275706565272C352C31352C31302C37352C35302C32352C3530292C0A2028352C274B543031373835272C276972696E272C2730392F32372F32303136272C27426C2D42414C4C272C2764657363272C2777617265272C2770726F272C27637572272C352C31352C31302C37352C35302C32352C3530293B0A2F2A21343030303020414C544552205441424C45206067726F737370726F6669743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060686F6C696461796C6973743030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060686F6C696461796C6973743030316D62603B0A435245415445205441424C452060686F6C696461796C6973743030316D626020280A202060686C69737449646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060686F6C696461794E616D6560207661726368617228333029204E4F54204E554C4C2C0A2020607765656B6C794F6666602076617263686172283330292044454641554C54204E554C4C2C0A20205052494D415259204B4559202860686C697374496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D342044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060686F6C696461796C6973743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060686F6C696461796C6973743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060686F6C696461796C6973743030316D6260202860686C6973744964602C60686F6C696461794E616D65602C607765656B6C794F666660292056414C554553200A2028312C2752616D7A616E272C275475657364617927292C0A2028322C27506F6E67616C272C27546875727364617927292C0A2028332C2752657075626C69635F446179272C27536174757264617927293B0A2F2A21343030303020414C544552205441424C452060686F6C696461796C6973743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606973737565646974656D3030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606973737565646974656D3030316D62603B0A435245415445205441424C4520606973737565646974656D3030316D626020280A202060697373756549646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060706F72646572436F646560207661726368617228353029204E4F54204E554C4C2C0A20206069737375654461746560207661726368617228353029204E4F54204E554C4C2C0A2020604974656D636F646560207661726368617228353029204E4F54204E554C4C2C0A2020606465736372697074696F6E6020766172636861722831303029204E4F54204E554C4C2C0A2020607175616E7469747960207661726368617228333029204E4F54204E554C4C2C0A202060756F6D60207661726368617228333029204E4F54204E554C4C2C0A202060616D6F756E746020646563696D616C2831322C3429204E4F54204E554C4C2C0A20206073657269616C4E6F60207661726368617228353029204E4F54204E554C4C2C0A202060736F75726365574860207661726368617228353029204E4F54204E554C4C2C0A202060746172676574574860207661726368617228353029204E4F54204E554C4C2C0A20206073746F636B456E74727960207661726368617228343029204E4F54204E554C4C2C0A202060636F6D70616E7960207661726368617228353029204E4F54204E554C4C2C0A20205052494D415259204B45592028606973737565496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D332044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606973737565646974656D3030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606973737565646974656D3030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606973737565646974656D3030316D626020286069737375654964602C60706F72646572436F6465602C60697373756544617465602C604974656D636F6465602C606465736372697074696F6E602C607175616E74697479602C60756F6D602C60616D6F756E74602C6073657269616C4E6F602C60736F757263655748602C607461726765745748602C6073746F636B456E747279602C60636F6D70616E7960292056414C554553200A2028322C2750524F5F3030303834272C2731302F31322F32303136272C2757696E64204D496C6C204320536572696573272C27476F6F64272C2732272C274E6F73272C273435362E30303030272C275345522D303032272C2750726F677265737320676F6F6473272C2746696E697368656420676F6F6473272C275354452D303031272C2744656C6C27293B0A2F2A21343030303020414C544552205441424C4520606973737565646974656D3030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606974656D64743030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606974656D64743030316D62603B0A435245415445205441424C4520606974656D64743030316D626020280A2020604974656D69646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020604974656D636F6465602076617263686172283530292044454641554C54204E554C4C2C0A2020605175616E746974796020736D616C6C696E74283629204E4F54204E554C4C2C0A202060526174656020646563696D616C2831322C34292044454641554C54204E554C4C2C0A202060416D6F756E746020646563696D616C2831322C34292044454641554C54204E554C4C2C0A20205052494D415259204B45592028604974656D696460292C0A2020554E49515545204B455920604974656D636F6465602028604974656D636F646560290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D32392044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606974656D64743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606974656D64743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606974656D64743030316D62602028604974656D6964602C604974656D636F6465602C605175616E74697479602C6052617465602C60416D6F756E7460292056414C554553200A2028312C2757696E67205368656574272C352C273435362E35303030272C273436352E3030303027292C0A2028322C2757696E64204D496C6C204320536572696573272C322C2734362E30303030272C2734362E3030303027292C0A2028332C2757696E642054757262696E652D4C272C322C273130302E30303030272C273130302E3030303027292C0A202832312C2757696E64204D696C6C204120536572696573272C31302C273130302E30303030272C273130302E3030303027292C0A202832322C275461626C65272C31302C273330302E30303030272C273239392E3530303027292C0A202832342C275368616674272C352C2734352E35303030272C273235342E3030303027292C0A202832352C27496E7465726E616C2044697363272C31342C2734352E32333030272C273435342E3131323027292C0A202832362C274D6F62696C65272C34352C2736332E32333030272C273236372E3331303027292C0A202832372C27436F6D7075746572272C31352C2732332E31323030272C273232322E3132333027292C0A202832382C274368616972272C322C273133352E34353030272C273435362E3332303027293B0A2F2A21343030303020414C544552205441424C4520606974656D64743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606974656D73743030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606974656D73743030316D62603B0A435245415445205441424C4520606974656D73743030316D626020280A2020606974656D737449646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606974656D636F646560207661726368617228353029204E4F54204E554C4C2C0A20206073746174757360207661726368617228333029204E4F54204E554C4C2C0A2020606974656D47726F757060207661726368617228343029204E4F54204E554C4C2C0A20205052494D415259204B45592028606974656D7374496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D352044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606974656D73743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606974656D73743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606974656D73743030316D62602028606974656D73744964602C606974656D636F6465602C60737461747573602C606974656D47726F757060292056414C554553200A2028312C274D6F62696C65272C27456E61626C6564272C2750726F647563747327292C0A2028322C274C6170746F70272C2754656D706C617465272C27526177204D6174657269616C7327292C0A2028342C2757696E64204D696C6C204120536572696573272C2744697361626C6564272C2753756220417373656D626C69657327293B0A2F2A21343030303020414C544552205441424C4520606974656D73743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606C6561643030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606C6561643030316D62603B0A435245415445205441424C4520606C6561643030316D626020280A20206069646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060706572736F6E6E616D6560207661726368617228333029204E4F54204E554C4C2C0A2020606F7267616E69736174696F6E6E616D6560207661726368617228333029204E4F54204E554C4C2C0A20206073746174757360207661726368617228333029204E4F54204E554C4C2C0A202060736F7572636560207661726368617228333029204E4F54204E554C4C2C0A2020606C6561646F776E657260207661726368617228353029204E4F54204E554C4C2C0A2020606E657874636F6E746163746279602076617263686172283530292044454641554C54204E554C4C2C0A2020606C65616474797065602076617263686172283530292044454641554C54204E554C4C2C0A2020606D61726B65747365676D656E74602076617263686172283530292044454641554C54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D31372044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606C6561643030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606C6561643030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606C6561643030316D62602028606964602C60706572736F6E6E616D65602C606F7267616E69736174696F6E6E616D65602C60737461747573602C60736F75726365602C606C6561646F776E6572602C606E657874636F6E746163746279602C606C65616474797065602C606D61726B65747365676D656E7460292056414C554553200A2028312C2772617669272C2778797A272C276F70656E272C276C656164272C2761646D696E272C2761626340676D61696C2E636F6D272C27636C69656E74272C27696E636F6D6527292C0A2028322C2772616A61272C276C6D77272C27696E697461746564272C276C656164272C2761646D696E272C2778797A40676D61696C2E636F6D272C27636F6E73756C74616E74272C27696E636F6D6527292C0A2028362C2772616D6B756D61726E617261696E272C2761626364272C27636F6D706C65746564272C2774616C6B696E67272C27636C69656E74272C2778797A40676D61696C2E636F6D272C2761646D696E6973747261746F72272C27696E636F6D656869676827292C0A202831352C2773697661272C276B61727961272C276F70656E272C2763616C6C272C2769737761727961272C27393838343534353837272C2761646D696E272C276869676827292C0A202831362C2764686979616B756D6172272C276B61727961746563686E6F6C6F67696573272C27696E697461746564272C2763616C6C696E67272C276C656164272C2778797A40676D61696C2E636F6D272C27636F6E73756C74616E74272C27696E636F6D656C6F7727293B0A2F2A21343030303020414C544552205441424C4520606C6561643030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606C656176656170703030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606C656176656170703030316D62603B0A435245415445205441424C4520606C656176656170703030316D626020280A2020606C7661707049646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206073657269657360207661726368617228333029204E4F54204E554C4C2C0A2020606C656176655479706560207661726368617228333029204E4F54204E554C4C2C0A202060726561736F6E60207661726368617228333029204E4F54204E554C4C2C0A20206066726F6D4461746560207661726368617228333029204E4F54204E554C4C2C0A202060746F4461746560207661726368617228333029204E4F54204E554C4C2C0A2020606C65617665417070726F76657260207661726368617228333029204E4F54204E554C4C2C0A202060706F7374696E674461746560207661726368617228333029204E4F54204E554C4C2C0A202060734E6F6020696E74283131292044454641554C54204E554C4C2C0A202060636F6D70616E7960207661726368617228343029204E4F54204E554C4C2C0A202060656D704E756D62657260207661726368617228323535292044454641554C54204E554C4C2C0A202060646570744E616D6560207661726368617228323535292044454641554C54204E554C4C2C0A20205052494D415259204B45592028606C76617070496460292C0A20204B45592060734E6F60202860734E6F60292C0A2020434F4E53545241494E5420606C656176656170703030316D625F6962666B5F316020464F524549474E204B4559202860734E6F6029205245464552454E4345532060656D706C6F7965653030316D6260202860734E6F60290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D362044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606C656176656170703030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606C656176656170703030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606C656176656170703030316D62602028606C766170704964602C60736572696573602C606C6561766554797065602C60726561736F6E602C6066726F6D44617465602C60746F44617465602C606C65617665417070726F766572602C60706F7374696E6744617465602C60734E6F602C60636F6D70616E79602C60656D704E756D626572602C60646570744E616D6560292056414C554553200A2028322C274C45412F303132272C27417070726F766564272C275369636B272C2731302F31322F32303135272C2731302F31322F32303135272C274872272C2731302F31322F32303135272C4E554C4C2C274D656368616E6963616C272C27537572657368272C4E554C4C292C0A2028342C274C45562F303236272C2752656A6563746564272C2743616E636572272C2731302F31332F32303136272C2731302F30352F32303136272C274D44272C2731302F32362F32303136272C4E554C4C2C2744656C6C272C27454D505F3032272C4E554C4C292C0A2028352C274C45562F303037272C27417070726F766564272C27506572736F6E616C20526561736F6E272C2731302F31392F32303136272C2731302F31312F32303136272C2748524D272C2731302F31392F32303136272C4E554C4C2C274879756E64616920707674204C7464272C27454D505F3036272C4E554C4C293B0A2F2A21343030303020414C544552205441424C4520606C656176656170703030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606C65617665747970653030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606C65617665747970653030316D62603B0A435245415445205441424C4520606C65617665747970653030316D626020280A2020606C767479706549646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606C76747970654E616D6560207661726368617228333029204E4F54204E554C4C2C0A2020606D617864617973416C6C6F7765646020696E7428313129204E4F54204E554C4C2C0A20205052494D415259204B45592028606C7674797065496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D362044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606C65617665747970653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606C65617665747970653030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606C65617665747970653030316D62602028606C76747970654964602C606C76747970654E616D65602C606D617864617973416C6C6F77656460292056414C554553200A2028312C2750726976696C656765272C3230292C0A2028322C2743617375616C272C3530292C0A2028332C274D617465726E697479272C3130292C0A2028352C2750617465726E697479272C3235293B0A2F2A21343030303020414C544552205441424C4520606C65617665747970653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606C6F67696E3030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606C6F67696E3030316D62603B0A435245415445205441424C4520606C6F67696E3030316D626020280A2020606C6F67696E69646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206066697273746E616D6560207661726368617228343529204E4F54204E554C4C2C0A2020606C6173746E616D6560207661726368617228343529204E4F54204E554C4C2C0A202060646F6D61696E60207661726368617228333029204E4F54204E554C4C2C0A202060757365726E616D6560207661726368617228343529204E4F54204E554C4C2C0A20206070617373776F726460207661726368617228363029204E4F54204E554C4C2C0A202060656E61626C6564602074696E79696E74283429204E4F54204E554C4C2044454641554C54202731272C0A20206073656375726974797175657374696F6E60207661726368617228343529204E4F54204E554C4C2C0A2020607365637572697479616E7377657260207661726368617228343529204E4F54204E554C4C2C0A2020606D65737361676560207661726368617228323030292044454641554C54204E554C4C2C0A20205052494D415259204B45592028606C6F67696E696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D34362044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606C6F67696E3030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606C6F67696E3030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606C6F67696E3030316D62602028606C6F67696E6964602C6066697273746E616D65602C606C6173746E616D65602C60646F6D61696E602C60757365726E616D65602C6070617373776F7264602C60656E61626C6564602C6073656375726974797175657374696F6E602C607365637572697479616E73776572602C606D65737361676560292056414C554553200A2028362C27736976616B756D6172272C276B6172756E616D6F6F72746879272C274D616E75666163747572696E67272C2773697661272C2724326124313124586152344E736F43772F557735495257582E376770656E666472504F7638383836536F3342303249636E4C375656452F4A3069376D272C302C27576861742077617320796F7572206368696C64686F6F64206E69636B6E616D65203F272C277469676572313233272C2774657374696E6727292C0A2028372C276B616E6E616E272C276D6174686979616C6167616E272C274D616E75666163747572696E67272C276B616E6E616E272C2724326124313124324E363941476F4C4C4466763070314867727833596541772F643770686B415864584D7379483533394C396A61516D4F4678555636272C302C27576861742077617320796F7572206368696C64686F6F64206E69636B6E616D65203F272C2774657374696E67313233272C2774657374696E6727292C0A2028382C276B617279612054656368272C276B617279612054656368272C274D616E75666163747572696E67272C276B61727961272C272432612431312449526158353749424C624D6952707876642F5059707571664747656D42673765346B4E4B4E66704E68504D4D4D57414E69334E5953272C302C27576861742077617320796F7572206368696C64686F6F64206E69636B6E616D65203F272C2774657374696E67313233272C2774657374696E6727292C0A202834332C27676972696A61272C276B756D617269272C275363686F6F6C272C27676972696A61272C2724326124313124574C2E424C677158536D614C5A2F446D47784B666675755A784F543878576667556E4736774449746E6E38424B5256796478713843272C302C27576861742077617320796F7572206368696C64686F6F64206E69636B6E616D65203F272C2774657374696E67313233343536272C2774657374696E6734353627292C0A202834342C276E6172657368272C276E6172657368272C27427579696E6720486F757365272C276E6172657368272C2724326124313124496C3857567369625066386E48754759706C72696D75662F7565724464535949496B3473475A723035427768766F466A4F6F2E6A2E272C302C27576861742077617320796F7572206368696C64686F6F64206E69636B6E616D65203F272C2774657374696E67313233272C2774657374696E6731323327292C0A202834352C2749737761727961272C27726176696B756D6172272C2743616C6962726174696F6E204C616273272C2769737761727961272C2724326124313124703539484A54416C48736C76715753494246472F507537795776654A6B4E6A556479597A43784A575A585276674456326C384B4A6D272C302C27576861742077617320796F7572206368696C64686F6F64206E69636B6E616D65203F272C2774657374696E67272C277465737427293B0A2F2A21343030303020414C544552205441424C4520606C6F67696E3030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606C76626C6F636B6C6973743030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606C76626C6F636B6C6973743030316D62603B0A435245415445205441424C4520606C76626C6F636B6C6973743030316D626020280A2020606C76626C6F636B49646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060626C6F636B4E616D6560207661726368617228333029204E4F54204E554C4C2C0A202060734E6F6020696E74283131292044454641554C54204E554C4C2C0A202060636F6D70616E7960207661726368617228323535292044454641554C54204E554C4C2C0A20205052494D415259204B45592028606C76626C6F636B496460292C0A20204B45592060734E6F60202860734E6F60292C0A2020434F4E53545241494E5420606C76626C6F636B6C6973743030316D625F6962666B5F316020464F524549474E204B4559202860734E6F6029205245464552454E4345532060656D706C6F7965653030316D6260202860734E6F60290A2920454E47494E453D496E6E6F44422044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606C76626C6F636B6C6973743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606C76626C6F636B6C6973743030316D62602044495341424C45204B455953202A2F3B0A2F2A21343030303020414C544552205441424C4520606C76626C6F636B6C6973743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606D616E75666163747572657365743030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606D616E75666163747572657365743030316D62603B0A435245415445205441424C4520606D616E75666163747572657365743030316D626020280A2020606D616E73657449646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206064697361626C654350616E64545460207661726368617228323029204E4F54204E554C4C2C0A202060616C6C6F774F5460207661726368617228323029204E4F54204E554C4C2C0A202060616C6C6F7750726F64696E686F6C7960207661726368617228323029204E4F54204E554C4C2C0A20206070726F6450657263656E746020646563696D616C2831322C3429204E4F54204E554C4C2C0A2020606261636B666C757368524D60207661726368617228343029204E4F54204E554C4C2C0A2020606361706163697479506C616E60207661726368617228333029204E4F54204E554C4C2C0A20206074696D6562774F7065726E602076617263686172283330292044454641554C54204E554C4C2C0A202060646566776F726B696E50726F67574860207661726368617228353029204E4F54204E554C4C2C0A20206064656646696E676F6F6473574860207661726368617228353029204E4F54204E554C4C2C0A20205052494D415259204B45592028606D616E736574496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D332044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606D616E75666163747572657365743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606D616E75666163747572657365743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606D616E75666163747572657365743030316D62602028606D616E7365744964602C6064697361626C654350616E645454602C60616C6C6F774F54602C60616C6C6F7750726F64696E686F6C79602C6070726F6450657263656E74602C606261636B666C757368524D602C606361706163697479506C616E602C6074696D6562774F7065726E602C60646566776F726B696E50726F675748602C6064656646696E676F6F6473574860292056414C554553200A2028312C2731272C2730272C2731272C2735302E30383030272C27424F4D272C273330272C273130272C27576F726B2D696E2050726F67726573732D57504C272C27416C6C2057617265686F757365732D57504C27293B0A2F2A21343030303020414C544552205441424C4520606D616E75666163747572657365743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606D6174657269616C726571756573743030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606D6174657269616C726571756573743030316D62603B0A435245415445205441424C4520606D6174657269616C726571756573743030316D626020280A20206069646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606974656D60207661726368617228333029204E4F54204E554C4C2C0A20206077617265686F75736560207661726368617228333029204E4F54204E554C4C2C0A20206061637475616C6020696E7428333029204E4F54204E554C4C2C0A2020607265717565737465646020696E7428333029204E4F54204E554C4C2C0A20206072657365727665646020696E7428333029204E4F54204E554C4C2C0A2020606F7264657265646020696E7428333029204E4F54204E554C4C2C0A20206070726F6A65637465646020696E7428333029204E4F54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D352044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606D6174657269616C726571756573743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606D6174657269616C726571756573743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606D6174657269616C726571756573743030316D62602028606964602C606974656D602C6077617265686F757365602C6061637475616C602C60726571756573746564602C607265736572766564602C606F726465726564602C6070726F6A656374656460292056414C554553200A2028312C276D6174657269616C272C2773706C272C31322C32302C31302C32352C3135292C0A2028332C277368616674272C2773706C2D77617265686F757365272C34352C34352C39332C37302C3630293B0A2F2A21343030303020414C544552205441424C4520606D6174657269616C726571756573743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606F70656E70726F646F726465723030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606F70656E70726F646F726465723030316D62603B0A435245415445205441424C4520606F70656E70726F646F726465723030316D626020280A20206070726F6449646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206070726F72646572436F646560207661726368617228333029204E4F54204E554C4C2C0A2020606461746560207661726368617228333029204E4F54204E554C4C2C0A2020606974656D746F4D616E756661637475726560207661726368617228343029204E4F54204E554C4C2C0A202060746F50726F64756365602076617263686172283330292044454641554C54204E554C4C2C0A20206070726F647563656460207661726368617228333029204E4F54204E554C4C2C0A202060656D70436F6D70616E7960207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B455920286070726F64496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D332044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606F70656E70726F646F726465723030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606F70656E70726F646F726465723030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606F70656E70726F646F726465723030316D626020286070726F644964602C6070726F72646572436F6465602C6064617465602C606974656D746F4D616E7566616374757265602C60746F50726F64756365602C6070726F6475636564602C60656D70436F6D70616E7960292056414C554553200A2028312C2750524F5F3030303834272C2731302F32302F32303136272C2742616C6C65657474272C273130272C2736272C2744656C6C27293B0A2F2A21343030303020414C544552205441424C4520606F70656E70726F646F726465723030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606F7065726174696F6E626F6D3030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606F7065726174696F6E626F6D3030316D62603B0A435245415445205441424C4520606F7065726174696F6E626F6D3030316D626020280A2020606F7049646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606F704E616D6560207661726368617228353029204E4F54204E554C4C2C0A202060776F726B73744E616D6560207661726368617228353029204E4F54204E554C4C2C0A20205052494D415259204B45592028606F70496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D372044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606F7065726174696F6E626F6D3030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606F7065726174696F6E626F6D3030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606F7065726174696F6E626F6D3030316D62602028606F704964602C606F704E616D65602C60776F726B73744E616D6560292056414C554553200A2028312C275365747570204669787475726573272C274C6174686527292C0A2028322C27417373656D626C79204F7065726174696F6E272C275061636B696E6720262054657374696E672053746174696F6E27292C0A2028332C2754657374696E67272C275061636B696E6720262054657374696E672053746174696F6E27292C0A2028342C2750726570617265204672616D65272C27417373656D626C792053746174696F6E5F3127292C0A2028362C2742616C6C65742046697474696E67272C275061636B696E6720616E642054657374696E672053746174696F6E27293B0A2F2A21343030303020414C544552205441424C4520606F7065726174696F6E626F6D3030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520606F726465723030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320606F726465723030316D62603B0A435245415445205441424C4520606F726465723030316D626020280A2020604F7264657269646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020604F726465726E616D65602076617263686172283530292044454641554C54204E554C4C2C0A20205052494D415259204B45592028604F72646572696460292C0A2020554E49515545204B455920604F726465726E616D65602028604F726465726E616D6560290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D352044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520606F726465723030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520606F726465723030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20606F726465723030316D62602028604F726465726964602C604F726465726E616D6560292056414C554553200A2028322C27417369616E204A756E6374696F6E27292C0A2028342C2743686F6963657327292C0A2028312C274C616E64736B69702059617264204361726527292C0A2028332C2754776F205065736F7327293B0A2F2A21343030303020414C544552205441424C4520606F726465723030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060706179726F6C6C3030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060706179726F6C6C3030316D62603B0A435245415445205441424C452060706179726F6C6C3030316D626020280A202060707249646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060734E6F6020696E74283131292044454641554C54204E554C4C2C0A20206073746174757360207661726368617228333029204E4F54204E554C4C2C0A20206066697363616C596561726020696E7428313129204E4F54204E554C4C2C0A20206073616C617279536C697060207661726368617228353029204E4F54204E554C4C2C0A202060656D704E616D6560207661726368617228323535292044454641554C54204E554C4C2C0A20205052494D415259204B45592028607072496460292C0A20204B45592060734E6F60202860734E6F60292C0A2020434F4E53545241494E542060706179726F6C6C3030316D625F6962666B5F316020464F524549474E204B4559202860734E6F6029205245464552454E4345532060656D706C6F7965653030316D6260202860734E6F60290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D322044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060706179726F6C6C3030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060706179726F6C6C3030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060706179726F6C6C3030316D626020286070724964602C60734E6F602C60737461747573602C6066697363616C59656172602C6073616C617279536C6970602C60656D704E616D6560292056414C554553200A2028312C4E554C4C2C274472616674272C323031362C273230303030272C274D616E696B616E64616E27293B0A2F2A21343030303020414C544552205441424C452060706179726F6C6C3030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206070726F6365737370723030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206070726F6365737370723030316D62603B0A435245415445205441424C45206070726F6365737370723030316D626020280A20206070726F6365737349646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060734E6F6020696E74283131292044454641554C54204E554C4C2C0A202060796561726020696E7428313129204E4F54204E554C4C2C0A2020606D6F6E74686020696E7428313129204E4F54204E554C4C2C0A202060706F7374696E674461746560207661726368617228333029204E4F54204E554C4C2C0A202060646570744E616D6560207661726368617228323535292044454641554C54204E554C4C2C0A202060656D70436F6D70616E7960207661726368617228323535292044454641554C54204E554C4C2C0A20205052494D415259204B455920286070726F63657373496460292C0A20204B45592060734E6F60202860734E6F60292C0A2020434F4E53545241494E54206070726F6365737370723030316D625F6962666B5F316020464F524549474E204B4559202860734E6F6029205245464552454E4345532060656D706C6F7965653030316D6260202860734E6F60290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D322044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206070726F6365737370723030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206070726F6365737370723030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206070726F6365737370723030316D626020286070726F636573734964602C60734E6F602C6079656172602C606D6F6E7468602C60706F7374696E6744617465602C60646570744E616D65602C60656D70436F6D70616E7960292056414C554553200A2028312C4E554C4C2C323031362C312C2731302F30312F32303136272C274C6567616C272C2744656C6C27293B0A2F2A21343030303020414C544552205441424C45206070726F6365737370723030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206070726F646F726465723030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206070726F646F726465723030316D62603B0A435245415445205441424C45206070726F646F726465723030316D626020280A202060707249646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606974656D746F4D616E756661637475726560207661726368617228343029204E4F54204E554C4C2C0A20206073746174757360207661726368617228333029204E4F54204E554C4C2C0A20206070726F72646572436F646560207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B45592028607072496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D31322044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206070726F646F726465723030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206070726F646F726465723030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206070726F646F726465723030316D626020286070724964602C606974656D746F4D616E7566616374757265602C60737461747573602C6070726F72646572436F646560292056414C554553200A2028312C2742616C6C65657474272C274472616674272C2750524F5F303030383427292C0A2028382C2746726F6E7420446F6F72272C27436F6D706C65746564272C2750524F5F3030303927293B0A2F2A21343030303020414C544552205441424C45206070726F646F726465723030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206070726F64706C616E3030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206070726F64706C616E3030316D62603B0A435245415445205441424C45206070726F64706C616E3030316D626020280A2020607072706C616E49646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606765744974656D7360207661726368617228343029204E4F54204E554C4C2C0A2020606974656D436F646560207661726368617228343029204E4F54204E554C4C2C0A202060626F6D4E6F60207661726368617228333029204E4F54204E554C4C2C0A202060706C616E6E656451747960207661726368617228343029204E4F54204E554C4C2C0A20206070656E64696E6751747960207661726368617228333029204E4F54204E554C4C2C0A2020606465736372697074696F6E6020766172636861722831303029204E4F54204E554C4C2C0A20205052494D415259204B45592028607072706C616E496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D352044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206070726F64706C616E3030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206070726F64706C616E3030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206070726F64706C616E3030316D62602028607072706C616E4964602C606765744974656D73602C606974656D436F6465602C60626F6D4E6F602C60706C616E6E6564517479602C6070656E64696E67517479602C606465736372697074696F6E60292056414C554553200A2028312C2753616C6573204F72646572272C2754412D5455423132272C2738363836272C273130272C2734272C2727292C0A2028332C274D6174657269616C2052657175657374272C275368616674272C2737383738272C2739272C2732272C2750726F64756374207175616C69747920697320706F6F7227292C0A2028342C274D6174657269616C2052657175657374272C275368616674272C2738363836272C273130272C2732272C2750726F64756374206973206120676F6F64207175616C69747927293B0A2F2A21343030303020414C544552205441424C45206070726F64706C616E3030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206070726F6473746F636B656E7472793030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206070726F6473746F636B656E7472793030316D62603B0A435245415445205441424C45206070726F6473746F636B656E7472793030316D626020280A202060707273746F636B49646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020607469746C6560207661726368617228353029204E4F54204E554C4C2C0A20206073746174757360207661726368617228343029204E4F54204E554C4C2C0A202060707572706F736560207661726368617228353029204E4F54204E554C4C2C0A20206073746F636B456E74727960207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B4559202860707273746F636B496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D362044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206070726F6473746F636B656E7472793030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206070726F6473746F636B656E7472793030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206070726F6473746F636B656E7472793030316D6260202860707273746F636B4964602C607469746C65602C60737461747573602C60707572706F7365602C6073746F636B456E74727960292056414C554553200A2028312C274D6174657269616C73205472616E7366657220666F72204D616E7566616374757265272C274472616674272C274D6174657269616C205472616E73666572272C275354452D303030543227292C0A2028322C274D6174657269616C73205472616E73666572272C274E6F7473746172746564272C274D616E7566616374757265272C275354452D303054363127292C0A2028332C274D6174657269616C732052656365697074272C2753746F70706564272C2752656365697074272C275354452D303030545427292C0A2028352C274D6174657269616C73205472616E73666572272C27496E2D50726F63657373272C274D616E7566616374757265272C275354452D303054363127293B0A2F2A21343030303020414C544552205441424C45206070726F6473746F636B656E7472793030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206070726F6474696D6573686565743030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206070726F6474696D6573686565743030316D62603B0A435245415445205441424C45206070726F6474696D6573686565743030316D626020280A20206070727449646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060656D704E616D6560207661726368617228343029204E4F54204E554C4C2C0A20206074734E616D6560207661726368617228353029204E4F54204E554C4C2C0A20206073746174757360207661726368617228353029204E4F54204E554C4C2C0A202060656D70436F6D70616E7960207661726368617228343029204E4F54204E554C4C2C0A202060747768727360207661726368617228343029204E4F54204E554C4C2C0A20205052494D415259204B4559202860707274496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D362044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206070726F6474696D6573686565743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206070726F6474696D6573686565743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206070726F6474696D6573686565743030316D62602028607072744964602C60656D704E616D65602C6074734E616D65602C60737461747573602C60656D70436F6D70616E79602C60747768727360292056414C554553200A2028312C2742616C61272C2774696D652073686565745F31272C274472616674272C2744656C6C272C273827292C0A2028322C27486172697368272C2774696D652073686565745F32272C275375626D6974746564272C274879756E64616920707674204C7464272C27313027292C0A2028352C27486174737565204B6173686977616769272C2774696D6573686565745F303939272C2753746F70706564272C27576865656C7320496E646961272C273827293B0A2F2A21343030303020414C544552205441424C45206070726F6474696D6573686565743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206070726F6770726F646F726465723030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206070726F6770726F646F726465723030316D62603B0A435245415445205441424C45206070726F6770726F646F726465723030316D626020280A20206070726F6449646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206070726F72646572436F646560207661726368617228333029204E4F54204E554C4C2C0A2020606461746560207661726368617228333029204E4F54204E554C4C2C0A2020606974656D746F4D616E756661637475726560207661726368617228343029204E4F54204E554C4C2C0A202060746F50726F64756365602076617263686172283330292044454641554C54204E554C4C2C0A20206070726F647563656460207661726368617228333029204E4F54204E554C4C2C0A202060656D70436F6D70616E7960207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B455920286070726F64496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D332044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206070726F6770726F646F726465723030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206070726F6770726F646F726465723030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206070726F6770726F646F726465723030316D626020286070726F644964602C6070726F72646572436F6465602C6064617465602C606974656D746F4D616E7566616374757265602C60746F50726F64756365602C6070726F6475636564602C60656D70436F6D70616E7960292056414C554553200A2028312C2750524F5F3030303834272C2731302F32302F32303136272C2742616C6C65657474272C273130272C2736272C2744656C6C27293B0A2F2A21343030303020414C544552205441424C45206070726F6770726F646F726465723030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206070726F6A6563743030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206070726F6A6563743030316D62603B0A435245415445205441424C45206070726F6A6563743030316D626020280A20206069646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206070726F6A6563746E616D6560207661726368617228333029204E4F54204E554C4C2C0A202060657374696D61746564636F73746020696E7428313129204E4F54204E554C4C2C0A202060656E646461746560207661726368617228353029204E4F54204E554C4C2C0A20206073746172746461746560207661726368617228353029204E4F54204E554C4C2C0A20206073746174757360207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D31312044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206070726F6A6563743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206070726F6A6563743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206070726F6A6563743030316D62602028606964602C6070726F6A6563746E616D65602C60657374696D61746564636F7374602C60656E6464617465602C60737461727464617465602C6073746174757360292056414C554553200A2028312C27496E74656C6C6F72272C302C27272C27272C27696E69746174656427292C0A2028392C276B617061272C34352C2730392F32372F32303136272C2730392F32372F32303136272C276F70656E656427292C0A202831302C27656E746974797761676574696E67272C39362C2731302F32302F32303136272C2731302F31352F32303136272C276F70656E656427293B0A2F2A21343030303020414C544552205441424C45206070726F6A6563743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520607075726368617365726563656970743030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320607075726368617365726563656970743030316D62603B0A435245415445205441424C4520607075726368617365726563656970743030316D626020280A20206069646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060737570706C69657260207661726368617228333029204E4F54204E554C4C2C0A2020604461746560207661726368617228333029204E4F54204E554C4C2C0A202060737570706C6965726164647265737360207661726368617228333029204E4F54204E554C4C2C0A2020606772616E64746F74616C60207661726368617228333029204E4F54204E554C4C2C0A20206073746174757360207661726368617228353029204E4F54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D332044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520607075726368617365726563656970743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520607075726368617365726563656970743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20607075726368617365726563656970743030316D62602028606964602C60737570706C696572602C6044617465602C60737570706C69657261646472657373602C606772616E64746F74616C602C6073746174757360292056414C554553200A2028312C27736F6C7574696F6E73272C2731322D30382D32303136272C27736F6C7574696F6E73272C27313030272C27746F62696C6C27292C0A2028322C27736F6C7574696F6E73272C2731322D30382D32303136272C27736F6C7574696F6E73272C27313030272C27746F62696C6C27293B0A2F2A21343030303020414C544552205441424C4520607075726368617365726563656970743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060726563727569746170706C6963616E743030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060726563727569746170706C6963616E743030316D62603B0A435245415445205441424C452060726563727569746170706C6963616E743030316D626020280A20206061707049646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606170706C6963616E744E616D6560207661726368617228343029204E4F54204E554C4C2C0A20206073746174757360207661726368617228333029204E4F54204E554C4C2C0A2020606A6F6249646020696E74283131292044454641554C54204E554C4C2C0A2020606A6F624E616D6560207661726368617228323535292044454641554C54204E554C4C2C0A20205052494D415259204B4559202860617070496460292C0A20204B455920606A6F624964602028606A6F62496460292C0A2020434F4E53545241494E542060726563727569746170706C6963616E743030316D625F6962666B5F316020464F524549474E204B45592028606A6F6249646029205245464552454E4345532060726563727569746F70656E696E673030316D62602028606A6F62496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D342044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060726563727569746170706C6963616E743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060726563727569746170706C6963616E743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060726563727569746170706C6963616E743030316D62602028606170704964602C606170706C6963616E744E616D65602C60737461747573602C606A6F624964602C606A6F624E616D6560292056414C554553200A2028312C2773616E6A6179272C277265706C696564272C312C4E554C4C292C0A2028322C27726F686974272C27686F6C64272C312C27646576656C6F706D656E7427292C0A2028332C27796F67657368272C276F70656E272C322C2774657374696E6727293B0A2F2A21343030303020414C544552205441424C452060726563727569746170706C6963616E743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060726563727569746F666665723030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060726563727569746F666665723030316D62603B0A435245415445205441424C452060726563727569746F666665723030316D626020280A2020606F6666657249646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606170706C6963616E744E616D6560207661726368617228333029204E4F54204E554C4C2C0A20206073746174757360207661726368617228333029204E4F54204E554C4C2C0A2020606F666665724C657474657260207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B45592028606F66666572496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D382044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060726563727569746F666665723030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060726563727569746F666665723030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060726563727569746F666665723030316D62602028606F666665724964602C606170706C6963616E744E616D65602C60737461747573602C606F666665724C657474657260292056414C554553200A2028312C2742616C616A69272C275375626D6974746564272C276F666665725F3030303127292C0A2028322C275368697661272C274472616674272C276F666665725F3030303927292C0A2028352C274B756D6172272C275375626D6974746564272C276F666665725F3038373127292C0A2028372C274E616E64696E69272C2743616E63656C6C6564272C276F666665725F3039313227293B0A2F2A21343030303020414C544552205441424C452060726563727569746F666665723030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060726563727569746F70656E696E673030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060726563727569746F70656E696E673030316D62603B0A435245415445205441424C452060726563727569746F70656E696E673030316D626020280A2020606A6F6249646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606A6F624E616D6560207661726368617228343029204E4F54204E554C4C2C0A20206073746174757360207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B45592028606A6F62496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D352044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060726563727569746F70656E696E673030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060726563727569746F70656E696E673030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060726563727569746F70656E696E673030316D62602028606A6F624964602C606A6F624E616D65602C6073746174757360292056414C554553200A2028312C27646576656C6F706D656E74272C276F70656E27292C0A2028322C2774657374696E67272C27636C6F73656427292C0A2028342C27427573696E65737320416E616C797374272C27636C6F73656427293B0A2F2A21343030303020414C544552205441424C452060726563727569746F70656E696E673030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060726F6C653030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060726F6C653030316D62603B0A435245415445205441424C452060726F6C653030316D626020280A202060726F6C6569646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060726F6C656E616D6560207661726368617228343529204E4F54204E554C4C2C0A202060737461747573602074696E79696E74283429204E4F54204E554C4C2044454641554C54202731272C0A20205052494D415259204B4559202860726F6C65696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D352044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060726F6C653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060726F6C653030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060726F6C653030316D6260202860726F6C656964602C60726F6C656E616D65602C6073746174757360292056414C554553200A2028312C27524F4C455F41444D494E272C31292C0A2028322C27524F4C455F53555045525F55534552272C31292C0A2028332C27524F4C455F55534552272C31292C0A2028342C27524F4C455F4755455354272C31293B0A2F2A21343030303020414C544552205441424C452060726F6C653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206073616C617279636F6D706F6E656E743030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206073616C617279636F6D706F6E656E743030316D62603B0A435245415445205441424C45206073616C617279636F6D706F6E656E743030316D626020280A20206073616C636F6D7049646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060636F6D4E616D65602076617263686172283530292044454641554C54204E554C4C2C0A20206061626272602076617263686172283330292044454641554C54204E554C4C2C0A20205052494D415259204B455920286073616C636F6D70496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D31302044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206073616C617279636F6D706F6E656E743030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206073616C617279636F6D706F6E656E743030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206073616C617279636F6D706F6E656E743030316D626020286073616C636F6D704964602C60636F6D4E616D65602C606162627260292056414C554553200A2028312C2750415920415320594F55204541524E272C275041594527292C0A2028322C27496E636F6D6520546178272C27495427292C0A2028332C274852412D4C4F4C272C2748524127292C0A2028342C274261736963204561726E696E67272C27424527292C0A2028352C274D792042617369632053616C617279272C274D27292C0A2028362C274C6F6E20646F64272C274C4427292C0A2028382C274F76657274696D65272C274F5427292C0A2028392C274261736963272C27414E4327293B0A2F2A21343030303020414C544552205441424C45206073616C617279636F6D706F6E656E743030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206073616C6172797374727563747572653030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206073616C6172797374727563747572653030316D62603B0A435245415445205441424C45206073616C6172797374727563747572653030316D626020280A20206073747249646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060656D704E616D65602076617263686172283330292044454641554C54204E554C4C2C0A202060697341637469766560207661726368617228323029204E4F54204E554C4C2C0A20206066726F6D44617465602076617263686172283330292044454641554C54204E554C4C2C0A20205052494D415259204B4559202860737472496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D342044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206073616C6172797374727563747572653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206073616C6172797374727563747572653030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206073616C6172797374727563747572653030316D62602028607374724964602C60656D704E616D65602C606973416374697665602C6066726F6D4461746560292056414C554553200A2028312C2742616C61272C27596573272C2731322F31322F3230313427292C0A2028322C2742616C61272C27596573272C2731302F32322F3230313627292C0A2028332C274D616E696B616E64616E272C27596573272C2731302F30352F3230313627293B0A2F2A21343030303020414C544552205441424C45206073616C6172797374727563747572653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206073616C65736F726465723030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206073616C65736F726465723030316D62603B0A435245415445205441424C45206073616C65736F726465723030316D626020280A202060536F726465726020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060437573746F6D65726E616D6560207661726368617228353029204E4F54204E554C4C2C0A2020604370757263686173656F72646572602076617263686172283630292044454641554C54204E554C4C2C0A2020605374617475736E616D6560207661726368617228323535292044454641554C54204E554C4C2C0A2020604974656D69646020696E74283131292044454641554C54204E554C4C2C0A2020604F7264657269646020696E74283131292044454641554C54204E554C4C2C0A2020604974656D636F6465602076617263686172283430292044454641554C54204E554C4C2C0A2020604F726465726E616D6560207661726368617228323535292044454641554C54204E554C4C2C0A20206053746174757369646020696E74283131292044454641554C54204E554C4C2C0A2020605364656C697665727964617465602076617263686172283430292044454641554C54204E554C4C2C0A202060536F7264657264617465602076617263686172283430292044454641554C54204E554C4C2C0A20205052494D415259204B4559202860536F7264657260292C0A20204B455920604974656D6964602028604974656D696460292C0A20204B455920604F726465726964602028604F72646572696460292C0A2020434F4E53545241494E54206073616C65736F726465723030316D625F6962666B5F316020464F524549474E204B45592028604974656D69646029205245464552454E43455320606974656D64743030316D62602028604974656D696460292C0A2020434F4E53545241494E54206073616C65736F726465723030316D625F6962666B5F326020464F524549474E204B45592028604F7264657269646029205245464552454E43455320606F726465723030316D62602028604F72646572696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D38392044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206073616C65736F726465723030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206073616C65736F726465723030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206073616C65736F726465723030316D6260202860536F72646572602C60437573746F6D65726E616D65602C604370757263686173656F72646572602C605374617475736E616D65602C604974656D6964602C604F726465726964602C604974656D636F6465602C604F726465726E616D65602C605374617475736964602C605364656C697665727964617465602C60536F726465726461746560292056414C554553200A202837392C2747697269272C276F7264657231272C27546F2044656C69766572272C312C322C2757696E67205368656574272C27417369616E204A756E6374696F6E272C4E554C4C2C2731302F32312F32303136272C2731302F30312F3230313627292C0A202838302C2744697661676172272C276F7264657232272C27546F2042696C6C272C322C342C2757696E64204D496C6C204320536572696573272C2743686F69636573272C4E554C4C2C2731302F32392F32303136272C2730392F32392F3230313627292C0A202838312C2756656E6B6174272C276F7264657233272C274472616674272C332C312C2757696E642054757262696E652D4C272C274C616E64736B697020596172642043617265272C4E554C4C2C2731312F30352F32303136272C2730392F32352F3230313627292C0A202838322C27507261736164272C276F7264657234272C27436F6D706C65746564272C32312C332C2757696E64204D696C6C204120536572696573272C2754776F205065736F73272C4E554C4C2C2731312F30342F32303136272C2730392F32352F3230313627292C0A202838332C274769726920507261736164272C276F7264657235272C27436C6F736564272C32322C322C275461626C65272C27417369616E204A756E6374696F6E272C4E554C4C2C2731312F30332F32303136272C2730392F33302F3230313627292C0A202838342C274B61626972272C276F7264657236272C2743616E63656C6C6564272C32342C342C275368616674272C2743686F69636573272C4E554C4C2C2731312F30322F32303136272C2730392F32352F3230313627292C0A202838352C2749736C616D272C276F7264657237272C27546F2044656C69766572272C32352C312C27496E7465726E616C2044697363272C274C616E64736B697020596172642043617265272C4E554C4C2C2731312F31352F32303136272C2730392F30362F3230313627292C0A202838362C2753697661272C276F7264657238272C27546F2042696C6C272C32362C332C274D6F62696C65272C2754776F205065736F73272C4E554C4C2C2731312F32362F32303136272C2730392F30372F3230313627292C0A202838372C2752616775272C276F7264657239272C274472616674272C32372C322C27436F6D7075746572272C27417369616E204A756E6374696F6E272C4E554C4C2C2731322F31302F32303136272C2730392F30312F3230313627292C0A202838382C274E6172657368272C276F726465723130272C274472616674272C32382C342C274368616972272C2743686F69636573272C4E554C4C2C2731302F32392F32303136272C2731312F30322F3230313627293B0A2F2A21343030303020414C544552205441424C45206073616C65736F726465723030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520607374617475733030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320607374617475733030316D62603B0A435245415445205441424C4520607374617475733030316D626020280A20206053746174757369646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020605374617475736E616D65602076617263686172283430292044454641554C54204E554C4C2C0A20205052494D415259204B4559202860537461747573696460292C0A2020554E49515545204B455920605374617475736E616D65602028605374617475736E616D6560290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D372044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520607374617475733030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520607374617475733030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20607374617475733030316D62602028605374617475736964602C605374617475736E616D6560292056414C554553200A2028362C2743616E63656C6C656427292C0A2028352C27436C6F73656427292C0A2028332C27436F6D706C6574656427292C0A2028322C27447261667427292C0A2028342C27546F2042696C6C27292C0A2028312C27546F2044656C6976657227293B0A2F2A21343030303020414C544552205441424C4520607374617475733030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206073746F636B616765696E673030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206073746F636B616765696E673030316D62603B0A435245415445205441424C45206073746F636B616765696E673030316D626020280A20206069646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606974656D636F646560207661726368617228333029204E4F54204E554C4C2C0A2020606974656D6E616D6560207661726368617228333029204E4F54204E554C4C2C0A2020606465736372697074696F6E60207661726368617228333029204E4F54204E554C4C2C0A2020606974656D67726F757060207661726368617228333029204E4F54204E554C4C2C0A2020606272616E6460207661726368617228333029204E4F54204E554C4C2C0A202060617665726167656167656020696E7428333029204E4F54204E554C4C2C0A2020606561726C69657374602074696E79696E74283129204E4F54204E554C4C2C0A2020606C6174657374602074696E79696E74283129204E4F54204E554C4C2C0A202060756F6D60207661726368617228333029204E4F54204E554C4C2C0A20206061637475616C6020696E74283131292044454641554C54204E554C4C2C0A2020606974656D60207661726368617228323535292044454641554C54204E554C4C2C0A2020606F7264657265646020696E74283131292044454641554C54204E554C4C2C0A20206070726F6A65637465646020696E74283131292044454641554C54204E554C4C2C0A2020607265717565737465646020696E74283131292044454641554C54204E554C4C2C0A20206072657365727665646020696E74283131292044454641554C54204E554C4C2C0A20206077617265686F75736560207661726368617228323535292044454641554C54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D342044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206073746F636B616765696E673030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206073746F636B616765696E673030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206073746F636B616765696E673030316D62602028606964602C606974656D636F6465602C606974656D6E616D65602C606465736372697074696F6E602C606974656D67726F7570602C606272616E64602C6061766572616765616765602C606561726C69657374602C606C6174657374602C60756F6D602C6061637475616C602C606974656D602C606F726465726564602C6070726F6A6563746564602C60726571756573746564602C607265736572766564602C6077617265686F75736560292056414C554553200A2028312C276D6174657269616C272C277368616674272C277261776D6165747269616C272C2762696C6C696E67272C27676F6F64272C352C312C302C276E6F73272C4E554C4C2C4E554C4C2C4E554C4C2C4E554C4C2C4E554C4C2C4E554C4C2C4E554C4C292C0A2028322C277461626C65272C277261776D6174657269616C272C277261776D6174727269616C62696C6C696E67272C277461626C65272C27676F6F64272C372C302C302C276E756D626572737373272C4E554C4C2C4E554C4C2C4E554C4C2C4E554C4C2C4E554C4C2C4E554C4C2C4E554C4C293B0A2F2A21343030303020414C544552205441424C45206073746F636B616765696E673030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206073746F636B62616C616E63653030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206073746F636B62616C616E63653030316D62603B0A435245415445205441424C45206073746F636B62616C616E63653030316D626020280A20206069646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606974656D60207661726368617228333029204E4F54204E554C4C2C0A2020606974656D6E616D6560207661726368617228333029204E4F54204E554C4C2C0A2020606974656D67726F757060207661726368617228333029204E4F54204E554C4C2C0A2020606272616E6460207661726368617228333029204E4F54204E554C4C2C0A2020606465736372697074696F6E60207661726368617228333029204E4F54204E554C4C2C0A20206077617265686F75736560207661726368617228333029204E4F54204E554C4C2C0A20206073746F636B756F6D60207661726368617228333029204E4F54204E554C4C2C0A2020606F70656E696E677174796020646563696D616C28332C3129204E4F54204E554C4C2C0A2020606F70656E696E6776616C75656020646563696D616C28332C3129204E4F54204E554C4C2C0A202060696E7174796020646563696D616C28332C3129204E4F54204E554C4C2C0A202060696E76616C75656020646563696D616C28332C3129204E4F54204E554C4C2C0A2020606F75747174796020646563696D616C28332C3129204E4F54204E554C4C2C0A2020606F757476616C75656020646563696D616C28332C3129204E4F54204E554C4C2C0A20206062616C7174796020646563696D616C28332C3129204E4F54204E554C4C2C0A20206062616C76616C75656020646563696D616C28332C3129204E4F54204E554C4C2C0A20206076616C69646174696F6E7261746560207661726368617228333029204E4F54204E554C4C2C0A202060636F6D70616E7960207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D322044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206073746F636B62616C616E63653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206073746F636B62616C616E63653030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206073746F636B62616C616E63653030316D62602028606964602C606974656D602C606974656D6E616D65602C606974656D67726F7570602C606272616E64602C606465736372697074696F6E602C6077617265686F757365602C6073746F636B756F6D602C606F70656E696E67717479602C606F70656E696E6776616C7565602C60696E717479602C60696E76616C7565602C606F7574717479602C606F757476616C7565602C6062616C717479602C6062616C76616C7565602C6076616C69646174696F6E72617465602C60636F6D70616E7960292056414C554553200A2028312C277368616674272C27626C616465272C277261776D6174657269616C272C276E696365272C27676F6F64206D6174657261696C272C2773706C272C276E6F73272C27312E30272C2731302E30272C27322E30272C27352E30272C2731302E30272C2734352E30272C2735382E30272C2731322E30272C273134272C2778797A27293B0A2F2A21343030303020414C544552205441424C45206073746F636B62616C616E63653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206073746F636B656E7472793030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206073746F636B656E7472793030316D62603B0A435245415445205441424C45206073746F636B656E7472793030316D626020280A20206073746F636B69646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606D6174657269616C7265717565737460207661726368617228333029204E4F54204E554C4C2C0A2020606461746560207661726368617228333029204E4F54204E554C4C2C0A2020605175616E746974796020696E74283131292044454641554C54204E554C4C2C0A2020605472616E7366657265645174796020646563696D616C28332C3129204E4F54204E554C4C2C0A202060517479746F7472616E736665726020646563696D616C28332C3129204E4F54204E554C4C2C0A2020606465736372697074696F6E60207661726368617228333029204E4F54204E554C4C2C0A202060636F6D70616E7960207661726368617228343029204E4F54204E554C4C2C0A2020606974656D69646020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A20205052494D415259204B455920286073746F636B696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D37322044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206073746F636B656E7472793030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206073746F636B656E7472793030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206073746F636B656E7472793030316D626020286073746F636B6964602C606D6174657269616C72657175657374602C6064617465602C605175616E74697479602C605472616E736665726564517479602C60517479746F7472616E73666572602C606465736372697074696F6E602C60636F6D70616E79602C606974656D696460292056414C554553200A2028312C274D52452D303031272C27323031352D30322D3036272C38382C2734302E30272C2739382E30272C2773706F72746974656D73272C274C4C43272C31292C0A2028322C274D52452D303032272C27323031342D30322D3036272C37382C2735302E30272C2736382E30272C2773706F72746974656D73272C27414243272C31292C0A2028392C274D52452D303039272C27323031352D30322D3039272C302C2732312E39272C2737382E33272C2773706F727473272C2773706F727473636F6D70616E79272C31292C0A202831342C274D52452D303036272C27323031392D30322D3033272C302C27302E30272C27302E30272C276D6574616C272C2773706F727473636F6D70616E79272C3231292C0A202831352C274D52452D303037272C27323031392D30322D3033272C34352C2734352E38272C2734352E33272C276D6574616C272C2773706F727473636F6D70616E79272C32292C0A202831382C274D52452D30303631272C27323031392D30322D3033272C32332C2734352E33272C2732332E33272C2773706F727473333639272C2773706F727473636F6D70616E79333639272C3232292C0A202832352C274D52452D30303139272C2731302F30352F32303136272C33362C2732332E36272C2734352E36272C276D6574616C313233272C276D6574616C636F6D70616E79313233272C3232292C0A202837312C274D525F303032272C2731302F30332F32303136272C37382C2732352E33272C2735382E33272C276D6174657269616C272C2778797A272C3232293B0A2F2A21343030303020414C544552205441424C45206073746F636B656E7472793030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206073746F636B6C65646765723030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206073746F636B6C65646765723030316D62603B0A435245415445205441424C45206073746F636B6C65646765723030316D626020280A20206069646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606461746560207661726368617228333029204E4F54204E554C4C2C0A2020606974656D60207661726368617228333029204E4F54204E554C4C2C0A2020606974656D6E616D6560207661726368617228333029204E4F54204E554C4C2C0A2020606974656D67726F757060207661726368617228333029204E4F54204E554C4C2C0A2020606272616E6460207661726368617228333029204E4F54204E554C4C2C0A2020606465736372697074696F6E60207661726368617228333029204E4F54204E554C4C2C0A20206077617265686F75736560207661726368617228333029204E4F54204E554C4C2C0A20206073746F636B756F6D60207661726368617228333029204E4F54204E554C4C2C0A2020607174796020696E7428333029204E4F54204E554C4C2C0A20206062616C616E63657174796020696E7428333029204E4F54204E554C4C2C0A202060696E636F6D696E67726174656020696E7428333029204E4F54204E554C4C2C0A20206076616C756174696F6E726174656020696E7428333029204E4F54204E554C4C2C0A20206062616C616E636576616C75656020696E7428333029204E4F54204E554C4C2C0A202060766F75636865727479706560207661726368617228333029204E4F54204E554C4C2C0A202060766F75636865726E6F6020696E7428333029204E4F54204E554C4C2C0A20206062617463686020696E7428333029204E4F54204E554C4C2C0A20206073657269616C6E6F6020696E7428333029204E4F54204E554C4C2C0A202060636F6D70616E7960207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D322044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206073746F636B6C65646765723030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206073746F636B6C65646765723030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206073746F636B6C65646765723030316D62602028606964602C6064617465602C606974656D602C606974656D6E616D65602C606974656D67726F7570602C606272616E64602C606465736372697074696F6E602C6077617265686F757365602C6073746F636B756F6D602C60717479602C6062616C616E6365717479602C60696E636F6D696E6772617465602C6076616C756174696F6E72617465602C6062616C616E636576616C7565602C60766F756368657274797065602C60766F75636865726E6F602C606261746368602C6073657269616C6E6F602C60636F6D70616E7960292056414C554553200A2028312C2732302D30382D31393930272C2773746F636B272C277368616674272C277261776D6174657269616C272C27676F6F64272C276E696365272C2773706C272C276E6F73272C31302C31322C32352C34352C38352C276D6174657269616C74797065272C31302C322C352C2778797A27293B0A2F2A21343030303020414C544552205441424C45206073746F636B6C65646765723030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C6520607461736B3030316D62600A2D2D0A0A44524F50205441424C452049462045584953545320607461736B3030316D62603B0A435245415445205441424C4520607461736B3030316D626020280A2020607461736B69646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020607461736B6465736372697074696F6E60207661726368617228333029204E4F54204E554C4C2C0A20206041737369676E546F60207661726368617228333029204E4F54204E554C4C2C0A20206041737369676E427960207661726368617228333029204E4F54204E554C4C2C0A20206073746174757360207661726368617228333029204E4F54204E554C4C2C0A20205052494D415259204B45592028607461736B696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D31372044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C6520607461736B3030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C4520607461736B3030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F20607461736B3030316D62602028607461736B6964602C607461736B6465736372697074696F6E602C6041737369676E546F602C6041737369676E4279602C6073746174757360292056414C554553200A202831332C27496E74656C6C6F722054657374696E67272C2733272C2732272C276F70656E27292C0A202831342C27496E74656C6C6F7220446576272C2732272C2733272C276F70656E27292C0A202831352C27496E74656C6C6F72205065726C20536372697074272C2731272C2732272C276F70656E27292C0A202831362C275665726961746F20446576272C2731272C2732272C276F70656E27293B0A2F2A21343030303020414C544552205441424C4520607461736B3030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206074657374636173653030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206074657374636173653030316D62603B0A435245415445205441424C45206074657374636173653030316D626020280A20206049446020626967696E7428323029204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206041535349474E544F6020766172636861722832353529204E4F54204E554C4C2C0A2020604155544F4D415445446020766172636861722832353529204E4F54204E554C4C2C0A202060444154455550444154454460206461746574696D65204E4F54204E554C4C2C0A20206045584543545950456020766172636861722832353529204E4F54204E554C4C2C0A202060464F4C4445524E414D456020766172636861722832353529204E4F54204E554C4C2C0A2020604C5354524E42596020766172636861722832353529204E4F54204E554C4C2C0A2020604C5354524E4441544560206461746574696D65204E4F54204E554C4C2C0A2020604C5354524E52454C454153456020766172636861722832353529204E4F54204E554C4C2C0A2020604C5354524E5354415455536020766172636861722832353529204E4F54204E554C4C2C0A2020604C5354524E544553545345546020766172636861722832353529204E4F54204E554C4C2C0A2020604F524947494E414C49446020766172636861722832353529204E4F54204E554C4C2C0A2020604F574E45526020766172636861722832353529204E4F54204E554C4C2C0A2020605052494F5249545960207661726368617228323535292044454641554C54204E554C4C2C0A20206052455649455745446020766172636861722832353529204E4F54204E554C4C2C0A202060524E4259484F53546020766172636861722832353529204E4F54204E554C4C2C0A20206052554E54494D456020766172636861722832353529204E4F54204E554C4C2C0A2020605354415455536020766172636861722832353529204E4F54204E554C4C2C0A20206054455354545950456020766172636861722832353529204E4F54204E554C4C2C0A2020605449544C456020766172636861722832353529204E4F54204E554C4C2C0A20206056455253494F4E6020766172636861722832353529204E4F54204E554C4C2C0A20205052494D415259204B4559202860494460290A2920454E47494E453D496E6E6F44422044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206074657374636173653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206074657374636173653030316D62602044495341424C45204B455953202A2F3B0A2F2A21343030303020414C544552205441424C45206074657374636173653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060747265656E6F64653030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060747265656E6F64653030316D62603B0A435245415445205441424C452060747265656E6F64653030316D626020280A20206049446020626967696E7428323029204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020604953504152454E546020766172636861722832353529204E4F54204E554C4C2C0A2020605049446020766172636861722832353529204E4F54204E554C4C2C0A202060504152454E544E414D456020766172636861722832353529204E4F54204E554C4C2C0A20205052494D415259204B4559202860494460290A2920454E47494E453D496E6E6F44422044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060747265656E6F64653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060747265656E6F64653030316D62602044495341424C45204B455953202A2F3B0A2F2A21343030303020414C544552205441424C452060747265656E6F64653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060747269616C62616C616E63653030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060747269616C62616C616E63653030316D62603B0A435245415445205441424C452060747269616C62616C616E63653030316D626020280A20206069646020696E742831302920756E7369676E6564204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606163636F756E7460207661726368617228343529204E4F54204E554C4C2C0A2020606F70656E696E6763726020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A2020606F70656E696E6764726020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A202060636C6F73696E6763726020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A202060636C6F73696E6764726020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A2020606372656469746020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A20206064656269746020696E742831302920756E7369676E6564204E4F54204E554C4C2C0A20205052494D415259204B4559202860696460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D332044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060747269616C62616C616E63653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060747269616C62616C616E63653030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060747269616C62616C616E63653030316D62602028606964602C606163636F756E74602C606F70656E696E676372602C606F70656E696E676472602C60636C6F73696E676372602C60636C6F73696E676472602C60637265646974602C60646562697460292056414C554553200A2028312C276163636F756E74272C31312C31312C31312C31312C31312C3131293B0A2F2A21343030303020414C544552205441424C452060747269616C62616C616E63653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060757365723030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060757365723030316D62603B0A435245415445205441424C452060757365723030316D626020280A2020607573657269646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A20206075736572726F6C6569646020696E7428313129204E4F54204E554C4C2C0A20206066697273746E616D6560207661726368617228333029204E4F54204E554C4C2C0A2020606C6173746E616D6560207661726368617228333029204E4F54204E554C4C2C0A2020607A6970636F64656020696E74283131292044454641554C54204E554C4C2C0A202060646F626020646174652044454641554C54204E554C4C2C0A202060656D61696C60207661726368617228333029204E4F54204E554C4C2C0A202060636F6E6669726D656D61696C60207661726368617228333029204E4F54204E554C4C2C0A202060736578602074696E79696E74283429204E4F54204E554C4C2C0A202060616464726573733160207661726368617228353029204E4F54204E554C4C2C0A202060616464726573733260207661726368617228353029204E4F54204E554C4C2C0A202060616464726573733360207661726368617228353029204E4F54204E554C4C2C0A2020606369747960207661726368617228333029204E4F54204E554C4C2C0A202060737461746560207661726368617228333029204E4F54204E554C4C2C0A202060636F756E74727960207661726368617228333029204E4F54204E554C4C2C0A2020606D6F62696C656020696E7428313029204E4F54204E554C4C2C0A2020606C616E646C696E656020696E7428313129204E4F54204E554C4C2C0A20205052494D415259204B455920286075736572696460290A2920454E47494E453D496E6E6F44422044454641554C5420434841525345543D757466383B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060757365723030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060757365723030316D62602044495341424C45204B455953202A2F3B0A2F2A21343030303020414C544552205441424C452060757365723030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C65206075736572726F6C653030316D62600A2D2D0A0A44524F50205441424C4520494620455849535453206075736572726F6C653030316D62603B0A435245415445205441424C45206075736572726F6C653030316D626020280A20206075736572726F6C6569646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A2020606C6F67696E69646020696E7428313129204E4F54204E554C4C2C0A202060726F6C6560207661726368617228343529204E4F54204E554C4C2C0A202060757365726E616D6560207661726368617228343529204E4F54204E554C4C2C0A20205052494D415259204B455920286075736572726F6C65696460292C0A20204B45592060666B5F6C6F67696E5F696478602028606C6F67696E696460292C0A2020434F4E53545241494E542060666B5F6C6F67696E69646020464F524549474E204B45592028606C6F67696E69646029205245464552454E43455320606C6F67696E3030316D62602028606C6F67696E69646029204F4E2044454C4554452043415343414445204F4E2055504441544520434153434144450A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D33392044454641554C5420434841525345543D757466383B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C65206075736572726F6C653030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C45206075736572726F6C653030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F206075736572726F6C653030316D626020286075736572726F6C656964602C606C6F67696E6964602C60726F6C65602C60757365726E616D6560292056414C554553200A2028312C362C27524F4C455F41444D494E272C277369766127292C0A202833332C372C27524F4C455F41444D494E272C276B616E6E616E27292C0A202833342C382C27524F4C455F55534552272C276B6172796127292C0A202833362C34332C27524F4C455F55534552272C27676972696A6127292C0A202833382C34352C27524F4C455F55534552272C276973776172796127293B0A2F2A21343030303020414C544552205441424C45206075736572726F6C653030316D626020454E41424C45204B455953202A2F3B0A0A0A2D2D0A2D2D20446566696E6974696F6E206F66207461626C652060776F726B73746174696F6E3030316D62600A2D2D0A0A44524F50205441424C45204946204558495354532060776F726B73746174696F6E3030316D62603B0A435245415445205441424C452060776F726B73746174696F6E3030316D626020280A202060776F726B737449646020696E7428313129204E4F54204E554C4C204155544F5F494E4352454D454E542C0A202060776F726B73744E616D6560207661726368617228343029204E4F54204E554C4C2C0A20205052494D415259204B4559202860776F726B7374496460290A2920454E47494E453D496E6E6F4442204155544F5F494E4352454D454E543D372044454641554C5420434841525345543D6C6174696E313B0A0A2D2D0A2D2D2044756D70696E67206461746120666F72207461626C652060776F726B73746174696F6E3030316D62600A2D2D0A0A2F2A21343030303020414C544552205441424C452060776F726B73746174696F6E3030316D62602044495341424C45204B455953202A2F3B0A494E5345525420494E544F2060776F726B73746174696F6E3030316D6260202860776F726B73744964602C60776F726B73744E616D6560292056414C554553200A2028312C27417373656D626C792053746174696F6E5F3127292C0A2028322C27417373656D626C792053746174696F6E5F3227292C0A2028332C274472696C6C696E67204D616368696E655F3127292C0A2028352C275061636B696E6720616E642054657374696E672053746174696F6E27292C0A2028362C274C6174686527293B0A2F2A21343030303020414C544552205441424C452060776F726B73746174696F6E3030316D626020454E41424C45204B455953202A2F3B0A0A0A0A0A2F2A213430313031205345542053514C5F4D4F44453D404F4C445F53514C5F4D4F4445202A2F3B0A2F2A2134303031342053455420464F524549474E5F4B45595F434845434B533D404F4C445F464F524549474E5F4B45595F434845434B53202A2F3B0A2F2A2134303031342053455420554E495155455F434845434B533D404F4C445F554E495155455F434845434B53202A2F3B0A2F2A21343031303120534554204348415241435445525F5345545F434C49454E543D404F4C445F4348415241435445525F5345545F434C49454E54202A2F3B0A2F2A21343031303120534554204348415241435445525F5345545F524553554C54533D404F4C445F4348415241435445525F5345545F524553554C5453202A2F3B0A2F2A2134303130312053455420434F4C4C4154494F4E5F434F4E4E454354494F4E3D404F4C445F434F4C4C4154494F4E5F434F4E4E454354494F4E202A2F3B0A2F2A21343031303120534554204348415241435445525F5345545F434C49454E543D404F4C445F4348415241435445525F5345545F434C49454E54202A2F3B0A,'2016-11-01 20:31:26');
/*!40000 ALTER TABLE `filemanager001mb` ENABLE KEYS */;


--
-- Definition of table `grossprofit001mb`
--

DROP TABLE IF EXISTS `grossprofit001mb`;
CREATE TABLE `grossprofit001mb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `salesinvoice` varchar(45) NOT NULL,
  `customer` varchar(45) NOT NULL,
  `postingdate` varchar(45) NOT NULL,
  `itemname` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `warehouse` varchar(45) NOT NULL,
  `project` varchar(45) NOT NULL,
  `currency` varchar(45) NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  `averagesellingrate` int(10) unsigned NOT NULL,
  `averagebuyingrate` int(10) unsigned NOT NULL,
  `sellingamount` int(10) unsigned NOT NULL,
  `buyingamount` int(10) unsigned NOT NULL,
  `grossprofit` int(10) unsigned NOT NULL,
  `grosspercentage` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grossprofit001mb`
--

/*!40000 ALTER TABLE `grossprofit001mb` DISABLE KEYS */;
INSERT INTO `grossprofit001mb` (`id`,`salesinvoice`,`customer`,`postingdate`,`itemname`,`description`,`warehouse`,`project`,`currency`,`quantity`,`averagesellingrate`,`averagebuyingrate`,`sellingamount`,`buyingamount`,`grossprofit`,`grosspercentage`) VALUES 
 (1,'KT04877','irin','10/05/2016','TEST','goof','karta','karya','rupee',5,20,15,100,75,25,0),
 (2,'KT00893','Dhiksha','10/06/2016','TEST','gg','GG','hh','hh',5,10,5,50,25,25,100),
 (4,'KT08815','shaasha','10/05/2016','BA-BAT','goof','good','rep','rupee',5,15,10,75,50,25,50),
 (5,'KT01785','irin','09/27/2016','Bl-BALL','desc','ware','pro','cur',5,15,10,75,50,25,50);
/*!40000 ALTER TABLE `grossprofit001mb` ENABLE KEYS */;


--
-- Definition of table `holidaylist001mb`
--

DROP TABLE IF EXISTS `holidaylist001mb`;
CREATE TABLE `holidaylist001mb` (
  `hlistId` int(11) NOT NULL AUTO_INCREMENT,
  `holidayName` varchar(30) NOT NULL,
  `weeklyOff` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`hlistId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `holidaylist001mb`
--

/*!40000 ALTER TABLE `holidaylist001mb` DISABLE KEYS */;
INSERT INTO `holidaylist001mb` (`hlistId`,`holidayName`,`weeklyOff`) VALUES 
 (1,'Ramzan','Tuesday'),
 (2,'Pongal','Thursday'),
 (3,'Republic_Day','Saturday');
/*!40000 ALTER TABLE `holidaylist001mb` ENABLE KEYS */;


--
-- Definition of table `inactivecust001mb`
--

DROP TABLE IF EXISTS `inactivecust001mb`;
CREATE TABLE `inactivecust001mb` (
  `inactcustId` int(11) NOT NULL AUTO_INCREMENT,
  `custType` varchar(50) NOT NULL,
  `customername` varchar(50) NOT NULL,
  `terName` varchar(50) NOT NULL,
  `customergroup` varchar(50) NOT NULL,
  `numoforder` varchar(20) NOT NULL,
  `totalordval` varchar(30) DEFAULT NULL,
  `totalordcons` varchar(40) DEFAULT NULL,
  `lastordamt` decimal(12,4) DEFAULT NULL,
  `lastorddate` varchar(40) DEFAULT NULL,
  `daysinlstord` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`inactcustId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inactivecust001mb`
--

/*!40000 ALTER TABLE `inactivecust001mb` DISABLE KEYS */;
INSERT INTO `inactivecust001mb` (`inactcustId`,`custType`,`customername`,`terName`,`customergroup`,`numoforder`,`totalordval`,`totalordcons`,`lastordamt`,`lastorddate`,`daysinlstord`) VALUES 
 (1,'Sales Order','Mithra','Rest of the World','QAS','10','3 Lakhs','4','1000000.0000','16/02/2016','60');
/*!40000 ALTER TABLE `inactivecust001mb` ENABLE KEYS */;


--
-- Definition of table `instalnote001mb`
--

DROP TABLE IF EXISTS `instalnote001mb`;
CREATE TABLE `instalnote001mb` (
  `instId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `status` varchar(40) NOT NULL,
  `remark` varchar(100) NOT NULL,
  `instCode` varchar(40) NOT NULL,
  PRIMARY KEY (`instId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instalnote001mb`
--

/*!40000 ALTER TABLE `instalnote001mb` DISABLE KEYS */;
INSERT INTO `instalnote001mb` (`instId`,`name`,`status`,`remark`,`instCode`) VALUES 
 (1,'Faber','Draft','No Remarks','IN-0098'),
 (2,'Castle','Submitted','Good Product','IN-0079');
/*!40000 ALTER TABLE `instalnote001mb` ENABLE KEYS */;


--
-- Definition of table `issueditem001mb`
--

DROP TABLE IF EXISTS `issueditem001mb`;
CREATE TABLE `issueditem001mb` (
  `issueId` int(11) NOT NULL AUTO_INCREMENT,
  `porderCode` varchar(50) NOT NULL,
  `issueDate` varchar(50) NOT NULL,
  `Itemcode` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `quantity` varchar(30) NOT NULL,
  `uom` varchar(30) NOT NULL,
  `amount` decimal(12,4) NOT NULL,
  `serialNo` varchar(50) NOT NULL,
  `sourceWH` varchar(50) NOT NULL,
  `targetWH` varchar(50) NOT NULL,
  `stockEntry` varchar(40) NOT NULL,
  `company` varchar(50) NOT NULL,
  PRIMARY KEY (`issueId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issueditem001mb`
--

/*!40000 ALTER TABLE `issueditem001mb` DISABLE KEYS */;
INSERT INTO `issueditem001mb` (`issueId`,`porderCode`,`issueDate`,`Itemcode`,`description`,`quantity`,`uom`,`amount`,`serialNo`,`sourceWH`,`targetWH`,`stockEntry`,`company`) VALUES 
 (2,'PRO_00084','10/12/2016','Wind MIll C Series','Good','2','Nos','456.0000','SER-002','Progress goods','Finished goods','STE-001','Dell');
/*!40000 ALTER TABLE `issueditem001mb` ENABLE KEYS */;


--
-- Definition of table `itemdt001mb`
--

DROP TABLE IF EXISTS `itemdt001mb`;
CREATE TABLE `itemdt001mb` (
  `Itemid` int(11) NOT NULL AUTO_INCREMENT,
  `Itemcode` varchar(50) DEFAULT NULL,
  `Quantity` smallint(6) NOT NULL,
  `Rate` decimal(12,4) DEFAULT NULL,
  `Amount` decimal(12,4) DEFAULT NULL,
  PRIMARY KEY (`Itemid`),
  UNIQUE KEY `Itemcode` (`Itemcode`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemdt001mb`
--

/*!40000 ALTER TABLE `itemdt001mb` DISABLE KEYS */;
INSERT INTO `itemdt001mb` (`Itemid`,`Itemcode`,`Quantity`,`Rate`,`Amount`) VALUES 
 (2,'Wind MIll C Series',2,'46.0000','46.0000'),
 (3,'Wind Turbine-L',2,'100.0000','100.0000'),
 (21,'Wind Mill A Series',10,'100.0000','100.0000'),
 (22,'Table',10,'300.0000','299.5000'),
 (24,'Shaft',5,'45.5000','254.0000'),
 (25,'Internal Disc',14,'45.2300','454.1120'),
 (26,'Mobile',45,'63.2300','267.3100'),
 (27,'Computer',15,'23.1200','222.1230');
/*!40000 ALTER TABLE `itemdt001mb` ENABLE KEYS */;


--
-- Definition of table `itemgroup001mb`
--

DROP TABLE IF EXISTS `itemgroup001mb`;
CREATE TABLE `itemgroup001mb` (
  `igId` int(11) NOT NULL AUTO_INCREMENT,
  `itemGroup` varchar(50) NOT NULL,
  PRIMARY KEY (`igId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemgroup001mb`
--

/*!40000 ALTER TABLE `itemgroup001mb` DISABLE KEYS */;
INSERT INTO `itemgroup001mb` (`igId`,`itemGroup`) VALUES 
 (1,'Raw Material'),
 (2,'Services'),
 (3,'Sub-assemblies'),
 (4,'Consumable');
/*!40000 ALTER TABLE `itemgroup001mb` ENABLE KEYS */;


--
-- Definition of table `itemprice001mb`
--

DROP TABLE IF EXISTS `itemprice001mb`;
CREATE TABLE `itemprice001mb` (
  `ipId` int(11) NOT NULL AUTO_INCREMENT,
  `itemCode` varchar(50) NOT NULL,
  `status` varchar(40) NOT NULL,
  `itemGroup` varchar(50) NOT NULL,
  PRIMARY KEY (`ipId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemprice001mb`
--

/*!40000 ALTER TABLE `itemprice001mb` DISABLE KEYS */;
INSERT INTO `itemprice001mb` (`ipId`,`itemCode`,`status`,`itemGroup`) VALUES 
 (3,'Shaft','Variant','Sub-assemblies'),
 (4,'Computer','Variant','Raw Material');
/*!40000 ALTER TABLE `itemprice001mb` ENABLE KEYS */;


--
-- Definition of table `itempricereport001mb`
--

DROP TABLE IF EXISTS `itempricereport001mb`;
CREATE TABLE `itempricereport001mb` (
  `itpricesId` int(11) NOT NULL AUTO_INCREMENT,
  `itemCode` varchar(50) NOT NULL,
  `itemGroup` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `UOM` varchar(30) NOT NULL,
  `lstPurchase` varchar(40) NOT NULL,
  `valuationRate` decimal(12,4) DEFAULT NULL,
  `spList` varchar(50) NOT NULL,
  `ppList` varchar(50) NOT NULL,
  `bomRate` decimal(12,4) DEFAULT NULL,
  PRIMARY KEY (`itpricesId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itempricereport001mb`
--

/*!40000 ALTER TABLE `itempricereport001mb` DISABLE KEYS */;
INSERT INTO `itempricereport001mb` (`itpricesId`,`itemCode`,`itemGroup`,`description`,`UOM`,`lstPurchase`,`valuationRate`,`spList`,`ppList`,`bomRate`) VALUES 
 (1,'Table','Consumable','Good','Nos','20','120000.0000','100','200','120000.0000');
/*!40000 ALTER TABLE `itempricereport001mb` ENABLE KEYS */;


--
-- Definition of table `itempuhist001mb`
--

DROP TABLE IF EXISTS `itempuhist001mb`;
CREATE TABLE `itempuhist001mb` (
  `histId` int(11) NOT NULL AUTO_INCREMENT,
  `itemCode` varchar(40) NOT NULL,
  `itemGroup` varchar(30) NOT NULL,
  `description` varchar(100) NOT NULL,
  `quantity` varchar(20) NOT NULL,
  `uom` varchar(20) NOT NULL,
  `date` varchar(40) DEFAULT NULL,
  `amount` varchar(40) NOT NULL,
  `poSeries` varchar(40) DEFAULT NULL,
  `transDate` varchar(50) DEFAULT NULL,
  `supplier` varchar(40) DEFAULT NULL,
  `receivedqty` varchar(40) DEFAULT NULL,
  `company` varchar(40) NOT NULL,
  PRIMARY KEY (`histId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itempuhist001mb`
--

/*!40000 ALTER TABLE `itempuhist001mb` DISABLE KEYS */;
INSERT INTO `itempuhist001mb` (`histId`,`itemCode`,`itemGroup`,`description`,`quantity`,`uom`,`date`,`amount`,`poSeries`,`transDate`,`supplier`,`receivedqty`,`company`) VALUES 
 (1,'Table','Raw Material','3.4.in l and 4.5.in w','4','Nos','10/10/2016','amount','Material Transfer','11/11/2016','Asiatic Solution','3','Dell'),
 (3,'Wind Turbine-L','Sub-assemblies','Good','4','Nos','10/18/2016','20000','SER-009','10/29/2016','Asiatic Solution','10','Dell');
/*!40000 ALTER TABLE `itempuhist001mb` ENABLE KEYS */;


--
-- Definition of table `itemshortagerep001mb`
--

DROP TABLE IF EXISTS `itemshortagerep001mb`;
CREATE TABLE `itemshortagerep001mb` (
  `shrepId` int(11) NOT NULL AUTO_INCREMENT,
  `warehouseName` varchar(50) NOT NULL,
  `itemCode` varchar(50) NOT NULL,
  `actualQty` decimal(12,4) DEFAULT NULL,
  `orderedQty` decimal(12,4) DEFAULT NULL,
  `plannedQty` decimal(12,4) DEFAULT NULL,
  `reservedQty` decimal(12,4) DEFAULT NULL,
  `projectedQty` decimal(12,4) DEFAULT NULL,
  PRIMARY KEY (`shrepId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemshortagerep001mb`
--

/*!40000 ALTER TABLE `itemshortagerep001mb` DISABLE KEYS */;
INSERT INTO `itemshortagerep001mb` (`shrepId`,`warehouseName`,`itemCode`,`actualQty`,`orderedQty`,`plannedQty`,`reservedQty`,`projectedQty`) VALUES 
 (1,'SPL','Table','12.0000','10.0000','15.0000','5.0000','13.0000'),
 (2,'SSPDL','Internal Disc','45.0000','12.0000','30.0000','24.0000','25.0000');
/*!40000 ALTER TABLE `itemshortagerep001mb` ENABLE KEYS */;


--
-- Definition of table `itemst001mb`
--

DROP TABLE IF EXISTS `itemst001mb`;
CREATE TABLE `itemst001mb` (
  `itemstId` int(11) NOT NULL AUTO_INCREMENT,
  `itemcode` varchar(50) NOT NULL,
  `status` varchar(30) NOT NULL,
  `itemGroup` varchar(40) NOT NULL,
  PRIMARY KEY (`itemstId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemst001mb`
--

/*!40000 ALTER TABLE `itemst001mb` DISABLE KEYS */;
INSERT INTO `itemst001mb` (`itemstId`,`itemcode`,`status`,`itemGroup`) VALUES 
 (1,'Mobile','Enabled','Products'),
 (2,'Laptop','Template','Raw Materials'),
 (4,'Wind Mill A Series','Disabled','Sub Assemblies');
/*!40000 ALTER TABLE `itemst001mb` ENABLE KEYS */;


--
-- Definition of table `itemwiselevel001mb`
--

DROP TABLE IF EXISTS `itemwiselevel001mb`;
CREATE TABLE `itemwiselevel001mb` (
  `iwlId` int(11) NOT NULL AUTO_INCREMENT,
  `itemCode` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `safetyStk` varchar(50) NOT NULL,
  `leadtimeDays` decimal(12,4) DEFAULT NULL,
  `consumed` decimal(12,4) DEFAULT NULL,
  `delivered` decimal(12,4) DEFAULT NULL,
  `totalOutgoing` decimal(12,4) DEFAULT NULL,
  `avgdailyOutgoing` decimal(12,4) DEFAULT NULL,
  `reorderLevel` varchar(50) NOT NULL,
  PRIMARY KEY (`iwlId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemwiselevel001mb`
--

/*!40000 ALTER TABLE `itemwiselevel001mb` DISABLE KEYS */;
INSERT INTO `itemwiselevel001mb` (`iwlId`,`itemCode`,`description`,`safetyStk`,`leadtimeDays`,`consumed`,`delivered`,`totalOutgoing`,`avgdailyOutgoing`,`reorderLevel`) VALUES 
 (1,'Table','Bad','12','25.0000','12.0000','10.0000','50.0000','10.0000','normal');
/*!40000 ALTER TABLE `itemwiselevel001mb` ENABLE KEYS */;


--
-- Definition of table `itemwisepurregister001mb`
--

DROP TABLE IF EXISTS `itemwisepurregister001mb`;
CREATE TABLE `itemwisepurregister001mb` (
  `iwprId` int(11) NOT NULL AUTO_INCREMENT,
  `itemCode` varchar(50) NOT NULL,
  `itemGroup` varchar(50) NOT NULL,
  `inVoice` varchar(50) NOT NULL,
  `postingDate` varchar(50) NOT NULL,
  `supName` varchar(50) NOT NULL,
  `payAccount` varchar(50) NOT NULL,
  `paymentMode` varchar(50) NOT NULL,
  `projectname` varchar(50) NOT NULL,
  `company` varchar(50) NOT NULL,
  `poSeries` varchar(50) NOT NULL,
  `purtName` varchar(50) NOT NULL,
  `expenseAccount` varchar(50) DEFAULT NULL,
  `quantity` varchar(50) NOT NULL,
  `rate` decimal(12,4) DEFAULT NULL,
  `amount` decimal(12,4) DEFAULT NULL,
  `totalTax` decimal(12,4) DEFAULT NULL,
  `total` decimal(12,4) DEFAULT NULL,
  `currency` varchar(50) NOT NULL,
  PRIMARY KEY (`iwprId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemwisepurregister001mb`
--

/*!40000 ALTER TABLE `itemwisepurregister001mb` DISABLE KEYS */;
INSERT INTO `itemwisepurregister001mb` (`iwprId`,`itemCode`,`itemGroup`,`inVoice`,`postingDate`,`supName`,`payAccount`,`paymentMode`,`projectname`,`company`,`poSeries`,`purtName`,`expenseAccount`,`quantity`,`rate`,`amount`,`totalTax`,`total`,`currency`) VALUES 
 (1,'Wind MIll C Series','Raw Matertial','Clear','12/10/2016','Asiatic Solution','Creditors','Cash','Intellor','Dell','SER-009','PREC-00013','sample','2','46.0000','24000.0000','1235.0000','25235.0000','INR'),
 (3,'Wind Turbine-L','Services','Cleared','11/15/2016','Asiatic Solution','Normal','Wire Transfer','Intellor','Dell','SER-009','PREC-0033','Nill','2','12.0000','24.0000','12.0000','36.0000','INR');
/*!40000 ALTER TABLE `itemwisepurregister001mb` ENABLE KEYS */;


--
-- Definition of table `jounalentry001mb`
--

DROP TABLE IF EXISTS `jounalentry001mb`;
CREATE TABLE `jounalentry001mb` (
  `jeId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL,
  `status` varchar(50) NOT NULL,
  `referenceNumber` varchar(50) NOT NULL,
  `jeSeries` varchar(50) NOT NULL,
  `postingDate` varchar(50) NOT NULL,
  `referenceDate` varchar(50) NOT NULL,
  `accountName` varchar(50) NOT NULL,
  `partyName` varchar(50) NOT NULL,
  `credit` varchar(50) NOT NULL,
  `debit` varchar(50) NOT NULL,
  `docStatus` varchar(50) NOT NULL,
  PRIMARY KEY (`jeId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jounalentry001mb`
--

/*!40000 ALTER TABLE `jounalentry001mb` DISABLE KEYS */;
INSERT INTO `jounalentry001mb` (`jeId`,`title`,`status`,`referenceNumber`,`jeSeries`,`postingDate`,`referenceDate`,`accountName`,`partyName`,`credit`,`debit`,`docStatus`) VALUES 
 (1,'Entry 1','Bank Entry','REF-001','JE-001','12/12/2015','10/10/2015','Savings','irin','nill','200','Draft');
/*!40000 ALTER TABLE `jounalentry001mb` ENABLE KEYS */;


--
-- Definition of table `landcostvouch001mb`
--

DROP TABLE IF EXISTS `landcostvouch001mb`;
CREATE TABLE `landcostvouch001mb` (
  `vouchId` int(11) NOT NULL AUTO_INCREMENT,
  `series` varchar(50) NOT NULL,
  `company` varchar(40) NOT NULL,
  `recptdocType` varchar(50) NOT NULL,
  `recptdoc` varchar(50) NOT NULL,
  `supName` varchar(50) NOT NULL,
  `grandTotal` varchar(50) NOT NULL,
  PRIMARY KEY (`vouchId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `landcostvouch001mb`
--

/*!40000 ALTER TABLE `landcostvouch001mb` DISABLE KEYS */;
INSERT INTO `landcostvouch001mb` (`vouchId`,`series`,`company`,`recptdocType`,`recptdoc`,`supName`,`grandTotal`) VALUES 
 (1,'LCV-001','Dell','Purchase Invoice','RC-001','Asiatic Solution','12000');
/*!40000 ALTER TABLE `landcostvouch001mb` ENABLE KEYS */;


--
-- Definition of table `lead001mb`
--

DROP TABLE IF EXISTS `lead001mb`;
CREATE TABLE `lead001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `personname` varchar(30) NOT NULL,
  `organisationname` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL,
  `source` varchar(30) NOT NULL,
  `leadowner` varchar(50) NOT NULL,
  `nextcontactby` varchar(50) DEFAULT NULL,
  `leadtype` varchar(50) DEFAULT NULL,
  `marketsegment` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lead001mb`
--

/*!40000 ALTER TABLE `lead001mb` DISABLE KEYS */;
INSERT INTO `lead001mb` (`id`,`personname`,`organisationname`,`status`,`source`,`leadowner`,`nextcontactby`,`leadtype`,`marketsegment`) VALUES 
 (1,'ravi','xyz','open','lead','admin','abc@gmail.com','client','income'),
 (2,'raja','lmw','initated','lead','admin','xyz@gmail.com','consultant','income'),
 (6,'ramkumarnarain','abcd','completed','talking','client','xyz@gmail.com','administrator','incomehigh'),
 (15,'siva','karya','open','call','iswarya','988454587','admin','high'),
 (16,'dhiyakumar','karyatechnologies','initated','calling','lead','xyz@gmail.com','consultant','incomelow'),
 (17,'','','','','','','','');
/*!40000 ALTER TABLE `lead001mb` ENABLE KEYS */;


--
-- Definition of table `leaddetail001mb`
--

DROP TABLE IF EXISTS `leaddetail001mb`;
CREATE TABLE `leaddetail001mb` (
  `leadId` int(11) NOT NULL AUTO_INCREMENT,
  `leadName` varchar(40) NOT NULL,
  `companyName` varchar(40) NOT NULL,
  `status` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `state` varchar(40) NOT NULL,
  `pinCode` varchar(30) NOT NULL,
  `country` varchar(50) NOT NULL,
  `phone` varchar(40) DEFAULT NULL,
  `mobileNo` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `leadOwner` varchar(50) NOT NULL,
  `terName` varchar(40) NOT NULL,
  PRIMARY KEY (`leadId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `leaddetail001mb`
--

/*!40000 ALTER TABLE `leaddetail001mb` DISABLE KEYS */;
INSERT INTO `leaddetail001mb` (`leadId`,`leadName`,`companyName`,`status`,`address`,`state`,`pinCode`,`country`,`phone`,`mobileNo`,`email`,`leadOwner`,`terName`) VALUES 
 (1,'Vettel','Dell','Open','4th st,Oval,London','London','020','England','+004-9876543','+353-9876905432','test@gamil.com','Administrator','United States');
/*!40000 ALTER TABLE `leaddetail001mb` ENABLE KEYS */;


--
-- Definition of table `leaveapp001mb`
--

DROP TABLE IF EXISTS `leaveapp001mb`;
CREATE TABLE `leaveapp001mb` (
  `lvappId` int(11) NOT NULL AUTO_INCREMENT,
  `series` varchar(30) NOT NULL,
  `leaveType` varchar(30) NOT NULL,
  `reason` varchar(30) NOT NULL,
  `fromDate` varchar(30) NOT NULL,
  `toDate` varchar(30) NOT NULL,
  `leaveApprover` varchar(30) NOT NULL,
  `postingDate` varchar(30) NOT NULL,
  `sNo` int(11) DEFAULT NULL,
  `company` varchar(40) NOT NULL,
  `empNumber` varchar(255) DEFAULT NULL,
  `deptName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lvappId`),
  KEY `sNo` (`sNo`),
  CONSTRAINT `leaveapp001mb_ibfk_1` FOREIGN KEY (`sNo`) REFERENCES `employee001mb` (`sNo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `leaveapp001mb`
--

/*!40000 ALTER TABLE `leaveapp001mb` DISABLE KEYS */;
INSERT INTO `leaveapp001mb` (`lvappId`,`series`,`leaveType`,`reason`,`fromDate`,`toDate`,`leaveApprover`,`postingDate`,`sNo`,`company`,`empNumber`,`deptName`) VALUES 
 (2,'LEA/012','Approved','Sick','10/12/2015','10/12/2015','Hr','10/12/2015',NULL,'Mechanical','Suresh',NULL),
 (4,'LEV/026','Rejected','Cancer','10/13/2016','10/05/2016','MD','10/26/2016',NULL,'Dell','EMP_02',NULL),
 (5,'LEV/007','Approved','Personal Reason','10/19/2016','10/11/2016','HRM','10/19/2016',NULL,'Hyundai pvt Ltd','EMP_06',NULL);
/*!40000 ALTER TABLE `leaveapp001mb` ENABLE KEYS */;


--
-- Definition of table `leavetype001mb`
--

DROP TABLE IF EXISTS `leavetype001mb`;
CREATE TABLE `leavetype001mb` (
  `lvtypeId` int(11) NOT NULL AUTO_INCREMENT,
  `lvtypeName` varchar(30) NOT NULL,
  `maxdaysAllowed` int(11) NOT NULL,
  PRIMARY KEY (`lvtypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `leavetype001mb`
--

/*!40000 ALTER TABLE `leavetype001mb` DISABLE KEYS */;
INSERT INTO `leavetype001mb` (`lvtypeId`,`lvtypeName`,`maxdaysAllowed`) VALUES 
 (1,'Privilege',20),
 (2,'Casual',50),
 (3,'Maternity',10),
 (5,'Paternity',25);
/*!40000 ALTER TABLE `leavetype001mb` ENABLE KEYS */;


--
-- Definition of table `login001mb`
--

DROP TABLE IF EXISTS `login001mb`;
CREATE TABLE `login001mb` (
  `loginid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `domain` varchar(30) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `securityquestion` varchar(45) NOT NULL,
  `securityanswer` varchar(45) NOT NULL,
  `message` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`loginid`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login001mb`
--

/*!40000 ALTER TABLE `login001mb` DISABLE KEYS */;
INSERT INTO `login001mb` (`loginid`,`firstname`,`lastname`,`domain`,`username`,`password`,`enabled`,`securityquestion`,`securityanswer`,`message`) VALUES 
 (6,'sivakumar','karunamoorthy','Manufacturing','siva','$2a$11$XaR4NsoCw/Uw5IRWX.7gpenfdrPOv8886So3B02IcnL7VVE/J0i7m',0,'What was your childhood nickname ?','tiger123','testing'),
 (7,'kannan','mathiyalagan','Manufacturing','kannan','$2a$11$2N69AGoLLDfv0p1Hgrx3YeAw/d7phkAXdXMsyH539L9jaQmOFxUV6',0,'What was your childhood nickname ?','testing123','testing'),
 (8,'karya Tech','karya Tech','Manufacturing','karya','$2a$11$IRaX57IBLbMiRpxvd/PYpuqfGGemBg7e4kNKNfpNhPMMMWANi3NYS',0,'What was your childhood nickname ?','testing123','testing'),
 (43,'girija','kumari','School','girija','$2a$11$WL.BLgqXSmaLZ/DmGxKffuuZxOT8xWfgUnG6wDItnn8BKRVydxq8C',0,'What was your childhood nickname ?','testing123456','testing456'),
 (44,'naresh','naresh','Buying House','naresh','$2a$11$Il8WVsibPf8nHuGYplrimuf/uerDdSYIIk4sGZr05BwhvoFjOo.j.',0,'What was your childhood nickname ?','testing123','testing123'),
 (45,'Iswarya','ravikumar','Calibration Labs','iswarya','$2a$11$p59HJTAlHslvqWSIBFG/Pu7yWveJkNjUdyYzCxJWZXRvgDV2l8KJm',0,'What was your childhood nickname ?','testing','test');
/*!40000 ALTER TABLE `login001mb` ENABLE KEYS */;


--
-- Definition of table `lvblocklist001mb`
--

DROP TABLE IF EXISTS `lvblocklist001mb`;
CREATE TABLE `lvblocklist001mb` (
  `lvblockId` int(11) NOT NULL AUTO_INCREMENT,
  `blockName` varchar(30) NOT NULL,
  `sNo` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lvblockId`),
  KEY `sNo` (`sNo`),
  CONSTRAINT `lvblocklist001mb_ibfk_1` FOREIGN KEY (`sNo`) REFERENCES `employee001mb` (`sNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lvblocklist001mb`
--

/*!40000 ALTER TABLE `lvblocklist001mb` DISABLE KEYS */;
/*!40000 ALTER TABLE `lvblocklist001mb` ENABLE KEYS */;


--
-- Definition of table `manufactureset001mb`
--

DROP TABLE IF EXISTS `manufactureset001mb`;
CREATE TABLE `manufactureset001mb` (
  `mansetId` int(11) NOT NULL AUTO_INCREMENT,
  `disableCPandTT` varchar(20) NOT NULL,
  `allowOT` varchar(20) NOT NULL,
  `allowProdinholy` varchar(20) NOT NULL,
  `prodPercent` decimal(12,4) NOT NULL,
  `backflushRM` varchar(40) NOT NULL,
  `capacityPlan` varchar(30) NOT NULL,
  `timebwOpern` varchar(30) DEFAULT NULL,
  `defworkinProgWH` varchar(50) NOT NULL,
  `defFingoodsWH` varchar(50) NOT NULL,
  PRIMARY KEY (`mansetId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manufactureset001mb`
--

/*!40000 ALTER TABLE `manufactureset001mb` DISABLE KEYS */;
INSERT INTO `manufactureset001mb` (`mansetId`,`disableCPandTT`,`allowOT`,`allowProdinholy`,`prodPercent`,`backflushRM`,`capacityPlan`,`timebwOpern`,`defworkinProgWH`,`defFingoodsWH`) VALUES 
 (1,'1','0','1','50.0800','BOM','30','10','Work-in Progress-WPL','All Warehouses-WPL');
/*!40000 ALTER TABLE `manufactureset001mb` ENABLE KEYS */;


--
-- Definition of table `matchpayment001mb`
--

DROP TABLE IF EXISTS `matchpayment001mb`;
CREATE TABLE `matchpayment001mb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `company` varchar(45) NOT NULL,
  `partytype` varchar(45) NOT NULL,
  `party` varchar(45) NOT NULL,
  `receivableorpayableaccount` varchar(45) NOT NULL,
  `fromdate` varchar(45) NOT NULL,
  `todate` varchar(45) NOT NULL,
  `bankorcashaccount` varchar(45) NOT NULL,
  `minimuminvoiceamount` int(10) unsigned NOT NULL,
  `maximuminvoiceamount` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matchpayment001mb`
--

/*!40000 ALTER TABLE `matchpayment001mb` DISABLE KEYS */;
INSERT INTO `matchpayment001mb` (`id`,`company`,`partytype`,`party`,`receivableorpayableaccount`,`fromdate`,`todate`,`bankorcashaccount`,`minimuminvoiceamount`,`maximuminvoiceamount`) VALUES 
 (2,'KARYA','party typr','party','receivable','10/12/2016','10/29/2016','bank',500,500);
/*!40000 ALTER TABLE `matchpayment001mb` ENABLE KEYS */;


--
-- Definition of table `materialrequest001mb`
--

DROP TABLE IF EXISTS `materialrequest001mb`;
CREATE TABLE `materialrequest001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(30) NOT NULL,
  `warehouse` varchar(30) NOT NULL,
  `actual` int(30) NOT NULL,
  `requested` int(30) NOT NULL,
  `reserved` int(30) NOT NULL,
  `ordered` int(30) NOT NULL,
  `projected` int(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `materialrequest001mb`
--

/*!40000 ALTER TABLE `materialrequest001mb` DISABLE KEYS */;
INSERT INTO `materialrequest001mb` (`id`,`item`,`warehouse`,`actual`,`requested`,`reserved`,`ordered`,`projected`) VALUES 
 (1,'material','spl',12,20,10,25,15),
 (3,'shaft','spl-warehouse',45,45,93,70,60);
/*!40000 ALTER TABLE `materialrequest001mb` ENABLE KEYS */;


--
-- Definition of table `matreqsunotcreate001mb`
--

DROP TABLE IF EXISTS `matreqsunotcreate001mb`;
CREATE TABLE `matreqsunotcreate001mb` (
  `mrsId` int(11) NOT NULL AUTO_INCREMENT,
  `mrSeries` varchar(50) NOT NULL,
  `date` varchar(40) NOT NULL,
  `itemCode` varchar(50) NOT NULL,
  `quantity` varchar(20) NOT NULL,
  `description` varchar(150) DEFAULT NULL,
  `company` varchar(40) NOT NULL,
  PRIMARY KEY (`mrsId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matreqsunotcreate001mb`
--

/*!40000 ALTER TABLE `matreqsunotcreate001mb` DISABLE KEYS */;
INSERT INTO `matreqsunotcreate001mb` (`mrsId`,`mrSeries`,`date`,`itemCode`,`quantity`,`description`,`company`) VALUES 
 (1,'MRSER-001','12/10/2016','Table','10','3/4in.*2ft*4ft plywood','dell');
/*!40000 ALTER TABLE `matreqsunotcreate001mb` ENABLE KEYS */;


--
-- Definition of table `menu001mb`
--

DROP TABLE IF EXISTS `menu001mb`;
CREATE TABLE `menu001mb` (
  `menuid` int(10) NOT NULL AUTO_INCREMENT,
  `menuname` varchar(25) NOT NULL,
  `menulink` varchar(75) DEFAULT NULL,
  `menutype` enum('Main-Menu','Child-Menu','Page-Main-Menu','Page-Child-Menu') DEFAULT NULL,
  `parentid` int(10) DEFAULT '0',
  `parentname` varchar(25) DEFAULT NULL,
  `domain` varchar(25) NOT NULL,
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu001mb`
--

/*!40000 ALTER TABLE `menu001mb` DISABLE KEYS */;
INSERT INTO `menu001mb` (`menuid`,`menuname`,`menulink`,`menutype`,`parentid`,`parentname`,`domain`) VALUES 
 (1,'Manufacturing',NULL,'Main-Menu',0,NULL,'Manufacturing'),
 (2,'Production','/TestAndReportStudio/ProdOrderDetails/prodorder','Child-Menu',1,'Manufacturing','Manufacturing'),
 (3,'Bill of Materials','/TestAndReportStudio/BomDetails/billofmaterial?menulink=manufacturing','Child-Menu',1,'Manufacturing','Manufacturing'),
 (4,'Tools','/TestAndReportStudio/BomDetails/manufacturetools','Child-Menu',1,'Manufacturing','Manufacturing'),
 (5,'SetUp','/TestAndReportStudio/ManufactureDetails/manufacture','Child-Menu',1,'Manufacturing','Manufacturing'),
 (6,'Reports','/TestAndReportStudio/ProductionReportDetails/openprorder','Child-Menu',1,'Manufacturing','Manufacturing'),
 (7,'Help',NULL,'Child-Menu',1,'Manufacturing','Manufacturing'),
 (8,'Accounts',NULL,'Main-Menu',0,NULL,'Manufacturing'),
 (9,'Billing','/TestAndReportStudio/Billing/accountsreceivable','Child-Menu',8,'Accounts','Manufacturing'),
 (10,'Company and Accounts','/TestAndReportStudio/CompanyAndAccounts/generalledger','Child-Menu',8,'Accounts','Manufacturing'),
 (11,'Masters','/TestAndReportStudio/Masters/asset','Child-Menu',8,'Accounts','Manufacturing'),
 (12,'Accounting Statements','/TestAndReportStudio/AccountingStatements/trialbalance','Child-Menu',8,'Accounts','Manufacturing'),
 (13,'Banking Payments','/TestAndReportStudio/BankingAndPayments/updatebank','Child-Menu',8,'Accounts','Manufacturing'),
 (14,'Taxes','/TestAndReportStudio/Taxes/salestaxes','Child-Menu',8,'Accounts','Manufacturing'),
 (15,'Budget and Cost Center','/TestAndReportStudio/BudgetAndCostCenter/budgetvariancereport','Child-Menu',8,'Accounts','Manufacturing'),
 (16,'Tools','/TestAndReportStudio/Tools/periodclosingvoucher','Child-Menu',8,'Accounts','Manufacturing'),
 (17,'SetUp','/TestAndReportStudio/SetUp/setup','Child-Menu',8,'Accounts','Manufacturing'),
 (18,'To Bill','/TestAndReportStudio/ToBill/ordereditemstobebilled?menulink=ToBill','Child-Menu',8,'Accounts','Manufacturing'),
 (19,'Analytics','/TestAndReportStudio/GrossProfit/grossprofit?menulink=Analytics','Child-Menu',8,'Accounts','Manufacturing'),
 (20,'Other Reports',NULL,'Child-Menu',8,'Accounts','Manufacturing'),
 (21,'Help',NULL,'Child-Menu',8,'Accounts','Manufacturing');
/*!40000 ALTER TABLE `menu001mb` ENABLE KEYS */;


--
-- Definition of table `openprodorder001mb`
--

DROP TABLE IF EXISTS `openprodorder001mb`;
CREATE TABLE `openprodorder001mb` (
  `prodId` int(11) NOT NULL AUTO_INCREMENT,
  `prorderCode` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `itemtoManufacture` varchar(40) NOT NULL,
  `toProduce` varchar(30) DEFAULT NULL,
  `produced` varchar(30) NOT NULL,
  `empCompany` varchar(30) NOT NULL,
  PRIMARY KEY (`prodId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `openprodorder001mb`
--

/*!40000 ALTER TABLE `openprodorder001mb` DISABLE KEYS */;
INSERT INTO `openprodorder001mb` (`prodId`,`prorderCode`,`date`,`itemtoManufacture`,`toProduce`,`produced`,`empCompany`) VALUES 
 (1,'PRO_00084','10/20/2016','Balleett','10','6','Dell');
/*!40000 ALTER TABLE `openprodorder001mb` ENABLE KEYS */;


--
-- Definition of table `operationbom001mb`
--

DROP TABLE IF EXISTS `operationbom001mb`;
CREATE TABLE `operationbom001mb` (
  `opId` int(11) NOT NULL AUTO_INCREMENT,
  `opName` varchar(50) NOT NULL,
  `workstName` varchar(50) NOT NULL,
  PRIMARY KEY (`opId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `operationbom001mb`
--

/*!40000 ALTER TABLE `operationbom001mb` DISABLE KEYS */;
INSERT INTO `operationbom001mb` (`opId`,`opName`,`workstName`) VALUES 
 (1,'Setup Fixtures','Lathe'),
 (2,'Assembly Operation','Packing & Testing Station'),
 (3,'Testing','Packing & Testing Station'),
 (4,'Prepare Frame','Assembly Station_1'),
 (6,'Ballet Fitting','Packing and Testing Station');
/*!40000 ALTER TABLE `operationbom001mb` ENABLE KEYS */;


--
-- Definition of table `order001mb`
--

DROP TABLE IF EXISTS `order001mb`;
CREATE TABLE `order001mb` (
  `Orderid` int(11) NOT NULL AUTO_INCREMENT,
  `Ordername` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Orderid`),
  UNIQUE KEY `Ordername` (`Ordername`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order001mb`
--

/*!40000 ALTER TABLE `order001mb` DISABLE KEYS */;
INSERT INTO `order001mb` (`Orderid`,`Ordername`) VALUES 
 (2,'Asian Junction'),
 (5,'Chocolates'),
 (4,'Choice'),
 (1,'Landskip Yard Care'),
 (3,'Two Pesos');
/*!40000 ALTER TABLE `order001mb` ENABLE KEYS */;


--
-- Definition of table `orditemsdeliver001mb`
--

DROP TABLE IF EXISTS `orditemsdeliver001mb`;
CREATE TABLE `orditemsdeliver001mb` (
  `orditemsId` int(11) NOT NULL AUTO_INCREMENT,
  `sorderName` varchar(50) NOT NULL,
  `customername` varchar(50) NOT NULL,
  `date` varchar(40) NOT NULL,
  `projectName` varchar(50) DEFAULT NULL,
  `quantity` varchar(40) NOT NULL,
  `deliverQty` varchar(40) NOT NULL,
  `qtytoDeliver` varchar(40) NOT NULL,
  `rate` decimal(12,4) DEFAULT NULL,
  `amount` decimal(12,4) DEFAULT NULL,
  `amttoDeliver` decimal(12,4) DEFAULT NULL,
  `availableQty` varchar(50) NOT NULL,
  `projectedQty` varchar(40) DEFAULT NULL,
  `expectedQty` varchar(40) DEFAULT NULL,
  `itemCode` varchar(60) NOT NULL,
  `description` varchar(100) NOT NULL,
  `itemGroup` varchar(50) NOT NULL,
  `warehouseName` varchar(50) NOT NULL,
  PRIMARY KEY (`orditemsId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orditemsdeliver001mb`
--

/*!40000 ALTER TABLE `orditemsdeliver001mb` DISABLE KEYS */;
INSERT INTO `orditemsdeliver001mb` (`orditemsId`,`sorderName`,`customername`,`date`,`projectName`,`quantity`,`deliverQty`,`qtytoDeliver`,`rate`,`amount`,`amttoDeliver`,`availableQty`,`projectedQty`,`expectedQty`,`itemCode`,`description`,`itemGroup`,`warehouseName`) VALUES 
 (1,'SO-001','Mithra','12/12/2015','Intellor','10','12','2','10000.0000','12000.0000','2000.0000','6','3','5','Mobile','Bad','Services','SPL');
/*!40000 ALTER TABLE `orditemsdeliver001mb` ENABLE KEYS */;


--
-- Definition of table `packingslip001mb`
--

DROP TABLE IF EXISTS `packingslip001mb`;
CREATE TABLE `packingslip001mb` (
  `psId` int(11) NOT NULL AUTO_INCREMENT,
  `slipName` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `delName` varchar(50) NOT NULL,
  PRIMARY KEY (`psId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `packingslip001mb`
--

/*!40000 ALTER TABLE `packingslip001mb` DISABLE KEYS */;
INSERT INTO `packingslip001mb` (`psId`,`slipName`,`status`,`delName`) VALUES 
 (1,'PS0001','Draft','DN-0007');
/*!40000 ALTER TABLE `packingslip001mb` ENABLE KEYS */;


--
-- Definition of table `paymententry001mb`
--

DROP TABLE IF EXISTS `paymententry001mb`;
CREATE TABLE `paymententry001mb` (
  `payentId` int(11) NOT NULL AUTO_INCREMENT,
  `entrySeries` varchar(50) NOT NULL,
  `postingDate` varchar(50) NOT NULL,
  `paymentType` varchar(50) NOT NULL,
  `paymentMode` varchar(50) NOT NULL,
  `partyType` varchar(40) NOT NULL,
  `partyName` varchar(50) NOT NULL,
  `accpaidTo` varchar(50) NOT NULL,
  PRIMARY KEY (`payentId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymententry001mb`
--

/*!40000 ALTER TABLE `paymententry001mb` DISABLE KEYS */;
INSERT INTO `paymententry001mb` (`payentId`,`entrySeries`,`postingDate`,`paymentType`,`paymentMode`,`partyType`,`partyName`,`accpaidTo`) VALUES 
 (1,'SER-001','12/12/2015','Pay','Cash','Supplier','Asiatic Solution','National Bank'),
 (2,'SER-002','11/17/2016','Pay','Wire Transfer','Customer','Asiatic Solution','Cash');
/*!40000 ALTER TABLE `paymententry001mb` ENABLE KEYS */;


--
-- Definition of table `paymentrequest001mb`
--

DROP TABLE IF EXISTS `paymentrequest001mb`;
CREATE TABLE `paymentrequest001mb` (
  `payreqId` int(11) NOT NULL AUTO_INCREMENT,
  `prName` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`payreqId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymentrequest001mb`
--

/*!40000 ALTER TABLE `paymentrequest001mb` DISABLE KEYS */;
INSERT INTO `paymentrequest001mb` (`payreqId`,`prName`,`status`) VALUES 
 (1,'PR001','Paid'),
 (2,'PR002','Initiated');
/*!40000 ALTER TABLE `paymentrequest001mb` ENABLE KEYS */;


--
-- Definition of table `payroll001mb`
--

DROP TABLE IF EXISTS `payroll001mb`;
CREATE TABLE `payroll001mb` (
  `prId` int(11) NOT NULL AUTO_INCREMENT,
  `sNo` int(11) DEFAULT NULL,
  `status` varchar(30) NOT NULL,
  `fiscalYear` int(11) NOT NULL,
  `salarySlip` varchar(50) NOT NULL,
  `empName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`prId`),
  KEY `sNo` (`sNo`),
  CONSTRAINT `payroll001mb_ibfk_1` FOREIGN KEY (`sNo`) REFERENCES `employee001mb` (`sNo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payroll001mb`
--

/*!40000 ALTER TABLE `payroll001mb` DISABLE KEYS */;
INSERT INTO `payroll001mb` (`prId`,`sNo`,`status`,`fiscalYear`,`salarySlip`,`empName`) VALUES 
 (1,NULL,'Draft',2016,'20000','Manikandan');
/*!40000 ALTER TABLE `payroll001mb` ENABLE KEYS */;


--
-- Definition of table `periodclosingvoucher001mb`
--

DROP TABLE IF EXISTS `periodclosingvoucher001mb`;
CREATE TABLE `periodclosingvoucher001mb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `transactiondate` varchar(45) NOT NULL,
  `closingaccounthead` varchar(45) NOT NULL,
  `postingdate` varchar(45) NOT NULL,
  `closingfiscalyear` varchar(45) NOT NULL,
  `company` varchar(45) NOT NULL,
  `remarks` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `periodclosingvoucher001mb`
--

/*!40000 ALTER TABLE `periodclosingvoucher001mb` DISABLE KEYS */;
INSERT INTO `periodclosingvoucher001mb` (`id`,`transactiondate`,`closingaccounthead`,`postingdate`,`closingfiscalyear`,`company`,`remarks`) VALUES 
 (2,'10/07/2016','SIVA','10/21/2016','2016 OCT','KARYA','Good');
/*!40000 ALTER TABLE `periodclosingvoucher001mb` ENABLE KEYS */;


--
-- Definition of table `pricingrule001mb`
--

DROP TABLE IF EXISTS `pricingrule001mb`;
CREATE TABLE `pricingrule001mb` (
  `priceruleid` int(11) NOT NULL AUTO_INCREMENT,
  `priceTitle` varchar(50) NOT NULL,
  `itemCode` varchar(50) NOT NULL,
  `selling` varchar(50) NOT NULL,
  `buying` varchar(50) NOT NULL,
  `minQty` varchar(20) NOT NULL,
  `maxQty` varchar(30) NOT NULL,
  `validFrom` varchar(40) NOT NULL,
  `company` varchar(50) NOT NULL,
  `validUpto` varchar(50) NOT NULL,
  `prordisc` varchar(50) NOT NULL,
  `discprlist` varchar(50) DEFAULT NULL,
  `forprlist` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`priceruleid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pricingrule001mb`
--

/*!40000 ALTER TABLE `pricingrule001mb` DISABLE KEYS */;
INSERT INTO `pricingrule001mb` (`priceruleid`,`priceTitle`,`itemCode`,`selling`,`buying`,`minQty`,`maxQty`,`validFrom`,`company`,`validUpto`,`prordisc`,`discprlist`,`forprlist`) VALUES 
 (1,'PR-001','Table','0','1','6','10','01/28/2016','Dell','08/08/2016','Price','','5000'),
 (3,'Top Most','Internal Disc','0','1','2','2','10/27/2016','Dell','10/20/2016','Price','','35%'),
 (5,'PR-005','Wind Turbine-L','1','1','3','8','10/26/2016','Dell','10/20/2016','Discount','10%',''),
 (6,'','','0','0','','','','','','','',''),
 (7,'','','0','0','','','','','','','','');
/*!40000 ALTER TABLE `pricingrule001mb` ENABLE KEYS */;


--
-- Definition of table `prmatreq001mb`
--

DROP TABLE IF EXISTS `prmatreq001mb`;
CREATE TABLE `prmatreq001mb` (
  `pmrId` int(11) NOT NULL AUTO_INCREMENT,
  `mrType` varchar(30) NOT NULL,
  `mrSeries` varchar(40) NOT NULL,
  `itemCode` varchar(40) NOT NULL,
  `quantity` varchar(20) NOT NULL,
  `forWarehouse` varchar(40) NOT NULL,
  `requiredDate` varchar(40) NOT NULL,
  PRIMARY KEY (`pmrId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prmatreq001mb`
--

/*!40000 ALTER TABLE `prmatreq001mb` DISABLE KEYS */;
INSERT INTO `prmatreq001mb` (`pmrId`,`mrType`,`mrSeries`,`itemCode`,`quantity`,`forWarehouse`,`requiredDate`) VALUES 
 (1,'Purchase','MRSER-001','WingSheet','3','Table','10/12/2016'),
 (4,'Material Issue','MRSER-006','Shaft','5','SSPDL','10/12/2016'),
 (5,'Purchase','MRSER-003','Table','5','SPL','10/20/2016');
/*!40000 ALTER TABLE `prmatreq001mb` ENABLE KEYS */;


--
-- Definition of table `processpr001mb`
--

DROP TABLE IF EXISTS `processpr001mb`;
CREATE TABLE `processpr001mb` (
  `processId` int(11) NOT NULL AUTO_INCREMENT,
  `sNo` int(11) DEFAULT NULL,
  `year` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `postingDate` varchar(30) NOT NULL,
  `deptName` varchar(255) DEFAULT NULL,
  `empCompany` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`processId`),
  KEY `sNo` (`sNo`),
  CONSTRAINT `processpr001mb_ibfk_1` FOREIGN KEY (`sNo`) REFERENCES `employee001mb` (`sNo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `processpr001mb`
--

/*!40000 ALTER TABLE `processpr001mb` DISABLE KEYS */;
INSERT INTO `processpr001mb` (`processId`,`sNo`,`year`,`month`,`postingDate`,`deptName`,`empCompany`) VALUES 
 (1,NULL,2016,1,'10/01/2016','Legal','Dell');
/*!40000 ALTER TABLE `processpr001mb` ENABLE KEYS */;


--
-- Definition of table `prodbundle001mb`
--

DROP TABLE IF EXISTS `prodbundle001mb`;
CREATE TABLE `prodbundle001mb` (
  `pbundId` int(11) NOT NULL AUTO_INCREMENT,
  `itemCode` varchar(50) NOT NULL,
  `childItem` varchar(50) NOT NULL,
  `quantity` varchar(50) NOT NULL,
  `description` varchar(150) NOT NULL,
  PRIMARY KEY (`pbundId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prodbundle001mb`
--

/*!40000 ALTER TABLE `prodbundle001mb` DISABLE KEYS */;
INSERT INTO `prodbundle001mb` (`pbundId`,`itemCode`,`childItem`,`quantity`,`description`) VALUES 
 (1,'Table','Wood','4','Poor Quality'),
 (2,'Shaft','Bold','5','Worst');
/*!40000 ALTER TABLE `prodbundle001mb` ENABLE KEYS */;


--
-- Definition of table `prodorder001mb`
--

DROP TABLE IF EXISTS `prodorder001mb`;
CREATE TABLE `prodorder001mb` (
  `prId` int(11) NOT NULL AUTO_INCREMENT,
  `itemtoManufacture` varchar(40) NOT NULL,
  `status` varchar(30) NOT NULL,
  `prorderCode` varchar(30) NOT NULL,
  PRIMARY KEY (`prId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prodorder001mb`
--

/*!40000 ALTER TABLE `prodorder001mb` DISABLE KEYS */;
INSERT INTO `prodorder001mb` (`prId`,`itemtoManufacture`,`status`,`prorderCode`) VALUES 
 (1,'Ballette','Draft','PRO_00084'),
 (8,'Front Door','Completed','PRO_0009'),
 (9,'                   ','Submitted','                              ');
/*!40000 ALTER TABLE `prodorder001mb` ENABLE KEYS */;


--
-- Definition of table `prodplan001mb`
--

DROP TABLE IF EXISTS `prodplan001mb`;
CREATE TABLE `prodplan001mb` (
  `prplanId` int(11) NOT NULL AUTO_INCREMENT,
  `getItems` varchar(40) NOT NULL,
  `itemCode` varchar(40) NOT NULL,
  `bomNo` varchar(30) NOT NULL,
  `plannedQty` varchar(40) NOT NULL,
  `pendingQty` varchar(30) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`prplanId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prodplan001mb`
--

/*!40000 ALTER TABLE `prodplan001mb` DISABLE KEYS */;
INSERT INTO `prodplan001mb` (`prplanId`,`getItems`,`itemCode`,`bomNo`,`plannedQty`,`pendingQty`,`description`) VALUES 
 (1,'Sales Order','TA-TUB12','8686','10','4',''),
 (3,'Material Request','Shaft','7878','9','2','Product quality is poor'),
 (4,'Material Request','Shaft','8686','10','2','Product is a good quality'),
 (5,'Sales Order','Wind Turbine-L','sdfsfsdfsdfsfsdfs','sdfsdsd','sdf','sdfsdf');
/*!40000 ALTER TABLE `prodplan001mb` ENABLE KEYS */;


--
-- Definition of table `prodstockentry001mb`
--

DROP TABLE IF EXISTS `prodstockentry001mb`;
CREATE TABLE `prodstockentry001mb` (
  `prstockId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `status` varchar(40) NOT NULL,
  `purpose` varchar(50) NOT NULL,
  `stockEntry` varchar(30) NOT NULL,
  PRIMARY KEY (`prstockId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prodstockentry001mb`
--

/*!40000 ALTER TABLE `prodstockentry001mb` DISABLE KEYS */;
INSERT INTO `prodstockentry001mb` (`prstockId`,`title`,`status`,`purpose`,`stockEntry`) VALUES 
 (1,'Materials Transfer for Manufacture','Draft','Material Transfer','STE-000T2'),
 (2,'Materials Transfer','Notstarted','Manufacture','STE-00T61'),
 (3,'Materials Receipt','Stopped','Receipt','STE-000TT'),
 (5,'Materials Transfer','In-Process','Manufacture','STE-00T61');
/*!40000 ALTER TABLE `prodstockentry001mb` ENABLE KEYS */;


--
-- Definition of table `prodtimesheet001mb`
--

DROP TABLE IF EXISTS `prodtimesheet001mb`;
CREATE TABLE `prodtimesheet001mb` (
  `prtId` int(11) NOT NULL AUTO_INCREMENT,
  `empName` varchar(40) NOT NULL,
  `tsName` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `empCompany` varchar(40) NOT NULL,
  `twhrs` varchar(40) NOT NULL,
  PRIMARY KEY (`prtId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prodtimesheet001mb`
--

/*!40000 ALTER TABLE `prodtimesheet001mb` DISABLE KEYS */;
INSERT INTO `prodtimesheet001mb` (`prtId`,`empName`,`tsName`,`status`,`empCompany`,`twhrs`) VALUES 
 (1,'Bala','time sheet_1','Draft','Dell','8'),
 (2,'Harish','time sheet_2','Submitted','Hyundai pvt Ltd','10'),
 (5,'Hatsue Kashiwagi','timesheet_099','Stopped','Wheels India','8');
/*!40000 ALTER TABLE `prodtimesheet001mb` ENABLE KEYS */;


--
-- Definition of table `productbundle001mb`
--

DROP TABLE IF EXISTS `productbundle001mb`;
CREATE TABLE `productbundle001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `parentitem` varchar(255) DEFAULT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productbundle001mb`
--

/*!40000 ALTER TABLE `productbundle001mb` DISABLE KEYS */;
INSERT INTO `productbundle001mb` (`id`,`description`,`item`,`parentitem`,`quantity`) VALUES 
 (1,'desc','bat','bat','2'),
 (2,'desc','ball','ball','5'),
 (3,'dexs','Wing Sheet','parent','5');
/*!40000 ALTER TABLE `productbundle001mb` ENABLE KEYS */;


--
-- Definition of table `progprodorder001mb`
--

DROP TABLE IF EXISTS `progprodorder001mb`;
CREATE TABLE `progprodorder001mb` (
  `prodId` int(11) NOT NULL AUTO_INCREMENT,
  `prorderCode` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `itemtoManufacture` varchar(40) NOT NULL,
  `toProduce` varchar(30) DEFAULT NULL,
  `produced` varchar(30) NOT NULL,
  `empCompany` varchar(30) NOT NULL,
  PRIMARY KEY (`prodId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `progprodorder001mb`
--

/*!40000 ALTER TABLE `progprodorder001mb` DISABLE KEYS */;
INSERT INTO `progprodorder001mb` (`prodId`,`prorderCode`,`date`,`itemtoManufacture`,`toProduce`,`produced`,`empCompany`) VALUES 
 (1,'PRO_00084','10/20/2016','Balleett','10','6','Dell');
/*!40000 ALTER TABLE `progprodorder001mb` ENABLE KEYS */;


--
-- Definition of table `project001mb`
--

DROP TABLE IF EXISTS `project001mb`;
CREATE TABLE `project001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectname` varchar(30) NOT NULL,
  `estimatedcost` int(11) NOT NULL,
  `enddate` varchar(50) NOT NULL,
  `startdate` varchar(50) NOT NULL,
  `status` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project001mb`
--

/*!40000 ALTER TABLE `project001mb` DISABLE KEYS */;
INSERT INTO `project001mb` (`id`,`projectname`,`estimatedcost`,`enddate`,`startdate`,`status`) VALUES 
 (1,'Intellor',200,'10/03/2016','10/01/2016','initated'),
 (9,'kapa',45,'09/27/2016','09/27/2016','opened'),
 (10,'entitywageting',96,'10/20/2016','10/15/2016','opened');
/*!40000 ALTER TABLE `project001mb` ENABLE KEYS */;


--
-- Definition of table `prpurchaseord001mb`
--

DROP TABLE IF EXISTS `prpurchaseord001mb`;
CREATE TABLE `prpurchaseord001mb` (
  `proId` int(11) NOT NULL AUTO_INCREMENT,
  `poSeries` varchar(40) NOT NULL,
  `date` varchar(40) NOT NULL,
  `supplier` varchar(40) NOT NULL,
  `supplyrawmat` varchar(40) NOT NULL,
  `itemCode` varchar(40) NOT NULL,
  `quantity` varchar(40) NOT NULL,
  `rate` decimal(12,4) NOT NULL,
  `amount` decimal(12,4) NOT NULL,
  `prtype` varchar(40) NOT NULL,
  `accountHead` varchar(50) DEFAULT NULL,
  `quotrate` decimal(12,4) NOT NULL,
  `taxandChg` varchar(40) NOT NULL,
  PRIMARY KEY (`proId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prpurchaseord001mb`
--

/*!40000 ALTER TABLE `prpurchaseord001mb` DISABLE KEYS */;
INSERT INTO `prpurchaseord001mb` (`proId`,`poSeries`,`date`,`supplier`,`supplyrawmat`,`itemCode`,`quantity`,`rate`,`amount`,`prtype`,`accountHead`,`quotrate`,`taxandChg`) VALUES 
 (1,'SER-009','12/12/2016','sample','Yes','Wind Mill Series','5','230.0000','250.0000','Normal','Manager','300.0000','Applicable'),
 (3,'Material Transfer','10/13/2016','New World Reality','No','Table','5','10000.0000','5000.0000','Exec','HR Manager','3000.0000','5000'),
 (4,'Material Issue','10/13/2016','New World Reality','Yes','Wind Turbine-L','3','200.0000','345.0000','Normal','Manager','400.0000','500');
/*!40000 ALTER TABLE `prpurchaseord001mb` ENABLE KEYS */;


--
-- Definition of table `prreqquot001mb`
--

DROP TABLE IF EXISTS `prreqquot001mb`;
CREATE TABLE `prreqquot001mb` (
  `prqId` int(11) NOT NULL AUTO_INCREMENT,
  `rqSeries` varchar(40) NOT NULL,
  `date` varchar(40) NOT NULL,
  `supplier` varchar(40) NOT NULL,
  `emailId` varchar(60) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `itemCode` varchar(50) NOT NULL,
  `requiredDate` varchar(50) NOT NULL,
  `quantity` varchar(50) NOT NULL,
  `warehouse` varchar(50) NOT NULL,
  PRIMARY KEY (`prqId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prreqquot001mb`
--

/*!40000 ALTER TABLE `prreqquot001mb` DISABLE KEYS */;
INSERT INTO `prreqquot001mb` (`prqId`,`rqSeries`,`date`,`supplier`,`emailId`,`contact`,`itemCode`,`requiredDate`,`quantity`,`warehouse`) VALUES 
 (1,'RQSER-001','10/10/2016','Modern Electricals','test@gamil.com','Sri ram','BOM-WindMillSeries-001','10/10/2016','4','SPL SERIES');
/*!40000 ALTER TABLE `prreqquot001mb` ENABLE KEYS */;


--
-- Definition of table `prsureq001mb`
--

DROP TABLE IF EXISTS `prsureq001mb`;
CREATE TABLE `prsureq001mb` (
  `prsrId` int(11) NOT NULL AUTO_INCREMENT,
  `suSeries` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `supplier` varchar(40) NOT NULL,
  `itemCode` varchar(40) NOT NULL,
  `quantity` varchar(30) NOT NULL,
  `stockUOM` varchar(20) NOT NULL,
  `rate` decimal(12,4) NOT NULL,
  `taxandChg` decimal(12,4) DEFAULT NULL,
  `accountHead` varchar(40) NOT NULL,
  `squotrate` decimal(12,4) DEFAULT NULL,
  `sutype` varchar(40) NOT NULL,
  PRIMARY KEY (`prsrId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prsureq001mb`
--

/*!40000 ALTER TABLE `prsureq001mb` DISABLE KEYS */;
INSERT INTO `prsureq001mb` (`prsrId`,`suSeries`,`date`,`supplier`,`itemCode`,`quantity`,`stockUOM`,`rate`,`taxandChg`,`accountHead`,`squotrate`,`sutype`) VALUES 
 (1,'SUSER-001','12/12/2015','harish','BOM-WindMillSeries-003','4','Nos','200.0000','1000.0000','Manager','465.0000','normal'),
 (3,'Material Transfer','10/13/2016','Eagle Hardware','Internal Disc','2','Nos','300.0000','550.0000','Manager','500.0000','Premium');
/*!40000 ALTER TABLE `prsureq001mb` ENABLE KEYS */;


--
-- Definition of table `puordtrends001mb`
--

DROP TABLE IF EXISTS `puordtrends001mb`;
CREATE TABLE `puordtrends001mb` (
  `ptrId` int(11) NOT NULL AUTO_INCREMENT,
  `period` varchar(50) NOT NULL,
  `basedOn` varchar(40) NOT NULL,
  `fiscalYear` varchar(30) NOT NULL,
  `company` varchar(60) NOT NULL,
  `itemCode` varchar(50) NOT NULL,
  `janQty` varchar(40) DEFAULT NULL,
  `janAmt` decimal(12,4) DEFAULT NULL,
  `febQty` varchar(40) DEFAULT NULL,
  `febAmt` decimal(12,4) DEFAULT NULL,
  `marQty` varchar(30) DEFAULT NULL,
  `marAmt` decimal(12,4) DEFAULT NULL,
  `aprQty` varchar(40) NOT NULL,
  `aprAmt` decimal(12,4) DEFAULT NULL,
  `mayQty` varchar(40) DEFAULT NULL,
  `mayAmt` decimal(12,4) DEFAULT NULL,
  `junQty` varchar(40) DEFAULT NULL,
  `junAmt` decimal(12,4) DEFAULT NULL,
  `julQty` varchar(40) DEFAULT NULL,
  `julAmt` decimal(12,4) DEFAULT NULL,
  `augQty` varchar(40) DEFAULT NULL,
  `augAmt` decimal(12,4) DEFAULT NULL,
  `sepQty` varchar(40) DEFAULT NULL,
  `sepAmt` decimal(12,4) DEFAULT NULL,
  `octQty` varchar(40) DEFAULT NULL,
  `octAmt` decimal(12,4) DEFAULT NULL,
  `novQty` varchar(40) DEFAULT NULL,
  `novAmt` decimal(12,4) DEFAULT NULL,
  `decQty` varchar(40) DEFAULT NULL,
  `decAmt` decimal(12,4) DEFAULT NULL,
  `totalQty` varchar(30) DEFAULT NULL,
  `totalAmt` decimal(12,4) DEFAULT NULL,
  `augQtyt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ptrId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `puordtrends001mb`
--

/*!40000 ALTER TABLE `puordtrends001mb` DISABLE KEYS */;
INSERT INTO `puordtrends001mb` (`ptrId`,`period`,`basedOn`,`fiscalYear`,`company`,`itemCode`,`janQty`,`janAmt`,`febQty`,`febAmt`,`marQty`,`marAmt`,`aprQty`,`aprAmt`,`mayQty`,`mayAmt`,`junQty`,`junAmt`,`julQty`,`julAmt`,`augQty`,`augAmt`,`sepQty`,`sepAmt`,`octQty`,`octAmt`,`novQty`,`novAmt`,`decQty`,`decAmt`,`totalQty`,`totalAmt`,`augQtyt`) VALUES 
 (1,'Monthly','Item','2015','Dell','Table','12','3400.0000','10','2450.0000','','0.0000','','0.0000','','0.0000','','0.0000','','0.0000','','0.0000','6','4500.0000','7','5600.0000','','0.0000','14','16000.0000','100','1000000.0000',NULL),
 (2,'Weekly','Supplier Type','2011','Dell','Wind Mill A Series','2','200.0000','1','100.0000','3','300.0000','4','400.0000','1','100.0000','1','100.0000',NULL,'600.0000',NULL,'700.0000','4','400.0000','3','300.0000','3','300.0000','2','200.0000','16','16000.0000','7');
/*!40000 ALTER TABLE `puordtrends001mb` ENABLE KEYS */;


--
-- Definition of table `puranalytics001mb`
--

DROP TABLE IF EXISTS `puranalytics001mb`;
CREATE TABLE `puranalytics001mb` (
  `puansId` int(11) NOT NULL AUTO_INCREMENT,
  `treeType` varchar(50) NOT NULL,
  `basedOn` varchar(50) NOT NULL,
  `valueorqty` varchar(40) NOT NULL,
  `company` varchar(50) NOT NULL,
  `fromDate` varchar(50) NOT NULL,
  `toDate` varchar(50) NOT NULL,
  `anRange` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`puansId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `puranalytics001mb`
--

/*!40000 ALTER TABLE `puranalytics001mb` DISABLE KEYS */;
INSERT INTO `puranalytics001mb` (`puansId`,`treeType`,`basedOn`,`valueorqty`,`company`,`fromDate`,`toDate`,`anRange`) VALUES 
 (1,'Supplier','Purchase In-voice','Quantity','Dell','12/10/2016','18/10/2016','Daily'),
 (4,'Item Group','Purchase Order','Value','IBM','10/14/2016','10/12/2016','Monthly');
/*!40000 ALTER TABLE `puranalytics001mb` ENABLE KEYS */;


--
-- Definition of table `purchase001mb`
--

DROP TABLE IF EXISTS `purchase001mb`;
CREATE TABLE `purchase001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Date` varchar(255) DEFAULT NULL,
  `grandtotal` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `supplieraddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase001mb`
--

/*!40000 ALTER TABLE `purchase001mb` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase001mb` ENABLE KEYS */;


--
-- Definition of table `purchasereceipt001mb`
--

DROP TABLE IF EXISTS `purchasereceipt001mb`;
CREATE TABLE `purchasereceipt001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier` varchar(30) NOT NULL,
  `Date` varchar(30) NOT NULL,
  `supplieraddress` varchar(30) NOT NULL,
  `grandtotal` varchar(30) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchasereceipt001mb`
--

/*!40000 ALTER TABLE `purchasereceipt001mb` DISABLE KEYS */;
INSERT INTO `purchasereceipt001mb` (`id`,`supplier`,`Date`,`supplieraddress`,`grandtotal`,`status`) VALUES 
 (1,'solutions','12-08-2016','solutions','100','tobill'),
 (2,'solutions','12-08-2016','solutions','100','tobill');
/*!40000 ALTER TABLE `purchasereceipt001mb` ENABLE KEYS */;


--
-- Definition of table `purecpttrend001mb`
--

DROP TABLE IF EXISTS `purecpttrend001mb`;
CREATE TABLE `purecpttrend001mb` (
  `putrendId` int(11) NOT NULL AUTO_INCREMENT,
  `period` varchar(50) NOT NULL,
  `basedOn` varchar(40) NOT NULL,
  `fiscalYear` varchar(30) NOT NULL,
  `company` varchar(60) NOT NULL,
  `itemCode` varchar(50) NOT NULL,
  `janQty` varchar(40) DEFAULT NULL,
  `janAmt` decimal(12,4) DEFAULT NULL,
  `febQty` varchar(40) DEFAULT NULL,
  `febAmt` decimal(12,4) DEFAULT NULL,
  `marQty` varchar(30) DEFAULT NULL,
  `marAmt` decimal(12,4) DEFAULT NULL,
  `aprQty` varchar(40) NOT NULL,
  `aprAmt` decimal(12,4) DEFAULT NULL,
  `mayQty` varchar(40) DEFAULT NULL,
  `mayAmt` decimal(12,4) DEFAULT NULL,
  `junQty` varchar(40) DEFAULT NULL,
  `junAmt` decimal(12,4) DEFAULT NULL,
  `julQty` varchar(40) DEFAULT NULL,
  `julAmt` decimal(12,4) DEFAULT NULL,
  `augQty` varchar(40) DEFAULT NULL,
  `augAmt` decimal(12,4) DEFAULT NULL,
  `sepQty` varchar(40) DEFAULT NULL,
  `sepAmt` decimal(12,4) DEFAULT NULL,
  `octQty` varchar(40) DEFAULT NULL,
  `octAmt` decimal(12,4) DEFAULT NULL,
  `novQty` varchar(40) DEFAULT NULL,
  `novAmt` decimal(12,4) DEFAULT NULL,
  `decQty` varchar(40) DEFAULT NULL,
  `decAmt` decimal(12,4) DEFAULT NULL,
  `totalQty` varchar(30) DEFAULT NULL,
  `totalAmt` decimal(12,4) DEFAULT NULL,
  `augQtyt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`putrendId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purecpttrend001mb`
--

/*!40000 ALTER TABLE `purecpttrend001mb` DISABLE KEYS */;
INSERT INTO `purecpttrend001mb` (`putrendId`,`period`,`basedOn`,`fiscalYear`,`company`,`itemCode`,`janQty`,`janAmt`,`febQty`,`febAmt`,`marQty`,`marAmt`,`aprQty`,`aprAmt`,`mayQty`,`mayAmt`,`junQty`,`junAmt`,`julQty`,`julAmt`,`augQty`,`augAmt`,`sepQty`,`sepAmt`,`octQty`,`octAmt`,`novQty`,`novAmt`,`decQty`,`decAmt`,`totalQty`,`totalAmt`,`augQtyt`) VALUES 
 (1,'Monthly','Item','2015','Dell','Table','12','3400.0000','10','2450.0000','','0.0000','','0.0000','','0.0000','','0.0000','','0.0000','','0.0000','6','4500.0000','7','5600.0000','','0.0000','14','16000.0000','100','1000000.0000',NULL),
 (2,'Weekly','Supplier Type','2011','Dell','Wind Mill A Series','2','200.0000','1','100.0000','3','300.0000','4','400.0000','1','100.0000','1','100.0000',NULL,'600.0000',NULL,'700.0000','4','400.0000','3','300.0000','3','300.0000','2','200.0000','16','16000.0000',NULL);
/*!40000 ALTER TABLE `purecpttrend001mb` ENABLE KEYS */;


--
-- Definition of table `purorditemreceive001mb`
--

DROP TABLE IF EXISTS `purorditemreceive001mb`;
CREATE TABLE `purorditemreceive001mb` (
  `poitrecId` int(11) NOT NULL AUTO_INCREMENT,
  `puOrder` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `reqbyDate` varchar(50) NOT NULL,
  `supName` varchar(50) NOT NULL,
  `projectName` varchar(50) DEFAULT NULL,
  `quantity` varchar(30) NOT NULL,
  `receivedQty` decimal(12,4) DEFAULT NULL,
  `qtytoReceive` decimal(12,4) DEFAULT NULL,
  `warehouseName` varchar(50) NOT NULL,
  `itemCode` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `brandName` varchar(50) NOT NULL,
  `company` varchar(50) NOT NULL,
  PRIMARY KEY (`poitrecId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purorditemreceive001mb`
--

/*!40000 ALTER TABLE `purorditemreceive001mb` DISABLE KEYS */;
INSERT INTO `purorditemreceive001mb` (`poitrecId`,`puOrder`,`date`,`reqbyDate`,`supName`,`projectName`,`quantity`,`receivedQty`,`qtytoReceive`,`warehouseName`,`itemCode`,`description`,`brandName`,`company`) VALUES 
 (1,'PO-001','12/12/2016','10','Asiatic Solution','Intellor','22','13.0000','10.0000','SPL','Table','Good','Top','Dell');
/*!40000 ALTER TABLE `purorditemreceive001mb` ENABLE KEYS */;


--
-- Definition of table `recruitapplicant001mb`
--

DROP TABLE IF EXISTS `recruitapplicant001mb`;
CREATE TABLE `recruitapplicant001mb` (
  `appId` int(11) NOT NULL AUTO_INCREMENT,
  `applicantName` varchar(40) NOT NULL,
  `status` varchar(30) NOT NULL,
  `jobId` int(11) DEFAULT NULL,
  `jobName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`appId`),
  KEY `jobId` (`jobId`),
  CONSTRAINT `recruitapplicant001mb_ibfk_1` FOREIGN KEY (`jobId`) REFERENCES `recruitopening001mb` (`jobId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recruitapplicant001mb`
--

/*!40000 ALTER TABLE `recruitapplicant001mb` DISABLE KEYS */;
INSERT INTO `recruitapplicant001mb` (`appId`,`applicantName`,`status`,`jobId`,`jobName`) VALUES 
 (1,'sanjay','replied',1,NULL),
 (2,'rohit','hold',1,'development'),
 (3,'yogesh','open',2,'testing');
/*!40000 ALTER TABLE `recruitapplicant001mb` ENABLE KEYS */;


--
-- Definition of table `recruitoffer001mb`
--

DROP TABLE IF EXISTS `recruitoffer001mb`;
CREATE TABLE `recruitoffer001mb` (
  `offerId` int(11) NOT NULL AUTO_INCREMENT,
  `applicantNamePrefix` varchar(30) NOT NULL,
  `applicantName` varchar(30) NOT NULL,
  `companyName` varchar(30) NOT NULL,
  `offer` varchar(30) NOT NULL,
  `refer` varchar(30) NOT NULL,
  `position` varchar(30) NOT NULL,
  `grade` varchar(30) NOT NULL,
  `ctc` varchar(30) NOT NULL,
  `dateOfJoin` varchar(30) NOT NULL,
  `line1` varchar(45) NOT NULL,
  `line2` varchar(45) NOT NULL,
  `cityOrVillage` varchar(30) NOT NULL,
  `stateOrTerritory` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `postalCode` varchar(30) NOT NULL,
  `phoneNo` varchar(20) NOT NULL,
  `alternativePhoneNo` varchar(20) NOT NULL,
  `offerLetter` varchar(30) NOT NULL,
  PRIMARY KEY (`offerId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recruitoffer001mb`
--

/*!40000 ALTER TABLE `recruitoffer001mb` DISABLE KEYS */;
INSERT INTO `recruitoffer001mb` (`offerId`,`applicantNamePrefix`,`applicantName`,`companyName`,`offer`,`refer`,`position`,`grade`,`ctc`,`dateOfJoin`,`line1`,`line2`,`cityOrVillage`,`stateOrTerritory`,`country`,`postalCode`,`phoneNo`,`alternativePhoneNo`,`offerLetter`) VALUES 
 (8,'Mr','Kabirul Islam','Karya Technologies','Software Development','KARYA|2016|RR','Associate Software Developer','R','360000','10/18/2016','Housing Board','Old Pallavaram','Chennai','TN','India','600117','9962626836','','offer_08712');
/*!40000 ALTER TABLE `recruitoffer001mb` ENABLE KEYS */;


--
-- Definition of table `recruitopening001mb`
--

DROP TABLE IF EXISTS `recruitopening001mb`;
CREATE TABLE `recruitopening001mb` (
  `jobId` int(11) NOT NULL AUTO_INCREMENT,
  `jobName` varchar(40) NOT NULL,
  `status` varchar(30) NOT NULL,
  PRIMARY KEY (`jobId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recruitopening001mb`
--

/*!40000 ALTER TABLE `recruitopening001mb` DISABLE KEYS */;
INSERT INTO `recruitopening001mb` (`jobId`,`jobName`,`status`) VALUES 
 (1,'development','open'),
 (2,'testing','closed'),
 (4,'Business Analyst','closed');
/*!40000 ALTER TABLE `recruitopening001mb` ENABLE KEYS */;


--
-- Definition of table `recruitrelieving001mb`
--

DROP TABLE IF EXISTS `recruitrelieving001mb`;
CREATE TABLE `recruitrelieving001mb` (
  `relievingId` int(11) NOT NULL AUTO_INCREMENT,
  `applicantNamePrefix` varchar(30) NOT NULL,
  `applicantName` varchar(30) NOT NULL,
  `companyName` varchar(30) NOT NULL,
  `position` varchar(30) NOT NULL,
  `grade` varchar(30) NOT NULL,
  `dateOfJoin` varchar(20) NOT NULL,
  `dateOfRelieve` varchar(20) NOT NULL,
  `line1` varchar(30) NOT NULL,
  `line2` varchar(30) NOT NULL,
  `cityOrVillage` varchar(30) NOT NULL,
  `stateOrTerritory` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `postalCode` varchar(30) NOT NULL,
  `phoneNo` varchar(20) NOT NULL,
  `alternativePhoneNo` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `relievingLetter` varchar(45) NOT NULL,
  PRIMARY KEY (`relievingId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recruitrelieving001mb`
--

/*!40000 ALTER TABLE `recruitrelieving001mb` DISABLE KEYS */;
INSERT INTO `recruitrelieving001mb` (`relievingId`,`applicantNamePrefix`,`applicantName`,`companyName`,`position`,`grade`,`dateOfJoin`,`dateOfRelieve`,`line1`,`line2`,`cityOrVillage`,`stateOrTerritory`,`country`,`postalCode`,`phoneNo`,`alternativePhoneNo`,`relievingLetter`) VALUES 
 (9,'Mr','Kabirul Islam','Karya Technologies','Associate Software Developer','R','10/04/2016','10/04/2016','Housing Board','Old Pallavaram','Chennai','TN','India','600117','9962626836','26836','rel1001');
/*!40000 ALTER TABLE `recruitrelieving001mb` ENABLE KEYS */;


--
-- Definition of table `recruitworkingexperience001mb`
--

DROP TABLE IF EXISTS `recruitworkingexperience001mb`;
CREATE TABLE `recruitworkingexperience001mb` (
  `workingexperienceId` int(11) NOT NULL AUTO_INCREMENT,
  `applicantNamePrefix` varchar(10) NOT NULL,
  `applicantName` varchar(45) NOT NULL,
  `companyName` varchar(30) NOT NULL,
  `position` varchar(30) NOT NULL,
  `grade` varchar(20) NOT NULL,
  `dateOfJoin` varchar(20) NOT NULL,
  `dateOfRelieve` varchar(20) NOT NULL,
  `workingexperienceLetter` varchar(30) NOT NULL,
  PRIMARY KEY (`workingexperienceId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recruitworkingexperience001mb`
--

/*!40000 ALTER TABLE `recruitworkingexperience001mb` DISABLE KEYS */;
INSERT INTO `recruitworkingexperience001mb` (`workingexperienceId`,`applicantNamePrefix`,`applicantName`,`companyName`,`position`,`grade`,`dateOfJoin`,`dateOfRelieve`,`workingexperienceLetter`) VALUES 
 (12,'Mr','Kabirul Islam','Karya Technologies','Associate Software Developer','R','10/04/2016','10/18/2016','exp101');
/*!40000 ALTER TABLE `recruitworkingexperience001mb` ENABLE KEYS */;


--
-- Definition of table `reqitemorder001mb`
--

DROP TABLE IF EXISTS `reqitemorder001mb`;
CREATE TABLE `reqitemorder001mb` (
  `mrsId` int(11) NOT NULL AUTO_INCREMENT,
  `mrSeries` varchar(50) NOT NULL,
  `date` varchar(40) NOT NULL,
  `itemCode` varchar(50) NOT NULL,
  `quantity` varchar(20) NOT NULL,
  `orderedqty` varchar(20) DEFAULT NULL,
  `qtyrtoorder` varchar(20) DEFAULT NULL,
  `description` varchar(150) DEFAULT NULL,
  `company` varchar(40) NOT NULL,
  `qtytoorder` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mrsId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reqitemorder001mb`
--

/*!40000 ALTER TABLE `reqitemorder001mb` DISABLE KEYS */;
INSERT INTO `reqitemorder001mb` (`mrsId`,`mrSeries`,`date`,`itemCode`,`quantity`,`orderedqty`,`qtyrtoorder`,`description`,`company`,`qtytoorder`) VALUES 
 (1,'MRSER-001','12/10/2016','Table','10','8','2','','dell','10');
/*!40000 ALTER TABLE `reqitemorder001mb` ENABLE KEYS */;


--
-- Definition of table `reqitemtransfer001mb`
--

DROP TABLE IF EXISTS `reqitemtransfer001mb`;
CREATE TABLE `reqitemtransfer001mb` (
  `ittransId` int(11) NOT NULL AUTO_INCREMENT,
  `mrSeries` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `quantity` varchar(40) NOT NULL,
  `transferQty` decimal(12,4) DEFAULT NULL,
  `qtytoTransfer` decimal(12,4) DEFAULT NULL,
  `itemCode` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `company` varchar(50) NOT NULL,
  PRIMARY KEY (`ittransId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reqitemtransfer001mb`
--

/*!40000 ALTER TABLE `reqitemtransfer001mb` DISABLE KEYS */;
INSERT INTO `reqitemtransfer001mb` (`ittransId`,`mrSeries`,`date`,`quantity`,`transferQty`,`qtytoTransfer`,`itemCode`,`description`,`company`) VALUES 
 (1,'MRSER-001','12/12/2015','10','10.0000','3.0000','Table','Good','Dell');
/*!40000 ALTER TABLE `reqitemtransfer001mb` ENABLE KEYS */;


--
-- Definition of table `requestitembuy001mb`
--

DROP TABLE IF EXISTS `requestitembuy001mb`;
CREATE TABLE `requestitembuy001mb` (
  `riId` int(11) NOT NULL AUTO_INCREMENT,
  `itemCode` varchar(40) NOT NULL,
  `warehouse` varchar(40) NOT NULL,
  `actual` varchar(30) NOT NULL,
  `requested` varchar(30) DEFAULT NULL,
  `reserved` varchar(30) DEFAULT NULL,
  `ordered` varchar(30) DEFAULT NULL,
  `projected` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`riId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `requestitembuy001mb`
--

/*!40000 ALTER TABLE `requestitembuy001mb` DISABLE KEYS */;
INSERT INTO `requestitembuy001mb` (`riId`,`itemCode`,`warehouse`,`actual`,`requested`,`reserved`,`ordered`,`projected`) VALUES 
 (1,'Table','SSPDL','10','8','8','12','7'),
 (4,'Table','SPDL','10','8','6','6','12');
/*!40000 ALTER TABLE `requestitembuy001mb` ENABLE KEYS */;


--
-- Definition of table `role001mb`
--

DROP TABLE IF EXISTS `role001mb`;
CREATE TABLE `role001mb` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(45) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role001mb`
--

/*!40000 ALTER TABLE `role001mb` DISABLE KEYS */;
INSERT INTO `role001mb` (`roleid`,`rolename`,`status`) VALUES 
 (1,'ROLE_ADMIN',1),
 (2,'ROLE_SUPER_USER',1),
 (3,'ROLE_USER',1),
 (4,'ROLE_GUEST',1);
/*!40000 ALTER TABLE `role001mb` ENABLE KEYS */;


--
-- Definition of table `salarycomponent001mb`
--

DROP TABLE IF EXISTS `salarycomponent001mb`;
CREATE TABLE `salarycomponent001mb` (
  `salcompId` int(11) NOT NULL AUTO_INCREMENT,
  `comName` varchar(50) DEFAULT NULL,
  `abbr` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`salcompId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salarycomponent001mb`
--

/*!40000 ALTER TABLE `salarycomponent001mb` DISABLE KEYS */;
INSERT INTO `salarycomponent001mb` (`salcompId`,`comName`,`abbr`) VALUES 
 (1,'PAY AS YOU EARN','PAYE'),
 (2,'Income Tax','IT'),
 (3,'HRA-LOL','HRA'),
 (4,'Basic Earning','BE'),
 (5,'My Basic Salary','M'),
 (6,'Lon dod','LD'),
 (8,'Overtime','OT'),
 (9,'Basic','ANC');
/*!40000 ALTER TABLE `salarycomponent001mb` ENABLE KEYS */;


--
-- Definition of table `salarystructure001mb`
--

DROP TABLE IF EXISTS `salarystructure001mb`;
CREATE TABLE `salarystructure001mb` (
  `strId` int(11) NOT NULL AUTO_INCREMENT,
  `empName` varchar(30) DEFAULT NULL,
  `isActive` varchar(20) NOT NULL,
  `fromDate` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`strId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salarystructure001mb`
--

/*!40000 ALTER TABLE `salarystructure001mb` DISABLE KEYS */;
INSERT INTO `salarystructure001mb` (`strId`,`empName`,`isActive`,`fromDate`) VALUES 
 (1,'Bala','Yes','12/12/2014'),
 (2,'Bala','Yes','10/22/2016'),
 (3,'Manikandan','Yes','10/05/2016');
/*!40000 ALTER TABLE `salarystructure001mb` ENABLE KEYS */;


--
-- Definition of table `salesorder001mb`
--

DROP TABLE IF EXISTS `salesorder001mb`;
CREATE TABLE `salesorder001mb` (
  `Sorder` int(11) NOT NULL AUTO_INCREMENT,
  `Customername` varchar(50) NOT NULL,
  `Cpurchaseorder` varchar(60) DEFAULT NULL,
  `Statusname` varchar(255) DEFAULT NULL,
  `Itemid` int(11) DEFAULT NULL,
  `Orderid` int(11) DEFAULT NULL,
  `Itemcode` varchar(40) DEFAULT NULL,
  `Ordername` varchar(255) DEFAULT NULL,
  `Statusid` int(11) DEFAULT NULL,
  `Sdeliverydate` varchar(40) DEFAULT NULL,
  `Sorderdate` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Sorder`),
  KEY `Itemid` (`Itemid`),
  KEY `Orderid` (`Orderid`),
  CONSTRAINT `salesorder001mb_ibfk_1` FOREIGN KEY (`Itemid`) REFERENCES `itemdt001mb` (`Itemid`),
  CONSTRAINT `salesorder001mb_ibfk_2` FOREIGN KEY (`Orderid`) REFERENCES `order001mb` (`Orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salesorder001mb`
--

/*!40000 ALTER TABLE `salesorder001mb` DISABLE KEYS */;
INSERT INTO `salesorder001mb` (`Sorder`,`Customername`,`Cpurchaseorder`,`Statusname`,`Itemid`,`Orderid`,`Itemcode`,`Ordername`,`Statusid`,`Sdeliverydate`,`Sorderdate`) VALUES 
 (81,'Venkat','order3','Draft',NULL,NULL,'Wind Turbine-L','Landskip Yard Care',NULL,'11/05/2016','09/25/2016'),
 (82,'Prasad','order4','Completed',21,3,'Wind Mill A Series','Two Pesos',NULL,'11/04/2016','09/25/2016'),
 (83,'Giri Prasad','order5','Closed',22,2,'Table','Asian Junction',NULL,'11/03/2016','09/30/2016'),
 (84,'Kabir','order6','Cancelled',24,4,'Shaft','Choices',NULL,'11/02/2016','09/25/2016'),
 (85,'Islam','order7','To Deliver',25,1,'Internal Disc','Landskip Yard Care',NULL,'11/15/2016','09/06/2016'),
 (86,'Siva','order8','To Bill',26,3,'Mobile','Two Pesos',NULL,'11/26/2016','09/07/2016'),
 (87,'Ragu','order9','Draft',27,2,'Computer','Asian Junction',NULL,'12/10/2016','09/01/2016'),
 (93,'Venkat','order2','Draft',NULL,NULL,'Wind Turbine-L','Choices',NULL,'10/18/2016','10/06/2016'),
 (94,'Sanjay','order13','Completed',NULL,NULL,'Internal Disc','Choices',NULL,'10/12/2016','10/11/2016'),
 (97,'Sanjay','order13','Closed',NULL,NULL,'Wind Turbine-L','Landskip Yard Care',NULL,'10/19/2016','10/21/2016'),
 (100,'Venkat','order13','Completed',NULL,NULL,'Wind Mill A Series','Choices',NULL,'10/19/2016','10/11/2016');
/*!40000 ALTER TABLE `salesorder001mb` ENABLE KEYS */;


--
-- Definition of table `salestaxesandtemplates001mb`
--

DROP TABLE IF EXISTS `salestaxesandtemplates001mb`;
CREATE TABLE `salestaxesandtemplates001mb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `company` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `accounthead` varchar(45) NOT NULL,
  `rate` int(10) unsigned NOT NULL,
  `amount` int(10) unsigned NOT NULL,
  `total` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salestaxesandtemplates001mb`
--

/*!40000 ALTER TABLE `salestaxesandtemplates001mb` DISABLE KEYS */;
INSERT INTO `salestaxesandtemplates001mb` (`id`,`title`,`company`,`type`,`accounthead`,`rate`,`amount`,`total`) VALUES 
 (2,'KARYA','KARYA','Service','SIVA',100,100,100);
/*!40000 ALTER TABLE `salestaxesandtemplates001mb` ENABLE KEYS */;


--
-- Definition of table `setupcugrp001mb`
--

DROP TABLE IF EXISTS `setupcugrp001mb`;
CREATE TABLE `setupcugrp001mb` (
  `cugrpId` int(11) NOT NULL AUTO_INCREMENT,
  `customergroup` varchar(40) NOT NULL,
  `salesPerson` varchar(40) NOT NULL,
  PRIMARY KEY (`cugrpId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `setupcugrp001mb`
--

/*!40000 ALTER TABLE `setupcugrp001mb` DISABLE KEYS */;
INSERT INTO `setupcugrp001mb` (`cugrpId`,`customergroup`,`salesPerson`) VALUES 
 (1,'Group Name','Expand'),
 (2,'Commercial','Collapse'),
 (3,'Individual','Expand'),
 (4,'Non-Project','Collapse');
/*!40000 ALTER TABLE `setupcugrp001mb` ENABLE KEYS */;


--
-- Definition of table `shippingrule001mb`
--

DROP TABLE IF EXISTS `shippingrule001mb`;
CREATE TABLE `shippingrule001mb` (
  `sruleId` int(11) NOT NULL AUTO_INCREMENT,
  `sruleName` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `sruleLabel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sruleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shippingrule001mb`
--

/*!40000 ALTER TABLE `shippingrule001mb` DISABLE KEYS */;
INSERT INTO `shippingrule001mb` (`sruleId`,`sruleName`,`status`,`sruleLabel`) VALUES 
 (1,'Kerry','Enabled','Kerry'),
 (2,'Fox','Disabled','FOX');
/*!40000 ALTER TABLE `shippingrule001mb` ENABLE KEYS */;


--
-- Definition of table `status001mb`
--

DROP TABLE IF EXISTS `status001mb`;
CREATE TABLE `status001mb` (
  `Statusid` int(11) NOT NULL AUTO_INCREMENT,
  `Statusname` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Statusid`),
  UNIQUE KEY `Statusname` (`Statusname`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status001mb`
--

/*!40000 ALTER TABLE `status001mb` DISABLE KEYS */;
INSERT INTO `status001mb` (`Statusid`,`Statusname`) VALUES 
 (6,'Cancelled'),
 (5,'Closed'),
 (3,'Completed'),
 (2,'Draft'),
 (4,'To Bill'),
 (1,'To Deliver');
/*!40000 ALTER TABLE `status001mb` ENABLE KEYS */;


--
-- Definition of table `stkreconcile001mb`
--

DROP TABLE IF EXISTS `stkreconcile001mb`;
CREATE TABLE `stkreconcile001mb` (
  `stkrecId` int(11) NOT NULL AUTO_INCREMENT,
  `series` varchar(50) NOT NULL,
  `company` varchar(50) NOT NULL,
  `postingDate` varchar(40) NOT NULL,
  `postingTime` varchar(20) NOT NULL,
  `diffAcc` varchar(50) DEFAULT NULL,
  `costCenter` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stkrecId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stkreconcile001mb`
--

/*!40000 ALTER TABLE `stkreconcile001mb` DISABLE KEYS */;
INSERT INTO `stkreconcile001mb` (`stkrecId`,`series`,`company`,`postingDate`,`postingTime`,`diffAcc`,`costCenter`) VALUES 
 (1,'STREC-001','Dell','12/12/2015','14.20.00','Stock Adjustment','Main');
/*!40000 ALTER TABLE `stkreconcile001mb` ENABLE KEYS */;


--
-- Definition of table `stkrepageing001mb`
--

DROP TABLE IF EXISTS `stkrepageing001mb`;
CREATE TABLE `stkrepageing001mb` (
  `stageId` int(11) NOT NULL AUTO_INCREMENT,
  `UOM` varchar(255) DEFAULT NULL,
  `averageAge` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `earliest` varchar(255) DEFAULT NULL,
  `itemCode` varchar(255) DEFAULT NULL,
  `itemGroup` varchar(255) DEFAULT NULL,
  `latest` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stageId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stkrepageing001mb`
--

/*!40000 ALTER TABLE `stkrepageing001mb` DISABLE KEYS */;
INSERT INTO `stkrepageing001mb` (`stageId`,`UOM`,`averageAge`,`brand`,`description`,`earliest`,`itemCode`,`itemGroup`,`latest`) VALUES 
 (1,'Nos','45','Normal','Aging Rapidly','12','Table','Services','12');
/*!40000 ALTER TABLE `stkrepageing001mb` ENABLE KEYS */;


--
-- Definition of table `stkrepbalance001mb`
--

DROP TABLE IF EXISTS `stkrepbalance001mb`;
CREATE TABLE `stkrepbalance001mb` (
  `stbalId` int(11) NOT NULL AUTO_INCREMENT,
  `balanceQty` varchar(255) DEFAULT NULL,
  `balanceValue` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `inQty` varchar(255) DEFAULT NULL,
  `itemCode` varchar(255) DEFAULT NULL,
  `itemGroup` varchar(255) DEFAULT NULL,
  `openingQty` varchar(255) DEFAULT NULL,
  `openingValue` varchar(255) DEFAULT NULL,
  `outQty` varchar(255) DEFAULT NULL,
  `outValue` varchar(255) DEFAULT NULL,
  `stkUOM` varchar(255) DEFAULT NULL,
  `valuationRate` varchar(255) DEFAULT NULL,
  `wareHouse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stbalId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stkrepbalance001mb`
--

/*!40000 ALTER TABLE `stkrepbalance001mb` DISABLE KEYS */;
INSERT INTO `stkrepbalance001mb` (`stbalId`,`balanceQty`,`balanceValue`,`brand`,`company`,`description`,`inQty`,`itemCode`,`itemGroup`,`openingQty`,`openingValue`,`outQty`,`outValue`,`stkUOM`,`valuationRate`,`wareHouse`) VALUES 
 (1,'12','12','Normal','Dell','Worst','12','Wind Mill A Series','Services','12','1234','12','12','Nos','1234','SPL');
/*!40000 ALTER TABLE `stkrepbalance001mb` ENABLE KEYS */;


--
-- Definition of table `stkrepledger001mb`
--

DROP TABLE IF EXISTS `stkrepledger001mb`;
CREATE TABLE `stkrepledger001mb` (
  `stledId` int(11) NOT NULL AUTO_INCREMENT,
  `balanceQty` varchar(255) DEFAULT NULL,
  `balanceValue` varchar(255) DEFAULT NULL,
  `batch` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `incomingRate` varchar(255) DEFAULT NULL,
  `itemCode` varchar(255) DEFAULT NULL,
  `itemGroup` varchar(255) DEFAULT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  `serialNo` varchar(255) DEFAULT NULL,
  `stkUOM` varchar(255) DEFAULT NULL,
  `valuationRate` varchar(255) DEFAULT NULL,
  `voucherCode` varchar(255) DEFAULT NULL,
  `voucherType` varchar(255) DEFAULT NULL,
  `wareHouse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stledId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stkrepledger001mb`
--

/*!40000 ALTER TABLE `stkrepledger001mb` DISABLE KEYS */;
INSERT INTO `stkrepledger001mb` (`stledId`,`balanceQty`,`balanceValue`,`batch`,`brand`,`company`,`date`,`description`,`incomingRate`,`itemCode`,`itemGroup`,`quantity`,`serialNo`,`stkUOM`,`valuationRate`,`voucherCode`,`voucherType`,`wareHouse`) VALUES 
 (1,'5','12','12','Normal','Dell','10/13/2016','Bad','1234','Table','Sub-assemblies','2','LED-001','Nos','1234','VC-001','Stock Entry','SPL');
/*!40000 ALTER TABLE `stkrepledger001mb` ENABLE KEYS */;


--
-- Definition of table `stkrepproject001mb`
--

DROP TABLE IF EXISTS `stkrepproject001mb`;
CREATE TABLE `stkrepproject001mb` (
  `stprojId` int(11) NOT NULL AUTO_INCREMENT,
  `UOM` varchar(255) DEFAULT NULL,
  `actualQty` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `itemCode` varchar(255) DEFAULT NULL,
  `itemGroup` varchar(255) DEFAULT NULL,
  `orderedQty` varchar(255) DEFAULT NULL,
  `plannedQty` varchar(255) DEFAULT NULL,
  `reorderQty` varchar(255) DEFAULT NULL,
  `reorderValue` varchar(255) DEFAULT NULL,
  `requestedQty` varchar(255) DEFAULT NULL,
  `reservedQty` varchar(255) DEFAULT NULL,
  `shortageQty` varchar(255) DEFAULT NULL,
  `wareHouse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stprojId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stkrepproject001mb`
--

/*!40000 ALTER TABLE `stkrepproject001mb` DISABLE KEYS */;
INSERT INTO `stkrepproject001mb` (`stprojId`,`UOM`,`actualQty`,`brand`,`description`,`itemCode`,`itemGroup`,`orderedQty`,`plannedQty`,`reorderQty`,`reorderValue`,`requestedQty`,`reservedQty`,`shortageQty`,`wareHouse`) VALUES 
 (1,'Nos','45','Normal','Casual','Wind Turbine-L','Services','12','30','12','12','12','12','12','SPL');
/*!40000 ALTER TABLE `stkrepproject001mb` ENABLE KEYS */;


--
-- Definition of table `stksettings001mb`
--

DROP TABLE IF EXISTS `stksettings001mb`;
CREATE TABLE `stksettings001mb` (
  `setId` int(11) NOT NULL AUTO_INCREMENT,
  `itemnameBy` varchar(30) NOT NULL,
  `defaultValue` varchar(40) NOT NULL,
  `itemGroup` varchar(50) NOT NULL,
  `allowancePercent` decimal(12,4) DEFAULT NULL,
  `defaultUOM` varchar(20) NOT NULL,
  `warehouseName` varchar(50) NOT NULL,
  `showbarcodeField` varchar(20) DEFAULT NULL,
  `autoinsertPricelist` varchar(20) DEFAULT NULL,
  `autosetSerialno` varchar(20) DEFAULT NULL,
  `allownegativeStock` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`setId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stksettings001mb`
--

/*!40000 ALTER TABLE `stksettings001mb` DISABLE KEYS */;
INSERT INTO `stksettings001mb` (`setId`,`itemnameBy`,`defaultValue`,`itemGroup`,`allowancePercent`,`defaultUOM`,`warehouseName`,`showbarcodeField`,`autoinsertPricelist`,`autosetSerialno`,`allownegativeStock`) VALUES 
 (1,'ItemCode','FIFO','Services','0.0000','Nos','SPL','1','0','0','1');
/*!40000 ALTER TABLE `stksettings001mb` ENABLE KEYS */;


--
-- Definition of table `stktransdeliver001mb`
--

DROP TABLE IF EXISTS `stktransdeliver001mb`;
CREATE TABLE `stktransdeliver001mb` (
  `stdelId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `status` varchar(40) NOT NULL,
  `grandTotal` varchar(30) NOT NULL,
  `delName` varchar(30) NOT NULL,
  PRIMARY KEY (`stdelId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stktransdeliver001mb`
--

/*!40000 ALTER TABLE `stktransdeliver001mb` DISABLE KEYS */;
INSERT INTO `stktransdeliver001mb` (`stdelId`,`title`,`status`,`grandTotal`,`delName`) VALUES 
 (1,'DustBin','Draft','12000','DN-0007'),
 (2,'Ceramics','Cancelled','10000','DNCN-009');
/*!40000 ALTER TABLE `stktransdeliver001mb` ENABLE KEYS */;


--
-- Definition of table `stktransentry001mb`
--

DROP TABLE IF EXISTS `stktransentry001mb`;
CREATE TABLE `stktransentry001mb` (
  `stentId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `status` varchar(40) NOT NULL,
  `purpose` varchar(50) NOT NULL,
  `stName` varchar(30) NOT NULL,
  PRIMARY KEY (`stentId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stktransentry001mb`
--

/*!40000 ALTER TABLE `stktransentry001mb` DISABLE KEYS */;
INSERT INTO `stktransentry001mb` (`stentId`,`title`,`status`,`purpose`,`stName`) VALUES 
 (1,'Materialissue','Draft','Material issue','STE-00019'),
 (2,'Replace','Submitted','Replace','STE-0098'),
 (4,'Material Transfer for Manufacture','Cancelled','Material Transfer for Manufacture','STE-0076'),
 (5,'Material Receipt','Submitted','Material Receipt','STE-00020');
/*!40000 ALTER TABLE `stktransentry001mb` ENABLE KEYS */;


--
-- Definition of table `stktranspurecpt001mb`
--

DROP TABLE IF EXISTS `stktranspurecpt001mb`;
CREATE TABLE `stktranspurecpt001mb` (
  `stpurtId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `status` varchar(40) NOT NULL,
  `grandTotal` varchar(40) NOT NULL,
  `purtName` varchar(40) NOT NULL,
  PRIMARY KEY (`stpurtId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stktranspurecpt001mb`
--

/*!40000 ALTER TABLE `stktranspurecpt001mb` DISABLE KEYS */;
INSERT INTO `stktranspurecpt001mb` (`stpurtId`,`title`,`status`,`grandTotal`,`purtName`) VALUES 
 (1,'Eagle hardware','To Bill','80000','PREC-00013'),
 (2,'Ks Merchandise','Completed','3000','PREC-0033');
/*!40000 ALTER TABLE `stktranspurecpt001mb` ENABLE KEYS */;


--
-- Definition of table `stockageing001mb`
--

DROP TABLE IF EXISTS `stockageing001mb`;
CREATE TABLE `stockageing001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemcode` varchar(30) NOT NULL,
  `itemname` varchar(30) NOT NULL,
  `description` varchar(30) NOT NULL,
  `itemgroup` varchar(30) NOT NULL,
  `brand` varchar(30) NOT NULL,
  `averageage` int(30) NOT NULL,
  `earliest` tinyint(1) NOT NULL,
  `latest` tinyint(1) NOT NULL,
  `uom` varchar(30) NOT NULL,
  `actual` int(11) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `ordered` int(11) DEFAULT NULL,
  `projected` int(11) DEFAULT NULL,
  `requested` int(11) DEFAULT NULL,
  `reserved` int(11) DEFAULT NULL,
  `warehouse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stockageing001mb`
--

/*!40000 ALTER TABLE `stockageing001mb` DISABLE KEYS */;
INSERT INTO `stockageing001mb` (`id`,`itemcode`,`itemname`,`description`,`itemgroup`,`brand`,`averageage`,`earliest`,`latest`,`uom`,`actual`,`item`,`ordered`,`projected`,`requested`,`reserved`,`warehouse`) VALUES 
 (1,'material','shaft','rawmaetrial','billing','good',5,1,0,'nos',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (2,'table','rawmaterial','rawmatrrialbilling','table','good',7,0,0,'numbersss',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `stockageing001mb` ENABLE KEYS */;


--
-- Definition of table `stockbalance001mb`
--

DROP TABLE IF EXISTS `stockbalance001mb`;
CREATE TABLE `stockbalance001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(30) NOT NULL,
  `itemname` varchar(30) NOT NULL,
  `itemgroup` varchar(30) NOT NULL,
  `brand` varchar(30) NOT NULL,
  `description` varchar(30) NOT NULL,
  `warehouse` varchar(30) NOT NULL,
  `stockuom` varchar(30) NOT NULL,
  `openingqty` decimal(3,1) NOT NULL,
  `openingvalue` decimal(3,1) NOT NULL,
  `inqty` decimal(3,1) NOT NULL,
  `invalue` decimal(3,1) NOT NULL,
  `outqty` decimal(3,1) NOT NULL,
  `outvalue` decimal(3,1) NOT NULL,
  `balqty` decimal(3,1) NOT NULL,
  `balvalue` decimal(3,1) NOT NULL,
  `validationrate` varchar(30) NOT NULL,
  `company` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stockbalance001mb`
--

/*!40000 ALTER TABLE `stockbalance001mb` DISABLE KEYS */;
INSERT INTO `stockbalance001mb` (`id`,`item`,`itemname`,`itemgroup`,`brand`,`description`,`warehouse`,`stockuom`,`openingqty`,`openingvalue`,`inqty`,`invalue`,`outqty`,`outvalue`,`balqty`,`balvalue`,`validationrate`,`company`) VALUES 
 (1,'shaft','blade','rawmaterial','nice','good materail','spl','nos','1.0','10.0','2.0','5.0','10.0','45.0','58.0','12.0','14','xyz');
/*!40000 ALTER TABLE `stockbalance001mb` ENABLE KEYS */;


--
-- Definition of table `stockentry001mb`
--

DROP TABLE IF EXISTS `stockentry001mb`;
CREATE TABLE `stockentry001mb` (
  `stockid` int(11) NOT NULL AUTO_INCREMENT,
  `materialrequest` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `TransferedQty` decimal(3,1) NOT NULL,
  `Qtytotransfer` decimal(3,1) NOT NULL,
  `description` varchar(30) NOT NULL,
  `company` varchar(40) NOT NULL,
  `itemid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`stockid`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stockentry001mb`
--

/*!40000 ALTER TABLE `stockentry001mb` DISABLE KEYS */;
INSERT INTO `stockentry001mb` (`stockid`,`materialrequest`,`date`,`Quantity`,`TransferedQty`,`Qtytotransfer`,`description`,`company`,`itemid`) VALUES 
 (1,'MRE-001','2015-02-06',88,'40.0','98.0','sportitems','LLC',1),
 (2,'MRE-002','2014-02-06',78,'50.0','68.0','sportitems','ABC',1),
 (9,'MRE-009','2015-02-09',0,'21.9','78.3','sports','sportscompany',1),
 (14,'MRE-006','2019-02-03',0,'0.0','0.0','metal','sportscompany',21),
 (15,'MRE-007','2019-02-03',45,'45.8','45.3','metal','sportscompany',2),
 (18,'MRE-0061','2019-02-03',23,'45.3','23.3','sports369','sportscompany369',22),
 (25,'MRE-0019','10/05/2016',36,'23.6','45.6','metal123','metalcompany123',22),
 (71,'MR_002','10/03/2016',78,'25.3','58.3','material','xyz',22);
/*!40000 ALTER TABLE `stockentry001mb` ENABLE KEYS */;


--
-- Definition of table `stockledger001mb`
--

DROP TABLE IF EXISTS `stockledger001mb`;
CREATE TABLE `stockledger001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(30) NOT NULL,
  `item` varchar(30) NOT NULL,
  `itemname` varchar(30) NOT NULL,
  `itemgroup` varchar(30) NOT NULL,
  `brand` varchar(30) NOT NULL,
  `description` varchar(30) NOT NULL,
  `warehouse` varchar(30) NOT NULL,
  `stockuom` varchar(30) NOT NULL,
  `qty` int(30) NOT NULL,
  `balanceqty` int(30) NOT NULL,
  `incomingrate` int(30) NOT NULL,
  `valuationrate` int(30) NOT NULL,
  `balancevalue` int(30) NOT NULL,
  `vouchertype` varchar(30) NOT NULL,
  `voucherno` int(30) NOT NULL,
  `batch` int(30) NOT NULL,
  `serialno` int(30) NOT NULL,
  `company` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stockledger001mb`
--

/*!40000 ALTER TABLE `stockledger001mb` DISABLE KEYS */;
INSERT INTO `stockledger001mb` (`id`,`date`,`item`,`itemname`,`itemgroup`,`brand`,`description`,`warehouse`,`stockuom`,`qty`,`balanceqty`,`incomingrate`,`valuationrate`,`balancevalue`,`vouchertype`,`voucherno`,`batch`,`serialno`,`company`) VALUES 
 (1,'20-08-1990','stock','shaft','rawmaterial','good','nice','spl','nos',10,12,25,45,85,'materialtype',10,2,5,'xyz');
/*!40000 ALTER TABLE `stockledger001mb` ENABLE KEYS */;


--
-- Definition of table `stockprojected001mb`
--

DROP TABLE IF EXISTS `stockprojected001mb`;
CREATE TABLE `stockprojected001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actualqty` int(11) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `itemcode` varchar(255) DEFAULT NULL,
  `itemgroup` varchar(255) DEFAULT NULL,
  `itemname` varchar(255) DEFAULT NULL,
  `orderedqty` int(11) DEFAULT NULL,
  `plannedqty` int(11) DEFAULT NULL,
  `projectedqty` int(11) DEFAULT NULL,
  `reorderlevel` int(11) DEFAULT NULL,
  `reorderqty` int(11) DEFAULT NULL,
  `requestedqty` int(11) DEFAULT NULL,
  `reservedqty` int(11) DEFAULT NULL,
  `shortageqty` int(11) DEFAULT NULL,
  `stockuom` varchar(255) DEFAULT NULL,
  `warehouse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stockprojected001mb`
--

/*!40000 ALTER TABLE `stockprojected001mb` DISABLE KEYS */;
/*!40000 ALTER TABLE `stockprojected001mb` ENABLE KEYS */;


--
-- Definition of table `supplier001mb`
--

DROP TABLE IF EXISTS `supplier001mb`;
CREATE TABLE `supplier001mb` (
  `supId` int(11) NOT NULL AUTO_INCREMENT,
  `supName` varchar(50) NOT NULL,
  `addType` varchar(50) NOT NULL,
  `supCity` varchar(50) NOT NULL,
  `supAddress` varchar(100) NOT NULL,
  `supPhone` varchar(50) NOT NULL,
  `supCountry` varchar(50) NOT NULL,
  `supState` varchar(50) NOT NULL,
  PRIMARY KEY (`supId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier001mb`
--

/*!40000 ALTER TABLE `supplier001mb` DISABLE KEYS */;
INSERT INTO `supplier001mb` (`supId`,`supName`,`addType`,`supCity`,`supAddress`,`supPhone`,`supCountry`,`supState`) VALUES 
 (1,'Asiatic Solution','Billing','Chennai','No:5,boss road,north chennai,wall taxi road','+91-8680924657','India','TamilNadu');
/*!40000 ALTER TABLE `supplier001mb` ENABLE KEYS */;


--
-- Definition of table `supptype001mb`
--

DROP TABLE IF EXISTS `supptype001mb`;
CREATE TABLE `supptype001mb` (
  `sutypeId` int(11) NOT NULL AUTO_INCREMENT,
  `supName` varchar(50) NOT NULL,
  `suType` varchar(50) NOT NULL,
  PRIMARY KEY (`sutypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supptype001mb`
--

/*!40000 ALTER TABLE `supptype001mb` DISABLE KEYS */;
INSERT INTO `supptype001mb` (`sutypeId`,`supName`,`suType`) VALUES 
 (1,'Asiatic Solution','Distributor'),
 (2,'Eagle hardware','Electrical');
/*!40000 ALTER TABLE `supptype001mb` ENABLE KEYS */;


--
-- Definition of table `supstatus001mb`
--

DROP TABLE IF EXISTS `supstatus001mb`;
CREATE TABLE `supstatus001mb` (
  `sustatusId` int(11) NOT NULL AUTO_INCREMENT,
  `supName` varchar(50) NOT NULL,
  `sustatus` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  PRIMARY KEY (`sustatusId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supstatus001mb`
--

/*!40000 ALTER TABLE `supstatus001mb` DISABLE KEYS */;
INSERT INTO `supstatus001mb` (`sustatusId`,`supName`,`sustatus`,`phone`) VALUES 
 (1,'Asiatic Solution','Enabled','95666789'),
 (2,'Asiatic Solution','Open','9790790208');
/*!40000 ALTER TABLE `supstatus001mb` ENABLE KEYS */;


--
-- Definition of table `swsanalytics001mb`
--

DROP TABLE IF EXISTS `swsanalytics001mb`;
CREATE TABLE `swsanalytics001mb` (
  `swsId` int(11) NOT NULL AUTO_INCREMENT,
  `itemCode` varchar(50) NOT NULL,
  `description` varchar(150) DEFAULT NULL,
  `swsUOM` varchar(20) NOT NULL,
  `consQty` varchar(20) NOT NULL,
  `consAmt` decimal(12,4) DEFAULT NULL,
  `delQty` varchar(20) NOT NULL,
  `delAmt` decimal(12,4) DEFAULT NULL,
  `totalQty` varchar(30) NOT NULL,
  `totalAmt` decimal(12,4) DEFAULT NULL,
  PRIMARY KEY (`swsId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `swsanalytics001mb`
--

/*!40000 ALTER TABLE `swsanalytics001mb` DISABLE KEYS */;
INSERT INTO `swsanalytics001mb` (`swsId`,`itemCode`,`description`,`swsUOM`,`consQty`,`consAmt`,`delQty`,`delAmt`,`totalQty`,`totalAmt`) VALUES 
 (1,'Table','Neat and Clean','Nos','12','10000.0000','10','8000.0000','10','8000.0000');
/*!40000 ALTER TABLE `swsanalytics001mb` ENABLE KEYS */;


--
-- Definition of table `task001mb`
--

DROP TABLE IF EXISTS `task001mb`;
CREATE TABLE `task001mb` (
  `taskid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `taskdescription` varchar(45) NOT NULL,
  `AssignTo` varchar(45) NOT NULL,
  `AssignBy` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `starton` varchar(45) NOT NULL,
  `endon` varchar(45) NOT NULL,
  `allday` tinyint(1) NOT NULL,
  `sendanemail` tinyint(1) NOT NULL,
  `repeatthisevent` tinyint(1) NOT NULL,
  PRIMARY KEY (`taskid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task001mb`
--

/*!40000 ALTER TABLE `task001mb` DISABLE KEYS */;
INSERT INTO `task001mb` (`taskid`,`taskdescription`,`AssignTo`,`AssignBy`,`status`,`starton`,`endon`,`allday`,`sendanemail`,`repeatthisevent`) VALUES 
 (27,'Bread Crump Creation','17','14','Assigned,','2016/11/03 17:22','2016/11/04 17:22',1,0,0);
/*!40000 ALTER TABLE `task001mb` ENABLE KEYS */;


--
-- Definition of table `taxrule001mb`
--

DROP TABLE IF EXISTS `taxrule001mb`;
CREATE TABLE `taxrule001mb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `billingcity` varchar(255) DEFAULT NULL,
  `billingcountry` varchar(255) DEFAULT NULL,
  `billingstate` varchar(255) DEFAULT NULL,
  `customer` varchar(255) DEFAULT NULL,
  `fromdate` varchar(255) DEFAULT NULL,
  `shippingcity` varchar(255) DEFAULT NULL,
  `shippingcountry` varchar(255) DEFAULT NULL,
  `shippingstate` varchar(255) DEFAULT NULL,
  `taxtemplate` varchar(255) DEFAULT NULL,
  `taxtype` varchar(255) DEFAULT NULL,
  `todate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `taxrule001mb`
--

/*!40000 ALTER TABLE `taxrule001mb` DISABLE KEYS */;
INSERT INTO `taxrule001mb` (`id`,`billingcity`,`billingcountry`,`billingstate`,`customer`,`fromdate`,`shippingcity`,`shippingcountry`,`shippingstate`,`taxtemplate`,`taxtype`,`todate`) VALUES 
 (1,'chennai','india',NULL,'Mithra','10/12/2016','chenai','india','tn','tax','sales','10/28/2016');
/*!40000 ALTER TABLE `taxrule001mb` ENABLE KEYS */;


--
-- Definition of table `territory001mb`
--

DROP TABLE IF EXISTS `territory001mb`;
CREATE TABLE `territory001mb` (
  `terId` int(11) NOT NULL AUTO_INCREMENT,
  `terName` varchar(50) NOT NULL,
  PRIMARY KEY (`terId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `territory001mb`
--

/*!40000 ALTER TABLE `territory001mb` DISABLE KEYS */;
INSERT INTO `territory001mb` (`terId`,`terName`) VALUES 
 (1,'Rest of the World'),
 (2,'United States');
/*!40000 ALTER TABLE `territory001mb` ENABLE KEYS */;


--
-- Definition of table `testcase001mb`
--

DROP TABLE IF EXISTS `testcase001mb`;
CREATE TABLE `testcase001mb` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ASSIGNTO` varchar(255) NOT NULL,
  `AUTOMATED` varchar(255) NOT NULL,
  `DATEUPDATED` datetime NOT NULL,
  `EXECTYPE` varchar(255) NOT NULL,
  `FOLDERNAME` varchar(255) NOT NULL,
  `LSTRNBY` varchar(255) NOT NULL,
  `LSTRNDATE` datetime NOT NULL,
  `LSTRNRELEASE` varchar(255) NOT NULL,
  `LSTRNSTATUS` varchar(255) NOT NULL,
  `LSTRNTESTSET` varchar(255) NOT NULL,
  `ORIGINALID` varchar(255) NOT NULL,
  `OWNER` varchar(255) NOT NULL,
  `PRIORITY` varchar(255) DEFAULT NULL,
  `REVIEWED` varchar(255) NOT NULL,
  `RNBYHOST` varchar(255) NOT NULL,
  `RUNTIME` varchar(255) NOT NULL,
  `STATUS` varchar(255) NOT NULL,
  `TESTTYPE` varchar(255) NOT NULL,
  `TITLE` varchar(255) NOT NULL,
  `VERSION` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `testcase001mb`
--

/*!40000 ALTER TABLE `testcase001mb` DISABLE KEYS */;
/*!40000 ALTER TABLE `testcase001mb` ENABLE KEYS */;


--
-- Definition of table `treenode001mb`
--

DROP TABLE IF EXISTS `treenode001mb`;
CREATE TABLE `treenode001mb` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ISPARENT` varchar(255) NOT NULL,
  `PID` varchar(255) NOT NULL,
  `PARENTNAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `treenode001mb`
--

/*!40000 ALTER TABLE `treenode001mb` DISABLE KEYS */;
/*!40000 ALTER TABLE `treenode001mb` ENABLE KEYS */;


--
-- Definition of table `trialbalance001mb`
--

DROP TABLE IF EXISTS `trialbalance001mb`;
CREATE TABLE `trialbalance001mb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(45) NOT NULL,
  `openingcr` int(10) unsigned NOT NULL,
  `openingdr` int(10) unsigned NOT NULL,
  `closingcr` int(10) unsigned NOT NULL,
  `closingdr` int(10) unsigned NOT NULL,
  `credit` int(10) unsigned NOT NULL,
  `debit` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trialbalance001mb`
--

/*!40000 ALTER TABLE `trialbalance001mb` DISABLE KEYS */;
INSERT INTO `trialbalance001mb` (`id`,`account`,`openingcr`,`openingdr`,`closingcr`,`closingdr`,`credit`,`debit`) VALUES 
 (1,'account',11,11,11,11,11,11);
/*!40000 ALTER TABLE `trialbalance001mb` ENABLE KEYS */;


--
-- Definition of table `unitofmeasure001mb`
--

DROP TABLE IF EXISTS `unitofmeasure001mb`;
CREATE TABLE `unitofmeasure001mb` (
  `unitId` int(11) NOT NULL AUTO_INCREMENT,
  `unitName` varchar(40) NOT NULL,
  PRIMARY KEY (`unitId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `unitofmeasure001mb`
--

/*!40000 ALTER TABLE `unitofmeasure001mb` DISABLE KEYS */;
INSERT INTO `unitofmeasure001mb` (`unitId`,`unitName`) VALUES 
 (1,'Minute'),
 (2,'Hour'),
 (3,'Set'),
 (5,'Nos'),
 (6,'Gram'),
 (7,'Kg'),
 (8,'Meter');
/*!40000 ALTER TABLE `unitofmeasure001mb` ENABLE KEYS */;


--
-- Definition of table `updatebank001mb`
--

DROP TABLE IF EXISTS `updatebank001mb`;
CREATE TABLE `updatebank001mb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bankaccount` varchar(45) NOT NULL,
  `fromdate` varchar(45) NOT NULL,
  `todate` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `updatebank001mb`
--

/*!40000 ALTER TABLE `updatebank001mb` DISABLE KEYS */;
INSERT INTO `updatebank001mb` (`id`,`bankaccount`,`fromdate`,`todate`) VALUES 
 (2,'bank','10/10/2016','10/05/2016');
/*!40000 ALTER TABLE `updatebank001mb` ENABLE KEYS */;


--
-- Definition of table `user001mb`
--

DROP TABLE IF EXISTS `user001mb`;
CREATE TABLE `user001mb` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `userroleid` int(11) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `zipcode` int(11) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `confirmemail` varchar(30) NOT NULL,
  `sex` tinyint(4) NOT NULL,
  `address1` varchar(50) NOT NULL,
  `address2` varchar(50) NOT NULL,
  `address3` varchar(50) NOT NULL,
  `city` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `mobile` int(10) NOT NULL,
  `landline` int(11) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user001mb`
--

/*!40000 ALTER TABLE `user001mb` DISABLE KEYS */;
/*!40000 ALTER TABLE `user001mb` ENABLE KEYS */;


--
-- Definition of table `userrole001mb`
--

DROP TABLE IF EXISTS `userrole001mb`;
CREATE TABLE `userrole001mb` (
  `userroleid` int(11) NOT NULL AUTO_INCREMENT,
  `loginid` int(11) NOT NULL,
  `role` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`userroleid`),
  KEY `fk_login_idx` (`loginid`),
  CONSTRAINT `fk_loginid` FOREIGN KEY (`loginid`) REFERENCES `login001mb` (`loginid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userrole001mb`
--

/*!40000 ALTER TABLE `userrole001mb` DISABLE KEYS */;
INSERT INTO `userrole001mb` (`userroleid`,`loginid`,`role`,`username`) VALUES 
 (1,6,'ROLE_ADMIN','siva'),
 (33,7,'ROLE_ADMIN','kannan'),
 (34,8,'ROLE_USER','karya'),
 (36,43,'ROLE_USER','girija'),
 (38,45,'ROLE_USER','iswarya');
/*!40000 ALTER TABLE `userrole001mb` ENABLE KEYS */;


--
-- Definition of table `warehouse001mb`
--

DROP TABLE IF EXISTS `warehouse001mb`;
CREATE TABLE `warehouse001mb` (
  `whId` int(11) NOT NULL AUTO_INCREMENT,
  `warehouseName` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `isActive` varchar(20) NOT NULL,
  `warehouseCode` varchar(60) NOT NULL,
  PRIMARY KEY (`whId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `warehouse001mb`
--

/*!40000 ALTER TABLE `warehouse001mb` DISABLE KEYS */;
INSERT INTO `warehouse001mb` (`whId`,`warehouseName`,`status`,`isActive`,`warehouseCode`) VALUES 
 (1,'SPL','Enabled','Yes','WC-SPL'),
 (2,'SSPDL','Disabled','No','WC-SSPDL');
/*!40000 ALTER TABLE `warehouse001mb` ENABLE KEYS */;


--
-- Definition of table `workstation001mb`
--

DROP TABLE IF EXISTS `workstation001mb`;
CREATE TABLE `workstation001mb` (
  `workstId` int(11) NOT NULL AUTO_INCREMENT,
  `workstName` varchar(40) NOT NULL,
  PRIMARY KEY (`workstId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `workstation001mb`
--

/*!40000 ALTER TABLE `workstation001mb` DISABLE KEYS */;
INSERT INTO `workstation001mb` (`workstId`,`workstName`) VALUES 
 (1,'Assembly Station_1'),
 (2,'Assembly Station_2'),
 (3,'Drilling Machine_1'),
 (5,'Packing and Testing Station'),
 (6,'Lathe'),
 (7,'Drilling Machine_1=2'),
 (8,'Drilling Machine_5'),
 (9,'Drilling Machine_7'),
 (10,'Drilling Machine_6'),
 (11,'Drilling Machine_2'),
 (12,'Drilling Machine_8'),
 (13,'Drilling Machine_9');
/*!40000 ALTER TABLE `workstation001mb` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
