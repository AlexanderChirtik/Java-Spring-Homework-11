CREATE TABLE IF NOT EXISTS tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(150) NOT NULL,
    status VARCHAR(15) NOT NULL,
    date_time DATETIME
);