// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
// Ферзь может ходить во всех направлениях: по диагонали и по прямой (вверх, вниз и в сторону). 
// Более того, — на любое расстояние. Перепрыгивать через другие фигуры не разрешено (это может делать только конь). 
// И вывести Доску.
// Пример вывода доски 8x8

// x 0 0 0 0 0 0 0
// 0 0 0 0 0 x 0 0
// 0 0 x 0 0 0 0 0
// 0 0 0 0 x 0 0 0
// 0 0 0 0 0 0 0 x 
// 0 x 0 0 0 0 0 0
// 0 0 0 x 0 0 0 0 
// 0 0 0 0 0 0 x 0


package HW5.HW5_3;

// import java.util.Arrays;//для отладки

public class chessmate {

    static int actualRow = 0; //текущая рабочая строка
    static int [] positionFerzInRow = {0,0,0,0,0,0,0,0};//в каждой ячейке, соответствующей строке, будет хранится положение ферзя в строке (0..7).нач положение 0 (1 столбец)
    public static void main(String[] args)  {              
        boolean isDone = false;//флаг решения задачи
        while (!isDone){//пока не решили задачу - ищем решение
            if (possiblePosition() == true && actualRow == 7){
                isDone = true;//если позиция в последней строке определена, значит задача решена
            } else if (positionFerzInRow[actualRow] > 7){//дошли до конца сроки и не нашли возможную позицию, нужно искать новую на предыд-й строке
                positionFerzInRow[actualRow] = 0;//возвращаем позицию на 0, тк после изменения вышестоящей позиции на этой строке нужно будет все перепроверить
                positionFerzInRow[--actualRow]++;//переход к предыдущ строке и увеличение в ней позиции на 1
            }else if (!possiblePosition()){//если не возможно поставить ферзя в текущей позиции - увеличить позицию в строке
                positionFerzInRow[actualRow]++;
            }else if (possiblePosition()){//если возможно - переход к новой строке
                actualRow++;
            }
            // System.out.println(Arrays.toString(positionFerzInRow));//для отладки
        }
        printChess();
    }
    
    public static boolean possiblePosition (){
        if (actualRow == 0){
            return true;
        }
        for (int i = 0; i < actualRow; i++){//проверяем позиции ферзей в строках выше текущей строки
            if (positionFerzInRow[actualRow] == positionFerzInRow[i] || //если ферзи стоят друг под другом
                ((Math.abs(positionFerzInRow[actualRow] - positionFerzInRow[i])) == (actualRow-i))){ //или по диагоналям
                return false;
            }
        }
        return true;
    }

    public static void printChess (){
        for(int i = 0; i<positionFerzInRow.length; i++){
            for(int j = 0; j<positionFerzInRow.length; j++){
                if (j == positionFerzInRow[i]){
                    System.out.print("x\t");
                } else{
                    System.out.print("0\t");
                }    
            }
            System.out.println();
            System.out.println();
        }
    }
}
