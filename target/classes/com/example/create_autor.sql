create table autores(
    id number GENERATED always as IDENTITY PRIMARY KEY,
    nome varchar(200),
    nacionalidade varchar(200)
)

ALTER TABLE livros ADD autor_id number;
ALTER TABLE livros ADD CONSTRAINT fk_livros_autor FOREIGN KEY (autor_id) REFERENCES autores (id);

SELECT * FROM livros;