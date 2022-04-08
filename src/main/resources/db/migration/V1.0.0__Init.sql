CREATE SEQUENCE hibernate_sequence;

CREATE TABLE garden
(
    id     BIGSERIAL PRIMARY KEY,
    name   VARCHAR(50),
    width  BIGINT,
    height BIGINT
);

CREATE TABLE square
(
    id         BIGSERIAL PRIMARY KEY,
    position_x BIGINT,
    position_y BIGINT,
    garden_id  BIGINT REFERENCES garden (id)
);

CREATE TABLE plant
(
    id                 BIGSERIAL PRIMARY KEY,
    name               VARCHAR(50),
    plantation_pattern VARCHAR(20),
    time_to_harvest    INTERVAL
);

CREATE TABLE plantation
(
    id              BIGSERIAL PRIMARY KEY,
    square_id       BIGINT REFERENCES square (id),
    plant_id        BIGINT REFERENCES plant (id),
    planned_date    DATE,
    plantation_date DATE,
    harvest_date    DATE,
    type            VARCHAR(20)
);


