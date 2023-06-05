--liquibase formatted sql

--changeset liquibase:18
CREATE TABLE user_roles
(
    role_id                     INTEGER NOT NULL,
    user_id                     INTEGER NOT NULL,
    CONSTRAINT pk_user_roles    PRIMARY KEY (role_id, user_id)
);

--changeset liquibase:19
ALTER TABLE user_roles
    ADD CONSTRAINT fk_user_role_on_user FOREIGN KEY (user_id) REFERENCES users (id);

--changeset liquibase:20
ALTER TABLE user_roles
    ADD CONSTRAINT fk_user_role_on_role FOREIGN KEY (role_id) REFERENCES roles (id);

--changeset liquibase:21
INSERT INTO user_roles (role_id, user_id)
VALUES (1,1),
       (2,2),
       (3,3),
       (1,2),
       (1,3)