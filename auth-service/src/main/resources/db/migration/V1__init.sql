
CREATE TABLE IF NOT EXISTS users (
    id         bigserial primary key,
    username   varchar(36) not null,
    phone_number      varchar(50) unique,
    password   varchar(80) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);
INSERT INTO users (username, phone_number, password)
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
