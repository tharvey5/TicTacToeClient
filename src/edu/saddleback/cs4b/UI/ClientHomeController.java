package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
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
    private Button profileButton;

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
        mainMenuButton.setOnMouseEntered(mouseEvent -> mainMenuButton.setTextFill(Color.valueOf("#FFD700")));
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
        singlePlayerButton.setOnMouseEntered(mouseEvent -> singlePlayerButton.setTextFill(Color.valueOf("#FFD700")));
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
        multiplayerButton.setOnMouseEntered(mouseEvent -> multiplayerButton.setTextFill(Color.valueOf("#FFD700")));
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
    public void highlightProfile()
    {
        profileButton.setOnMouseEntered(mouseEvent -> profileButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'VIEW PROFILE' LABEL WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetProfile()
    {
        profileButton.setOnMouseExited(mouseEvent -> profileButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'ABOUT US' LABEL WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightAboutUs()
    {
        aboutUsButton.setOnMouseEntered(mouseEvent -> aboutUsButton.setTextFill(Color.valueOf("#FFD700")));
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
        logoutButton.setOnMouseEntered(mouseEvent -> logoutButton.setTextFill(Color.valueOf("#FFD700")));
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
    public void handleMainMenuAction()
    {
        ClientEventLog.getInstance().clearObservers();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("MainMenu");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleSinglePlayerAction()
    {
        ClientEventLog.getInstance().clearObservers();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("SinglePlayer");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleMultiplayerAction()
    {
        ClientEventLog.getInstance().clearObservers();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Multiplayer");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleProfileAction()
    {
        ClientEventLog.getInstance().clearObservers();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Profile");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleEditProfileAction()
    {
        ClientEventLog.getInstance().clearObservers();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ProfileEdit");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleEditProfileUsernameAction()
    {
        ClientEventLog.getInstance().clearObservers();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ProfileChangeUsername");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleEditProfilePasswordAction()
    {
        ClientEventLog.getInstance().clearObservers();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ProfileChangePassword");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleAboutUsAction()
    {
        ClientEventLog.getInstance().clearObservers();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AboutUs");
        viewScreen.setCenter(view);
    }

    @FXML
    public void handleLogoutAction()
    {
        ClientEventLog.getInstance().clearObservers();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Logout");
        viewScreen.setCenter(view);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
