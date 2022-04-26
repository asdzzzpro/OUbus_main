
import com.mycompany.conf.JdbcUtils;
import com.mycompany.services.DangNhapNhanVienService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NGUYENVANTAI
 */
public class TestStaff {
    private static Connection conn;
    private static DangNhapNhanVienService s ;
    
    @BeforeAll
    public static void beforeAll() throws SQLException {
        s = new DangNhapNhanVienService();
    }
    
    @AfterAll
    public static void afterAll() {
        if (conn != null)
                try {
                    conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TestAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    @Test
    public void testUserNameNotNull() throws SQLException
    {
        conn = JdbcUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM nhanvien");
        List<String> kq = new ArrayList<>();
        while(rs.next()){
            String name = rs.getString("username");
            kq.add(name);
//            System.out.println(name);
        }
//        System.out.println(kq);
        kq.forEach(c -> Assertions.assertNotNull(c));
    }
    @Test  
    public void testAdmin() throws SQLException{
        conn = JdbcUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM nhanvien");
        List<String> kq = new ArrayList<>();
        while(rs.next()){
            String name = rs.getString("tenNV");
            kq.add(name);
//            System.out.println(name);
        }
        Set<String> kq2 = new HashSet<>(kq);
        
        Assertions.assertEquals(kq.size(), kq2.size());
    }
}
