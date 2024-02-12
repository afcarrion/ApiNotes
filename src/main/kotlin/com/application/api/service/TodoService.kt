import com.application.api.data.Todo
import org.springframework.stereotype.Service
import java.util.*

@Service("Todo service")
class TodoService{

    fun getTodos(): List<Todo> = listOf(
        Todo(
            UUID.randomUUID().toString(),
            "My first todo",
            "this is a message from my first todo",
            System.currentTimeMillis().toString()
        ),

    )
}