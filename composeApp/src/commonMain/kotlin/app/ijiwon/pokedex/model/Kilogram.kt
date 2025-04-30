package app.ijiwon.pokedex.model

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class Kilogram(val value: Float) {
    override fun toString(): String {
        return value.toString().plus(SYMBOL)
    }

    companion object {
        private const val SYMBOL = "kg"
    }
}