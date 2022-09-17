import java.io.File
import java.lang.Exception

class FileReader {
    companion object {
        fun readFile(textFilePath: String?): MutableList<String>? {
             return try {
                val result = mutableListOf<String>()
                File(textFilePath).forEachLine { result.add(it) }
                result
            } catch (e: Exception){
                null
            }
        }
    }

}
