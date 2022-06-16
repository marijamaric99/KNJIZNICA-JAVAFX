package ba.sum.fpmoz.knjiznica.knjiznicajavafx;

import ba.sum.fpmoz.knjiznica.knjiznicajavafx.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class Program extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        /*Table.create(Author.class);
        Table.create(User.class);
        Table.create(Book.class);
        Table.create(Book_Author.class);
        Table.create(Borrowing.class);

        User user = new User();
        user.setFirstname("Marija");
        user.setLastname("Maric");
        user.setJMBG("1236547893215");
        user.setEmail("marija.maric@fpmoz.sum.ba");
        user.setRole("Student");
        user.save();*/


        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("intro-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 370);
        stage.setTitle("Dobrodošli na sustav!");
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setScene(scene);
        stage.show();
    }

    public static void swapScene (Stage stage, String viewName, String title){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource(viewName));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 520);
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stage.setTitle(title);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nastala je pogreška: " + e.getMessage());
        }

    }

    public static void swapScene (Stage stage, String viewName){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource(viewName));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 520);
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nastala je pogreška: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        launch();
    }
}