package presentation;

import logic.*;

public class UI {
    public static void main(String[] args) {
        var calc = new Calculator();
        System.out.println(calc.add(1, 6));
    }
}
