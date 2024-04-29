package com.example.lemonjuice

interface Repository {

    fun increment()
    fun isLast(): Boolean
    fun reset()
    fun getCounter(): Int

    class Base(
        private var counter: Int = 0,
    ) : Repository {

        override fun increment() {
            counter++
        }

        override fun isLast() = counter == 5

        override fun reset() {
            counter = 0
        }

        override fun getCounter() = counter
    }
}