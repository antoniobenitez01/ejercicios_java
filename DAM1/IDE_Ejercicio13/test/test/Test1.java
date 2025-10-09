package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ejercicio13.Fecha;

class Test1 
{
	@Test
	void test() 
	{
		Fecha fecha = new Fecha();
		assertAll
		(
				() -> assertEquals("02/04/2025",fecha.devuelveFecha(1)),
				() -> assertEquals("04/2025",fecha.devuelveFecha(2)),
				() -> assertEquals("miércoles 02-abr-2025, 17:55:55",fecha.devuelveFecha(3)),
				() -> assertEquals("02/04/2025",fecha.devuelveFecha(4))
		);
	}
}
