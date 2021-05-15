package ru.netology

import kotlin.math.roundToInt
import kotlin.random.Random.Default.nextInt

val creditCard = "Master" //выбор карты
val amount = nextInt(0, 200_000) * 100
val moneyMonth = 0 //общая сумма переводов за месяц
val maxLimitMaster = 75_000 // максимальная сумма перевода для Мaster в месяц без коммиссии
val maxLimitMounthCreditCard = 600_000  //максимальная сумма перевода за месяц для карт
val maxLimitVK = 40_000 // максимальная сумма перевода за месяц для VK Pay
val maxLimitDayVK = 15_000   //максимальная сумма перевода в день для VK Pay
val maxLimitDayCard = 150_000   //максимальная сумма перевода в день для карт
fun main() {
    when {
        amount == 0 -> println("Operation is not possible")
        limitMoneyDay() == true -> println("Operation is not possible")

        limitMoneyMonth() == true -> println("Operation is not possible")
        else -> commissionPay(creditCard,amount,maxLimitMaster, moneyMonth)
    }
}
fun commissionPay(creditCard:String,amount:Int,maxLimitMaster:Int,moneyMonth:Int) {
    var commission = 0
    when {
        creditCard == "Master" || creditCard == "Maestro" ->
            if (moneyMonth * 100 + amount > maxLimitMaster * 100) {
                commission = (amount * 0.6).roundToInt() + (20 * 100)
                println("commission: $commission")
            } else {
                commission = 0
                println("commission: $commission")
            }

        creditCard == "Visa" || creditCard == "Mir" ->
            if (amount * 0.75 < 35 * 100) {
                println("Operation is not possible")
            } else {
                commission = (amount * 0.75).roundToInt()
                println("commission: $commission")
            }
        else -> println("commission: $commission")

    }

}

fun limitMoneyMonth(): Boolean {
    when (true) {
        creditCard == "Master" || creditCard == "Maestro" ->
            if (moneyMonth * 100 + amount > maxLimitMounthCreditCard * 100) {
                return true
            }
        creditCard == "Visa" || creditCard == "Mir" ->
            if (moneyMonth * 100 + amount > maxLimitMounthCreditCard * 100) {
                return true
            }
        creditCard == "VK Pay" ->
            if (moneyMonth * 100 + amount > maxLimitVK * 100) {
                return true
            }
        else -> return false
    }
    return false
}

fun limitMoneyDay(): Boolean {
    when {
        creditCard == "Master" || creditCard == "Maestro" ->
            if (amount > maxLimitDayCard * 100) {
                return true
            }
        creditCard == "Visa" || creditCard == "Mir" ->
            if (amount > maxLimitDayCard * 100) {
                return true
            }
        creditCard == "VK Pay" ->
            if (amount > maxLimitDayVK * 100) {
                return true
            }
        else -> return false
    }
    return false
}