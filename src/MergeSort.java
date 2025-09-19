public class MergeSort {

    private static final int INSERTION_SORT_THRESHOLD = 16;

    public static void sort(int[] array) {
        int[] buffer = new int[array.length];
        mergeSort(array, buffer, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] buffer, int left, int right) {
        if (right - left + 1 <= INSERTION_SORT_THRESHOLD) {
            insertionSort(array, left, right);
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(array, buffer, left, mid);
        mergeSort(array, buffer, mid + 1, right);

        merge(array, buffer, left, mid, right);
    }

    private static void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private static void merge(int[] array, int[] buffer, int left, int mid, int right) {
        // Копируем левую и правую части в буфер
        System.arraycopy(array, left, buffer, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (buffer[i] <= buffer[j]) {
                array[k++] = buffer[i++];
            } else {
                array[k++] = buffer[j++];
            }
        }

        while (i <= mid) {
            array[k++] = buffer[i++];
        }

        // правая часть уже на месте, не нужно копировать
    }

    // Пример использования
    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 1, 5, 6, 7, 3, 8, 4, 10, 0, -1, 11, 13, 12 };
        sort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
