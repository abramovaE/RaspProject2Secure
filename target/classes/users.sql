CREATE TABLE `RadioRasp`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL
)
  ENGINE InnoDB;


CREATE TABLE `RadioRasp`.`roles` (
  `id`   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

CREATE TABLE `RadioRasp`.`user_roles` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id),
  UNIQUE (user_id, role_id)
)
ENGINE = InnoDB;

INSERT INTO users VALUES (1, "abramova", "12345");
INSERT INTO roles VALUES (1, "role_user");
INSERT INTO roles VALUES (2, "role_admin");

INSERT INTO user_roles VALUES (1, 2);