package com.ssi.unittest.utils;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List listMock = mock(List.class);

    @Test
    public void size_basic(){
        when(listMock.size()).thenReturn(5);
        assertEquals(5, listMock.size());
    }

    @Test
    public void size_different_values(){
        when(listMock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, listMock.size());
        assertEquals(10, listMock.size());
    }

    @Test
    public void returnWithParam(){
        when(listMock.get(0)).thenReturn("any");
        assertEquals("any", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    public void returnWithAnyParam(){
        when(listMock.get(anyInt())).thenReturn("any");
        assertEquals("any", listMock.get(0));
        assertEquals("any", listMock.get(1));
    }

    @Test
    public void verify_basic(){
        List<String> stringMock =  mock(List.class);
        String value = (String) stringMock.get(0);
        String value1 = (String) stringMock.get(1);

        verify(stringMock).get(0);
        verify(stringMock, times(2)).get(anyInt());
        verify(stringMock, atLeast(1)).get(anyInt());
        verify(stringMock, atMost(2)).get(anyInt());
        verify(stringMock, never()).get(2);
    }

    @Test
    public void argumentCapture(){
        List<String> stringMock =  mock(List.class);
        stringMock.add("one");
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(stringMock).add(stringArgumentCaptor.capture());

        assertEquals("one", stringArgumentCaptor.getValue());
    }

    @Test
    public void argumentCapture_multiple(){
        List<String> stringMock =  mock(List.class);
        stringMock.add("one");
        stringMock.add("two");
        stringMock.add("three");

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(stringMock, times(3)).add(stringArgumentCaptor.capture());

        List<String> allValues = stringArgumentCaptor.getAllValues();
        assertEquals("one", allValues.get(0));
        assertEquals("two", allValues.get(1));
        assertEquals("three", allValues.get(2));
    }

    @Test
    public void mocking(){
        ArrayList arrayListMock =  mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); //default null
        System.out.println(arrayListMock.size()); //default 0
        arrayListMock.add("one");
        arrayListMock.add("two");
        System.out.println(arrayListMock.size());// 0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());
    }

    @Test
    public void spying(){
        ArrayList arrayListMock =  spy(ArrayList.class);
        arrayListMock.add("zero");
        System.out.println(arrayListMock.get(0)); //no default but real
        System.out.println(arrayListMock.size()); //no default but real
        arrayListMock.add("one");
        arrayListMock.add("two");
        System.out.println(arrayListMock.size());// 3
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());//after mock it will be shown overridden behave

        verify(arrayListMock).add("one");
//        verify(arrayListMock).add("three");
    }
}
