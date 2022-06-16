module ba.sum.fpmoz.knjiznica.knjiznicajavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.kordamp.bootstrapfx.core;

    opens ba.sum.fpmoz.knjiznica.knjiznicajavafx to javafx.fxml;
    opens ba.sum.fpmoz.knjiznica.knjiznicajavafx.model to javafx.fxml;
    exports ba.sum.fpmoz.knjiznica.knjiznicajavafx;
    exports ba.sum.fpmoz.knjiznica.knjiznicajavafx.controller;
    exports ba.sum.fpmoz.knjiznica.knjiznicajavafx.model;
    opens ba.sum.fpmoz.knjiznica.knjiznicajavafx.controller to javafx.fxml;
}