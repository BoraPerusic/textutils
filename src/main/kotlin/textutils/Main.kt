package textutils

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.multiple
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.file
import org.slf4j.LoggerFactory
import java.io.File

/**
 * SplitTexts utility class.
 * Reads an input file, splits lines into tokens based on separators,
 * filters them based on configuration, and writes distinct tokens to an output file.
 */
class SplitTexts : CliktCommand() {
    private val logger = LoggerFactory.getLogger(SplitTexts::class.java)

    private val inputFile by argument("input-file").file(mustExist = true, canBeDir = false, mustBeReadable = true)
    private val outputFile by argument("output-file").file(mustExist = false, canBeDir = false)

    private val separators by option("--separator", help = "Separator character(s)")
        .multiple(default = Config.separators)

    private val includeNumbers by option("--incl-numbers", help = "Include numbers in the result")
        .flag("--no-incl-numbers", default = Config.includeNumbers)

    private val stopwords by option("--stopword", help = "Stopword to exclude")
        .multiple(default = Config.stopwords)

    private val singleQuotes by option("--singleq", help = "Treat single quotes as unbreakable text markers")
        .flag("--no-singleq", default = Config.quotesHandling)

    private val doubleQuotes by option("--doubleq", help = "Treat double quotes as unbreakable text markers")
        .flag("--no-doubleq", default = Config.quotesHandling)

    override fun run() {
        logger.debug("Starting SplitTexts processing")

        val separatorChars = separators.flatMap { it.toList() }.toSet()
        val stopwordSet = stopwords.toSet()

        logger.debug("Effective configuration: separators={}, includeNumbers={}, stopwords={}, singleQuotes={}, doubleQuotes={}",
            separatorChars, includeNumbers, stopwordSet, singleQuotes, doubleQuotes)

        val tokenizer = Tokenizer(
            separators = separatorChars,
            singleQuotes = singleQuotes,
            doubleQuotes = doubleQuotes,
            includeNumbers = includeNumbers,
            stopwords = stopwordSet
        )

        val distinctTokens = mutableSetOf<String>()

        logger.debug("Reading lines from {}", inputFile)
        inputFile.useLines { lines ->
            lines.forEach { line ->
                distinctTokens.addAll(tokenizer.tokenize(line))
            }
        }

        logger.debug("Writing {} distinct tokens to {}", distinctTokens.size, outputFile)
        outputFile.bufferedWriter().use { writer ->
            distinctTokens.forEach { token ->
                writer.write(token)
                writer.newLine()
            }
        }
        logger.debug("Finished processing")
    }
}

fun main(args: Array<String>) = SplitTexts().main(args)
