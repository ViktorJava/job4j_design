--1. Написать запрос получение всех продуктов с типом "СЫР"
 SELECT p.name "pName", type.name "pType"
 FROM product p
 JOIN TYPE ON p.type_id = type.id
 WHERE type.name = 'Сыр';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
 SELECT p.name
 FROM product p
 WHERE p.name like '%мороженое%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
--Запрос должен быть универсальным, т.е. не зависеть от конкретного временного промежутка
 SELECT p.name, p.expired_date
 FROM product p
 WHERE extract(MONTH FROM p.expired_date)=extract(MONTH FROM CURRENT_DATE+interval '1 month') 
 AND extract(YEAR FROM p.expired_date)=extract(YEAR FROM CURRENT_DATE+interval '1 month');

--4. Написать запрос, который выводит самый дорогой продукт.
 SELECT name, price
 FROM product
 ORDER BY price DESC
 limit(1);

--5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих.
--В виде имя_типа, количество
 SELECT type.name, count(*)
 FROM product p JOIN TYPE ON p.type_id=type.id
 GROUP BY type.id;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
 SELECT p.name, type.name
 FROM product p
 JOIN TYPE ON p.type_id = type.id
 WHERE type.name = 'Сыр' OR type.name = 'Молоко';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
 SELECT type.name, count(*)
 FROM product p JOIN TYPE ON p.type_id=type.id
 GROUP BY type.id
 HAVING count(*) < 10;

--8. Вывести все продукты и их тип.
 SELECT p.name, type.name
 FROM product p
 JOIN TYPE ON p.type_id = type.id;
