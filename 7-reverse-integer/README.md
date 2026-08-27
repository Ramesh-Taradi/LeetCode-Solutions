<h2><a href="https://leetcode.com/problems/reverse-integer">Reverse Integer</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given a signed 32-bit integer <code>x</code>, return <code>x</code><em> with its digits reversed</em>. If reversing <code>x</code> causes the value to go outside the signed 32-bit integer range <code>[-2<sup>31</sup>, 2<sup>31</sup> - 1]</code>, then return <code>0</code>.</p>

<p><strong>Assume the environment does not allow you to store 64-bit integers (signed or unsigned).</strong></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> x = 123
<strong>Output:</strong> 321
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> x = -123
<strong>Output:</strong> -321
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> x = 120
<strong>Output:</strong> 21
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= x &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

# Reverse Integer

## Problem
Given a signed 32-bit integer `x`, return `x` with its digits reversed.

If reversing `x` causes the value to go outside the 32-bit integer range, return `0`.

## Approach

We repeatedly take the last digit of the number using:

`x % 10`

Then remove that digit using:

`x / 10`

We add the extracted digit to the reversed number:

`reverse = reverse * 10 + digit`

Before adding the digit, we check whether the operation will cause integer overflow.

## Example

Input:

123

Step 1:

digit = 3  
reverse = 3

Step 2:

digit = 2  
reverse = 32

Step 3:

digit = 1  
reverse = 321

Output:

321

## Complexity

**Time Complexity:** O(log n)

**Space Complexity:** O(1)
