package refinement.types

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertTrue


class PositiveIntegerShould {

    @Test
    fun `build a positive integer from integer`() {
        val positiveInteger: PositiveInteger = 5.toPI()
        assertTrue(positiveInteger.value == 5)
    }

    @Test
    fun `raise an error when build from negative integer`() {
        assertFails {
            (-5).toPI()
        }
    }

    @Test
    fun `have the ability to add`() {
        assertEquals(11.toPI(), 5.toPI() + 6.toPI())
    }

    @Test
    fun `have the ability to subtract`() {
        assertEquals(1.toPI(), 6.toPI() - 5.toPI())
    }

    @Test
    fun `have the ability to multiply`() {
        assertEquals(30.toPI(), 5.toPI() * 6.toPI())
    }

    @Test
    fun `raise an error on resulting an illegal operation`() {
        assertFails {
            5.toPI() - 6.toPI()
        }
    }
}
