create table customer
(
    id         int primary key auto_increment not null,
    first_name varchar(32),
    last_name  varchar(32),
    email      varchar(64),
    phone      varchar(16)
);

CREATE TABLE location
(
    id      int primary key auto_increment not null,
    name    varchar(32),
    address varchar(128),
    open    datetime,
    close   datetime,
    mon     boolean,
    tue     boolean,
    wed     boolean,
    thu     boolean,
    fri     boolean,
    sat     boolean,
    sun     boolean
);

create table appointment
(
    id          int primary key auto_increment not null,
    location_id int                            not null,
    time        datetime,
    customer_id int                            not null,
    purpose     varchar(16),
    FOREIGN KEY (location_id) REFERENCES location (id),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

create table services
(
    id          int primary key auto_increment not null,
    location_id int                            not null,
    service     varchar(16),
    FOREIGN KEY (location_id) references location (id) ON DELETE CASCADE
)