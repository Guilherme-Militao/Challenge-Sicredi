--TABLES
CREATE TABLE ASSOCIADO(
	ID_ASSOCIADO NUMBER(10,0),
	CPF VARCHAR2(11)NOT NULL UNIQUE,
	EMAIL VARCHAR2(50) NOT NULL,
	NOME VARCHAR2(50) NOT NULL,
	PRIMARY KEY (ID_ASSOCIADO)
	
);
--DROP TABLE ASSOCIADO;

CREATE TABLE PAUTA(
	ID_PAUTA NUMBER(10),
	TITULO VARCHAR2(50) NOT NULL,
	DESCRICAO VARCHAR2(250) NOT NULL,
	PRIMARY KEY(ID_PAUTA)
);
--DROP TABLE PAUTA;


CREATE TABLE SESSAO(
	ID_SESSAO NUMBER(10),
	ID_PAUTA NUMBER(10) UNIQUE,
	INICIO_DATE TIMESTAMP,
	TEMPO_DURACAO NUMBER(10),
	FINAL_DATE TIMESTAMP,
	STATUS_SESSAO CHAR(1), -- C = CLOSED, O = OPENED

	PRIMARY KEY(ID_SESSAO),
	FOREIGN KEY (ID_PAUTA) REFERENCES PAUTA (ID_PAUTA)
	
);

--DROP TABLE SESSAO;

CREATE TABLE VOTO(
	ID_VOTO NUMBER(10),
	ID_SESSAO NUMBER(10),
	ID_ASSOCIADO NUMBER(10),
	CONTEUDO VARCHAR2(3) NOT NULL,
	INFO_VOTO TIMESTAMP NOT NULL,
	PRIMARY KEY(ID_VOTO),
	UNIQUE (ID_SESSAO,ID_ASSOCIADO),
	FOREIGN KEY (ID_SESSAO) REFERENCES SESSAO (ID_SESSAO),
	FOREIGN KEY (ID_ASSOCIADO) REFERENCES ASSOCIADO (ID_ASSOCIADO)
);
DROP TABLE VOTO;
--SEQUENCES--


CREATE SEQUENCE SEQ_SESSAO
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;
--DROP SEQUENCE SEQ_SESSAO

CREATE SEQUENCE SEQ_VOTO
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

CREATE SEQUENCE SEQ_ASSOCIADO
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;
--DROP SEQUENCE SEQ_ASSOCIADO;

CREATE SEQUENCE SEQ_PAUTA
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

--DROP SEQUENCE SEQ_PAUTA