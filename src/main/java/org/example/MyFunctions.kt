package org.example

import java.util.*

class MyFunctions {

    companion object {
        @JvmStatic
        fun calcPrimesNumber1(limit: Int): Int {
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

        @JvmStatic
        fun calcPrimesNumber2(limit: Int): Int {
            if (limit <= 1) return 0
            val allNumbers = BitSet(limit - 1)
            for (i in 0 until limit - 1) allNumbers[i] = true

            var i = 2
            while (i * i <= limit) {
                if (allNumbers[i - 2]) for (j in i * i..limit step i) allNumbers[j - 2] = false
                i++
            }

            var count = 0
            for (j in 0 until limit) if (allNumbers[j]) count++

            return count
        }
    }
}
