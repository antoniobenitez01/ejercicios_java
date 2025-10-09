package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ejercicio14.Factorial;

class TestFactorial 
{
	@DisplayName("Test de Factoriales")
	@Test
	void testVarios() 
	{
		assertAll("Prueba de multiples cosas",
				() -> assertEquals(24, Factorial.calculo(4)),
				() -> assertEquals(6, Factorial.calculo(3)),
				() -> assertEquals(24, Factorial.calculo(6)),
				() -> assertEquals(24, Factorial.calculo(3)),
				() -> assertEquals(24, Factorial.calculo(500)));
	}
}
