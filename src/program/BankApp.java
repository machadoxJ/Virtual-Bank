package program;

import information.BankInfo;
import information.RegistrationInfo;
import information.DataInfo;
import java.util.Scanner;

import static information.BankInfo.*;
import static information.RegistrationInfo.*;


public class BankApp {

    private final Scanner sc = new Scanner(System.in);
    private final Main main = new Main();
    private final BankInfo bankinfo = new BankInfo();
    private final RegistrationInfo registrationinfo = new RegistrationInfo();
    private static final double balance = getBalance();

    public void Balance() {

        System.out.println();
        System.out.printf("Saldo atual: %.2f", getBalance(), " reais");
        System.out.println();
        System.out.println("enter...");
        sc.nextLine();
        main.OptionsBank();
    }
    public void Withdraw() {

        System.out.println();
        System.out.println("Quanto deseja sacar?");
        System.out.println();
        System.out.println("+========================+");
        System.out.println("|        Sacar -         |");
        System.out.println("|       Valores          |");
        System.out.println("+========================+");
        System.out.println("| 1. R$10.00             |");
        System.out.println("| 2. R$20.00             |");
        System.out.println("| 3. R$50.00             |");
        System.out.println("| 4. R$100.00            |");
        System.out.println("| 5. R$200.00            |");
        System.out.println("| 6. Voltar              |");
        System.out.println("+========================+");
        int valores = sc.nextInt();
        switch (valores) {
            case 1:
                bankinfo.withdraw(10.0);
                System.out.println();
                System.out.println("R$10.00 Foram sacados com sucesso!");
            case 2:
                bankinfo.withdraw(20.0);
                System.out.println();
                System.out.println("R$20.00 Foram sacados com sucesso!");
            case 3:
                bankinfo.withdraw(50.0);
                System.out.println();
                System.out.println("R$50.00 Foram sacados com sucesso!");
            case 4:
                bankinfo.withdraw(100.0);
                System.out.println();
                System.out.println("R$100.00 Foram sacados com sucesso!");
            case 5:
                bankinfo.withdraw(200.0);
                System.out.println();
                System.out.println("R$200.00 Foram sacados com sucesso!");
            case 6: main.OptionsBank(); break;
            default: System.out.println("Opção invalida");
        }
        DataInfo.recorddata();
        Balance();
    }
    public void Deposit() {

        System.out.println();
        System.out.println("Quanto deseja depositar?");
        System.out.println();
        System.out.println("+========================+");
        System.out.println("|      Depositar -       |");
        System.out.println("|       Valores          |");
        System.out.println("+========================+");
        System.out.println("| 1. R$10.00             |");
        System.out.println("| 2. R$20.00             |");
        System.out.println("| 3. R$50.00             |");
        System.out.println("| 4. R$100.00            |");
        System.out.println("| 5. R$200.00            |");
        System.out.println("| 6. Voltar              |");
        System.out.println("+========================+");
        int valores = sc.nextInt();
        switch (valores) {
            case 1:
                bankinfo.add(10.0);
                System.out.println();
                System.out.println("R$10.00 Foram depositados com sucesso!");
            case 2:
                bankinfo.add(20.0);
                System.out.println();
                System.out.println("R$20.00 Foram depositados com sucesso!");
            case 3:
                bankinfo.add(50.0);
                System.out.println();
                System.out.println("R$50.00 Foram depositados com sucesso!");
            case 4:
                bankinfo.add(100.0);
                System.out.println();
                System.out.println("R$100.00 Foram depositados com sucesso!");
            case 5:
                bankinfo.add(200.0);
                System.out.println();
                System.out.println("R$200.00 Foram depositados com sucesso!");
            case 6: Main main = new Main(); main.OptionsBank(); break;
            default: System.out.println("Opção invalida");
        }
        DataInfo.recorddata();
        Balance();
    }
    public void Transfer() {

        System.out.println();
        System.out.println("Quanto deseja transferir?");
        double transfer = sc.nextDouble();
        //Irá ver se ele tem o saldo necessário para essa transferencia.
        if (transfer > getBalance()) {
            System.out.println();
            System.out.println("Transferencia negada");
            System.out.printf("Você tem apenas: %.2f", balance, " reais");
        }
        //Irá adicionar na conta mencionada e irá remover da conta logada.
        else {
            System.out.println();
            System.out.println("Para quem deseja transferir?");
            System.out.println("Digite o nome:");
            String account = sc.next();
            String tempaccount = getName();
            registrationinfo.setRegister("bank");
            registrationinfo.setName(account);
            DataInfo.readInfo();

            //Adicionando e salvando saldo da pessoa mencionada.
            System.out.println();
            bankinfo.add(transfer);
            DataInfo.recorddata();

            //Removendo e salvando saldo da pessoa logada.
            registrationinfo.setName(tempaccount);
            DataInfo.readInfo();
            bankinfo.withdraw(transfer);
            System.out.println("Transferencia concluding com sucesso!");
            System.out.printf("Saldo restante em sua conta é de: %.2f", balance, " reais");
            DataInfo.recorddata();
        }
        System.out.println();
        System.out.println("Voltando...");
        main.OptionsBank();
    }
    public void Account() {

        System.out.println();
        System.out.println("Informações da conta: ");
        System.out.print("Nome: " + getName());
        System.out.print("Senha: " + getPassword());
        System.out.print("Idade: " + getAge());
        System.out.print("Pais: " + getCountry());
        System.out.print("Saldo: " + balance);
        System.out.println();
        System.out.println("enter...");
        sc.nextLine();
        main.OptionsBank();

    }
}
