package utils

object ExtensionUtil {
    fun String.getInt(): Int? {
        return this.toIntOrNull()
    }

}