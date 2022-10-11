package model.bank;

import model.data.Bank;
import model.data.Registration;
import model.saving.Saving;
import java.util.Scanner;

import static model.data.Bank.*;
import static model.data.Registration.*;


public class Program {

    private final Scanner sc = new Scanner(System.in);
    private final application.Program main = new application.Program();
    private final Bank BankData = new Bank();
    private final Registration RegistrationData = new Registration();
    private static final double balance = getBalance();
    public static double transfer;

    public void balance() {

        System.out.println();
        System.out.printf("Saldo atual: %.2f", getBalance());
        System.out.print(" reais");
        sc.nextLine();
        main.OptionsBank();
    }
    public void withdraw() {

        System.out.println();
        System.out.println("Quanto deseja sacar?");
        System.out.println();
        System.out.println("+========================+");
        System.out.println("|        Sacar -         |");
        System.out.println("|       Valores          |");
        System.out.println("+========================+");
        System.out.println("| 1. R$20.00             |");
        System.out.println("| 2. R$50.00             |");
        System.out.println("| 3. R$100.00            |");
        System.out.println("| 4. R$200.00            |");
        System.out.println("| 5. Voltar              |");
        System.out.println("+========================+");
        int valores = sc.nextInt();
        switch (valores) {
            case 1: {
                if (getBalance() >= 10.0) {
                    BankData.withdraw(10.0);
                    System.out.println();
                    System.out.println("R$10.00 Foram sacados com sucesso!");
                } else {
                    System.out.println();
                    System.out.println("Desculpe, mais você não tem R$10.00!");
                }
                System.out.println();
                sc.nextLine();
            }
            case 2: {
                if (getBalance() >= 20.0) {
                    BankData.withdraw(20.0);
                    System.out.println();
                    System.out.println("R$20.00 Foram sacados com sucesso!");
                } else {
                    System.out.println();
                    System.out.println("Desculpe, mais você não tem R$20.00!");
                }
                System.out.println();
                sc.nextLine();
            }
            case 3: {
                if (getBalance() >= 50.0) {
                    BankData.withdraw(50.0);
                    System.out.println();
                    System.out.println("R$50.00 Foram sacados com sucesso!");
                } else {
                    System.out.println();
                    System.out.println("Desculpe, mais você não tem R$50.00!");
                }
                System.out.println();
                sc.nextLine();
            }
            case 4: {
                if (getBalance() >= 100.0) {
                    BankData.withdraw(100.0);
                    System.out.println();
                    System.out.println("R$100.00 Foram sacados com sucesso!");
                } else {
                    System.out.println();
                    System.out.println("Desculpe, mais você não tem R$100.00!");
                }
                System.out.println();
                sc.nextLine();
            }
            case 5: {
                if (getBalance() >= 200.0) {
                    BankData.withdraw(200.0);
                    System.out.println();
                    System.out.println("R$200.00 Foram sacados com sucesso!");
                } else {
                    System.out.println();
                    System.out.println("Desculpe, mais você não tem R$200.00!");
                }
                System.out.println();
                sc.nextLine();
            }
            case 6: main.OptionsBank();
            default: System.out.println("Opção invalida");
        }
        Saving.recordData();
        balance();
    }
    public void deposit() {

        System.out.println();
        System.out.println("Quanto deseja depositar?");
        System.out.println("Valor mínimo de R$20");
        System.out.println();

        double value = sc.nextDouble();
        if (value >= 20.0) {
            BankData.deposit(value);
            System.out.println();
            System.out.printf("R$ %.2f", value);
            System.out.print(" Foram depositados com sucesso!");
            System.out.println();
            sc.nextLine();
        }
        else System.out.println("O valor mínimo é R$20");
        Saving.recordData();
        balance();
    }
    public void transfer() {

        //Adicionará na conta mencionada e irá remover da conta logada.
        System.out.println();
        System.out.println("Para quem deseja transferir?");
        System.out.println("Valor mínimo de R$10");
        System.out.println("Taxa de 0,38% menos ou igual à 100 reais");
        System.out.println("Taxa de 0,5% maior à 100 reais");
        System.out.println("Digite o nome:");
        String account = sc.next();
        String tempaccount = getName();
        double tempbal = getBalance();
        RegistrationData.setRegister("bank");
        RegistrationData.setName(account);
        Saving.readData();

        //Irá testar se tal conta existe.
        if(!getaccount()) {
            System.out.println("Transferencia negada: Pessoa inexistente!");
            RegistrationData.setName(tempaccount);
            Saving.readData();
            System.out.println();
            sc.nextLine();
            System.out.println();
            main.OptionsBank();
        } else {
            System.out.println();
            System.out.println("Quanto deseja transferir?");
            transfer = sc.nextDouble();
            BankData.tax(transfer);
            //Testando se o valor mínimo está certo.
            if (transfer >= 10){
                //Irá ver se ele tem o saldo necessário para essa transferencia.
                System.out.println();
                if (transfer > tempbal) {
                    System.out.println("Transferencia negada: Saldo insuficiente!");
                    RegistrationData.setName(tempaccount);
                    Saving.readData();
                } else {
                    //Adicionando e salvando saldo da pessoa mencionada.
                    BankData.deposit(transfer - getTax());
                    Saving.recordData();

                    //Removendo e salvando saldo da pessoa logada.
                    RegistrationData.setName(tempaccount);
                    Saving.readData();
                    BankData.setBalance(tempbal);
                    BankData.withdraw(transfer);

                    //Terminado e salvando dados.
                    Saving.recordData();
                    System.out.println("Transferencia concluida com sucesso!");
                }
            } else {
                System.out.println("Transferencia negada: Valor mínimo R$10!");
                RegistrationData.setName(tempaccount);
                Saving.readData();
            }
            System.out.println();
            sc.nextLine();
            main.OptionsBank();
        }
    }
    public void Account() {

        System.out.println();
        System.out.println("Informações da conta: ");
        System.out.println("Nome: " + getName());
        System.out.println("Senha: " + getPassword());
        System.out.println("Idade: " + getAge());
        System.out.println("Pais: " + getCountry());
        System.out.println("Saldo: " + balance);
        System.out.println();
        System.out.println("enter...");
        sc.nextLine();
        main.OptionsBank();

    }
}
