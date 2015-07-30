package main.controller;

import main.model.*;
import main.model.Character;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * takes care of saving the game state by using JPA, EclipseLink and H2
 */
public class JPAController {
    public JPAController()
    {
        factory = Persistence.createEntityManagerFactory("my_unit");
        saved = false;
    }

    /**
     * Saves all entity-objects in the game (player, items, objects and characters) into the database
     */
    public void save()
    {
        EntityLists entityLists = EntityLists.getInstance();
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        em.persist(entityLists.getPlayer());

        for (Item item : entityLists.getPlayer().getInventory())
            em.persist(item);

        for (Item item : entityLists.getItemList())
            em.persist(item);

        for (main.model.Object object : entityLists.getObjectList())
            em.persist(object);

        for (main.model.Character character : entityLists.getCharacterList())
            em.persist(character);

        em.getTransaction().commit();

        em.close();
        saved = true;
    }

    /**
     * loads all entitty-objects stored in the database and adds the objects to the various lists in the game
     * @return success of load process
     */
    public boolean load()
    {
        if (!saved) return false;

        EntityLists entityLists = EntityLists.getInstance();
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Query q1 = em.createNativeQuery("select * from Player", Player.class);
        entityLists.setPlayer((Player) q1.getSingleResult());

        Query q2 = em.createNativeQuery( "select * from Item i where i.isInInventory = TRUE", Item.class );
        List<Item> dbInventoryList = q2.getResultList();
        entityLists.getPlayer().setInventory(dbInventoryList);

        Query q3 = em.createNativeQuery( "select * from Item i where i.isInInventory = FALSE", Item.class );
        List<Item> dbItemList = q3.getResultList();
        entityLists.setItemList(dbItemList);

        Query q4 = em.createNativeQuery( "select * from Object", main.model.Object.class );
        List<main.model.Object> dbObjectList = q4.getResultList();
        entityLists.setObjectList(dbObjectList);

        Query q5 = em.createNativeQuery( "select * from Character", Character.class );
        List<Character> dbCharacterList = q5.getResultList();
        entityLists.setCharacterList(dbCharacterList);

        em.getTransaction().commit();

        em.close();

        return true;
    }

    private EntityManagerFactory factory;
    private boolean saved;
}
