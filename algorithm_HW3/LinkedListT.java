package algorithm_HW3;

public class LinkedListT<T extends Comparable<T>> {
    private Node root;
    private int size;

    public void add(T value) {
        if (root == null) {
            root = new Node(value);
            size = 1;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.next = new Node(value);
        size++;
    }

    public void addFirst(T value) {
        if (root == null) {
            root = new Node(value);
            size = 1;
            return;
        }
        Node temp = root;
        root = new Node(value);
        root.next = temp;
        size++;
    }

    public LinkedListT reverse(){
        LinkedListT<T> reversedList = new LinkedListT<>();
        Node currentNode = root;
        while (currentNode != null) {
            reversedList.addFirst(currentNode.value);
            currentNode = currentNode.next;
        }
        return reversedList;
    }

    public void addSorted(T value) {
        if (root == null) {
            root = new Node(value);
            size = 1;
            return;
        }
        if (root.value.compareTo(value) > 0) {
            Node newNode = new Node(value);
            newNode.next = root;
            root = newNode;
            size++;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value.compareTo(value) > 0) {
                Node newNode = new Node(value);
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                size++;
                return;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(value);
        size++;
    }

    public boolean remove(T value) {
        if (root == null)
            return false;
        if (root.value.compareTo(value) == 0) {
            root = root.next;
            size--;
            return true;
        }
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value.compareTo(value) == 0) {
                currentNode.next = currentNode.next.next;
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            root = root.next;
            size--;
            return;
        }
        Node preDeleted = this.getNode(index - 1);
        preDeleted.next = preDeleted.next.next;
        size--;
    }

    public int removeAll(T value) {
        int prevSize = size;
        while (root != null && root.value.compareTo(value) == 0) {
            root = root.next;
            size--;
        }
        if (root == null)
            return prevSize - size;
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value.compareTo(value) == 0) {
                currentNode.next = currentNode.next.next;
                size--;
            } else
                currentNode = currentNode.next;
        }
        return prevSize - size;
    }

    public void quickSort() {
        quickSort(0, size - 1);
    }

    private void quickSort(int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        T pivot = this.getValue((leftMarker + rightMarker) / 2);
        while (leftMarker <= rightMarker) {
            while (this.getValue(leftMarker).compareTo(pivot) < 0)
                leftMarker++;
            while (this.getValue(rightMarker).compareTo(pivot) > 0)
                rightMarker--;
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker)
                    swap(leftMarker, rightMarker);
                leftMarker++;
                rightMarker--;
            }
        }
        if (leftMarker < rightBorder)
            quickSort(leftMarker, rightBorder);
        if (leftBorder < rightMarker)
            quickSort(leftBorder, rightMarker);
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node currentNode = root;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
        return currentNode;
    }

    public T getValue(int index) {
        return this.getNode(index).value;
    }

    public void setValue(int index, T value) {
        this.getNode(index).value = value;
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size)
            throw new IndexOutOfBoundsException();
        if (index1 == index2)
            return;
        Node node1 = null, node2 = null, currentNode = root;
        for (int i = 0; currentNode != null; i++) {
            if (index1 == i)
                node1 = currentNode;
            else if (index2 == i)
                node2 = currentNode;
            if (node2 != null && node1 != null)
                break;
            currentNode = currentNode.next;
        }
        T temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public LinkedListT copyList() {
        LinkedListT<T> copyList = new LinkedListT<>();
        Node currentNode = root;
        while (currentNode != null) {
            copyList.add(currentNode.value);
            currentNode = currentNode.next;
        }
        return copyList;
    }

    public void print() {
        System.out.print("[ ");
        Node currentNode = root;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println("] size: " + size);
    }

    public int size() {
        return size;
    }

    private class Node {
        T value;
        Node next;

        Node() {
        }

        Node(T value) {
            this.value = value;
        }
    }


}
