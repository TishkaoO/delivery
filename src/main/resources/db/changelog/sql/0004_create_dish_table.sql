create table if not exists delivery.dish(
    pk_dish_id serial primary key,
    name varchar not null,
    description varchar,
    price double precision not null,
    is_stock boolean not null,
    fk_category_id int references delivery.category(pk_category_id),
    fk_order_id int references delivery.orders(pk_order_id)
);