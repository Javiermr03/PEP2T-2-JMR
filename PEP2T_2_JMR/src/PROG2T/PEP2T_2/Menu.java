package PROG2T.PEP2T_2;

import java.util.Scanner;

class Menu {
    private final Scanner scanner = new Scanner ( System.in );

    // método que obtiene una entrada del usuario con el mensaje especificado
    private String getInput ( String mensaje ) {
        System.out.print ( mensaje );
        return scanner.nextLine ( );
    }


    void opcion1 () {

        // Pide al usuario que introduzca los datos de su cuenta
        String banco = getInput ( "\nIntroduce los 4 digitos del banco: " );
        String sucursal = getInput ( "Introduce los 4 digitos de la sucursal: " );
        String cuenta = getInput ( "Introduce los 10 digitos de la cuenta: " );
        String cuenta2 = "00" + banco + sucursal;

        DigiControl pruebacontrol = new DigiControl ();
        int digitosControl1 = pruebacontrol.generarDigitosControl( cuenta2 );
        int digitosControl2 = pruebacontrol.generarDigitosControl( cuenta );
        String digitosControl = String.valueOf ( digitosControl1 ) + digitosControl2;

        System.out.println ("\n" + banco + " " + sucursal + " DC1DC2 " + cuenta + " ---> " + banco + " " + sucursal + " " + digitosControl + " " + cuenta );

    }

    void opcion2 ( ) {

        //    Pide al usuario que introduzca los datos de su cuenta
        String banco = getInput ( "\nIntroduce los 4 digitos del banco: " );
        String sucursal = getInput ( "Introduce los 4 digitos de la sucursal: " );
        String digitosControlAValidar = getInput ( "Introduce los 2 digitos de control: " );
        String cuenta = getInput ( "Introduce los 10 digitos de la cuenta: " );
        String cuentaSinDC = "00" + banco + sucursal;

        DigiControl pruebacontrol = new DigiControl ();
        int digitosControl1 = pruebacontrol.generarDigitosControl( cuentaSinDC );
        int digitosControl2 = pruebacontrol.generarDigitosControl( cuenta );
        String digitosControl = String.valueOf ( digitosControl1 ) + digitosControl2;
        System.out.print ( "\nNúmero de cuenta a validar: " + banco + " " + sucursal + " " + digitosControlAValidar + " " + cuenta );
        DigiControl pruebadigcon = new DigiControl ();
        boolean esValido = pruebadigcon.validarDC( digitosControl , digitosControlAValidar );

        System.out.println ( "\nDígitos calculados: " + digitosControl );
        System.out.print ( esValido ? "Verificacion: Correcta" : "Verificacion: Incorrecta" );
    }

    void opcion3 () {
        String banco = getInput ( "\nIntroduce los 4 digitos del banco: " );
        String sucursal = getInput ( "Introduce los 4 digitos de la sucursal: " );
        String digitosControl = getInput ( "Introduce los 2 digitos de control: " );
        String cuenta = getInput ( "Introduce los 10 digitos de la cuenta: " );
        DigiIBAN pruebaiban = new DigiIBAN();
        String iban = pruebaiban.generacionIBAN( banco , sucursal , digitosControl , cuenta );
        System.out.println ("\nIBAN generado:  " + iban + " " + banco + " " + sucursal + " " + digitosControl + " " + cuenta );
    }

    void opcion4 ( ) {
        String ibanAValidar = getInput ( "\nIntroduce los 4 primeros dígitos del IBAN: " );
        String banco = getInput ( "Introduce los 4 digitos del banco: " );
        String sucursal = getInput ( "Introduce los 4 digitos de la sucursal: " );
        String digitosControl = getInput ( "Introduce los 2 digitos de control: " );
        String cuenta = getInput ( "Introduce los 10 digitos de la cuenta: " );
        DigiIBAN pruebaiban = new DigiIBAN();
        String ibancorrecto = pruebaiban.generacionIBAN( banco , sucursal , digitosControl , cuenta );
        DigiIBAN validariban = new DigiIBAN();
        boolean esValido = validariban.validarIBAN( ibancorrecto , ibanAValidar );
        System.out.println ( "\nNúmero de cuenta a validar: " + ibanAValidar + " " + banco + " " + sucursal + " " + digitosControl + " " + cuenta );
        System.out.print ( "IBAN calculado: " + ibancorrecto );
        if ( esValido ) {
            System.out.print ( "\tVerificacion: Correcta\n" );
        } else {
            System.out.print ( "\tVerificacion: Incorrecta\n" );
        }
    }
}