INSERT INTO profession (profession) VALUES ('Программист');
INSERT INTO profession (profession) VALUES ('Тракторист');
INSERT INTO profession (profession) VALUES ('Дворник');
INSERT INTO profession (profession) VALUES ('Киллер');

INSERT INTO zip_code (city, state) VALUES ('Энергодар','Запорожская');
INSERT INTO zip_code (city, state) VALUES ('Киев','Киевская.');

INSERT INTO status (status) VALUES ('Занят');
INSERT INTO status (status) VALUES ('отошел');
INSERT INTO status (status) VALUES ('Свободен');

insert into my_contacts (last_name, first_name, phone, email, prof_id, zip_code, status_id) 
	values ('Виктор','Вдовиченко','0661092760','gipsy@gmail.com',1,1,3);
insert into my_contacts (last_name, first_name, phone, email, prof_id, zip_code, status_id) 
	values ('Иван','Иванов','0551237640','ivanov@gmail.com',2,2,1);

insert into my_contacts (last_name, first_name, phone, email, prof_id, zip_code, status_id)
values ('Петр','Петров','0671872584','petrov@gmail.com',3,2,3);

insert into my_contacts (last_name, first_name, phone, email, prof_id, zip_code, status_id)
values ('Надежда','Надеждова','0982783946','nadia@gmail.com',4,1,2);

