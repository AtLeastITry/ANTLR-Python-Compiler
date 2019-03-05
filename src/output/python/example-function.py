
a = 10
a = something(1, 2)
b = test()
def something(c, d):
	a = 20
	def innersomething(x, y):
		return (x + 3) * y * 3
	return innersomething(c, d)
def test():
	return something(a, a)