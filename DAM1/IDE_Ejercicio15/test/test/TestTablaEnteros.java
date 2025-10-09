package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ejercicio15.TablaEnteros;

class TestTablaEnteros 
{
	@Test 
	void testSumaTabla() 
	{ 
		int [] array = {2,8,1,5}; 
		TablaEnteros miTabla = new TablaEnteros(array);
		assertAll(
				() ->	assertEquals(16, miTabla.sumaTabla()),
				() ->	assertEquals(-15, miTabla.sumaTabla())
		); 
	}
	
	@Test 
	void testMayorTabla() 
	{ 
		int [] array = {2,8,1,5}; 
		TablaEnteros miTabla = new TablaEnteros(array);
		assertAll(
				() ->	assertEquals(8, miTabla.mayorTabla()),
				() ->	assertEquals(5, miTabla.mayorTabla())
		); 
	}
	
	@Test 
	void testPosicionTabla() 
	{ 
		int [] array = {2,8,1,5}; 
		TablaEnteros miTabla = new TablaEnteros(array);
		assertAll(
				() ->	assertEquals(2, miTabla.posicionTabla(1)),
				() ->	assertEquals(0, miTabla.posicionTabla(2)),
				() -> 	assertEquals(5, miTabla.posicionTabla(3))
		); 
	}
}
