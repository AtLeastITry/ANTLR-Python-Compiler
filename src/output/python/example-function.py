
a = 10
def test():
	return something(a, a)
def something(c, d):
	a = 20
	def innersomething(x, y):
		return (x + 3) * y * 3
	a = innersomething(c, d)
	return a
while a > 10:
	a = something(1, 2)
	b = test()
if a > 10:
	a = something(1, 2)
	b = test()
elif a < 10:
	a = something(1, 2)
	b = test()