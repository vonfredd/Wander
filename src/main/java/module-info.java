module com.wanderers.wander {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.wanderers.wander to javafx.fxml;
    exports com.wanderers.wander.village;
    opens com.wanderers.wander.village to javafx.fxml;
    exports com.wanderers.wander;
}