package refinement.types

abstract class RefinementType<T>(val value: T, validation: (value: T) -> Unit) {
    init {
        validation(value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return this.value == (other as RefinementType<T>).value
    }

    override fun hashCode(): Int {
        return this.value.hashCode()
    }

    abstract operator fun plus(to: RefinementType<T>): RefinementType<T>
    abstract operator fun minus(to: RefinementType<T>): RefinementType<T>
    abstract operator fun times(to: RefinementType<T>): RefinementType<T>
}


interface RefinementTypesScope<T> {
    fun T.rt(): RefinementType<T>
}
