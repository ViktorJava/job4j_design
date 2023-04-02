CREATE TABLE IF NOT EXISTS products
(
    id       serial PRIMARY KEY,
    name     varchar(50),
    producer varchar(50),
    count    integer DEFAULT 0,
    price    integer
);

INSERT INTO products(name, producer, count, price)
VALUES ('product_1', 'prod_1', 4, -1),
       ('product_2', 'prod_2', 14, 230),
       ('product_3', 'prod_3', 100501, 0);

/*
 Удаление продукта с минимальной ценой.
 */
CREATE OR REPLACE PROCEDURE delete_min_price()
    LANGUAGE 'plpgsql' AS
$$
BEGIN
    DELETE FROM products WHERE price = (SELECT MIN(price) FROM products);
END;
$$;

/*
Удаление чётного количества продуктов на складе.
 */
CREATE OR REPLACE PROCEDURE delete_even_count()
    LANGUAGE 'plpgsql' AS
$$
BEGIN
    DELETE FROM products WHERE MOD(count, 2) = 0;
END;
$$;

/*
 Удаление всего товара, с минимально заданной ценой (default 0 рублей).
 Функция возвращает удалённые данные.
*/
CREATE OR REPLACE FUNCTION correct_price(low_price integer DEFAULT 0)
    RETURNS table
            (
                name  varchar,
                price integer
            )
    LANGUAGE sql
AS
$$
DELETE
FROM products
WHERE price <= low_price
RETURNING NAME, price;
$$;

--
CALL delete_min_price();-- del name: product_1, price: -1
CALL delete_even_count();-- del name: product_2, count: 14
SELECT *
FROM correct_price();-- del name: product_3, price: 0

DROP PROCEDURE IF EXISTS delete_min_price();
DROP PROCEDURE IF EXISTS delete_even_count();
DROP FUNCTION IF EXISTS correct_price(integer);
DROP TABLE IF EXISTS products;
