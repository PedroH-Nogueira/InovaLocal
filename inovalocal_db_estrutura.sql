DROP DATABASE IF EXISTS inovalocal_db;
CREATE DATABASE inovalocal_db;
USE inovalocal_db;

CREATE TABLE Comunidade (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  localizacao VARCHAR(100) NOT NULL,
  populacao INT NOT NULL,
  situacaoConectividade VARCHAR(50) NOT NULL
);

CREATE TABLE EquipamentoPLC (
  id INT PRIMARY KEY AUTO_INCREMENT,
  modelo VARCHAR(100) NOT NULL,
  fabricante VARCHAR(100) NOT NULL,
  capacidadeMbps INT NOT NULL,
  emUso BOOLEAN NOT NULL
);

CREATE TABLE PontoAcesso (
  id INT PRIMARY KEY AUTO_INCREMENT,
  idComunidade INT NOT NULL,
  local VARCHAR(100) NOT NULL,
  status VARCHAR(50) NOT NULL,
  bandaDisponivel DECIMAL(6,2) NOT NULL,
  CONSTRAINT fk_ponto_comunidade FOREIGN KEY (idComunidade) REFERENCES Comunidade(id)
);

INSERT INTO Comunidade (nome, localizacao, populacao, situacaoConectividade)
VALUES
('Cidadela', 'Av. José', 2110, 'Inativo'),
('Serra Verde', 'KM 12 - Zona Rural', 800, 'Ativo'),
('Boa Esperança', 'Distrito 2', 450, 'Precário');

INSERT INTO EquipamentoPLC (modelo, fabricante, capacidadeMbps, emUso)
VALUES
('PLC-1000', 'InovaTech', 300, TRUE),
('PowerLink X2', 'RuralNet', 500, FALSE);

INSERT INTO PontoAcesso (idComunidade, local, status, bandaDisponivel)
VALUES
(1, 'Escola Municipal', 'Ativo', 120.00),
(1, 'Posto de Saúde', 'Ativo', 80.00),
(2, 'Praça Central', 'Planejado', 0.00);

SELECT * FROM Comunidade;
SELECT * FROM PontoAcesso;
SELECT * FROM EquipamentoPLC;
