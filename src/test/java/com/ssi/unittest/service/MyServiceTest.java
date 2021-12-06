package com.ssi.unittest.service;

import com.ssi.unittest.dao.MyDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyDaoStub implements MyDao {
    @Override
    public int[] getNumbers() {
        return new int[]{1,2};
    }
}
class MyDaoEmptyStub implements MyDao {
    @Override
    public int[] getNumbers() {
        return new int[]{};
    }
}

class MyDaoOneElementStub implements MyDao {
    @Override
    public int[] getNumbers() {
        return new int[]{5};
    }
}

public class MyServiceTest {

    @Test
    public void calculateSumTest_basic() {
        MyService myService = new MyService();
        myService.setMyDao(new MyDaoStub());
        int actualResult = myService.sum();
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumTest_empty() {
        MyService myService = new MyService();
        myService.setMyDao(new MyDaoEmptyStub());
        int actualResult = myService.sum();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumTest_oneElement() {
        MyService myService = new MyService();
        myService.setMyDao(new MyDaoOneElementStub());
        int actualResult = myService.sum();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}


