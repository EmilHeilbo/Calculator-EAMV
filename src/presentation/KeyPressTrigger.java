package presentation;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;

public class KeyPressTrigger implements EventHandler<KeyEvent> {

    private Button[] buttons;

    public KeyPressTrigger(Button[] buttons) {
        this.buttons = buttons;
    }

    @Override
    public void handle(KeyEvent e) {
        switch (e.getCode()) {
            case DIGIT0 -> buttons[20].fire();
            case DIGIT1 -> buttons[16].fire();
            case DIGIT2 -> buttons[17].fire();
            case DIGIT3 -> buttons[18].fire();
            case DIGIT4 -> buttons[12].fire();
            case DIGIT5 -> buttons[13].fire();
            case DIGIT6 -> buttons[14].fire();
            case DIGIT7 -> buttons[8].fire();
            case DIGIT8 -> buttons[9].fire();
            case DIGIT9 -> buttons[10].fire();
            case NUMPAD0 -> buttons[20].fire();
            case NUMPAD1 -> buttons[16].fire();
            case NUMPAD2 -> buttons[17].fire();
            case NUMPAD3 -> buttons[18].fire();
            case NUMPAD4 -> buttons[12].fire();
            case NUMPAD5 -> buttons[13].fire();
            case NUMPAD6 -> buttons[14].fire();
            case NUMPAD7 -> buttons[8].fire();
            case NUMPAD8 -> buttons[9].fire();
            case NUMPAD9 -> buttons[10].fire();
            case ENTER -> buttons[23].fire();
            case MINUS -> buttons[5].fire();
            case ADD -> buttons[4].fire();
            case MULTIPLY -> buttons[6].fire();
            case DIVIDE -> buttons[7].fire();
            case POWER -> buttons[2].fire();
            case ESCAPE -> buttons[22].fire();
            default -> throw new IllegalArgumentException("Unexpected value: " + e.getCode());
        }
        ;
    }

}
