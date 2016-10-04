
package br.edu.ifsp.regescweb.dao;

import br.edu.ifsp.regescweb.db.ConnectionFactory;
import br.edu.ifsp.regescweb.models.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
        String sql = "INSERT INTO Student(name, age) VALUES (?, ?)";
        
        PreparedStatement stmt = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, student.getName());
        stmt.setInt(2, student.getAge());
        
        stmt.executeUpdate();
        
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        student.setId(rs.getLong(1));
        
        stmt.close();
    }
    
    
    
    
    
}



