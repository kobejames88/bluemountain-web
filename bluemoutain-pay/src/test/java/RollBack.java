import com.bluemoutain.dao.AccountDao;
import com.bluemoutain.dao.UserDao;
import com.bluemoutain.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class RollBack {
    @Autowired
    private  AccountDao accountDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountService accountService;

    @Test
    public Object insertAccount(final String customer, final int money) {
        TransactionTemplate transactionTemplate=new TransactionTemplate();
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);//设置为required传播级别
        Object re= transactionTemplate.execute(new TransactionCallback() {
            public Integer doInTransaction( TransactionStatus status) {
                int i = accountDao.insertAccount(customer, money);
                status.setRollbackOnly();//主动回滚
                return i;
            }
        });
        return re;
    }
    @Test
    public int inertUser(final String username, final String password) {
        TransactionTemplate transactionTemplate=new TransactionTemplate();
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);//设置为required传播级别
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                int i = userDao.inertUser(username, password);
                int hahha = accountService.insertAccount("hahha", 2222);
//                status.setRollbackOnly();
                System.out.println("user==="+i);
                System.out.println("account===="+hahha);
            }
        });
        return 0;
    }
}
