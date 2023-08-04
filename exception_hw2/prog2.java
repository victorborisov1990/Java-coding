package exception_hw2;

import java.util.Scanner;

/*
Задача 2:
Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление. Если второе число равно нулю, 
программа должна выбрасывать исключение DivisionByZeroException с сообщением "Деление на ноль недопустимо". В противном случае, 
программа должна выводить результат деления.
 */

public class prog2 {
    public static void main(String[] args) throws DivisionByZeroException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int number1 = scan.nextInt();
        scan.nextLine();
        System.out.println("Введите второе число:");
        int number2 = scan.nextInt();
        scan.close();
        if (number2 == 0)
            throw new DivisionByZeroException();
        else{
            double result = number1 / number2;
            System.out.println("Result = " + result);
        }
    }
 
    public static class DivisionByZeroException extends Exception{
        public DivisionByZeroException(){
            super("Деление на ноль недопустимо");
        }
        
    }
}
