// Дана строка (получение через обычный текстовый файл!!!)

// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"

// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].

// Пример вывода в консоль:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
package HW2_2;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class program {

    public static void parser (String record){
        StringBuilder sb = new StringBuilder();
        // "фамилия":"Иванов","оценка":"5","предмет":"Математика"
        // от("фамилия":") surname до(","оценка":")от mark до(","предмет":")от subject до(")
        String beforeSurneme = "\"фамилия\":\"";//( "фамилия":" )
        String beforeMark = "\",\"оценка\":\""; //(","оценка":")
        String beforeSubject = "\",\"предмет\":\"";//(","предмет":")
        String surname = record.substring(record.indexOf(beforeSurneme)+beforeSurneme.length(), record.indexOf(beforeMark));
        String mark = record.substring(record.indexOf(beforeMark)+beforeMark.length(), record.indexOf(beforeSubject));
        String subject = record.substring(record.indexOf(beforeSubject)+beforeSubject.length(), record.lastIndexOf("\"")); 
        sb.append("Студент ").append(surname).append(" получил(a) ").append(mark).append(" по предмету ").append(subject);
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws Exception {
        File file = new File("HW2/HW2_2/stud.txt");
        FileReader fr = new FileReader(file);
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()) {//пока есть очередная строка для считывания
            parser(scan.nextLine());//передаем строку в парсер, чтобы выявить нужные данные
        }
        fr.close();
        scan.close();
        
    } 
}
