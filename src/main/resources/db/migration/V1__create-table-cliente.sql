CREATE TABLE cliente(
  id SERIAL PRIMARY KEY,
  nome TEXT NOT NULL,
  bairro TEXT NOT NULL,
  cep TEXT NOT NULL,
  rua TEXT NOT NULL,
  complemento TEXT NOT NULL
);