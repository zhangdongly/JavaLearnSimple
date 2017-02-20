package org.zdlearn.java.simple.recommand;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zdlearn.java.simple.recommand.domain.RContext;
import org.zdlearn.java.simple.recommand.engine.REnginePool;
import org.zdlearn.java.simple.recommand.filter.RFilterPool;

import java.util.Map;

/**
 * <p>项目名称：用户预判</p>
 * <p>包名称：  com.jd.jr.recommand</p>
 * <p>类名称：  RecommandBootstrap</p>
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
public class RecommandBootstrap {

    Logger logger= LoggerFactory.getLogger(this.getClass().getName());

    REnginePool rEnginePool;
    RFilterPool RFilterPool;

    //执行推荐过程
    public RContext execute(String jdPin, Map<String, String> extension) {
        if(rEnginePool==null|| RFilterPool ==null){
          logger.error("预判模块初始化失败，请确认是否配置OK");
            return null;
        }
        RContext context=initData(jdPin,extension);
        if(rEnginePool.invoker(context)){
            RFilterPool.invoker(context);
        }
        return context;
    }

    public RContext initData(String jdPin, Map<String, String> extension) {
        //准备数据
        RContext context=new RContext();
        context.setJdPin(jdPin);
        context.setInputExtenstion(extension);
        return context;
    }

    public RecommandBootstrap setREnginePool(REnginePool pool){
        this.rEnginePool=pool;
        return this;
    }

    public RecommandBootstrap setRFilterPool(RFilterPool pool){
        this.RFilterPool =pool;
        return this;
    }
}


