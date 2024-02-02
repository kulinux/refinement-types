package refinement.types

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertTrue


class PositiveIntegerShould {

    @Test
    fun `build a positive integer from integer`() {
        val positiveInteger: PositiveInteger = 5.to()
        assertTrue(positiveInteger.value == 5)
    }

    @Test
    fun `raise an error when build from negative integer`() {
        assertFails {
            (-5).to()
        }
    }

    @Test
    fun `have the ability to add`() {
        assertEquals(11.to(), 5.to() + 6.to())
    }

    @Test
    fun `have the ability to subtract`() {
        assertEquals(1.to(), 6.to() - 5.to())
    }

    @Test
    fun `have the ability to multiply`() {
        assertEquals(30.to(), 5.to() * 6.to())
    }

    @Test
    fun `raise an error on resulting an illegal operation`() {
        assertFails {
            5.to() - 6.to()
        }
    }
}
