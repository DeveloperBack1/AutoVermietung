DROP TABLE IF EXISTS rentals;
DROP TABLE IF EXISTS cars;
DROP TABLE IF EXISTS customers;

-- Таблица для хранения информации об автомобилях
CREATE TABLE cars
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    model         VARCHAR(255) NOT NULL,
    brand         VARCHAR(255) NOT NULL,
    price_per_day DOUBLE       NOT NULL,
    available     BOOLEAN DEFAULT TRUE
);

-- Таблица для хранения информации о клиентах
CREATE TABLE customers
(
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    email       VARCHAR(255) NOT NULL UNIQUE
);

-- Таблица для хранения информации об арендах
CREATE TABLE rentals
(
    rental_id   INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    car_id      INT NOT NULL,
    start_date  DATE,
    end_date    DATE,
    total_cost  DOUBLE,
    CONSTRAINT fk_rental_customer FOREIGN KEY (customer_id) REFERENCES customers (customer_id) ON DELETE CASCADE,
    CONSTRAINT fk_rental_car FOREIGN KEY (car_id) REFERENCES cars (id) ON DELETE CASCADE
);