--liquibase formatted sql

--changeset liquibase:25
CREATE TABLE work_card
(
    id               INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    planned_date     TIMESTAMP WITHOUT TIME ZONE,
    replacement_date TIMESTAMP WITHOUT TIME ZONE              NOT NULL,
    is_done           BOOLEAN                                  NOT NULL,
    aircraft_id      INTEGER                                  NOT NULL,
    component_id     INTEGER,
    CONSTRAINT pk_workcard PRIMARY KEY (id)
);

--changeset liquibase:26
ALTER TABLE work_card
    ADD CONSTRAINT FK_WORKCARD_ON_AIRCRAFT FOREIGN KEY (aircraft_id) REFERENCES aircraft (id);

--changeset liquibase:27
ALTER TABLE work_card
    ADD CONSTRAINT FK_WORKCARD_ON_COMPONENT FOREIGN KEY (component_id) REFERENCES component (id);

--changeset liquibase:28
INSERT INTO work_card (planned_date, replacement_date, is_done, aircraft_id, component_id)
VALUES ('01-04-2023', '03-04-2023', false, 1, 1),
 ('02-03-2023', '04-03-2023', false, 2, 1),
 ('03-05-2023', '03-05-2023', false, 1, 2)
