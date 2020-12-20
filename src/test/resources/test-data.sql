CREATE TABLE IF NOT EXISTS movie (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    minutes INT NOT NULL,
    genre VARCHAR(50) NOT NULL,
    director VARCHAR(50) NOT NULL,
);

insert into movie (name,minutes,genre,director) values
('Dark Knight',152,'ACTION','director1'),
('Memento',113,'THRILLER','director2'),
('Matrix',136,'ACTION','director1');