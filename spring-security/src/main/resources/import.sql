INSERT INTO user (id, username, password, name, age)
VALUES (1, 'waylau', '$2a$10$4gIaDSGLiNgkUViXa1UcheeWKyeKOJBlGj4DY1ltjfCXNYZam2a0C', '老卫', 30);
INSERT INTO user (id, username, password, name, age)
VALUES (2, 'admin', '$2a$10$4gIaDSGLiNgkUViXa1UcheeWKyeKOJBlGj4DY1ltjfCXNYZam2a0C', 'Way Lau', 29);

INSERT INTO authority (id, name)
VALUES (1, 'ROLE_USER');
INSERT INTO authority (id, name)
VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_authority (user_id, authority_id)
VALUES (1, 1);
INSERT INTO user_authority (user_id, authority_id)
VALUES (2, 1);
-- noinspection SqlNoDataSourceInspection

INSERT INTO user_authority (user_id, authority_id)
VALUES (2, 2);

CREATE TABLE IF NOT EXISTS persistent_logins
(
  username  varchar(64) not null,
  series    varchar(64) not null,
  token     varchar(64) not null,
  last_used timestamp   not null,
  PRIMARY KEY (series)
);