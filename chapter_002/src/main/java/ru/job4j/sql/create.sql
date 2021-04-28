--Роли. 
CREATE TABLE role(
id serial PRIMARY KEY,
role varchar(30)
);

--Категории заявки.
CREATE TABLE category(
id serial PRIMARY KEY,
category varchar(30)
);

--Права ролей.
CREATE TABLE rules(
id serial PRIMARY KEY,
rules varchar(30)
);

--Состояние заявки.
CREATE TABLE state(
id serial PRIMARY KEY,
state varchar(30)
);

--Пользователи.
CREATE TABLE users (
id serial PRIMARY KEY,
name varchar(50),
role_id int REFERENCES role(id)
);

--Вспомогательная таблица many-to-many.
CREATE TABLE role_rules(
id serial PRIMARY KEY,
role_id int REFERENCES role(id),
rules_id int REFERENCES rules(id)
);

--Заявки. 
CREATE TABLE item(
id serial PRIMARY KEY,
item_name varchar(255),
user_id int REFERENCES users(id),
category_id int REFERENCES category(id),
state_id int REFERENCES state(id)	
);

--Комментарии заявок. 
CREATE TABLE comments(
id serial PRIMARY KEY,
comments varchar(255),
item_id int REFERENCES item(id)
);

--Приложенные Файлы.
CREATE TABLE attaches(
id serial PRIMARY KEY,
attaches varchar(255),
item_id int REFERENCES item(id)
);