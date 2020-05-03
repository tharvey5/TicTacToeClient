package edu.saddleback.cs4b;

import edu.saddleback.cs4b.Backend.ClientPackage.AIEventLog;
import edu.saddleback.cs4b.Backend.ClientPackage.Client;
import edu.saddleback.cs4b.Backend.ClientPackage.ClientAIRunner;
import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.UI.UIEventLog;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/edu/saddleback/cs4b/UI/ClientLogin.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(()->{
            Client client = new Client("localhost", 8080, UIEventLog.getInstance(), ClientEventLog.getInstance());
            Client aiConnect = new Client("localhost", 8080, AIEventLog.getInstance(), )
        }).start();

        //new Thread(ClientAIRunner.getInstance()).start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
