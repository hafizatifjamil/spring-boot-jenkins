package com.ssi.unittest.service;

import com.ssi.unittest.dao.MyDao;

public class MyService {

    private MyDao myDao;

    public void setMyDao(MyDao myDao) {
        this.myDao = myDao;
    }

    public int sum(){
        int sum = 0;
        int[] arr = myDao.getNumbers();
        for(int number: arr){
            sum = sum + number;
        }
        return sum;
    }
}
