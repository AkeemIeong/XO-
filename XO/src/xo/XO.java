
package xo;

import java.util.Scanner;
public class XO {

    static Scanner leer=new Scanner(System.in);
    public static void main(String[] args) {
        char op='s';
        do{
            System.out.println("X O");
            System.out.println("Opcion 1 Vs PvP");
            System.out.println("Opcion 2 Vs Ai");
            int opcion=leer.nextInt();
            switch(opcion){
                case 1:
                    char[][]matriz=generar();
                    int[]array;
                    for (int i = 0; i < 9; i++) {
                        imprimir(matriz);
                        System.out.println("Ingrese una linea: ");
                        int line=leer.nextInt();
                        System.out.println("Ingrese una columna: ");
                        int col=leer.nextInt();
                        matriz=pos(matriz,line,col,i);
                        System.out.println("MAtriz gen:\n");imprimir(matriz);
                        array=turn(matriz);
                        imprimir2(array);
                        if(veri(array)==true){
                            System.out.println("Has ganado");
                        }else
                            System.out.println("Ingrese una linea: ");
                    }
                    break;
                case 2:

                    break;
            }
        }while(op!='n') ;
    }
    public static char[][]generar(){
        char[][]matriz=new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j]=' ';
            }
        }
        return matriz;
    }
    
    public static void imprimir(char matriz[][]){
        String matri="";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matri+= "["+matriz[i][j]+"]";
            }
            matri+="\n";
        }//Carlos Fortin es mi idolo:)
        System.out.println(matri);
    }
    
    public static void imprimir2(int array[]){
        String accum="";
        for (int i = 0; i < array.length; i++) {
            accum+=array[i];
        }
        System.out.println("Array gen: "+accum);
    }
    
    public static int[] turn(char [][]matriz){
        int []array=new int[9];
        int cont=0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                array[cont]=matriz[i][j];
                cont++;
            }
        }
        return array;
    }
    
    public static boolean veri(int[]array){
        boolean veri=false;
        for (int i = 0; i < array.length; i++) {
            if(i==0){
                if(array[i]==array[i+4]&&array[i]==array[i+8]){
                    veri=true;
                }else
                    if(array[i]==array[i+3]&&array[i]==array[i+6]){
                        
                    }
            }
            if(i>=0&&i<3||3>=0&&i<6||i>=6&&i<=8){
                if(array[i] ==array[i+1]&&array[i]==array[i+2]){
                    veri=true;
                }
            }
            if(i==2){
                if(array[i]==array[i+2]&&array[i]==array[i+6]){
                    veri=true;
                }
            }
        }
        
        return veri;
    }
    
    public static char[][]pos(char[][]matriz,int line,int col,int x){
        char[][]temp=new char[matriz.length][matriz[0].length];
        for (int i = 0; i <matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(line==i&&col==j){
                    if(matriz[i][j]=='X'||matriz[i][j]=='0'){
                        System.out.println("No se puede realizar el movimiento");
                    }else
                        if(x%2==0){
                            matriz[i][j]='X';
                        }
                        else
                            matriz[i][j]='0';
                }
            }
        }
        return temp;
    }
}
/*while(turn<9){
                        turn(matriz);
                        System.out.println("Ingrese una linea: ");
                        pos=leer.nextInt();
                        System.out.println("Ingese una fila: ");
                        matriz=place(matriz,pos,turn);
                        turn++;
                        imprimir(matriz);
                    }
    public static char[][]place(char [][]matriz,int pos,int turn){
        char [][]temp=new char [matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                    if(matriz[i][j]==' '){
                        if(turn%2==0){
                            matriz[i][j]='X';
                        }
                        else
                            matriz[i][j]='0';
                    }
                }
            }
        
        return temp;
    }
*/