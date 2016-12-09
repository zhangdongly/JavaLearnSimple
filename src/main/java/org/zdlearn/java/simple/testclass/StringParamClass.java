package org.zdlearn.java.simple.testclass;

/**
 * Created by wyzhangdong on 2016/12/5.
 */
public class StringParamClass implements StringParamClassInterface{



    public String getStringResultWithNoParam(){
        return "abc" ;
    }

    public void getNoResultWithParam(String abc){
        System.out.println(abc);
    }
    public String getResultWithParam(String abc){
        System.out.println(abc);
        return abc;
    }
}
