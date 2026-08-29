# Remove Duplicates from Sorted Array II

## Problem

Given an integer array `nums` sorted in **non-decreasing order**, remove some duplicates in-place such that each unique element appears **at most twice**.

The relative order of the elements must remain the same.

Return `k`, the number of elements remaining after removing the extra duplicates.

The first `k` elements of `nums` should contain the final result. Elements after index `k - 1` can be ignored.

The solution must modify the array **in-place** and use **O(1) extra memory**.

---

## Approach

We use a **two-pointer approach**.

Since the array is already sorted, duplicate elements are next to each other.

The important idea is:

* The first **two elements** can always be kept.
* Starting from the third element, check whether the current element is different from the element **two positions behind in the result**.
* If they are different, we keep the current element.
* If they are the same, it means we already have two copies of that number, so we skip it.

### Variables

* `i` → traverses the original array.
* `k` → represents the position where the next valid element should be inserted.

The important condition is:

```java
nums[i] != nums[k - 2]
```

If this is true, the current element can be inserted.

---

## Solution

```java
class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int k = 2;

        for (int i = 2; i < nums.length; i++) {

            if (nums[i] != nums[k - 2]) {
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
nums = [1,1,1,2,2,3]
```

We can always keep the first two elements:

```text
[1,1]
```

So:

```text
k = 2
```

Now start from:

```text
i = 2
```

### Step 1

```text
i = 2
nums[i] = 1
nums[k - 2] = nums[0] = 1
```

Check:

```text
1 != 1 → false
```

So we skip the third `1`.

```text
[1,1,1,2,2,3]
```

`k` remains `2`.

---

### Step 2

```text
i = 3
nums[i] = 2
nums[k - 2] = nums[0] = 1
```

Check:

```text
2 != 1 → true
```

Keep `2`:

```java
nums[k] = nums[i];
```

So:

```text
nums[2] = nums[3]
```

Array becomes:

```text
[1,1,2,2,2,3]
```

Then:

```text
k = 3
```

---

### Step 3

```text
i = 4
nums[i] = 2
nums[k - 2] = nums[1] = 1
```

Check:

```text
2 != 1 → true
```

Keep it:

```text
nums[3] = 2
```

Now:

```text
[1,1,2,2,2,3]
```

Then:

```text
k = 4
```

---

### Step 4

```text
i = 5
nums[i] = 3
nums[k - 2] = nums[2] = 2
```

Check:

```text
3 != 2 → true
```

Keep it:

```text
nums[4] = 3
```

Final result:

```text
[1,1,2,2,3,_]
```

And:

```text
k = 5
```

Therefore, the answer is:

```text
k = 5
```

---

## Why `k - 2`?

This is the most important part of the solution.

Suppose our result currently contains:

```text
[1,1]
```

We want to check whether another `1` should be added.

The position two places behind `k` is:

```text
k - 2
```

So:

```text
nums[i] == nums[k - 2]
```

means the current number would become the **third occurrence**.

Therefore, we skip it.

For example:

```text
[1,1,1]
     ↑
 current 1

nums[k - 2] = 1
```

Since they are equal, we don't insert the third `1`.

This guarantees that every number appears **at most twice**.

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

No extra array or data structure is created. We modify the original array in-place.
