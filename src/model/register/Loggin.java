package model.register;

import application.Program;
import model.saving.Saving;
import model.data.Registration;

import java.util.Objects;
import java.util.Scanner;

import static model.data.Registration.*;


public class Loggin {

    private final Scanner sc = new Scanner(System.in);
    private final Program main = new Program();

    public void startRegister() {
        String finish;
        do {
            model.register.Registration info = new model.register.Registration();
            System.out.println();
            System.out.println("----------Register----------");
            info.register();
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
        Saving.recordData();
        System.out.println("Cadastro feito!!");
        main.OptionsBank();
    }

    public void startLogin() {
        Registration registerinfo = new Registration();
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
            Saving.readData();
            if (Objects.equals(getName(), testblock)) {
                System.out.println();
                System.out.println("Essa conta está Bloqueada!!");
                startLogin();
            }

            System.out.println("Senha: ");
            password = sc.nextLine();

            //Mostrará opções para a senha invalida.
            if (!password.equals(Registration.getPassword())) {
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
                        if (age != Registration.getAge()) {
                            System.out.println();
                            System.out.println("A idade inserida está incorreta!");
                            System.out.println("Conta bloqueada!!!");
                            registerinfo.setName("block" + getName());
                            Saving.recordData();
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
                            String nameblock = "block" + getName();
                            registerinfo.setBlock("y");
                            registerinfo.setNameBlock(nameblock);
                            Saving.recordData();
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
                    String nameblock = "block" + getName();
                    registerinfo.setBlock("y");
                    registerinfo.setNameBlock(nameblock);
                    Saving.recordData();
                    startLogin();
                }
            }
        //Verá se a senha é verdadeira.
        } while (!password.equals(Registration.getPassword()));
        System.out.println();
        System.out.println("Login feito!!");
        main.OptionsBank();

    }
}
