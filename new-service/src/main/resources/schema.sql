DROP TABLE IF EXISTS news;
CREATE TABLE  news (
    news_id BIGINT PRIMARY KEY auto_increment,
    title VARCHAR(50),
    detail VARCHAR(256),
    author_id BIGINT,
    category_id BIGINT
);

