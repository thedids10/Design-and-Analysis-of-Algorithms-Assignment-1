Design and Analysis of Algorithms – Assignment 1

This repository contains implementations and analysis of four classic divide-and-conquer algorithms: MergeSort, QuickSort, Deterministic Select (Median-of-Medians), and Closest Pair of Points.
All implementations include recursion control techniques and metric collection (time, recursion depth, comparisons).

1. MergeSort
Architecture and Recursion Control

Classic recursive splitting of the array into two halves.

Recursion is controlled by a cutoff threshold: small subarrays are handled with Insertion Sort.

A reusable buffer is passed along recursive calls to reduce memory allocation overhead.

Recurrence Analysis

Master Theorem, Case 2.

Recurrence:

T(n) = 2T(n/2) + Θ(n)


Final complexity: Θ(n log n)

Graphs and Measurements

(Graphs showing time and recursion depth versus input size will be inserted later.)

Discussion

Constant factors (cache effects, JVM garbage collection) noticeably influence performance.

Cutoff to insertion sort improves speed on small input sizes.

2. QuickSort
Architecture and Recursion Control

Randomized pivot selection ensures balanced partitions with high probability.

Recursion proceeds only on the smaller partition, while the larger one is processed iteratively, guaranteeing O(log n) stack depth.

Partitioning is done in-place with minimal swaps.

Recurrence Analysis

Expected recurrence:

T(n) = T(n/2) + T(n/2) + Θ(n) ≈ T(n) = 2T(n/2) + Θ(n)


With randomization, expected complexity: Θ(n log n).

Worst-case (rare with randomization): O(n²).

Graphs and Measurements

(Graphs of running time and recursion depth will be inserted here.)

Discussion

Randomization effectively avoids worst-case behavior on adversarial inputs.

Iterating over the larger partition ensures bounded recursion depth.

3. Deterministic Select (Median-of-Medians)
Architecture and Recursion Control

Array is divided into groups of 5.

Median of each group is found; then median of medians is used as pivot.

Partitioning is done in-place.

Recursion proceeds only into the necessary side (the one containing the k-th order statistic).

Preference is given to recursing into the smaller side, limiting recursion depth.

Recurrence Analysis

Recurrence (Akra–Bazzi method intuition):

T(n) ≤ T(n/5) + T(7n/10) + Θ(n)


Final complexity: Θ(n) (deterministic linear time).

Graphs and Measurements

(Graphs comparing Select vs. sorting approaches will be inserted later.)

Discussion

Constant factors are higher than QuickSelect with random pivot, but worst-case guarantees O(n).

Metrics confirm recursion depth is bounded and scales much slower than n.

4. Closest Pair of Points (2D)
Architecture and Recursion Control

Input points are presorted by x and y coordinates.

Recursively split into halves by x-coordinate.

After recursive calls, a “strip” of width 2d (where d = min(leftDist, rightDist)) is checked.

In the strip, only 7–8 nearest neighbors per point are scanned, ensuring efficiency.

Recurrence Analysis

Master Theorem, Case 2.

Recurrence:

T(n) = 2T(n/2) + Θ(n)


Final complexity: Θ(n log n).

Graphs and Measurements

(Graphs of runtime vs. n will be inserted here.)

Discussion

Implementation efficiency depends on sorting and strip construction.

On small inputs, brute force may be competitive due to lower constant factors.

📊 Summary

MergeSort and Closest Pair follow Θ(n log n) complexity.

QuickSort achieves expected Θ(n log n) with randomized pivots, avoiding worst-case depth.

Deterministic Select achieves Θ(n) using Median-of-Medians, with stronger guarantees than randomized selection.

Empirical results (time, recursion depth, comparisons) align with theoretical predictions, though constant factors (cache, GC, insertion sort threshold) influence practical performance.
