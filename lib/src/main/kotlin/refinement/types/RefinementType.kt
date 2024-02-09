package refinement.types

open class RefinementType<T>(val value: T, validation: (value: T) -> Unit) {
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


}
