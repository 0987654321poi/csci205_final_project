module csci205_final_project{
    requires java.base;
    requires java.desktop;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports org.team6;
    opens org.team6 to javafx.fxml;
    exports org.team6.SolitareModel;
    opens org.team6.SolitareModel to javafx.fxml;
}
