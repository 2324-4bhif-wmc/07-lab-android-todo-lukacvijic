package at.htl.todo.ui.layout

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import at.htl.todo.model.Model
import at.htl.todo.model.ModelStore
import at.htl.todo.model.TodoService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainViewBuilder {
    @Inject
    lateinit var store: ModelStore

    @Inject
    lateinit var toDoService: TodoService

    @Inject
    constructor() {
    }

    fun setContentOfActivity(activity: ComponentActivity) {
        val view = ComposeView(activity)
        view.setContent {
            val viewModel = store
                .pipe
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeAsState(initial = Model())
                .value

            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                TabScreen(viewModel, store)
            }
        }
        activity.setContentView(view)
    }
}