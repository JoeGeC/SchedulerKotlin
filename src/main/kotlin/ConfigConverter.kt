class ConfigConverter(currentHourString: String, currentMinuteString: String) {

    private val scheduler = Scheduler(currentHourString.toInt(), currentMinuteString.toInt())

    fun convert(commands: List<String>): List<String> {
        return commands.map{ convert(it) }
    }

    fun convert(config: String): String {
        return try {
            val split = config.split(' ')
            val command = split[2]
            val hour = convertHourMinute(split[1])
            val minutes = convertHourMinute(split[0])
            if (hour > 23 || minutes > 59) throw Exception("")
            "${scheduler.getNextTimeOf(hour, minutes)} - $command"
        } catch (e: Exception) {
            errorMessage
        }
    }

    private fun convertHourMinute(hour: String): Int
    {
        if (hour == "*") return -1
        return hour.toInt()
    }

    companion object {
        const val errorMessage = "Please enter a valid command"
    }

}
