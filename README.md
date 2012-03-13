vnTagger - POS Tagging for Vietnamese
===

## Introduction

- vnTagger is an automatic tagger for tagging Vietnamese texts with high accuracy (around 95%)
- The program is developed in the Java programming language and is platform-independent
- Reference: [An empirical study of maximum entropy approach for part-of-speech tagging of Vietnamese texts](http://www.loria.fr/~lehong/pubs/vnTagger.pdf)

## About this repository

This is an **unofficial fork** of [vnTagger](http://www.loria.fr/~lehong/tools/vnTagger.php), originally written by [Le Hong Phuong](http://www.loria.fr/~lehong/).

The source code in this repository is currently updated to [vnTagger 4.2.0b](http://www.loria.fr/~lehong/tools/download.php?file=vn.hus.nlp.tagger-4.2.0-src.tar.gz), released in 05/08/2010. It uses [vnTokenizer](http://www.loria.fr/~lehong/tools/vnTokenizer.php) version 4.1.1c to tokenize texts before tagging.

Changes may have been made in compare to the original version.

## Usage

On a Unix/Linux system, use the provided script `vnTagger.sh` to run the program, on a MS Windows, use `vnTagger.bat`.

### Tag a text file
You should provide two arguments for the program: an input text file to be tagged (with argument option `-i`) and an output file for the program to write result to (with argument option `-o`).
		 
For example:
		  
	./vnTagger.sh -i samples/0.txt  -o samples/0.tagged.xml
	 	
Note that the file `0.txt` must exist and contain some Vietnamese text encoded in UTF-8 encoding. The result file `0.tagged.xml` is a text file (A simple XML format) created by the program and it is always encoded in UTF-8 encoding.
	 	
- By default, syllables of compound words are separated by spaces, you can use option `-u` to **separate them by `_` character**.
- If you want that the result file is a **plain text instead of an XML** file, use the option `-p`.  
- If the input text is already tokenized, you can tell vnTagger to **skip tokenization** by passing using the `-st` option.
	 	
Thus, the command
	 	
	 ./vnTagger.sh -i samples/0.txt  -o samples/0.tagged.xml -u
	 		
will produce output with syllables separated by underscore characters.
	 	
The command 
	 	
	 ./vnTagger.sh -i samples/0.txt  -o samples/0.tagged.txt -u -p 
	 		
will produce output with syllables separated by underscore characters and use a plain text output file instead of an XML file.

### Test a tagged file
	
If you want to test the accuracy of the tagger on a correctly tagged file, use the argument `-t` on the file to test, for example:
		
	./vnTagger.sh -t samples/1.tagged.txt
		
Results of the test will be outputed to the standard console. Note that the test file need to be a plain text file in which syllables are separated by underscores, words are separated by spaces.


## API for Developers
	
The main class of the tagger is `vn.hus.nlp.tagger.VietnameseMaxentTagger`. This class provides three **instance methods** to tag text:
			
1. Tag a text and return a tagged string:

		public String tagText(String text)
	
2. Tag an input text file and write the result to an output file, using an outputer:

		public void tagFile(String inputFile, String outputFile, IOutputer outputer)
		
3. Tag an input text file and write the result to an output file, using a default plain outputer.
	
		public void tagFile(String inputFile, String outputFile)

4. And a method for test a tagged file:
	
		public void testFile(String filename)


## Tagset

The tagset in use contains 17 main lexical tags:
		
1.  Np - Proper noun
2.  Nc - Classifier
3.  Nu - Unit noun
4.  N - Common noun
5.  V - Verb
6.  A - Adjective
7.  P - Pronoun
8.  R - Adverb
9.  L - Determiner
10. M - Numeral
11. E - Preposition
12. C - Subordinating conjunction
13. CC - Coordinating conjunction
14. I - Interjection
15. T - Auxiliary, modal words
16. Y - Abbreviation
17. Z - Bound morphemes
18. X - Unknown
		
There are also tags for delimiters and punctuations.

## Changes Logs

#### 13/03/2012

- Added option to POS tag pre-tokenized text (skip tokenization).

---

#### 01/04/2010

- Upgrade to use with Stanford Tagger 2.0.

#### 25/12/2009

- Upgrade the tokenizer module to vnTokenizer 4.1.1.
- Update resources

#### 30/11/2009

- Upgrade the tokenizer module to vnTokenizer 4.1.0 (with a minor bug fixed).
- Update resources, use a richer feature set for tagging texts, especially Vietnamese-specific features.
- Much better tagging results.
	
#### 18/07/2009

- Upgrade the tokenizer module to vnTokenizer 4.1
- Update resources.
	
## LICENSE
  
See the LICENSE file.	