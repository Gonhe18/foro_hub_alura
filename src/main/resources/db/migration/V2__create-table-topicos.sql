create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(500) not null,
    fecha_de_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
    status varchar(20) not null,
    autor BIGINT NOT NULL,
    curso varchar(100) not null,

    primary key(id),
    CONSTRAINT fk_topicos_autor FOREIGN KEY (autor) REFERENCES usuarios(id)
);