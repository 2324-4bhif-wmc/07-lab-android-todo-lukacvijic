package at.htl.todo.ui.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import at.htl.todo.model.Model
import at.htl.todo.model.Todo

@Composable
fun DetailedTodos(model: Model) {
    val todos = model.todos

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        items(todos.size) { index ->
            DetailRow(todo = todos[index])
            HorizontalDivider()
        }
    }
}

@Composable
fun DetailRow(todo: Todo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "ID: " + todo.id.toString(),
            style = MaterialTheme.typography.bodySmall
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Title: " + todo.title,
            style = MaterialTheme.typography.bodySmall
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Completed: " + todo.completed,
            style = MaterialTheme.typography.bodySmall,
            color = if(todo.completed)  Color.Green else Color.Red
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "UserID: " + todo.userId,
            style = MaterialTheme.typography.bodySmall
        )
    }
}