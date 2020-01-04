create schema ponto_inteligente;

create table empresa
(
    id               bigint       not null,
    cnpj             varchar(255) not null,
    data_atualizacao datetime(6)  not null,
    data_criacao     datetime(6)  not null,
    razao_social     varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table funcionario
(
    id                     bigint       not null,
    cpf                    varchar(255) not null,
    data_atualizacao       datetime(6),
    data_criacao           datetime(6),
    email                  varchar(255) not null,
    nome                   varchar(255) not null,
    perfil                 integer      not null,
    qtd_horas_almoco       float,
    qtd_horas_trabalho_dia float,
    senha                  varchar(255) not null,
    valor_hora             decimal(19, 2),
    empresa_id             bigint,
    primary key (id)
) engine = InnoDB;

create table lancamento
(
    id               bigint       not null,
    data             datetime(6)  not null,
    data_atualizacao datetime(6)  not null,
    data_criacao     datetime(6)  not null,
    descricao        varchar(255),
    localizacao      varchar(255),
    tipo             varchar(255) not null,
    funcionario_id   bigint,
    primary key (id)
) engine = InnoDB;

alter table funcionario
    add constraint FK4cm1kg523jlopyexjbmi6y54j
        foreign key (empresa_id)
            references empresa (id);

alter table lancamento
    add constraint FK46i4k5vl8wah7feutye9kbpi4
        foreign key (funcionario_id)
            references funcionario (id);