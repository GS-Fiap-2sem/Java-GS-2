INSERT INTO usuarios (nome, email, tipo) VALUES ('Joao Silva', 'joao@mail.com', 'aluno');
INSERT INTO usuarios (nome, email, tipo) VALUES ('Auto Pecas Ltda', 'contato@autop.com', 'empresa');

INSERT INTO vagas (id_empresa, titulo, descricao, localizacao, remuneracao) VALUES (2, 'Assistente de Oficina', 'Auxiliar em manutencao', 'Sao Paulo - SP', 120.0);
INSERT INTO vagas (id_empresa, titulo, descricao, localizacao, remuneracao) VALUES (2, 'Ajudante Eletricista', 'Servicos eletricos basicos', 'Sao Paulo - SP', 150.0);

INSERT INTO contratos (id_vaga, id_aluno, status, data_inicio) VALUES (1, 1, 'concluido', '2025-08-01');
