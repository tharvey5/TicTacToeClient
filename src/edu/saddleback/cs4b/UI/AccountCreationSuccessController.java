package edu.saddleback.cs4b.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class AccountCreationSuccessController
{
    @FXML
    Button returnToLoginButton;

    /**
     * WHEN THIS METHOD IS CALLED THE 'RETURN TO LOGIN' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightReturnToLogin()
    {
        returnToLoginButton.setOnMouseEntered(mouseEvent -> returnToLoginButton.setTextFill(Color.RED));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'RETURN TO LOGIN' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetReturnToLogin()
    {

        returnToLoginButton.setOnMouseExited(mouseEvent -> returnToLoginButton.setTextFill(Color.BLACK));
    }

    @FXML
    public void handleReturnToLoginAction(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(getClass().getResource("/edu/saddleback/cs4b/UI/ClientLogin.fxml"));
        Scene scene  = new Scene(parent);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }


}
