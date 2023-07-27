CREATE TABLE VEM_SER.PAIS (
    id_pais NUMBER(38,0) NOT NULL,
    nome VARCHAR2(50) NOT NULL,
    CONSTRAINT PK_PAIS PRIMARY KEY (id_pais)
);

CREATE TABLE VEM_SER.ESTADO(
	id_estado NUMBER(38,0) NOT NULL,
	id_pais NUMBER(38,0) NOT NULL, 
	nome VARCHAR2(50) NOT NULL,
	CONSTRAINT PK_ESTADO PRIMARY KEY (id_estado),
	CONSTRAINT FK_PAIS FOREIGN KEY (id_pais) REFERENCES PAIS(id_pais)
);

CREATE TABLE VEM_SER.CIDADE(
	id_cidade NUMBER(38,0) NOT NULL,
	id_estado NUMBER(38,0) NOT NULL, 
	nome VARCHAR2(50) NOT NULL,
	CONSTRAINT PK_CIDADE PRIMARY KEY (id_cidade, id_estado),
	CONSTRAINT FK_ESTADO FOREIGN KEY (id_estado) REFERENCES ESTADO(id_estado)
);

CREATE TABLE VEM_SER.BAIRRO(
	id_bairro NUMBER(38,0) NOT NULL,
	id_cidade NUMBER(38,0) NOT NULL, 
	id_estado NUMBER(38,0) NOT NULL,
	nome VARCHAR2(50) NOT NULL,
	CONSTRAINT PK_BAIRRO PRIMARY KEY (id_bairro, id_cidade),
	CONSTRAINT FK_CIDADE FOREIGN KEY (id_cidade, id_estado) REFERENCES CIDADE(id_cidade, id_estado)
);

CREATE TABLE VEM_SER.ENDERECO(
	id_endereco NUMBER(38,0) NOT NULL,
	id_bairro NUMBER(38,0) NOT NULL,
	id_cidade NUMBER(38,0) NOT NULL, 
	logradouro VARCHAR2(255) NOT NULL,
	numero NUMBER(38,0) NOT NULL,
	complemento VARCHAR2(100) NOT NULL,
	cep CHAR(9) NOT NULL,
	CONSTRAINT PK_ENDERECO PRIMARY KEY (id_endereco),
	CONSTRAINT FK_BAIRRO FOREIGN KEY (id_bairro, id_cidade) REFERENCES BAIRRO(id_bairro, id_cidade)
);

CREATE SEQUENCE SEQ_PAIS
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
CREATE SEQUENCE SEQ_ESTADO
 START WITH     10
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
CREATE SEQUENCE SEQ_CIDADE
 START WITH     20
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
CREATE SEQUENCE SEQ_BAIRRO
 START WITH     30
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
CREATE SEQUENCE SEQ_ENDERECO
 START WITH     100
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

INSERT INTO VEM_SER.PAIS (id_pais, nome)
VALUES(SEQ_PAIS.nextval, 'Brasil');

INSERT INTO VEM_SER.PAIS (id_pais, nome)
VALUES(SEQ_PAIS.nextval, 'Japão');

INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome)
VALUES(SEQ_ESTADO.nextval, '1', 'RS');

INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome)
VALUES(SEQ_ESTADO.nextval, '1', 'SC');

INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome)
VALUES(SEQ_ESTADO.nextval, '2', 'Kanto');

INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome)
VALUES(SEQ_ESTADO.nextval, '2', 'Chubu');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES(SEQ_CIDADE.nextval, '10', 'Capão da Canoa');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES(SEQ_CIDADE.nextval, '10', 'Osório');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES(SEQ_CIDADE.nextval, '11', 'Criciuma');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES(SEQ_CIDADE.nextval, '11', 'Florianópolis');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES(SEQ_CIDADE.nextval, '12', 'Saitama');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES(SEQ_CIDADE.nextval, '12', 'Chiba');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES(SEQ_CIDADE.nextval, '13', 'Nagano');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES(SEQ_CIDADE.nextval, '13', 'Shizuoka');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '20', '10', 'Zona Nova');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '20', '10', 'Centro');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '21', '10', 'Sulbrasileiro');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '21', '10', 'Laranjeiras');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '22', '11', 'Figueirinha');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '22', '11', 'Zona Sul');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '23', '11', 'Zona Norte');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '23', '11', 'Atlântida');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '24', '12', 'Shibuya');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '24', '12', 'Akihabara');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '25', '12', 'Ikebukuro');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '25', '12', 'Shinjuku');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '26', '13', 'Nakano');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '26', '13', 'Roppongi');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '27', '13', 'Ginza');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES(SEQ_BAIRRO.nextval, '27', '13', 'Ueno');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '30', '20', 'Rua 1', SEQ_PAIS.nextval, 'casa', '1000');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '30', '20', 'Rua 2', SEQ_PAIS.nextval, 'apto', '1001');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '31', '20', 'Rua 3', SEQ_PAIS.nextval, 'casa', '1002');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '31', '20', 'Rua 2', SEQ_PAIS.nextval, 'casa', '1002');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '34', '21', 'Rua 2', SEQ_PAIS.nextval, 'casa', '1009');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '34', '21', 'Rua x', SEQ_PAIS.nextval, 'apto', 'x');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '35', '21', 'Rua k', SEQ_PAIS.nextval, 'apto', 'k');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '35', '21', 'Rua j', SEQ_PAIS.nextval, 'apto', 'j');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '36', '22', 'Rua 7', SEQ_PAIS.nextval, 'loja', '7');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '36', '22', 'Rua 8', SEQ_PAIS.nextval, 'loja', '8');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '37', '22', 'Rua 10', SEQ_PAIS.nextval, 'loja', '7');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '37', '22', 'Rua 10', SEQ_PAIS.nextval, 'loja', 'k');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '38', '23', 'Rua 12', SEQ_PAIS.nextval, 'loja', 'aa');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '38', '23', 'Rua 12', SEQ_PAIS.nextval, 'loja', 'm');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '39', '23', 'Rua 12', SEQ_PAIS.nextval, 'loja', 'm');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '39', '23', 'Rua hg', SEQ_PAIS.nextval, 'casa', 'hg');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '39', '23', 'Rua nove', SEQ_PAIS.nextval, 'casa', '700');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '40', '24', 'Sakura', SEQ_PAIS.nextval, 'lote', '1');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '40', '24', 'Naruto', SEQ_PAIS.nextval, 'lote', '2');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '41', '24', 'Sasuke', SEQ_PAIS.nextval, 'lote', '3');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '41', '24', 'Tanjiro', SEQ_PAIS.nextval, 'lote', '4');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '42', '25', 'Hinata', SEQ_PAIS.nextval, 'lote', '5');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '42', '25', 'Nezuko', SEQ_PAIS.nextval, 'lote', '6');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '43', '25', 'Kakashi', SEQ_PAIS.nextval, 'lote', '7');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '43', '25', 'Asta', SEQ_PAIS.nextval, 'lote', '8');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '44', '26', 'Kimimaru', SEQ_PAIS.nextval, 'lote', '9');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '44', '26', 'RockLee', SEQ_PAIS.nextval, 'lote', '10');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '45', '26', 'Gaara', SEQ_PAIS.nextval, 'lote', '11');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '45', '26', 'Orochimaru', SEQ_PAIS.nextval, 'lote', '12');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '46', '27', 'Jiraiya', SEQ_PAIS.nextval, 'lote', '13');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '46', '27', 'Minato', SEQ_PAIS.nextval, 'lote', '14');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '47', '27', 'Konohamaru', SEQ_PAIS.nextval, 'lote', '15');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES(SEQ_ENDERECO.nextval, '47', '27', 'Tsunade', SEQ_PAIS.nextval, 'lote', '16');


