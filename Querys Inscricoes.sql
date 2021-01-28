-- Pontuar todos os Candidatos

CREATE OR REPLACE FUNCTION pontuar(numeric,numeric,numeric)
	RETURNS integer AS
		$body$
			DECLARE pontuar INTEGER;
				BEGIN
				RAISE NOTICE 'Nesta função os parametros não são nomeados';
				pontuar:=($1+$2)*$3;
				RETURN(pontuar);
				END;
		$body$
	LANGUAGE 'plpgsql';

UPDATE public.tbcandidato
   SET can_pontuacao=(SELECT * FROM pontuar(can_notaport,can_notamat,can_freq));

-- Pré-Classificar todos os Candidatos
CREATE SEQUENCE 'seq_preclassificacao'
BEGIN WORK;

UPDATE public.tbcandidato SET can_preclassificacao= NEXTVAL('seq_preclassificacao') ORDER BY can_pontuacao DESC;

SELECT * FROM tbcandidato ORDER BY can_pontuacao DESC;

	--ROLLBACK/COMMIT WORK;

-- Listar os 500 Candidatos melhor pré-classificado

SELECT * FROM tbcandidato ORDER BY can_pontuacao DESC LIMIT 500;

-- Inserir Nota do Questionario

UPDATE public.tbcandidato
   SET can_questionario=?
 WHERE <condition>;


-- Pontuar os 500 Candidatos melhor pré-classificado

-- Classificar todos os Candidatos

-- Retornar os 500 candidatos mais pontuados

-- Atualizar dados dos Candidatos

--Util
UPDATE public.tbcandidato
   SET can_id=?, can_inscricao=?, can_nome=?, can_endereco=?, can_numero=?, 
       can_bairro=?, can_cep=?, can_rg=?, can_pontoref=?, can_telefone1=?, 
       can_telefone2=?, can_telefone3=?, can_datanasc=?, can_sexo=?, 
       can_naturalidade=?, can_escola=?, can_nomepai=?, can_nomemae=?, 
       can_renda=?, can_notaport=?, can_notamat=?, can_freq=?, can_pontuacao=?, 
       can_questionario=?, can_preclassificacao=?, can_classificacao=?
 WHERE <condition>;

 SELECT can_id, can_inscricao, can_nome, can_endereco, can_numero, can_bairro, 
       can_cep, can_rg, can_pontoref, can_telefone1, can_telefone2, 
       can_telefone3, can_datanasc, can_sexo, can_naturalidade, can_escola, 
       can_nomepai, can_nomemae, can_renda, can_notaport, can_notamat, 
       can_freq, can_pontuacao, can_questionario, can_preclassificacao, 
       can_classificacao
  FROM public.tbcandidato;