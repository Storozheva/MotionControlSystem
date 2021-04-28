DROP TABLE IF EXISTS stations CASCADE;
DROP TABLE IF EXISTS routes CASCADE;
DROP TABLE IF EXISTS train_stop_points CASCADE;
DROP TABLE IF EXISTS routes_with_train_stop_points CASCADE;

CREATE TABLE IF NOT EXISTS stations
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS train_stop_points
(
    id                       SERIAL PRIMARY KEY,
    station_id               BIGINT NOT NULL,
    arrival_time_in_minutes  BIGINT NOT NULL,
    dispatch_time_in_minutes BIGINT NOT NULL,
    stop_duration_in_minutes BIGINT NOT NULL,

    CONSTRAINT station_id_fk FOREIGN KEY (station_id) REFERENCES stations (id)
);


CREATE TABLE IF NOT EXISTS routes
(
    id                                  SERIAL PRIMARY KEY,
    name                                VARCHAR(100) NOT NULL,
    start_time_in_minutes_from_midnight BIGINT       NOT NULL,
    length_in_kilometers                REAL         NOT NULL,
    departure_point_id                  BIGINT       NOT NULL, -- FK
    destination_point_id                BIGINT       NOT NULL, -- FK

    CONSTRAINT departure_point_id_fk FOREIGN KEY (departure_point_id) REFERENCES stations (id),
    CONSTRAINT destination_point_id_fk FOREIGN KEY (destination_point_id) REFERENCES stations (id)
);

CREATE TABLE IF NOT EXISTS routes_with_train_stop_points
(
    route_id            BIGINT,
    train_stop_point_id BIGINT,

    CONSTRAINT route_id_fk FOREIGN KEY (route_id) REFERENCES routes (id),
    CONSTRAINT train_stop_point_id_fk FOREIGN KEY (train_stop_point_id) REFERENCES train_stop_points (id),
    CONSTRAINT routes_with_train_stop_points_id PRIMARY KEY (route_id, train_stop_point_id)
);

INSERT INTO stations (name) VALUES ('Test Station 1');
INSERT INTO stations (name) VALUES ('Test Station 2');
INSERT INTO stations (name) VALUES ('Test Station 3');
INSERT INTO stations (name) VALUES ('Test Station 4');
INSERT INTO stations (name) VALUES ('Test Station 5');
INSERT INTO stations (name) VALUES ('Test Station 6');
INSERT INTO stations (name) VALUES ('Test Station 7');
INSERT INTO stations (name) VALUES ('Test Station 8');
INSERT INTO stations (name) VALUES ('Test Station 9');
INSERT INTO stations (name) VALUES ('Test Station 10');
INSERT INTO stations (name) VALUES ('Test Station 11');
INSERT INTO stations (name) VALUES ('Test Station 12');

INSERT INTO train_stop_points (station_id, arrival_time_in_minutes, dispatch_time_in_minutes, stop_duration_in_minutes) VALUES
(
    1,
    5,
    10,
    5
);

INSERT INTO train_stop_points (station_id, arrival_time_in_minutes, dispatch_time_in_minutes, stop_duration_in_minutes) VALUES
(
    2,
    15,
    20,
    5
);

INSERT INTO train_stop_points (station_id, arrival_time_in_minutes, dispatch_time_in_minutes, stop_duration_in_minutes) VALUES
(
    3,
    25,
    30,
    5
);

insert into routes (name, start_time_in_minutes_from_midnight, length_in_kilometers, departure_point_id,
                    destination_point_id)
values (
           'Test Station 1 - Test Station 3',
           0,
           30.3,
           1,
           3
       );

INSERT INTO routes_with_train_stop_points (route_id, train_stop_point_id) VALUES (1, 1);
INSERT INTO routes_with_train_stop_points (route_id, train_stop_point_id) VALUES (1, 2);
INSERT INTO routes_with_train_stop_points (route_id, train_stop_point_id) VALUES (1, 3);
