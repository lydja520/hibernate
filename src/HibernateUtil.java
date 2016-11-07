import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by ydc on 16-11-7.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    //私有的构造方法,防止别人new出来，典型的单例设计模式的引用
    private HibernateUtil() {
    }

    static {
        //若hibernate的配置文件名为hibernate.cfg.xml且文件在classpath下时，configure方法可不带参数
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
