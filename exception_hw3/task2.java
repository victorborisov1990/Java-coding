package exception_hw3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

/*
Задача 2: Файловый менеджер (ООП, исключения)

Создайте класс FileManager. Этот класс должен иметь методы для выполнения основных операций с файлами: чтение, 
запись и копирование. Каждый из этих методов должен выбрасывать соответствующее исключение, если в процессе 
выполнения операции произошла ошибка (например, FileNotFoundException, если файл не найден).
 */
public class task2 {
    public static void main(String[] args){
        String path = "exception_hw3/test.txt";
        FileManager fm = new FileManager();
        fm.copy(path, "exception_hw3/test2.txt");
    }


    public static class FileManager{
        // String path;
        public FileManager(){
        }

        public String read(String path) {
            String line;
            StringBuilder sb = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(path))){
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                System.out.println("Чтение...ок!"); 
            }
            catch ( FileNotFoundException  e){
                System.out.println("Ошибка файла: " + e.getClass().getSimpleName());
            }
            catch ( IOException  e){
                System.out.println("Ошибка чтения: " + e.getClass().getSimpleName());
            }
            catch ( Exception  e){
                System.out.println("Ошибка: " + e.getClass().getSimpleName());
            }
            return sb.toString();
        }

        public void write(String path, String info) {
            try (FileWriter writer = new FileWriter(path)){
                writer.write(info); 
                System.out.println("Запись...ок!"); 
            }
            catch ( FileNotFoundException  e){
                System.out.println("Ошибка файла: " + e.getClass().getSimpleName());
            }
            catch ( IOException  e){
                System.out.println("Ошибка чтения: " + e.getClass().getSimpleName());
            }
            catch ( Exception  e){
                System.out.println("Ошибка: " + e.getClass().getSimpleName());
            }
        }

        public void copy(String src, String dst) {
            write(dst, read(src));
            System.out.println("Копирование завершено");
        }

    }
}
