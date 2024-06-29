CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data TIMESTAMP,
    status BOOLEAN NOT NULL,
    usuario_id BIGINT,
    curso_id BIGINT,
    FOREIGN KEY (id) REFERENCES usuarios(id),
    FOREIGN KEY (id) REFERENCES cursos(id)
);