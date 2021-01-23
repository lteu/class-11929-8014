import sys
import random 

def main(args):
	a = '30'
	b = 'e'
	c = 'lode'

	candidates = ' abcdefzghgxklmn'
	stringout = ''
	longnum = random.randint(5, 200)
	for i in range(1,longnum):
		x = random.randint(0, len(candidates)-1)
		if x != 0:
			char = candidates[x]
			stringout += char
		if random.randint(0, 1) == 1:
			stringout+=a
		if random.randint(0, 1) == 1:
			stringout+=b
		if random.randint(0, 1) == 1:
			stringout+=c


	print(stringout)


	# cases = ['30elode','30eelode','30lodelode','30e30elodelode']
	# for case in cases:


	# 	# rlt = systematicSearch(case)
	# 	# print(case,rlt,'s')

	# 	rlt = linearSearch(case)
	# 	print(case,rlt,'l')



if __name__ == '__main__':
  main(sys.argv[1:])