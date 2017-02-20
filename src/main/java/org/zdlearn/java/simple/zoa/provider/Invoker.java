package org.zdlearn.java.simple.zoa.provider;

import org.zdlearn.java.simple.zoa.domain.ZOAContext;

/**
 * <p>项目名称：ZOA</p>
 * <p>包名称：  org.zdlearn.java.simple.zoa.provider</p>
 * <p>类名称：  Invoker</p>
 * <p>类描述：  //服务的实名执行器</p>
 * <p>创建人：  zhangdong147896325@163.com</p>
 * <p>创建日期：2016/12/29 </p>
 * <p>修改人:</p>
 * <p>修改日期</p>
 * <p>修改备注</p>
 * <p>@version V1.0 </p>
 * <p>@author zhangdong147896325@163.com</p>
 * <p>@see</p>
 */
public interface Invoker {
    public void invoker(ZOAContext context);
}
