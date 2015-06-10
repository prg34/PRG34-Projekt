package main.controller;

import main.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 */
public class JPAController {
    public JPAController()
    {
        factory = null;
        em = null;
    }

    public void save()
    {
        factory = Persistence.createEntityManagerFactory("my_unit");
        em = factory.createEntityManager();


        em.getTransaction().begin();
        em.persist(EntityLists.getInstance().getPlayer());
        em.getTransaction().commit();

        em.getTransaction().begin();
        for (Item item : EntityLists.getInstance().getPlayer().getInventory())
            em.persist(item);
        em.getTransaction().commit();

        em.getTransaction().begin();
        for (Item item : EntityLists.getInstance().getItemList())
            em .persist(item);
        em.getTransaction().commit();

        em.getTransaction().begin();
        for (main.model.Object object : EntityLists.getInstance().getObjectList())
            em.persist(object);
        em.getTransaction().commit();

        em.getTransaction().begin();
        for (main.model.Character character : EntityLists.getInstance().getCharacterList())
            em.persist(character);
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.persist(EntityLists.getInstance());
        em.getTransaction().commit();

        //em.close();
    }

    public void load()
    {

    }

    private EntityManagerFactory factory;
    private EntityManager em;
}
