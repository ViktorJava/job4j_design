DROP table if exists my_contcts;
DROP table if exists profession;
DROP table if exists zip_code;
DROP table if exists status;


CREATE TABLE profession(
	prof_id serial PRIMARY KEY,
	profession varchar (255)
);

CREATE TABLE zip_code(
	zip_code serial PRIMARY KEY,
	city varchar(100),
	state varchar(255)
);

CREATE TABLE status(
	status_id serial PRIMARY KEY,
	status varchar(255)
);

CREATE TABLE  my_contacts(
	contact_id serial PRIMARY KEY,
	last_name varchar(255),
	first_name varchar(255),
	phone varchar(200),
	email varchar(255),
	prof_id int REFERENCES profession(prof_id),
	zip_code int REFERENCES zip_code(zip_code),
	status_id int REFERENCES status(status_id)
);