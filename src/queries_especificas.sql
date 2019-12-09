-- 3.1	Obter uma listagem, em ordem alfabética pelo autor de todas as publicações armazenadas no BD.
SELECT tituloPub, nome_autor FROM Publicacoes
	NATURAL JOIN Autores
	ORDER BY nome_autor;

-- 3.2	Obter uma listagem, em ordem alfabética pelo tema, de todas as publicações armazenadas no BD.
SELECT tituloPub, temaPub FROM Publicacoes
	ORDER BY temaPub;
	
-- 3.3	Obter uma listagem, em ordem alfabética pelo título, de todas as publicações armazenadas no BD.
SELECT tituloPub FROM Publicacoes
	ORDER BY tituloPub;
	
-- 3.4	Obter uma listagem dos ARTIGOS que constituem um ANAIS DE CONFERÊNCIA.
SELECT titulo_do_artigo FROM artigos_de_anais_de_conferencia
	WHERE titulo_do_congresso = tituloDoCongresso
	ORDER BY titulo_do_artigo;
	
-- 3.5	Obter uma listagem cronológica de todos os ARTIGOS que constituem os números de um PERIÓDICO,
--		dados um ano de inicio e um ano de fim.
SELECT titulo_do_artigo, titulo_do_periodico, ano_de_publicacao, mes_de_publicacao FROM artigos_de_periodicos
	WHERE titulo_do_periodico = tituloDoPeriodico
	AND ano_de_publicacao BETWEEN anoInicio AND anoFim
	ORDER BY ano_de_publicacao, mes_de_publicacao, titulo_do_artigo;
	
-- 3.6	Obter uma listagem cronológica das publicações de um dado autor.
SELECT tituloPub, ano_de_publicacao, mes_de_publicacao FROM Publicacoes
	NATURAL JOIN Autores_Publicacoes
	WHERE nome_autor = nomeDoAutor
	ORDER BY ano_de_publicacao, mes_de_publicacao, tituloPub;
	
-- 3.7	Obter uma listagem, em ordem alfabética do autor, das publicações referentes a um determinado tema.
SELECT tituloPub, nomeAutor FROM Publicacoes
	NATURAL JOIN Autores_Publicacoes
	WHERE temaPub = tema
	ORDER BY nome_autor;
	
-- 3.8	Obter o nome da pessoa a quem se emprestou uma determinada publicação.
SELECT nome_locatario FROM Emprestimos
	WHERE tituloPub = titulo
	AND data_devolucao = NULL;
	
-- 3.9	Obter a localização de uma determinada publicação de interesse.
SELECT * FROM Localizacao
	NATURAL JOIN Publicacoes
	WHERE tituloPub = titulo;