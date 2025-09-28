package org.algoritms.select;

import java.util.Arrays;

public class DeterministicSelect {
    private long cnt = 0;

    public int select(int[] a, int k) {
        if (a == null || k < 1 || k > a.length) throw new RuntimeException();
        return go(a, 0, a.length - 1, k - 1);
    }

    private int go(int[] a, int l, int r, int k) {
        while (true) {
            if (l == r) return a[l];
            int piv = pick(a, l, r);
            int idx = split(a, l, r, piv);

            if (k == idx) return a[k];

            // выбираем меньшую часть для рекурсии
            if (idx - l < r - idx) {
                if (k < idx) return go(a, l, idx - 1, k);
                l = idx + 1;
            } else {
                if (k > idx) return go(a, idx + 1, r, k);
                r = idx - 1;
            }
        }
    }

    private int split(int[] a, int l, int r, int piv) {
        int pos = l;
        for (int i = l; i <= r; i++) if (a[i] == piv) { pos = i; break; }
        swap(a, pos, r);
        int s = l;
        for (int i = l; i < r; i++) {
            cnt++;
            if (a[i] < piv) {
                swap(a, i, s);
                s++;
            }
        }
        swap(a, s, r);
        return s;
    }

    private int pick(int[] a, int l, int r) {
        int n = r - l + 1;
        if (n <= 5) {
            Arrays.sort(a, l, r + 1);
            return a[l + n / 2];
        }
        int m = (n + 4) / 5;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            int st = l + i * 5;
            int en = Math.min(st + 4, r);
            Arrays.sort(a, st, en + 1);
            arr[i] = a[st + (en - st) / 2];
        }
        return pick(arr, 0, m - 1);
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    public long getComparisons() { return cnt; }
}
