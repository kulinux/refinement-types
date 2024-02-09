package refinement.types

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertTrue


class RangeIntegerShould {

    @Test
    fun `build a range integer from integer`() {
        val rangeInteger: RangeInteger = 5.toRI(1, 5)
        assertTrue(rangeInteger.value == 5)
    }

    @Test
    fun `raise an error when build from out of range`() {
        assertFails {
            5.toRI(1, 2)
        }
    }

    @Test
    fun `have the ability to add`() {
        assertEquals(2.toRI(1, 5), 1.toRI(1, 5) + 1.toRI(1, 5))
    }

    @Test
    fun `have the ability to subtract`() {
        assertEquals(1.toRI(1, 5), 5.toRI(1, 5) - 4.toRI(1, 5))
    }

    @Test
    fun `have the ability to multiply`() {
        assertEquals(30.toRI(1, 50), 5.toRI(1, 50) * 6.toRI(1, 50))
    }

    @Test
    fun `raise an error on resulting an illegal operation`() {
        assertFails {
            5.toRI(1, 5) - 6.toRI(1, 5)
        }
    }
}
