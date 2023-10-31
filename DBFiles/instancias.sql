USE `dbname` ;

SELECT * FROM Cliente;

INSERT INTO Salgado VALUES (1,"Coxinha de Frango com Catupiry",0.7);
INSERT INTO Salgado VALUES (2,"Risoles de Carne",0.7);
INSERT INTO Salgado VALUES (3,"Quibe",0.7);
INSERT INTO Salgado VALUES (4,"Esfiha de Carne",0.7);
INSERT INTO Salgado VALUES (5,"Empadinha de Palmito",0.7);
INSERT INTO Salgado VALUES (6,"Enroladinho de Salsicha",0.7);
INSERT INTO Salgado VALUES (7,"Bolinha de Queijo",0.7);
INSERT INTO Salgado VALUES (8,"Bolinha de Queijo com Milho",0.7);
INSERT INTO Salgado VALUES (9,"Risoles de Frango",0.7);
INSERT INTO Salgado VALUES (10,"Risoles de Presunto e Queijo",0.7);
INSERT INTO Salgado VALUES (11,"Enroladinho de Presunto e Queijo",0.7);

INSERT INTO Bolo VALUES (1,"Bolo de Brigadeiro",53.0,1.0);
INSERT INTO Bolo VALUES (2,"Bolo de Prestigio",53.0,1.0);
INSERT INTO Bolo VALUES (3,"Bolo de Abacaxi",53.0,1.0);
INSERT INTO Bolo VALUES (4,"Bolo de Pessego",53.0,1.0);
INSERT INTO Bolo VALUES (5,"Bolo Dois Amores",53.0,1.0);
INSERT INTO Bolo VALUES (6,"Bolo Viuva Negra",53.0,1.0);

-- insert into doces values (id, descricao, valor unitario)
-- o valor de todos é 1.2
-- valores a seguir:
-- Brigadeiro;
-- Brigadeiro Branco;
-- Brigadeiro Colorido;
-- Beijinho de Coco;
-- Casadinho;
-- Cajuzinho;

INSERT INTO Doce VALUES (1,"Brigadeiro",1.2);
INSERT INTO Doce VALUES (2,"Brigadeiro Branco",1.2);
INSERT INTO Doce VALUES (3,"Brigadeiro Colorido",1.2);
INSERT INTO Doce VALUES (4,"Beijinho de Coco",1.2);
INSERT INTO Doce VALUES (5,"Casadinho",1.2);
INSERT INTO Doce VALUES (6,"Cajuzinho",1.2);

-- Tabela Cliente
-- Columns:
-- cpf varchar(11) PK 
-- nome varchar(200) 
-- RG varchar(20) 
-- endereco varchar(100) 
-- CEP varchar(20) 
-- celular varchar(13) 
-- telefoneResidencial varchar(13) 
-- telefoneComercial varchar(13) 
-- email varchar(50)

-- inserir tupla de exemplo

SELECT * FROM Cliente;

DELETE From cliente where cpf = '88149699066';

INSERT INTO Cliente VALUES ('88149699066', 'Joao da Silva', '267584288', 'Rua Aguas Claras', '12345-678', '67 99988-1235', '67 9999-4444', '67 88888-4545', 'jonasgames123@gmail.com')

