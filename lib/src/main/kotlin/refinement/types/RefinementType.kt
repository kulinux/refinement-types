package refinement.types

open class RefinementType<T>(val value: T, validation: (value: T) -> Unit) {
    init {
        validation(value)
    }
}
