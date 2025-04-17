package app.ijiwon.pokedex.utils.coroutines.flow

import android.os.Looper
import android.view.Choreographer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine

actual suspend fun awaitFrameRendered() = suspendCancellableCoroutine { continuation ->
    val frameCallback = Choreographer.FrameCallback {
        if (!continuation.isCompleted) {
            with(continuation) {
                Dispatchers.Main.resumeUndispatched(Unit)
            }
        }
    }

    if (Looper.myLooper() === Looper.getMainLooper()) {
        Choreographer.getInstance().postFrameCallback(frameCallback)
    } else {
        Dispatchers.Main.dispatch(continuation.context) {
            Choreographer.getInstance().postFrameCallback(frameCallback)
        }
    }

    continuation.invokeOnCancellation {
        Choreographer.getInstance().removeFrameCallback(frameCallback)
    }
}