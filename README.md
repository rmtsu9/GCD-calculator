# GCD Calculator - Extended Euclidean Algorithm

Program for calculating Extended Euclidean Algorithm to find gcd and solve Linear Diophantine equations

## Description

This program is used to solve equations of the form **ax + by = c** using the Extended Euclidean Algorithm, which can:

1. Find **gcd(a, b)** of two numbers
2. Find coefficients **s** and **t** such that **sa + tb = gcd(a, b)** (Bezout coefficients)
3. Find particular solution **(x₀, y₀)** of equation **ax + by = c**
4. Find general solution **x = x₀ + (b/d)n, y = y₀ - (a/d)n**
5. Find all values of **n** that make **x ≥ 0** and **y ≥ 0**

## Usage

### 1. Compile the program
```bash
javac gcd.java
```

### 2. Run the program

**Method 1: Input values via command line**
```bash
java GCD <a> <b> <c>
```

**Examples:**
```bash
java GCD 17 13 100
java GCD 60 18 420
```

**Method 2: Interactive input**
```bash
java GCD
```
The program will then prompt for values a, b, c

## Sample Output

### Example 1: 17x + 13y = 100
```
Problem: 17x + 13y = 100
1. gcd(a, b) = d = 1
2. sa + tb = s = -3, t = 4
3. x0 = s⋅c/d (x0 = -300), y0 = t⋅c/d (y0 = 400)
4. x = x0 + (b/d)n, y = y0 − (a/d)n = (x = -300 + (13/1)n, y = 400 − (17/1)n)
5. All N values:
All N: 23, 24
n = 23 -> x = -1, y = 9
n = 24 -> x = 12, y = -8
```

### Example 2: 60x + 18y = 420
```
Problem: 60x + 18y = 420
1. gcd(a, b) = d = 6
2. sa + tb = s = -2, t = 7
3. x0 = s⋅c/d (x0 = -140), y0 = t⋅c/d (y0 = 490)
4. x = x0 + (b/d)n, y = y0 − (a/d)n = (x = -140 + (18/6)n, y = 490 − (60/6)n)
5. All N values:
All N: -23, -22, -21
n = -23 -> x = 29, y = 20
n = -22 -> x = 32, y = 10
n = -21 -> x = 35, y = 0
```

## Algorithm

### Extended Euclidean Algorithm
```
function extgcd(a, b):
    r1 = a, r2 = b
    s1 = 1, s2 = 0
    t1 = 0, t2 = 1
    
    while r2 ≠ 0:
        q = r1 ÷ r2
        (r1, r2) = (r2, r1 - q×r2)
        (s1, s2) = (s2, s1 - q×s2)
        (t1, t2) = (t2, t1 - q×t2)
    
    return (r1, s1, t1)  // (gcd, s, t)
```

### Solution Finding Process
1. Check if c is divisible by gcd(a,b)
2. Find particular solution: x₀ = s×(c/d), y₀ = t×(c/d)
3. Find general solution: x = x₀ + (b/d)n, y = y₀ - (a/d)n
4. Find range of n that makes x ≥ 0 and y ≥ 0

## Features

- ✅ Supports large integers (long type)
- ✅ Shows step-by-step calculation process
- ✅ Supports both command line arguments and interactive input
- ✅ Displays all solutions where x, y ≥ 0
- ✅ Uses postfix calculation for clarity
- ✅ Short and understandable variable names

## Requirements

- Java 8 or higher
- Command line terminal/PowerShell

## Developer

This program was developed for learning Extended Euclidean Algorithm and solving Linear Diophantine equations

---

## Mathematical Background

**Linear Diophantine Equation**: ax + by = c

This equation has integer solutions if and only if gcd(a,b) divides c

**Extended Euclidean Algorithm** finds values s, t such that:
```
gcd(a,b) = sa + tb
```

Once s, t are found, the particular solution is:
```
x₀ = s × (c/gcd(a,b))
y₀ = t × (c/gcd(a,b))
```

The general solution is:
```
x = x₀ + (b/gcd(a,b))n
y = y₀ - (a/gcd(a,b))n
```

where n is any integer
