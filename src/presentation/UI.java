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


	
	// Objects and values used across the application
	private Calculator calc;
	private boolean altered;
	private Operator operation;
	private double op1, op2;
	private Label equationDisplay;
	private boolean updateable;
	private Button[] buttons;






	public static void main(String[] args) {
		launch(args);
	}







	@Override
	public void start(Stage pStage) {
		// Calculator
		calc = new Calculator();


		// Constants used in calculating the size of elements in our layout
		final int BUTTON_SIZE = 80;
		final int SPACING = 10;
		final int WIDTH = 4;
		final int HEIGHT = 7;




		// Title and size of appilcation
		pStage.setTitle("EAMV - Simple Calculator");
		pStage.setWidth(BUTTON_SIZE * WIDTH + SPACING * (WIDTH - 1));
		pStage.setHeight(BUTTON_SIZE * HEIGHT + SPACING * (HEIGHT + 1));






		// Layout, spacing and background
		var grid = new GridPane();
		var scene = new Scene(grid);
		grid.setHgap(SPACING);
		grid.setVgap(SPACING);
		grid.setBackground(new Background(new BackgroundFill(Color.web("B8AFA9"), CornerRadii.EMPTY, Insets.EMPTY)));






		// Display for numbers in the top of our layout
		equationDisplay = new Label("0");
		equationDisplay.setAlignment(Pos.CENTER_RIGHT);
		equationDisplay.setPrefSize(BUTTON_SIZE * 4 + SPACING * 3, BUTTON_SIZE);
		equationDisplay.setStyle("-fx-font: 32 arial;");
		equationDisplay
				.setBackground(new Background(new BackgroundFill(Color.web("white"), CornerRadii.EMPTY, Insets.EMPTY)));
		GridPane.setColumnSpan(equationDisplay, 4);
		GridPane.setConstraints(equationDisplay, 0, 0);
		grid.getChildren().add(equationDisplay);







		// Generate and add buttons with text, size and possition to layout
		buttons = new Button[24];
		String[] buttonText = { "%", "|x|", "^", "sqrt", "+", "-", "*", "/", "7", "8", "9", "cos", "4", "5", "6", "sin",
				"1", "2", "3", "tan", "0", ",", "C", "=" };
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button(buttonText[i]);                         // button and text
			buttons[i].setPrefSize(BUTTON_SIZE, BUTTON_SIZE);				// size
			GridPane.setConstraints(buttons[i], i % WIDTH, i / WIDTH + 1);	// possition
			grid.getChildren().add(buttons[i]);								// add to layout
		}







		// Set action to each button
		buttons[0].setOnAction(new TwoOperands(Operator.MOD, this));
		buttons[1].setOnAction(new OneOperand(Operator.ABS, this));
		buttons[2].setOnAction(new TwoOperands(Operator.POW, this));
		buttons[3].setOnAction(new OneOperand(Operator.SQRT, this));
		buttons[4].setOnAction(new TwoOperands(Operator.ADD, this));
		buttons[5].setOnAction(new TwoOperands(Operator.SUB, this));
		buttons[6].setOnAction(new TwoOperands(Operator.MUL, this));
		buttons[7].setOnAction(new TwoOperands(Operator.DIV, this));
		buttons[8].setOnAction(new Numbers(7, this));
		buttons[9].setOnAction(new Numbers(8, this));
		buttons[10].setOnAction(new Numbers(9, this));
		buttons[11].setOnAction(new OneOperand(Operator.COS, this));
		buttons[12].setOnAction(new Numbers(4, this));
		buttons[13].setOnAction(new Numbers(5, this));
		buttons[14].setOnAction(new Numbers(6, this));
		buttons[15].setOnAction(new OneOperand(Operator.SIN, this));
		buttons[16].setOnAction(new Numbers(1, this));
		buttons[17].setOnAction(new Numbers(2, this));
		buttons[18].setOnAction(new Numbers(3, this));
		buttons[19].setOnAction(new OneOperand(Operator.TAN, this));
		buttons[20].setOnAction(new Numbers(0, this));
		buttons[21].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO implement comma into calculations.
			}

		});
		
		buttons[22].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// C-clear  /  reset calculator
				op1 = 0;
				op2 = 0;
				operation = null;
				altered = false;
				updateable = false;
				equationDisplay.setText("0");
			}

		});
		
		buttons[23].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				doMath(); // =
			}

		});







		// Enable Numpad, Enter, Escape and number keys
		scene.setOnKeyPressed(new KeyPressTrigger(buttons));







		// Show the application
		pStage.setScene(scene);
		pStage.show();
	}










	public void doMath() {
		// Do the calculation
		op2 = Double.parseDouble(equationDisplay.getText());
		double res;
		switch (operation) {
			case ADD -> res = calc.add(op1, op2);
			case SUB -> res = calc.sub(op1, op2);
			case MUL -> res = calc.mul(op1, op2);
			case DIV -> res = calc.div(op1, op2);
			case POW -> res = calc.pow(op1, op2);
			case MOD -> res = calc.mod(op1, op2);
			case SQRT -> res = calc.sqrt(op1);
			case COS -> res = calc.cos(op1);
			case SIN -> res = calc.sin(op1);
			case TAN -> res = calc.tan(op1);
			case ABS -> res = calc.abs(op1);
			default -> throw new IllegalArgumentException("Unexpected value: doMath - no operation? " + operation);
		}
		;



		// Reset for next calculation
		op1 = res;
		altered = false;
		updateable = true;
		operation = null;




		// Display result of calculation
		if (Math.rint(op1) == op1)
			equationDisplay.setText(Long.toString((long) op1));
		else
			equationDisplay.setText(Double.toString(op1));
	}











	/////////////////////////
	// Getters and Setters //
	/////////////////////////
	public double getOp1() {
		return op1;
	}

	public double getOp2() {
		return op2;
	}

	public void setOp1(double op1) {
		this.op1 = op1;
	}

	public void setOp2(double op2) {
		this.op2 = op2;
	}

	public Operator getOperation() {
		return operation;
	}

	public void setOperator(Operator operation) {
		this.operation = operation;
	}

	public String getLabelText() {
		return equationDisplay.getText();
	}

	public void setLabelText(String text) {
		equationDisplay.setText(text);
	}

	public boolean isAltered() {
		return altered;
	}

	public void setAltered(boolean altered) {
		this.altered = altered;
	}

	public boolean isUpdateable() {
		return updateable;
	}

	public void setUpdateable(boolean updateable) {
		this.updateable = updateable;
	}

}
