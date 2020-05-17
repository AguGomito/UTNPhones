drop DATABASE utnphones;
create database utnphones;
USE utnphones;


CREATE TABLE IF NOT EXISTS Provinces (
    province_id int AUTO_INCREMENT,
    name varchar (250),
    CONSTRAINT pk_provinces PRIMARY KEY (province_id));

CREATE TABLE IF NOT EXISTS Cities (
    city_id int AUTO_INCREMENT,
    city_name varchar(250),
    province_id int,
    prefix varchar(10),
    CONSTRAINT pk_cities PRIMARY KEY (city_id),
    CONSTRAINT fk_provinces FOREIGN KEY (province_id) REFERENCES Provinces (province_id));

CREATE TABLE IF NOT EXISTS Users( 
username varchar(50),
password varchar(50),
name varchar(250),
lastname varchar(250),
user_type int, /*1 cliente 2 empleado*/
is_active int,
dni varchar(10),
user_id int auto_increment,
city_id int,
province_id int,
CONSTRAINT pk_users PRIMARY KEY (user_id),
CONSTRAINT fk_Usrcities FOREIGN KEY (city_id) REFERENCES Cities (city_id),
CONSTRAINT fk_Usrprovinces FOREIGN KEY (province_id) REFERENCES Provinces (province_id));

CREATE TABLE IF NOT EXISTS PhoneLines(line_id int auto_increment,
phone_number varchar(50),
line_type int, /*1 movil 2 residencial*/
state BOOLEAN,
user_id int,
CONSTRAINT pk_PhoneLines PRIMARY KEY (line_id),
CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES Users (user_id));

CREATE TABLE IF NOT EXISTS Rates(rate_id int AUTO_INCREMENT,
issuer_city_id int,
receiver_city_id int,
cost_minute float,
CONSTRAINT pk_rates PRIMARY KEY (rate_id),
CONSTRAINT fk_citiesIss FOREIGN KEY (issuer_city_id) REFERENCES Cities (city_id),
CONSTRAINT fk_citiesRec FOREIGN KEY (receiver_city_id) REFERENCES Cities (city_id));

CREATE TABLE IF NOT EXISTS Invoices(invoice_id int AUTO_INCREMENT,
line_id int,
invoice_total float,
price_cost float,
price_total float,
nmbr_of_calls int,
issuing_date TIMESTAMP,
due_date date,
CONSTRAINT pk_invoices PRIMARY KEY (invoice_id),
CONSTRAINT fk_phoneLines FOREIGN KEY (line_id) REFERENCES PhoneLines(line_id));


CREATE TABLE IF NOT EXISTS Calls(call_id int AUTO_INCREMENT,
phone_issuer_id int,
phone_receiver_id int,
rate_id int,
call_price float,
duration float,
date timestamp,
invoice_id int,
CONSTRAINT pk_calls PRIMARY KEY (call_id),
CONSTRAINT fk_phoneLinesIss FOREIGN KEY (phone_issuer_id) REFERENCES PhoneLines (user_id),
CONSTRAINT fk_phoneLinesRec FOREIGN KEY (phone_receiver_id) REFERENCES PhoneLines (user_id),
CONSTRAINT fk_rate FOREIGN KEY (rate_id) REFERENCES Rates (rate_id),
CONSTRAINT fk_invoices FOREIGN KEY (invoice_id) REFERENCES Invoices (invoice_id));


--INSERT
INSERT INTO provinces VALUES (1, "Buenos Aires");
INSERT INTO provinces VALUES (2, "Entre Rios");
INSERT INTO provinces VALUES (3, "Santa Fe");
INSERT INTO provinces VALUES (4, "Cordoba");
INSERT INTO provinces VALUES (5, "La Pampa");
INSERT INTO provinces VALUES (6, "Rio Negro");

INSERT INTO cities VALUES (1, "Mar del Plata", 1, "0223");







