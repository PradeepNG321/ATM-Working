create database if not exist bankmanagementsystem;


 use bankmanagementsystem;

 create table signup(formno varchar(20),
	name varchar(50), fname varchar(50), dob varchar(20), 
	gender varchar(20), email varchar(50), 
	marital varchar(20), address varchar(50), 
	city varchar(30), state varchar(30),pin varchar(20));

create table signuptwo(formno varchar(20),
	Religion varchar(20), Category varchar(50), 
	Income varchar(20), Education varchar(50), 
	occupation varchar(20), PAN_No varchar(50), 
	Aadhar_No varchar(30), Senior_Citizen varchar(30),
	Exitance_account varchar(20));

 create table signupthree(Form_No varchar(20),
	Account_Type varchar(40), Card_No varchar(20), 
	Pin varchar(10), Facility varchar(40));

 create table login(Form_No varchar(10), Card_No varchar(30), 
	Pin varchar(10));

create table bank(pin varchar(10), date varchar(30), type varchar(20), amount varchar(20));
