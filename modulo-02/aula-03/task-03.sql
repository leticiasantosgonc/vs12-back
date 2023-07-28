-- Fazer um RIGHT JOIN entre tabelas Pessoa e Contato
SELECT *
FROM Pessoa p
RIGHT JOIN Contato c ON p.id_pessoa = c.id_contato;

-- Right Join entre Pessoa, PESSOA_X_PESSOA_ENDERECO e Endereco_Pessoa
SELECT ppe.id_pessoa, p.nome, ep.cidade, ep.pais
FROM Endereco_Pessoa ep
RIGHT JOIN PESSOA_X_PESSOA_ENDERECO ppe ON ep.id_endereco = ppe.id_endereco
RIGHT JOIN Pessoa p ON ppe.id_pessoa = p.id_pessoa;

-- Right Join entre todas as tabelas começando por Pessoa
SELECT ppe.id_pessoa, p.nome, ep.cidade, ep.pais, c.numero, c.descricao
FROM Endereco_Pessoa ep
RIGHT JOIN PESSOA_X_PESSOA_ENDERECO ppe ON ep.id_endereco = ppe.id_endereco
RIGHT JOIN Pessoa p ON ppe.id_pessoa = p.id_pessoa
RIGHT JOIN Contato c ON p.id_pessoa = c.id_pessoa;

-- Fazer um FULL JOIN entre tabelas Pessoa e Contato
SELECT *
FROM Pessoa p
FULL JOIN Contato c ON p.id_pessoa = c.id_contato;

-- Full Join entre Pessoa, PESSOA_X_PESSOA_ENDERECO e Endereco_Pessoa
SELECT *
FROM Endereco_Pessoa ep
FULL JOIN PESSOA_X_PESSOA_ENDERECO ppe ON ep.id_endereco = ppe.id_endereco
FULL JOIN Pessoa p ON ppe.id_pessoa = p.id_pessoa;

-- Full Join entre todas as tabelas começando por Pessoa
SELECT *
FROM Endereco_Pessoa ep
FULL JOIN PESSOA_X_PESSOA_ENDERECO ppe ON ep.id_endereco = ppe.id_endereco
FULL JOIN Pessoa p ON ppe.id_pessoa = p.id_pessoa
FULL JOIN Contato c ON p.id_pessoa = c.id_contato;

-- Utilizando o EXISTS, selecione as pessoas que tem endereço
SELECT p.nome
FROM PESSOA p
WHERE EXISTS (SELECT ep.id_endereco
 FROM ENDERECO_PESSOA ep 
 WHERE ep.id_endereco = p.ID_PESSOA)

-- Selecione id, nome da tabela pessoa junto com id, logradouro da tabela endereço
SELECT p.id_pessoa, p.nome FROM PESSOA p
UNION
SELECT ep.id_endereco, ep.logradouro FROM ENDERECO_PESSOA ep