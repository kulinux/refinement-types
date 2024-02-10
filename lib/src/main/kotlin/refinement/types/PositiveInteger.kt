package refinement.types

private class PositiveInteger(value: Int): RefinementType<Int>(value, { require(it > 0) }) {

    override operator fun minus(to: RefinementType<Int>): PositiveInteger {
        return PositiveInteger(this.value - to.value)
    }

    override operator fun times(to: RefinementType<Int>): PositiveInteger {
        return PositiveInteger(this.value * to.value)
    }

    override fun plus(to: RefinementType<Int>): RefinementType<Int> {
        return PositiveInteger(this.value + to.value)
    }
}

val toPositiveIntegerScope = object: RefinementTypesScope<Int> {
    override fun Int.rt(): RefinementType<Int> {
        return PositiveInteger(this)
    }
}

