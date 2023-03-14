// (Дополнительно) Реализовать алгоритм сортировки слиянием

package HW3.HW3_1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class sort {
    public static int [] zapolnenie (int [] numbers) {//заполняет массив случайными числами
        Random rand = new Random();
        for(int i = 0; i < numbers.length; i++){ 
            numbers[i] = rand.nextInt(10);
        }
        System.out.println(Arrays.toString(numbers));
        return numbers;
    }
    
    public static int [] mergeArray(int [] arrayA, int [] arrayB) {

        int [] arrayC = new int[arrayA.length + arrayB.length];//результирующий массив длинной как сумма длинн массивов
        int positionA = 0, positionB = 0;//позиции для корректировки положения и невыхода за размер массива
        
        for (int i = 0; i < arrayC.length; i++) {
            if (i - positionA >= arrayA.length){//если на текущей итерации цикла вышли за границы массива А, значит
            arrayC[i] = arrayB[i - positionB];//из него забрали все элементы. берем элементы из В по очереди, тк он сортированный 
            positionB++;
            } else if (i - positionB >= arrayB.length) {//если на текущей итерации цикла вышли за границы массива В, значит
            arrayC[i] = arrayA[i - positionA];//из него забрали все элементы. берем элементы из А по очереди, тк он сортированный 
            positionA++;
            } else if (arrayA[i - positionA] < arrayB[i - positionB]) {//если элемент массива А мненьше элемента из В, 
            arrayC[i] = arrayA[i - positionA];//то добавляем эл-т А в i-й элемент массива С
            positionB++;//увеличиваем позицию В, чтобы при увеличении i мы не пропустили элемент из В, который не попал в С после проверки
            } else {
            arrayC[i] = arrayB[i - positionB];//то же для В
            positionA++;
            }
        }
        return arrayC;//возврат объединенного сортированного массива
    }    
    
    public static int [] sortArray(int[] arrayA){
        if (arrayA == null) {//если массив пустой
            return null;
        }
        if (arrayA.length < 2) {//если массив из одного элемента, то он отсортирован
            return arrayA; 
        }
        int [] arrayB = new int[arrayA.length / 2];//разделение массива на левую и правую часть
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);//левая часть
        int [] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);//правая часть

        arrayB = sortArray(arrayB); // Массивы делятся до тех пор, пока не вернут отсортированные массивы, сначала единичной длины
        arrayC = sortArray(arrayC); // по мере возврата по стеку вызовов, длина возвращаемых массивов будет увеличиваться
        return mergeArray(arrayB, arrayC);//2 сортированных массива объединяются и сортируются
    }
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите рзамер массива: ");
        int size = scan.nextInt();
        scan.close();
        int [] array = new int [size];
        array = sortArray(zapolnenie(array));
        System.out.println(Arrays.toString(array));
    } 
}
