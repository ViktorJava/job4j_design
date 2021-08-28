-- Тестирование индексации таблицы.

CREATE TABLE test (id integer, value text);
INSERT INTO test --вставляем 2млн случайных записей (7сек).
SELECT i, md5(random()::text)
FROM generate_series(1, 2000000) AS i;

SELECT * FROM test WHERE id = 1000000; -- 185ms.
CREATE INDEX test_id_index ON test (id); -- индексируем по полю id (2сек).
SELECT * FROM test WHERE id = 1000000; -- 55ms.
SELECT pg_size_pretty( pg_total_relation_size( 'test' ) ); -- размер таблицы 130MB.
SELECT pg_size_pretty( pg_database_size( 'postgres' ) ); -- размер базы данных.

DROP INDEX test_id_index; -- удаляю индекс.
