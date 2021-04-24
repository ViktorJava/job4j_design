-- Удаление таблицы если существует.
DROP TABLE IF EXISTS car_card;

create table car_card(
id serial primary key,
	car_model varchar (30),
	date_creation date,
	price int
);
insert into car_card(car_model, date_creation, price) values('BMW', '22/08/2014', 25000);
update car_card set car_model='Mercedes', price='19000';
select * from car_card;
-- Очистка таблицы.
delete from car_card;
