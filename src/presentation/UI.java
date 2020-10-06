package presentation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.*;

public class UI extends Application{
    public static void main(String[] args) {
    	launch(args);
    }

	@Override
	public void start(Stage pStage) throws Exception {
		pStage.setTitle("Calculator title");
		GridPane g = new GridPane();
		g.add(new Text("Hello"), 0, 0);
		Scene s = new Scene(g);
		pStage.setScene(s);
		pStage.show();
	}
}
