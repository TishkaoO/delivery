create table if not exists delivery.orders(
   order_id serial primary key,
   number_of_order varchar not null unique,
   created_date timestamp,
   fk_customer_id int references delivery.customer(customer_id),
   fk_status_id int references delivery.status(status_id)
);