CREATE TABLE VEM_SER.ESTUDANTE (
    id NUMBER,
    nome VARCHAR2(200) NOT NULL,
    data_nascimento DATE NOT NULL,
    nr_matricula NUMBER(10) UNIQUE NOT NULL, 
    ativo CHAR(1),
    PRIMARY KEY(id)
);

CREATE SEQUENCE SEQ_ESTUDANTE
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Letícia Santos', TO_DATE('06-10-1996', 'dd-mm-yyyy'), '0000000001', 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Vitor Nunes', TO_DATE('20-07-1996', 'dd-mm-yyyy'), '0000000002', 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Valeria Santos', TO_DATE('13-11-1965', 'dd-mm-yyyy'), '0000000003', 'N');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Marli Santos', TO_DATE('16-02-1947', 'dd-mm-yyyy'), '0000000004', 'N');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Daniel Gonçalves', TO_DATE('18-08-1949', 'dd-mm-yyyy'), '0000000005', 'N');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Anne Schneider', TO_DATE('20-07-1996', 'dd-mm-yyyy'), '0000000006', 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Leonardo Rosa', TO_DATE('22-10-1996', 'dd-mm-yyyy'), '0000000007', 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Liliane Mulling', TO_DATE('13-05-1996', 'dd-mm-yyyy'), '0000000008', 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Marina Chaves', TO_DATE('23-11-1998', 'dd-mm-yyyy'), '0000000009', 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Olinda Colombo', TO_DATE('09-04-1947', 'dd-mm-yyyy'), '0000000010', 'N');

SELECT * FROM VEM_SER.ESTUDANTE;
