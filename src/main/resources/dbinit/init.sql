create schema if not exists typography;
create table typography.employee
(
    id int not null primary key,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    phone varchar(10) not null,
    email varchar(30) not null,
);

create table typography.customer
(
    id int not null primary key,
    first_name varchar(40) not null ,
    last_name varchar(40) not null ,
    phone varchar(10) not null,
    email varchar(30) not null,
    order_id int,
    constraint customer_to_order_id foreign key (order_id) references typography.order_to_customer;
);

create table typography.goods
(
    id int not null primary key,
    good_name varchar(40) not null,
    good_cost int not null,
    amount int not null,
    material varchar(40) not null,
    good_options varchar,
);

create table typography.order
(
    id int not null primary key,
    date_start timestamp not null,
    date_end timestamp,
    employee int not null,
    goods int not null
    primary key(id),
    constraint employee_to_order foreign key (employee) references typography.employee,
    constraint goods_to_order foreign key (goods) references typography.goods
)

create table typography.order_to_customer
(
    customer_id int not null constraint customer_id references typography.customer,
    order_id int not null constraint order_id references typography.order
)
