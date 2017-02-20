package org.zdlearn.java.simple.recommand.collector;


import org.zdlearn.java.simple.recommand.AbstractInvoker;
import org.zdlearn.java.simple.recommand.RInvoker;
import org.zdlearn.java.simple.recommand.engine.REngine;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>项目名称：用户预判</p>
 * <p>包名称：  com.jd.jr.recommand.collector</p>
 * <p>类名称：  RDataCollectorPool</p>
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
public class RDataCollectorPool extends AbstractInvoker<RInvoker> {
    Set<String> dataCollectionInvokerSet;
    private RDataCollectorPool(){
        //设为私有，避免被调用用
        super();
        this.dataCollectionInvokerSet=new HashSet<String>();
    }

    public static RDataCollectorPool initRDataCollectorPool(Collection<REngine> list){
        RDataCollectorPool rDataCollectorPool=new RDataCollectorPool();
        for(REngine engine:list){
           for(RInvoker invoker:engine.getDataCollectorList()){
               if(rDataCollectorPool.contains(invoker.getClass().getName())){
                   //有就不加了
               }else{
                   rDataCollectorPool.addInvoker(invoker);
                   rDataCollectorPool.addInvokerName(invoker.getClass().getName());
               }
           }
        }
        return rDataCollectorPool;
    }

    public boolean contains(String invokerName){
          return this.dataCollectionInvokerSet.contains(invokerName);
    }

    public void addInvokerName(String invokerName){
        this.dataCollectionInvokerSet.add(invokerName);
    }
}
