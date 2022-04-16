CREATE SEQUENCE hibernate_sequence;

CREATE TABLE garden
(
    id       BIGSERIAL PRIMARY KEY,
    owner_id VARCHAR(36),
    name     VARCHAR(50),
    width    BIGINT,
    height   BIGINT
);

CREATE TABLE square
(
    id         BIGSERIAL PRIMARY KEY,
    position_x BIGINT,
    position_y BIGINT,
    garden_id  BIGINT REFERENCES garden (id),
    type       VARCHAR(20)
);

CREATE TABLE plant
(
    id                 BIGSERIAL PRIMARY KEY,
    name               VARCHAR(50),
    latin_name         TEXT,
    min_height_in_cm   INTEGER,
    max_height_in_cm   INTEGER,
    plantation_pattern VARCHAR(20),
    time_to_harvest    INTERVAL
);

CREATE TABLE plant_association
(
    first_plant_id  BIGINT,
    second_plant_id BIGINT,
    type            VARCHAR(20),
    constraint pk_plant_association primary key (first_plant_id, second_plant_id)
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


