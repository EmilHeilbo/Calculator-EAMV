package presentation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.*;

public class UI extends Application{

	public static void main(String[] args) {
    	var calc = new Calculator();
    	launch(args);
    }

	@Override
	public void start(Stage pStage) throws Exception {
		final int BUTTON_SIZE = 80;

		pStage.setTitle("EAMV - Simple Calculator");
		GridPane g = new GridPane();
		Scene s = new Scene(g, BUTTON_SIZE * 4, BUTTON_SIZE * 7);
		pStage.setScene(s);
		pStage.show();
	}
}
