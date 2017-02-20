package org.zdlearn.java.simple.zoa.domain;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * <p>项目名称：ZOA</p>
 * <p>包名称：  org.zdlearn.java.simple.zoa.domain</p>
 * <p>类名称：  ZOAContext</p>
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
public class ZOAContext implements Serializable {

    /**
     * 接口
     */
    public String interfaceName;
    /**
     * 方法名
     */
    public String methodName;
    /**
     * 执行结果
     */
    public String resultCode;

    /**
     * 请求参数
     */
    Object[] params;

    /**
     * 返回结果类型
     */
    Type resultType;

    Object result ;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Type getResultType() {
        return resultType;
    }

    public void setResultType(Type resultType) {
        this.resultType = resultType;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
