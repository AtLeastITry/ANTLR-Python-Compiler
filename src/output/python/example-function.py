
a = 10
def something(c, d):
	a = 20
	def innersomething(x, y):
		return (x + 3) * y * 3
	a = innersomething(c, d)
	return a
def test():
	return something(a, a)
a = something(1, 2)
b = test()