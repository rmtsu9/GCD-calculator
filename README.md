# GCD Calculator - Extended Euclidean Algorithm (เครื่องคิดเลข GCD - อัลกอริทึมยูคลิดขยาย)

Program for calculating Extended Euclidean Algorithm to find gcd and solve Linear Diophantine equations (โปรแกรมสำหรับคำนวณอัลกอริทึมยูคลิดขยายเพื่อหาค่า gcd และแก้สมการดีโอแฟนไทน์เชิงเส้น)

## Description (คำอธิบาย)

This program is used to solve equations of the form **ax + by = c** using the Extended Euclidean Algorithm, which can: (โปรแกรมนี้ใช้แก้สมการในรูปแบบ **ax + by = c** โดยใช้อัลกอริทึมยูคลิดขยาย ซึ่งสามารถทำได้ดังนี้:)

1. Find **gcd(a, b)** of two numbers (หาค่า **gcd(a, b)** ของสองจำนวน)

2. Find coefficients **s** and **t** such that **sa + tb = gcd(a, b)** (Bezout coefficients) (หาค่าสัมประสิทธิ์ **s** และ **t** ให้เป็นไปตาม **sa + tb = gcd(a, b)** (ค่าสัมประสิทธิ์ของ Bezout))

3. Find particular solution **(x₀, y₀)** of equation **ax + by = c** (หาเฉพาะคำตอบหนึ่งชุด **(x₀, y₀)** ของสมการ **ax + by = c**)

4. Find general solution **x = x₀ + (b/d)n, y = y₀ - (a/d)n** (หาเฉลยทั่วไป **x = x₀ + (b/d)n, y = y₀ - (a/d)n**)

5. Find all values of **n** that make **x ≥ 0** and **y ≥ 0** (หาค่าทั้งหมดของ **n** ที่ทำให้ **x ≥ 0** และ **y ≥ 0**)

## Usage (การใช้งาน)

### 1. Compile the program (คอมไพล์โปรแกรม)

```bash
javac gcd.java
```

### 2. Run the program (รันโปรแกรม)

**Method 1: Input values via command line** (วิธีที่ 1: ใส่ค่าผ่านบรรทัดคำสั่ง)

```bash
java GCD <a> <b> <c>
```

**Examples:** (ตัวอย่าง:)

```bash
java GCD 17 13 100
java GCD 60 18 420
```

**Method 2: Interactive input** (วิธีที่ 2: ป้อนค่าแบบโต้ตอบ)

```bash
java GCD
```

The program will then prompt for values a, b, c (โปรแกรมจะถามให้ป้อนค่า a, b, c ทีละค่า)

## Sample Output (ตัวอย่างผลลัพธ์)

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

## Algorithm (อัลกอริทึม)

### Extended Euclidean Algorithm (อัลกอริทึมยูคลิดขยาย)

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

### Solution Finding Process (กระบวนการหาคำตอบ)

1. Check if c is divisible by gcd(a,b) (ตรวจว่า c หารด้วย gcd(a,b) ลงตัวหรือไม่)

2. Find particular solution: x₀ = s×(c/d), y₀ = t×(c/d)

3. Find general solution: x = x₀ + (b/d)n, y = y₀ - (a/d)n

4. Find range of n that makes x ≥ 0 and y ≥ 0 (หาช่วงของ n ที่ทำให้ x ≥ 0 และ y ≥ 0)

## Features (คุณสมบัติ)

- ✅ Supports large integers (long type) (✅ รองรับจำนวนเต็มขนาดใหญ่ (ชนิด long))

- ✅ Shows step-by-step calculation process (✅ แสดงกระบวนการคำนวณทีละขั้นตอน)

- ✅ Supports both command line arguments and interactive input (✅ รองรับทั้งการส่งค่าเป็นอาร์กิวเมนต์และการป้อนค่าแบบโต้ตอบ)

- ✅ Displays all solutions where x, y ≥ 0 (✅ แสดงคำตอบทั้งหมดที่ x, y ≥ 0)

- ✅ Uses postfix calculation for clarity (✅ ใช้วิธีคำนวณแบบโพสต์ฟิกซ์เพื่อความชัดเจน)

- ✅ Short and understandable variable names (✅ ใช้ชื่อตัวแปรสั้นและเข้าใจง่าย)

## Requirements (ความต้องการ)

- Java 8 or higher (Java 8 ขึ้นไป)

- Command line terminal/PowerShell (เทอร์มินัลบรรทัดคำสั่ง/PowerShell)

## Developer (ผู้พัฒนา)

This program was developed for learning Extended Euclidean Algorithm and solving Linear Diophantine equations (โปรแกรมนี้พัฒนาขึ้นเพื่อการเรียนรู้เกี่ยวกับอัลกอริทึมยูคลิดขยายและการแก้สมการดีโอแฟนไทน์เชิงเส้น)

---

## Mathematical Background (พื้นฐานทางคณิตศาสตร์)

**Linear Diophantine Equation**: ax + by = c

This equation has integer solutions if and only if gcd(a,b) divides c (สมการนี้มีคำตอบเป็นจำนวนเต็มก็ต่อเมื่อ gcd(a,b) เป็นตัวหารของ c)

**Extended Euclidean Algorithm** finds values s, t such that: (**อัลกอริทึมยูคลิดขยาย** หา s, t ที่เป็นไปตาม:)

```
gcd(a,b) = sa + tb
```

Once s, t are found, the particular solution is: (เมื่อหา s, t ได้แล้ว ค่าเฉพาะคำตอบคือ:)

```
x₀ = s × (c/gcd(a,b))
y₀ = t × (c/gcd(a,b))
```

The general solution is: (เฉลยทั่วไปคือ:)

```
x = x₀ + (b/gcd(a,b))n
y = y₀ - (a/gcd(a,b))n
```

where n is any integer (โดยที่ n เป็นจำนวนเต็มใดๆ)
