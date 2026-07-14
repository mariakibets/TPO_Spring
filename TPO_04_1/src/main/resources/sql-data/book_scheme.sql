CREATE TABLE IF NOT EXISTS "author" (
    "id" INT AUTO_INCREMENT PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS "Publisher" (
    "idPublisher" BIGINT AUTO_INCREMENT PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS "Book" (
    "idBook" BIGINT AUTO_INCREMENT PRIMARY KEY,
    "title" VARCHAR(255) NOT NULL,
    "price" DOUBLE NOT NULL,
    "publisher_id" BIGINT,
    FOREIGN KEY ("publisher_id") REFERENCES "Publisher"("idPublisher") ON DELETE SET NULL
    );

CREATE TABLE IF NOT EXISTS "book_author" (
    "book_id" INT,
    "author_id" INT,
    FOREIGN KEY ("book_id") REFERENCES "Book"("idBook"),
    FOREIGN KEY ("author_id") REFERENCES "author"("id"),
    PRIMARY KEY ("book_id", "author_id")
    );
