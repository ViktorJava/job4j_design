DROP TABLE IF EXISTS account,test,result,role,account_role CASCADE;
DROP VIEW IF EXISTS show_students_with_80_or_less_percents;

/*
 База данных, системы проверки знаний.
 Создать выборку, лиц из числа студентов (role.name='student'),
 которые прошли тестирование,
 с результатом знаний менее 80 процентов (тестирование провалено),
 год и более, назад от текущей даты.
*/

CREATE TABLE account
(
    id       serial PRIMARY KEY,
    login    VARCHAR(50)       NOT NULL,
    password VARCHAR(255)      NOT NULL,
    name     VARCHAR(100)      NOT NULL,
    email    VARCHAR(100)      NOT NULL,
    active   bool DEFAULT TRUE NOT NULL
);

INSERT INTO account(login, password, name, email, active)
VALUES ('semenov', '123', 'Семён Семёныч', 'semenov@mail.ru', DEFAULT),
       ('petrov', '321', 'Пётр Петрович', 'petrov@mail.ru', DEFAULT),
       ('parsentev', '8765564', 'Пётр Сергеевич', 'parsentev@mail.ru', DEFAULT),
       ('gipsyscrew', 'iugw7', 'Виктор Александрович', 'gipsyscrew@mail.ru', DEFAULT);

CREATE TABLE test
(
    id          serial PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description TEXT         NOT NULL
);

INSERT INTO test(name, description)
VALUES ('Java SE', 'Java SE'),
       ('Android dev', 'Android software development'),
       ('SQL', 'PostgreSQL');



CREATE TABLE result
(
    id         serial PRIMARY KEY,
    id_account integer,
    id_test    integer,
    percent    DOUBLE PRECISION NOT NULL,
    created    timestamp        NOT NULL,
    CONSTRAINT result_account_fk FOREIGN KEY (id_account)
        REFERENCES account (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT result_test_fk FOREIGN KEY (id_test)
        REFERENCES test (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

INSERT INTO result(id_account, id_test, percent, created)
VALUES (1, 1, 85, '22.02.2022'),
       (2, 2, 15, NOW()),
       (4, 1, 60, '14.02.2022'),
       (3, 3, 10, '22.07.1945');


CREATE TABLE role
(
    id   serial PRIMARY KEY,
    name varchar(15) NOT NULL
);

INSERT INTO role(name)
VALUES ('tutor'),
       ('admin'),
       ('student');

CREATE TABLE account_role
(
    id         serial PRIMARY KEY,
    id_role    integer,
    id_account integer,
    CONSTRAINT account_role_fk FOREIGN KEY (id_role)
        REFERENCES role (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT account_role_fk2 FOREIGN KEY (id_account)
        REFERENCES account (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

INSERT INTO account_role (id_role, id_account)
VALUES (1, 3),
       (2, 3),
       (3, 1),
       (3, 2),
       (3, 4);

CREATE VIEW show_students_with_80_or_less_percents AS
SELECT a.name AS name, r.name AS role, t.name AS test, res.percent
FROM account a
         JOIN result res ON a.id = res.id_account
         JOIN test t ON res.id_test = t.id
         JOIN account_role ar ON a.id = ar.id_account
         JOIN role r ON ar.id_role = r.id
WHERE res.percent <= 80
  AND r.name = 'student'
  AND EXTRACT(YEAR FROM res.created) <= EXTRACT(YEAR FROM CURRENT_DATE - INTERVAL '1 year');

SELECT *
FROM show_students_with_80_or_less_percents;
