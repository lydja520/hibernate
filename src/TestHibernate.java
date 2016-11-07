import bean.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.*;

import java.util.List;

/**
 * Created by ydc on 16-11-7.
 */
public class TestHibernate {

    @Test
    public void getAllUser() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM User";
        List<User> users = session.createQuery(hql).list();

        System.out.println(users);

        transaction.commit();
    }



}
