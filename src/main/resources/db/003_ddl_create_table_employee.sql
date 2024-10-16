create table employee(
    id serial primary key,
    fullName text,
    department text,
    note varchar,
    employee_references_id int references reference (id)
);