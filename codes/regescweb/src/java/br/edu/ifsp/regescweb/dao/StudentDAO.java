
package br.edu.ifsp.regescweb.dao;

import br.edu.ifsp.regescweb.db.ConnectionFactory;
import br.edu.ifsp.regescweb.models.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class StudentDAO {
    private Connection conn;
    
    public StudentDAO() throws ClassNotFoundException, SQLException {
        this.conn = ConnectionFactory.getConnection();
    }

    // este método é chamado sempre antes da desalocação/destruição do objeto
    // em questão
    @Override
    protected void finalize() throws SQLException {
        System.out.println("Executando antes de destruir o objeto");
        this.conn.close();
    }
    
    
    public void insert(Student student) throws SQLException {
        String sql = "ashjakshak INSERT INTO Student(name, age) VALUES (?, ?)";
        
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, student.getName());
        stmt.setInt(2, student.getAge());
        
        stmt.executeUpdate();
        
        stmt.close();
    }
    
}



