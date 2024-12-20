CREATE DATABASE estoque;
USE estoque;
CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    quantidade INT NOT NULL,
    tipo VARCHAR(100) NOT NULL
);

SELECT * FROM produto