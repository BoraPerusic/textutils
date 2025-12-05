package textutils

import com.typesafe.config.ConfigFactory
import org.slf4j.LoggerFactory

object Config {
    private val logger = LoggerFactory.getLogger(Config::class.java)
    private val config = ConfigFactory.load()
    private val splitTextsConfig = config.getConfig("textutils.split-texts")

    val separators: List<String> = splitTextsConfig.getStringList("separators")
    val quotesHandling: Boolean = splitTextsConfig.getBoolean("quotes-handling")
    val includeNumbers: Boolean = splitTextsConfig.getBoolean("include-numbers")
    val stopwords: List<String> = splitTextsConfig.getStringList("stopwords")

    init {
        logger.debug("Loaded configuration: separators={}, quotesHandling={}, includeNumbers={}, stopwords={}",
            separators, quotesHandling, includeNumbers, stopwords)
    }
}
