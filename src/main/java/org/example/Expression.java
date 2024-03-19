package org.example;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class Expression {
    /**
     * Метод для вычисления математического выражения.
     * @param expression математическое выражение для вычисления
     * @return результат вычисления выражения
     * @throws ArithmeticException если произошла ошибка при вычислении выражения
     */
    public static int calculate(String expression) {
        int result;
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
            Object resultObj = engine.eval(expression);
            if (resultObj instanceof Integer) {
                result = (int) resultObj;
                System.out.println("Результат: " + result);
            } else {
                result = Integer.parseInt(resultObj.toString());
                System.out.println("Результат: " + result);
            }
        } catch (ArithmeticException e) {
            throw e;
        } catch (ScriptException | NumberFormatException e) {
            throw new ArithmeticException("Деление на ноль или некорректное выражение.");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print("Введите математическое выражение: ");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        calculate(expression);
    }
}