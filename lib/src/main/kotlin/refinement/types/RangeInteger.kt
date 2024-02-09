package refinement.types

class RangeInteger(value: Int, private val min: Int, private val max: Int) :
    RefinementType<Int>(value, { require(it in min..max) }) {


    operator fun plus(to: RangeInteger): RangeInteger {
        return RangeInteger(this.value + to.value, this.min, this.max)
    }

    operator fun minus(to: RangeInteger): RangeInteger {
        return RangeInteger(this.value - to.value, this.min, this.max)
    }

    operator fun times(to: RangeInteger): RangeInteger {
        return RangeInteger(this.value * to.value, this.min, this.max)
    }
}

fun Int.toRI(min: Int, max: Int): RangeInteger {
    return RangeInteger(this, min, max)
}
