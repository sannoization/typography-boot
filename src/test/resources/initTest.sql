create schema if not exists typography;
create table typography.employee
(
    id         serial primary key,
    first_name varchar(40) not null,
    last_name  varchar(40) not null,
    phone      varchar(10) not null,
    email      varchar(30) not null
);

create table typography.customer
(
    id         serial primary key,
    first_name varchar(40) not null,
    last_name  varchar(40) not null,
    phone      varchar(10) not null,
    email      varchar(30) not null
);

insert into typography.employee (first_name, last_name, phone, email)
values ('alex', 'sorokov', '9995553322', 'sorok@mail.ru');