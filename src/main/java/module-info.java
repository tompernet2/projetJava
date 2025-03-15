module sio.autoecoleprojet {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires spring.core;
    requires spring.security.crypto;
    requires java.desktop;
    requires jdk.jfr;
    requires com.google.protobuf;
    requires spring.security.core;  // Ajout de la dépendance Spring Security Crypto

    opens sio.autoecoleprojet to javafx.fxml;
    opens sio.autoecoleprojet.models;
    exports sio.autoecoleprojet;
}
