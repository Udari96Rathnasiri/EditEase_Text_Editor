package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.event.MouseEvent;

public class AboutUsWindowController {
    public AnchorPane root;
    public Button btnClose;

    public void onMouseMove(MouseEvent e){
        root.setCursor(Cursor.NONE);
        Stage primaryStage= (Stage) root.getScene().getWindow();

    }


    public void btnCloseOnAction(ActionEvent actionEvent) throws Exception{
        Stage currentStage = (Stage) btnClose.getScene().getWindow();
        currentStage.close();
    }
}
