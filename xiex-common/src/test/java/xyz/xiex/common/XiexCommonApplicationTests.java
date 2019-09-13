package xyz.xiex.common;


import org.junit.Test;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class XiexCommonApplicationTests {


    @Test
    public void contextLoads() {
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i=0;i<1000000;i++){
            arrayList.add(i);
        }
        long currentTimeMillis = System.currentTimeMillis();
        IntSummaryStatistics intSummaryStatistics = arrayList.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println( "使用stream进行累加计算消耗的时间："+(System.currentTimeMillis()-currentTimeMillis)+",和为"+intSummaryStatistics.getSum());
        Integer sum=0;
        long currentTimeMillis2 = System.currentTimeMillis();
        for (Integer integer : arrayList) {
            sum+=integer;
        }
        System.out.println( "使用for进行累加计算消耗的时间："+(System.currentTimeMillis()-currentTimeMillis2)+",和为"+sum);

        long currentTimeMillis3 = System.currentTimeMillis();
        IntSummaryStatistics intSummaryStatistics1 = arrayList.parallelStream().mapToInt((x) -> x).summaryStatistics();
        System.out.println( "使用stream进行累加计算消耗的时间："+(System.currentTimeMillis()-currentTimeMillis3)+",和为"+intSummaryStatistics1.getSum());


    }

}

