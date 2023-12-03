class Day2 {
    val MAX_RED = 12
    val MAX_GREEN = 13
    val MAX_BLUE = 14
    fun solve(input: String): Int {
        val lines = input.split("\n")
        var sum = 0
        for (line in lines){
            if(line.isEmpty()) continue
            sum += processLine(line)
        }

        return sum
    }

    private fun processLine(line: String): Int {
        val gameId = Regex("Game (\\d+)").find(line)!!.groupValues[1].toInt()
        if (!isColorCubeCountValid(line, Regex("(\\d+) red"), MAX_RED) ||
            !isColorCubeCountValid(line, Regex("(\\d+) green"), MAX_GREEN) ||
            !isColorCubeCountValid(line, Regex("(\\d+) blue"), MAX_BLUE)){
                return 0
        }
        return gameId
    }

    private fun isColorCubeCountValid(input: String, r: Regex, max: Int): Boolean {
        val matches = r.findAll(input)
        for (match in matches){
            if (match.groupValues[1].toInt() > max)
                return false
        }
        return true
    }
}