package org.zdlearn.java.simple.zoa.provider;

/**
 * <p>项目名称：ZOA</p>
 * <p>包名称：  org.zdlearn.java.simple.zoa.provider</p>
 * <p>类名称：  Provider</p>
 * <p>类描述：  一个服务提供者对象</p>
 * <p>创建人：  zhangdong147896325@163.com</p>
 * <p>创建日期：2016/12/29 </p>
 * <p>修改人:</p>
 * <p>修改日期</p>
 * <p>修改备注</p>
 * <p>@version V1.0 </p>
 * <p>@author zhangdong147896325@163.com</p>
 * <p>@see</p>
 */
public class Provider {

    public Provider(){}
    public Provider(String className,Object ref){
        this.className=className;
        this.ref=ref;
    }
    /**
     * 提供者名称（API接口全类名）
     */
    private String className;

    /**
     * 服务提供者实体类
     */
    private Object ref;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Object getRef() {
        return ref;
    }

    public void setRef(Object ref) {
        this.ref = ref;
    }
}
