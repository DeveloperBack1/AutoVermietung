-- Вставка данных в таблицу cars
-- Вставка данных в таблицу cars
INSERT INTO cars (model, brand, price_per_day, available)
VALUES
    ('Model S', 'Tesla', 150.0, TRUE),
    ('Civic', 'Honda', 50.0, TRUE),
    ('Corolla', 'Toyota', 60.0, TRUE),
    ('Mustang', 'Ford', 120.0, FALSE),
    ('X5', 'BMW', 200.0, TRUE);

-- Вставка данных в таблицу customers
INSERT INTO customers (name, email)
VALUES
    ('Alice Johnson', 'alice.johnson@example.com'),
    ('Bob Smith', 'bob.smith@example.com'),
    ('Charlie Brown', 'charlie.brown@example.com'),
    ('Diana Prince', 'diana.prince@example.com'),
    ('Ethan Hunt', 'ethan.hunt@example.com');

-- Вставка данных в таблицу rentals
INSERT INTO rentals (customer_id, car_id, start_date, end_date, total_cost)
VALUES
    (1, 1, '2024-11-01', '2024-11-05', 600.0),  -- Alice арендует Tesla на 4 дня
    (2, 2, '2024-11-03', '2024-11-06', 150.0),  -- Bob арендует Honda на 3 дня
    (3, 4, '2024-11-02', '2024-11-04', 240.0),  -- Charlie арендует Ford на 2 дня
    (4, 5, '2024-11-05', '2024-11-09', 800.0),  -- Diana арендует BMW на 4 дня
    (5, 3, '2024-11-10', '2024-11-12', 120.0);  -- Ethan арендует Toyota на 2 дня
