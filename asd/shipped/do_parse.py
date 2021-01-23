"""
python3 do_parse.py
"""

import sys
import os
import zipfile
import shutil
import re
import rarfile


def main(args):

	unzipped_folder = "unzipped/"
	clean_folder = "working/"


	for studentDir in os.listdir(unzipped_folder):

		if studentDir== ".DS_Store":
			continue
		
		tmp_dst = clean_folder+studentDir
		if os.path.exists(tmp_dst):
			shutil.rmtree(tmp_dst)
		os.makedirs(tmp_dst)

		normal_path = unzipped_folder+studentDir
		for aFile in os.listdir(normal_path):
			if aFile == ".DS_Store" or ".java~" in aFile:
				continue

			openpath = normal_path+"/"+aFile
			if os.path.isdir(openpath):
				continue

			with open(openpath, encoding='utf8', errors='ignore') as f:
				content = f.read()

			outfile = tmp_dst+"/"+aFile
			with open(outfile, 'w+') as outfile:
				outfile.write(content)




if __name__ == '__main__':
  main(sys.argv[1:])