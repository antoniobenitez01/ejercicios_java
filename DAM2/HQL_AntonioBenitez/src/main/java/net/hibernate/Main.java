package net.hibernate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.hibernate.dao.CancionDAO;
import net.hibernate.dao.CantanteDAO;
import net.hibernate.entity.Cancion;
import net.hibernate.entity.Cantante;
import net.hibernate.util.HibernateUtil;

public class Main 
{
	public static void main(String[] args) 
	{
		// ---	CREACIÓN CONTACTOS
		System.out.println("\u001B[32m\n=== CARDINALIDAD EN HIBERNATE ===\n");
		
		System.out.println("\u001B[36m--- Creando Cantantes ...\n\u001B[37m");
		List<Cantante> objetosCantante = Arrays.asList(
				new Cantante("Freddie Mercury","Inglaterra"),
				new Cantante("Michael Jackson","Estados Unidos"),
				new Cantante("Elton John","Inglaterra"),
				new Cantante("Prince","Estados Unidos"),
				new Cantante("Amy Winehouse","Inglaterra"));
		objetosCantante.forEach(cantante -> System.out.println(cantante));
		
		System.out.println("\u001B[36m\n--- Creando Canciones ...\n\u001B[37m");
		List<Cancion> objetosCancion = Arrays.asList(
				new Cancion("Bohemian Rhapsody",1975,objetosCantante.get(0)),
				new Cancion("Remember the Time",1991,objetosCantante.get(1)),
				new Cancion("I'm Still Standing",1983,objetosCantante.get(2)),
				new Cancion("Purple Rain",1984,objetosCantante.get(3)),
				new Cancion("Back to Black",2006,objetosCantante.get(4)));
		objetosCancion.forEach(cancion -> System.out.println(cancion));
		
		// ---	INSERTAR CONTACTOS EN BASE DE DATOS
		System.out.println("\u001B[36m\n--- Insertando Cantantes en BBDD ...\n\u001B[33m");
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			for(Cantante cantante : objetosCantante) {
				session.persist(cantante);
			}
			for(Cancion cancion : objetosCancion) {
				session.persist(cancion);
			}
			transaction.commit();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		}
	}
}
