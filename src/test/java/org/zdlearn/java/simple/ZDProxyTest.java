package org.zdlearn.java.simple;

import org.testng.annotations.Test;
import org.zdlearn.java.simple.testclass.StringParamClass;
import org.zdlearn.java.simple.testclass.StringParamClassInterface;

/**
 * Created by wyzhangdong on 2016/12/5.
 */
public class ZDProxyTest {
    @Test
    public static void testInvokeWithInterface(){
        StringParamClassInterface stringParamClass  =  new ZDProxy().bindWithNoImplementation(StringParamClassInterface.class);
        stringParamClass.getNoResultWithParam("abc");
        stringParamClass.getResultWithParam("bcd");
        stringParamClass.getStringResultWithNoParam();
    }

    @Test
    public static void testInvokeWithClass(){
        StringParamClassInterface stringParamClass  =  new ZDProxy().bindWithImplementation(StringParamClass.class);
        stringParamClass.getNoResultWithParam("abc");
        stringParamClass.getResultWithParam("bcd");
        stringParamClass.getStringResultWithNoParam();
    }


}
