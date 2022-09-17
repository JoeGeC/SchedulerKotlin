class Scheduler(
    private var currentHour: Int,
    private var currentMinute: Int
) {
    private var hourResult = 0

    fun getNextTimeOf(scheduledHour: Int, scheduledMinutes: Int): String
    {
        hourResult = handleAnyHour(scheduledHour, scheduledMinutes)
        val minuteResult = handleAnyMinute(scheduledHour, scheduledMinutes)
        if (hourResult < currentHour || (hourResult == currentHour && minuteResult < currentMinute))
            return "${formatTime(hourResult, minuteResult)} tomorrow"
        return "${formatTime(hourResult, minuteResult)} today"
    }

    private fun handleAnyHour(scheduledHour: Int, scheduledMinutes: Int): Int
    {
        if (scheduledHour != -1) return scheduledHour
        if (scheduledMinutes > currentMinute || scheduledMinutes == -1)
            return currentHour
        return incrementHour()
    }

    private fun incrementHour(): Int
    {
        val result = currentHour + 1
        return if(result >= 24) 0 else result
    }

    private fun handleAnyMinute(scheduledHour: Int, scheduledMinutes: Int): Int
    {
        if (scheduledMinutes != -1) return scheduledMinutes
        if (scheduledHour == currentHour || scheduledHour == -1)
            return currentMinute
        return 0
    }

    private fun formatTime(hour: Int, minutes: Int): String = "${hour}:${String.format("%02d", minutes)}"

}
