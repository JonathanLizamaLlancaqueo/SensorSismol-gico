package sensorTest;


import dominioProblema.Sensor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JonathanLizama
 */
public class testSensor {

      @Before
      public void setUp() {

      }

      /**
       * Test que prueba el ingreso de una matriz 2x2 , con una cantidad de dias que no
       * existe.
       *
       */
      @Test
      public void testMayorIntensidad() {
            double registro[][] = new double[][]{{1.32, 3.31}, {4.23, 2.65}};
            double esperado = Sensor.mayorIntensidadSismo(registro, 5);
            double resultado = 0.0;
            assertEquals(esperado, resultado, 0.2);
      }

      /**
       * Test que prueba el ingreso de un dia de la semana que no existe en nuestros
       * registro, que en principio es de 21 dias
       *
       */
      @Test
      public void testDiaDeLaSemana() {
            String diaEsperado = Sensor.diaDeLaSemana(22);
            String resultado = "no existe";
            assertEquals(diaEsperado, resultado);

      }

      /**
       * Test que valida el ingreso de un dia que no existe, osea un valor negativo
       *
       */
      @Test
      public void testValidarCantidadDias() {
            assertEquals(Sensor.validarCantidadDias(-4), false);
      }

      @After
      public void tearDown() {
      }

}
