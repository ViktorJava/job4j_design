DROP TABLE IF EXISTS person CASCADE;
DROP TABLE IF EXISTS company CASCADE;

CREATE TABLE IF NOT EXISTS company
(
    id   int NOT NULL,
    name varchar,
    CONSTRAINT company_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS person
(
    id         integer NOT NULL,
    name       varchar,
    company_id int REFERENCES company (id),
    CONSTRAINT person_pk PRIMARY KEY (id)
);