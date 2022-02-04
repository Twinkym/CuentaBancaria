import java.util.Scanner;

public class CuentaBancaria {

    private static double SALDO = 1000;

    private static final int TREUREDINERS = 1;
    private static final int INGRESARDINERS = 2;

    public static void main(String[] args) {

        askToUser();
        int option = askForOperationOption();
        validateOperations(option, withdraw, deposit);
        validateOperations(option, withdraw, deposit);
        int withdraw = validateWithdraw(option, withdraw);
        int deposit =  validateDeposit( option, deposit);
        makeWithdraw(withdraw);
        makeDeposit(deposit);
    }

    private static void askToUser() {
        System.out.println("Benvingut el saldo del seu compte es: " + SALDO);

    }

    public static int askForOperationOption() {
        System.out.println("Que desitja fer? ");
        System.out.println("1. Treure diners. ");
        System.out.println("2. Ingresar diners. ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String validateOperations(int option, double withdraw, double deposit) {
        if (option == TREUREDINERS) {
            validateWithdraw(option, withdraw);
        }
        if (option == INGRESARDINERS) {
            validateDeposit(option, deposit);
        }
        return "";
    }
    public static String validateWithdraw(int option, double withdraw) {

        if (option == 1 && (withdraw >= SALDO)) {
                System.out.println("Saldo insuficient selecciona una quantitat inferior al teu saldo. " + SALDO);
            }
        if (withdraw <= SALDO){
            makeWithdraw(withdraw);
            System.out.println("Ha seleccionat treure dinners. " + " ¿Quants diners vol extreure? ");
            Scanner sc = new Scanner(System.in);
            return String.valueOf(sc.nextInt());
        }  return ("");

    }

    public static String makeWithdraw(double withdraw) {
        double nouSaldo = (SALDO - withdraw);
        if (withdraw <= SALDO) {
            System.out.println("Retirada realitzada amb exit, el seu nou saldo es: " + (nouSaldo));
        }
        return "Gracias por su visita. ";
    }

    public static String validateDeposit(int option, double deposit) {

        if (option == 2 && (deposit > (2 * SALDO))) {

                System.out.println("No pots ingresar una quantitat superior a dos vegades al teu saldo. " + SALDO);
            }
        if   (deposit <= SALDO) {
            System.out.println("Ha seleccionat ingresar diners. " + " ¿Quants diners vol ingresar?");
            Scanner sc = new Scanner(System.in);
            return String.valueOf(sc.nextInt());
        }
        return "";
    }

    public static String makeDeposit(double deposit) {
        double nouSaldo = (SALDO + deposit);

        if (deposit <= SALDO) {
            System.out.println("Ingres realitzat amb exit, el seu nou saldo es: " + (nouSaldo));
        }
        return "Gracies per la seva visita li desitjem un bon día. ";
    }
}
