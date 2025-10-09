package claseTicket;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

public class Ticket 
{
	private static final int MAXIMA_CADENA = 99999999;
	
	private static int ultimoAnyo = LocalDate.now().getYear();
	private static int ultimaCadena;
	
	private String id;
	private LocalDate fechaTicket;
	private LocalTime horaUtilizado;
	
	public Ticket(LocalDate fecha)
	{
		LocalDate fechaHoy = LocalDate.now();
		if(fecha == null)
		{
			throw new IllegalArgumentException ("La fecha no puede ser null.");
		}
		if(fecha.isBefore(fechaHoy))
		{
			throw new IllegalArgumentException ("La fecha no puede ser anterior a la fecha actual.");
		}
		if(fecha.getYear() > fechaHoy.getYear())
		{
			throw new IllegalArgumentException ("Año posterior al año actual.");
		}
		if(Ticket.ultimaCadena == Ticket.MAXIMA_CADENA)
		{
			throw new IllegalArgumentException ("No se pueden crear más tickets este año.");
		}
		
		this.horaUtilizado = null;
		this.fechaTicket = fecha;
		
		if(Ticket.ultimoAnyo != fechaHoy.getYear())
		{
			Ticket.ultimaCadena = 0;
			Ticket.ultimoAnyo = fechaHoy.getYear();
		}
		
		this.id = String.format("%04d-%08d", fechaHoy.getYear(), Ticket.ultimaCadena++);
	}
	
	public Ticket()
	{
		this(LocalDate.now());
	}
	
	public static Ticket randomEsteMes()
	{
		LocalDate hoy = LocalDate.now();
		LocalDate fechaRandom = hoy.plusDays((int) (Math.random() * (hoy.lengthOfMonth() - hoy.getDayOfMonth() + 1)));
		Ticket ticket = new Ticket(fechaRandom);
		return ticket;
	}
	
	public static Ticket random()
	{
		LocalDate hoy = LocalDate.now();
		int ultimoDia = 365 + (hoy.isLeapYear() ? 1 : 0);
		LocalDate fechaRandom = hoy.plusDays((int) (Math.random() * (ultimoDia - hoy.getDayOfYear() + 1)));
		Ticket ticket = new Ticket(fechaRandom);
		return ticket;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public LocalDate getFecha()
	{
		return this.fechaTicket;
	}
	
	private boolean usado()
	{
		return this.horaUtilizado != null;
	}
	
	public boolean esFinDeSemana()
	{
		boolean esFinDe = false;
		if(this.fechaTicket.getDayOfWeek() == DayOfWeek.SATURDAY || this.fechaTicket.getDayOfWeek() == DayOfWeek.SUNDAY)
		{
			esFinDe = true;
		}
		return esFinDe;
	}
	
	public void usar()
	{
		if(this.usado())
		{
			throw new IllegalStateException ("Ticket ya ha sido utilizado.");
		}
		if(!this.fechaTicket.isEqual(LocalDate.now()))
		{
			throw new IllegalStateException (String.format("No se puede usar el ticket en esta fecha."
											+ "\nEl ticket solo se puede usar el día: %02d-%02d-%d", 
											fechaTicket.getDayOfMonth(), fechaTicket.getMonthValue(), fechaTicket.getYear()));
		}
		this.horaUtilizado = LocalTime.now();
	}
	
	public String toString()
	{
		return String.format("ID: %s, Fecha: %02d/%02d/%d, Usado: %s",
							this.id, this.fechaTicket.getDayOfMonth(), this.fechaTicket.getMonthValue(), this.fechaTicket.getYear(),
							this.horaUtilizado == null ? "no" : String.format ("%02d:%02d", horaUtilizado.getHour(), horaUtilizado.getMinute()));
	}
}
