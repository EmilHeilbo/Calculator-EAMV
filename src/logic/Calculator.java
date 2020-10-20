package logic;

//import java.util.Scanner;

public class Calculator implements CalcInterface {
    /*private static double[] buffer = new double[30];
    private static char[] operand = new char[29];
    private static byte[] order = new byte[29];
    private static byte opCount = 0, bufferCount = 0;

    public static void main(String[] args) {
        CalcHistory history = new CalcHistory();
        var scan = new Scanner(System.in);
        String input = scan.nextLine();

        if(!checkInput(input))
            System.exit(0);

    }

    static boolean checkInput(String s) {
        // Check if string only contains mathematical operands
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > '(' || s.charAt(i) < '9' && s.charAt(i) != ' ' && !s.substring(i + 1, i + 3).equals("cos") && !s.substring(i + 1, i + 3).equals("sin") && !s.substring(i + 1, i + 3).equals("tan"))
                return false;
            if (s.charAt(i) == ' ');
            else if (s.charAt(i) > '0' && s.charAt(i) <= '(')
                put(s.charAt(i));
            else if (s.charAt(i) <= '0' && s.charAt(i) >= '9')
                buffer[bufferCount] *= 10 + (double) s.charAt(i);
            else if (s.substring(i + 1, i + 4).equals("sqrt")) {
                put('√');
                i += 3;
            }
            else if (s.substring(i + 1, i + 3).equals("cos")) {
                put('c');
                i += 2;
            }
            else if (s.substring(i + 1, i + 3).equals("sin")) {
                put('s');
                i += 2;
            }
            else if (s.substring(i + 1, i + 3).equals("tan")) {
                put('t');
                i += 2;
            }
        }
        return true;
    }

    static void put(char c) {
        operand[opCount] = c;
        opCount++;
        if (buffer[bufferCount] != 0)
            bufferCount++;
    }

    void handleEquation() {

    }*/

    public double op1 = 0, op2 = 0, buffer;

    public enum Operator {ADD, SUB, MUL, DIV, POW, MOD}

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
