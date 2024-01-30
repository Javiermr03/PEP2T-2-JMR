package PROG2T.PEP2T_2;

class DigiControl {
    private static final int[] CONSTANTES = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};

    // Generar dígito de control
    int generarDigitosControl(String cuenta2) {

        int acumulado = 0;
        int dc = 0;
        int resto;

        for (int i = 0; i < cuenta2.length(); i++) {
            acumulado += Character.getNumericValue(cuenta2.charAt(i)) * CONSTANTES[i];
            if (i == 9) {
                resto = acumulado % 11;
                dc = 11 - resto;
                if (dc == 10) {
                    dc = 1;
                } else if (dc == 11) {
                    dc = 0;
                }
            }
        }
        return dc;
    }

    // Validar dígito de control
    boolean validarDC(String digitosControl, String digitosControlaValidar) {

        return digitosControl.equals(digitosControlaValidar);
    }
}