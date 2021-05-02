INSERT INTO people(name) VALUES ('Аня');
INSERT INTO people(name) VALUES ('Ваня');
INSERT INTO people(name) VALUES ('Маня');

INSERT INTO devices (name, price) VALUES('iPhone 11', 800);
INSERT INTO devices (name, price) VALUES ('Samsung S21', 1000);
INSERT INTO devices (name, price) VALUES ('Nokia 3310', 30);
INSERT INTO devices (name, price) VALUES ('GPixel', 1130);
INSERT INTO devices (name, price) VALUES ('Synchrophasotron', 10500);
INSERT INTO devices (name, price) VALUES ('Nuclear reactor', 8200);
INSERT INTO devices (name, price) VALUES ('Notebook', 639);
INSERT INTO devices (name, price) VALUES ('JavaPhone', 12000);

INSERT INTO devices_people (device_id, people_id) VALUES(1, 1);
INSERT INTO devices_people (device_id, people_id) VALUES(2, 1);
INSERT INTO devices_people (device_id, people_id) VALUES(3, 1);

INSERT INTO devices_people (device_id, people_id) VALUES(3, 2);
INSERT INTO devices_people (device_id, people_id) VALUES(4, 2);
INSERT INTO devices_people (device_id, people_id) VALUES(5, 2);

INSERT INTO devices_people (device_id, people_id) VALUES(6, 3);
INSERT INTO devices_people (device_id, people_id) VALUES(7, 3);
INSERT INTO devices_people (device_id, people_id) VALUES(8, 3);
