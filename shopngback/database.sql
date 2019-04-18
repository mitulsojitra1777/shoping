// create category table




create table category(
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	imageurl VARCHAR(50),
	active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY(id)
	

);

--CREATE TABLE user_detail (
-- 	id IDENTITY,
-- 	first_name VARCHAR(50),
-- 	last_name VARCHAR(50),
-- 	type VARCHAR(20),
-- 	is_active BOOLEAN,
-- 	mobile int,
-- 	email VARCHAR(100),
-- 	password varchar(50),
--	CONSTRAINT pk_user_detail_id PRIMARY KEY(id)	
--);

CREATE TABLE user_detail (
 	id IDENTITY,
 	first_name VARCHAR(50),
 	last_name VARCHAR(50),
 	role VARCHAR(20),
 	enabled BOOLEAN,
 	contact_number VARCHAR(20),
 	email VARCHAR(100),
 	password varchar(50),
	CONSTRAINT pk_user_detail_id PRIMARY KEY(id)	
);


//create product table
CREATE TABLE product (
 	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50)
	descreption VARCHAR(255),
	unit_price double,
	quntity INTEGER,
	is_active BOOLEAN,
	category_id INT,
	suplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY(id),
	
);
alter table product add column unit_price decimal ( 10 , 2 ) after quntity ;

ALTER TABLE PRODUCT ADD CONSTRAINT pk_product_suplier_id FOREIGN KEY ( SUPLIER_ID ) REFERENCES USER_DETAIL ( ID ) ;

ALTER TABLE PRODUCT ADD CONSTRAINT fk_product_category_id FOREIGN  KEY ( CATEGORY_ID ) REFERENCES CATEGORY ( ID )



