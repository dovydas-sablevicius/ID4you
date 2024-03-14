package com.project.id4you.common

import org.junit.Assert.assertEquals
import org.junit.Test

class TestingTest {

    @Test
    fun add() {
        val testing = Testing()
        val result = testing.add(2, 3)
        assertEquals(5, result)
    }
}
