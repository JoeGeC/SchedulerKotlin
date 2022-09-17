class Main{
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val input = generateSequence(::readLine)
            val lines = input.toList()
            run(lines, args[0].split(":"))
        }

        private fun run(config: List<String>, time: List<String>)
        {
            val converter = ConfigConverter(time[0], time[1])
            val results = converter.convert(config)
            println("\n")
            results.forEach{ println(it) }
        }
    }
}
