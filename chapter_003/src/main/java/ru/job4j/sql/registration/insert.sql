insert into role (role) values ('Client');
insert into role (role) values ('VIP Client');
insert into role (role) values ('Maecenas');

insert into users (name,role_id) values('Ivan',1);
insert into users (name,role_id) values ('Kirill',2);
insert into users (name,role_id) values ('Viktor',3);

insert into category (category) values ('Normal');
insert into category (category) values ('Emergency');
insert into category (category) values ('Repeated');

insert into state (state) values ('Work');
insert into state (state) values ('Completed');
insert into state (state) values ('Rejected');

insert into rules (rules) values ('Admin');
insert into rules (rules) values ('User');
insert into rules (rules) values ('Guest');

insert into role_rules (role_id, rules_id) values (1, 3);
insert into role_rules (role_id, rules_id) values (2, 2);
insert into role_rules (role_id, rules_id) values (3, 2);

insert into item (item_name, user_id, category_id, state_id) values ('item_1', 1, 1, 1);
insert into item (item_name, user_id, category_id, state_id) values ('item_2', 2, 2, 1);
insert into item (item_name, user_id, category_id, state_id) values ('item_3', 3, 3, 2);

insert into comments (comments,item_id) values('Comment_1',1);
insert into comments (comments,item_id) values('Comment_2',2);
insert into comments (comments,item_id) values('Comment_3',3);

insert into attaches (attaches,item_id) values('Photo_1',1);
insert into attaches (attaches,item_id) values('Photo_2',2);




