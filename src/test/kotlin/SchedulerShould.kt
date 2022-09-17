import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SchedulerShould {
    @Test
    fun outputNextTimeInSameDay() {
        val scheduler = Scheduler(1, 0)
        assertEquals("1:30 today", scheduler.getNextTimeOf(1, 30))
    }

    @Test
    fun outputNextTimeInSameDay2()
    {
        val scheduler = Scheduler(1, 0)
        assertEquals("2:30 today", scheduler.getNextTimeOf(2, 30))
    }

    @Test
    fun outputNextTimeInSameDay00()
    {
        val scheduler = Scheduler(1, 0)
        assertEquals("2:00 today", scheduler.getNextTimeOf(2, 0))
    }

    @Test
    fun outputNextTimeTomorrow()
    {
        val scheduler = Scheduler(2, 0)
        assertEquals("1:30 tomorrow", scheduler.getNextTimeOf(1, 30))
    }

    @Test
    fun outputNextTimeTomorrowOnSameHour()
    {
        val scheduler = Scheduler(2, 30)
        assertEquals("2:00 tomorrow", scheduler.getNextTimeOf(2, 0))
    }

    @Test
    fun outputNextTimeTomorrowOnSameTime()
    {
        val scheduler = Scheduler(2, 30)
        assertEquals("2:30 today", scheduler.getNextTimeOf(2, 30))
    }

    @Test
    fun outputNextTimeOnAnyHour()
    {
        val scheduler = Scheduler(4, 10)
        assertEquals("4:45 today", scheduler.getNextTimeOf(-1, 45))
    }

    @Test
    fun outputNextTimeOnAnyHourWithLowerMinutes()
    {
        val scheduler = Scheduler(4, 45)
        assertEquals("5:10 today", scheduler.getNextTimeOf(-1, 10))
    }

    @Test
    fun outputNextTimeOnAnyHourWithSameMinutes()
    {
        val scheduler = Scheduler(4, 45)
        assertEquals("5:45 today", scheduler.getNextTimeOf(-1, 45))
    }

    @Test
    fun outputNextTimeOnAnyMinute()
    {
        val scheduler = Scheduler(4, 45)
        assertEquals("5:00 today", scheduler.getNextTimeOf(5, -1))
    }

    @Test
    fun outputNextTimeOnAnyMinuteTomorrow()
    {
        val scheduler = Scheduler(6, 45)
        assertEquals("5:00 tomorrow", scheduler.getNextTimeOf(5, -1))
    }

    @Test
    fun outputNextTimeOnAnyMinuteSameHour()
    {
        val scheduler = Scheduler(5, 45)
        assertEquals("5:45 today", scheduler.getNextTimeOf(5, -1))
    }

    @Test
    fun outputNextTimeOnAnyHourAnyMinute()
    {
        val scheduler = Scheduler(5, 45)
        assertEquals("5:45 today", scheduler.getNextTimeOf(-1, -1))
    }

    @Test
    fun outputNextTimeOnAnyHour23Hours59Mins()
    {
        val scheduler = Scheduler(23, 59)
        assertEquals("0:00 tomorrow", scheduler.getNextTimeOf(-1, 0))
    }
}