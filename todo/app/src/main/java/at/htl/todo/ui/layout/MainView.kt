package at.htl.todo.ui.layout

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import at.htl.todo.model.Model
import at.htl.todo.model.ModelStore
import at.htl.todo.model.Todo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/*
@Singleton
class MainView @Inject constructor() {

    @Inject
    lateinit var store: ModelStore

    @Inject
    lateinit var detailView: DetailView


    fun buildContent(activity: ComponentActivity) {
        activity.enableEdgeToEdge()
        activity.setContent {
            val viewModel = store
                .pipe
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeAsState(initial = Model())
                .value
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Todos(model = viewModel, modifier = Modifier.padding(all = 32.dp), store)
            }
        }
    }
}
*/

@Composable
fun Todos(model: Model, store: ModelStore) {
    val todos = model.todos

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        items(todos.size) { index ->
            TodoRow(todo = todos[index], store)
            HorizontalDivider()
        }
    }
}

@Composable
fun TodoRow(todo: Todo, store: ModelStore) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1F)
        ) {
            Text(
                text = todo.title,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Column {
            Checkbox(
                checked = todo.completed,
                onCheckedChange = {
                    store.apply {
                            m -> m.todos.filter { t -> t.id == todo.id }.first().completed = !todo.completed
                    }
                }
            )
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun TodoPreview() {
    val model = Model()
    val todo = Todo()
    todo.id = 1
    todo.title = "First Todo"
    model.todos = arrayOf(todo)

    TodoTheme {
        Todos(model)
    }
}*/