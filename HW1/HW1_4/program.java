// *(ДОПОЛНИТЕЛЬНАЯ) +Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.
// Ввод: 2? + ?5 = 69    Вывод: 24 + 45 = 69

package HW1.HW1_4;

import java.util.Scanner;

public class program {
    
    public static void proverka (String uravnenie){
        uravnenie = uravnenie.replace(" ", "");//удаляем пробелы
        int first_q_index = uravnenie.indexOf("?");
        int second_q_index = uravnenie.indexOf("?", first_q_index+1);
        int plus_index = uravnenie.indexOf("+");
        int equil_index = uravnenie.indexOf("=");
        // System.out.print("Индекс первого знака '?': ");
        // System.out.println(first_q_index);
        // System.out.print("Индекс второго знака '?': ");
        // System.out.println(second_q_index);
        // System.out.print("Индекс знака '+': ");
        // System.out.println(plus_index);
        // System.out.print("Индекс знака '=': ");
        // System.out.println(equil_index);
        String temp_str = uravnenie;
        StringBuilder sb = new StringBuilder(temp_str);
        Boolean reshaemo = false;
        while (reshaemo == false){
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    //temp_str.charAt(first_q_index);
                    sb.setCharAt(first_q_index, (char)(i + '0'));//замена по индексу первого вопроса на i. к цифре нужно добавить '0' иначе конверт в char не работает
                    sb.setCharAt(second_q_index, (char)(j + '0'));//замена по индексу второго вопроса на j. 
                    temp_str = sb.toString();
                    // System.out.println("*********************************************");
                    // System.out.println(temp_str);//проверка работы замены
    
                    try{
                        int slog1 = Integer.parseInt(temp_str.substring(0, plus_index));//первое число находится до +
                        // System.out.println (slog1);
                        int slog2 = Integer.parseInt(temp_str.substring(plus_index + 1, equil_index));//второе число между + и =
                        // System.out.println (slog2);
                        int res = Integer.parseInt(temp_str.substring(equil_index + 1));//результат после = и до конца
                        // System.out.println (res);
                        if(slog1 + slog2 == res){
                            reshaemo = true;
                            System.out.print ("Решение: ");
                            System.out.println (temp_str);
                            break;//выход из внутр цикла
                        }
                    }
                    catch (NumberFormatException e){
                        //e.printStackTrace();
                        System.err.println("Неправильный формат строки!");
                    }
                }
                if(reshaemo == true) break;//выход из внешнего цикла
            }
            if(reshaemo == false){//если дошли до конца цикла и не нашли решение
                System.out.println ("Нет решения!");
                reshaemo = true;//для выхода из while
            }             
        }        
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение вида q + w = e (q, w, e >= 0).Скройте 2 цифры в левой части знаком '?':");   
        String text = scan.nextLine();
        scan.close();
        proverka(text);
    }
}