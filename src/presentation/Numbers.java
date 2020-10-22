package presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Numbers implements EventHandler<ActionEvent> {

    private int number;
    private UI ui;
    

	public Numbers(int number, UI ui){
        this.number = number;
        this.ui = ui;
    }


	@Override
	public void handle(ActionEvent arg0) {
        if(ui.getOperation()!=null) ui.setAltered(true);
        if(ui.getLabelText().equals("0")| (ui.isAltered()&ui.isUpdateable())) {
            ui.setLabelText(""+number);
            ui.setUpdateable(false);
        } else {
            ui.setLabelText(ui.getLabelText()+number);
        }
	}
}
