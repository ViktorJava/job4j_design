CREATE TABLE departments (
	id serial PRIMARY KEY,
	name varchar(255)
);

CREATE TABLE emploees(
	id serial PRIMARY KEY,
	name varchar(255),
	departments_id int REFERENCES departments(id)
);

CREATE TABLE teens(
	id serial PRIMARY KEY,
	name varchar(200),
	gender char(1)
);