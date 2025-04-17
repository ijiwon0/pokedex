package app.ijiwon.pokedex.utils.log

import co.touchlab.kermit.Logger

object Timber {

    private val logger = Logger.apply {
        setTag("ijiwon")
    }

    fun d(message: String, throwable: Throwable? = null) {
        logger.d(message, throwable)
    }
}