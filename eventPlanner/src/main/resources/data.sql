insert into categories (name)
values ('wedding'),
       ('disorganising');

insert into users (name, password, last_online, registration_date)
values ('Armin', 'titok', '2024-08-07', '2023-11-10'),
       ('Laci', 'titok', '2022-04-12', '2020-03-19');

insert into events (date_time, location, creator_id, description, title)
values ('2024-01-01', 'Budapest', 1, 'Lorem Ipsum', 'Annas wedding party');