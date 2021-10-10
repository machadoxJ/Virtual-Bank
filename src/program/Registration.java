package program;

import information.RegisterInfo;
import information.DataInfo;
import information.RegistrationInfo;

import java.util.Objects;
import java.util.Scanner;

import static information.RegistrationInfo.*;


public class Registration {

    private final Scanner sc = new Scanner(System.in);
    private final Main main = new Main();

    public void startRegister() {
        String finish;
        do {
            RegisterInfo info = new RegisterInfo();
            System.out.println();
            System.out.println("----------Register----------");
            info.Register();
            System.out.println();
            System.out.println("----------Dados----------");
            System.out.println("Seu nome: " + getName());
            System.out.println("Sua senha: " + getPassword());
            System.out.println("Seu pais: " + getCountry());
            System.out.println("Sua idade: " + getAge());
            System.out.println();
            System.out.println("----------Dados----------");
            System.out.println("Deseja finalizar o cadastro?");
            System.out.println("Digite 's'!");
            finish = sc.nextLine();
        } while (finish.equals("n"));
        DataInfo.recorddata();
        System.out.println("Cadastro feito!!");
        main.OptionsBank();
    }

    public void startLogin() {
        RegistrationInfo registerinfo = new RegistrationInfo();
        String register = "login";
        String password;
        int attempts = 0;
        do {
            System.out.println();
            System.out.println("----------Login----------");
            System.out.println("Nome: ");
            registerinfo.setName(sc.nextLine());
            registerinfo.setRegister(register);

            //Testará se a conta está bloqueada.
            String testblock = "block" + getName();
            DataInfo.readInfo();
            if (Objects.equals(getName(), testblock)) {
                System.out.println();
                System.out.println("Essa conta está Bloqueada!!");
                startLogin();
            }

            System.out.println();
            System.out.println("Senha: ");
            password = sc.nextLine();

            //Verá se a senha é verdadeira.
            if (password.equals(information.RegistrationInfo.getPassword())) {
                System.out.println();
                System.out.println("Nome e senha válidos");
            }
            //Mostrará opções para a senha invalida.
            else {
                attempts++;
                System.out.println();
                System.out.println("Nome ou senha inválidos");
                if (attempts == 3 || attempts == 4) {
                    System.out.println();
                    System.out.println("Deseja mudar de senha?");
                    System.out.println("Digite 's'!");
                    register = sc.nextLine();
                    if (Objects.equals(register, "s")) {
                        System.out.println();
                        System.out.println("Responda duas perguntas:");

                        //Testará se ele sabe a idade colocada no registramento.
                        System.out.println();
                        System.out.println("Qual a idade foi colocada no registro?");
                        int age = sc.nextInt();
                        if (age != information.RegistrationInfo.getAge()) {
                            System.out.println();
                            System.out.println("A idade inserida está incorreta!");
                            System.out.println("Conta bloqueada!!!");
                            registerinfo.setName("bloqueada" + getName());
                            DataInfo.recorddata();
                            startLogin();
                        }

                        //Testará se ele sabe o país colocado no registramento.
                        System.out.println();
                        System.out.println("Qual o país foi colocado no registro?");
                        String country = sc.nextLine();
                        if (!country.equals(getCountry())) {
                            System.out.println();
                            System.out.println("O país inserido está incorreto!");
                            System.out.println("Conta bloqueada!!!");
                            String nameblock = "bloqueada" + getName();
                            registerinfo.setBlock("y");
                            registerinfo.setNameBlock(nameblock);
                            DataInfo.recorddata();
                            startLogin();
                        }

                        //Mudará a senha da conta registrada.
                        System.out.println();
                        System.out.println("Coloque sua nova senha desejada!");
                        registerinfo.setPassword(sc.nextLine());
                        startLogin();
                    }
                } else if (attempts > 4 && attempts < 10) {
                    System.out.println();
                    System.out.println("Deseja voltar?");
                    System.out.println("Digite 's'!");
                    register = sc.nextLine();
                    if (Objects.equals(register, "s")) {
                        System.out.println();
                        System.out.println("Voltando...");
                        main.OptionsLogin();
                    }
                } else if (attempts >= 10) {
                    System.out.println("Sua conta acabou de ser Bloqueada!!");
                    String nameblock = "bloqueada" + getName();
                    registerinfo.setBlock("y");
                    registerinfo.setNameBlock(nameblock);
                    DataInfo.recorddata();
                    startLogin();
                }
            }
        } while (password.equals(information.RegistrationInfo.getPassword()));
        System.out.println();
        System.out.println("Login feito!!");
        main.OptionsBank();
    }
}
