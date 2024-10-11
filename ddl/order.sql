create table orders
(
    id         bigint unsigned not null default 0,
    creator    bigint unsigned not null,
    updater    bigint unsigned not null,
    createTime datetime not null default now(),
    updateTime datetime not null default now(),
    deleted    tinyint(1) not null default 0,
    amount     decimal(14, 2),
    primary key (id)
);
