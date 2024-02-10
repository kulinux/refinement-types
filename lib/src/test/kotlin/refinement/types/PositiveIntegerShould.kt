package refinement.types

import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertTrue

private class PositiveRefinementTypeResolver : ParameterResolver {
    override fun supportsParameter(parameterContext: ParameterContext?, extensionContext: ExtensionContext?): Boolean {
        return parameterContext?.parameter?.type === RefinementTypesScope::class.java
    }

    override fun resolveParameter(parameterContext: ParameterContext?, extensionContext: ExtensionContext?): Any {
        return toPositiveIntegerScope
    }
}

context(RefinementTypesScope<Int>)
@ExtendWith(PositiveRefinementTypeResolver::class)
class PositiveIntegerShould {


    @Test
    fun `build a positive integer from integer`() {
        val positiveInteger = 5.rt()
        assertTrue(positiveInteger.value == 5)
    }

    @Test
    fun `raise an error when build from negative integer`() {
        assertFails {
            (-5).rt()
        }
    }

    @Test
    fun `have the ability to add`() {
        assertEquals(11.rt(), 5.rt() + 6.rt())
    }

    @Test
    fun `have the ability to subtract`() {
        assertEquals(1.rt(), 6.rt() - 5.rt())
    }

    @Test
    fun `have the ability to multiply`() {
        assertEquals(30.rt(), 5.rt() * 6.rt())
    }

    @Test
    fun `raise an error on resulting an illegal operation`() {
        assertFails {
            5.rt() - 6.rt()
        }
    }
}

