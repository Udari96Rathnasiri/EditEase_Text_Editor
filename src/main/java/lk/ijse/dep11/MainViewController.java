package lk.ijse.dep11;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Optional;

public class MainViewController {
    public MenuItem btnNew;
    public MenuItem btnExit;
    public AnchorPane root;
    public MenuItem btnUserGuide;
    public MenuItem btnAboutUs;
    public HTMLEditor txtEditor;

    public void initialize(){
        txtEditor.requestFocus();

    }


    public void btnNewOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane mainSceneRoot = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Scene scene1 = new Scene(mainSceneRoot);

        // Creating new stage(window) and set a scene
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.setTitle("Untitled Document");
        stage.centerOnScreen();
        stage.show();

        stage.setOnCloseRequest(e ->{
            Optional<ButtonType> buttonRef =  new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to exit?",
                    ButtonType.YES,ButtonType.NO).showAndWait();
            if (buttonRef.get() == ButtonType.NO){
                e.consume();
            }
        });
    }
    public void btnExitOnAction(ActionEvent actionEvent) throws IOException{
        Optional<ButtonType> buttonRef =  new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to exit?",
                ButtonType.YES,ButtonType.NO).showAndWait();
        if (buttonRef.get() == ButtonType.YES){
            Platform.exit();
        }

    }
    public void btnUserGuideOnAction(ActionEvent actionEvent) throws  IOException{
        AnchorPane UserGuideWindowRoot = FXMLLoader.load(getClass().getResource("/view/UserGuideWindow.fxml"));
        Scene scene1 = new Scene(UserGuideWindowRoot);

        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.setTitle("User Guide");

        stage.initModality(Modality.APPLICATION_MODAL);             //modal for the whole application
        stage.initOwner(root.getScene().getWindow());

        stage.show();
    }

    public void btnAboutUsOnAction(ActionEvent actionEvent) throws IOException{
        AnchorPane AboutUsWindowRoot = FXMLLoader.load(getClass().getResource("/view/AboutUsWindow.fxml"));
        Scene scene1 = new Scene(AboutUsWindowRoot);

        // Creating new stage(window) and set a scene
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.setTitle("About Us");

        stage.initStyle(StageStyle.TRANSPARENT);
        root.setBackground(Background.fill(Color.TRANSPARENT));
        scene1.setFill(Color.TRANSPARENT);

        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();

    }

}
