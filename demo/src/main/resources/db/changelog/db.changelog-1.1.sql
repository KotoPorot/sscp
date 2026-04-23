--changeset rodionov:1
            INSERT INTO my_app_schema.users (username, password) VALUES ('admin', '{noop}admin123');
            INSERT INTO my_app_schema.users (username, password) VALUES ('user_kiel', '{noop}kiel2026');
            INSERT INTO my_app_schema.users (username, password) VALUES ('dev_ivan', '{noop}pass123');
            INSERT INTO my_app_schema.users (username, password) VALUES ('manager', '{noop}man789');
            INSERT INTO my_app_schema.users (username, password) VALUES ('guest', '{noop}guest');


            INSERT INTO my_app_schema.test_entity (name, age) VALUES ('Max Mustermann', 25);
            INSERT INTO my_app_schema.test_entity (name, age) VALUES ('Anna Schmidt', 30);
            INSERT INTO my_app_schema.test_entity (name, age) VALUES ('Olaf Scholz', 45);
            INSERT INTO my_app_schema.test_entity (name, age) VALUES ('Klaus Weber', 22);
            INSERT INTO my_app_schema.test_entity (name, age) VALUES ('Elena Becker', 28);


            INSERT INTO my_app_schema.test_entity_hobby (test_entity_id, hobby) VALUES (1, 'Java Development');
            INSERT INTO my_app_schema.test_entity_hobby (test_entity_id, hobby) VALUES (2, 'Vinyl Records');
            INSERT INTO my_app_schema.test_entity_hobby (test_entity_id, hobby) VALUES (3, 'Football');
            INSERT INTO my_app_schema.test_entity_hobby (test_entity_id, hobby) VALUES (4, 'Cooking');
            INSERT INTO my_app_schema.test_entity_hobby (test_entity_id, hobby) VALUES (5, 'Travel');


            INSERT INTO my_app_schema.clients (id, first_name, last_name, city, date, age) VALUES (101, 'Tim', 'Rodionov', 'Kiel', '2026-03-07', 27);
            INSERT INTO my_app_schema.clients (id, first_name, last_name, city, date, age) VALUES (102, 'Artem', 'Petrov', 'Hamburg', '2026-02-15', 31);
            INSERT INTO my_app_schema.clients (id, first_name, last_name, city, date, age) VALUES (103, 'Julia', 'Wagner', 'Berlin', '2026-01-10', 24);
            INSERT INTO my_app_schema.clients (id, first_name, last_name, city, date, age) VALUES (104, 'Dmitry', 'Sokolov', 'Munich', '2025-12-01', 40);
            INSERT INTO my_app_schema.clients (id, first_name, last_name, city, date, age) VALUES (105, 'Sophie', 'Müller', 'Lübeck', '2026-03-01', 29);