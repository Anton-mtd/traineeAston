import mylist.MyArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MyArrayListTest")
public class MyArrayListTest {

    MyArrayList<Integer> myArrayList;

    @BeforeEach
    public void setup() {
        myArrayList = new MyArrayList<>(new Integer[]{4, 6, 1});
    }


    @Test
    public void testGet() {
        // Given
        int existIndex = 0;
        int unexistIndex = 4;
        // When
        Object existObject = myArrayList.get(existIndex);
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> myArrayList.get(unexistIndex));
        // Then
        Assertions.assertEquals(myArrayList.get(existIndex), existObject);

        String expectedMessage = "Index " + unexistIndex + " out of bounds for length ";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }


    @Test
    public void testAdd() {
        // Given
        Integer intForAdd = 3;
        // When
        myArrayList.add(intForAdd);
        // Then
        Assertions.assertEquals(myArrayList.get(myArrayList.size() - 1), intForAdd);
    }

    @Test
    public void testContains() {
        // Given
        Integer testObject = 6;
        Integer testObject2 = 16;
        boolean isContains;
        boolean isNotContains;
        // When
        isContains = myArrayList.contains(testObject);
        isNotContains = myArrayList.contains(testObject2);
        // Then
        Assertions.assertTrue(isContains);
        Assertions.assertFalse(isNotContains);
    }

    @Test
    public void testRemoveByIndex() {
        // Given
        int existIndexForRemove = 1;
        Integer objectByIndex = myArrayList.get(existIndexForRemove);
        int notExistIndexForRemove = 10;

        // When
        myArrayList.remove(existIndexForRemove);
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> myArrayList.remove(notExistIndexForRemove));

        // Then
        Assertions.assertFalse(myArrayList.contains(objectByIndex));

        String expectedMessage = "Index " + notExistIndexForRemove + " out of bounds for length ";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testRemoveByObject() {
        // Given
        Object existObjectForRemove = 4;
        boolean isRemoved;
        Object notExistObjectForRemove = 10;
        boolean isNotRemoved;

        // When
        isRemoved = myArrayList.remove(existObjectForRemove);
        isNotRemoved = myArrayList.remove(notExistObjectForRemove);

        // Then
        Assertions.assertTrue(isRemoved);
        Assertions.assertFalse(isNotRemoved);
    }

    @Test
    public void testSize() {
        // Given
        int expectedSize = 3;

        // When
        int actualSize = myArrayList.size();

        // Then
        Assertions.assertEquals(expectedSize,actualSize);
    }

    @Test
    public void testIndexOf() {
        // Given
        Integer object = 6;
        int expectedIndex = 1;

        // When
        int actualIndex = myArrayList.indexOf(object);

        // Then
        Assertions.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testSet() {
        // Given
        int index = 1;
        Integer newValue = 12;

        // When
        Integer actual = myArrayList.set(index, newValue);

        // Then
        Assertions.assertEquals(12, actual);
    }

    @Test
    public void testToArray() {
        // Given
        Object[] expected = new Integer[]{4, 6, 1};

        // When
        Object[] actual = myArrayList.toArray();

        // Then
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void testSort() {
        // Given
        MyArrayList<Integer> expectedMyList = new MyArrayList<>(new Integer[]{1,4,6});

        // When
        myArrayList.sort();

        // Then
        Assertions.assertEquals(expectedMyList,myArrayList);
    }
}
