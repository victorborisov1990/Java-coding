package exception_hw3;

import java.util.Scanner;

/*
Задача 1: Проверка пароля (Основы языка Java, операторы, ветвления)
Создайте класс PasswordVerifier. Этот класс должен содержать метод, который принимает строку пароля и проверяет его на соответствие следующим правилам:
Пароль должен быть не менее 8 символов.
Пароль должен содержать хотя бы одну цифру.
Пароль должен содержать хотя бы одну заглавную букву.
Метод должен выбрасывать исключение, если пароль не соответствует какому-либо из этих правил.
 */
public class task1 {
    public static void main(String[] args) throws PswdSecurityException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите пароль:");
        String password = scan.nextLine();
        scan.close();
        PasswordVerifier ckecker = new PasswordVerifier();
        if(ckecker.ckeck(password))
            System.out.println("Пароль соответстует условиям");
        else
            throw new PswdSecurityException();
    }

    public static class PasswordVerifier{
        
        public Boolean ckeck(String password){
            if(password.length() >= 8)//проверка длины
                if(password.matches("^[a-zA-Z]*[0-9]+[a-zA-Z0-9]*$"))//проверка содержит ли цифры
                    if(password.matches("^[a-z0-9]*[A-Z]+[a-zA-Z0-9]*$"))//проверка содержит ли Заглавную букву
                        return true;
            return false;
        }
    }

    public static class PswdSecurityException extends Exception{
        public PswdSecurityException(){
            super("Пароль не соответстует критериям безопасности");
        }
    }
}



