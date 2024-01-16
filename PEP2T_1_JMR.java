import java.util.Scanner;

public class PEP2T_1_JMR {

    private double saldo;
    private double topeRetirada;

    // Establecer el tope de retirada en 600€ y el saldo inicial en 2000€ en el constructor
    public PEP2T_1_JMR() {
        this.saldo = 2000.0;
        this.topeRetirada = 600.0;
    }

    // Método para mostrar el menú de opciones
    public void mostrarMenu() {
        System.out.println("\n\t  \u001B[34mPROGRAMA CAJERO AUTOMÁTICO\u001B[0m");
        System.out.println("\n\t\t  Menú de Opciones");
        System.out.println("\t    ====================");
        System.out.println("\n\t\t  1) Retirada de dinero");
        System.out.println("\t\t  2) Ingreso de dinero");
        System.out.println("\t\t  3) Salir");
        System.out.print("\n\t\t\t  Opción: ");
    }

    // Método para realizar retiradas
    public void realizarRetirada(double cantidad) {
        if (verificarTope(cantidad)) {
            if (verificarSaldo(cantidad)) {
                System.out.println("\n\t\u001B[32m     Usted retiró " + cantidad + " €\u001B[0m");
                saldo -= cantidad;
                topeRetirada -= cantidad;
                System.out.println("\t\u001B[32mSu saldo actual es de " + saldo + " €\u001B[0m");
            } else {
                System.out.println("\u001B[31mSaldo insuficiente. Operación cancelada.\u001B[0m");
            }
        } else {
            System.out.println("\n\t\t\u001B[31mSu saldo actual es de "  + saldo + "€\u001B[0m");
        }
    }

    // Método para realizar ingresos
    public void realizarIngreso(double cantidad) {
        System.out.println("\n\t\u001B[32m    Usted ingresó " + cantidad + " €\u001B[0m");
        saldo += cantidad;
        System.out.println("\t\u001B[32mSu saldo actual es de " + saldo + "€\u001B[0m");
    }

    // Método para comprobar el saldo actual
    public boolean verificarSaldo(double cantidad) {
        return saldo >= cantidad;
    }

    // Método para verificar el tope de retiro diario
    public boolean verificarTope(double cantidad) {
        if (cantidad > topeRetirada) {
            System.out.println("\tIntenta retirar " + cantidad + " €");
            System.out.println("\n\t\u001B[31mTiene establecido ahora un tope de " + topeRetirada + "€\u001B[0m");
            return false;
        }
        else
            return true;
    }

    public static void main(String[] args) {
        // Crear un objeto CajeroAutomatico con el constructor sin parámetros
        PEP2T_1_JMR cajero = new PEP2T_1_JMR();

        int opcion;
        Scanner lector = new Scanner(System.in);

        do {
            cajero.mostrarMenu();
            opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n\tSu saldo actual es de " + cajero.saldo + " €");
                    System.out.print("\tTeclee dinero a retirar: ");
                    double cantidadRetirar = lector.nextDouble();
                    cajero.realizarRetirada(cantidadRetirar);
                    break;
                case 2:
                    System.out.print("\n\tTeclee dinero a ingresar: ");
                    double cantidadIngresar = lector.nextDouble();
                    cajero.realizarIngreso(cantidadIngresar);
                    break;
                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("\u001B[31m¡Opción no válida! Por favor, elija una opción correcta.\u001B[0m");
                    break;
            }

        } while (opcion != 3);

        lector.close();
    }
}
