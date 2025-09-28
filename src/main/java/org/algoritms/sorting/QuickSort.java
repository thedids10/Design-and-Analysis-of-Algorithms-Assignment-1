package org.algoritms.sorting;

public class QuickSort {
    private long cmp = 0;

    public void sort(int[] a) {
        if (a == null || a.length < 2) return;
        qs(a, 0, a.length - 1);
    }

    private void qs(int[] a, int l, int r) {
        if (l >= r) return;
        int p = part(a, l, r);
        qs(a, l, p - 1);
        qs(a, p + 1, r);
    }

    private int part(int[] a, int l, int r) {
        int piv = a[r], i = l - 1;
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
