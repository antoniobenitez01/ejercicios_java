package clasePersona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner entradaTeclado = new Scanner(System.in);
		Profesor profesor1 = new Profesor();
		Alumno alumno1 = new Alumno();
		boolean fechaCorrecta = false;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Introduzca el DNI del Profesor 1.");
		profesor1.setDNI(entradaTeclado.nextLine());
		
		System.out.println("Introduzca el nombre completo del Profesor 1.");
		profesor1.setName(entradaTeclado.nextLine());
		
		System.out.println("Introduzca la edad del Profesor 1.");
		profesor1.setEdad(entradaTeclado.nextInt());
		entradaTeclado.nextLine(); //Depuración Scanner
		
		do
		{
			try
			{
				System.out.println("Introduzca la fecha de nacimiento del Profesor 1 (YYYY-MM-DD).");
				profesor1.setFechaNac(LocalDate.parse(entradaTeclado.nextLine()));
				fechaCorrecta = true;
			}catch(DateTimeParseException excepcion1)
			{
				System.out.println("Fecha introducida incorrecta, asegurése de seguir el formato indicado.");
			}
		}while(fechaCorrecta == false);
		
		System.out.println("Introduzca el departamento del Profesor 1");
		profesor1.setDepartamento(entradaTeclado.nextLine());
		
		System.out.printf("\nDATOS - PROFESOR 1" + "\n------------------------------" +
						"\nDNI: " + profesor1.getDNI() +
						"\nNombre: " + profesor1.getName() +
						"\nEdad: " + profesor1.getEdad() +
						"\nFecha nacimiento: " + profesor1.getFechaNac().format(formato) +
						"\nDepartamento: " + profesor1.getDepartamento());
		
		System.out.println("\n"+"\nIntroduzca el DNI del Alumno 1.");
		alumno1.setDNI(entradaTeclado.nextLine());
		
		System.out.println("Introduzca el nombre completo del Alumno 1.");
		alumno1.setName(entradaTeclado.nextLine());
		
		System.out.println("Introduzca la edad del Alumno 1.");
		alumno1.setEdad(entradaTeclado.nextInt());
		entradaTeclado.nextLine(); //Depuración Scanner
		
		fechaCorrecta = false; //Reiniciamos valor booleano
		do
		{
			try
			{
				System.out.println("Introduzca la fecha de nacimiento del Alumno 1 (YYYY-MM-DD).");
				alumno1.setFechaNac(LocalDate.parse(entradaTeclado.nextLine()));
				fechaCorrecta = true;
			}catch(DateTimeParseException excepcion1)
			{
				System.out.println("Fecha introducida incorrecta, asegurése de seguir el formato indicado.");
			}
		}while(fechaCorrecta == false);
		
		System.out.println("Introduzca el curso del Alumno 1");
		alumno1.setCurso(entradaTeclado.nextLine());
		
		fechaCorrecta = false; //Reiniciamos valor booleano
		do
		{
			try
			{
				System.out.println("Introduzca la fecha de matriculación del Alumno 1 (YYYY-MM-DD).");
				alumno1.setFechaMat(LocalDate.parse(entradaTeclado.nextLine()));
				fechaCorrecta = true;
			}catch(DateTimeParseException excepcion1)
			{
				System.out.println("Fecha introducida incorrecta, asegurése de seguir el formato indicado.");
			}
		}while(fechaCorrecta == false);
		
		System.out.printf("\nDATOS - ALUMNO 1" + "\n------------------------------" +
				"\nDNI: " + alumno1.getDNI() +
				"\nNombre: " + alumno1.getName() +
				"\nEdad: " + alumno1.getEdad() +
				"\nFecha nacimiento: " + alumno1.getFechaNac().format(formato) +
				"\nCurso: " + alumno1.getCurso() +
				"\nFecha matriculación: " + alumno1.getFechaMat().format(formato));		
	}
}
