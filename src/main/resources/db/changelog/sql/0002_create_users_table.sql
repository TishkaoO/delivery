create table if not exists delivery.users(
pk_user_id serial primary key,
username varchar,
password varchar,
email varchar,
roles varchar
);