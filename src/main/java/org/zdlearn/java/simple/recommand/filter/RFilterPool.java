package org.zdlearn.java.simple.recommand.filter;


import org.zdlearn.java.simple.recommand.AbstractInvoker;

/**
 * <p>项目名称：用户预判</p>
 * <p>包名称：  com.jd.jr.recommand.filter</p>
 * <p>类名称：  RFilterPool</p>
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
public class RFilterPool extends AbstractInvoker<RFilter> {

    public RFilterPool(){
        super();
        addDefaultFilter();
    }

    private void addDefaultFilter(){
          //在这里增加默认的拦截器
    }
}
