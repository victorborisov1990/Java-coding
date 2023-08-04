package exception_hw2;

import java.util.Scanner;

/*
Задача3: - по желанию
Напишите программу, которая запрашивает у пользователя три числа и выполняет следующие проверки:

Если первое число больше 100, выбросить исключение NumberOutOfRangeException с сообщением 
"Первое число вне допустимого диапазона".
Если второе число меньше 0, выбросить исключение NumberOutOfRangeException с сообщением 
"Второе число вне допустимого диапазона".
Если сумма первого и второго чисел меньше 10, выбросить исключение NumberSumException с сообщением 
"Сумма первого и второго чисел слишком мала".
Если третье число равно 0, выбросить исключение DivisionByZeroException с сообщением "Деление на ноль недопустимо".
В противном случае, программа должна выводить сообщение "Проверка пройдена успешно".
- необходимо создать 3 класса собвстенных исключений
 */

public class prog3 {

    public static void main(String[] args) throws   NumberOutOfRangeException,
                                                    NumberSumException,
                                                    DivisionByZeroException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int number1 = scan.nextInt();
        scan.nextLine();
        System.out.println("Введите второе число:");
        int number2 = scan.nextInt();
        scan.nextLine();
        System.out.println("Введите третье число:");
        int number3 = scan.nextInt();
        scan.close();
        if (number1 > 100)
            throw new NumberOutOfRangeException("Первое число вне допустимого диапазона");
        else if (number2 < 0)
            throw new NumberOutOfRangeException("Второе число вне допустимого диапазона");
        else if (number1 + number2 < 10)
            throw new NumberSumException();
        else if (number3 == 0)
            throw new DivisionByZeroException();
        else
          System.out.println("Проверка пройдена успешно");
        
    }
 
    public static class NumberOutOfRangeException extends Exception{
        public NumberOutOfRangeException(String message){
            super(message);
        }
        
    }
    
    public static class NumberSumException extends Exception{
        public NumberSumException(){
            super("Сумма первого и второго чисел слишком мала");
        }
        
    }

    public static class DivisionByZeroException extends Exception{
        public DivisionByZeroException(){
            super("Деление на ноль недопустимо");
        }
        
    }


}
