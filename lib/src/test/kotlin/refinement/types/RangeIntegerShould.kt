package refinement.types

import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertTrue


private class RangeIntegerRefinementTypeResolver : ParameterResolver {
    override fun supportsParameter(parameterContext: ParameterContext?, extensionContext: ExtensionContext?): Boolean {
        return parameterContext?.parameter?.type === RefinementTypesScope::class.java
    }

    override fun resolveParameter(parameterContext: ParameterContext?, extensionContext: ExtensionContext?): Any {
        return toRangeIntegerScope(1, 5)
    }
}

context(RefinementTypesScope<Int>)
@ExtendWith(RangeIntegerRefinementTypeResolver::class)
class RangeIntegerShould {

    @Test
    fun `build a range integer from integer`() {
        val rangeInteger = 5.rt()
        assertTrue(rangeInteger.value == 5)
    }

    @Test
    fun `raise an error when build from out of range`() {
        assertFails {
            7.rt()
        }
    }

    @Test
    fun `have the ability to add`() {
        assertEquals(2.rt(), 1.rt() + 1.rt())
    }

    @Test
    fun `have the ability to subtract`() {
        assertEquals(1.rt(), 5.rt() - 4.rt())
    }

    @Test
    fun `have the ability to multiply`() {
        assertEquals(4.rt(), 2.rt() * 2.rt())
    }

    @Test
    fun `raise an error on resulting an illegal operation`() {
        assertFails {
            5.rt() - 6.rt()
        }
    }

}
