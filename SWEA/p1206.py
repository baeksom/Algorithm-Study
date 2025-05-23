T = 10
for test_case in range(1, T + 1):
    n = int(input())
    m = list(map(int, input().split()))
    answer = 0
    for i in range(2, len(m) - 2):
        maxH = max(m[i - 2], m[i - 1], m[i + 1], m[i + 2])
        if m[i] > maxH:
            answer += (m[i] - maxH)
    print(f"#{test_case} {answer}")