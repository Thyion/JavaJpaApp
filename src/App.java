import models.Uzytkownik;
import org.hibernate.Transaction;
import org.hibernate.ejb.HibernatePersistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceProperty;
import javax.persistence.spi.PersistenceProvider;
import java.util.HashMap;
import java.util.List;

public class App {

    public static final String SELECT_QUERY = "from Uzytkownik where imie = :imie";

    public static void main(String[] args){

//        String imie = "Krzysztof";
//        String nazwisko = "Kowalik";
//
//        PersistenceProvider persistenceProvider = new HibernatePersistence();
//        EntityManagerFactory entityManagerFactory = persistenceProvider.createEntityManagerFactory("NewPersistenceUnit", new HashMap());
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        List<Uzytkownik> users = entityManager.createQuery(SELECT_QUERY, Uzytkownik.class).setParameter("imie", imie).getResultList();
//        System.out.println(users);
//
//
//        entityManager.close();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Uzytkownik user = new Uzytkownik();


        user.setImie("Tomasz");
        user.setNazwisko("Dumbos");

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
