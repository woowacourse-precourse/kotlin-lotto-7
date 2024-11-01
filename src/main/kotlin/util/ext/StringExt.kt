package util.ext

fun String.isNumeric(): Boolean{
    return this.toIntOrNull() != null
}

fun String.isThousandUnit(): Boolean{
    return this != "0" && this.toInt() % 1000 == 0
}

fun String.toThousandUnit(): Int{
    return this.toInt() / 1000
}

fun String.splitByComma(): List<String>{
    return this.split(",")
}