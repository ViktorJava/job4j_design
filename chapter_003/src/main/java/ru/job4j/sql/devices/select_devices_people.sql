--Используя агрегатные функции вывести среднюю цену устройств.
SELECT avg(devices.price) FROM devices;

--Используя группировку вывести для каждого человека среднюю цену его устройств.
SELECT p.name "имя", round (avg(d.price)) "ср.цена"
FROM devices d JOIN devices_people dp ON d.id= dp.device_id
JOIN people p ON p.id = dp.people_id
GROUP BY p.name;

--Дополнить запрос условием, что средняя стоимость устройств должна быть больше 5000.
SELECT p.name "имя", round (avg(d.price)) "ср.цена"
FROM devices d JOIN devices_people dp ON d.id= dp.device_id
JOIN people p ON p.id = dp.people_id
GROUP BY p.name
HAVING avg(d.price)>5000;
