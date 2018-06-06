package mockito.test;

import mockito.business.TodoBusinessImpl;
import mockito.data.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;

public class TodoBusinessImplStub {

    @Test
    public void usingStub(){
        TodoService todoService = mock(TodoService.class);
       // List<String> re = stub(todoService.retrieveTodos("user")).;
      when(todoService.retrieveTodos("Dummy")).
                thenReturn(Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance"));

//        TodoService service = new ToDoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> result = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2,result.size());
    }
}
