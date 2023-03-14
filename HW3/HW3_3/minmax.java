// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф. из этого списка.
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class minmax{
    
    public static ArrayList<Integer> Zapolnenie (ArrayList<Integer> numbers, int size) {//заполняет массив случайными числами
        Random rand = new Random();
        for(int i = 0; i < size; i++){ 
            numbers.add(rand.nextInt(10));
        }
        System.out.println(numbers);
        return numbers;
    }
    
    public static double Average(ArrayList<Integer> numbers) {
      int sum = 0;
      double sum_d = 0;
      if(!numbers.isEmpty()) {
        for (Integer number : numbers) {
            sum += number;
        }
        sum_d = sum;
        return sum_d / numbers.size();
      }
      return sum_d;
    }
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите рзамер массива: ");
        int number = scan.nextInt();
        scan.close();
        ArrayList<Integer> list = new ArrayList<>();
        list = Zapolnenie(list, number);
        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));
        System.out.println(Average(list));
    }
}