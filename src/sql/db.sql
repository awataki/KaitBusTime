create table time_table
(
    id        int auto_increment,
    hour      int not null,
    minutes   int not null,
    weekday   int not null,
    type      int not null,
    from      int not null,
    `to`      int not null,
    direction int null,
    constraint time_table_pk
        primary key (id)
);

