create table users
(
    id         bigint unsigned default 0,
    name       varchar(255) not null default '',
    age        int,
    city       varchar(255),
    phone_num  varchar(255),
    is_deleted tinyint(1) not null default 0,
    primary key (id),
    unique index uniq_phonenum(phone_num)
);
