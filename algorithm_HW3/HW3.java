package algorithm_HW3;

// import LinkedListT;

public class HW3 {
    
    public static void main(String[] args) {
        
        LinkedListT<Integer> numbers = new LinkedListT<>();
        numbers.add(1);
        numbers.add(7);
        numbers.add(0);
        numbers.add(5);
        numbers.add(-3);
        numbers.addFirst(10);


        numbers.print();
        numbers = numbers.reverse();
        numbers.print();

    }
}
