--liquibase formatted sql
--changeset Rtransat:1
CREATE TABLE IF NOT EXISTS actors
(
    uuid       uuid PRIMARY KEY,
    "name"     VARCHAR(255) NOT NULL,
    active     BOOLEAN      NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP    NULL DEFAULT NULL,
    UNIQUE (uuid)
);