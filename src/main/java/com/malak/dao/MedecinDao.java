package com.malak.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.malak.entities.Medecin;
import com.malak.util.JPAutil;


public class MedecinDao {
	private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPAMedecin");

	//méthode ajouter d'une entité à la bd
		public void ajouter(Medecin m) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(m);
			tx.commit();
		}

	//méthode modifier d'une entité à partir de la bd
		public void modifier(Medecin m) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.merge(m);
			tx.commit();
		}

	//méthode Supprimer d'une entité à partir de la bd
		public void supprimer(Medecin m) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			m = entityManager.merge(m); // important
			entityManager.remove(m);
			tx.commit();
		}

	//méthode Consulter d'une entité à partir de la bd
		public Medecin consulter(Medecin m, Object id) {
			return entityManager.find(m.getClass(), id);
		}

	//méthode pour lister tous les objets à partir de la bd
		public List<Medecin> listerTous() {
			List<Medecin> Medecins = entityManager.createQuery("select m from Medecin m").getResultList();

			return Medecins;
		}

	//méthode pour lister tous les Medecin dont le nom contient un
	//texte donné en paramètre (pnom)
		public List<Medecin> listerParNom(String nom) {
			List<Medecin> Medecins = entityManager.createQuery("select m from Medecin m where m.nom like :pnom")
					.setParameter("pnom", "%" + nom + "%").getResultList();

			return Medecins;
		}

}
