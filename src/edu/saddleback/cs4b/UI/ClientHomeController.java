package edu.saddleback.cs4b.UI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientHomeController implements Initializable
{
    @FXML
    private Button mainMenuButton;

    @FXML
    private Button singlePlayerButton;

    @FXML
    private Button multiplayerButton;

    @FXML
    private Button viewProfileButton;

    @FXML
    private Button aboutUsButton;

    @FXML
    private Button logoutButton;

    @FXML
    private BorderPane viewScreen;

    /**
     * WHEN THIS METHOD IS CALLED THE 'MAIN MENU' LABEL WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightMainMenu()
    {
        mainMenuButton.setOnMouseEntered(mouseEvent -> mainMenuButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'MAIN MENU' LABEL WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetMainMenu()
    {
        mainMenuButton.setOnMouseExited(mouseEvent -> mainMenuButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'SINGLE PLAYER' LABEL WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightSinglePlayer()
    {
        singlePlayerButton.setOnMouseEntered(mouseEvent -> singlePlayerButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'SINGLE PLAYER' LABEL WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetSinglePlayer()
    {
        singlePlayerButton.setOnMouseExited(mouseEvent -> singlePlayerButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'MULTIPLAYER' LABEL WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightMultiplayer()
    {
        multiplayerButton.setOnMouseEntered(mouseEvent -> multiplayerButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'MULTIPLAYER' LABEL WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetMultiplayer()
    {
        multiplayerButton.setOnMouseExited(mouseEvent -> multiplayerButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'VIEW PROFILE' LABEL WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightViewProfile()
    {
        viewProfileButton.setOnMouseEntered(mouseEvent -> viewProfileButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'VIEW PROFILE' LABEL WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetViewProfile()
    {
        viewProfileButton.setOnMouseExited(mouseEvent -> viewProfileButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'ABOUT US' LABEL WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightAboutUs()
    {
        aboutUsButton.setOnMouseEntered(mouseEvent -> aboutUsButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'ABOUT US' LABEL WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetAboutUs()
    {
        aboutUsButton.setOnMouseExited(mouseEvent -> aboutUsButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'ABOUT US' LABEL WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightLogout()
    {
        logoutButton.setOnMouseEntered(mouseEvent -> logoutButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'ABOUT US' LABEL WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetLogout()
    {
        logoutButton.setOnMouseExited(mouseEvent -> logoutButton.setTextFill(Color.WHITE));
    }

    @FXML
    public void handleMainMenuAction(MouseEvent event)
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("MainMenuScreen");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleSinglePlayerAction(MouseEvent event)
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("SinglePlayerScreen");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleMultiplayerAction(MouseEvent event)
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("MultiplayerScreen");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleViewProfileAction(MouseEvent event)
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ViewProfileScreen");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleAboutUsAction(MouseEvent event)
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AboutUsScreen");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleLogoutAction(MouseEvent event)
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("LogoutScreen");
        viewScreen.setCenter(view);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
