package empresaDeSoftware;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class testEmpresa {

	@Test
	public void queSePuedaAgregarEmpleado() {
		Empleado empleado1 = new Empleado(13456789, 001, "John Connor", 50000.0, 2000);

		Empresa microsoft = new Empresa("Microsoft");

		microsoft.contratarEmpleado(empleado1);

		assertTrue(microsoft.getEmpleados().contains(empleado1));
	}

	@Test
	public void queNoSePuedaAgregarUnEmpleado() {
		Empleado empleado1 = new Empleado(13456789, 001, "John Connor", 50000.0, 2000);
		Empleado empleado2 = new Empleado(13456789, 001, "Don Draper", 100000.0, 2000);

		Empresa microsoft = new Empresa("Microsoft");

		microsoft.contratarEmpleado(empleado1);
		microsoft.contratarEmpleado(empleado2);

		int cantEmpleados = 1;
		Assert.assertEquals(cantEmpleados, microsoft.getEmpleados().size(), 0.01);

	}

	@Test
	public void queSePuedaDarDeBajaEmpleados() {
		Empleado empleado1 = new Empleado(10456789, 001, "John Connor", 50000.0, 2000);
		Empleado empleado2 = new Gerente(13456711, 002, "Don Draper", 100000.0, 2000);
		Empleado empleado3 = new Empleado(12456730, 003, "Diana Prince", 80000.0, 2000);
		Empleado empleado4 = new Empleado(13456789, 004, "Peggy Olson", 73000.0, 2000);

		Empresa microsoft = new Empresa("Microsoft");

		microsoft.contratarEmpleado(empleado1);
		microsoft.contratarEmpleado(empleado2);
		microsoft.contratarEmpleado(empleado3);
		microsoft.contratarEmpleado(empleado4);

		microsoft.darDeBajaAEmpleado(13456789);
		microsoft.darDeBajaAEmpleado(13456711);

		int empleadosRestantes = 2;
		Assert.assertEquals(empleadosRestantes, microsoft.getEmpleados().size());
	}

	@Test
	public void calculoVacaciones() {
		Empleado empleadoDePrueba1 = new Empleado(13456789, 001, "Juan Perez", 50000.0, 2005);
		Empleado empleadoDePrueba2 = new Empleado(10890567, 002, "Estela Maris", 75000.0, 1980);
		Empleado empleadoDePrueba3 = new Empleado(44567889, 003, "Amancio Jackson", 35000.0, 2019);
		Empleado empleadoDePrueba4 = new Empleado(45990876, 004, "Juana Gomez", 35000.0, 2014);

		Administracion administracion = new Administracion();
		empleadoDePrueba1.calcularDiasDeVacaciones();
		empleadoDePrueba2.calcularDiasDeVacaciones();
		empleadoDePrueba3.calcularDiasDeVacaciones();
		empleadoDePrueba4.calcularDiasDeVacaciones();

		assertEquals(28, empleadoDePrueba1.getDiasDeVacaciones());
		assertEquals(35, empleadoDePrueba2.getDiasDeVacaciones());
		assertEquals(14, empleadoDePrueba3.getDiasDeVacaciones());
		assertEquals(21, empleadoDePrueba4.getDiasDeVacaciones());
	}

	
	@Test
	public void calcularGananciaProyecto() {
		Proyecto desarrolloSistemaBanco = new Proyecto("BankSystem", 15000.00, 100000.00);
		Proyecto webECommerce = new Proyecto("TiendaOnline", 8000.00, 50000.00);
		
		assertEquals(85000.00, desarrolloSistemaBanco.ganancia(),0);
		assertEquals(42000.00, webECommerce.ganancia(),0);
		
	}
	
	@Test
	public void calcularSueldoDesarrollador() {
		
		//El desarrollador 1 tendrá 6 proyectos asignados, pero solo 4 terminados.
		//El desarrollador 2 tendrá 6 proyectos asignados, y todos terminados
		
		Proyecto proyecto1 = new Proyecto("Proyecto 1", 15000.00, 100000.00);
		Proyecto proyecto2 = new Proyecto("Proyecto 2", 8000.00, 50000.00);
		Proyecto proyecto3 = new Proyecto("Proyecto 3", 9000.00, 20000.00);
		Proyecto proyecto4 = new Proyecto("Proyecto 4", 22000.00, 40000.00);
		Proyecto proyecto5 = new Proyecto("Proyecto 5", 2000.00, 5000.00);
		Proyecto proyecto6 = new Proyecto("Proyecto 6", 5000.00, 10000.00);
		Proyecto proyecto7 = new Proyecto("Proyecto 7", 10000.00, 35000.00);
		Proyecto proyecto8 = new Proyecto("Proyecto 8", 50000.00, 120000.00);
		
		Gerente gerente = new Gerente(22909887, 88, "Armando Paredes", 112000.00, 1995);
		
		//Si bien no es necesario para el proposito de este test comenzarProyecto(), se incluye para mostrar como seria el flujo
		gerente.comenzarProyecto(proyecto1);
		gerente.terminarProyecto(proyecto1);
		gerente.comenzarProyecto(proyecto2);
		gerente.terminarProyecto(proyecto2);
		gerente.comenzarProyecto(proyecto3);
		gerente.terminarProyecto(proyecto3);
		gerente.comenzarProyecto(proyecto4);
		gerente.terminarProyecto(proyecto4);
		gerente.comenzarProyecto(proyecto5);
		gerente.terminarProyecto(proyecto5);
		gerente.comenzarProyecto(proyecto6);
		gerente.terminarProyecto(proyecto6);
		//El proyecto 7 es cancelado
		gerente.comenzarProyecto(proyecto7);
		gerente.cancelarProyecto(proyecto7);
		//El poryecto 8 no esta temrinado aun
		gerente.comenzarProyecto(proyecto8);
		
		Desarrollador desarrollador1 = new Desarrollador(30778909, 155, "Juan Perez", 60000.00, 2015);
		Desarrollador desarrollador2 = new Desarrollador(36445009, 209, "Mariana Arias", 57000.00, 2019);
		
		desarrollador1.asignarProyecto(proyecto1);
		desarrollador1.asignarProyecto(proyecto2);
		desarrollador1.asignarProyecto(proyecto3);
		desarrollador1.asignarProyecto(proyecto4);
		desarrollador1.asignarProyecto(proyecto7);
		desarrollador1.asignarProyecto(proyecto8);
		
		desarrollador2.asignarProyecto(proyecto1);
		desarrollador2.asignarProyecto(proyecto2);
		desarrollador2.asignarProyecto(proyecto3);
		desarrollador2.asignarProyecto(proyecto4);
		desarrollador2.asignarProyecto(proyecto5);
		desarrollador2.asignarProyecto(proyecto6);
		
		//empleado 1 debiera cobrar $71000 (Sueldo base + $3000 de plus por no tener faltas + $8000 de los 4 proyectos finalizados)
		//empleado 2 debiera cobrar $72000 (Sueldo base + $3000 de plus por no tener faltas + $12000 de los 6 proyectos finalizados)
		assertEquals(71000.00, desarrollador1.calcularSueldo(desarrollador1),0);
		assertEquals(72000.00, desarrollador2.calcularSueldo(desarrollador2),0);
		
	
		
		
		
		
		
		
	}
	
}
