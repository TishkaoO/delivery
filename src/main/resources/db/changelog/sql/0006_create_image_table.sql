create table if not exists delivery.image(
    pk_image_id serial primary key,
    url varchar,
    fk_dish_id int references delivery.dish(pk_dish_id)
);