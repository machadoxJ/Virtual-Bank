package program;

import info.Bankinfo;
import info.Salving;
import java.util.Scanner;


public class Bank {

    Scanner banco = new Scanner(System.in);
    Main main = new Main();
    private static double saldo = Bankinfo.getSaldo();
    private String tempconta;
    private String conta;

    public void Saldo() {

        System.out.println();
        System.out.printf("Saldo atual: %.2f", Bankinfo.getSaldo(), " reais");
        System.out.println();
        System.out.println("enter...");
        String enter = banco.nextLine();
        main.banco();
    }
    public void Sacar() {

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
        Bankinfo bankinfo = new Bankinfo();
        int v = banco.nextInt();
        Double valor = 0.0;
        switch (v) {
            case 1:
                valor = 10.0;
                bankinfo.retirar(valor);
                System.out.println();
                System.out.println("R$10.00 Foram sacados com sucesso!");
                Salving.gravarInfos();
                Saldo();
            case 2:
                valor = 20.0;
                bankinfo.retirar(valor);
                System.out.println();
                System.out.println("R$20.00 Foram sacados com sucesso!");
                Salving.gravarInfos();
                Saldo();
            case 3:
                valor = 50.0;
                bankinfo.retirar(valor);
                System.out.println();
                System.out.println("R$50.00 Foram sacados com sucesso!");
                Salving.gravarInfos();
                Saldo();
            case 4:
                valor = 100.0;
                bankinfo.retirar(valor);
                System.out.println();
                System.out.println("R$100.00 Foram sacados com sucesso!");
                Salving.gravarInfos();
                Saldo();
            case 5:
                valor = 200.0;
                bankinfo.retirar(valor);
                System.out.println();
                System.out.println("R$200.00 Foram sacados com sucesso!");
                Salving.gravarInfos();
                Saldo();
            case 6: Main main = new Main(); main.inicio(); break;
            default: System.out.println("Opção invalida");
        }

    }
    public void Depositar() {

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
        Bankinfo bankinfo = new Bankinfo();
        int v = banco.nextInt();
        Double valor = 0.0;
        switch (v) {
            case 1:
                valor = 10.0;
                bankinfo.adicionar(valor);
                System.out.println();
                System.out.println("R$10.00 Foram depositados com sucesso!");
                Salving.gravarInfos();
                Saldo();
            case 2:
                valor = 20.0;
                bankinfo.adicionar(valor);
                System.out.println();
                System.out.println("R$20.00 Foram depositados com sucesso!");
                Salving.gravarInfos();
                Saldo();
            case 3:
                valor = 50.0;
                bankinfo.adicionar(valor);
                System.out.println();
                System.out.println("R$50.00 Foram depositados com sucesso!");
                Salving.gravarInfos();
                Saldo();
            case 4:
                valor = 100.0;
                bankinfo.adicionar(valor);
                System.out.println();
                System.out.println("R$100.00 Foram depositados com sucesso!");
                Salving.gravarInfos();
                Saldo();
            case 5:
                valor = 200.0;
                bankinfo.adicionar(valor);
                System.out.println();
                System.out.println("R$200.00 Foram depositados com sucesso!");
                Salving.gravarInfos();
                Saldo();
            case 6: Main main = new Main(); main.inicio(); break;
            default: System.out.println("Opção invalida");
        }
    }
    public void Transferir() {

        System.out.println();
        System.out.println("Quanto deseja transferir?");
        double transferir = banco.nextDouble();
        if (transferir > Bankinfo.getSaldo()) {
            System.out.println();
            System.out.println("Transferencia negada");
            System.out.printf("Você tem apenas: %.2f", saldo, " reais");
        }
        else {
            System.out.println();
            System.out.println("Para quem deseja transferir?");
            System.out.println("Digite o nome:");
            conta = banco.next();
            tempconta = Loggin.getName();
            Loggin loggin = new Loggin();
            Bankinfo bankinfo = new Bankinfo();
            loggin.setRegister("b");
            loggin.setName(conta);
            Salving.lerInfos();

            System.out.println();
            bankinfo.adicionar(transferir);

            System.out.println();
            Salving.gravarInfos();
            loggin.setName(tempconta);

            System.out.println();
            Salving.lerInfos();
            bankinfo.retirar(transferir);

            System.out.println();
            System.out.println("Transferencia concluida com sucesso!");
            System.out.printf("Saldo restante em sua conta: %.2f", Bankinfo.getSaldo(), " reais");
            Salving.gravarInfos();
        }
        System.out.println();
        System.out.println();
        System.out.println("Voltando..");
        main.banco();
    }
    public void Conta() {

        System.out.println();
        System.out.println("Informações da conta: ");
        System.out.print("Nome: " + Loggin.getName());
        System.out.print("Senha: " + Loggin.getPassword());
        System.out.print("Idade: " + Loggin.getAge());
        System.out.print("Pais: " + Loggin.getCountry());
        System.out.print("Saldo: " + Bankinfo.getSaldo());
        System.out.println();
        System.out.println("enter...");
        String enter = banco.nextLine();
        main.banco();

    }
}
