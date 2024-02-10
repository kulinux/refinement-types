package refinement.types

private class RangeInteger (value: Int, private val min: Int, private val max: Int) :
    RefinementType<Int>(value, { require(it in min..max) }) {


    override operator fun plus(to: RefinementType<Int>): RangeInteger {
        return RangeInteger(this.value + to.value, this.min, this.max)
    }

    override operator fun minus(to: RefinementType<Int>): RangeInteger {
        return RangeInteger(this.value - to.value, this.min, this.max)
    }

    override operator fun times(to: RefinementType<Int>): RangeInteger {
        return RangeInteger(this.value * to.value, this.min, this.max)
    }
}

fun toRangeIntegerScope(min: Int, max: Int) = object : RefinementTypesScope<Int> {
    override fun Int.rt(): RefinementType<Int> {
        return RangeInteger(this, min, max)
    }
}



