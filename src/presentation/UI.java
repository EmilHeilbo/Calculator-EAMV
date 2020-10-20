package presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import logic.*;

public class UI extends Application {
	
	private Calculator calc;
	private Operator operation;
	private double op1, op2;
	private Label equationDisplay;
    
	
	public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage pStage) {
        calc = new Calculator();

        final int BUTTON_SIZE = 80;
        final int SPACING = 10;
        final int WIDTH = 4;
        final int HEIGHT = 7;

        pStage.setTitle("EAMV - Simple Calculator");
        pStage.setWidth(BUTTON_SIZE * WIDTH + SPACING * (WIDTH - 1));
        pStage.setHeight(BUTTON_SIZE * HEIGHT + SPACING * (HEIGHT + 1));

        var grid = new GridPane();
        var scene = new Scene(grid);
        grid.setHgap(SPACING);
        grid.setVgap(SPACING);
        grid.setBackground(new Background(new BackgroundFill(Color.web("B8AFA9"), CornerRadii.EMPTY, Insets.EMPTY)));

        String equation = "";
        equationDisplay = new Label();
        equationDisplay.setAlignment(Pos.CENTER_RIGHT);
        equationDisplay.setPrefSize(BUTTON_SIZE * 4 + SPACING * 3, BUTTON_SIZE);
        equationDisplay.setStyle("-fx-font: 32 arial;");
        equationDisplay.setBackground(new Background(new BackgroundFill(Color.web("white"), CornerRadii.EMPTY, Insets.EMPTY)));
        GridPane.setColumnSpan(equationDisplay, 4);
        GridPane.setConstraints(equationDisplay, 0, 0);
        grid.getChildren().add(equationDisplay);

        Button[] buttons = new Button[24];
        String[] buttonText =
                {
                        "%", "|x|", "^", "sqrt",
                        "+", "-", "*", "/",
                        "7", "8", "9", "cos",
                        "4", "5", "6", "sin",
                        "1", "2", "3", "tan",
                        "0", ",", "C", "="
                };
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button-" + (i + 1));
            buttons[i].setText(buttonText[i]);
            buttons[i].setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
            GridPane.setConstraints(buttons[i], i % WIDTH, i / WIDTH + 1);
            grid.getChildren().add(buttons[i]);
        }
        buttons[0].setOnAction(new Calculation(Operator.MUL, this));

        pStage.setScene(scene);
        pStage.show();
    }
}
