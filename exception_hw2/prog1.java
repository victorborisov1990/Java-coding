package exception_hw2;

import java.util.Scanner;

/* 
Задача 1:
Напишите программу, которая запрашивает у пользователя число и проверяет, является ли оно положительным. 
Если число отрицательное или равно нулю, программа должна выбрасывать исключение InvalidNumberException 
с сообщением "Некорректное число".
В противном случае, программа должна выводить сообщение "Число корректно".
*/
public class prog1 {

    public static void main(String[] args) throws InvalidNumberException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите положительное число");
        int number = scan.nextInt();
        scan.close();
        if (number > 0)
            System.out.println("Число корректно");
        else
            throw new InvalidNumberException();

    }
 
    public static class InvalidNumberException extends Exception{
        public InvalidNumberException(){
            super("Некорректное число");
        }
        
    }
}