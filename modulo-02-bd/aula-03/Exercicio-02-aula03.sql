--Inner Join entre tabela Pessoa e Contato
SELECT *
FROM 
	PESSOA p 
INNER JOIN CONTATO c ON p.id_pessoa = c.id_contato;

-- Inner Join entre tabela Pessoa, Pessoa_x_Pessoa_x_Endereco e Endereco_Pessoa
SELECT p.nome, ppe.id_pessoa, ep.logradouro, ep.cidade, ep.estado, ep.pais
FROM 
    PESSOA p 
INNER JOIN PESSOA_X_PESSOA_ENDERECO ppe ON p.id_pessoa = ppe.id_pessoa
INNER JOIN ENDERECO_PESSOA ep ON ppe.id_pessoa = ep.id_endereco


-- Inner Join entre todas as tabelas começando por Pessoa
SELECT p.id_pessoa, p.nome, c.numero, ppe.id_endereco, ep.logradouro
FROM 
	PESSOA p
INNER JOIN CONTATO c ON p.id_pessoa = c.id_pessoa
INNER JOIN PESSOA_X_PESSOA_ENDERECO  ppe ON p.id_pessoa = ppe.id_pessoa
INNER JOIN ENDERECO_PESSOA ep ON ppe.id_endereco = ep.id_endereco

-- Left Join Entre tabela Pessoa e Contato
SELECT p.id_pessoa, c.id_contato
FROM PESSOA p 
LEFT JOIN CONTATO c ON p.id_pessoa = c.id_contato

-- Left Join entre tabela Pessoa, PESSOA_X_PESSOA_ENDERECO e Endereco_Pessoa
SELECT p.nome, ppe.id_pessoa, ep.logradouro, ep.cidade, ep.estado, ep.pais
FROM 
    PESSOA p 
LEFT JOIN PESSOA_X_PESSOA_ENDERECO ppe ON p.id_pessoa = ppe.id_pessoa
LEFT JOIN ENDERECO_PESSOA ep ON ppe.id_pessoa = ep.id_endereco

-- Left Join entre todas as tabelas começando por Pessoa
SELECT p.id_pessoa, p.nome, c.numero, ppe.id_endereco, ep.logradouro
FROM 
	PESSOA p
LEFT JOIN CONTATO c ON p.id_pessoa = c.id_pessoa
LEFT JOIN PESSOA_X_PESSOA_ENDERECO  ppe ON p.id_pessoa = ppe.id_pessoa
LEFT JOIN ENDERECO_PESSOA ep ON ppe.id_endereco = ep.id_endereco
