module com.mycompany.fxticketsale {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    

    opens com.mycompany.fxticketsale to javafx.fxml;
    exports com.mycompany.fxticketsale;
    exports com.mycompany.pojo;
}
