import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FileReaderShould {

    @Test
    internal fun readFromFile() {
        val expected = listOf(
            "30 1 /bin/run_me_daily",
            "45 * /bin/run_me_hourly",
            "* * /bin/run_me_every_minute",
            "* 19 /bin/run_me_sixty_times"
        )
        val textFilePath = this.javaClass.classLoader.getResource("ExampleConfig.txt")?.path
        assertEquals(expected, FileReader.readFile(textFilePath))
    }

}