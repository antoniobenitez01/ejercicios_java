package net.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
		
		System.out.println("\u001B[32m\n=== CONSULTAS HQL CANCIONES ===\n");
		
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
				new Cancion("Crazy Little Thing Called Love",1979,objetosCantante.get(0)),
				new Cancion("The Show Must Go On",1991,objetosCantante.get(0)),
				new Cancion("Remember the Time",1991,objetosCantante.get(1)),
				new Cancion("Man in the Mirror",1987,objetosCantante.get(1)),
				new Cancion("Thriller",1982,objetosCantante.get(1)),
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
		
		// ---	VARIABLES
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		List<Cantante> cantantes;
		List<Cancion> canciones;
		
		// --- PROGRAMA
		
		System.out.println("\u001B[32m\n--- Consultas HQL ---\n");
		
		// 1. Todas las canciones de un cantante
		System.out.println("\u001B[36m1. Todas las CANCIONES de un CANTANTE\n\u001B[37m");
		String hql1 = "FROM Cancion c WHERE c.cantante.id = :cantanteId";
		
		System.out.println("Mostrando canciones de FREDDY MERCURY ...\u001B[33m");
		Query<Cancion> queryCancion = session.createQuery(hql1,Cancion.class);
		queryCancion.setParameter("cantanteId", 1);
		canciones = queryCancion.getResultList();
		if(canciones.isEmpty()) {
			System.out.println("\u001B[37mERROR: Lista de CANCIONES vacía.");
		}else {
			for(Cancion cancion : canciones) {	
				System.out.println("\u001B[37m" +cancion);
			}
		}
		
		System.out.println("\nMostrando canciones de MICHAEL JACKSON ...\u001B[33m");
		queryCancion = session.createQuery(hql1,Cancion.class);
		queryCancion.setParameter("cantanteId", 2);
		canciones = queryCancion.getResultList();
		if(canciones.isEmpty()) {
			System.out.println("\u001B[37mERROR: Lista de CANCIONES vacía.");
		}else {
			for(Cancion cancion : canciones) {	
				System.out.println("\u001B[37m" +cancion);
			}
		}
		
		// 2. Buscar canciones que tengan un titulo
		System.out.println("\n\u001B[36m2. Buscar CANCIONES por TÍTULO (exacto)\n\u001B[37m");
		String hql2 = "FROM Cancion c WHERE c.titulo = :titulo";
		
		System.out.println("Mostrando canciones de nombre 'Remember the Time' ...\u001B[33m");
		queryCancion = session.createQuery(hql2,Cancion.class);
		queryCancion.setParameter("titulo", "Remember the Time");
		canciones = queryCancion.getResultList();
		if(canciones.isEmpty()) {
			System.out.println("\u001B[37mERROR: Lista de CANCIONES vacía.");
		}else {
			for(Cancion cancion : canciones) {	
				System.out.println("\u001B[37m" +cancion);
			}
		}
		
		System.out.println("\nMostrando canciones de nombre 'dark rain' ...\u001B[33m");
		queryCancion = session.createQuery(hql2,Cancion.class);
		queryCancion.setParameter("titulo", "dark rain");
		canciones = queryCancion.getResultList();
		if(canciones.isEmpty()) {
			System.out.println("\u001B[37mERROR: Lista de CANCIONES vacía.");
		}else {
			for(Cancion cancion : canciones) {	
				System.out.println("\u001B[37m" +cancion);
			}
		}
		
		//3. contar cuantas Canciones contienen una palabra en el titulo. Ej "Navidad", nos mostrarías cuantas canciones contienen esa palabra
		System.out.println("\n\u001B[36m3. Lista de CANCIONES que contienen una palabra\n\u001B[37m");
		String hql3 = "FROM Cancion c WHERE c.titulo LIKE :palabra";
		
		System.out.println("Mostrando canciones con la palabra 'Time' en el título ...\u001B[33m");
		queryCancion = session.createQuery(hql3,Cancion.class);
		queryCancion.setParameter("palabra","%Time%");
		canciones = queryCancion.getResultList();
		if(canciones.isEmpty()) {
			System.out.println("\u001B[37mERROR: Lista de CANCIONES vacía.");
		}else {
			for(Cancion cancion : canciones) {	
				System.out.println("\u001B[37m" + cancion);
			}
		}
		
		System.out.println("\nMostrando canciones con la palabra 'Black' en el título ...\u001B[33m");
		queryCancion = session.createQuery(hql3,Cancion.class);
		queryCancion.setParameter("palabra","%Black%");
		canciones = queryCancion.getResultList();
		if(canciones.isEmpty()) {
			System.out.println("\u001B[37mERROR: Lista de CANCIONES vacía.");
		}else {
			for(Cancion cancion : canciones) {	
				System.out.println("\u001B[37m" + cancion);
			}
		}
		
		//4. Lista de cantantes con el nº de canciones que tienen
		System.out.println("\n\u001B[36m4. Lista de CANTANTES con el Nº de CANCIONES que tienen\n\u001B[33m");
		Query<Cantante>queryCantante = session.createQuery("FROM Cantante",Cantante.class);
		cantantes = queryCantante.getResultList();
		if(cantantes.isEmpty()) {
			System.out.println("\u001B[37mERROR: Lista de CANTANTES vacía.");
		}else {
			for(Cantante cantante : cantantes) {
				queryCancion = session.createQuery(hql1,Cancion.class);
				queryCancion.setParameter("cantanteId", cantante.getId());
				canciones = queryCancion.getResultList();
				System.out.printf("\u001B[37m%s - Número de canciones: %d\n\u001B[33m",cantante.getNombre(),canciones.size());
			}
		}
		
		//5. lista de canciones entre dos fechas (años), con el nombre del cantante
		System.out.println("\n\u001B[36m5. Lista de CANCIONES entre dos fechas\n\u001B[37m");
		String hql5 = "FROM Cancion c WHERE c.anyo > :anyo1 AND c.anyo < :anyo2";
		
		System.out.println("Mostrando canciones entre 1980 y 1990 ...\u001B[33m");
		queryCancion = session.createQuery(hql5,Cancion.class);
		queryCancion.setParameter("anyo1",1980);
		queryCancion.setParameter("anyo2",1990);
		canciones = queryCancion.getResultList();
		if(canciones.isEmpty()) {
			System.out.println("\u001B[37mERROR: Lista de CANCIONES vacía.");
		}else {
			for(Cancion cancion : canciones) {	
				System.out.println("\u001B[37m" + cancion);
			}
		}
		
		System.out.println("\nMostrando canciones entre 1999 y 2010 ...\u001B[33m");
		queryCancion = session.createQuery(hql5,Cancion.class);
		queryCancion.setParameter("anyo1",1999);
		queryCancion.setParameter("anyo2",2010);
		canciones = queryCancion.getResultList();
		if(canciones.isEmpty()) {
			System.out.println("\u001B[37mERROR: Lista de CANCIONES vacía.");
		}else {
			for(Cancion cancion : canciones) {	
				System.out.println("\u001B[37m" + cancion);
			}
		}
	}
}
