CREATE TABLE IF NOT EXISTS light
(
    id    serial PRIMARY KEY,
    lamp  text,
    state text
);

INSERT INTO light(lamp, state)
VALUES ('red', 'on'),
       ('green', 'off');
