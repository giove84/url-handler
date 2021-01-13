DROP TABLE IF EXISTS urls;

-- script for creating the urls table
CREATE TABLE urls (
  id INT AUTO_INCREMENT PRIMARY KEY,
  original_url VARCHAR(250) NOT NULL,
  short_url VARCHAR(30),
  creation_date DATE NOT NULL
);
