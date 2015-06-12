package main.controller;

import main.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 */
public class JPAController {
    public JPAController()
    {
        factory = null;
        em = null;
        saved = false;
    }

    public void save()
    {
        factory = Persistence.createEntityManagerFactory("my_unit");
        em = factory.createEntityManager();

        /*
        em.getTransaction().begin();
        em.persist(EntityLists.getInstance().getPlayer());
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.persist(EntityLists.getInstance());
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.persist(EntityLists.getInstance().getPlayer().getInventory());
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
        */

        em.close();
        factory.close();
        saved = true;
    }

    public boolean load()
    {
        if (!saved) return false;

        factory = Persistence.createEntityManagerFactory("my_unit");
        em = factory.createEntityManager();

        /*
        Query q1 = em.createNativeQuery("select * from Player", Player.class);
        EntityLists.getInstance().setPlayer((Player) q1.getSingleResult());

        Query q2 = em.createNativeQuery("select * from EntityLists", EntityLists.class);
        EntityLists = q2.getSingleResult();


        Query q = em.createNativeQuery( "select * from Inventory", Inventory.class );
        List<Customer> dbCustomerList = q.getResultList();
        for (Customer c : dbCustomerList)
        {
        }
        */

        em.close();
        factory.close();

        return true;
    }

    private EntityManagerFactory factory;
    private EntityManager em;
    private boolean saved;
}
