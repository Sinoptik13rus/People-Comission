fun main() {
    val numberOfSecond: Int = 111361
    val exemplaryPhrase = agoToText(numberOfSecond)
    println(exemplaryPhrase)
}

fun agoToText(numberOfSecond: Int): String {
    val phrase: String
    when (numberOfSecond) {
        in 0..60 -> phrase = "Был(а) только что"
        in 61..(60 * 60) -> phrase = minuteEdit(numberOfSecond)
        in (60 * 60 + 1)..(24 * 60 * 60) -> phrase = hourEdit(numberOfSecond)
        in (24 * 60 * 60 + 1)..(2 * 24 * 60 * 60) -> phrase = "Был(а) в сети сегодня"
        in (2 * 24 * 60 * 60 + 1)..(3 * 24 * 60 * 60) -> phrase = "Был(а) в сети вчера"
        else -> phrase = "Был(а) в сети давно"
    }
    return phrase
}

fun minuteEdit(numberOfSecond: Int): String {
    val editPhrase: String
    val numbersOfMinute = (numberOfSecond / 60).toInt()
    val remainder = numbersOfMinute % 10
    when {
        ((remainder == 1) && (numbersOfMinute !== 11)) -> editPhrase = "Был(а) $numbersOfMinute минуту назад"
        ((1 < remainder) && (remainder < 5)) -> editPhrase = "Был(а) $numbersOfMinute минуты назад"
        else -> editPhrase = "Был(а) $numbersOfMinute минут назад"
    }
    return editPhrase

}

fun hourEdit(numberOfSecond: Int): String {
    val editPhrase1: String
    val numbersOfHours = (numberOfSecond / 60 / 60).toInt()
    val remainder1 = numbersOfHours % 10
    when {
        ((numbersOfHours == 1) || (numbersOfHours == 21)) -> editPhrase1 = "Был(а) $numbersOfHours час назад"
        ((1 < remainder1) && (remainder1 < 5)) -> editPhrase1 = "Был(а) $numbersOfHours часа назад"
        else -> editPhrase1 = "Был(а) $numbersOfHours часов назад"
    }
    return editPhrase1

}
