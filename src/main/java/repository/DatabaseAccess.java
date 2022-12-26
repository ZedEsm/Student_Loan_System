package repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseAccess {
    public static EntityManagerFactory getEntityManager() {
        return Persistence.createEntityManagerFactory("stuloan");
    }
}

