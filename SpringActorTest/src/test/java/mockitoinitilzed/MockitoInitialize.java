

package mockitoinitilzed;


import java.util.LinkedList;

import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.Assert;


public class MockitoInitialize {

    @Test
    public void testMock() {
        // Mock
        LinkedList mocklinkedList = Mockito.mock(LinkedList.class);
        // Stub
        Mockito.when(mocklinkedList.get(0)).thenReturn("First Value");
        // Verify
        Assert.assertEquals("First Value", mocklinkedList.get(0));
        Mockito.verify(mocklinkedList).get(0);
    }

}
