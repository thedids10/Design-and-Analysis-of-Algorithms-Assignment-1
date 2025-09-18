1. MergeSort
Architecture and Recursion Control

The classic approach of splitting the array into two halves is used.

Recursion is controlled by a cutoff threshold for small subarrays, switching to Insertion Sort.

A reusable buffer is employed for merging to reduce memory allocation overhead.

Recurrence Analysis

Master Theorem, Case 2, is applied.

Recurrence relation: T(n) = 2T(n/2) + Θ(n)

Final complexity: Θ(n log n)

Graphs and Measurements

(Graphs showing time and recursion depth versus input size will be inserted here later)

Discussion

Constant factors such as caching and garbage collection noticeably affect performance.

The cutoff to Insertion Sort improves speed on small input sizes.
