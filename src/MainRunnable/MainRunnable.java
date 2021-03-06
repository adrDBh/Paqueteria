package MainRunnable;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainRunnable extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/loginView.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Iniciar sesión");
            primaryStage.centerOnScreen();
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Error de I/O" + e.getMessage());
        }
    }
}