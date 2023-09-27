package com.example.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Autor;
import com.example.model.Livro;

public class LivroDao {

    private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private final String USER = "rm97784";
    private final String PASS = "081100";
    
    public void inserir(Livro livro) throws SQLException{
        var con = DriverManager.getConnection(URL, USER, PASS);

        var ps = con.prepareStatement("INSERT INTO livros (titulo, genero, ano, valor, autor_id) VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, livro.getTitulo());
        ps.setString(2, livro.getGenero());
        ps.setInt(3, livro.getAno());
        ps.setBigDecimal(4, livro.getValor());
        ps.setInt(5, livro.getAutor().getId());

        ps.executeUpdate();
        con.close();
    }

    public List<Livro> buscarTodos() throws SQLException{
        var livros = new ArrayList<Livro>();
        var con = DriverManager.getConnection(URL, USER, PASS);
        var rs = con.createStatement().executeQuery("SELECT livros.*, autores.nome FROM livros INNER JOIN autores ON livros.autor_id=autores.id");

        while(rs.next()){
            livros.add(new Livro(
                rs.getInt("id"),
                rs.getString("titulo"), 
                rs.getString("genero"), 
                rs.getInt("ano"), 
                rs.getBigDecimal("valor"),
                new Autor(
                    rs.getInt("autor_id"),
                    rs.getString("nome"),
                    null
                )
            ));
        }

        con.close();
        return livros;
    }

    public void apagar(Livro livro) throws SQLException {
        var con = DriverManager.getConnection(URL, USER, PASS);
        var ps = con.prepareStatement("DELETE FROM livros WHERE id=?"); 
        ps.setInt(1, livro.getId());
        ps.executeUpdate();
        con.close();
    }

    public void atualizar(Livro livro) throws SQLException {
        var con = DriverManager.getConnection(URL, USER, PASS);
        var ps = con.prepareStatement("UPDATE livros SET titulo=?, genero=?, ano=?, valor=? WHERE id=?");
        ps.setString(1, livro.getTitulo());
        ps.setString(2, livro.getGenero());
        ps.setInt(3, livro.getAno());
        ps.setBigDecimal(4, livro.getValor());
        ps.setInt(5, livro.getId());
        ps.executeUpdate();
        con.close();

    }

}
