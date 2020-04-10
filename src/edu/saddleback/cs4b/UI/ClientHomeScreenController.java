package edu.saddleback.cs4b.UI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientHomeScreenController implements Initializable
{
    @FXML
    private Label mainMenuLabel;

    @FXML
    private Label singlePlayerLabel;

    @FXML
    private Label multiplayerLabel;

    @FXML
    private Label viewProfileLabel;

    @FXML
    private Label aboutUsLabel;

    @FXML
    private Label logoutLabel;

    @FXML
    private BorderPane viewScreen;

    /**
     * WHEN THIS METHOD IS CALLED THE 'MAIN MENU' LABEL WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightMainMenu()
    {
        mainMenuLabel.setOnMouseEntered(mouseEvent -> mainMenuLabel.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'MAIN MENU' LABEL WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetMainMenu()
    {
        mainMenuLabel.setOnMouseExited(mouseEvent -> mainMenuLabel.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'SINGLE PLAYER' LABEL WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightSinglePlayer()
    {
        singlePlayerLabel.setOnMouseEntered(mouseEvent -> singlePlayerLabel.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'SINGLE PLAYER' LABEL WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetSinglePlayer()
    {
        singlePlayerLabel.setOnMouseExited(mouseEvent -> singlePlayerLabel.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'MULTIPLAYER' LABEL WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightMultiplayer()
    {
        multiplayerLabel.setOnMouseEntered(mouseEvent -> multiplayerLabel.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'MULTIPLAYER' LABEL WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetMultiplayer()
    {
        multiplayerLabel.setOnMouseExited(mouseEvent -> multiplayerLabel.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'VIEW PROFILE' LABEL WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightViewProfile()
    {
        viewProfileLabel.setOnMouseEntered(mouseEvent -> viewProfileLabel.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'VIEW PROFILE' LABEL WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetViewProfile()
    {
        viewProfileLabel.setOnMouseExited(mouseEvent -> viewProfileLabel.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'ABOUT US' LABEL WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightAboutUs()
    {
        aboutUsLabel.setOnMouseEntered(mouseEvent -> aboutUsLabel.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'ABOUT US' LABEL WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetAboutUs()
    {
        aboutUsLabel.setOnMouseExited(mouseEvent -> aboutUsLabel.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'ABOUT US' LABEL WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightLogout()
    {
        logoutLabel.setOnMouseEntered(mouseEvent -> logoutLabel.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'ABOUT US' LABEL WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetLogout()
    {
        logoutLabel.setOnMouseExited(mouseEvent -> logoutLabel.setTextFill(Color.WHITE));
    }

    @FXML
    public void handleMainMenuAction(MouseEvent event)
    {
        System.out.println("You clicked me!");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("MainMenuScreen");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleSinglePlayerAction(MouseEvent event)
    {
        System.out.println("You clicked me!");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("SinglePlayerScreen");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleMultiplayerAction(MouseEvent event)
    {
        System.out.println("You clicked me!");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("MultiplayerScreen");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleViewProfileAction(MouseEvent event)
    {
        System.out.println("You clicked me!");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ViewProfileScreen");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleAboutUsAction(MouseEvent event)
    {
        System.out.println("You clicked me!");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AboutUsScreen");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleLogoutAction(MouseEvent event)
    {
        System.out.println("You clicked me!");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("LogoutScreen");
        viewScreen.setCenter(view);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
