package mylist;

import mylist.MyArrayList;
import mylist.MyList;

/**
 * Sorts any collection extended by mylist.MyList interface
 * this sorts is based on mylist.QuickSort principe
 *
 * @author Anton Skomorokhin
 */
public class QuickSort {


    /**
     * @param list list whose will be sorted
     * @param <E> is any Object according permits from mylist.MyList realisation
     * @return sorted mylist.MyList object
     */
    public static <E> MyList<E> sort(MyList<E> list) {
        E[] arr = (E[]) list.toArray();
        quickSort(arr, 0, list.size() - 1);
        return new MyArrayList(arr);
    }

    private static void quickSort(Object[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }


    private static int partition(Object[] arr, int begin, int end) {
        Object pivot = arr[end];
        int wall = (begin - 1);

        for (int currentEl = begin; currentEl < end; currentEl++) {
            if (((Comparable) arr[currentEl]).compareTo(pivot) <= 0) {
                wall++;

                Object swapTemp = arr[wall];
                arr[wall] = arr[currentEl];
                arr[currentEl] = swapTemp;
            }
        }

        Object swapTemp = arr[wall + 1];
        arr[wall + 1] = arr[end];
        arr[end] = swapTemp;

        return wall + 1;
    }

}




