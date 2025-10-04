CREATE TABLE advogado (
    id UUID PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    numero_oab VARCHAR(7) NOT NULL,
    estado_oab VARCHAR(2) NOT NULL,
    whatsapp VARCHAR(20),
    email VARCHAR(100)
);
