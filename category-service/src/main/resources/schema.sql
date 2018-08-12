DROP TABLE IF EXISTS categorie;
CREATE TABLE categorie (
    category_id BIGINT PRIMARY KEY auto_increment,
    category_name VARCHAR(128),
    description VARCHAR(256)
);

