    create table if not exists delivery.statistic(
        statistic_id serial primary key,
        count bigint,
        fk_dish_id int references delivery.dish(dish_id)
    );