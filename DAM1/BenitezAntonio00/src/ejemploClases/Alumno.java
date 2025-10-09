
package ejemploClases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que representa un <strong>Alumno</strong>.
 * <p>Los objetos de esta clase contienen atributos que permiten almacenar información sobre:</p>
 * <ul>
 * <li><strong>dni:</strong> DNI del Alumno en formato String</li>
 * <li><strong>nombre:</strong> Nombre del Alumno en formato String</li>
 * <li><strong>apellidos:</strong> Apellidos del Alumno en formato String</li>
 * <li><strong>fechaNacimiento:</strong> Fecha de Nacimiento del Alumno en formato LocalDate</li>
 * <li><strong>peso:</strong> Peso del Alumno representado por un valor decimal double</li>
 * <li><strong>altura:</strong> Altura del Alumno representada por un valor decimal double</li>
 * <li><strong>numeroHermanos:</strong> Número de hermanos del Alumno representado por un valor entero</li>
 * <li><strong>horaMaximaAlumno:</strong> Hora máxima del Alumno en formato LocalTime</li>
 * <li><strong>mayorEdad:</strong> Boolean donde true significa que el Alumno es mayor de edad</li>
 * </ul>
 * <p>La clase también dispone de información general independiente de los objetos concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>numeroMinGrupo:</strong> Número mínimo de los grupos de clase</li>
 * <li><strong>numeroAlumnos:</strong> Número total de alumnos</li>
 * </ul>
 * 
 * @author Antonio Benítez Rodríguez
 */
public class Alumno 
{
//ATRIBUTOS ===========================================================================
	
	/**
	 * Número máximo de alumnos dentro del centro :
	 * {@value NUMERO_MAXIMO_ALUMNOS} alumnos.
	 */
	public final static int NUMERO_MAXIMO_ALUMNOS = 1000;
	/**
	 * Hora máxima del centro 
	 * LocalTime de 22:00.
	 */
	public final static LocalTime HORA_MAXIMA_GENERAL = LocalTime.of(22, 00);
	/**
	 * Número máximo de alumnos dentro de un grupo :
	 * {@value NUMERO_MAX_GRUPO} alumnos.
	 */
	public final static int NUMERO_MAX_GRUPO = 35;
	/**
	 * Hora máxima por defecto de un alumno 
	 * LocalTime de 21:30.
	 */
	public final static LocalTime HORA_MAXIMA_ALUMNO_DEFAULT = LocalTime.of(21, 30);
	/**
	 * Valor por defect de peso de un alumno :
	 * {@value PESO_ALUMNO_DEFAULT} Kgs.
	 */
	public final static double PESO_ALUMNO_DEFAULT = 60.50;
	/**
	 * Valor por defecto de altura de un alumno :
	 * {@value ALTURA_ALUMNO_DEFAULT} metros.
	 */
	public final static double ALTURA_ALUMNO_DEFAULT = 1.65;
	/**
	 * Número por defect de hermanos por alumno :
	 * {@value NUMERO_HERMANOS_DEFAULT} hermanos.
	 */
	public final static int NUMERO_HERMANOS_DEFAULT = 0;
	private static int numeroMinGrupo = 5;
	private static int numeroAlumnos;
	
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private double peso;
	private double altura;
	private int numeroHermanos;
	private LocalTime horaMaximaAlumno;
	private boolean mayorEdad;
	
//INICIALIZACIÓN ===========================================================================
	
	static //Inicialización de clase
	{
		System.out.println("Inicializando clase Alumno...");
	}
	//Inicialización por instancia
	{
		System.out.println("Inicializando instancia...");
	}
	
//CONSTRUCTORES ===========================================================================
	
	/**
	 * Constructor maestro (todos los parámetros)
	 *
	 * @param dni DNI del alumno en formato String
	 * @param nombre Nombre del alumno en formato String
	 * @param apellidos Apellidos del alumno en formato String
	 * @param fechaNacimiento Fecha de nacimiento del alumno en formato LocalDate
	 * @param peso Peso del alumno dictado por un valor decimal
	 * @param altura Altura del alumno dictada por un valor decimal
	 * @param numeroHermanos Número de hermanos de un alumno dictado por un valor entero
	 * @param mayorEdad Boolean donde true significa que el alumno es mayor de edad
	 * @param horaMaximaAlumno Hora máxima del alumno en formato LocalTime
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido
	 */
	public Alumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, double peso, 
			double altura, int numeroHermanos, boolean mayorEdad, LocalTime horaMaximaAlumno) throws IllegalArgumentException
	{
		//COMPROBACIÓN DE EXCEPCIONES
		if(dni == null || dni.isEmpty()) // EXCEPCIÓN - String de dni no debe estar vacío o ser nulo
		{
			throw new IllegalArgumentException ("DNI null o vacío");
		}
		if(!checkDNI(dni)) // EXCEPCIÓN - dni debe seguir el formato correctamente
		{
			throw new IllegalArgumentException ("El DNI introducido no sigue el formato estándar.");
		}
		if(nombre == null || nombre.isEmpty()) // EXCEPCIÓN - String de nombre no debe estar vacío o ser nulo
		{
			throw new IllegalArgumentException ("Nombre null o vacío.");
		}
		if(apellidos == null || apellidos.isEmpty()) // EXCEPCIÓN - String de apellidos no debe estar vacío o ser nulo
		{
			throw new IllegalArgumentException ("Apellidos null o vacío.");
		}
		if(fechaNacimiento == null) // EXCEPCIÓN - LocalDate de fechaNacimiento no debe ser nulo
		{
			throw new IllegalArgumentException ("Fecha de Nacimiento null.");
		}
		if(peso < 0) // EXCEPCIÓN - Peso no puede ser un valor negativo
		{
			throw new IllegalArgumentException ("Peso no puede ser negativo.");
		}
		if(altura < 0) // EXCEPCIÓN - Altura no puede ser un valor negativo
		{
			throw new IllegalArgumentException ("Altura no puede ser negativa.");
		}
		if(numeroHermanos < 0) // EXCEPCIÓN - Número de hermanos no puede ser negativo
		{
			throw new IllegalArgumentException ("Número de hermanos no puede ser negativo.");
		}
		if((!mayorEdadCheck(fechaNacimiento) && mayorEdad == true) || (mayorEdadCheck(fechaNacimiento) && mayorEdad == false))
		{
			throw new IllegalArgumentException ("Fecha de nacimiento no concuerda con mayorEdad");
		}
		if(horaMaximaAlumno == null) // EXCEPCIÓN - LocalTime de horaMaximaAlumno no debe ser nulo
		{
			throw new IllegalArgumentException ("Hora Máxima de Alumno null.");
		}
		
		//CONSTRUCCIÓN DE OBJETO
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.peso = peso;
		this.altura = altura;
		this.numeroHermanos = numeroHermanos;
		this.mayorEdad = mayorEdad;
		this.horaMaximaAlumno = horaMaximaAlumno;
		
		//ACUMULACIÓN VARIABLES STATIC
		Alumno.numeroAlumnos++;
	}
	
	/**
	 * Constructor 4 parámetros
	 *
	 * @param dni DNI del alumno en formato String
	 * @param nombre Nombre del alumno en formato String
	 * @param apellidos Apellidos del alumno en formato String
	 * @param fechaNacimiento Fecha de nacimiento del alumno en formato LocalDate
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido
	 */
	public Alumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento)
	{
		this(dni, nombre, apellidos, fechaNacimiento, Alumno.PESO_ALUMNO_DEFAULT, Alumno.ALTURA_ALUMNO_DEFAULT, 
				Alumno.NUMERO_HERMANOS_DEFAULT, mayorEdadCheck(fechaNacimiento), Alumno.HORA_MAXIMA_ALUMNO_DEFAULT);
	}
	
	/**
	 * Constructor de copia de objeto
	 *
	 * @param a Objeto Alumno a copiar
	 */
	public Alumno(Alumno a)
	{
		this(a.dni, a.nombre, a.apellidos, a.fechaNacimiento, a.peso, a.altura, a.numeroHermanos, a.mayorEdad, a.horaMaximaAlumno);
	}
	/**
	 * Pseudoconstructor Alumnos de Ejemplo
	 * @return Alumno[] Array de Alumnos de Ejemplo
	 */
	public static Alumno[] crearArrayAlumnosEjemplo()
	{
		return new Alumno[] 
		{
			new Alumno("26267841R", "Antonio", "Benítez Rodríguez", LocalDate.of(2001, 12, 28), 87.56, 1.87, 1, true, LocalTime.of(21,30)),
			new Alumno("26267841R", "Marta", "Ramírez Pedrosa", LocalDate.of(2008, 05, 04), 56.75, 1.46, 0, false, LocalTime.of(15,00)),
			new Alumno("26267841R", "Javier", "Jiménez Bodega", LocalDate.of(1999, 10, 19), 76.56, 2.10, 2, true, LocalTime.of(21,30)),
			new Alumno("26267841R", "Francisco", "Burjos Bedolla", LocalDate.of(2009, 03, 07), 67.87, 1.93, 3, false, LocalTime.of(15,00)),
			new Alumno("26267841R", "Lucía", "García Del Olmo", LocalDate.of(1997, 06, 15), 98.65, 1.65, 4, true, LocalTime.of(21,30))
		};
	}
	
//GETTERS ===========================================================================
	
	/**
	 * Devuelve el objeto String del atributo dni
	 * @return String dni
	 */
	public String getDni()
	{
		return this.dni;
	}
	/**
	 * Devuelve el objeto String del atributo nombre
	 * @return String nombre
	 */
	public String getNombre()
	{
		return this.nombre;
	}
	/**
	 * Devuelve el objeto String del atributo apellidos
	 * @return String apellidos
	 */
	public String getApellidos()
	{
		return this.apellidos;
	}
	/**
	 * Devuelve el objeto LocalDate del atributo fechaNacimiento
	 * @return LocalDate fechaNacimiento
	 */
	public LocalDate getFechaNacimiento()
	{
		return this.fechaNacimiento;
	}
	/**
	 * Devuelve el valor decimal double del atributo peso
	 * @return double peso
	 */
	public double getPeso()
	{
		return this.peso;
	}
	/**
	 * Devuelve el valor decimal double del atributo altura
	 * @return double altura
	 */
	public double getAltura()
	{
		return this.altura;
	}
	/**
	 * Devuelve el valor entero del atributo numeroHermanos
	 * @return int numeroHermanos
	 */
	public int getNumeroHermanos()
	{
		return this.numeroHermanos;
	}
	/**
	 * Devuelve el valor booleano del atributo mayorEdad
	 * @return boolean mayorEdad
	 */
	public boolean getMayorEdad()
	{
		return this.mayorEdad;
	}
	/**
	 * Devuelve el objeto LocalTime del atributo horaMaximaAlumno
	 * @return LocalTime horaMaximaAlumno
	 */
	public LocalTime getHoraMaximaAlumno()
	{
		return this.horaMaximaAlumno;
	}
	
//SETTERS ===========================================================================
	
	/**
	 * Establece el valor del atributo dni
	 *
	 * @param dni DNI del Alumno en formato String
	 * @throws IllegalArgumentException Si el DNI está mal escrito
	 * o el objeto String es null o vacío
	 */
	public void setDni(String dni) throws IllegalArgumentException
	{
		if(dni == null || dni.isEmpty()) // EXCEPCIÓN - String de dni no debe estar vacío o ser nulo
		{
			throw new IllegalArgumentException ("DNI null o vacío");
		}
		if(!checkDNI(dni)) // EXCEPCIÓN - dni debe seguir el formato correctamente
		{
			throw new IllegalArgumentException ("El DNI introducido no sigue el formato estándar.");
		}
		this.dni = dni;
	}
	/**
	 * Establece el valor del atributo nombre
	 *
	 * @param nombre Nombre del Alumno en formato String
	 * @throws IllegalArgumentException Si el objeto String esta vacío o es nulo
	 */
	public void setNombre(String nombre) throws IllegalArgumentException
	{
		if(nombre == null || nombre.isEmpty()) // EXCEPCIÓN - String de nombre no debe estar vacío o ser nulo
		{
			throw new IllegalArgumentException ("Nombre null o vacío.");
		}
		this.nombre = nombre;
	}
	/**
	 * Establece el valor del atributo apellidos
	 *
	 * @param apellidos Apellidos del Alumno en formato String
	 * @throws IllegalArgumentException Si el objeto String esta vacío o es nulo
	 */
	public void setApellidos(String apellidos) throws IllegalArgumentException
	{
		if(apellidos == null || apellidos.isEmpty()) // EXCEPCIÓN - String de apellidos no debe estar vacío o ser nulo
		{
			throw new IllegalArgumentException ("Apellidos null o vacío.");
		}
		this.apellidos = apellidos;
	}
	/**
	 * Establece el valor del atributo fechaNacimiento
	 *
	 * @param fechaNacimiento Fecha de nacimiento del Alumno en formato LocalDate
	 * @throws IllegalArgumentException Si el objeto LocalDate es nulo o
	 * no coincide con el atributo mayorEdad
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) throws IllegalArgumentException
	{
		if(fechaNacimiento == null) // EXCEPCIÓN - LocalDate de fechaNacimiento no debe ser nulo
		{
			throw new IllegalArgumentException ("Fecha de Nacimiento null.");
		}
		if((!mayorEdadCheck(fechaNacimiento) && mayorEdad == true) || (mayorEdadCheck(fechaNacimiento) && mayorEdad == false))
		{
			throw new IllegalArgumentException ("Fecha de nacimiento no concuerda con mayorEdad");
		}
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * Establece el valor del atributo peso
	 *
	 * @param peso Peso del Alumno dictado por un valor decimal
	 * @throws IllegalArgumentException Si el peso es un valor negativo
	 */
	public void setPeso(double peso) throws IllegalArgumentException
	{
		if(peso < 0) // EXCEPCIÓN - Peso no puede ser un valor negativo
		{
			throw new IllegalArgumentException ("Peso no puede ser negativo.");
		}
		this.peso = peso;
	}
	/**
	 * Establece el valor del atributo altura
	 *
	 * @param altura Altura del Alumno dictado por un valor decimal
	 * @throws IllegalArgumentException Si la altura es un valor negativo
	 */
	public void setAltura(double altura) throws IllegalArgumentException
	{
		if(altura < 0) // EXCEPCIÓN - Altura no puede ser un valor negativo
		{
			throw new IllegalArgumentException ("Altura no puede ser negativa.");
		}
		this.altura = altura;
	}
	/**
	 * Establece el valor del atributo numeroHermanos
	 *
	 * @param numeroHermanos Número de hermanos del Alumnos dictado por un valor entero
	 * @throws IllegalArgumentException Si el valor de numeroHermanos es un valor negativo
	 */
	public void setNumeroHermanos(int numeroHermanos)
	{
		if(numeroHermanos < 0)
		{
			throw new IllegalArgumentException ("Número de hermanos no puede ser negativo.");
		}
		this.numeroHermanos = numeroHermanos;
	}
	/**
	 * Establece el valor del atributo mayorEdad
	 *
	 * @param mayorEdad Boolean donde true significa que el alumno es mayor de edad
	 * @throws IllegalArgumentException Si el valor booleano mayorEdad no concuerda con el objeto LocalDate fechaNacimiento
	 */
	public void setMayorEdad(boolean mayorEdad)
	{
		if((!mayorEdadCheck(fechaNacimiento) && mayorEdad == true) || (mayorEdadCheck(fechaNacimiento) && mayorEdad == false))
		{
			throw new IllegalArgumentException ("Fecha de nacimiento no concuerda con mayorEdad");
		}
		this.mayorEdad = mayorEdad;
	}
	/**
	 * Establece el valor del atributo horaMaximaAlumno
	 *
	 * @param horaMaximaAlumno Hora máxima del alumno en formato LocalTime
	 */	
	public void setHoraMaximaAlumno(LocalTime horaMaximaAlumno)
	{
		this.horaMaximaAlumno = horaMaximaAlumno;
	}
	
//MÉTODOS ===========================================================================
	
	/**
	 * Comprueba si un DNI está bien escrito
	 * @param dni DNI del alumno en formato String
	 * @return Valor booleano
	 */
	private static boolean checkDNI(String dni)
	{
		boolean dniCorrect = false;
		Pattern patronDni = Pattern.compile("[0-9]{8}[A-Za-z]"); //Expresión regular de DNI estándar
		Matcher dniMatch = patronDni.matcher(dni); //Objeto Matcher del patrón DNI
		if(dniMatch.matches())
		{
			dniCorrect = true;
		}
		else
		{
			dniCorrect = false;
		}
		return dniCorrect;
	}
	
	/**
	 * Devuelve true si la Fecha de Nacimiento introducida corresponde a una persona mayor de edad
	 * @param fechaNacimiento Fecha de nacimiento del alumno en formato LocalDate
	 * @return Valor booleano
	 */
	private static boolean mayorEdadCheck(LocalDate fechaNacimiento)
	{
		boolean esMayorEdad = false;
		LocalDate fechaHoy = LocalDate.now();
		Period period = Period.between( fechaNacimiento, fechaHoy);
		if(period.getYears() >= 18)
		{
			esMayorEdad = true;
		}
		else
		{
			esMayorEdad = false;
		}
		return esMayorEdad;
	}
	
	/**
	 * Devuelve un objeto String que representa la información
	 * detallada del Alumno
	 * <p><strong>El formato de salida</strong> será del siguiente tipo: </p>
	 * <p>DNI: {Valor del atributo dni}<br>
	 * Nombre: {Valor del atributo nombre}<br>
	 * Apellidos: {Valor del atributo apellidos}<br>
	 * Fecha de Nacimiento: {Valor del atributo fechaNacimiento}<br>
	 * Peso: {Valor del atributo peso}<br>
	 * Altura: {Valor del atributo altura}<br>
	 * Número de Hermanos: {Valor del atributo numeroHermanos}<br>
	 * Mayor de Edad: {Valor del atributo mayorEdad}<br>
	 * Hora Máxima Alumno: {Valor del atributo horaMaximaAlumno}</p>
	 * @return Cadena que represeta la información del Alumno.
	 */
	public String toString() 
	{
		return String.format("DNI: %s \nNombre: %s "
				+ "\nApellidos: %s "
				+ "\nFecha de Nacimiento: %s "
				+ "\nPeso: %.2f \nAltura: %.2f "
				+ "\nNúmero de Hermanos: %d"
				+ "\nMayor de Edad: %b"
				+ "\nHora Máxima Alumno: %s",
				this.dni, this.nombre, this.apellidos, this.fechaNacimiento.toString(), this.peso, this.altura, this.numeroHermanos, this.mayorEdad, this.horaMaximaAlumno.toString());
	}
}
