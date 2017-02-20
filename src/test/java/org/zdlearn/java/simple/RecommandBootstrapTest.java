package org.zdlearn.java.simple;


import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zdlearn.java.simple.recommand.RInvoker;
import org.zdlearn.java.simple.recommand.RecommandBootstrap;
import org.zdlearn.java.simple.recommand.domain.RContext;
import org.zdlearn.java.simple.recommand.domain.RKnowledge;
import org.zdlearn.java.simple.recommand.engine.REngine;
import org.zdlearn.java.simple.recommand.engine.REnginePool;
import org.zdlearn.java.simple.recommand.filter.RFilter;
import org.zdlearn.java.simple.recommand.filter.RFilterPool;

import java.util.*;

/**
 * <p>项目名称：用户预判</p>
 * <p>包名称：  com.jd.jr.recommand</p>
 * <p>类名称：  RecommandBootstrap的测试类</p>
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
public class RecommandBootstrapTest {

    @Test
    public void testNoConfig(){
        RecommandBootstrap bootstrap=new RecommandBootstrap();
        RContext context=bootstrap.execute(Mockito.anyString(),Mockito.<String, String>anyMap()) ;
        Assert.assertTrue(context==null);
    }

    @Test
    public void testCommandLineEngine(){
        RecommandBootstrap bootstrap=new RecommandBootstrap();
        REnginePool enginePool=new REnginePool();
        enginePool.addInvoker(new REngine() {
            public boolean invoker(RContext rContext) {
                System.out.println("这是一个推荐引擎，其实什么都没做");
                return true;
            }
            public List<RInvoker> getDataCollectorList() {
                return Collections.EMPTY_LIST;
            }
        });
        RFilterPool RFilterPool =new RFilterPool();
        RFilterPool.addInvoker(new RFilter() {
            public boolean invoker(RContext rContext) {
                System.out.println("这是一个简单的拦截器，其实什么都没做");
                return true;
            }
        }) ;
        bootstrap.setREnginePool(enginePool);
        bootstrap.setRFilterPool(RFilterPool);
        RContext context=bootstrap.execute(Mockito.anyString(),Mockito.<String, String>anyMap()) ;
        Assert.assertTrue(context!=null);
    }

    @Test
    public void testAddOneKNoAndNoFilter(){
        RecommandBootstrap bootstrap=new RecommandBootstrap();
        REnginePool enginePool=new REnginePool();
        enginePool.addInvoker(new REngine() {
            public boolean invoker(RContext rContext) {
                rContext.setResultList(getKnowlegeList(1));
                return true;
            }
            public List<RInvoker> getDataCollectorList() {
                return Collections.EMPTY_LIST;
            }
        });
        RFilterPool RFilterPool =new RFilterPool();
        RFilterPool.addInvoker(new RFilter() {
            public boolean invoker(RContext rContext) {
                System.out.println("这是一个简单的拦截器，其实什么都没做");
                return true;
            }
        }) ;
        bootstrap.setREnginePool(enginePool);
        bootstrap.setRFilterPool(RFilterPool);
        RContext context=bootstrap.execute(Mockito.anyString(),Mockito.<String, String>anyMap()) ;
        Assert.assertTrue(context!=null);
        Assert.assertTrue(context.getResultList()!=null);
        Assert.assertTrue(context.getResultList().size()==1);
        Assert.assertTrue(context.getResultList().get(0).getTitle().equals("i=0"));
    }




    @Test
    public void testAddMulKNoAndOneFilter(){
        RecommandBootstrap bootstrap=new RecommandBootstrap();
        REnginePool enginePool=new REnginePool();
        enginePool.addInvoker(new REngine() {
           
            public boolean invoker(RContext rContext) {
                rContext.setResultList(getKnowlegeList(10));
                return true;
            }

            public List<RInvoker> getDataCollectorList() {
                return Collections.EMPTY_LIST;
            }
        });
        RFilterPool RFilterPool =new RFilterPool();
        RFilterPool.addInvoker(new RFilter() {
            public boolean invoker(RContext rContext) {
                List<RKnowledge> rKnowledgeLis=rContext.getResultList();
                Iterator<RKnowledge> iterator=rKnowledgeLis.iterator();
                while(iterator.hasNext()){
                    //遍历处理，如果分数为奇数干掉，为偶数，乘以10
                    RKnowledge rKnowledge=iterator.next();
                    if(rKnowledge.getScore()%2==0){
                        rKnowledge.setScore(rKnowledge.getScore()*10);
                    }else{
                        iterator.remove();;
                    }
                }
                rContext.setResultList(rKnowledgeLis);
                return true;
            }
        }) ;
        bootstrap.setREnginePool(enginePool);
        bootstrap.setRFilterPool(RFilterPool);
        RContext context=bootstrap.execute(Mockito.anyString(),Mockito.<String, String>anyMap()) ;
        Assert.assertTrue(context!=null);
        Assert.assertTrue(context.getResultList()!=null);
        Assert.assertTrue(context.getResultList().size()==5);
        Assert.assertTrue(context.getResultList().get(0).getTitle().equals("i=0"));
    }


    @Test
    public void testAddMulKNoAndOneFilterAndFromData(){
         final String dataCollectionKey="zhangsan";
        RecommandBootstrap bootstrap=new RecommandBootstrap();
        REnginePool enginePool=new REnginePool();
        enginePool.addInvoker(new REngine() {
            public boolean invoker(RContext rContext) {
                //从content取数据，然后生成knowledge
                rContext.setResultList(getKnowlegeList(Integer.valueOf(String.valueOf(rContext.getUserData().get(dataCollectionKey)))));
                return true;
            }

            public List<RInvoker> getDataCollectorList() {
                List<RInvoker> dataCollectorInvokerList=new ArrayList<RInvoker>();
                dataCollectorInvokerList.add(new RInvoker() {
                    public boolean invoker(RContext rContext) {
                        Map<String,Object> userData=new HashMap<String,Object>();
                        System.out.println("假装在这里取了数据");
                        userData.put(dataCollectionKey,12);
                        rContext.setUserData(userData);
                        return true;
                    }
                }) ;
                return dataCollectorInvokerList;
            }
        });
        RFilterPool RFilterPool =new RFilterPool();
        RFilterPool.addInvoker(new RFilter() {
            public boolean invoker(RContext rContext) {
                List<RKnowledge> rKnowledgeLis=rContext.getResultList();
                Iterator<RKnowledge> iterator=rKnowledgeLis.iterator();
                while(iterator.hasNext()){
                    //遍历处理，如果分数为奇数干掉，为偶数，乘以10
                    RKnowledge rKnowledge=iterator.next();
                    if(rKnowledge.getScore()%2==0){
                        rKnowledge.setScore(rKnowledge.getScore()*10);
                    }else{
                        iterator.remove();;
                    }
                }
                rContext.setResultList(rKnowledgeLis);
                return true;
            }
        }) ;
        bootstrap.setREnginePool(enginePool);
        bootstrap.setRFilterPool(RFilterPool);
        RContext context=bootstrap.execute(Mockito.anyString(),Mockito.<String, String>anyMap()) ;
        Assert.assertTrue(context!=null);
        Assert.assertTrue(context.getResultList()!=null);
        Assert.assertTrue(context.getResultList().size()==6);
        Assert.assertTrue(context.getResultList().get(0).getTitle().equals("i=0"));
    }







    private List<RKnowledge> getKnowlegeList(int count){
        List<RKnowledge> knowledgeList=new ArrayList<RKnowledge>();
        for(int i=0;i<count;i++){
            knowledgeList.add(getKnowlege("i="+i,i));
        }
        return knowledgeList;
    }

    private RKnowledge getKnowlege(String title,int score){
        RKnowledge rKnowledge=new RKnowledge();
        rKnowledge.setTitle(title);
        rKnowledge.setScore(score);
        return  rKnowledge;
    }



}
