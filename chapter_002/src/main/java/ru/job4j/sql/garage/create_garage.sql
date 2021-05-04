DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS transmission;
DROP TABLE IF EXISTS engine;
DROP TABLE IF EXISTS body;

CREATE TABLE body(
id serial PRIMARY KEY,
name varchar(100)
);

CREATE TABLE engine(
id serial PRIMARY KEY,
name varchar(100)
);

CREATE TABLE transmission(
id serial PRIMARY KEY,
name varchar(100)
);

CREATE TABLE car(
id serial PRIMARY KEY,
name varchar(255),
body_id int REFERENCES body(id),
engine_id int REFERENCES engine(id),
transmission_id int REFERENCES transmission(id)
);

INSERT INTO body(name) VALUES('кабриолет');
INSERT INTO body(name) VALUES('паркетник');
INSERT INTO body(name) VALUES('хэчбэк');
INSERT INTO body(name) VALUES('седан');
INSERT INTO body(name) VALUES('самосвал');

INSERT INTO engine(name) VALUES('дизель 2.0');
INSERT INTO engine(name) VALUES('бензин 1.5');
INSERT INTO engine(name) VALUES('турбо-дизель');
INSERT INTO engine(name) VALUES('электро');
INSERT INTO engine(name) VALUES('гибрид');

INSERT INTO transmission(name) VALUES('автомат 5ст.');
INSERT INTO transmission(name) VALUES('робот 6ст.');
INSERT INTO transmission(name) VALUES('механика 4ст.');
INSERT INTO transmission(name) VALUES('механика 5ст.');
INSERT INTO transmission(name) VALUES('вариатор');

INSERT INTO car(name, body_id, engine_id, transmission_id) VALUES('Шэвроле', 1, 1, 2);
INSERT INTO car(name, body_id, engine_id, transmission_id) VALUES('Бумер', 2, 3, 3);
INSERT INTO car(name, body_id, engine_id, transmission_id) VALUES('Мэрс', 3, 2, 4);
INSERT INTO car(name, body_id, engine_id, transmission_id) VALUES('Запорожец', 4, 3, 1);
