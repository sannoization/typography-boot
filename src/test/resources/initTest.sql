create schema if not exists typography;
create table typography.employee
(
    id         int         not null primary key,
    first_name varchar(40) not null,
    last_name  varchar(40) not null,
    phone      varchar(10) not null,
    email      varchar(30) not null
);

create table typography.goods
(
    id           int         not null primary key,
    good_name    varchar(40) not null,
    good_cost    int         not null,
    amount       int         not null,
    material     varchar(40) not null,
    good_options varchar(256)
);

create table typography.order
(
    id         int       not null primary key,
    date_start timestamp not null,
    date_end   timestamp,
    employee   int       not null,
    goods      int       not null,
    constraint employee_to_order foreign key (employee) references typography.employee (id) on delete cascade,
    constraint goods_to_order foreign key (goods) references typography.goods (id) on delete cascade
);

create table typography.customer
(
    id         int         not null primary key,
    first_name varchar(40) not null,
    last_name  varchar(40) not null,
    phone      varchar(10) not null,
    email      varchar(30) not null
);

create table typography.order_to_customer
(
    customer_id int
        constraint customer_id references typography.customer (id) on delete cascade,
    order_id    int
        constraint order_id references typography.order (id) on delete cascade,
    primary key (customer_id, order_id)
);

insert into typography.employee (id, first_name, last_name, phone, email)
values (0, 'alex', 'sorokov', '9995553322', 'sorok@mail.ru');

insert into typography.customer (id, first_name, last_name, phone, email)
values (1, 'kirill', 'tulin', '9601234545', 'kirill@ko.ru');

insert into typography.goods (id, good_name, good_cost, amount, material, good_options)
values (1, 'print', 200, 5, 'paper', 'option');

insert into typography.order (id, date_start, date_end, employee, goods)
values (1, '2007-12-03 10:15:30.000000', '2007-12-03 10:15:30.000000', 0, 1);

insert into typography.order_to_customer (customer_id, order_id)
values (1, 1);