def factorial_iterative(n):
    result = 1
    for i in range(1, n+1):
        result *= i
    return result

def factorial_recursive(n):
    if n == 1:
        return 1
    return n * factorial_recursive(n - 1)

n = 5
print('반복적으로 구현:', factorial_iterative(n))
print('재귀적으로 구현:', factorial_recursive(n))