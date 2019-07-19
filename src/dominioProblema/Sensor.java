package dominioProblema;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author JonathanLizama
 */
public class Sensor {

      /**
       * Función que lee un numero entero.
       *
       * @return un entero.
       *
       */
      public static int leerNumeroEntero() {
            Scanner leer = new Scanner(System.in);
            try {
                  return leer.nextInt();
            } catch (InputMismatchException e) {
                  System.out.println(e);
                  System.out.println("ingrese un valor valido");
                  return 0;
            }
      }

      /**
       * Función que entrega el registro sismologico.
       *
       * @param registro es una matriz con valores azar.
       * @param dias cantidad dias a analizar.
       * @param validar valida cantidad dias sea mayor a 0.
       * @return registro con numeros azar entre 0.0 y 9.5.
       *
       */
      public static double[][] registroSismologico(double registro[][], int dias, boolean validar) {
            if (validar == true) {
                  for (int i = 0; i < dias; i++) {
                        for (int j = 0; j < 24; j++) {
                              registro[i][j] = gradosRichterAzar();
                        }
                  }
            }
            System.out.println("El registro se realizo correctamente");
            return registro;

      }

      /**
       * Función que muestra el registro sismologico de Nx24.
       *
       * @param registro de sismos.
       * @param dias que se analizarón.
       *
       */
      public static void mostrarRegistroSismologico(double registro[][], int dias) {
            System.out.println("\t" + "\t" + "REGISTRO DE SISMOS");
            for (int i = 0; i < dias; i++) {
                  for (int j = 0; j < 24; j++) {
                        System.out.print("[" + registro[i][j] + "]" + "\t");

                  }
                  System.out.println("");

            }

      }

      /**
       * Función Main que se encarga de lanzar el programa
       *
       * @param args.
       *
       */
      public static void main(String[] args) {

            menu();
      }

      /**
       * Función que genera los grados Richter.
       *
       * @return grados richter entre 0.0 y 9.5.
       *
       */
      public static double gradosRichterAzar() {
            Random azar = new Random();
            double numero = azar.nextDouble() * 9.5;
            return Math.round(numero * Math.pow(10, 2)) / Math.pow(10, 2);
      }

      /**
       * Función que calcula el sismo mas intenso en la escala grados Richter .
       *
       * @param registro simologico.
       * @param dias cantidad de dias analizados.
       * @return mayorSismo.
       *
       */
      public static double mayorIntensidadSismo(double registro[][], int dias) {
            double mayorIntensidad = registro[0][0];
            try {
                  for (int i = 0; i < dias; i++) {
                        for (int j = 0; j < 24; j++) {
                              if (mayorIntensidad < registro[i][j]) {
                                    mayorIntensidad = registro[i][j];
                              }
                        }
                  }
                  return mayorIntensidad;
            } catch (ArrayIndexOutOfBoundsException ex) {
                  System.out.println(ex);
                  System.out.println("el indice del array no existe");
                  double vacio = 0.0;
                  return vacio;
            }
      }

      /**
       * Función que calcula el dia que se produjo el mayor sismo.
       *
       * @param registro sismologico.
       * @param dias analizados.
       * @return diaMayorIntensidad.
       *
       */
      public static int diaMayorIntensidad(double registro[][], int dias) {
            int diaMayor = 0;
            double mayorIntensidad = registro[0][0];
            for (int i = 0; i < dias; i++) {
                  for (int j = 0; j < 24; j++) {
                        if (mayorIntensidad < registro[i][j]) {
                              mayorIntensidad = registro[i][j];
                              diaMayor = i + 1;
                        }
                  }
            }
            return diaMayor;
      }

      /**
       * Función que entrega un dia de la semana (lunes-domingo).
       *
       * @param dia tiene un maximo de 21 dias, al sobrepasar este numero, arrojara que no
       * existe.
       * @return diaDeLaSemana.
       *
       */
      public static String diaDeLaSemana(int dia) {
            String respuesta;
            switch (dia) {
                  case 1:
                  case 8:
                  case 15:
                        respuesta = "Lunes";
                        break;
                  case 2:
                  case 9:
                  case 16:
                        respuesta = "Martes";
                        break;
                  case 3:
                  case 10:
                  case 17:
                        respuesta = "Miercoles";
                        break;
                  case 4:
                  case 11:
                  case 18:
                        respuesta = "Jueves";
                        break;
                  case 5:
                  case 12:
                  case 19:
                        respuesta = "Viernes";
                        break;
                  case 6:
                  case 13:
                  case 20:
                        respuesta = "Sabado";
                        break;
                  case 7:
                  case 14:
                  case 21:
                        respuesta = "Domingo";
                        break;
                  default:
                        respuesta = "no existe";
                        break;
            }
            return respuesta;

      }

      /**
       * Función que calcula la hora que se produjo el mayor Sismo.
       *
       * @param registro sismologico.
       * @param dias analizados.
       * @return horaMayorSismo.
       *
       */
      public static int horaMayorIntensidad(double registro[][], int dias) {
            int horaMayor = 0;
            double mayorIntensidad = registro[0][0];
            for (int i = 0; i < dias; i++) {
                  for (int j = 0; j < 24; j++) {
                        if (mayorIntensidad < registro[i][j]) {
                              mayorIntensidad = registro[i][j];
                              horaMayor = j + 1;
                        }
                  }
            }
            return horaMayor;
      }

      /**
       * Función que cuenta los sismos superiores o iguales a 5.5 °Richter.
       *
       * @param registro sismologico.
       * @param dias analizados.
       * @return totalSismos > 5.5.
       *
       */
      public static int sismoMayor55(double registro[][], int dias) {
            int cont = 0;
            for (int i = 0; i < dias; i++) {
                  for (int j = 0; j < 24; j++) {
                        if (registro[i][j] >= 5.5) {
                              cont++;
                        }
                  }
            }
            return cont;
      }

      /**
       * Función que muestra un menu para interactuar con el usuario.
       *
       */
      public static void menu() {
            boolean salir = false;
            int cantidadDias = 0;
            boolean validar;
            double registro[][] = new double[][]{{}, {}};
            double sumaDias[] = {};
            double promedio[] = {};
            while (!salir) {
                  System.out.println("------------------------------------------------------------------------");
                  System.out.println("Bienvenido a la aplicacion sensor sismologico");
                  System.out.println("------------------------------------------------------------------------");
                  System.out.println("1. Generar registro de sismos");
                  System.out.println("2. Mostrar registro sismologico");
                  System.out.println("3. Cual fue el sismo mas intenso? ");
                  System.out.println("4. Que dia ocurrio el sismo mas intenso? ");
                  System.out.println("5. A que hora ocurrio el sismo más intenso? ");
                  System.out.println("6. Promedio con respecto a los dias");
                  System.out.println("7. Promedio Mayor");
                  System.out.println("8. Salir");
                  System.out.println("------------------------------------------------------------------------" + "\n");
                  int opcion = leerNumeroEntero();

                  switch (opcion) {
                        case 1: {
                              System.out.println("Ingrese la cantidad de dias que desea analizar ");
                              cantidadDias = leerNumeroEntero();
                              validar = validarCantidadDias(cantidadDias);
                              registro = new double[cantidadDias][24];
                              registroSismologico(registro, cantidadDias, validar);
                              sumaDias = new double[cantidadDias];
                              sumaDias(registro, cantidadDias, sumaDias);
                              promedio = new double[cantidadDias];

                              break;
                        }
                        case 2: {
                              validar = validarCantidadDias(cantidadDias);
                              if (validar == true) {
                                    mostrarRegistroSismologico(registro, cantidadDias);

                              } else {
                                    System.out.println("Primero debemos generar el registro, presione 1" + "\n");
                              }

                              break;
                        }
                        case 3: {
                              validar = validarCantidadDias(cantidadDias);
                              if (validar == true) {
                                    System.out.println(mayorIntensidadSismo(registro, cantidadDias) + " °Richter");

                              } else {
                                    System.out.println("Primero debemos generar el registro, presione 1" + "\n");
                              }

                              break;
                        }
                        case 4: {
                              validar = validarCantidadDias(cantidadDias);
                              if (validar == true) {
                                    System.out.println("Ocurrio el dia : " + diaDeLaSemana(diaMayorIntensidad(registro, cantidadDias)));
                              } else {
                                    System.out.println("Primero debemos generar el registro, presione 1" + "\n");
                              }

                              break;
                        }
                        case 5: {
                              validar = validarCantidadDias(cantidadDias);
                              if (validar == true) {
                                    System.out.println("Fue a las: " + horaMayorIntensidad(registro, cantidadDias) + " Hrs");
                              } else {
                                    System.out.println("Primero debemos generar el registro, presione 1" + "\n");
                              }
                              break;
                        }
                        case 6: {
                              validar = validarCantidadDias(cantidadDias);
                              if (validar == true) {
                                    mostrarPromedio(promedioDias(registro, cantidadDias, sumaDias, promedio), cantidadDias);
                              } else {
                                    System.out.println("Primero debemos generar el registro, presione 1" + "\n");
                              }
                              break;
                        }
                        case 7: {
                              validar = validarCantidadDias(cantidadDias);
                              if (validar == true) {
                                    if (promedioMayorIntensidad(promedio, cantidadDias) != 0.0) {
                                          System.out.println("Mayor promedio es: " + promedioMayorIntensidad(promedio, cantidadDias));
                                          System.out.println("Fue el dia N°: " + diaMayorPromedio(promedio, cantidadDias));
                                    } else {
                                          System.out.println("PRIMERO DEBE CALCULAR EL PROMEDIO, presione 6");
                                    }

                              } else {
                                    System.out.println("Primero debemos generar el registro, presione 1" + "\n");
                              }
                              break;
                        }
                        case 8: {
                              System.out.println("Ha salido del registro sismologico");
                              salir = true;

                              break;
                        }
                        default:
                              System.out.println("Ingrese una opción correcta...");
                              break;
                  }
            }
      }

      /**
       * Función que valida que la cantidad de dias sea mayor a 0.
       *
       * @param dias analizados.
       * @return True si dias > 0.
       *
       */
      public static boolean validarCantidadDias(int dias) {
            return dias > 0;
      }

      /**
       * Función que calcula la suma de los sismos de cada dia.
       *
       * @param registro sismologico.
       * @param dias analizados.
       * @param sumaDias suma cada fila del registroSismologico.
       * @return sumaDias con respecto a las 24 hrs del dia.
       *
       */
      public static double[] sumaDias(double registro[][], int dias, double sumaDias[]) {
            for (int i = 0; i < dias; i++) {
                  for (int j = 0; j < 24; j++) {
                        sumaDias[i] = (Math.round((sumaDias[i] + registro[i][j]) * Math.pow(10, 2)) / Math.pow(10, 2));
                  }

            }
            return sumaDias;

      }

      /**
       * Función que calcula el promedio de los sismos de cada dia.
       *
       * @param registro Sismologico.
       * @param dias analizados.
       * @param sumaDias suma las filas del registroSismologico.
       * @param promedio de cada fila del registroSismologico(sumaDias[i]/24).
       * @return promedio.
       *
       */
      public static double[] promedioDias(double registro[][], int dias, double sumaDias[], double promedio[]) {
            for (int i = 0; i < dias; i++) {
                  promedio[i] = (Math.round((sumaDias[i] / 24) * Math.pow(10, 3)) / Math.pow(10, 3));
            }
            return promedio;
      }

      /**
       * Función que muestra el promedio de los sismos con respecto a los dias analizados.
       *
       * @param promedio de cada fila del registroSismologico(sumaDias[i]/24).
       * @param dias analizados.
       */
      public static void mostrarPromedio(double promedio[], int dias) {
            for (int i = 0; i < dias; i++) {
                  System.out.print("Promedio Dia N°" + (i + 1) + ":");
                  System.out.println("[" + promedio[i] + "]" + "\t");
            }
            System.out.println("");

      }

      /**
       * Función que calcula el mayor Promedio.
       *
       * @param promedio de cada fila del registroSismologico(sumaDias[i]/24).
       * @param dias analizados.
       * @return mayorPromedio.
       *
       */
      public static double promedioMayorIntensidad(double promedio[], int dias) {
            double mayor = promedio[0];
            for (int i = 0; i < dias; i++) {
                  if (promedio[i] > mayor) {
                        mayor = promedio[i];
                  }
            }
            return mayor;

      }

      /**
       * Función que calcula el dia del mayor promedio.
       *
       * @param promedio de cada fila del registroSismologico(sumaDias[i]/24).
       * @param dias analizados.
       * @return diaMayorPromedio.
       *
       */
      public static int diaMayorPromedio(double promedio[], int dias) {
            int mayor = 1;
            double mayorPromedio = promedio[0];
            for (int i = 0; i < dias; i++) {
                  if (promedio[i] > mayorPromedio) {
                        mayorPromedio = promedio[i];
                        mayor = i + 1;
                  }
            }
            return mayor;
      }
}
