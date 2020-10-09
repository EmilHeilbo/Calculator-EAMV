package presentation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
		pStage.setWidth(4 * BUTTON_SIZE);
		pStage.setHeight(7 * BUTTON_SIZE);

		VBox vbox = new VBox();
		GridPane g = new GridPane();
		Text text = new Text("Smashkey");
		text.setTextAlignment(TextAlignment.RIGHT);
		vbox.getChildren().add(text);
		
		Scene s = new Scene(vbox);
		
		pStage.setScene(s);
		pStage.show();
	}
}
