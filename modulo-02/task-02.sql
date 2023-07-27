-- Selecionar todos os países ordenados por nome decrescente;
SELECT nome FROM PAIS
ORDER BY nome DESC;

-- Selecionar logradouro e cep dos endereços. Porém, somente os logradouros que comecem com a letra ‘a’ (maiúsculo ou minúsculo);
SELECT logradouro, cep FROM ENDERECO 
WHERE logradouro LIKE 'A%' OR logradouro LIKE 'a%';

-- Selecionar todos os endereços que tenham cep com final ‘0’;..
 SELECT * FROM ENDERECO 
 WHERE cep LIKE '%0';

-- Selecionar todos os endereços que tenham números entre 1 e 100;
SELECT * FROM ENDERECO
WHERE numero BETWEEN 1 AND 100;

-- Selecionar todos os endereços que comecem por “RUA” e ordenar pelo cep de forma decrescente ;
SELECT * FROM ENDERECO 
WHERE logradouro LIKE 'Rua%' OR logradouro LIKE 'rua%'
ORDER BY cep DESC;

-- Selecionar a quantidade de endereços cadastrados na tabela;
SELECT COUNT(LOGRADOURO) FROM ENDERECO

-- Selecionar a quantidade de endereços cadastrados agrupados pelo id da cidade
SELECT COUNT(logradouro) FROM ENDERECO
GROUP BY id_cidade;



