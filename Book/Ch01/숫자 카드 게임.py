# min() 함수 이용
# n, m = map(int, input().split())
#
# result = 0
# for i in range(n):
#     data = list(map(int, input().split()))
#     min_value = min(data)
#     result = max(result, min_value)
#
# print(result)

# 2중 반복문 구조 이용
# n, m = map(int, input().split())
#
# result = 0
# for i in range(n):
#     data = list(map(int, input().split()))
#     min_value = 10001
#     for a in data:
#         min_value = min(min_value, a)
#     result = max(result, min_value)
#
# print(result)

n, m = map(int, input().split())

min_card = -1
for i in range(n):
    data = list(map(int, input().split()))
    if min_card < min(data):
        min_card = min(data)

print(min_card)