create table if not exists usr
(
    id         int8         not null,
    first_name varchar(100) not null,
    last_name  varchar(100) not null,
    age        int8         not null,
    primary key (id)
);