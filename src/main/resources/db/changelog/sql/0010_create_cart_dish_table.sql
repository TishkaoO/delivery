create table if not exists delivery.cart_dish(
cart_dish_ serial primary key,
cart_id int references delivery.cart(pk_cart_id),
dish_id int references delivery.dish(pk_dish_id)
);