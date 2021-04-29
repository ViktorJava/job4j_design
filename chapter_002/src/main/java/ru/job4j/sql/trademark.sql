CREATE TABLE country(
	id serial PRIMARY KEY,
	name varchar(100)
);

CREATE TABLE trademark(
	id serial primary key,
	name varchar(100),
	vehicle_id int references country(id)
);
insert into country(name) values('Russia');
insert into country(name) values('Ukraine');
insert into country(name) values('China');

insert into trademark(name, vehicle_id) values ('Job4j', 1);
insert into trademark(name, vehicle_id) values ('SoftServe', 2);
insert into trademark(name, vehicle_id) values ('Huawei', 3);
insert into trademark(name) values('Horns and hooves');

--select tm.name from trademark tm;
--SELECT * FROM trademark JOIN country co ON trademark.vehicle_id = co.id;
--SELECT tm.name, co.name FROM trademark AS tm JOIN country AS co ON tm.vehicle_id = co.id;
--SELECT tm.name FROM trademark tm WHERE id in (SELECT id FROM country);