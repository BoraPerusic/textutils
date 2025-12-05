# textutils

This repo contains various small command line text utils, written mostly by Jules with my small help in Kotlin.

## Tech Stack
- Kotlin
- Clikt for CLI
- kotlinx for serialization
- HOCON files for configurations

## Split texts
The first util gets a file with list of strings, each instance is on a new line
The goal of the util is to split each line into tokens (words, ...) and return a distinct list of those words.
The configuration will contain:
1. the list of separators which separate words / tokens on each line. Default are [' ', '.', '-', ',', '!', '|', '?', '<', '>', '(', ')', '[', ']', '{', '}' ]
2. whether the quotes (single, ' , or double, " ) mark unbreakable text (default: no)
3. if numbers should be included in the result (defaul: no)
4. list of other stopwords that should be omitted from the result

 The parameters will be <input-file> <output-file> and options (separators, incl-numbers, stopwords, singleq, doubleq)
