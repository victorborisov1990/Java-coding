// Вывести все простые числа от 1 до 1000

package HW1.HW1_2;

public class program {
    public static void main(String[] args) {
        System.out.println("Простые числа от 1 до 1000: ");
        for(int number = 2; number < 1000; number++){//первое простое число это 2
            Boolean isPrime = true;//для каждого проверяемого числа ставим флаг "является простым"
            for(int delitel = 2; delitel < number; delitel++){//если нацело делится на числа больше 1 и меньше самого себя
                if(number % delitel == 0) isPrime = false;//то флаг "является простым" сбрасывается
            }
            if(isPrime == true) System.out.println(number);//если флаг не сбросился при проверке делителей, то число простое
        }
    } 
}

