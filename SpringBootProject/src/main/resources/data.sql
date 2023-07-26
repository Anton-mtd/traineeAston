CREATE TABLE IF NOT EXISTS addresses (id bigserial, street VARCHAR(150), number int, PRIMARY KEY (id));
INSERT INTO addresses (street, number) VALUES ('Пушкина', 75), ('Кулакова', 8), ('Серова', 17), ('Мира', 10), ('Ленина', 22);


CREATE TABLE IF NOT EXISTS ratings (id bigserial, title VARCHAR(150), PRIMARY KEY (id));
INSERT INTO ratings (title) VALUES('12+'), ('16+'), ('10+');


CREATE TABLE IF NOT EXISTS movies (id bigserial, title VARCHAR(150), rating_id INT, PRIMARY KEY (id), foreign key (rating_id) references ratings (id));
INSERT INTO movies (title, rating_id) VALUES('inception', 2), ('the batman', 1), ('puss in boots', 3), ('top gun: Maverick', 2), ('vendetta', 2), ('spider man', 3), ('стражи галактики:3', 1), ('Флеш', 1), ('Челюсти', 2), ('Алладин', 3);


CREATE TABLE IF NOT EXISTS cinemas (id bigserial, title VARCHAR(150), address_id INT, PRIMARY KEY (id), foreign key (address_id) references addresses (id));
INSERT INTO cinemas (title, address_id) VALUES('stars', 1), ('movie', 2), ('sky', 3), ('blockA', 4), ('space', 5);


CREATE TABLE IF NOT EXISTS cinemas_movies (id bigserial, cinema_id INT, movie_id INT, PRIMARY KEY (id), foreign key (cinema_id) references cinemas (id), foreign key (movie_id) references movies (id));
INSERT INTO cinemas_movies (cinema_id, movie_id) VALUES(1, 3), (1, 2), (1, 4), (2, 2), (2, 1), (2, 5), (2, 10), (3, 8), (3, 1), (3, 7), (3, 9), (4, 1), (4, 2), (4, 3), (4, 6), (5, 3), (5, 10), (5, 2), (5, 7), (5, 5);


