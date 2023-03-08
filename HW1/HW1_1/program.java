// Вычислить суммe чисел от 1 до n, а так же n! (произведение чисел от 1 до n)
// Ввод:5 Вывод: 1 + 2 + 3 + 4 + 5 = 15 , n! 1 * 2 * 3 * 4 * 5 = 120

package HW1.HW1_1;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "Cp866");// Cp866 кодировка, чтобы распознавалась кирилица
        System.out.println("Введите число больше 0:");   
        int number = scan.nextInt();
        while (number <= 0){
            System.out.println("Введите число больше 0:");//проверка на правильность введенного числа   
            number = scan.nextInt();    
        }
        scan.close();
        int fact = 1;
        int temp = number;
        while (temp > 1){
            fact *= temp;
            temp--;
        }
        System.out.printf("Факториал = %d", fact); 
        System.out.println();   
        int sum = 0;
        temp = number;
        while (temp > 0){
            sum += temp;
            temp--;
        }
        System.out.printf("Треугольное число = %d", sum);  
    } 
}
