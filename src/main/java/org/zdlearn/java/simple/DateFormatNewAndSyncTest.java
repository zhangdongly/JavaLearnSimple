package org.zdlearn.java.simple;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>项目名称：zd</p>
 * <p>包名称：  org.zdlearn.java.simple</p>
 * <p>类名称：  DateFormatNewAndSyncTest</p>
 * <p>类描述：  //类职责详细说明</p>
 * <p>创建人：  wyzhangdong</p>
 * <p>创建日期：2017/1/19 </p>
 * <p>修改人:</p>
 * <p>修改日期</p>
 * <p>修改备注</p>
 * <p>@version V1.0 </p>
 * <p>@author wyzhangdong</p>
 * <p>@see</p>
 */
public class DateFormatNewAndSyncTest {

    private static final SimpleDateFormat DATE_FULL_WITH_NO_LINE_SDF =   new SimpleDateFormat( "yyyyMMdd HH:mm:ss" );

    ExecutorService executors=Executors.newFixedThreadPool(32);

    public synchronized static String getDateStringWithDefaultFormat(Date date){
         return DATE_FULL_WITH_NO_LINE_SDF.format(date);
    }

    public static String getDateStringWithNewFormat(Date date){
        SimpleDateFormat format =   new SimpleDateFormat( "yyyyMMdd HH:mm:ss" );
        return format.format(date);
    }


    @Test
    public void testWithSignleTest(){
        /**
         * 单线程测试，每个接口调用一万次。采用1221的方式。
         */
        Date date=new Date();
       long begin=System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            getDateStringWithDefaultFormat(date);
        }
        long t1=System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            getDateStringWithNewFormat(date);
        }
        long t2=System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            getDateStringWithNewFormat(date);
        }
        long t3=System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            getDateStringWithDefaultFormat(date);
        }
        long t4=System.currentTimeMillis();
        System.out.println("test with signle thread");
        System.out.println("sync cost:"+((t1-begin)+(t4-t3)));
        System.out.println("new cost:"+((t3-t1)));
        System.out.println("all cost:"+(t4-begin));
    }

    @Test
    public void testWith10Thread() throws Exception{
        /**
         * 测试10个线程    每个接口调用一万次。采用1221的方式。
         */
        Date date=new Date();
        final int theads=10;
         long begin=System.currentTimeMillis();
        Future<Long> sync=executors.submit(new RunSyncDateFormat(theads,date));
        Future<Long> newS=executors.submit(new RunNewDateFormat(theads,date));

        System.out.println("test with signle thread");
        System.out.println("sync cost:"+sync.get());
        System.out.println("new cost:"+newS.get());
        System.out.println("all cost:"+(System.currentTimeMillis()-begin));


    }


    @Test
    public void testWith100Thread() throws Exception{
        /**
         * 测试10个线程    每个接口调用一万次。采用1221的方式。
         */
        Date date=new Date();
        final int theads=100;
        long begin=System.currentTimeMillis();
        Future<Long> newS=executors.submit(new RunNewDateFormat(theads,date));
        Future<Long> sync=executors.submit(new RunSyncDateFormat(theads,date));
        System.out.println("test with signle thread");
        System.out.println("sync cost:"+sync.get());
        System.out.println("new cost:"+newS.get());
        System.out.println("all cost:"+(System.currentTimeMillis()-begin));
    }



    public class RunSyncDateFormat implements Callable<Long>{
        private int theads;
        private Date date;
        public RunSyncDateFormat(int theads,Date date){
            this.theads=theads;
            this.date=date;
        }
        public Long call() throws Exception {
            List<Future> list=new ArrayList<Future>();
            for(int i=0;i<theads;i++){
                list.add(executors.submit(new Callable() {
                    public Object call() throws Exception {
                        int count=10000/theads;
                        for(int i=0;i<count;i++){
                            getDateStringWithDefaultFormat(date);
                        }
                        return null;
                    }
                }));
            }
            long begin=System.currentTimeMillis();
            for(int i=0;i<theads;i++){
                list.get(i).get();
            }
            return System.currentTimeMillis()-begin;
        }
    }

    public class RunNewDateFormat implements Callable<Long>{
        private int theads;
        private Date date;
        public RunNewDateFormat(int theads,Date date){
            this.theads=theads;
            this.date=date;
        }
        public Long call() throws Exception {
            List<Future> list=new ArrayList<Future>();
            for(int i=0;i<theads;i++){
                list.add(executors.submit(new Callable() {
                    public Object call() throws Exception {
                        int count=10000/theads;
                        for(int i=0;i<count;i++){
                            getDateStringWithDefaultFormat(date);
                        }
                        return null;
                    }
                }));
            }
            long begin=System.currentTimeMillis();
            for(int i=0;i<theads;i++){
                list.get(i).get();
            }
            return System.currentTimeMillis()-begin;
        }
    }


}
