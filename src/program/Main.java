package program;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static int i;
    private static int b;

    public static void main (String[] args) {
        Main main = new Main();
        main.inicio();
        if (i != 3) {main.banco();}
    }
    public int inicio() {
        boolean ini = false;
        while (!ini || i > 3 || i < 1) {
            Scanner iniciar = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("+========================+");
                System.out.println("|      L o g a r -       |");
                System.out.println("|      O P Ç Õ E S       |");
                System.out.println("+========================+");
                System.out.println("| 1. Logar               |");
                System.out.println("| 2. Registrar           |");
                System.out.println("| 3. Sair                |");
                System.out.println("+========================+");
                i = iniciar.nextInt();
                ini = true;
                switch (i) {
                    case 1: Loggin login = new Loggin(); login.Login(); break;
                    case 2: Loggin register = new Loggin(); register.Registrar(); break;
                    case 3: break;
                    default: System.out.println("Opção invalida");
                }
            } catch (InputMismatchException e) {
                String erro = iniciar.nextLine();
                System.out.println("Você só pode colocar Numeros!!");
            }
        }
        return i;
    }
    public void banco() {
        b = 0;
        while (b > 6 || b < 1) {
            Scanner bancon = new Scanner(System.in);
            Bank bank = new Bank();
            try {
                System.out.println();
                System.out.println("+========================+");
                System.out.println("|      B A N C O -       |");
                System.out.println("|      O P Ç Õ E S       |");
                System.out.println("+========================+");
                System.out.println("| 1. Saldo               |");
                System.out.println("| 2. Sacar               |");
                System.out.println("| 3. Depositar           |");
                System.out.println("| 4. Transferir          |");
                System.out.println("| 5. Conta               |");
                System.out.println("| 6. Sair                |");
                System.out.println("+========================+");
                b = bancon.nextInt();
                switch (b) {
                    case 1: bank.Saldo(); break;
                    case 2: Loggin register = new Loggin(); register.Registrar(); break;
                    case 3: bank.Depositar(); break;
                    case 4: bank.Transferir(); break;
                    case 6: Main main = new Main(); main.inicio(); break;
                    default: System.out.println("Opção invalida");
                }
            } catch (InputMismatchException e) {
                String erro = bancon.nextLine();
                System.out.println("Você só pode colocar Numeros!!");
            }
        }
    }
}
