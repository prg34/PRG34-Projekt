package main.controller;

import main.model.*;
import main.model.Character;
import main.model.Object;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

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
        EntityLists entityLists = EntityLists.getInstance();
        factory = Persistence.createEntityManagerFactory("my_unit");
        em = factory.createEntityManager();

        em.getTransaction().begin();

        /*
        em.persist(entityLists.getPlayer());

        for (Item item : entityLists.getPlayer().getInventory())
            em.persist(item);

        for (Item item : entityLists.getItemList())
            em.persist(item);

        for (main.model.Object object : entityLists.getObjectList())
            em.persist(object);

        for (main.model.Character character : entityLists.getCharacterList())
            em.persist(character);
        */

        em.getTransaction().commit();

        em.close();
        factory.close();
        saved = true;
    }

    public boolean load()
    {
        if (!saved) return false;

        EntityLists entityLists = EntityLists.getInstance();
        factory = Persistence.createEntityManagerFactory("my_unit");
        em = factory.createEntityManager();

        em.getTransaction().begin();

        /*
        Query q1 = em.createNativeQuery("select * from Player", Player.class);
        entityLists.setPlayer((Player) q1.getSingleResult());

        Query q2 = em.createNativeQuery( "select * from Item i where i.isInInventory = FALSE", Item.class );
        List<Item> dbInventoryList = q2.getResultList();
        entityLists.getPlayer().setInventory(dbInventoryList);

        Query q3 = em.createNativeQuery( "select * from Item i where i.isInInventory = TRUE", Item.class );
        List<Item> dbItemList = q3.getResultList();
        entityLists.setItemList(dbItemList);

        Query q4 = em.createNativeQuery( "select * from Object", main.model.Object.class );
        List<main.model.Object> dbObjectList = q4.getResultList();
        entityLists.setObjectList(dbObjectList);

        Query q5 = em.createNativeQuery( "select * from Character", Character.class );
        List<Character> dbCharacterList = q5.getResultList();
        entityLists.setCharacterList(dbCharacterList);
        */

        em.getTransaction().commit();

        em.close();
        factory.close();

        return true;
    }

    private EntityManagerFactory factory;
    private EntityManager em;
    private boolean saved;
}
