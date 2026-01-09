package net.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.hibernate.entity.Usuario;
import net.hibernate.util.HibernateUtil;

public class UsuarioDAO 
{
	//SELECT CONTACTO - Devuelve todos los Contactos registrados en la BBDD
	public static List<Usuario> selectContacto() {
		List<Usuario> usuarios = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			usuarios = session.createQuery("from Usuario",Usuario.class).list();
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		}
		return usuarios;
	}
	
	//UPDATE CONTACTO - Inserta o Actualiza el Contacto introducido por parámetro en la BBDD
	public static void updateContacto(Usuario usuario) 
	{
		if(usuario != null) {
			Transaction transaction = null;
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				session.merge(usuario);
				transaction.commit();
			}catch(Exception e ) {
				if(transaction != null) {
					transaction.rollback();
				}
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("ERROR: Usuario introducido = NULL");
		}
	}
	
	//DELETE CONTACTO - Borra el Contacto introducido por parámetro de la BBDD
	public static void deleteContacto(Usuario usuario) 
	{
		if(usuario != null) {
			Transaction transaction = null;
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				session.remove(usuario);
				System.out.println("Usuario eliminado correctamente.");
				transaction.commit();
			}catch(Exception e ) {
				if(transaction != null) {
					transaction.rollback();
				}
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("ERROR: Usuario introducido = NULL");
		}
	}
}
