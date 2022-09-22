
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

create table orders(
    id bigserial primary key,
--    user_id bigint not null references users(id),
    username varchar(255) not null,
    total_price int not null,
    address varchar,
    phone varchar(255),
    created_at timestamp,
    updated_at timestamp
);

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

insert into orders (username, total_price, address, phone)
values ('user01', 200, 'address', '000001');

insert into order_items (product_id, order_id, quantity, price_per_product, price)
values (1, 1, 2, 100, 200);

