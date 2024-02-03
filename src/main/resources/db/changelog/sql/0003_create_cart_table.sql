create table if not exists delivery.cart(
pk_cart_id serial primary key,
fk_user_id int references delivery.users(pk_user_id)
);