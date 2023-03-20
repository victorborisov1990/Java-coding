// В калькулятор добавьте возможность отменить последнюю операцию.
// Дополнительно каскадная отмена - отмена нескольких операций


package HW4.HW4_3;
import java.util.Scanner;
import java.util.Stack;

public class calc {
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Stack <Double> st = new Stack<>();
        Double result = 0.0;
        Double number1 = 0.0;
        Boolean haveNumber1 = false;// флаг, чтобы нельзя было ввести 1-e число 2й раз
        System.out.print("Доступные команды: \n n - ввод числа \n q - выход из программы \n Введите команду: ");
        String cmd = scan.nextLine();
        while (!cmd.equals("q")){//////////////////////////////////////////////////////пока не введена команда выход
            if(cmd.equals("n") && haveNumber1 == false){///////////////////////////////////////////////////////ввод первого числа
                System.out.print("Ввод числа ->");//потом заменить на метод!!!!!!!!!!!!!!!!!
                number1 = Double.valueOf(scan.nextInt());//вводить целые числа (вводить в формате 0.0 неудобно) и конвертировать в дабл
                result = number1;
                haveNumber1 = true;
                scan.nextLine();
            }else if(cmd.equals("z")){/////////////////////////////////////////////////если введена команда отмена
                System.out.print("отмена ****************************");
                if(st.empty()){//если стэк резултьатов пуст, значит мы отменили все операции 
                    result = number1;//тогда выводим первое введенное число. Дальше него отменить нельзя
                    System.out.println(result);
                }
                else{//если стэк резултьатов не пуст, значит нужно записать в result и вывести на экран предпоследний результат 
                    st.pop();//удаляем результат последней операции
                    if(!st.empty()){//если после удаления стэк резултьатов не пуст, можно обратиться к более старой операции
                        result = st.peek();//делаем текущим результат предпоследней операции
                        System.out.println(result);
                    }
                    else{//В случае, если в стэке была одна операция и после удаления он опустел, то записываем в result
                        result = number1;
                        System.out.println(result);
                    }
                }
            }else if (cmd.equals("f")){////////////////////////////////////////////////введена команда на ввод арифмет операции
                System.out.printf("Пред рез - > %.2f\n", result);
                System.out.print("Ввод знака -> ");
                String znak = scan.nextLine();
                System.out.print("Ввод числа -> ");
                Double number2 = Double.valueOf(scan.nextInt());
                scan.nextLine();
                switch(znak){
                    case "+": 
                        result = result + number2;
                        st.push(result);
                        System.out.print("ответ:     ");
                        System.out.printf("%.2f\n", result);
                        break;
                    case "-": 
                        result = result - number2;
                        st.push(result);
                        System.out.print("ответ:     ");
                        System.out.printf("%.2f\n", result);
                        break;
                    case "*": 
                        result = result * number2;
                        st.push(result);
                        System.out.print("ответ:     ");
                        System.out.printf("%.2f\n", result);
                        break;
                    case "/": 
                        result = result / number2;
                        st.push(result);
                        System.out.print("ответ:     ");
                        System.out.printf("%.2f\n", result);
                        break;
                }
            }else
                System.out.println("Неизвестная команда");
            System.out.print("Доступные команды: \n f - арифм.операция \n z - отмена последней операции\n  q - выход из программы \n Введите команду: ");
            cmd = scan.nextLine();                    
        }
    scan.close();    
    }
}
