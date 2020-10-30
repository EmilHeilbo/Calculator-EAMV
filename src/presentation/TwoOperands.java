package presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TwoOperands implements EventHandler<ActionEvent> {

    private Operator op;
    private UI ui;

    public TwoOperands(Operator op, UI ui) {
        this.op = op;
        this.ui = ui;
    }

    @Override
    public void handle(ActionEvent arg0) {
        if (ui.getOperation() != null) ui.doMath();
        if (ui.getOperation() == null) {
            ui.setOp1(Double.parseDouble(ui.getLabelText()));
            ui.setOperator(op);
            ui.setUpdatable(true);
        } else {
            if (!ui.isAltered()) {
                ui.setOperator(op);
            } else {
                ui.doMath();
            }
        }
    }
}