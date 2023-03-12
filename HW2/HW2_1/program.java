// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.


package HW2_1;

import java.util.Scanner;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class program {

    public static void sorting (int[] arr) throws java.io.IOException {
        Logger loging = Logger.getLogger(program.class.getName());
        String logsPath = "HW2/HW2_1/log.txt";
        FileHandler fh = new FileHandler(logsPath, false);
        loging.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        for (int i = 0; i < arr.length -1; i++){//количество проходов
            for(int j = 0; j < arr.length -1 -i; j++ ){// проход по массиву
                if(arr[j] > arr[j + 1]){//сравнение пар
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
                loging.info(Arrays.toString(arr));//логгирование каждой перестановки
            }
            loging.info("*************************************************************");//разделитель между проходами
        }
        System.out.print("Отсортированный массив: ");
        System.out.println(Arrays.toString(arr));
    }
    
    public static void main(String[] args) throws java.io.IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размер массива: ");   
        int size = scan.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            System.out.printf("Введите %d элемент массива -> ", i+1);
            array[i] = scan.nextInt();
        }
        scan.close();
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(array));
        sorting (array);
    } 
    
    
}
