package presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OneOperand implements EventHandler<ActionEvent> {


    private Operator op;
    private UI ui;

    public OneOperand(Operator op, UI ui) {
        this.op = op;
        this.ui = ui;
    }


    @Override
    public void handle(ActionEvent arg0) {
        ui.setOperator(op);
        ui.setOp1(Double.parseDouble(ui.getLabelText()));
        ui.doMath();
    }

}
