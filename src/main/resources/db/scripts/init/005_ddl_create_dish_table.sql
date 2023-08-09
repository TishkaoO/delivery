create table if not exists delivery.dish(
    dish_id serial primary key,
    name varchar not null,
    description varchar,
    price numeric(10,2) not null,
    is_stock boolean not null
);