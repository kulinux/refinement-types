package refinement.types

class PositiveInteger(value: Int): RefinementType<Int>(value, { require(it > 0) }) {

    operator fun plus(to: PositiveInteger): PositiveInteger {
        return PositiveInteger(this.value + to.value)
    }

    operator fun minus(to: PositiveInteger): PositiveInteger {
        return PositiveInteger(this.value - to.value)
    }

    operator fun times(to: PositiveInteger): PositiveInteger {
        return PositiveInteger(this.value * to.value)
    }
}

fun Int.to(): PositiveInteger {
    return PositiveInteger(this)
}
