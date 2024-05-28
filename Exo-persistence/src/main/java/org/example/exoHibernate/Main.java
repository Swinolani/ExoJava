package org.example.exoHibernate;

import org.example.exoHibernate.entities.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;

public class Main {

        public static void main(String[] args) {

            StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
            SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

            Session session = sessionFactory.openSession();

            // Ajout des 5 produits
            session.getTransaction().begin();
            Produit monProduit1= Produit.builder().proMarque("nike").proReference("ferfrreg").proPrix(25.30).proStock(5).proDate(LocalDate.now()).build();
            Produit monProduit2= Produit.builder().proMarque("nokia").proReference("rtgtrgt").proPrix(30.00).proStock(50).proDate(LocalDate.now()).build();
            Produit monProduit3= Produit.builder().proMarque("pas didé").proReference("ujtujty").proPrix(351.).proStock(25).proDate(LocalDate.now()).build();
            Produit monProduit4= Produit.builder().proMarque("ici non plus").proReference("thh(hy(").proPrix(12.50).proStock(1).proDate(LocalDate.now()).build();
            Produit monProduit5= Produit.builder().proMarque("cest cool").proReference("r(yy(ryrh").proPrix(30.).proStock(10).proDate(LocalDate.now()).build();
            session.save(monProduit1);
            session.save(monProduit2);
            session.save(monProduit3);
            session.save(monProduit4);
            session.save(monProduit5);
            session.getTransaction().commit();

            // infos du produit dont id est egal à 2
            session.getTransaction().begin();
            Produit produitRecup = session.load(Produit.class,2);
            System.out.println(produitRecup.toString());

            // Modification marque du produit dont id est egal à 1
            Produit produitUpdate=session.load(Produit.class,1);
            produitUpdate.setProMarque("MARQUE MODIFIe");
            session.update(produitUpdate);

            Produit produitSuppr=session.load(Produit.class,3);
            session.delete(produitSuppr);


            session.getTransaction().commit();

            session.close();
            sessionFactory.close();
        }

}
