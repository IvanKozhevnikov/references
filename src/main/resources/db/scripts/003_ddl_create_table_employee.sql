create table employee(
    id serial primary key,
    fullName text not null,
    profession text not null,
    department text not null,
    note varchar
);