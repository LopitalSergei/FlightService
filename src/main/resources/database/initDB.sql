CREATE TABLE IF NOT EXISTS planes
(
    plane_id        BIGSERIAL PRIMARY KEY,
    brand           VARCHAR(255) NOT NULL,
    model           VARCHAR(255) NOT NULL,
    plane_class     VARCHAR(255) NOT NULL,
    number_of_seats INT          NOT NULL
);

CREATE TABLE IF NOT EXISTS cities
(
    city_id         BIGSERIAL PRIMARY KEY,
    city_name       VARCHAR(255) NOT NULL,
    country         VARCHAR(255) NOT NULL,
    count_of_people INT          NOT NULL
);

CREATE TABLE IF NOT EXISTS Tours
(
    tour_id  BIGSERIAL PRIMARY KEY,
    plane_id INT,
    city_id  INT,
    CONSTRAINT fk_plane_id FOREIGN KEY (plane_id) REFERENCES planes (plane_id),
    CONSTRAINT fk_city_id FOREIGN KEY (city_id) REFERENCES cities (city_id)
);