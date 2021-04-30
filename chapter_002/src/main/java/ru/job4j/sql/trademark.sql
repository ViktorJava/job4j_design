CREATE TABLE country(
	id serial PRIMARY KEY,
	name varchar(100)
);

CREATE TABLE trademark(
	id serial PRIMARY KEY,
	name varchar(100),
	country_id int REFERENCES country(id)
);
INSERT INTO country(name) VALUES('Russia');
INSERT INTO country(name) VALUES('Ukraine');
INSERT INTO country(name) VALUES('China');

INSERT INTO trademark(name, country_id) VALUES ('Job4j', 1);
INSERT INTO trademark(name, country_id) VALUES ('SoftServe', 2);
INSERT INTO trademark(name, country_id) VALUES ('Huawei', 3);
INSERT INTO trademark(name) VALUES('Horns and hooves');

SELECT tm.name FROM trademark tm;
SELECT * FROM trademark JOIN country co ON trademark.country_id = co.id;
SELECT tm.name AS "Имя компании", co.name AS "Страна" FROM trademark AS tm JOIN country AS co ON tm.country_id = co.id;
SELECT tm.name AS "Имя компании" FROM trademark tm WHERE id in (SELECT id FROM country);