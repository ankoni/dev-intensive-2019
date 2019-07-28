package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND) : Date {
    var time = this.time

    time+=when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
        else -> throw IllegalStateException("invalid unit")
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date : Date = Date()) : String {
    val current = Date().time
    val diff = (current - this.time)
    val absDiff = abs(diff)
    val strDiff:String?

    if (diff >= 0 ) {
        if ((diff/ SECOND) <= 75) {
            strDiff = when(diff/ SECOND) {
                in 0..1 -> "только что"
                in 1..45 -> "несколько секунд назад"
                else -> "минуту назад"
            }
        } else if ((diff/ MINUTE) <= 75) {
            strDiff = when(diff/ MINUTE) {
                in 2..4 -> "${diff/ MINUTE} минуты назад"
                in 5..45 -> "${diff/ MINUTE} минут назад"
                else -> "час назад"
            }
        } else if ((diff/ HOUR <= 26)) {
            strDiff = when(diff/ HOUR) {
                in 2..4 -> "${diff/ HOUR} часа назад"
                in 5..22 -> "${diff/ HOUR} часов назад"
                else -> "день назад"
            }
        } else {
            strDiff = when(diff/ DAY) {
                in 2..4 -> "${diff/ DAY} дня назад"
                in 5..360 -> "${diff/ DAY} дней назад"
                else -> "более года назад"
            }
        }
    } else {
        if ((absDiff/ SECOND + 1) <= 75) {
            strDiff = when(absDiff/ SECOND + 1) {
                in 0..1 -> "только что"
                in 1..45 -> "через несколько секунд"
                else -> "через минуту"
            }
        } else if ((absDiff/ MINUTE + 1) <= 75) {
            strDiff = when(absDiff/ MINUTE + 1) {
                in 2..4 -> "через ${absDiff/ MINUTE + 1 } минуты"
                in 5..45 -> "через ${absDiff/ MINUTE + 1} минут"
                else -> "через час"
            }
        } else if ((absDiff/ HOUR + 1 <= 26)) {
            strDiff = when(absDiff/ HOUR + 1) {
                in 2..4 -> "через ${absDiff/ HOUR + 1 } часа"
                in 5..22 -> "через ${absDiff/ HOUR + 1} часов"
                else -> "через день"
            }
        } else {
            strDiff = when(absDiff/ DAY + 1) {
                in 2..4 -> "через ${absDiff/ DAY + 1} дня"
                in 5..360 -> "через ${absDiff/ DAY + 1} дней"
                else -> "более чем через год"
            }
        }

    }
    return "$strDiff"
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}