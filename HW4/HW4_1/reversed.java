// Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.

package HW4.HW4_1;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class reversed {
    
    public static LinkedList <Integer> reverse (LinkedList <Integer> list) {//вернет “перевернутый” список
        LinkedList <Integer> result = new LinkedList<>();
        for(int i = 0; i < list.size() ; i++){ //int i = list.size()-1; i >=0 ; i--
            result.addFirst(list.get(i));//каждый последующий добавляем в начало списка, в итоге последний окажется первым 
        }
        return result;
    }
    
    public static LinkedList <Integer> zapolnenie (LinkedList <Integer> linklist, int size) {//заполняет массив случайными числами
        Random rand = new Random();
        for(int i = 0; i < size; i++){ 
            linklist.add(rand.nextInt(10));//добавляем в конец 
        }
        System.out.println(linklist);
        return linklist;
    }
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scan.nextInt();
        scan.close();
        LinkedList <Integer> numbers = new LinkedList<>();
        numbers = zapolnenie(numbers, size);
        System.out.println(reverse(numbers));
    } 
}
