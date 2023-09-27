create table users
(
    id        bigint unsigned default 0,
    name      varchar(255) not null default '',
    age       int          not null default 0,
    city      varchar(255),
    phone_num varchar(255),
    extra     text,
    primary key (id),
    unique index uniq_phonenum(phone_num)
);
