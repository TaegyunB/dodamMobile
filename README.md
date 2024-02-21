# Dodam Application Explaination
Dodam is a mobile application of for multicultural families. It helps to record and manage mom's health information. Also, mom and dad can prepare for the baby with an albu where they can store the memories during the pregnancy weeks. Moreover, mom can also share these contents with dad. Lastly, they can check helpful information and benefits for multicultural families provided by their country.

# Featues
To create Dodam service, we have used SpringBoot for the server and MySQL Workbench for the database. We have made mother's notebook, album, diary, provision of health and welfare policy information.

# How to Run
Receive the code through the clone and open the project through an IDE like Eclipse. Our Java version was 17, SpringBoot was 3.2.2 and necessary libraries was downloaded through Maven.

For the Database, we have made dodam schema by the username dodam@localhost.

# Code for the Database
```
DROP DATABASE IF EXISTS  dodam;
DROP user IF EXISTS  dodam@localhost;
create user dodam@localhost identified WITH mysql_native_password  by 'dodam';
create database dodam;
grant all privileges on dodam.* to dodam@localhost with grant option;
commit;

CREATE SCHEMA IF NOT EXISTS dodam;

USE dodam;

DROP TABLE IF EXISTS dodam.user;
DROP TABLE IF EXISTS dodam.connection;
DROP TABLE IF EXISTS dodam.babyInfo;
DROP TABLE IF EXISTS dodam.todo;
DROP TABLE IF EXISTS dodam.diary;

-- User --
CREATE TABLE IF NOT EXISTS user (
    userid VARCHAR(50) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    phoneNumber VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    gender ENUM('M', 'F') NOT NULL,
    password VARCHAR(100) NOT NULL,
    connection_id VARCHAR(50)
);

-- Connection --
CREATE TABLE IF NOT EXISTS connection (
    user1_id VARCHAR(50),
    user2_id VARCHAR(50),
    connection_id VARCHAR(50) UNIQUE PRIMARY KEY
-- 	CONSTRAINT fk_user_connection_id
--     FOREIGN KEY (connection_id) REFERENCES user(connection_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
);

DELIMITER $$
CREATE TRIGGER sync_connection_id1
AFTER INSERT ON connection
FOR EACH row
BEGIN
	update user set connection_id = new.connection_id where userid = new.user1_id;
END$$

DELIMITER $$
CREATE TRIGGER sync_connection_id2
AFTER INSERT ON connection
FOR EACH row
BEGIN
	update user set connection_id = new.connection_id where userid = new.user2_id;
END$$

-- DELIMITER $$
-- CREATE TRIGGER sync_user1id_user2id_connect
-- AFTER INSERT ON connection
-- FOR EACH row
-- BEGIN
-- 	insert into connection values(user1_id = new.user2_id, user2_id = new.user1_id, connection_id = new.connection_id);
-- END $$

-- Baby Info --
CREATE TABLE IF NOT EXISTS babyInfo (
	connection_id VARCHAR(50),
    babyid INT,
    babyName VARCHAR(50),
    babyGender VARCHAR(10),
    dueDate DATE,
    PRIMARY KEY(babyid),
    INDEX fk_baby_connection_id_idx (connection_id ASC),
    CONSTRAINT fk_baby_connection_id
    FOREIGN KEY (connection_id) REFERENCES connection(connection_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Todo --
CREATE TABLE IF NOT EXISTS todo (
	connection_id VARCHAR(50),
    todoid INT AUTO_INCREMENT,
    title VARCHAR(100),
    content VARCHAR(500),
    closingDate DATE,
    PRIMARY KEY(todoid),
    INDEX fk_todo_connection_id_idx (connection_id ASC),
    FOREIGN KEY (connection_id) REFERENCES connection(connection_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Diary -- 
CREATE TABLE IF NOT EXISTS diary (
	userid VARCHAR(50),
    diaryid INT AUTO_INCREMENT,
    title VARCHAR(100),
    content VARCHAR(5000),
    writtenDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(diaryid),
    INDEX fk_diary_userid_idx (userid ASC),
    FOREIGN KEY (userid) REFERENCES user(userid)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Examination History --
CREATE TABLE IF NOT EXISTS examinationHistory (
	connection_id VARCHAR(50),
    examinationid INT AUTO_INCREMENT,
    examinationDate DATE,
    pregnacyWeek INT,
    weight DOUBLE,
    bloodPressure DOUBLE,
    urinalysis VARCHAR(500),
    embryocadia DOUBLE,
    requirement VARCHAR(500),
    nextVisitDate DATE,
    PRIMARY KEY(examinationid),
    INDEX fk_examinationHistory_connection_id_idx (connection_id ASC),
    FOREIGN KEY (connection_id) REFERENCES connection(connection_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE[Uploading dodam sql문.rtf…]()

);
```

# Technologies Used
SpringBoot <br/>
MySQL <br /> 
MyBatis

# Developer Information
Hyeongcheol Shin / hcshin00717@gmail.com / ShinHyeongcheol <br />
Taegyun Baek / taegyunb99@gmail.com / taegyunb <br />
Wonjeong Park / josephwjp8@gmail.com / ParkWonjeong <br />
Minwoo Kim / whitetors@gmail.com / whitetor
