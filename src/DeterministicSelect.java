import java.util.Arrays;

public class DeterministicSelect {

    private static int comparisons = 0;
    private static int maxDepth = 0;

    public static int selectKth(int[] a, int k) {
        if (a == null || a.length == 0) throw new IllegalArgumentException("empty array");
        if (k < 0 || k >= a.length) throw new IllegalArgumentException("k out of range");

        comparisons = 0;
        maxDepth = 0;

        return select(a, 0, a.length - 1, k, 1);
    }

    private static int select(int[] a, int left, int right, int k, int depth) {
        while (true) {
            if (left == right) return a[left];

            maxDepth = Math.max(maxDepth, depth);

            int pivotIndex = medianOfMedians(a, left, right);
            pivotIndex = partition(a, left, right, pivotIndex);

            if (k == pivotIndex) {
                return a[pivotIndex];
            } else if (k < pivotIndex) {
                int leftSize = pivotIndex - left;
                int rightSize = right - pivotIndex;
                if (leftSize <= rightSize) {
                    return select(a, left, pivotIndex - 1, k, depth + 1);
                } else {
                    right = pivotIndex - 1;
                    depth += 1;
                }
            } else {
                int leftSize = pivotIndex - left;
                int rightSize = right - pivotIndex;
                if (rightSize <= leftSize) {
                    return select(a, pivotIndex + 1, right, k, depth + 1);
                } else {
                    left = pivotIndex + 1;
                    depth += 1;
                }
            }
        }
    }

    private static int medianOfMedians(int[] a, int left, int right) {
        int n = right - left + 1;
        if (n <= 5) {
            Arrays.sort(a, left, right + 1);
            return left + n / 2;
        }

        int numMedians = (int) Math.ceil(n / 5.0);
        for (int i = 0; i < numMedians; i++) {
            int subL = left + i * 5;
            int subR = Math.min(subL + 4, right);
            Arrays.sort(a, subL, subR + 1);
            int median = subL + (subR - subL) / 2;
            swap(a, left + i, median);
        }

        return medianOfMedians(a, left, left + numMedians - 1);
    }

    private static int partition(int[] a, int left, int right, int pivotIndex) {
        int pivot = a[pivotIndex];
        swap(a, pivotIndex, right);

        int store = left;
        for (int i = left; i < right; i++) {
            comparisons++;
            if (a[i] < pivot) {
                swap(a, store, i);
                store++;
            }
        }
        swap(a, store, right);
        return store;
    }

    private static void swap(int[] a, int i, int j) {
        if (i != j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    public static int getComparisons() { return comparisons; }
    public static int getMaxDepth() { return maxDepth; }

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4, 19, 26, -2, 10, 10, 10};
        int k = 4;
        int kth = selectKth(arr, k);
        System.out.println("k = " + k + ", элемент = " + kth);
        System.out.println("Сравнений: " + getComparisons());
        System.out.println("Макс. глубина рекурсии: " + getMaxDepth());
    }
}
