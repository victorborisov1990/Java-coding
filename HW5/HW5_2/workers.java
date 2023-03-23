// дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся
// имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.

//нужно вывести имена, которые встерчаются больше 1 раза

package HW5.HW5_2;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class workers {
    public static void main(String[] args)  {
        //Для списка сотрудников не подходит map, тк и имя и фамилия не являются уникальными
        String [][] spisok = {{"Иван","Иванов"},{"Светлана","Петрова"},{"Кристина","Белова"},{"Анна","Мусина"},
                                {"Анна","Крутова"},{"Иван","Юрин"},{"Петр","Лыков"},{"Павел","Чернов"},{"Петр","Чернышов"},
                                {"Мария","Федорова"},{"Марина","Светлова"},{"Мария","Савина"},{"Мария","Рыкова"},
                                {"Марина","Лугова"},{"Анна","Владимирова"},{"Иван","Мечников"},{"Петр","Петин"},{"Иван","Ежов"}};
        Set <String> names = new HashSet<>();
        for( int i = 0; i < spisok.length; i++){
            names.add(spisok[i][0]);
        }
        System.out.println(names);//вывод уникального списка имен
        Map <String, Integer > data = new HashMap<>();
        for (String name : names){
            int count = 0;
            for (int i = 0; i < spisok.length; i++){
                if (name.equals(spisok[i][0])){
                    count++;
                }
            }
            if(count > 1)//если имя встречается больше 1 раза
                data.put(name, count);//добавляем в мар пару: имя - количество повторений
        }
        // System.out.println(data);//вывод пар имя и кол-во повторений
        LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();
        int maxi = data.size();
        for(int i = 0; i< maxi; i++){
            String keyOfMax = "";
            int maxValue = 0;
            for(var item: data.entrySet()){//находим пару с максимальным значением
                if(item.getValue()>maxValue){
                    maxValue = item.getValue();
                    keyOfMax = item.getKey();
                }
            }
            sorted.put(keyOfMax, maxValue);//записываем эту пару в новый мар с сохранением порядка
            data.remove(keyOfMax);//удаляем из неупорядоченного мар
            // System.out.println(data);//вывод пар имя и кол-во повторений
        }
        System.out.println(sorted);//вывод отсортированного списка имен с количеством повторений      
    }
}

