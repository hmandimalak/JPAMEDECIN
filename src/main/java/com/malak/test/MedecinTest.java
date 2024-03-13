package com.malak.test;

import java.util.List;

import com.malak.dao.MedecinDao;
import com.malak.entities.Medecin;

public class MedecinTest {
	    public static void main(String[] args) {
	        // Créer un objet Medecin 1
	        Medecin m1 = new Medecin();
	        m1.setNom("John Doe");
	        m1.setSpecialite("Cardiologue");
	        m1.setFaculte("XYZ");

	        // Créer un objet Medecin 2
	        Medecin m2 = new Medecin();
	        m2.setNom("Jane Smith");
	        m2.setSpecialite("Généraliste");
	        m2.setFaculte("ABC");

	        // Ajouter les deux objets Medecin à la BD
	        MedecinDao medecinDao = new MedecinDao();
	        medecinDao.ajouter(m1);
	        System.out.println("Medecin ajouté avec succès!");

	        medecinDao.ajouter(m2);
	        System.out.println("Second medecin ajouté avec succès!");

	        // Tester la méthode listerTous
	        System.out.println("Appel de la méthode listerTous");
	        List<Medecin> medecins = medecinDao.listerTous();
	        for (Medecin medecin : medecins) {
	            System.out.println(medecin.getId() + " " + medecin.getNom());
	        }

	        // Tester la méthode listerParNom
	        System.out.println("Appel de la méthode listerParNom");
	        List<Medecin> medecinsParNom = medecinDao.listerParNom("John");
	        for (Medecin medecin : medecinsParNom) {
	            System.out.println(medecin);
	        }

	        // Tester la méthode modifier
	        Medecin medecinModifie = medecins.get(0); // Suppose que vous avez au moins un medecin dans la liste
	        medecinModifie.setSpecialite("Chirurgien");
	        medecinDao.modifier(medecinModifie);
	        System.out.println("Medecin modifié avec succès!");

	        // Tester la méthode supprimer
	        Medecin medecinASupprimer = medecins.get(0); // Suppose que vous avez au moins un medecin dans la liste
	        medecinDao.supprimer(medecinASupprimer);
	        System.out.println("Medecin supprimé avec succès!");

	        // Tester la méthode consulter
	        // Par exemple, si vous avez l'ID d'un Medecin
	        Long idMedecin = 1L; // Suppose que 1L est l'ID du premier Medecin dans votre base de données
	        Medecin medecinConsulte = medecinDao.consulter(new Medecin(), idMedecin);
	        System.out.println("Medecin consulté: " + medecinConsulte);
	    }
	}


