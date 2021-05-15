package ru.netology

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.roundToInt

class MainKtTest {
    @Test
    fun commissionCommissionVK_Pay() {
        val amount=0
        val maxLimitMaster=0
        val moneyMonth =0
        val creditCard="VK Pay"
        commissionPay(
            amount=amount,
            creditCard=creditCard,
            maxLimitMaster=maxLimitMaster,
            moneyMonth=moneyMonth
        )
            val result = 0
            assertEquals(1, result)
        }


    @Test
    fun commissionCommissionMaster() {
        val amount=100_000*100
        val maxLimitMaster=75_000
        val moneyMonth =0
        val creditCard="Master"
        commissionPay(
            amount=amount,
            creditCard=creditCard,
            maxLimitMaster=maxLimitMaster,
            moneyMonth=moneyMonth
        )
        if (moneyMonth * 100 + amount > maxLimitMaster * 100) {
            val result = (amount * 0.6).roundToInt() + (20 * 100)

            assertEquals(6_002_000, result)
        }
    }
    @Test
    fun commissionNonCommissionMaster() {
        val amount=1000*100
        val maxLimitMaster=75_000
        val moneyMonth =0
        val creditCard="Master"
        commissionPay(
            amount=amount,
            creditCard=creditCard,
            maxLimitMaster=maxLimitMaster,
            moneyMonth=moneyMonth
        )
        if (moneyMonth * 100 + amount > maxLimitMaster * 100) {
            val result = (amount * 0.6).roundToInt() + (20 * 100)

            assertEquals(0, result)
        }
    }
    @Test
    fun commissionCommissionVisa() {
        val amount=100
        val maxLimitMaster=75_000
        val moneyMonth =0
        val creditCard="Visa"
        commissionPay(
            amount=amount,
            creditCard=creditCard,
            maxLimitMaster=maxLimitMaster,
            moneyMonth=moneyMonth
        )
            val result= (amount * 0.75).roundToInt()
            assertEquals(75, result)

    }
    @Test
    fun commissionCommissionVisaAndMir() {
        val amount=100_000
        val maxLimitMaster=75_000
        val moneyMonth =0
        val creditCard="Visa"
        commissionPay(
            amount=amount,
            creditCard=creditCard,
            maxLimitMaster=maxLimitMaster,
            moneyMonth=moneyMonth
        )
        val result= (amount * 0.75).roundToInt()
        assertEquals(75_000, result)

    }
}