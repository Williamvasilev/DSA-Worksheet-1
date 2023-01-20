module com.example.worksheet1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.worksheet1 to javafx.fxml;
    exports com.example.worksheet1;
}