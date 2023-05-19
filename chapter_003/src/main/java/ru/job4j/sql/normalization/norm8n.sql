DROP TABLE IF EXISTS person CASCADE;
DROP TABLE IF EXISTS address CASCADE;
DROP TABLE IF EXISTS video CASCADE;
DROP TABLE IF EXISTS person_video CASCADE;

CREATE TABLE address
(
    id        serial PRIMARY KEY,
    street    varchar(200) NOT NULL,
    house     int          NOT NULL,
    apartment int DEFAULT 0
);


CREATE TABLE person
(
    id         SERIAL PRIMARY KEY,
    first_name varchar(100) NOT NULL,
    last_name  varchar(100) NOT NULL,
    sex        char(1),
    address_id int REFERENCES address (id) ON DELETE RESTRICT
);

CREATE TABLE video
(
    id   serial PRIMARY KEY,
    name varchar NOT NULL UNIQUE
);

CREATE TABLE person_video
(
    id        serial PRIMARY KEY,
    person_id int REFERENCES person (id),
    video_id  int REFERENCES video (id)
);

INSERT INTO address (street, house, apartment)
VALUES ('1-й Казанский переулок', 14, DEFAULT),
       ('Центральная', 40, 74),
       ('Ленина', 7, 130);

INSERT INTO person (first_name, last_name, sex, address_id)
VALUES ('Егорова', 'Ольга', 'Ж', 1),
       ('Иванов', 'Сергей', 'М', 2),
       ('Иванов', 'Сергей', 'М', 3),
       ('Вдовиченко', 'Виктор', 'М', 1);

INSERT INTO video(name)
VALUES ('Пираты карибского моря'),
       ('Матрица: революция'),
       ('Человек который изменил всё'),
       ('Интерстеллар');

INSERT INTO person_video(person_id, video_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 2);

CREATE UNIQUE INDEX ui ON person_video (person_id, video_id);
--DROP INDEX ui;

SELECT first_name, last_name, street, house, apartment, name
FROM address a
         JOIN person p ON a.id = p.address_id
         JOIN person_video pm ON p.id = pm.person_id
         JOIN video m ON pm.video_id = m.id
