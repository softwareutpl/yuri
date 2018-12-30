/*

 * To change this template, choose Tools | Templates

 * and open the template in the editor.

 */

package mayra;



import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Calendar;

import java.util.GregorianCalendar;

import java.util.Scanner;



/**

 *

 * @author User

 */

public class Mayra {



    public static void main(String[] args) {

        // TODO code application logic here

        try {

            System.out.println("");//declaramos las diferentes variables que usaremos

            Scanner sca = new Scanner(System.in);

            Calendar cal = new GregorianCalendar();

            int mesActual = cal.get(Calendar.MONTH), anyoActual = cal.get(Calendar.YEAR),

                    diaActual = cal.get(Calendar.DAY_OF_MONTH);

            int mes, dia, anyo;

            int mesResultado, diaResultado, anyResultado;





            System.out.println("Calcular cuantos años tienes");//preguntamos dia mes y año de nacimiento

            System.out.println("Dime el día");

            dia = sca.nextInt();

            System.out.println("Dime el mes");

            mes = sca.nextInt();

            System.out.println("Dime el año");

            anyo = sca.nextInt();



//creamos las excepciones en caso que la fecha de error

            if (dia < 0 | dia > 31) {

                throw new Exception("el día está mal puesto");



            }

            if (mes < 0 | mes > 12) {

                throw new Exception("el mes está mal puesto");



            }

            if (anyo < 0) {

                throw new Exception("el año está mal puesto");



            }



            mesResultado = Math.abs(mes - mesActual+1);

            diaResultado = Math.abs(dia - diaActual);

            anyResultado = Math.abs(anyo - anyoActual);



            System.out.println("Tienes " + anyResultado + " años" + ", " + mesResultado

                    + " meses " + " y " + diaResultado + " días");

            aniadirArchivo(diaResultado,mesResultado, anyResultado);

        } catch (Exception ex) {

            System.out.println("Ha habido un error " + ex.toString());

        }



    }

    

    

    public static void aniadirArchivo(int wdia, int wmes, int wanio) {

		FileWriter flwriter = null;

		try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 

			flwriter = new FileWriter("C:\\_versalida\\persona.txt", true);

			BufferedWriter bfwriter = new BufferedWriter(flwriter);

     		//escribe los datos en el archivo

		bfwriter.write( "Edad exacta = " + wanio + " años " + wmes + " meses "+ wdia + " dias" +"\n");

                bfwriter.flush();

			bfwriter.close();

			System.out.println("Archivo modificado satisfactoriamente..");

 

		} catch (IOException e) {

		} finally {

			if (flwriter != null) {

				try {

					flwriter.close();

				} catch (IOException e) {

				}

			}

		}

	}	

    

    

}