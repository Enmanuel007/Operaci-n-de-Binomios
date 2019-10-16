import java.io.InputStreamReader;
import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    public static void MostrarMenu(){
        System.out.println("*****************");
        System.out.println("*******Menu******");
        System.out.println("*****************");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Salir");
        LeerSeleccion();
    }
    
    public static void LeerSeleccion(){
        try {
            int seleccion;
            int[] polinomioA, polinomioB, resultado;
            Interface i =(Interface)Naming.lookup("rmi://192.168.137.57/Polinomio");
            System.out.print("Digite su opcion: ");
            Scanner sc = new Scanner (new InputStreamReader(System.in));
            seleccion = sc.nextInt();
            
            switch(seleccion){
                case 1:
                    System.out.print("Sumar: ");
                    polinomioA = LeerPolinomio("Ingrese el primer Polinomio");
                    polinomioB = LeerPolinomio("Ingrese el segundo Polinomio");
                    resultado = i.sumar(polinomioA, polinomioB);
                    System.out.println("El Resultado de la operación Sumar es: ");
                    MostrarPolinomio(resultado);
                    System.out.println("Presione una tecla para continuar");
                    //String seguir= sc.nextLine();
                    //while(seguir.equals("")) System.out.println(seguir);
                    MostrarMenu();
                    break;
                case 2:
                    System.out.print("Restar: ");
                    polinomioA = LeerPolinomio("Ingrese el primer Polinomio");
                    polinomioB = LeerPolinomio("Ingrese el segundo Polinomio");
                    resultado = i.restar(polinomioA, polinomioB);
                    System.out.println("El Resultado de la operación Restar es: ");
                    MostrarPolinomio(resultado);
                    MostrarMenu();
                    break;
                case 3:
                    System.out.print("Multiplicar: ");
                    polinomioA = LeerPolinomio("Ingrese el primer Polinomio");
                    polinomioB = LeerPolinomio("Ingrese el segundo Polinomio");
                    resultado = i.multiplicar(polinomioA, polinomioB);
                    System.out.println("El Resultado de la operación Multiplicar es: ");
                    MostrarPolinomio(resultado);
                    MostrarMenu();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    MostrarMenu();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    public static int[] LeerPolinomio(String pMensaje){
        int[] polinomio = new int[3];
        Scanner sc = new Scanner(System.in);
        System.out.println(pMensaje);
        for(int i=0; i<3; i++)
            polinomio[i]=sc.nextInt();
        return polinomio;
    }
    
    public static void MostrarPolinomio(int[] pPolinomio){
        for(int i=0; i<3; i++)
            System.out.println(" " + pPolinomio[i]);
    }
    
    public static void main(String[] args){
        try {
            MostrarMenu();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
