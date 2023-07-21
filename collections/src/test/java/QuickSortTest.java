
import mylist.MyArrayList;
import mylist.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("QickSort test")
public class QuickSortTest {


    @Test
    public void testSort() {
        // Given
        MyArrayList<Integer> myArrayList = new MyArrayList<>(new Integer[]{4, 3, 9, 6, 0, 2, 1, 5, 8, 7});

        // When
        QuickSort.sort(myArrayList);

        // Then
        Assertions.assertArrayEquals(myArrayList.toArray(), new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }
}
