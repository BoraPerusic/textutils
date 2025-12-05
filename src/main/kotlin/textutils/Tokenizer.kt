package textutils

import org.slf4j.LoggerFactory

/**
 * Tokenizer class responsible for splitting text into tokens.
 * Handles separators, quotes, numbers filtering, and stopwords.
 */
class Tokenizer(
    private val separators: Set<Char>,
    private val singleQuotes: Boolean,
    private val doubleQuotes: Boolean,
    private val includeNumbers: Boolean,
    private val stopwords: Set<String>
) {
    private val logger = LoggerFactory.getLogger(Tokenizer::class.java)

    /**
     * Splits a line of text into a list of valid tokens.
     */
    fun tokenize(line: String): List<String> {
        val tokens = mutableListOf<String>()
        val currentToken = StringBuilder()
        var inSingleQuote = false
        var inDoubleQuote = false

        for (char in line) {
            // Check for single quote start/end
            if (singleQuotes && char == '\'' && !inDoubleQuote) {
                inSingleQuote = !inSingleQuote
                currentToken.append(char)
            }
            // Check for double quote start/end
            else if (doubleQuotes && char == '"' && !inSingleQuote) {
                inDoubleQuote = !inDoubleQuote
                currentToken.append(char)
            } else {
                // Inside quotes, treat everything as content
                if (inSingleQuote || inDoubleQuote) {
                    currentToken.append(char)
                } else {
                    // Outside quotes, check for separators
                    if (separators.contains(char)) {
                        if (currentToken.isNotEmpty()) {
                            addTokenIfValid(tokens, currentToken.toString())
                            currentToken.clear()
                        }
                    } else {
                        currentToken.append(char)
                    }
                }
            }
        }
        // Add remaining token
        if (currentToken.isNotEmpty()) {
            addTokenIfValid(tokens, currentToken.toString())
        }

        return tokens
    }

    private fun addTokenIfValid(tokens: MutableList<String>, token: String) {
        if (isValid(token)) {
            tokens.add(token)
        }
    }

    private fun isValid(token: String): Boolean {
        if (stopwords.contains(token)) return false
        if (!includeNumbers) {
             // Check if the token is a number
             if (token.toDoubleOrNull() != null) return false
             // Additional check for digits-only strings which might overflow Double
             if (token.all { it.isDigit() }) return false
        }
        return true
    }
}
