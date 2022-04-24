package org.example

import java.util.*

class MyFunctions {

    companion object {

        /**
         * Подсчёт количества простых чисел в интевале до limit
         *
         * Решенеие решетом Эратосфена
         * link: https://ru.wikipedia.org/wiki/Решето_Эратосфена
         *
         * T = O(N*log(log(N)))
         * R = O(N)
         */
        @JvmStatic
        fun calcPrimesNumber1(limit: Int): Int {
            if (limit <= 1) return 0
            val allNumbers = BitSet(limit - 1)
            for (i in 0 until limit - 1) allNumbers[i] = true

            var i = 2
            while (i * i <= limit) {
                if (allNumbers[i - 2]) for (j in i * i..limit step i) allNumbers[j - 2] = false
                i++
            }

            var count = 0
            for (j in 0 until limit - 1) if (allNumbers[j]) count++

            return count
        }

        /**
         * Подсчёт количества простых чисел в интевале до limit
         *
         * Решенеие решетом Эратосфена с линейным временем работы
         * link: https://ru.wikipedia.org/wiki/Решето_Эратосфена#Решето_Эратосфена_с_линейным_временем_работы
         *
         * T = O(N)
         * R = O(N + M),
         * где N - количество чисел (limit),
         * M - количество простых чисел среди N чисел
         *
         * R очень велика, так как в обоих массивых хранятся сами числа,
         * на значениях близких к 10^9 возникнет Java Heap Space Error
         * Но трудоёмкость действительно O(N)
         */
        @JvmStatic
        fun calcPrimesNumber2(limit: Int): Int {
            val primes = mutableListOf<Int>()
            if (limit <= 1) return 0
            val allNumbers = IntArray(limit - 1)

            for (i in 0..limit - 2) {
                if (allNumbers[i] == 0) {
                    allNumbers[i] = i + 2
                    primes.add(i + 2)
                }
                for (p in primes) {
                    if (p > allNumbers[i] || p * (i + 2) > limit) break
                    allNumbers[p * (i + 2) - 2] = p
                }
            }
            return primes.size
        }

        /**
         * Подсчёт количества простых чисел в интевале до limit
         * Тест для проверки задержки во времени MutableList
         *
         * Решенеие решетом Эратосфена с линейным временем работы
         * link: https://ru.wikipedia.org/wiki/Решето_Эратосфена#Решето_Эратосфена_с_линейным_временем_работы
         *
         * T = O(N)
         * R = O(N + M),
         * где N - количество чисел (limit),
         * M - количество простых чисел среди N чисел
         *
         * R очень велика, так как в обоих массивых хранятся сами числа,
         * на значениях близких к 10^9 возникнет Java Heap Space Error
         * Но трудоёмкость действительно O(N)
         */
        @JvmStatic
        fun testCalcPrimesNumber2(limit: Int, countPrimes: Int): Int {
            val primes = IntArray(countPrimes)
            if (limit <= 1) return 0
            val allNumbers = IntArray(limit - 1)
            var saveI = 0
            for (i in 0..limit - 2) {
                if (allNumbers[i] == 0) {
                    allNumbers[i] = i + 2
                    primes[saveI] = i + 2
                    saveI++
                }
                for (p in primes) {
                    if (p == 0) break
                    if (p > allNumbers[i] || p * (i + 2) > limit) break
                    allNumbers[p * (i + 2) - 2] = p
                }
            }
            return primes.size
        }

        /*
        /**
         * Тест времени для заполненеия BitSet длиной limit-1
         * противоположными значениями (true)
         */
        @JvmStatic
        fun testTimeArrays1(limit: Int) {
            val allNumbers = BitSet(limit - 1)
            for (i in 0 until limit - 1) allNumbers[i] = true
        }

        /**
         * Тест времени для заполненеия IntArray длиной limit-1
         * значениями самих чисел (i)
         * и заполенения mutableList длиной countPrimes значениями i
         */
        @JvmStatic
        fun testTimeArrays2(limit: Int, countPrimes: Int) {
            val allNumbers = IntArray(limit - 1)
            val primes = IntArray(countPrimes)
            for (i in 0 until limit - 1) allNumbers[i] = i
            for (i in 0 until countPrimes) primes[i] = i
        }
        */
    }
}
