package org.algoritms.sorting;

import java.util.Random;

public class QuickSort {
    private long cmp = 0;
    private Random rnd = new Random();

    public void sort(int[] a) {
        if (a == null || a.length < 2) return;
        qs(a, 0, a.length - 1);
    }

    private void qs(int[] a, int l, int r) {
        while (l < r) {
            int p = part(a, l, r);
            if (p - l < r - p) {
                qs(a, l, p - 1); // рекурсия в меньший кусок
                l = p + 1;       // итерация по большому
            } else {
                qs(a, p + 1, r);
                r = p - 1;
            }
        }
    }

    private int part(int[] a, int l, int r) {
        int pivotIndex = l + rnd.nextInt(r - l + 1);
        swap(a, pivotIndex, r);
        int piv = a[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            cmp++;
            if (a[j] <= piv) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    public long getComparisons() { return cmp; }
}
