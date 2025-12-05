package textutils

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TokenizerTest : StringSpec({
    val defaultSeparators = setOf(' ', '.', ',', '!')

    "basic splitting" {
        val tokenizer = Tokenizer(defaultSeparators, false, false, false, emptySet())
        tokenizer.tokenize("hello world") shouldBe listOf("hello", "world")
        tokenizer.tokenize("hello, world!") shouldBe listOf("hello", "world")
    }

    "quotes handling" {
        val tokenizer = Tokenizer(defaultSeparators, singleQuotes = true, doubleQuotes = true, includeNumbers = false, stopwords = emptySet())
        tokenizer.tokenize("hello 'big world'") shouldBe listOf("hello", "'big world'")
        tokenizer.tokenize("hello \"big world\"") shouldBe listOf("hello", "\"big world\"")
        // Mixed quotes
        tokenizer.tokenize("hello 'big \" world'") shouldBe listOf("hello", "'big \" world'")
    }

    "numbers filtering" {
        val tokenizer = Tokenizer(defaultSeparators, false, false, false, emptySet())
        tokenizer.tokenize("hello 123 world") shouldBe listOf("hello", "world")
        // dot is separator in defaultSeparators, so 12.34 becomes 12 and 34, both are numbers (digits)
        tokenizer.tokenize("hello 12.34 world") shouldBe listOf("hello", "world")
    }

    "numbers including" {
        val tokenizer = Tokenizer(defaultSeparators, false, false, true, emptySet())
        tokenizer.tokenize("hello 123 world") shouldBe listOf("hello", "123", "world")
    }

    "stopwords filtering" {
        val tokenizer = Tokenizer(defaultSeparators, false, false, false, setOf("bad"))
        tokenizer.tokenize("hello bad world") shouldBe listOf("hello", "world")
    }

    "separators interaction with numbers" {
        // if . is not a separator
        val tokenizer = Tokenizer(setOf(' '), false, false, false, emptySet())
        // "12.34" -> is it a number?
        // toDoubleOrNull handles "12.34" -> true. So it should be filtered if includeNumbers=false.
        tokenizer.tokenize("value is 12.34") shouldBe listOf("value", "is")

        // include numbers
        val tokenizerIncl = Tokenizer(setOf(' '), false, false, true, emptySet())
        tokenizerIncl.tokenize("value is 12.34") shouldBe listOf("value", "is", "12.34")
    }
})
