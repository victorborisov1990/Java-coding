// Пусть дан произвольный список целых чисел, удалить из него чётные числа
package HW3.HW3_2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RemoveEven {
    
    public static ArrayList<Integer> zapolnenie (ArrayList<Integer> numbers, int size) {//заполняет массив случайными числами
        Random rand = new Random();
        for(int i = 0; i < size; i++){ 
            numbers.add(rand.nextInt(10));
        }
        System.out.println(numbers);
        return numbers;
    }
    
    public static void removeEven (ArrayList<Integer> numbers) {//удаляет четные числа
        for(int i = numbers.size()-1; i >= 0; i--){ 
            if(numbers.get(i) % 2 == 0 ){
                numbers.remove(i);
            }
        }
        System.out.println(numbers);
        
    }
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите рзамер массива: ");
        int number = scan.nextInt();
        scan.close();
        ArrayList<Integer> list = new ArrayList<>();
        removeEven(zapolnenie(list, number));
    }
}