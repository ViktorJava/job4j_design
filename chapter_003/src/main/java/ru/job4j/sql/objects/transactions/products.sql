DROP TABLE products;
CREATE TABLE IF NOT EXISTS products
(
    id       serial PRIMARY KEY,
    name     varchar(50),
    producer varchar(50),
    count    integer DEFAULT 0,
    price    integer
);

INSERT INTO products (name, producer, count, price)
VALUES ('product_1', 'producer_1', 100, 75),
       ('product_2', 'producer_2', 10, 150),
       ('product_3', 'producer_3', 0, 500);

SELECT*
FROM products;

BEGIN;

UPDATE products
SET count=220
WHERE price = 500;

SAVEPOINT first_sp;

DELETE
FROM products
WHERE name = 'product_1';

SAVEPOINT second_sp;

DELETE
FROM products
WHERE name = 'product_2';

SELECT *
FROM products;

ROLLBACK TO first_sp;

SELECT*
FROM products;

COMMIT;
