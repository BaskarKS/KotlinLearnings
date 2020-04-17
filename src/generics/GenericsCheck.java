package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsCheck {
    public static void main(String[] args) {
        //1GenericBasics.kt

        List list = new ArrayList();
        list.add(10);
        list.add("hello");
        list.add(10.5);

        List<String> strList = new ArrayList<>();
        strList.add("Hai");
        //strList.add(10); //compiler catches and inform us to change the passed value

        //2GenericsFunctionsAndErasure.kt
        //Generics cant be used in code performed at runtime, its erased at compile time itself
        List<String> strings = new ArrayList<>();
        strings.add("Hello");

        //boolean b = strings instanceof List<String>; // this code is evaluated at runtime only
        // cant use generics here because its erased at compile time
        boolean typeIsList = strings instanceof List;
        System.out.println(typeIsList);

        int[] array = new int[] {2, 1};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        if (array == null || array.length == 0)
            return;
        quickSort(array, 0, array.length - 1);
    }
    public static void quickSort(int[] array, int start, int end) {
        if (start > end)
            return;
        int pivot = array[end];
        int startIdx = start;
        int partitionIdx = startIdx - 1;
        while (startIdx <= end) {
            if (array[startIdx] <= pivot)
                swap(array, startIdx, ++partitionIdx);
            startIdx++;
        }
        quickSort(array, start, partitionIdx - 1);
        quickSort(array, partitionIdx + 1, end);
    }
    public static void swap(int[] array, int idxOne, int idxTwo) {
        int temp = array[idxOne];
        array[idxOne] = array[idxTwo];
        array[idxTwo] = temp;
    }
}
