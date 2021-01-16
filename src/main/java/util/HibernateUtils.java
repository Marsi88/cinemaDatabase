package util;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                configuration.addAnnotatedClass(TicketCategory.class);
                configuration.addAnnotatedClass(Ticket.class);
                configuration.addAnnotatedClass(Reservation.class);
                configuration.addAnnotatedClass(Seat.class);
                configuration.addAnnotatedClass(Room.class);
                configuration.addAnnotatedClass(Movie.class);
                configuration.addAnnotatedClass(Schedule.class);
                configuration.addAnnotatedClass(Client.class);

                // add classes used to map database tables
                ServiceRegistry serviceRegistry = new
                        StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory =
                        configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }


}
