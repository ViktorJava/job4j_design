DROP TABLE if exists devices_people;
DROP TABLE if exists devices;
DROP TABLE if exists people;

CREATE table devices(
    id serial primary key,
    name varchar(255),
    price float
);

CREATE table people(
    id serial primary key,
    name varchar(255)
);

CREATE table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);
