create table PERSON (id_person identity,
						first_name varchar not null,
						last_name varchar not null,
						primary key (id_person));

create table Account (id_account identity,
						user_name varchar unique,
						password varchar not null,
					  email varchar,
					  id_person integer,
						primary key (id_account));


insert into PERSON(id_person,first_name,last_name) values (1,'first_name_test1','last_name_test1');
insert into PERSON(id_person,first_name,last_name) values (2,'first_name_test2','last_name_test2');
insert into ACCOUNT(id_account,user_name,password,email,id_person) values (1,'username_test1','secret1','test1@test.ro',1);
insert into ACCOUNT(id_account,user_name,password,email,id_person) values (2,'username_test2','secret2','test2@test.ro',2);
