DROP TABLE IF EXISTS author;
CREATE TABLE author (
    author_id BIGINT PRIMARY KEY auto_increment,
    first_name VARCHAR(128),
    last_name VARCHAR(256)
);

