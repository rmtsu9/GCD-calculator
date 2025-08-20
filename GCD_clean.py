#!/usr/bin/env python3
"""GCD_clean.py - minimal, clean implementation
"""
import sys


def extgcd(a, b):
    r0, r1 = a, b
    s0, s1 = 1, 0
    t0, t1 = 0, 1
    while r1:
        q = r0 // r1
        r0, r1 = r1, r0 - q * r1
        s0, s1 = s1, s0 - q * s1
        t0, t1 = t1, t0 - q * t1
    return r0, s0, t0


def ceil_div(a, b):
    return -((-a) // b)


def main(argv):
    if len(argv) >= 4:
        try:
            a = int(argv[1]); b = int(argv[2]); c = int(argv[3])
        except Exception:
            print('Invalid integer arguments')
            return
    else:
        try:
            a = int(input('a = ')); b = int(input('b = ')); c = int(input('c = '))
        except Exception:
            print('Invalid integer input')
            return

    d, s, t = extgcd(a, b)
    print(f'gcd = {d}; s = {s}; t = {t}')

    if c % d != 0:
        print('No integer solutions')
        return

    k = c // d
    x0 = s * k; y0 = t * k
    stepX = b // d; stepY = a // d

    print(f'x0 = {x0}, y0 = {y0}; stepX = {stepX}, stepY = {stepY}')

    lower = None; upper = None

    if stepX > 0:
        lower = ceil_div(-x0, stepX)
    elif stepX < 0:
        upper = (-x0) // stepX
    else:
        if x0 < 0:
            print('No solution with x >= 0')
            return

    if stepY > 0:
        ub = y0 // stepY
        if upper is None or ub < upper:
            upper = ub
    elif stepY < 0:
        lb = ceil_div(y0, -stepY)
        if lower is None or lb > lower:
            lower = lb
    else:
        if y0 < 0:
            print('No solution with y >= 0')
            return

    if lower is None and upper is None:
        print('All integers n are valid')
        return

    if lower is not None and upper is not None and lower <= upper:
        ns = range(lower, upper + 1)
        print('All N: ' + ', '.join(map(str, ns)))
        for n in ns:
            x = x0 + stepX * n; y = y0 - stepY * n
            if x >= 0 and y >= 0:
                print(f'n = {n} -> x = {x}, y = {y}')
        return

    vals = []
    if upper is not None: vals.append(upper)
    if lower is not None: vals.append(lower)

    if not vals:
        print('No finite bounds for n (unbounded).')
        return

    print('Candidate n: ' + ', '.join(map(str, vals)))
    for n in vals:
        x = x0 + stepX * n; y = y0 - stepY * n
        print(f'n = {n} -> x = {x}, y = {y}')


if __name__ == '__main__':
    main(sys.argv)
