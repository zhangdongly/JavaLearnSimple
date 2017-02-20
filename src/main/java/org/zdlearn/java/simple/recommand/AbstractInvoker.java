package org.zdlearn.java.simple.recommand;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zdlearn.java.simple.recommand.domain.RContext;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>项目名称：用户预判</p>
 * <p>包名称：  com.jd.jr.recommand</p>
 * <p>类名称：  AbstractInvoker</p>
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
public abstract class AbstractInvoker<T extends RInvoker> implements RInvoker {

    Logger logger= LoggerFactory.getLogger(this.getClass().getName());

   protected Collection<T> invokerList;

    protected AbstractInvoker(){
        //默认是ArrayList
        invokerList=new ArrayList<T>();
    }

    public AbstractInvoker addInvoker(T r){
        invokerList.add(r);
        return this;
    }

    public boolean invoker(RContext rContext) {
        boolean resultFalg=true;
        for(RInvoker engine:invokerList){
            if(engine.invoker(rContext)){
                continue;
            }else{
                logger.info(engine.getClass().getName()+"执行失败");
                resultFalg=false;
                break;
            }
        }
        return resultFalg;
    }
}
