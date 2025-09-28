import java.util.Random;

public class QuickSort {

    private static final Random rand = new Random();

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        while (low < high) {
            int pivotIndex = low + rand.nextInt(high - low + 1);
            swap(arr, pivotIndex, high);

            int p = partition(arr, low, high);

        
            if (p - low < high - p) {
                quickSort(arr, low, p - 1);
                low = p + 1;
            } else {
                quickSort(arr, p + 1, high);
                high = p - 1;
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] array = {9, 3, 7, 1, 5, 4, 6, 8, 2, 0, 11, -3, 12};
        sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
