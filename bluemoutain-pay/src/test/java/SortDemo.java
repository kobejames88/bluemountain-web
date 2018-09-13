import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortDemo {
    static int[] bits = new int[] { 1, 2, 3, 4, 5 };

    public static void sort(String prefix, int[] a) {
        if (a.length == 1) {
            System.out.println(prefix + a[0]);
        }

        for (int i = 0; i < a.length; i++) {
            sort(prefix + a[i], copy(a, i));
        }
    }

    public static int[] copy(int[] a,int index){
        int[] b = new int[a.length-1];
        System.arraycopy(a, 0, b, 0, index);
        System.arraycopy(a, index+1, b, index, a.length-index-1);
        return b;
    }

    public List<int []> AddTest(){
        int a;
        int b;
        int c;
        List outLlist = new ArrayList();
        List<Integer> innerList  =new ArrayList<Integer>();
        for(a=0;a<=9;a++)
        {
            for( b=0;b<=9;b++)
            {
                for(c=0;c<=9;c++)
                {
                    int  abc =a*100+b*10+c;
                    int  cba =c*100+b*10+a;//把 abc   cba 连接起来  转成整形  判断
                    if((a*100+b*10+c)+(c*100+b*10+a)==1333){

                        int aa = a;
                        int bb = b;
                        int cc = c;
                        int [] nxy = {aa,bb,cc};
                        outLlist.add(nxy);
                        System.out.println(outLlist);

                    }
                    //打印 abc  cba
                }
            }
        }
        return outLlist;

    }

    public static <T> String getType(T t){
        if(t instanceof String){
            return "string";
        }else if(t instanceof Integer){
            return "int";
        }else if (t instanceof Arrays){
            return " Arrays";
        } else if(t instanceof List){
            return "list";

        }else{
            return "do not down";
        }

    }



    public static void main(String[] args) {
        List l  =new SortDemo().AddTest();

        SortDemo t = new SortDemo();
        for (int i=0;i<l.size();i++){
            int a = ((int [])l.get(i))[0];
            int b = ((int [])l.get(i))[1];
            int c = ((int [])l.get(i))[2];
            System.out.println(a+","+b+","+c);
            int ass[] =  {a,b,c};
            t.sort("paixushi ", ass);

        }



    }

}
