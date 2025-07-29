CREATE TABLE usuario (
    id UUID PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    whatsapp VARCHAR(20),
    email VARCHAR(255) UNIQUE,
    data_hora_cadastro TIMESTAMP
);