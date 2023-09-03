package lk.ijse.dep11;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.util.Optional;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/SplashWindow.fxml"));
        Scene scene1 = new Scene(root);
        primaryStage.setScene(scene1);

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        root.setBackground(Background.fill(Color.TRANSPARENT));
        scene1.setFill(Color.TRANSPARENT);

        primaryStage.setResizable(false);
        primaryStage.show();

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(6), root);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(e -> {
            primaryStage.hide();

            try {
                showMainApplicationWindow();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        fadeOut.play();

    }
    public void showMainApplicationWindow()throws Exception{
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Scene mainscene = new Scene(root1);
        Stage stage = new Stage();
        stage.setScene(mainscene);
        stage.setTitle("EditEase");
        stage.setMaximized(true);
        stage.show();

        stage.setOnCloseRequest(e ->{
            Optional<ButtonType> buttonRef =  new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to exit?",
                    ButtonType.YES,ButtonType.NO).showAndWait();
            if (buttonRef.get() == ButtonType.NO){
                e.consume();
            }
        });
    }
}
