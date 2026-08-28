# Remove Element

## Problem

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` from the array **in-place**.

The order of the remaining elements can be changed.

Return the number of elements in `nums` that are **not equal to `val`**.

The first `k` elements of `nums` should contain all the elements that are not equal to `val`, where `k` is the returned value.

---

## Approach

We use a **two-pointer approach**.

* `i` is used to traverse every element in the array.
* `k` keeps track of the position where the next valid element should be placed.

While traversing the array:

1. Check whether `nums[i]` is equal to `val`.
2. If it is equal to `val`, skip it.
3. If it is not equal to `val`, copy it to `nums[k]`.
4. Increment `k`.
5. After the loop, `k` represents the number of elements that are not equal to `val`.

---

## Solution

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
```

---

## Step-by-Step Dry Run

### Example

```text
nums = [3, 2, 2, 3]
val = 3
```

Initially:

```text
k = 0
```

| i | nums[i] | Condition  | Action        | Array       | k |
| - | ------- | ---------- | ------------- | ----------- | - |
| 0 | 3       | `3 == val` | Skip          | `[3,2,2,3]` | 0 |
| 1 | 2       | `2 != val` | `nums[0] = 2` | `[2,2,2,3]` | 1 |
| 2 | 2       | `2 != val` | `nums[1] = 2` | `[2,2,2,3]` | 2 |
| 3 | 3       | `3 == val` | Skip          | `[2,2,2,3]` | 2 |

Finally:

```text
k = 2
```

The first `k` elements are:

```text
[2, 2]
```

So the output is:

```text
2
```

Anything after index `k - 1` does not matter.

---

## Time Complexity

```text
O(n)
```

We traverse the array only once.

---

## Space Complexity

```text
O(1)
```

We modify the original array without using any extra data structure.
