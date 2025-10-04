CREATE TABLE "office-digital".agenda (
    id UUID PRIMARY KEY,
    data DATE,
    horario TIME,
    tipo_compromisso VARCHAR(50),
    descricao_compromisso VARCHAR(255),
    numero_processo VARCHAR(255),
    data_hora_criacao TIMESTAMP,
    advogado_responsavel_id UUID,
    FOREIGN KEY (advogado_responsavel_id) REFERENCES "office-digital".advogado(id)
);