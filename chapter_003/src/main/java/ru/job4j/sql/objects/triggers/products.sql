DROP TABLE IF EXISTS products,history_of_price;

CREATE TABLE products
(
    id       serial PRIMARY KEY,
    name     varchar(50),
    producer varchar(50),
    count    integer DEFAULT 0,
    price    integer
);

/*
 Триггер должен срабатывать после вставки данных, для любого товара и просто
 насчитывать налог на товар (нужно прибавить налог к цене товара).
 Действовать он должен не на каждый ряд, а на запрос (statement уровень)
 */

CREATE OR REPLACE FUNCTION super_tax()
    RETURNS trigger AS
$$
BEGIN
    UPDATE products
    SET price = price + (price * 0.2)
    WHERE id = (SELECT id FROM inserted);
    RETURN new;
END;
$$
    LANGUAGE 'plpgsql';

CREATE TRIGGER super_tax_trigger
    AFTER INSERT
    ON products
    REFERENCING new TABLE AS inserted
    FOR EACH STATEMENT
EXECUTE PROCEDURE super_tax();

/*
 Триггер должен срабатывать до вставки данных и насчитывать налог на товар
 (нужно прибавить налог к цене товара). Используем row уровень.
 */

CREATE OR REPLACE FUNCTION tax()
    RETURNS trigger AS
$$
BEGIN
    new.price = new.price + (new.price * 0.2);
    RETURN new;
END;
$$
    LANGUAGE 'plpgsql';

CREATE TRIGGER tax_trigger
    BEFORE INSERT
    ON products
    FOR EACH ROW
EXECUTE PROCEDURE tax();

/*
 Триггер на row уровне, который при вставке продукта в таблицу products,
 будет заносить имя, цену и текущую дату в таблицу history_of_price.
 */

CREATE TABLE history_of_price
(
    id    serial PRIMARY KEY,
    name  varchar(50),
    price integer,
    date  timestamp
);

CREATE OR REPLACE FUNCTION history_of_price() RETURNS trigger AS
$$
BEGIN
    INSERT INTO history_of_price(name, price, date)
    VALUES (NEW.name, NEW.price, NOW());
    RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER history_of_price_trigger
    AFTER INSERT
    ON products
    FOR EACH ROW
EXECUTE PROCEDURE history_of_price();

INSERT INTO products(name, producer, count, price)
VALUES ('product_1', 'prod_1', 3, 100);
