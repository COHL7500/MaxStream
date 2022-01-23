module com.example.grpro15_proj {
    requires javafx.controls;
    requires javafx.fxml;


    opens project_code to javafx.fxml;
    exports project_code;
}