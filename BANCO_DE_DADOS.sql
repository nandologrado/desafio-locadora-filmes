DROP DATABASE IF EXISTS locadora;

CREATE DATABASE locadora;
USE locadora;

DROP TABLE IF EXISTS filme;
 SET character_set_client = utf8mb4 ;
CREATE TABLE filme (
  id_filme bigint(20) NOT NULL AUTO_INCREMENT,
  diretor varchar(255) NOT NULL,
  qt_copias int(11) NOT NULL,
  titulo varchar(255) NOT NULL,
  versao int(11) DEFAULT NULL,
  PRIMARY KEY (id_filme)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS usuario;
 SET character_set_client = utf8mb4 ;
CREATE TABLE usuario (
  id_usuario bigint(20) NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL,
  nome_usuario varchar(255) NOT NULL,
  senha varchar(255) NOT NULL,
  PRIMARY KEY (id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS locacao;
 SET character_set_client = utf8mb4 ;
CREATE TABLE locacao (
  id_locacao bigint(20) NOT NULL AUTO_INCREMENT,
  dt_locacao date NOT NULL,
  dt_retorno date DEFAULT NULL,
  id_filme bigint(20) NOT NULL,
  id_usuario bigint(20) NOT NULL,
  PRIMARY KEY (id_locacao),
  KEY FK_filme_locacao (id_filme),
  KEY FK_usuario_locacao (id_usuario),
  CONSTRAINT FK_filme_locacao FOREIGN KEY (id_filme) REFERENCES filme (id_filme),
  CONSTRAINT FK_usuario_locacao FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("AS HORAS", "STEPHEN DALDRY", 1, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("FATAL", "ISABEL COIXET", 1, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("TESS UMA LIÇÃO DE VIDA", "ROMAN POLANSKI", 3, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("QUEM TEM MEDO DE VIRGINIA WOOLF?", "MIKE NICHOLS", 1, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("VIDA E ARTE DE GEORGIA O’KEEFFE", "BOB BALABAN", 5, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("AGONIA E ÊXTASE", "CAROL REED", 2, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("A ÁRVORE DA VIDA", "TERRENCE MALICK", 4, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("O LIVRO DE CABECEIRA", "PETER GREENAWAY", 1, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("O PIANO", "JANE CAMPION", 1, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("COSMÓPOLIS", "DAVID CRONENBERG", 1, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("RETORNO A HOWARDS END", "JAMES IVORY", 2, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("DOGVILLE", "LARS VON TRIER", 1, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("MANDERLAY", "LARS VON TRIER", 3, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("A ÚLTIMA TEMPESTADE", "PETER GREENAWAY", 1, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("9 ½ SEMANAS DE AMOR", "ADRIAN LYNE", 1, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("QUERO SER JOHN MALKOVICH", "SPIKE JONZE", 4, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("CLOSER", "MIKE NICHOLS", 1, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("DESEJO E REPARAÇÃO", "JOE WRIGHT", 1, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("O CÉU QUE NOS PROTEGE", "BERNARDO BERTOLUCCI", 1, 1);

INSERT INTO FILME (titulo, diretor, qt_copias,versao)
VALUES ("UM LUGAR NA PLATEIA", "DANIÈLE THOMPSON", 5, 1);


