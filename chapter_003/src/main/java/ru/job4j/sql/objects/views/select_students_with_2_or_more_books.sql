DROP TABLE IF EXISTS authors,books,students,orders CASCADE;
DROP VIEW IF EXISTS show_students_with_2_or_more_books;

CREATE TABLE students
(
    id   serial PRIMARY KEY,
    name varchar(50)
);
INSERT INTO students (name)
VALUES ('Иван Иванов');
INSERT INTO students (name)
VALUES ('Петр Петров');

CREATE TABLE authors
(
    id   serial PRIMARY KEY,
    name varchar(50)
);
INSERT INTO authors (name)
VALUES ('Александр Пушкин');
INSERT INTO authors (name)
VALUES ('Николай Гоголь');

CREATE TABLE books
(
    id        serial PRIMARY KEY,
    name      varchar(50),
    author_id integer REFERENCES authors (id) ON DELETE CASCADE
);
INSERT INTO books (name, author_id)
VALUES ('Евгений Онегин', 1);
INSERT INTO books (name, author_id)
VALUES ('Капитанская дочка', 1);
INSERT INTO books (name, author_id)
VALUES ('Дубровский', 1);
INSERT INTO books (name, author_id)
VALUES ('Мертвые души', 2);
INSERT INTO books (name, author_id)
VALUES ('Вий', 2);


CREATE TABLE orders
(
    id         serial PRIMARY KEY,
    active     boolean DEFAULT TRUE,
    student_id integer REFERENCES students (id) ON DELETE CASCADE,
    book_id    integer REFERENCES books (id) ON DELETE CASCADE
);

INSERT INTO orders (book_id, student_id)
VALUES (1, 1);
INSERT INTO orders (book_id, student_id)
VALUES (3, 1);
INSERT INTO orders (book_id, student_id)
VALUES (5, 2);
INSERT INTO orders (book_id, student_id)
VALUES (4, 1);
INSERT INTO orders (book_id, student_id)
VALUES (2, 2);

CREATE VIEW show_students_with_2_or_more_books
AS
SELECT s.name AS student, COUNT(a.name), a.name AS author
FROM students AS s
         JOIN orders o ON s.id = o.student_id
         JOIN books b ON o.book_id = b.id
         JOIN authors a ON b.author_id = a.id
GROUP BY (s.name, a.name)
HAVING COUNT(a.name) >= 2;

SELECT *
FROM show_students_with_2_or_more_books;
