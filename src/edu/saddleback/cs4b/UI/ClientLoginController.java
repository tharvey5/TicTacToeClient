package edu.saddleback.cs4b.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientLoginController
{
    @FXML
    Button loginButton;

    @FXML
    Button createAccountButton;


    /**
     * WHEN THIS METHOD IS CALLED THE 'LOGIN' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightLogin()
    {
        loginButton.setOnMouseEntered(mouseEvent -> loginButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'LOGIN' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetLogin()
    {
        loginButton.setOnMouseExited(mouseEvent -> loginButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'CREATE ACCOUNT' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightCreateAccount()
    {
        createAccountButton.setOnMouseEntered(mouseEvent -> createAccountButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'CREATE ACCOUNT' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetCreateAccount()
    {
        createAccountButton.setOnMouseExited(mouseEvent -> createAccountButton.setTextFill(Color.WHITE));
    }

    @FXML
    public void handleLoginAction(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(getClass().getResource("/edu/saddleback/cs4b/UI/ClientHomeScreen.fxml"));
        Scene scene  = new Scene(parent);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    @FXML
    public void handleCreateAccountAction(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(getClass().getResource("/edu/saddleback/cs4b/UI/ClientRegistration.fxml"));
        Scene scene  = new Scene(parent);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }


}
