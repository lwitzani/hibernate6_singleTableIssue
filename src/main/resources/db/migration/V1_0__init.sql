CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS person
(
    id   BIGINT NOT NULL PRIMARY KEY,
    name TEXT   NOT NULL
);

CREATE TABLE IF NOT EXISTS body_part
(
    id            BIGINT NOT NULL PRIMARY KEY,
    person_id     BIGINT REFERENCES person,
    name          TEXT   NOT NULL,
    discriminator TEXT   NOT NULL
);