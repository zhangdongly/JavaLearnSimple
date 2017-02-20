package org.zdlearn.java.simple.zoa.api;

/**
 * <p>项目名称：ZOA</p>
 * <p>包名称：  org.zdlearn.java.simple.zoa.domain.provider</p>
 * <p>类名称：  HellowordApiImpl</p>
 * <p>类描述：  //类职责详细说明</p>
 * <p>创建人：  zhangdong147896325@163.com</p>
 * <p>创建日期：2016/12/28 </p>
 * <p>修改人:</p>
 * <p>修改日期</p>
 * <p>修改备注</p>
 * <p>@version V1.0 </p>
 * <p>@author zhangdong147896325@163.com</p>
 * <p>@see</p>
 */
public class HellowordApiImpl implements HellowordApi {

    public String helloWord(String request) {
        return "Hello word "+request;
    }
}
