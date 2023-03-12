// Реализовать простой калькулятор (+ - / *)
// Ввод числа ->
// Ввод знака ->
// Ввод числа ->
// Добавить логгирование

package HW2_3;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class program {
    public static void main(String[] args) throws java.io.IOException {
        Logger loging = Logger.getLogger(program.class.getName());
        String logsPath = "HW2/HW2_3/log.txt";
        FileHandler fh = new FileHandler(logsPath, true);
        loging.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение:");   
        System.out.println("Ввод числа ->");
        int number1 = scan.nextInt();
        sb.append("Результат: ").append(number1);
        loging.info("Введено первое число: " + number1);
        scan.nextLine();
        System.out.println("Ввод знака ->");
        String znak = scan.nextLine();
        sb.append(znak);
        loging.info("Введен знак: " + znak);
        System.out.println("Ввод числа ->");
        int number2 = scan.nextInt();
        sb.append(number2).append("=");
        loging.info("Введено второе число: " + number2);
        System.out.println("Результат ->");
        scan.close();
        switch(znak){
            case "+": System.out.println(number1 + number2);
                sb.append(number1 + number2);
                loging.info(sb.toString());
                break;
            case "-": System.out.println(number1 - number2);
                sb.append(number1 - number2);
                loging.info(sb.toString());
                break;
            case "*": System.out.println(number1 * number2);
                sb.append(number1 * number2);
                loging.info(sb.toString());
                break;
            case "/": double number1_d = number1;
                double number2_d = number2;
                double result = number1_d / number2_d;
                sb.append(result);
                loging.info(sb.toString());
                System.out.printf("%.2f", result);
                break;
        }
    } 
}
