package app.ijiwon.pokedex.utils.coroutines.flow

import kotlinx.coroutines.yield

actual suspend fun awaitFrameRendered() {
    yield()
}