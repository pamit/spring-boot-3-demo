DROP TABLE IF EXISTS courses;

CREATE TABLE courses
(
    id bigint not null,
    title varchar(255) not null,
    author varchar(255) not null,
    primary key (id)
);
