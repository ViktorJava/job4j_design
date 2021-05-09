DROP TABLE IF EXISTS phonebook;

CREATE TABLE phonebook(
idphonebook serial PRIMARY KEY,
lastname varchar(255),
phone int
);

INSERT INTO phonebook(lastname,phone) VALUES('Каптур', 7263632);
INSERT INTO phonebook(lastname,phone) VALUES('Артюкевич', 9879393);
