INSERT INTO user (id, username, password, name, age) VALUES (1, 'waylau', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '老卫', 30);
INSERT INTO user (id, username, password, name, age)  VALUES (2, 'admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'Way Lau', 29);

INSERT INTO authority (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 1);
-- noinspection SqlNoDataSourceInspection

INSERT INTO user_authority (user_id, authority_id) VALUES (2, 2);