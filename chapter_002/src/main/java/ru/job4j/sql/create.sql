--Роли. 
-- Роль, как таковую, может иметь много пользователей.
CREATE TABLE role(
id serial PRIMARY KEY,
role_name varchar(255)
);

--Категории заявки.
CREATE TABLE category(
id serial PRIMARY KEY,
categort_name varchar(255)
);

--Права ролей.
CREATE TABLE rules(
id serial PRIMARY KEY,
rules_name varchar(255)
);

--Состояние заявки.
CREATE TABLE state(
id serial PRIMARY KEY,
status varchar(255)
);

--Пользователи.
--Многие пользователи имеют роль.
CREATE TABLE users (
id serial PRIMARY KEY,
last_name varchar(255),
role_id int REFERENCES role(id)
);

--Вспомогательная таблица many-to-many.
CREATE TABLE role_rules(
id serial PRIMARY KEY,
role_id int REFERENCES role(id),
rules_id int REFERENCES rules(id)
);

--Заявки. 
--Много заявок может пренадлежать одному пользователю.
--заявка может иметь множество категорий.
--заявка может иметь множество состояний.
CREATE TABLE item(
id serial PRIMARY KEY,
item_name varchar(255),
user_id int REFERENCES users(id),
category_id int REFERENCES category(id)	
);

--Комментарии заявок. 
--Одна заявка может иметь много комментариев.
CREATE TABLE comments(
id serial PRIMARY KEY,
comment_text varchar(255),
item_id int REFERENCES item(id)
);

--Приложенные Файлы.
--Одна заявка может иметь множество вложений.
CREATE TABLE attaches(
id serial PRIMARY KEY,
file_name varchar(255),
item_id int REFERENCES item(id)
);