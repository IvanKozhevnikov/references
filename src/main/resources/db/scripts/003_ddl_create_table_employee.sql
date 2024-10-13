create table employee(
    id serial primary key,
    fullName text not null,
    department text not null,
    note varchar,
    employee_references_id int not null references reference (id)
);