package ejemploHerencia;

public class Main {

	public static void main(String[] args) 
	{
		
		Programador programador1 = new Programador();
		System.out.println("\n" + programador1.toString());
		
		Analista analista1 = new Analista();
		System.out.println("\n" + analista1.toString());
		
		Ingeniero ingeniero1 = new Ingeniero();
		System.out.println("\n" + ingeniero1.toString());
		
		System.out.printf("\nNúmero de trabajadores en total: %d \n", Trabajador.getNumeroTrabajadores());
		
		//======================================
		
		System.out.printf("\nProgramador 1 - Nómina: %.2f" +
						"\nAnalista 1 - Nómina: %.2f" +
						"\nIngeniero 1 - Nómina: %.2f",
						programador1.calcularNomina(Trabajador.SALARIO_BASE_DEFAULT),
						analista1.calcularNomina(Trabajador.SALARIO_BASE_DEFAULT), ingeniero1.calcularNomina(Trabajador.SALARIO_BASE_DEFAULT));
		
		System.out.printf("\n\nProgramador 1 - Días vacaciones: %d" +
				"\nAnalista 1 - Días vacaciones: %d" +
				"\nIngeniero 1 - Días vacaciones: %d\n",
				programador1.calcularVacaciones(), analista1.calcularVacaciones(), ingeniero1.calcularVacaciones());
		
		// ===================================== 
		
		System.out.println("\n === POLIMORFISMO ===");
		Trabajador trabajador;
		
		trabajador = new Programador();
		System.out.printf("\nTrabajador (Programador) - Días vacaciones: %d",trabajador.calcularVacaciones());
		
		trabajador = new Analista();
		System.out.printf("\nTrabajador (Analista) - Días vacaciones: %d",trabajador.calcularVacaciones());
		
		trabajador = new Ingeniero();
		System.out.printf("\nTrabajador (Ingeniero) - Días vacaciones: %d\n",trabajador.calcularVacaciones());
		
		// ======================================
		
		System.out.println("\n === INSTANCE OF ===\n");
		Trabajador[] empresa = new Trabajador[10];
		
		empresa[0] = new Programador();
		empresa[1] = new Analista();
		empresa[2] = new Ingeniero();
		
		for(int i = 0; i<empresa.length && empresa[i] != null; i++)
		{
			if(empresa[i] instanceof Analista)
			{
				System.out.printf("Trabajador %d es un Analista\n", i+1);
			}
			else if(empresa[i] instanceof Ingeniero)
			{
				System.out.printf("Trabajador %d es un Ingeniero\n", i+1);
			}
			else
			{
				System.out.printf("Trabajador %d es un Programador\n", i+1);
			}
		}
	}
}
