create table department(
    id serial primary key,
    name text not null unique,
    note varchar,
    parent_department text
);