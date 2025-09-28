package org.algoritms.sorting;

public class MergeSort {
    private long c = 0;

    public void sort(int[] a) {
        if (a == null || a.length < 2) return;
        go(a, 0, a.length - 1, new int[a.length]);
    }

    private void go(int[] a, int l, int r, int[] tmp) {
        if (l >= r) return;
        int m = (l + r) / 2;
        go(a, l, m, tmp);
        go(a, m + 1, r, tmp);
        merge(a, l, m, r, tmp);
    }

    private void merge(int[] a, int l, int m, int r, int[] tmp) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            c++;
            if (a[i] <= a[j]) tmp[k++] = a[i++];
            else tmp[k++] = a[j++];
        }
        while (i <= m) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        for (int x = l; x <= r; x++) a[x] = tmp[x];
    }

    public long getComparisons() { return c; }
}
