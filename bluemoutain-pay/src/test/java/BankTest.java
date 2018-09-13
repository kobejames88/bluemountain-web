import org.junit.Test;

public class BankTest {
    private int count =0;//账户余额
    //存钱
    @Test
    public  void  addMoney(int money){

        synchronized (this) {
            count +=money;
        }
        System.out.println(System.currentTimeMillis()+"存进："+money);
        ;
    }

    //取钱
    @Test
    public  void  subMoney(int money){

        synchronized (this) {
            if(count-money < 0){
                System.out.println("余额不足");
                return ;
            }
            count -=money;
        }
        System.out.println(+System.currentTimeMillis()+"取出："+money);

    }
@Test
    //查询
    public void lookMoney(){
        System.out.println("账户余额："+count);
    }
}
