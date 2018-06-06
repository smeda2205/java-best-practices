package mockito.test;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {


    @Test
    public void test(){
        List list = mock(List.class);
        when(list.size()).thenReturn(2);
        assertEquals("size:",list.size(),2);
    }
}
