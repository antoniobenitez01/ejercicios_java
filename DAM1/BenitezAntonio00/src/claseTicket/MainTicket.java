package claseTicket;

import java.time.LocalDate;

public class MainTicket {

	public static void main(String[] args) 
	{
		Ticket[] coleccionTickets = new Ticket[10];
		for(int i=0; i<7; i++)
		{
			coleccionTickets[i] = new Ticket();
		}
		
		coleccionTickets[7] = new Ticket(LocalDate.of(2025, 06, 28));
		coleccionTickets[8] = Ticket.random();
		coleccionTickets[9] = Ticket.randomEsteMes();
		
		System.out.println("\n=== TICKETS DISPONIBLES ===\n");
		for(int i=0; i<coleccionTickets.length; i++)
		{
			if(coleccionTickets[i] != null)
			{
				System.out.printf("%s\n",coleccionTickets[i].toString());
			}
		}
		
		System.out.println("\n=== MÉTODOS ===\n");
		System.out.printf("Utilizando método finDeSemana en Ticket Random (%s) ...\n", coleccionTickets[8].getId());
		if(coleccionTickets[8].esFinDeSemana())
		{
			System.out.println("El Ticket Random se ha creado en un fin de semana.");
		}
		else
		{
			System.out.println("El Ticket Random no se ha creado en un fin de semana.");
		}
		
		System.out.printf("\nUsando Ticket por omisión (%s) ...\n", coleccionTickets[0].getId());
		try
		{
			coleccionTickets[0].usar();
		}catch(IllegalStateException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		System.out.printf("%s\n",coleccionTickets[0].toString());
		
		System.out.printf("\nUsando Ticket por omisión (%s) otra vez ...\n", coleccionTickets[0].getId());
		try
		{
			coleccionTickets[0].usar();
		}catch(IllegalStateException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		System.out.printf("%s\n",coleccionTickets[0].toString());
		
		System.out.printf("\nUsando Ticket Random (%s)...\n", coleccionTickets[8].getId());
		try
		{
			coleccionTickets[8].usar();
		}catch(IllegalStateException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
	}
}
