--drop DATABASE utnphones;
--create database utnphones;
--USE utnphones;

--DROP TABLE Provinces;
CREATE TABLE IF NOT EXISTS Provinces (
    province_id int AUTO_INCREMENT,
    name varchar (250) not null unique,
    CONSTRAINT pk_provinces PRIMARY KEY (province_id)
);

--DROP TABLE cities;
CREATE TABLE IF NOT EXISTS Cities (
    city_id int AUTO_INCREMENT,
    city_name varchar(250) not null unique,
    province_id int not null,
    prefix varchar(10) not null unique,
    CONSTRAINT pk_cities PRIMARY KEY (city_id),
    CONSTRAINT fk_provinces FOREIGN KEY (province_id) REFERENCES Provinces (province_id)
);

DROP TABLE users;
CREATE TABLE IF NOT EXISTS Users (
    user_id int auto_increment,
    username varchar(50) not null unique,
    password varchar(50) not null,
    name varchar(250) not null,
    lastname varchar(250) not null,
    user_type int not null, /*1 cliente 2 empleado*/
    is_active int default 1,
    dni varchar(10) not null unique,
    city_id int not null,
    CONSTRAINT pk_users PRIMARY KEY (user_id),
    CONSTRAINT fk_Usrcities FOREIGN KEY (city_id) REFERENCES Cities (city_id)
);


DROP TABLE phonelines;
CREATE TABLE IF NOT EXISTS PhoneLines (
    line_id int auto_increment,
    phone_number varchar(50) not null,
    line_type int default 1, /*1 movil 2 residencial*/
    state INT default 1,
    user_id int not null,
    CONSTRAINT pk_PhoneLines PRIMARY KEY (line_id),
    CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES Users (user_id)
);


DROP TABLE rates;
CREATE TABLE IF NOT EXISTS Rates (
    rate_id int AUTO_INCREMENT,
    issuer_city_id int not null,
    receiver_city_id int not null,
    cost_minute float not null,
    CONSTRAINT pk_rates PRIMARY KEY (rate_id),
    CONSTRAINT fk_citiesIss FOREIGN KEY (issuer_city_id) REFERENCES Cities (city_id),
    CONSTRAINT fk_citiesRec FOREIGN KEY (receiver_city_id) REFERENCES Cities (city_id)
);


DROP TABLE invoices;
CREATE TABLE IF NOT EXISTS Invoices (
    invoice_id int AUTO_INCREMENT,
    line_id int not null,
    invoice_total float not null,
    price_cost float not null,
    price_total float not null,
    nmbr_of_calls int not null,
    issuing_date TIMESTAMP not null,
    due_date date not null,
    CONSTRAINT pk_invoices PRIMARY KEY (invoice_id),
    CONSTRAINT fk_phoneLines FOREIGN KEY (line_id) REFERENCES PhoneLines(line_id)
);

DROP TABLE calls;
CREATE TABLE IF NOT EXISTS Calls(
    call_id int AUTO_INCREMENT,
    phone_issuer_id int not null,
    phone_receiver_id int not null,
    rate_id int not null,
    call_price float not null,
    duration float not null,
    date timestamp not null,
    invoice_id int not null,
    CONSTRAINT pk_calls PRIMARY KEY (call_id),
    CONSTRAINT fk_phoneLinesIss FOREIGN KEY (phone_issuer_id) REFERENCES PhoneLines (user_id),
    CONSTRAINT fk_phoneLinesRec FOREIGN KEY (phone_receiver_id) REFERENCES PhoneLines (user_id),
    CONSTRAINT fk_rate FOREIGN KEY (rate_id) REFERENCES Rates (rate_id),
    CONSTRAINT fk_invoices FOREIGN KEY (invoice_id) REFERENCES Invoices (invoice_id)
);


--SQL TO EXECUTE FAST




