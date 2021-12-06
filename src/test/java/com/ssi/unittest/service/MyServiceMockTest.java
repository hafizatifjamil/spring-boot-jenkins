package com.ssi.unittest.service;

import com.ssi.unittest.dao.MyDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyServiceMockTest {

    @InjectMocks
    MyService myService = new MyService();

    @Mock
    MyDao myDao;
//    MyService myService = new MyService();
//    MyDao myDao = mock(MyDao.class);
//    @BeforeEach
//    public void before(){
//        myService.setMyDao(myDao);
//    }

    @Test
    public void calculateSumTest_basic() {
        //when someone call getNumbers() then return new int[]{1,2}
        when(myDao.getNumbers()).thenReturn(new int[]{1,2});
        assertEquals(3, myService.sum());
    }

    @Test
    public void calculateSumTest_empty() {
        //when someone call getNumbers() then return new int[]{1,2}
        when(myDao.getNumbers()).thenReturn(new int[]{});
        assertEquals(0, myService.sum());
    }

    @Test
    public void calculateSumTest_oneElement() {
        //when someone call getNumbers() then return new int[]{1,2}
        when(myDao.getNumbers()).thenReturn(new int[]{5});
        assertEquals(5, myService.sum());
    }
}


