package com.example.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Autor;

public class AutorDao {

    private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private final String USER = "rm97784";
    private final String PASS = "081100";
    
    public void inserir(Autor autor) throws SQLException{
        var con = DriverManager.getConnection(URL, USER, PASS);

        var ps = con.prepareStatement("INSERT INTO autores (nome, nacionalidade) VALUES (?, ?)");
        ps.setString(1, autor.getNome());
        ps.setString(2, autor.getNacionalidade());

        ps.executeUpdate();
        con.close();
    }

    public List<Autor> buscarTodos() throws SQLException{
        var autores = new ArrayList<Autor>();
        var con = DriverManager.getConnection(URL, USER, PASS);
        var rs = con.createStatement().executeQuery("SELECT * FROM autores");

        while(rs.next()){
            autores.add(new Autor(
                rs.getInt("id"),
                rs.getString("nome"), 
                rs.getString("nacionalidade") 
            ));
        }

        con.close();
        return autores;
    }

    public void apagar(Autor autor) throws SQLException {
        var con = DriverManager.getConnection(URL, USER, PASS);
        var ps = con.prepareStatement("DELETE FROM clientes WHERE id=?"); 
        ps.setInt(1, autor.getId());
        ps.executeUpdate();
        con.close();
    }

    public void atualizar(Autor autor) throws SQLException {
        var con = DriverManager.getConnection(URL, USER, PASS);
        var ps = con.prepareStatement("UPDATE autores SET nome=?, nacionalidade=? WHERE id=?");
        ps.setString(1, autor.getNome());
        ps.setString(2, autor.getNacionalidade());
        ps.setInt(3, autor.getId());
        
        ps.executeUpdate();
        con.close();

    }

}
