package org.zdlearn.java.simple.recommand;/**
 * 软件版权：zhangdong147896325@163.com
 * 系统名称：ai-demo
 * 文件名称：RInvoker
 * 版本变更记录（可选）：修改日期2017/2/20 10:02，修改人zhangdong147896325@163.com，工单号（手填），
 * 修改描述（手填）
 */


import org.zdlearn.java.simple.recommand.domain.RContext;

/**
 * <p>项目名称：用户预判</p>
 * <p>包名称：  com.jd.jr.recommand</p>
 * <p>接口名称: RInvoker</p>
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
public interface RInvoker {

    public boolean invoker(RContext rContext);
}
