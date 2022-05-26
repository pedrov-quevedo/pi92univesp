create table tb_usu (
    id int auto_increment NOT NULL,
    usu_username varchar(150) NOT NULL,
    usu_password varchar(30) NOT NULL,
    primary key(id)
);

create table tb_dadosusu (
	dadosusu_userid int,
    dadosusu_name varchar(150) NOT NULL,
    dadosusu_email varchar(150) NOT NULL,
    dadosusu_datanascimento date NOT NULL,
    dadosusu_contato varchar(150) NOT NULL,
    dadosusu_datacadastro timestamp NOT NULL,
    foreign key (dadosusu_userid) REFERENCES tb_usu(id)
)