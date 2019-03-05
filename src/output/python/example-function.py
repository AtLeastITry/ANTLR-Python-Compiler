def something(a, b):
	def innersomething(x, y):
		return (x + 3) * y * 3
	return innersomething(a, b)
a = something(1, 2)