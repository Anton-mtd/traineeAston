import mylist.MyArrayList;
import mylist.QuickSort;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        Car one = new Car("one", 120);
        Car two = new Car("two", 90);
        Car three = new Car("three", 180);
        Car four = new Car("four", 85);
        Car five = new Car("five", 200);

        MyArrayList<Car> arr = new MyArrayList<Car>();

        arr.add(one);
        arr.add(two);
        arr.add(three);
        arr.add(four);
        arr.add(five);


        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + ",");
        }

        QuickSort.sort(arr);
//        arr.sort();



        System.out.println();
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + ",");
        }
    }

}
