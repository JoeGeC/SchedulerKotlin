class Main{
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val input = generateSequence(::readLine)
            val lines = input.toList()
            if(args.isEmpty())
                printError()
            else
                run(lines, args[0].split(":"))
        }

        private fun printError() =
            println("Please enter the command in the format <cat input.txt | java -jar SchedulerParser.jar hh:mm>")

        private fun run(config: List<String>, time: List<String>)
        {
            val converter = ConfigConverter(time[0], time[1])
            val results = converter.convert(config)
            println("\n")
            results.forEach{ println(it) }
        }
    }
}
