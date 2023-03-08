// Реализовать простой калькулятор (+ - / *)
// Ввод числа ->
// Ввод знака ->
// Ввод числа ->

package HW1.HW1_3;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение:");   
        System.out.println("Ввод числа ->");
        int number1 = scan.nextInt();
        scan.nextLine();
        System.out.println("Ввод знака ->");
        String znak = scan.nextLine();
        System.out.println("Ввод числа ->");
        int number2 = scan.nextInt();
        System.out.println("Результат ->");
        scan.close();
        switch(znak){
            case "+": System.out.println(number1 + number2);
                break;
            case "-": System.out.println(number1 - number2);
                break;
            case "*": System.out.println(number1 * number2);
                break;
            case "/": double number1_d = number1;
                double number2_d = number2;
                double result = number1_d / number2_d;
                System.out.printf("%.2f", result);
                break;
        }
    }
}
