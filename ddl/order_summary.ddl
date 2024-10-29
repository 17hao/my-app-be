create table order_summary
(
    id          bigint unsigned not null,
    creator     bigint unsigned not null,
    updater     bigint unsigned not null,
    create_time datetime       not null,
    update_time datetime       not null,
    deleted     tinyint(1) not null,
    amount      decimal(14, 2) not null,
    primary key (id)
);
