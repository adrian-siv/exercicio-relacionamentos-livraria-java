CREATE TABLE livros (
    id number GENERATED always as identity,
    titulo varchar(200),
    genero varchar(200),
    ano integer,
    valor number(9,2)
)
