package com.example.lemonjuice

interface Repository {

    fun increment()
    fun isLast(): Boolean
    fun reset()

    class Base(
        private var counter: IntCache,
    ) : Repository {

        override fun increment() {
            val old = counter.read()
            val new = old + 1
            counter.save(new)
        }

        override fun isLast() = counter.read() == 5

        override fun reset() {
            counter.save(0)
        }
    }
}