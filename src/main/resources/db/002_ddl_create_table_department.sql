create table department(
    id serial primary key,
    name text not null,
    note varchar,
    parent_department text
);