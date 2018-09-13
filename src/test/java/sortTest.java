import org.junit.Test;

import java.util.*;

public class sortTest {
    @Test
    public void test(){
        int[] num = {1,-2,3,10,-4,7,2,-5};
        //int[] num = {1,-2,3,10,-4,10,2,-5};
        System.out.println(maxSum(num));
    }
    public int maxSum(int[] num){ int curSum = 0; int curMaxSum = -99999999; int start = 0; int end = 0; for(int i=0;i<num.length;i++){ if(curSum<=0){
        curSum = num[i];
        start = i;
    } else{
        curSum += num[i];
    } if(curSum>curMaxSum){
        curMaxSum = curSum;
        end = i;
    }
    } for(int i = start;i<=end;i++){
        System.out.println(num[i]);
    } return curMaxSum;
    }
    @Test
    public void mapTest(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        map.put("d", "ddd");
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println("map.get(" + key + ") is :" + map.get(key));

        }
        System.out.println("-------------------");
        HashTableTest();
        System.out.println("-------------------");
        TreeMap();
    }
    public String HashTableTest(){
        Hashtable<String, String> tab = new Hashtable<String, String>();
        tab.put("a", "aaa");
        tab.put("b", "bbb");
        tab.put("c", "ccc");
        tab.put("d", "ddd");
        Iterator<String> iterator_1 = tab.keySet().iterator();
        while (iterator_1.hasNext()) {
            Object key = iterator_1.next();
            System.out.println("tab.get(" + key + ") is :" + tab.get(key));

        }
        return "-------------------";

    }
    public String  TreeMap() {
        TreeMap<String, String> tmp = new TreeMap<String, String>();
        tmp.put("a", "aaa");
        tmp.put("b", "bbb");
        tmp.put("c", "ccc");
        tmp.put("d", "ddd");
        Iterator<String> iterator_2 = tmp.keySet().iterator();
        while (iterator_2.hasNext()) {
            Object key = iterator_2.next();
            System.out.println("tmp.get(" + key + ") is :" + tmp.get(key));
        }
        return "-----------------------";
    }
}
