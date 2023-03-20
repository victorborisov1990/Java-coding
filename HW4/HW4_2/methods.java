// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.

package HW4.HW4_2;

import java.util.LinkedList;
import java.util.Scanner;

public class methods {
    
    public static void enqueue (LinkedList <Integer> linklist, int newElement) {//помещает элемент в конец очереди
        linklist.add(newElement);
    }
    
    public static Integer dequeue (LinkedList <Integer> linklist) {//возвращает первый элемент из очереди и удаляет его
        if(!linklist.isEmpty())//если список не пустой        
            return linklist.pollFirst();//возвр-т 1й элемент и удаляет его. Remove делает то же, но выдаст ошибку, если список пуст, а poll вернет null
        else
            return -1;
    }

    public static Integer first (LinkedList <Integer> list) {//возвращает первый элемент из очереди, не удаляя 
        if(!list.isEmpty())//если список не пустой        
            return list.peekFirst();//возвр-т 1й элемент. getFirst делает то же, но выдаст ошибку, если список пуст, а peekFirst вернет null
        else
            return -1;
    }
    

    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        LinkedList <Integer> numbers = new LinkedList<>();
        Integer number = 0;
        System.out.print("Доступные команды: \n + (добавить эл-т) \n - (удалить 1й эл-т) \n f (показать 1й эл-т) \n q (выход) \n Введите команду: ");
        String cmd = scan.nextLine();
        while (!cmd.equals("q")){//////////////////////////////////////////////////////пока не введена команда выход
            switch(cmd){
                case "+": 
                    System.out.print("Введите число: ");
                    number = scan.nextInt();
                    scan.nextLine();
                    enqueue(numbers, number);
                    System.out.println(numbers);
                    break;
                case "-": 
                    number = dequeue(numbers);
                    if (number == -1)
                        System.out.println("Очередь пуста, нечего удалять");
                    else 
                        System.out.printf("Удален элемент: %d\n", number);
                        System.out.println(numbers);
                    break;
                case "f": 
                    number = first(numbers);
                    if (number == -1)
                        System.out.println("Очередь пуста, нет 1го элемента");
                    else 
                        System.out.printf("1 элемент очереди: %d\n", number);
                        System.out.println(numbers);
                    break;
                // default:
                //     System.out.println("Неверная команда");
                //     break;
            }
            System.out.print("Доступные команды: \n + (добавить эл-т) \n - (удалить 1й эл-т) \n f (показать 1й эл-т) \n q (выход) \n Введите команду: ");
            cmd = scan.nextLine();
        }
        // enqueue(numbers, 10);
        // enqueue(numbers, 7);
        // enqueue(numbers, 23);
        // enqueue(numbers, 44);
        // System.out.println(numbers);
        // System.out.println(dequeue(numbers));
        // System.out.println(numbers);
        // System.out.println(first(numbers));
        // System.out.println(dequeue(numbers));
        // System.out.println(dequeue(numbers));
        // System.out.println(dequeue(numbers));
        // System.out.println(dequeue(numbers));
        // System.out.println(numbers);

        scan.close();
    } 

    
}



