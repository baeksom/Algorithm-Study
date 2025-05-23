T = int(input())

for test_case in range(1, T + 1):
        n = int(input())
        lst = [0] * 5001
        for i in range(n):
            a, b = map(int, input().split())
            for j in range(a, b+1):
                lst[j] += 1
        p = int(input())

        answer = ''
        for i in range(p):
            C = int(input())
            answer += str(lst[C]) + " "

        print(f"#{test_case} {answer}")