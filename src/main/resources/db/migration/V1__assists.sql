create table assistances
(
    id        bigint auto_increment
        primary key,
    description varchar(300) not null,
    name varchar(100) not null
);

insert into assistances (name, description) VALUES ('Troca de Aparelho','Troca de aparelho decodificador de TV');
insert into assistances (name, description) VALUES ('Troca de Cabo Interno','Troca de Cabo Interno');
insert into assistances (name, description) VALUES ('Troca de Fiacao Interna','Substituicao de fiacao interna de residuos');
insert into assistances (name, description) VALUES ('Manutencao de fogao','Reparo sem necessidade de compra de peca');
insert into assistances (name, description) VALUES ('Manutencao de geladeira','Reparo sem necessidade de compra de peca');
insert into assistances (name, description) VALUES ('Manutencao de maquina de lavar','Reparo sem necessidade de compra de peca');