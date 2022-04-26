
import com.mycompany.conf.JdbcUtils;
import com.mycompany.pojo.ChuyenXe;
import com.mycompany.services.ChuyenDiService;
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
public class TestTour {
    private static Connection conn;
    private static ChuyenDiService s;
    
    @BeforeAll
    public static void beforeAll() {
        
        s = new ChuyenDiService();
    }
    
    @AfterAll
    public static void afterAll() {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TestTour.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @Test
    public void testSearchSuccessful() throws SQLException {
        conn = JdbcUtils.getConn();
        String kw = "BD";
        List<ChuyenXe> cx = s.getChuyenXe(kw);
        for (ChuyenXe c: cx)
            Assertions.assertTrue(c.getDiemDi().toLowerCase().contains(kw.toLowerCase()));
    }
    @Test
    public void deleteTour() throws SQLException {
        conn = JdbcUtils.getConn();
        String kw = "BD";
        List<ChuyenXe> cx =s.getChuyenXe(kw);
        int id = 2;
        ChuyenDiService.deleteChuyenDi(id);
        for (ChuyenXe v: cx)
            Assertions.assertEquals(2, v.getMaChuyenXe());
    }
    @Test
    public void testTimKiemSai() throws SQLException {
        conn = JdbcUtils.getConn();
        String kw = "123/343";
        List<ChuyenXe> cx = s.getChuyenXe(kw);
        
        Assertions.assertEquals(1, cx.size());
    }
    @Test
    public void testSearchUnscure() throws SQLException {
        conn = JdbcUtils.getConn();
        String kw = "1 OR 1=1";
        List<ChuyenXe> v = s.getChuyenXe(kw);
        
        Assertions.assertEquals(0, v.size());
    }
   
    @Test
    public void testThemThanhCong() throws SQLException {
        conn = JdbcUtils.getConn();
        ChuyenXe v;
        v = new ChuyenXe(1, "2001-3-4", 2000, "BD", "DN");
        s.themChuyenDi(v);
        Assertions.assertEquals(v.getDiemDi(), "BD");
    }
}
