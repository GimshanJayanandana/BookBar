package lk.ijse.BookBar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


    public class launcher extends Application {
        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage stage) throws Exception {
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/loginForm.fxml"))));
            stage.centerOnScreen();
            stage.setTitle("Dashboard");

            stage.show();
        }
    }
