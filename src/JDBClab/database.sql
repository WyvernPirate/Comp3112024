CREATE DATABASE shop
USE shop
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    name NVARCHAR(25) NOT NULL,
    price DOUBLE NOT NULL,
    quantity INT NOT NULL
    ) ;

