CREATE TABLE Enderecos_De_Publicacao (
	id_endereco_publicacao INT NOT NULL CHECK (id_endereco_publicacao >= 0),
    pais VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    logradouro VARCHAR(50) NOT NULL,
	numero INT NOT NULL,
	complemento VARCHAR(50) NOT NULL,
    cep INT NOT NULL,
	
	PRIMARY KEY (id_endereco_publicacao)
);

CREATE TABLE Localizacoes (
	id_localizacao INT NOT NULL CHECK (id_localizacao >= 0),
    id_meio_fisico_digital CHAR(1) NOT NULL CHECK (id_meio_fisico_digital = 'F' 
												OR id_meio_fisico_digital = 'D' 
												OR id_meio_fisico_digital = 'A'),
	descritivo_localizacao VARCHAR(350) NOT NULL,
	observacoes_localizacao VARCHAR(50),
	
    PRIMARY KEY (id_localizacao),
);

CREATE TABLE Publicacoes (
	id_publicacao INT NOT NULL CHECK (id_publicacao >= 0),
    id_localizacao INT NOT NULL,
	id_endereco_publicacao INT NOT NULL,
	id_autor INT NOT NULL,
	editora_publicacao VARCHAR(50) NOT NULL,
	tema_publicacao VARCHAR(50) NOT NULL,
	
	PRIMARY KEY (id_publicacao),
	FOREIGN KEY (id_localizacao) REFERENCES Localizacoes(id_localizacao),
	FOREIGN KEY (id_endereco_publicacao) REFERENCES Enderecos_De_Publicacao(id_endereco_publicacao),
	FOREIGN KEY (id_autor) REFERENCES autores(id_autor)
);

CREATE TABLE Monografias (
	id_monografia INT NOT NULL CHECK (id_monografia >= 0),
	id_publicacao INT NOT NULL,
    titulo_da_monografia VARCHAR(50) NOT NULL,
    nome_instituicao VARCHAR(50) NOT NULL,
    data_publicacao DATE NOT NULL,
 
    PRIMARY KEY (id_monografia),
    FOREIGN KEY (id_publicacao) REFERENCES Publicacoes(id_publicacao),
);

CREATE TABLE Livros (
	id_livro INT NOT NULL CHECK (id_livro >= 0),
	id_publicacao INT NOT NULL,
	titulo_do_livro VARCHAR(100) NOT NULL,
	numero_edicao INT NOT NULL,
	data_publicacao DATE NOT NULL,
	titulo_original VARCHAR(50),
	numero_paginas INT,
	
	PRIMARY KEY (id_livro),
	FOREIGN KEY (id_publicacao) REFERENCES Publicacoes(id_publicacao)
);

CREATE TABLE Artigos_De_Livro (
	id_artigo_de_livro INT NOT NULL CHECK(id_artigo_de_livro >= 0),
	id_publicacao INT NOT NULL,
	id_livro INT NOT NULL,
	data_publicacao DATE NOT NULL,
	numero_edicao SMALLINT NOT NULL,
	pagina_inicial_no_livro SMALLINT NOT NULL,
	pagina_final_no_livro SMALLINT NOT NULL,
	numero_do_capitulo_no_livro SMALLINT NOT NULL,
	
	PRIMARY KEY (id_artigo_de_livro),
	FOREIGN KEY (id_publicacao) REFERENCES Publicacoes(id_publicacao),
	FOREIGN KEY (id_livro) REFERENCES Livros(id_livro)
);

CREATE TABLE Autores_Publicacoes{
	id_publicacao INT NOT NULL,
	id_autor INT NOT NULL,
	
	PRIMARY KEY (id_publicacao, id_autor),
	FOREIGN KEY (id_publicacao) REFERENCES Publicacoes(id_publicacao),
	FOREIGN KEY (id_autor) REFERENCES Autores(id_autor)
};

CREATE TABLE Autores{
	id_autor INT NOT NULL CHECK (id_autor >= 0),
	nome_autor VARCHAR(50) NOT NULL,
	
	PRIMARY KEY (id_autor)	
};

CREATE TABLE Anais_De_Conferencia (
	id_anal_de_conferencia INT NOT NULL CHECK (id_anal_de_conferencia >= 0),
	titulo_do_congresso VARCHAR(100) NOT NULL,
	data_congresso DATE NOT NULL,
	
	PRIMARY KEY(id_anal_de_conferencia)
);

CREATE TABLE Artigos_De_Anais_De_Conferencia (
	id_artigo_anal_de_conferencia INT NOT NULL CHECK(id_artigo_anal_de_conferencia >= 0),
	id_publicacao INT NOT NULL,
	id_anal_de_conferencia INT NOT NULL,
	volume_publicacao SMALLINT NOT NULL,
	numero_publicacao SMALLINT NOT NULL,
	data_publicacao DATE NOT NULL,
	pagina_inicial SMALLINT NOT NULL,
	pagina_final SMALLINT NOT NULL,	
	
	PRIMARY KEY (id_artigo_anal_de_conferencia),
    FOREIGN KEY (id_publicacao) REFERENCES Publicacoes(id_publicacao),
    FOREIGN KEY (id_anal_de_conferencia) REFERENCES Anais_De_Conferencia(id_anal_de_conferencia)
);

CREATE TABLE Periodicos (
	id_periodico INT NOT NULL CHECK (id_periodico >= 0),
	titulo_periodico VARCHAR(100) NOT NULL,
	data_primeiro_volume DATE NOT NULL,
    data_ultimo_volume DATE,
	
	PRIMARY KEY (id_periodico)
);

CREATE TABLE Artigos_De_Periodico (
	id_artigo_de_periodico INT NOT NULL CHECK (id_artigo_de_periodico >= 0),
	id_periodico INT NOT NULL,
	id_publicacao INT NOT NULL,
	titulo_do_artigo VARCHAR(100) NOT NULL,
	numero_volume SMALLINT NOT NULL,
	data_publicacao DATE NOT NULL,
	pagina_inicial SMALLINT NOT NULL,
	pagina_final SMALLINT NOT NULL,	
	
	PRIMARY KEY (id_artigo_de_periodico),
    FOREIGN KEY (id_publicacao) REFERENCES Publicacoes(id_publicacao),
    FOREIGN KEY (id_periodico) REFERENCES Periodicos(id_periodico)
);