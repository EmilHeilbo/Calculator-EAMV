package presentation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
=======
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
>>>>>>> 7e2cfad8fd595fcc2028a6fb7a744b862437976a
import javafx.stage.Stage;
import logic.*;

public class UI extends Application {

    public static void main(String[] args) {
        var calc = new Calculator();
        launch(args);
    }

<<<<<<< HEAD
    @Override
    public void start(Stage pStage) throws Exception {
        final int BUTTON_SIZE = 80;
        final int SPACING = 10;
        final int WIDTH = 4;
        final int HEIGHT = 8;

        pStage.setWidth(BUTTON_SIZE * WIDTH);
        pStage.setHeight(BUTTON_SIZE * HEIGHT);
        var grid = new GridPane();
        grid.setMinSize(WIDTH * BUTTON_SIZE + SPACING * (WIDTH - 1), (HEIGHT - 1) * BUTTON_SIZE + SPACING * (HEIGHT - 2));
        grid.setHgap(SPACING);
        grid.setVgap(SPACING);
        String[] buttonText =
                {
                        "%", "||", "^", "√",
                        "+", "-", "*", "/",
                        "7", "8", "9", "cos",
                        "4", "5", "6", "sin",
                        "1", "2", "3", "tan",
                        "0", ",", "C", "="
                };
        var buttons = new Button[buttonText.length];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText(buttonText[i]);
            grid.add(buttons[i], i % WIDTH, i / WIDTH);
        }
        pStage.setTitle("EAMV - Simple Calculator");
        var scene = new Scene(grid);
        var text = new Text("Test 1234567890");
        text.setTextAlignment(TextAlignment.RIGHT);
        grid.getChildren().add(text);

        grid.setBackground(new Background(new BackgroundFill(Color.web("FF8000"), CornerRadii.EMPTY, Insets.EMPTY)));
        pStage.setScene(scene);
        pStage.show();
    }
=======
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
>>>>>>> 7e2cfad8fd595fcc2028a6fb7a744b862437976a
}
