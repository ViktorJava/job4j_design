--Вывести список всех машин и все привязанные к ним детали.
SELECT c.name "марка",b.name "кузов", e.name "двигатель", t.name "КПП" 
FROM car c
JOIN body b ON c.body_id = b.id
JOIN engine e ON c.engine_id = e.id
JOIN transmission t ON c.transmission_id = t.id;

--Вывести отдельно детали (1 деталь - 1 запрос), которые не используются в машине.
SELECT b.name "кузов" FROM body b
LEFT JOIN car c ON b.id = c.body_id
WHERE c.body_id IS NULL;

SELECT e.name "двигатель" FROM engine e
LEFT JOIN car c ON e.id = c.body_id
WHERE c.body_id IS NULL;

SELECT t.name "КПП" FROM transmission t
LEFT JOIN car c ON t.id = c.body_id
WHERE c.body_id IS NULL;
