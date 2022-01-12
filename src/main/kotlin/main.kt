import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    while (true) {
        println("Введите время в секундах или введите 0 для выхода")
        val time = scanner.nextInt()
        if (time == 0) break
        println(agoToText(time))
    }
}

fun agoToText(time: Int): String {
    return when (time) {
        in 0..60 -> "был(а) только что"
        in 61..60 * 60 -> "был(а) " + time / 60 + minutesByText(time) + " назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "был(а) " + time / 3600 + hourText(time) + " назад"
        in 24 * 3600 + 1..48 * 3600 -> "был(а) сегодня"
        in 48 * 3600 + 1..72 * 3600 -> "был(а) вчера"
        else -> "был(а) давно"
    }
}

fun minutesByText(time: Int): String {
    val minutesTime = time / 60
    return when {
        minutesTime == 1 || minutesTime % 10 == 1 && minutesTime % 100 != 11 -> "минуту"
        minutesTime in 2..4 -> "минуты"
        else -> "минут"
    }
}

fun hourText(time: Int): String {
    val hourTime = time / 3600
    return when {
        hourTime == 1 || time % 10 == 1 && time % 100 != 11 -> "час"
        hourTime in 2..4 || hourTime > 21 -> "часа"
        else -> "часов"
    }
}