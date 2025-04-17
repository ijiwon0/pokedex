package app.ijiwon.pokedex.utils.coroutines.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingCommand
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.transformLatest

object WhileSubscribedOrRetained : SharingStarted {

    override fun command(subscriptionCount: StateFlow<Int>): Flow<SharingCommand> =
        subscriptionCount.transformLatest { count ->
            if (count > 0) {
                emit(SharingCommand.START)
            } else {
                awaitFrameRendered()

                emit(SharingCommand.STOP)
            }
        }.dropWhile { it != SharingCommand.START }
            .distinctUntilChanged()
}

expect suspend fun awaitFrameRendered()