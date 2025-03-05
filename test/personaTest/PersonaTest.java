package personaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.model.Persona;

class PersonaTest {

    private Persona personaDefault;
    private Persona personaConDatos;
    private Persona personaCompleta;

    @BeforeEach
    void setUp() {
        personaDefault = new Persona();
        personaConDatos = new Persona("Juan", 25, 'H');
        personaCompleta = new Persona("Ana", 30, 'M', 60, 1.65);
    }

    @Test
    void testPersona() {
        assertNotNull(personaDefault);
        assertNotEquals("", personaDefault.toString().contains("Nombre: ")); 
    }

    @Test
    void testPersonaStringIntChar() {
        assertTrue(personaConDatos.toString().contains("Nombre: Juan"));
        assertTrue(personaConDatos.toString().contains("Edad: 25"));
        assertEquals('H', personaConDatos.getSexo());
    }

    @Test
    void testPersonaStringIntCharDoubleDouble() {
        assertTrue(personaCompleta.toString().contains("Nombre: Ana"));
        assertTrue(personaCompleta.toString().contains("Edad: 30"));
        assertEquals('M', personaCompleta.getSexo());
    }


    @Test
    void testSetNombre() {
        personaDefault.setNombre("Carlos");
        assertTrue(personaDefault.toString().contains("Nombre: Carlos"));
    }

    @Test
    void testSetEdad() {
        personaDefault.setEdad(40);
        assertTrue(personaDefault.toString().contains("Edad: 40"));
    }

    @Test
    void testSetSexo() {
        personaDefault.setSexo('M');
        assertEquals('M', personaDefault.getSexo());
        personaDefault.setSexo('X'); 
        assertNotEquals('H', personaDefault.getSexo());
    }

    @Test
    void testSetPeso() {
        personaDefault.setPeso(75);
        assertTrue(personaDefault.toString().contains("Peso: 75"));
    }

    @Test
    void testSetAltura() {
        personaDefault.setAltura(1.80);
        assertTrue(personaDefault.toString().contains("Altura: 1.8"));
    }

    @Test
    void testCalcularIMC() {
        personaCompleta.setPeso(50);
        assertEquals(Persona.INFRAPESO, personaCompleta.calcularIMC());
        
        personaCompleta.setPeso(65);
        assertEquals(Persona.PESO_IDEAL, personaCompleta.calcularIMC());
        
        personaCompleta.setPeso(80);
        assertEquals(Persona.SOBREPESO, personaCompleta.calcularIMC());
    }

    @Test
    void testEsMayorDeEdad() {
        personaConDatos.setEdad(17);
        assertFalse(personaConDatos.esMayorDeEdad());
        
        personaConDatos.setEdad(18);
        assertTrue(personaConDatos.esMayorDeEdad());
    }

    @Test
    void comprobarSexo() {
    	assertEquals('H', personaDefault.getSexo());
    	assertEquals('H', personaDefault.getSexo());
    }
}
