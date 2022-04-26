
import com.mycompany.conf.JdbcUtils;
import com.mycompany.pojo.VeXe;
import com.mycompany.services.VeXeService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
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
public class TestTicket {
    private static Connection conn;
    private static VeXeService s;
    
    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JdbcUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(TestTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        s = new VeXeService();
    }
    
    @AfterAll
    public static void afterAll() {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TestTicket.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @Test
    public void testSearchSuccessful() throws SQLException {
        String kw = "you";
        List<VeXe> vexe = s.getListVeXe(kw);
        
        for (VeXe v: vexe)
            Assertions.assertTrue(v.getTenKH().toLowerCase().contains(kw.toLowerCase()));
    }
    
    @Test
    public void testTimKiemSai() throws SQLException {
        String kw = "123/343";
        List<VeXe> vexe = s.getListVeXe(kw);
        
        Assertions.assertEquals(vexe.size(),1);
    }
    @Test
    public void testSearchUnscure() throws SQLException {
        String kw = "1 OR 1=1";
        List<VeXe> v = s.getListVeXe(kw);
        
        Assertions.assertEquals(v.size(), 0);
    }
     @Test
    public void deleteTicket() throws SQLException {
        String kw = "Huy Ngu";
        List<VeXe> vexe =s.getListVeXe(kw);
        int id = 6;
        s.xoaVe(id);
        for (VeXe v: vexe)
            Assertions.assertEquals(v.getMaVe(),6 );
    }
    @Test
    public void testThemThanhCong() throws SQLException {
        VeXe v;
        v = new VeXe("VeTest", "1", 1, "Tai","123","12-3-2001",1);
        s.themVe(v);
        Assertions.assertEquals(v.getTenKH(), "Tai");
    }
//    @T
}
