public class Main {
    public static void main(String[] args) {
        char[][] array = new char[14][14];
        int contador = 0, controlador = 1, varTemporalSuma = (array.length / 2) + 4, varTemporalResta = (array.length / 2) - 4;
        for (int i = 0; i < array.length; i++) {
            if(controlador == 2){
                contador = i;
                break;
            }
            for (int j = 0; j < array.length; j++) {
                if(i == 0){
                    if(j > (array.length / 2) - 3 && j < (array.length / 2) + 3){
                        array[i][j] = '*';
                    }
                }
                else{
                    if(varTemporalResta > 0 && varTemporalSuma < array.length - 1){
                        array[i][varTemporalResta] = '*';
                        array[i][varTemporalSuma] = '*';
                        varTemporalSuma++; varTemporalResta--;
                    }
                    else{
                        controlador++;
                        array[i][varTemporalResta] = '*';
                        array[i][varTemporalSuma] = '*';
                    }
                    break;
                }
            }
        }
        int segundoControlador = 0, segundaVarTempRest = (array.length / 2) - 4, segundaVarTempSum = (array.length / 2) + 4;
        for (int i = array.length; i >= contador ; i--) {
            if(segundoControlador == 2){
                break;
            }
            for (int j = 0; j < array.length; j++) {
                if(i == array.length - 1){
                    if(j > (array.length / 2) - 3 && j < (array.length / 2) + 3){
                        array[i][j] = '*';
                    }
                } else if (i < array.length - 1 && i > contador) {
                    if (segundaVarTempRest > 0 && segundaVarTempSum < array.length - 1){
                        array[i][segundaVarTempRest] = '*';
                        array[i][segundaVarTempSum] = '*';
                        segundaVarTempRest--; segundaVarTempSum++;
                    }
                    else{
                        segundoControlador++;
                        array[i][segundaVarTempRest] = '*';
                        array[i][segundaVarTempSum] = '*';
                    }
                    break;
                }
            }
        }
        imprimir(array);
    }
    public static void imprimir(char[][] array){
        for (int i = 0; i < array.length; i++) {
            int controlador = 2;
            for (int j = 0; j < array.length; j++) {
                if(array[i][j] == '*'){
                    controlador--;
                }
                if(controlador == 1){
                    array[i][j] = '*';
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(' ');
                if(array[i][j] == '*'){
                    System.out.print(array[i][j]);
                }
                else{
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}