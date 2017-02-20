package org.zdlearn.java.simple.recommand.domain;

import java.util.List;
import java.util.Map;

/**
 * <p>项目名称：用户预判</p>
 * <p>包名称：  com.jd.jr.recommand.domain</p>
 * <p>类名称：  RContext</p>
 * <p>类描述：  //类职责详细说明</p>
 * <p>创建人：  zhangdong147896325@163.com</p>
 * <p>创建日期：2017/2/20 </p>
 * <p>修改人:</p>
 * <p>修改日期</p>
 * <p>修改备注</p>
 * <p>@version V1.0 </p>
 * <p>@author zhangdong147896325@163.com</p>
 * <p>@see</p>
 */
public class RContext {
    private String jdPin;
    private Map<String,String> inputExtenstion;
    private Map<String,Object> userData;
    private List<RKnowledge> resultList;

    public String getJdPin() {
        return jdPin;
    }

    public void setJdPin(String jdPin) {
        this.jdPin = jdPin;
    }

    public Map<String, String> getInputExtenstion() {
        return inputExtenstion;
    }

    public void setInputExtenstion(Map<String, String> inputExtenstion) {
        this.inputExtenstion = inputExtenstion;
    }

    public Map<String, Object> getUserData() {
        return userData;
    }

    public void setUserData(Map<String, Object> userData) {
        this.userData = userData;
    }

    public List<RKnowledge> getResultList() {
        return resultList;
    }

    public void setResultList(List<RKnowledge> resultList) {
        this.resultList = resultList;
    }

    @Override
    public String toString() {
        return "RContext{" +
                "jdPin='" + jdPin + '\'' +
                ", inputExtenstion=" + inputExtenstion +
                ", userData=" + userData +
                ", resultList=" + resultList +
                '}';
    }
}
