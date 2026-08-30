# Majority Element

## Problem

Given an integer array `nums` of size `n`, return the **majority element**.

The majority element is the element that appears **more than `⌊n / 2⌋` times**.

The problem guarantees that a majority element always exists.

---

## Approach

We use the **Boyer-Moore Voting Algorithm**.

The idea is to keep track of:

* `candidate` → the number that is currently considered the majority candidate.
* `count` → the current voting balance for that candidate.

For every number in the array:

1. If `count == 0`, make the current number the new `candidate`.
2. If the current number is equal to `candidate`, increase `count`.
3. Otherwise, decrease `count`.

### Why does this work?

The majority element appears **more than half of the time**.

We can think of the process as a voting system:

```text
Same as candidate      → +1 vote
Different from candidate → -1 vote
```

A majority element has more occurrences than all other elements combined, so the other elements cannot completely cancel it.

Since the problem guarantees that a majority element exists, the final `candidate` will always be the majority element.

---

## Solution

```java
class Solution {
    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
```

---

## Step-by-Step Dry Run

### Example

```text
nums = [2,2,1,1,1,2,2]
```

Initially:

```text
candidate = 0
count = 0
```

### Step 1

```text
num = 2
```

Since:

```text
count == 0
```

we make `2` the candidate:

```text
candidate = 2
```

Now:

```text
num == candidate
2 == 2
```

So:

```text
count++
```

Result:

```text
candidate = 2
count = 1
```

---

### Step 2

```text
num = 2
```

`count` is not zero, so the candidate remains `2`.

Check:

```text
2 == 2
```

True, so:

```text
count++
```

Result:

```text
candidate = 2
count = 2
```

---

### Step 3

```text
num = 1
```

Check:

```text
1 == 2
```

False.

Therefore:

```text
count--
```

Result:

```text
candidate = 2
count = 1
```

The `1` cancels one vote for `2`.

---

### Step 4

```text
num = 1
```

Again:

```text
1 == 2
```

False.

So:

```text
count--
```

Result:

```text
candidate = 2
count = 0
```

Now the votes have completely cancelled:

```text
2  2
↓  ↓
1  1
```

---

### Step 5

```text
num = 1
```

Now:

```text
count == 0
```

So we select the current number as the new candidate:

```text
candidate = 1
```

Then:

```text
1 == 1
```

So:

```text
count++
```

Result:

```text
candidate = 1
count = 1
```

---

### Step 6

```text
num = 2
```

Check:

```text
2 == 1
```

False.

So:

```text
count--
```

Result:

```text
candidate = 1
count = 0
```

The `2` cancels the vote for `1`.

---

### Step 7

```text
num = 2
```

Now:

```text
count == 0
```

So:

```text
candidate = 2
```

Then:

```text
2 == 2
```

Therefore:

```text
count++
```

Final:

```text
candidate = 2
count = 1
```

Return:

```text
2
```

---

## Dry Run Table

| `num` | Candidate Before | Count Before | Action               | Candidate After | Count After |
| ----: | ---------------: | -----------: | -------------------- | --------------: | ----------: |
|     2 |                0 |            0 | New candidate, match |               2 |           1 |
|     2 |                2 |            1 | Match                |               2 |           2 |
|     1 |                2 |            2 | Different → decrease |               2 |           1 |
|     1 |                2 |            1 | Different → decrease |               2 |           0 |
|     1 |                2 |            0 | New candidate, match |               1 |           1 |
|     2 |                1 |            1 | Different → decrease |               1 |           0 |
|     2 |                1 |            0 | New candidate, match |               2 |           1 |

Final answer:

```text
candidate = 2
```

---

## Key Concept

The most important idea is that `count` is **not simply the total number of times the candidate appears**.

It represents the **current balance of votes**.

```text
Same element      → count + 1
Different element → count - 1
```

When:

```text
count == 0
```

the previous candidate has been completely cancelled, so we choose the current number as a new candidate.

Because the majority element occurs more than `n / 2` times, it cannot be completely cancelled by all the other elements.

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

We only use two variables, `candidate` and `count`, regardless of the size of the input array.

---

## Key Takeaway

**Boyer-Moore Voting Algorithm:**

```text
count == 0 → choose new candidate
same       → count++
different  → count--
```

This gives an optimal solution with:

```text
Time:  O(n)
Space: O(1)
```
