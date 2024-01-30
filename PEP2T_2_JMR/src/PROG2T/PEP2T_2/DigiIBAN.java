package PROG2T.PEP2T_2;

import java.math.BigInteger;

class DigiIBAN {

    String generacionIBAN(String banco , String sucursal , String digitosControl , String cuenta ) {

        String cuentacompleta = banco + sucursal + digitosControl + cuenta;
        String cuentacompletado = cuentacompleta + "142800";
        BigInteger numerocuenta = new BigInteger(cuentacompletado);
        BigInteger modulo = new BigInteger("97");
        BigInteger resto = numerocuenta.mod(modulo);
        int digitosiban = 98 - resto.intValue();
        if(digitosiban < 10) {
            return "ES0" + digitosiban + " " + cuentacompleta;
        }
        return "ES" + digitosiban;
    }

    boolean validarIBAN(String ibanCorrecto , String ibanAValidar ) {

        return ibanCorrecto.equals(ibanAValidar);
    }
}