def factorial(n):
	val = 1
	counter = 1
	while counter <= n:
		val = val * counter
		counter = counter + 1
	return val
b = factorial(8)
print(b)