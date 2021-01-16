import org.hibernate.Session;
import util.HibernateUtils;

public class CinemaDatabaseApplication {
    public static void main(String[] args) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        session.createQuery("FROM Client").getResultList().forEach(System.out::println);


    }

}
