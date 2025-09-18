import java.util.Random;

public class QuickSort {

    // Главный метод для сортировки массива
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // Вспомогательный метод для рекурсивной сортировки
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Разделение массива и получение индекса опорного элемента
            int pivotIndex = partition(arr, low, high);

            // Рекурсивные вызовы для левой и правой части массива
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Метод для разбиения массива с случайным выбором опорного элемента
    private static int partition(int[] arr, int low, int high) {
        // Случайный выбор опорного элемента
        Random random = new Random();
        int pivotIndex = low + random.nextInt(high - low + 1);

        // Перемещаем опорный элемент в конец массива
        swap(arr, pivotIndex, high);

        int pivot = arr[high];
        int i = low - 1;

        // Проходим по массиву и перемещаем элементы меньше опорного влево
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Перемещаем опорный элемент в его правильное место
        swap(arr, i + 1, high);
        return i + 1; // Возвращаем индекс опорного элемента
    }

    // Метод для обмена элементов
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Пример использования
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr);

        // Вывод отсортированного массива
        System.out.println("Отсортированный массив:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
