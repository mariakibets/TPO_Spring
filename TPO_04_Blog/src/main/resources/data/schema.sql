CREATE TABLE IF NOT EXISTS Users (
                       user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(255) NOT NULL UNIQUE
);


CREATE TABLE  IF NOT EXISTS Roles (
                       role_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Users_Roles (
                             user_id BIGINT,
                             role_id BIGINT,
                             PRIMARY KEY (user_id, role_id),
                             FOREIGN KEY (user_id) REFERENCES Users(user_id),
                             FOREIGN KEY (role_id) REFERENCES Roles(role_id)
);


CREATE TABLE IF NOT EXISTS Blog (
                      blog_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      manager_user_id BIGINT,
                      FOREIGN KEY (manager_user_id) REFERENCES Users(user_id)
);

CREATE TABLE IF NOT EXISTS Article (
                         article_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         author_user_id BIGINT,
                         blog_blog_id BIGINT,
                         FOREIGN KEY (author_user_id) REFERENCES Users(user_id),
                         FOREIGN KEY (blog_blog_id) REFERENCES Blog(blog_id)
);
