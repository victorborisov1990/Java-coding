// Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
// что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера 2) Вывод всего
// Пример:
// К: Введите   1) Добавление номера    2) Вывод всего
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите   1) Добавление номера    2) Вывод всего
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите   1) Добавление номера    2) Вывод всего
// Я: 2
// Иванов: 1242353, 547568

package HW5.HW5_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class phonebook {
    public static void main(String[] args)  {
        Map<String, String> book = new HashMap<>();
        Scanner scan = new Scanner(System.in, "Cp866");
        System.out.print("Доступные команды: \n + (добавить телефонный номер) \n w (показать все записи) \n q (выход) \n Введите команду: ");
        String cmd = scan.nextLine();
        while (!cmd.equals("q")){//////////////////////////////////////////////////////пока не введена команда выход
            switch(cmd){
                case "+": 
                    System.out.print("Введите фамилию: ");
                    String surname = scan.nextLine();
                    System.out.print("Введите телефонный номер: ");
                    String phone = scan.nextLine();
                    book.put(phone, surname);//телефон это ключ, фамилия это значение
                    break;
                case "w": 
                    Set<String> persons = new HashSet<>(book.values());//список уникальных фамилий
                    // System.out.println(persons);
                    // System.out.println(var1.getClass());
                    for (String person : persons){//для каждой фамилии
                        System.out.printf("- %s: ",person);
                        for(var item: book.entrySet()){//смотрим в парах key = phone, value = surname
                            if (person.equals(item.getValue()))//если находим фамилию == текущей уникальной фамилии
                                System.out.printf("%s; ",item.getKey());//выводим соотв. ей телефон
                        }
                        System.out.println();
                    }
                    break;
            }
            System.out.print("Доступные команды: \n + (добавить телефонный номер) \n w (показать все записи) \n q (выход) \n Введите команду: ");
            cmd = scan.nextLine();
        }
        scan.close();
    }
}
