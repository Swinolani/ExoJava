package org.example.exoHibernate;

import org.example.exoHibernate.entities.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


import java.time.LocalDate;
import java.util.List;

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

            // Suppresion du produit dont l'id est egal à 3
            Produit produitSuppr=session.load(Produit.class,3);
            session.delete(produitSuppr);


            session.getTransaction().commit();

            //Exo 2
            System.out.println("\nEXERCICE 2 QUESTION 1----------------------------- \n");
            // 1.
            session.getTransaction().begin();
            Query queryExo2Q1 = session.createQuery("from Produit ");
            List<Produit> listProduitExo2Q1 = queryExo2Q1.list();
            for (Produit produit : listProduitExo2Q1) {
                System.out.println("\n");
                System.out.println(produit.toString());
            }
            session.getTransaction().commit();

            // 2.
            System.out.println("\nEXERCICE 2 QUESTION 2----------------------------- \n");
            session.getTransaction().begin();
            Query queryExo2Q2 = session.createQuery("from Produit where proprix >26 ");
            List<Produit> listProduitExo2Q2 = queryExo2Q2.list();
            for (Produit produit : listProduitExo2Q2) {
                System.out.println("\n");
                System.out.println(produit.toString());
            }
            session.getTransaction().commit();

            // 3.
            System.out.println("\nEXERCICE 2 QUESTION 3----------------------------- \n");
            session.getTransaction().begin();
            Query queryExo2Q3 = session.createQuery("from Produit where proDate between '2024-05-28' and '2024-05-28'"); //pas le choix pour les dates désolé

            List<Produit> listProduitExo2Q3 = queryExo2Q3.list();
            for (Produit produit : listProduitExo2Q3) {
                System.out.println("\n");
                System.out.println(produit.toString());
            }
            session.getTransaction().commit();
            //---------------------------------------------------------------------------------------

            //Exo 3
            System.out.println("\nEXERCICE 3 QUESTION 1-----------------------------  \n");
            // 1.
            session.getTransaction().begin();
            Query queryExo3Q1 = session.createQuery("from Produit where proDate between :date1 and :date2");
            queryExo3Q1.setParameter("date1", LocalDate.now());
            queryExo3Q1.setParameter("date2", LocalDate.now());
            List<Produit> listProduitExo3Q1 = queryExo3Q1.list();
            for (Produit produit : listProduitExo3Q1) {
                System.out.println("\n");
                System.out.println(produit.toString());
            }
            session.getTransaction().commit();
            System.out.println("\nEXERCICE 3 QUESTION 2-----------------------------  \n");
            // 2.
            session.getTransaction().begin();
            Query queryExo3Q2 = session.createQuery("from Produit where proStock < :seuil");
            queryExo3Q2.setParameter("seuil", 10);

            List<Produit> listProduitExo3Q2 = queryExo3Q2.list();
            for (Produit produit : listProduitExo3Q2) {
                System.out.println("\n");
                System.out.println(produit.getProId() +' '+produit.getProReference());
            }
            session.getTransaction().commit();

            //Exo 4
            System.out.println("\nEXERCICE 4 QUESTION 1-----------------------------  \n");
            // 1.
            session.getTransaction().begin();
            Query queryExo4Q1 = session.createQuery("from Produit where proMarque = :marque");
            queryExo4Q1.setParameter("marque", "nokia");

            List<Produit> listProduitExo4Q1 = queryExo4Q1.list();
            for (Produit produit : listProduitExo4Q1) {
                System.out.println("\n");
                System.out.println(produit.getProStock());
            }
            session.getTransaction().commit();

            System.out.println("\nEXERCICE 4 QUESTION 2-----------------------------  \n");
            // 2.
            session.getTransaction().begin();
            Query queryExo4Q2 = session.createQuery("select avg(proPrix) from Produit");
            queryExo4Q1.setParameter("marque", "nokia");

            double moyenneExo4Q2 = (double) queryExo4Q2.uniqueResult();
            System.out.println("la moyenne des prix vaut : "+moyenneExo4Q2);
            session.getTransaction().commit();

            System.out.println("\nEXERCICE 4 QUESTION 3-----------------------------  \n");
            // 3.
            session.getTransaction().begin();
            Query queryExo4Q3 = session.createQuery("from Produit where proMarque = :marque");
            queryExo4Q3.setParameter("marque", "nokia");

            List<Produit> listProduitExo4Q3 = queryExo4Q3.list();
            for (Produit produit : listProduitExo4Q3) {
                System.out.println("\n");
                System.out.println(produit.toString());
            }
            session.getTransaction().commit();

            System.out.println("\nEXERCICE 4 QUESTION 4-----------------------------  \n");
            // 4.
            session.getTransaction().begin();
            Query queryExo4Q4 = session.createQuery("delete from Produit where proMarque = :marque");
            queryExo4Q4.setParameter("marque", "nokia");

            queryExo4Q4.executeUpdate();
            session.getTransaction().commit();

            session.close();
            sessionFactory.close();
        }

}
