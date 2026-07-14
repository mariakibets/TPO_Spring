CREATE TABLE IF NOT EXISTS publisher (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS author (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS book (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    title VARCHAR(255) NOT NULL,
                                    price DOUBLE NOT NULL,
                                    publisher_id BIGINT,
                                    FOREIGN KEY (publisher_id) REFERENCES publisher(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS author_books (
                                            book_id BIGINT,
                                            author_id BIGINT,
                                            FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE,
                                            FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE,
                                            PRIMARY KEY (book_id, author_id)
);
