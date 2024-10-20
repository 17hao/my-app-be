create table account
(
    id            bigint unsigned default 0,
    name          varchar(255)  not null default '',
    password_hash varchar(1024) not null default '',
    deleted       tinyint(1) not null default 0,
    primary key (id)
);
