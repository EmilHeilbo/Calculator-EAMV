package presentation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class Calculation implements EventHandler<ActionEvent>{

	private Operator op;
	private UI ui;
	public Calculation(Operator op,UI ui) {
		this.op = op;
		this.ui = ui;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		
	}

}