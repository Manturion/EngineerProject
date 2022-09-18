-- tables
DROP TABLE IF EXISTS Report;
DROP TABLE IF EXISTS Offer_Customer;
DROP TABLE IF EXISTS shop_offers;
DROP TABLE IF EXISTS Offer;
DROP TABLE IF EXISTS Banned_Customer;
DROP TABLE IF EXISTS Customer_Shop;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Shop;
DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS City;
DROP TABLE IF EXISTS Status;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS Role;

CREATE TABLE IF NOT EXISTS City
(
    name character varying(30) NOT NULL UNIQUE,
    id   serial                NOT NULL
    );

CREATE TABLE IF NOT EXISTS Status
(
    name character varying(255) NOT NULL UNIQUE,
    id   serial                 NOT NULL
    );

CREATE TABLE IF NOT EXISTS Category
(
    name character varying(255) NOT NULL UNIQUE,
    id   serial                 NOT NULL
    );

CREATE TABLE IF NOT EXISTS Role
(
    name character varying(20) NOT NULL UNIQUE,
    id   serial                NOT NULL
    );

CREATE TABLE IF NOT EXISTS Address
(
    street_name   character varying(255) NOT NULL,
    street_number character varying(5)   NOT NULL,
    flat_number   character varying(5),
    zip_code      character varying(6)   NOT NULL,
    city_id       serial                 NOT NULL,
    id            serial                 NOT NULL
    );

CREATE TABLE IF NOT EXISTS Shop
(
    name       character varying(255) NOT NULL,
    address_id serial                 NOT NULL,
    id         serial                 NOT NULL
    );

CREATE TABLE IF NOT EXISTS Report
(
    description text,
    date        TIMESTAMP NOT NULL,
    offer_id    serial    NOT NULL,
    Customer_id serial    NOT NULL,
    id          serial    NOT NULL
);

CREATE TABLE IF NOT EXISTS Banned_Customer
(
    ban_date    TIMESTAMP NOT NULL,
    expire_date TIMESTAMP NOT NULL,
    reason      text      NOT NULL,
    banned_by   int       NOT NULL,
    Customer_id serial    NOT NULL,
    id          serial    NOT NULL
);

CREATE TABLE IF NOT EXISTS Customer
(
    email         character varying(255) NOT NULL UNIQUE,
    name          character varying(255) NOT NULL UNIQUE,
    password      character varying(255) NOT NULL,
    salt          character varying(255) NOT NULL,
    phone_number  character varying(15),
    respect       int                    NOT NULL,
    is_banned     BOOLEAN                NOT NULL,
    offer_counter int                    NOT NULL,
    token         character varying(255) NOT NULL,
    role_id       serial                 NOT NULL,
    id            serial                 NOT NULL
    );

CREATE TABLE IF NOT EXISTS Offer
(
    title        character varying(255) NOT NULL,
    description  text                   NOT NULL,
    image        character varying(255) NOT NULL,
    old_price    NUMERIC(9, 2),
    new_prize    NUMERIC(9, 2),
    gps          NUMERIC(15, 2)         NOT NULL,
    start_date   TIMESTAMP              NOT NULL,
    expire_date  TIMESTAMP,
    is_available BOOLEAN                NOT NULL,
    created_by_customer_id   int        NOT NULL,
    status_id    serial                 NOT NULL,
    category_id  serial                 NOT NULL,
    id           serial                 NOT NULL
    );

CREATE TABLE IF NOT EXISTS Offer_Customer
(
    grade       int    NOT NULL,
    customer_id serial NOT NULL,
    offer_id    serial NOT NULL
);

CREATE TABLE IF NOT EXISTS Customer_Shop
(
    customer_id serial NOT NULL,
    shop_id     serial NOT NULL
);

-- primary keys

-- city primary key
ALTER TABLE City
    ADD CONSTRAINT city_pk
        PRIMARY KEY (id);

-- Offer_Customer primary keys
ALTER TABLE Offer_Customer
    ADD CONSTRAINT offer_customer_pk
        PRIMARY KEY (offer_id, customer_id);

-- Customer_Shop primary keys
ALTER TABLE Customer_Shop
    ADD CONSTRAINT customer_shop_pk
        PRIMARY KEY (shop_id, customer_id);

ALTER TABLE Customer_Shop
    ADD CONSTRAINT customer_shop_shop_id_unique
        UNIQUE (shop_id);

-- status primary key
ALTER TABLE Status
    ADD CONSTRAINT status_pk
        PRIMARY KEY (id);

-- category primary key
ALTER TABLE Category
    ADD CONSTRAINT category_pk
        PRIMARY KEY (id);

-- role primary key
ALTER TABLE Role
    ADD CONSTRAINT role_pk
        PRIMARY KEY (id);

-- address primary key
ALTER TABLE Address
    ADD CONSTRAINT address_pk
        PRIMARY KEY (id);

-- shop primary key
ALTER TABLE Shop
    ADD CONSTRAINT shop_pk
        PRIMARY KEY (id);

-- report primary key
ALTER TABLE Report
    ADD CONSTRAINT report_pk
        PRIMARY KEY (id);

-- banned_Customer primary key
ALTER TABLE Banned_Customer
    ADD CONSTRAINT banned_Customer_pk
        PRIMARY KEY (id);

-- Customer primary key
ALTER TABLE Customer
    ADD CONSTRAINT Customer_pk
        PRIMARY KEY (id);

-- offer primary key
ALTER TABLE Offer
    ADD CONSTRAINT offer_pk
        PRIMARY KEY (id);

-- foreign keys

-- address Foreign key
ALTER TABLE Address
    ADD CONSTRAINT city_fk
        FOREIGN KEY (city_id)
            REFERENCES City (id);

-- shop Foreign key
ALTER TABLE Shop
    ADD CONSTRAINT address_fk
        FOREIGN KEY (address_id)
            REFERENCES Address (id);

-- report Foreign keys
ALTER TABLE Report
    ADD CONSTRAINT offer_fk
        FOREIGN KEY (offer_id)
            REFERENCES Offer (id);

ALTER TABLE Report
    ADD CONSTRAINT Customer_fk
        FOREIGN KEY (Customer_id)
            REFERENCES Customer (id);

-- banned_Customer Foreign key
ALTER TABLE Banned_Customer
    ADD CONSTRAINT Customer_fk
        FOREIGN KEY (Customer_id)
            REFERENCES Customer (id);

ALTER TABLE Customer
    ADD CONSTRAINT role_fk
        FOREIGN KEY (role_id)
            REFERENCES Role (id);

-- Offer Foreign keys
ALTER TABLE Offer
    ADD CONSTRAINT Customer_fk
        FOREIGN KEY (created_by_customer_id)
            REFERENCES Customer (id);

ALTER TABLE Offer
    ADD CONSTRAINT status_fk
        FOREIGN KEY (status_id)
            REFERENCES Status (id);

ALTER TABLE Offer
    ADD CONSTRAINT category_fk
        FOREIGN KEY (category_id)
            REFERENCES Category (id);

-- Customer_shop foreign keys
ALTER TABLE Customer_Shop
    ADD CONSTRAINT customer_fk
        FOREIGN KEY (customer_id)
            REFERENCES Customer (id);

ALTER TABLE Customer_Shop
    ADD CONSTRAINT shop_fk
        FOREIGN KEY (shop_id)
            REFERENCES Shop (id);

-- Offer_Customer foreign keys
ALTER TABLE Offer_Customer
    ADD CONSTRAINT customer_fk
        FOREIGN KEY (customer_id)
            REFERENCES Customer (id);

ALTER TABLE Offer_Customer
    ADD CONSTRAINT offer_fk
        FOREIGN KEY (offer_id)
            REFERENCES Offer (id);