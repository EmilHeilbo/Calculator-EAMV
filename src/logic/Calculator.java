package logic;

public class Calculator implements CalcInterface {

    public double add(double op1, double op2) {
        return op1 + op2;
    }

    public double sub(double op1, double op2) {
        return op1 - op2;
    }

    public double mul(double op1, double op2) {
        return op1 * op2;
    }

    public double div(double op1, double op2) {
        return op1 / op2;
    }

    public double pow(double op1, double op2) {
        return Math.pow(op1, op2);
    }

    public double mod(double op1, double op2) {
        return op1 % op2;
    }

    public double sqrt(double op1) {
        return Math.sqrt(op1);
    }

    public double cos(double op1) {
        return Math.cos(op1);
    }

    public double sin(double op1) {
        return Math.sin(op1);
    }

    public double tan(double op1) {
        return Math.tan(op1);
    }

    public double abs(double op1) {
        return Math.abs(op1);
    }
}
