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

create table typography.goods
(
    id serial primary key,
    good_name varchar(40) not null,
    good_cost int not null,
    amount int not null,
    material varchar(40) not null,
    good_options varchar
);

insert into typography.employee (first_name, last_name, phone, email)
values ('alex', 'sorokov', '9995553322', 'sorok@mail.ru');

insert into typography.customer (first_name, last_name, phone, email)
values ('kirill', 'tulin', '9601234545', 'kirill@ko.ru');