package presentation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class Calculation implements EventHandler<ActionEvent>{

	private Operator op;
	public Calculation(Operator op) {
		this.op = op;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		
	}

}