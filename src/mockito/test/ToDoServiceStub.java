package mockito.test;

import mockito.data.TodoService;

import java.util.Arrays;
import java.util.List;

public class ToDoServiceStub implements TodoService{

    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
    }
}
