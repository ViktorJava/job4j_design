-- Используя left и right join написать запросы, которые давали бы одинаковый результат.
SELECT d.name, e.name FROM emploees e LEFT JOIN departments d ON e.departments_id = d.id;
SELECT d.name, e.name FROM departments d RIGHT JOIN emploees e ON d.id = e.departments_id;

-- Создать таблицу teens с атрибутами name, gender и заполнить ее.
-- Используя cross join составить все возможные разнополые пары
SELECT t1.name AS "Девушки", t1.gender ||'/'|| t2.gender AS "Пол", t2.name AS "Мужики"
FROM teens t1 CROSS JOIN teens t2
WHERE t1.gender <> t2.gender;

-- Выполнить запросы с left, right, full, cross соединениями
SELECT * FROM emploees e LEFT JOIN departments d ON e.departments_id = d.id;
SELECT * FROM departments d RIGHT JOIN emploees e ON d.id = e.departments_id;
SELECT * FROM emploees e FULL JOIN departments d ON e.departments_id = d.id;
SELECT * FROM departments CROSS JOIN emploees;

-- Используя left join найти департаменты, у которых нет работников
SELECT d.name
FROM departments d
LEFT JOIN emploees e
ON e.departments_id = d.id
WHERE e.departments_id IS NULL;