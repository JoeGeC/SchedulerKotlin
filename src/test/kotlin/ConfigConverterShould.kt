import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConfigConverterShould {
    private val configConverter = ConfigConverter("16", "10")

    @Test
    fun convertOneCommand()
    {
        val expected = "1:30 tomorrow - /bin/run_me_daily"
        val result = configConverter.convert("30 1 /bin/run_me_daily")
        assertEquals(expected, result)
    }

    @Test
    fun catchInvalidCommandOneInt()
    {
        val result = configConverter.convert("1 /bin/run_me_daily")
        assertEquals(ConfigConverter.errorMessage, result)
    }

    @Test
    fun catchInvalidCommandHourTooBig()
    {
        val result = configConverter.convert("30 24 /bin/run_me_daily")
        assertEquals(ConfigConverter.errorMessage, result)
    }

    @Test
    fun catchInvalidCommandMinuteTooBig()
    {
        val result = configConverter.convert("60 1 /bin/run_me_daily")
        assertEquals(ConfigConverter.errorMessage, result)
    }

    @Test
    fun convertMultipleCommands()
    {
        val commands = listOf(
            "30 1 /bin/run_me_daily",
            "45 * /bin/run_me_hourly",
        )
        val expected = listOf(
            "1:30 tomorrow - /bin/run_me_daily",
            "16:45 today - /bin/run_me_hourly"
        )
        val result = configConverter.convert(commands)
        assertEquals(expected, result)
    }
}