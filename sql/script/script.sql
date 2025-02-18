CREATE TABLE pessoas (
    id SERIAL,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    sexo VARCHAR(9),
    dataNasc VARCHAR(10),
    telefone VARCHAR(11) NOT NULL,
    rua VARCHAR(255) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    pessoaRole VARCHAR(5) NOT NULL,
    constraint pk_pessoas primary key(id)
);

CREATE TABLE produtos(
	id SERIAL,
	nome VARCHAR(200) NOT NULL,
	preco double precision NOT NULL,
	qtd INT NOT NULL,
	categoria VARCHAR(50) NOT NULL,
	descricao VARCHAR(500),
	constraint pk_produtos primary key(id)
);


CREATE TABLE vendas(idPessoa integer NOT NULL, valorTotal double precision NOT NULL, dataVenda VARCHAR(10));

CREATE TABLE compras(idCompra SERIAL, idProduto integer NOT NULL, numeroNF bigint NOT NULL, quantidade integer NOT NULL, primary key(idCompra), constraint fk_produtos FOREIGN KEY(idProduto) REFERENCES produtos(id));

SELECT * FROM vendas INNER JOIN pessoas ON pessoas.id = idPessoa;