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
)