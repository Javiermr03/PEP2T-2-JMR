package PROG2T.PEP2T_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PilotDigits {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner ( System.in );
        boolean salir = false;

        // Menu de opciones
        while ( ! salir ) {
            System.out.println ( "\n\t\t\tMenú de Opciones" );
            System.out.println ( "\t\t\t================" );
            System.out.println ( "\n\t1) Generar dígitos de control" );
            System.out.println ( "\t2) Validar dígitos de control" );
            System.out.println ( "\t3) Generar dígitos del IBAN" );
            System.out.println ( "\t4) Validar dígitos del IBAN" );
            System.out.println ( "\t5) Salir" );
            System.out.print ( "\n\t\t\tOpción: " );
            try {
                int option = sc.nextInt ( );
                sc.nextLine ( );
                Menu opciones = new Menu();
                switch ( option ) {
                    case 1:
                        opciones.opcion1 ( );
                        break;
                    case 2:
                        opciones.opcion2 ( );
                        break;
                    case 3:
                        opciones.opcion3 ();
                        break;
                    case 4:
                        opciones.opcion4 ( );
                        break;
                    case 5:
                        System.out.println ( "Saliendo..." );
                        salir = true;
                        break;
                    default:
                        System.out.println ( "Opción inválida. Seleccione una opción válida." );
                }
            }
            catch ( InputMismatchException e ) {
                System.out.println ( "Por favor ingrese un valor numérico válido." );
                sc.nextLine ( );
            }
            if ( ! salir ) {
                System.out.print ( "\nVolviendo al menú de Opciones...\n" );
            }
        }
        System.out.println ( "\u001b[0;1m" + "\n\t\t¡Hasta la próxima!" + "\u001b[0;0m" );
    }
}