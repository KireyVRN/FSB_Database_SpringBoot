CREATE TABLE fsb_database
(
    id INT AUTO_INCREMENT,
    name varchar(255),
    age INT,
    countryofresidence VARCHAR(255),
    marriage VARCHAR(255),
    conviction VARCHAR(255),
    status VARCHAR(255),
    commentary VARCHAR(255),
    PRIMARY KEY (ID)
);

CREATE TABLE users
(
    id INT AUTO_INCREMENT,
    login varchar(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(255),
    PRIMARY KEY (ID)
);