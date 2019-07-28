package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName (fullName:String?):Pair<String?, String?>{

        val parts : List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return firstName to lastName
    }

    fun transliterations(payload: String, divider:String = " ") : String {
        var nickName:String = ""
        var letter:String = ""
        payload.forEach {
            if (it.toUpperCase() == it) {
                letter += when(it.toLowerCase()) {
                    'а' -> 'a'
                    'б' -> 'b'
                    'в' -> 'v'
                    'г' -> 'g'
                    'д' -> 'd'
                    'е' -> 'e'
                    'ё' -> 'e'
                    'ж' -> "zh"
                    'з' -> 'z'
                    'и' -> 'i'
                    'й' -> 'i'
                    'к' -> 'k'
                    'л' -> 'l'
                    'м' -> 'm'
                    'н' -> 'n'
                    'о' -> 'o'
                    'п' -> 'p'
                    'р' -> 'r'
                    'с' -> 's'
                    'т' -> 't'
                    'у' -> 'u'
                    'ф' -> 'f'
                    'х' -> 'h'
                    'ц' -> 'c'
                    'ч' -> "ch"
                    'ш' -> "sh"
                    'щ' -> "sh"
                    'ъ' -> ""
                    'ы' -> "i"
                    'ь' -> ""
                    'э' -> 'e'
                    'ю' -> "yu"
                    'я' -> "ya"
                    ' ' -> divider
                    else -> it
                }
                nickName+=letter.toUpperCase()
                letter = ""

            } else {
                nickName+= when(it) {
                    'а' -> 'a'
                    'б' -> 'b'
                    'в' -> 'v'
                    'г' -> 'g'
                    'д' -> 'd'
                    'е' -> 'e'
                    'ё' -> 'e'
                    'ж' -> "zh"
                    'з' -> 'z'
                    'и' -> 'i'
                    'й' -> 'i'
                    'к' -> 'k'
                    'л' -> 'l'
                    'м' -> 'm'
                    'н' -> 'n'
                    'о' -> 'o'
                    'п' -> 'p'
                    'р' -> 'r'
                    'с' -> 's'
                    'т' -> 't'
                    'у' -> 'u'
                    'ф' -> 'f'
                    'х' -> 'h'
                    'ц' -> 'c'
                    'ч' -> "ch"
                    'ш' -> "sh"
                    'щ' -> "sh"
                    'ъ' -> ""
                    'ы' -> "i"
                    'ь' -> ""
                    'э' -> 'e'
                    'ю' -> "yu"
                    'я' -> "ya"
                    ' ' -> divider
                    else -> it
                }
            }

        }
        return nickName
    }

    fun toInitials(firstName: String?, lastName: String?) : String? {
        var initials:String? = null
        if (firstName !== null && lastName != null && lastName != "" && lastName != " " && firstName != "" && firstName != " ") {
            initials = "${firstName?.getOrNull(0)?.toUpperCase()}${lastName?.getOrNull(0)?.toUpperCase()}"
        } else if (firstName != null && firstName != "" && firstName != " ") {
            initials = "${firstName?.getOrNull(0)?.toUpperCase()}"
        } else if (lastName != null && lastName != "" && lastName != " ") {
            initials = "${lastName?.getOrNull(0)?.toUpperCase()}"
        }

        return "$initials"
    }
}