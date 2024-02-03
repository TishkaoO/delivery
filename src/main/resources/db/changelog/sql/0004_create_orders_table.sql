create table if not exists delivery.orders(
pk_order_id serial primary key,
fk_user_id int references delivery.users(pk_user_id)
);