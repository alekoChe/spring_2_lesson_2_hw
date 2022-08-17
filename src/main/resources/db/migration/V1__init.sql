--create table if not exists products (
--    id          bigserial primary key,
--    title       varchar(255),
--    price       int
--);
--
--insert into products (title, price)
--values ('Milk', 100),
--       ('Bread', 80),
--       ('Cheese', 90);

CREATE TABLE IF NOT EXISTS products (
    id              bigserial PRIMARY KEY,
    title           VARCHAR(255),
    price           int,
    purchase_price  int
);

INSERT INTO products (title, price, purchase_price)
VALUES
    ('Product1', 10, 6),
    ('Product2', 15, 10),
    ('Product3', 20, 12),
    ('Product4', 3, 1),
    ('Product5', 19, 15),
    ('Product6', 25, 17),
    ('Product7', 40, 20),
    ('Product8', 55, 35),
    ('Product9', 17, 10),
    ('Product10', 85, 70),
    ('Product11', 27, 11),
    ('Product12', 5, 1),
    ('Product13', 105, 65),
    ('Product14', 155, 100),
    ('Product15', 30, 10),
    ('Product16', 7, 6),
    ('Product17', 19, 12),
    ('Product18', 65, 45),
    ('Product19', 29, 10),
    ('Product20', 3, 1),
    ('Product21', 33, 18);

--create table users (
--    id         bigserial primary key,
--    username   varchar(36) not null,
--    password   varchar(80) not null,
--    email      varchar(50) unique,
--    created_at timestamp default current_timestamp,
--    updated_at timestamp default current_timestamp
--);

--insert into users (username, password, email)
--values ('bob', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'bob_johnson@gmail.com'),
--       ('john', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'john_johnson@gmail.com');

CREATE TABLE IF NOT EXISTS users (
    id         bigserial primary key,
    user_name   varchar(36) not null,
    phone_number      varchar(50) unique,
    password   varchar(80) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);
INSERT INTO users (user_name, phone_number, password)
VALUES
    ('user01', '000001', '$2a$12$ub7305gwTQ7KzdpTyrFv0u3aVaAYOSzR5eA9Qt4E3LPzIxQca3X2.'),
    ('user02', '000002', '$2a$12$N44I.FqavWmhfz5vLWos1eHx9N1/PdDSsXHn5jGViAWf5SBH64Nj.'),
    ('user03', '000003', '$2a$12$Q/T1s6.q6DyhNowb3iXNuOHObXxAVW7/t/2wzdQuG9IZ9Rq3GBCuu'),
    ('user04', '000004', '$2a$12$8r.l9ZvfhsAiAqfc9tPlPuzJD44jSveOzxlJHicwLsVCVlCI576ae'),
    ('user05', '000005', '$2a$12$4uEdsyuXBPicUg/p5wqiv.z6g7XmwIImoWZUnGRryCi1iOZKgG6.e');

create table roles (
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN'),
       ('ROLE_SUPER_ADMIN');

--CREATE TABLE users_roles (
--    user_id bigint not null references users (id),
--    role_id bigint not null references roles (id),
--    primary key (user_id, role_id)
--);
--
--insert into users_roles (user_id, role_id)
--values (1, 1),
--       (2, 2);

CREATE TABLE users_roles (
    user_id     bigint not null references users (id),
    role_id     bigint not null references roles (id),
    primary key (user_id, role_id)
);

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 1),
       (3, 1),
       (4, 2),
       (5, 2),
       (5, 3);

create table orders(
    id bigserial primary key,
    user_id bigint not null references users(id),
    total_price int not null,
    address varchar,
    phone varchar(255),
    created_at timestamp,
    updated_at timestamp
);

--CREATE TABLE IF NOT EXISTS orders (
--    id               bigserial PRIMARY KEY,
--    user_id          bigint not null references users (id),
--    --order_details_id bigint not null references order_details (id),
----    product_id     bigint not null references products (id),
----    product_number int not null,
--    created_at       timestamp default current_timestamp
--);

create table order_items(
                            id bigserial primary key,
                            product_id bigint not null references products(id),
                            quantity int not null,
                            order_id bigint not null references orders(id),
                            price_per_product int not null,
                            price int not null,
                            created_at timestamp,
                            updated_at timestamp
);

insert into orders (user_id, total_price, address, phone)
values (1, 200, 'address', '12345');

insert into order_items (product_id, order_id, quantity, price_per_product, price)
values (1, 1, 2, 100, 200);
