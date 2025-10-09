/*
 * Clase Main donde hacemos uso de las clases creadas
 * Personal, Profesor y PAS para utilizar sus
 * constructores y métodos.
 * Excepciones: IllegalArgumentException, NullPointerException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 17/02/2025
 */
package ejercicio3;

import java.time.LocalDate;

public class Colegio 
{

	public static void main(String[] args) 
	{
		//PERSONAL =============================================================================
		
		Personal personal1 = null, personal2 = null;
		
		System.out.println("\n================= PERSONAL =================\n");
		try
		{
			System.out.println("Creando objeto Personal con DNI vacío...");
			personal1 = new Personal("", "Antonio", "Benítez Rodríguez", LocalDate.of(2001, 12, 28), "Hombre",
					2000, 603216305, "abenrod@g.educaand.es");
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException ex) {
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			System.out.println("\nCreando objeto Personal con fecha de nacimiento nula...");
			personal1 = new Personal("26267841R", "Antonio", "Benítez Rodríguez", null, "Hombre",
					2000, 603216305, "abenrod@g.educaand.es");
			System.out.println("Creado con éxito.");
		}catch(NullPointerException ex) {
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			System.out.println("\nCreando objeto Personal con telefono negativo...");
			personal1 = new Personal("26267841R", "Antonio", "Benítez Rodríguez", LocalDate.of(2001, 12, 28), "Hombre",
					2000, -500, "abenrod@g.educaand.es");
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException ex) {
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			System.out.println("\nCreando objeto Personal con salario negativo...");
			personal1 = new Personal("26267841R", "Antonio", "Benítez Rodríguez", LocalDate.of(2001, 12, 28), "Hombre",
					-500, 603216305, "abenrod@g.educaand.es");
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException ex) {
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			System.out.println("\nCreando objeto Personal con datos correctos...");
			personal1 = new Personal("26267841R", "Antonio", "Benítez Rodríguez", LocalDate.of(2001, 12, 28), "Hombre",
					2000, 603216305, "abenrod@g.educaand.es");
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException ex) {
			System.out.printf("%s\n", ex.getMessage());
		}
		
		System.out.println("\nCreando objeto Personal con datos por omisión...");
		personal2 = new Personal();
		
		System.out.println("\n	-- MÉTODOS --\n");
		
		System.out.printf("PERSONAL 1:\n%s\n", personal1.toString());
		System.out.printf("\nPERSONAL 2:\n%s\n", personal2.toString());
		
		System.out.println("\nAumentando salario de personal 1 un 50%...");
		personal1.aumentoSalario(50);
		System.out.printf("\nPERSONAL 1:\n%s\n", personal1.toString());
		
		try
		{
			System.out.println("\nAumentando salario de personal 1 un -50%...");
			personal1.aumentoSalario(-50);
			System.out.printf("\nPERSONAL 1:\n%s\n", personal1.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		//PROFESOR ====================================================================================
		Profesor profesor1 = null, profesor2 = null;
		
		System.out.println("\n================= PROFESOR =================\n");
		
		try
		{
			System.out.println("Creando objeto Profesor con DNI vacío...");
			profesor1 = new Profesor("", "Antonio", "Benítez Rodríguez", LocalDate.of(2001, 12, 28), "Hombre",
					2000, 603216305, "abenrod@g.educaand.es", "Profesorado", "Matemáticas", "Artes", false, 2);
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException ex) {
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			System.out.println("\nCreando objeto Profesor con Titulación vacía...");
			profesor1 = new Profesor("26267841R", "Antonio", "Benítez Rodríguez", LocalDate.of(2001, 12, 28), "Hombre",
					2000, 603216305, "abenrod@g.educaand.es", "", "Matemáticas", "Artes", false, 2);
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException ex) {
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			System.out.println("\nCreando objeto Profesor con años de experiencia vacío...");
			profesor1 = new Profesor("26267841R", "Antonio", "Benítez Rodríguez", LocalDate.of(2001, 12, 28), "Hombre",
					2000, 603216305, "abenrod@g.educaand.es", "Profesorado", "Matemáticas", "Artes", false, -50);
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException ex) {
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			System.out.println("\nCreando objeto Profesor con datos correctos...");
			profesor1 = new Profesor("26267841R", "Antonio", "Benítez Rodríguez", LocalDate.of(2001, 12, 28), "Hombre",
					2000, 603216305, "abenrod@g.educaand.es", "Profesorado", "Matemáticas", "Artes", false, 2);
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException ex) {
			System.out.printf("%s\n", ex.getMessage());
		}
		
		System.out.println("\nCreando objeto Profesor con datos por omisión...");
		profesor2 = new Profesor();
		
		System.out.println("\n	-- MÉTODOS --\n");
		
		System.out.printf("PROFESOR 1:\n%s\n", profesor1.toString());
		System.out.printf("\nPROFESOR 2:\n%s\n", profesor2.toString());
		
		System.out.println("\nAumentando salario de profesor 1...");
		profesor1.aumentoSalario();
		System.out.printf("\nPROFESOR 1:\n%s\n", profesor1.toString());
		
		System.out.println("\nCalculando años de jubilación de profesor 1...");
		try
		{
			System.out.printf("PROFESOR 1 - Años hasta jubilación: %d años.\n", profesor1.anyosJubilacion());
		}catch(IllegalStateException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		//PROFESOR ====================================================================================
		PAS pas1 = null, pas2 = null;
		
		System.out.println("\n================= PAS =================\n");
		
		try
		{
			System.out.println("Creando objeto PAS con DNI vacío...");
			pas1 = new PAS("", "Antonio", "Benítez Rodríguez", LocalDate.of(2001, 12, 28), "Hombre",
					2000, 603216305, "abenrod@g.educaand.es", false, false, true, "Inglés");
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException ex) {
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			System.out.println("Creando objeto PAS con Área de atención vacío...");
			pas1 = new PAS("26267841R", "Antonio", "Benítez Rodríguez", LocalDate.of(2001, 12, 28), "Hombre",
					2000, 603216305, "abenrod@g.educaand.es", false, false, true, "");
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException ex) {
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			System.out.println("\nCreando objeto PAS con datos correctos...");
			pas1 = new PAS("26267841R", "Antonio", "Benítez Rodríguez", LocalDate.of(2001, 12, 28), "Hombre",
					2000, 603216305, "abenrod@g.educaand.es", false, false, true, "Inglés");
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException ex) {
			System.out.printf("%s\n", ex.getMessage());
		}
		
		System.out.println("\nCreando objeto PAS con datos por omisión...");
		pas2 = new PAS();
		
		System.out.println("\n	-- MÉTODOS --\n");
		
		System.out.printf("PAS 1:\n%s\n", pas1.toString());
		System.out.printf("\nPAS 2:\n%s\n", pas2.toString());
		
		System.out.println("\nAumentando salario de PAS 1 un 50%...");
		pas1.aumentoSalario(50);
		System.out.printf("\nPAS 1:\n%s\n", pas1.toString());
		
		try
		{
			System.out.println("\nAumentando salario de PAS 1 un -50%...");
			pas1.aumentoSalario(-50);
			System.out.printf("\nPROFESOR 1:\n%s\n", pas1.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		System.out.println("\nCalculando número de idiomas...");
		System.out.printf("PAS 1 - Número de idiomas: %d\n", pas1.numIdiomas());
		
		try
		{
			System.out.println("\nCambiando idioma inválido...");
			pas1.cambioIdioma("Español");
			System.out.printf("\nPAS 1:\n%s\n", pas1.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			System.out.println("\nCambiando idioma válido...");
			pas1.cambioIdioma("Inglés");
			System.out.printf("PAS 1:\n%s\n", pas1.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
	}
}
