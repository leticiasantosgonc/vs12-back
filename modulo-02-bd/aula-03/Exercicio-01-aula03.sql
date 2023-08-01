-- Atualizar logradouro e o complemento dos enderecos com id 2 e 3

UPDATE ENDERECO 
SET 
	logradouro = 'Rua Alameda das Rosas',	
	complemento = 'Casa'
WHERE 
	id_endereco = 102 OR id_endereco = 103;
	
-- Atualizar o numero do endereco onde id é 4 para 999999
UPDATE ENDERECO 
SET 
	numero = 999999
WHERE 
	id_endereco = 104;

--Remover o último registro da tabela endereco (utlizando funcao max)
DELETE FROM ENDERECO
WHERE id_endereco = (SELECT MAX(id_endereco) FROM ENDERECO)

-- Remover o endereco onde o número é 999999
DELETE FROM ENDERECO 
WHERE numero=999999;

-- Remover 2 registros da tabela endereco
DELETE FROM ENDERECO 
WHERE id_endereco = 105 OR id_endereco = 106;
	