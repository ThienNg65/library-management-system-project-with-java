-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema library_management
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema library_management
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `library_management` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `library_management` ;

-- -----------------------------------------------------
-- Table `library_management`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_management`.`book` (
  `book_BookID` INT NOT NULL,
  `book_Title` VARCHAR(45) NOT NULL,
  `book_PublisherName` VARCHAR(45) NOT NULL,
  `book_AuthorName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`book_BookID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `library_management`.`library_branch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_management`.`library_branch` (
  `library_branch_BranchID` INT NOT NULL,
  `library_branch_BranchName` VARCHAR(45) NOT NULL,
  `library_branch_BranchAddress` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`library_branch_BranchID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `library_management`.`book_copies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_management`.`book_copies` (
  `book_copies_CopiesID` INT NOT NULL,
  `book_copies_BookID` INT NOT NULL,
  `book_copies_BranchID` INT NOT NULL,
  `book_copies_No_Of_Copies` INT NOT NULL,
  PRIMARY KEY (`book_copies_CopiesID`),
  INDEX `book_copies_BookID_idx` (`book_copies_BookID` ASC) VISIBLE,
  INDEX `book_copies_BranchID_idx` (`book_copies_BranchID` ASC) VISIBLE,
  CONSTRAINT `book_copies_BookID`
    FOREIGN KEY (`book_copies_BookID`)
    REFERENCES `library_management`.`book` (`book_BookID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `book_copies_BranchID`
    FOREIGN KEY (`book_copies_BranchID`)
    REFERENCES `library_management`.`library_branch` (`library_branch_BranchID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `library_management`.`borrower`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_management`.`borrower` (
  `borrower_CardNo` INT NOT NULL,
  `borrower_BorrowerName` VARCHAR(45) NOT NULL,
  `borrower_BorrowerAddress` VARCHAR(255) NOT NULL,
  `borrower_BorrowerPhone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`borrower_CardNo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `library_management`.`book_loans`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_management`.`book_loans` (
  `book_loans_LoansID` INT NOT NULL,
  `book_loans_BookID` INT NOT NULL,
  `book_loans_BranchID` INT NOT NULL,
  `book_loans_CardNo` INT NOT NULL,
  `book_loans_DateOut` VARCHAR(45) NOT NULL,
  `book_loans_DueDate` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`book_loans_LoansID`),
  INDEX `book_loans_BookID` (`book_loans_BookID` ASC) VISIBLE,
  INDEX `book_loans_BranchID` (`book_loans_BranchID` ASC) VISIBLE,
  INDEX `book_loans_CardNo` (`book_loans_CardNo` ASC) VISIBLE,
  CONSTRAINT `book_loans_BookID`
    FOREIGN KEY (`book_loans_BookID`)
    REFERENCES `library_management`.`book` (`book_BookID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `book_loans_BranchID`
    FOREIGN KEY (`book_loans_BranchID`)
    REFERENCES `library_management`.`library_branch` (`library_branch_BranchID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `book_loans_CardNo`
    FOREIGN KEY (`book_loans_CardNo`)
    REFERENCES `library_management`.`borrower` (`borrower_CardNo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `library_management`.`book_log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_management`.`book_log` (
  `book_id` INT NULL DEFAULT NULL,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  `publisher` VARCHAR(45) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `library_management` ;

-- -----------------------------------------------------
-- INSERT VALUES INTO TABLES
-- -----------------------------------------------------


INSERT INTO book
VALUES 
	(1, 'Chainsaw Man', 'NXB Trẻ', 'Fujimoto Tatsuki'),
	(2, 'One Piece', 'NXB Kim Đồng', 'Oda Eiichiro'),
	(3, 'Dragon Ball', 'NXB Kim Đồng', 'Toriyama Akira'),
	(4, 'Dune - Xứ Cát', 'Nhã Nam', ' Frank Herbert'),
	(5, 'Cô gái trong sương mù', 'NXB Phụ nữ Việt Nam', 'Donato Carrisi'),
	(6, 'Luật Kế Toán', 'NXB CT quốc gia Sự thật', 'Quốc Hội');

SELECT * FROM book WHERE book_PublisherName = 'NXB Kim Đồng';

INSERT INTO library_branch
VALUES
	(1, 'Ninh Kiều LiB','6 Mậu Thân, Ninh Kiều, Cần Thơ'),
	(2, 'Cái Răng LiB','15 Lê Bình, Cái Răng, Cần Thơ'),
	(3, 'Bình Thủy LiB','40 Đặng Văn Dầy, Bình Thủy, Cần Thơ');

SELECT * FROM library_branch;

INSERT INTO borrower
	(borrower_CardNo, borrower_BorrowerName, borrower_BorrowerAddress, borrower_BorrowerPhone)
VALUES
	('58439','Trần Khánh Thuận','163 Phố Khâu Đoan Trụ, Xã Đoan, Huyện An Dương, Hải Phòng','0846747526'),
	('15667','Chí Đồng Hạ','3344 Phố Bì Lam Đại, Phường Hưng Lợi, Quận Ninh Kiều, Cần Thơ','0834141532'),
	('81407','Ngô Bình Đào','2 Phố Chu, Xã Thạc Nhung, Huyện Thuỷ Nguyên, Hải Phòng','08512956430'),
	('72006','Nguyễn Lê Duyên Ái','7 Phố Mai, Phường Trần Phú, Quận Sơn Hà, Quảng Ngãi','0835278974'),
	('51424','Đoàn Thương Minh','030 Phố Điệp, Phường Sử Hoa Quân, Huyện Gia Bình, Bắc Ninh','0856328466');
	
SELECT * FROM borrower;

INSERT INTO book_loans
	(book_loans_LoansID,book_loans_BookID, book_loans_BranchID, book_loans_CardNo, book_loans_DateOut, book_loans_DueDate)
VALUES
	('1','1','1','81407','5/4/20','12/4/20'),
	('2','2','3','15667','10/5/20','24/5/20'),
	('3','3','2','58439','1/6/20','1/7/20'),
	('4','4','2','58439','1/1/20','1/3/20'),
	('5','5','1','51424','5/12/20','24/1/21');

SELECT * FROM book_loans;

INSERT INTO book_copies
	(book_copies_CopiesID, book_copies_BookID, book_copies_BranchID, book_copies_No_Of_Copies)
VALUES
	('1','1','1','5'),
	('2','1','2','3'),
	('3','1','3','2'),
	('4','2','1','0'),
	('5','2','2','2'),
	('6','2','3','5'),
	('7','3','1','2'),
	('8','3','2','2'),
	('9','3','3','2'),
	('10','4','1','0'),
	('11','4','2','0'),
	('12','4','3','1'),
	('13','5','1','5'),
	('14','5','2','5'),
	('15','5','3','5');

SELECT * FROM book_copies;


-- -----------------------------------------------------
-- procedure DeleteBook
-- -----------------------------------------------------

DELIMITER $$
USE `library_management`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteBook`(
  in sp_BookID   INT
)
BEGIN
    DELETE FROM book
	WHERE book_BookID = sp_BookID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure UpdateBookList
-- -----------------------------------------------------

DELIMITER $$
USE `library_management`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateBookList`(
    IN  sp_BookID   INT,
    IN  sp_Title   VARCHAR(255), 
    IN  sp_PublisherName   VARCHAR(255)
)
BEGIN
    IF sp_BookID = 0 
    THEN INSERT INTO book(book_BookID, book_Title, book_PublisherName) 
         VALUES (sp_BookID, sp_Title, sp_PublisherName);
    ELSE UPDATE book 
         SET book_BookID = sp_BookID, 
             book_Title = sp_Title, 
             book_PublisherName = sp_PublisherName
         WHERE book.book_BookID = sp_BookID;
    END IF;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- function get_book
-- -----------------------------------------------------

DELIMITER $$
USE `library_management`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `get_book`(bookid int) RETURNS varchar(255) CHARSET utf8mb4
    DETERMINISTIC
BEGIN    
	declare title, publisher, output varchar(255);
    select book_Title into title from book where book_BookID = bookid;
    -- select book_PublisherName into publisher from book where book_BookID = bookid;
    -- set @output := 'title: ' or title or ' publisher: ' or publisher;

    return title;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_full_book_infor
-- -----------------------------------------------------

DELIMITER $$
USE `library_management`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_full_book_infor`()
begin
select b.*, lb.library_branch_BranchName, cp.book_copies_No_Of_Copies
from 
	book b,
    book_copies cp,
    library_branch lb
where 
	b.book_BookID = cp.book_copies_BookID and
	cp.book_copies_BranchID = lb.library_branch_BranchID;
end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_full_borrower_infor
-- -----------------------------------------------------

DELIMITER $$
USE `library_management`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_full_borrower_infor`()
begin
select s1.*, s3.book_Title
from 
	borrower s1,
    book_loans s2,
    book s3
where 
	s1.borrower_CardNo = s2.book_loans_CardNo and
    s2.book_loans_BookID = s3.book_BookID;
end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insert_full_Book
-- -----------------------------------------------------

DELIMITER $$
USE `library_management`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_full_Book`(
	in b_BookID int,
    in b_Title varchar(255),
    in b_Publisher varchar(255),
	in b_Author varchar(255),
    -- in lb_BranchID int,
    -- in lb_BranchName varchar(255),
    in cp_CopiesID int,
    -- in cp_BookID int,
    in cp_BranchID int,
    in cp_NoCopies int
)
begin
	insert into book(book_BookID, book_Title, book_PublisherName, book_AuthorName) 
		values (b_BookID, b_Title, b_Publisher,b_Author);
	
    insert into book_copies(book_copies_CopiesID, book_copies_BookID, book_copies_BranchID, book_copies_No_Of_Copies) 
		values (cp_CopiesID, b_BookID, cp_BranchID, cp_NoCopies);
        -- set book_copies_BookID = b_BookID;
end$$

DELIMITER ;
USE `library_management`;

DELIMITER $$
USE `library_management`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `library_management`.`ins_book`
AFTER INSERT ON `library_management`.`book`
FOR EACH ROW
BEGIN
   INSERT INTO book_log
      VALUES (new.book_BookID, new.book_Title, new.book_PublisherName);
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

/*
-- test procedure for my code, you can run it to test the code on "library_getStoredProcedure"
-- STORED PROCEDURE to insert a book
DELIMITER //
CREATE PROCEDURE InsertBook
(
	IN  sp_BookID   INT,
    IN  sp_Title   VARCHAR(255), 
    IN  sp_PublisherName   VARCHAR(255),
    in sp_authorName 	VARCHAR(255)
) 
BEGIN
    INSERT INTO book(book_BookID, book_Title, book_PublisherName, book_AuthorName) 
		VALUES (sp_BookID, sp_Title, sp_PublisherName, sp_authorName);
END //
DELIMITER ;
*/