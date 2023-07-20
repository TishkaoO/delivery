create table if not exists delivery.order_dish(
  order_dish_id serial primary key,
  fk_customer_id int references delivery.orders(order_id),
  fk_status_id int references delivery.dish(dish_id)
);