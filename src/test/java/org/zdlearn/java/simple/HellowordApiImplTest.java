package org.zdlearn.java.simple;

import org.testng.annotations.Test;
import org.zdlearn.java.simple.zoa.api.HellowordApiImpl;

/**
 * <p>项目名称：</p>
 * <p>包名称：  org.zdlearn.java.simple</p>
 * <p>类名称：  HellowordApiImplTest</p>
 * <p>类描述：  //类职责详细说明</p>
 * <p>创建人：  wyzhangdong</p>
 * <p>创建日期：2016/12/29 </p>
 * <p>修改人:</p>
 * <p>修改日期</p>
 * <p>修改备注</p>
 * <p>@version V1.0 </p>
 * <p>@author wyzhangdong</p>
 * <p>@see</p>
 */
public class HellowordApiImplTest {

    @Test
    public void test(){
        new HellowordApiImpl().helloWord("aaaa");
    }
}
