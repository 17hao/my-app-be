create table order_item
(
    id               bigint unsigned not null,
    order_summary_id bigint unsigned not null,
    quantity         int unsigned not null,
    unit_price       decimal(14, 2) not null,
    primary key (id)
);
