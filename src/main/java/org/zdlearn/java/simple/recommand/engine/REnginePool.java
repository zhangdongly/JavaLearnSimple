package org.zdlearn.java.simple.recommand.engine;


import org.zdlearn.java.simple.recommand.AbstractInvoker;
import org.zdlearn.java.simple.recommand.collector.RDataCollectorPool;
import org.zdlearn.java.simple.recommand.domain.RContext;

/**
 * <p>项目名称：用户预判</p>
 * <p>包名称：  com.jd.jr.recommand.engine</p>
 * <p>类名称：  REnginePool</p>
 * <p>类描述：  引擎池和执行器</p>
 * <p>创建人：  zhangdong147896325@163.com</p>
 * <p>创建日期：2017/2/20 </p>
 * <p>修改人:</p>
 * <p>修改日期</p>
 * <p>修改备注</p>
 * <p>@version V1.0 </p>
 * <p>@author zhangdong147896325@163.com</p>
 * <p>@see</p>
 */
public class REnginePool extends AbstractInvoker<REngine> {

    /**
     * 数据收集器池。因为要收集多少数据由引擎的属性决定，所以把他放在这里
     */
    RDataCollectorPool rDataCollectorPool;

    public REnginePool(){
        super();
    }

    @Override
    public boolean invoker(RContext rContext){
        if(rDataCollectorPool==null){
            rDataCollectorPool=RDataCollectorPool.initRDataCollectorPool(invokerList)  ;
        }
        //先收集数据
       if(rDataCollectorPool.invoker(rContext)){
          //收集数据Ok，执行
          return super.invoker(rContext);
       }
       return false;
    }



}
