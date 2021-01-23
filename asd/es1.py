import sys

def systematicSearch(instr):
	count = 0
	for x in range(len(instr)):
		if instr[x:x+2] == '30':
			for y in range(x+2,len(instr)):
				if instr[y] == 'e':
					for z in range(y+1,len(instr)):
						if instr[z:z+4] == 'lode':
							count += 1
	return count


def linearSearch(instr):
	count30 = 0
	countWeight = 0
	count = 0
	for x in range(len(instr)):
		if instr[x:x+2] == '30':
			count30 += 1
		if instr[x] == 'e':
			countWeight +=  count30
		if instr[x:x+4] == 'lode':
			count += countWeight
	return count



def main(args):
	with open('Esercizio1-1.in') as f:
		lines = f.readlines()


	# cases = ['30elode','30eelode','30lodelode','30e30elodelode']
	cases = lines[1:]
	for case in cases:
		rlt = systematicSearch(case)
		print(case,rlt,'s')

		# rlt = linearSearch(case)
		# print(rlt)



if __name__ == '__main__':
  main(sys.argv[1:])