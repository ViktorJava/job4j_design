CREATE TABLE TYPE (
id serial PRIMARY KEY,
name varchar(200)
);

CREATE TABLE product (
id serial PRIMARY KEY,
name varchar(200),
type_id int REFERENCES type(id),
expired_date TIMESTAMP,
price int
);
