package program;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private final Scanner sc = new Scanner(System.in);

    public static void main (String[] args) { Main main = new Main(); main.OptionsLogin(); }

    public void OptionsLogin() {
        boolean errologin = false;
        int login = 0;
        while (!errologin || login > 3 || login < 1) {
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
                login = sc.nextInt();
                errologin = true;
                switch (login) {
                    case 1: Registration startLogin = new Registration(); startLogin.startLogin(); break;
                    case 2: Registration startRegister = new Registration(); startRegister.startRegister(); break;
                    case 3: break;
                    default: System.out.println("Opção invalida");
                }
            } catch (InputMismatchException e) { sc.nextLine(); System.out.println("Você só pode colocar Números!!"); }
        }
    }

    public void OptionsBank() {
        int bank = 0;
        BankApp bankApp = new BankApp();
        while (bank > 6 || bank < 1) {
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
                System.out.println("| 5. Sua Conta           |");
                System.out.println("| 6. Deslogar            |");
                System.out.println("+========================+");
                bank = sc.nextInt();
                switch (bank) {
                    case 1: bankApp.Balance(); break;
                    case 2: bankApp.Withdraw(); break;
                    case 3: bankApp.Deposit(); break;
                    case 4: bankApp.Transfer(); break;
                    case 5: bankApp.Account(); break;
                    case 6: Main main = new Main(); main.OptionsLogin(); break;
                    default: System.out.println("Opção invalida");
                }
            } catch (InputMismatchException e) { sc.nextLine(); System.out.println("Você só pode colocar Números!!"); }
        }
    }
}
