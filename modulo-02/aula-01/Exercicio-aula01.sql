CREATE TABLE VEM_SER.PESSOA (
  id_pessoa NUMBER NOT NULL,
  nome VARCHAR2(255) NOT NULL,
  data_nascimento DATE NOT NULL,
  telefone VARCHAR2(14),
  idade NUMBER(3) NOT NULL, 
  altura DECIMAL(4,2) NOT NULL,
  cpf CHAR(11) UNIQUE NOT NULL,
  PRIMARY KEY(id_pessoa)
);

INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf)
VALUES(1, 'Letícia Santos', TO_DATE('06-10-1996', 'dd-mm-yyyy'), '51980407433', 36, 1.58, '25836914745');

INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf)
VALUES(2, 'Miguel Machado', TO_DATE('01-01-1990', 'dd-mm-yyyy'), '51999999999', 30, 1.85, '12345678999');

INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf)
VALUES(3, 'Vitor Nunes', TO_DATE('20-07-1996', 'dd-mm-yyyy'), '73993462714', 27, 1.85, '02536947117');

INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf)
VALUES(4, 'Nix Pedrix', TO_DATE('04-07-2021', 'dd-mm-yyyy'), '51980407455', 2, 1.00, '25874136945');

SELECT * FROM VEM_SER.PESSOA;

UPDATE VEM_SER.PESSOA
SET idade = 27
WHERE id_pessoa = 1;

UPDATE VEM_SER.PESSOA
SET idade = 31
WHERE id_pessoa = 2;

UPDATE VEM_SER.PESSOA
SET idade = 28
WHERE id_pessoa = 3;

UPDATE VEM_SER.PESSOA
SET idade = 3
WHERE id_pessoa = 4;

DELETE FROM VEM_SER.PESSOA WHERE id_pessoa = 4;
