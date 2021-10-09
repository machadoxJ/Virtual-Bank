package info;

import program.Loggin;


import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Information {

    public Scanner inf = new Scanner(System.in);
    Loggin Loggin = new Loggin();

    private int age = 0;
    private String pais = null;
    private String nome = "nome";
    private String senha = "senha";
    private String rnome = "register";
    private String register = "s";

    public void regist() {
        do {
            if (Objects.equals(nome, senha)) System.out.println("O nome e senha não podem ser iguais!!");
            if (Objects.equals(nome, rnome)) System.out.println("Esse nome já foi registrado!");
            System.out.println("Seu Nome: ");
            nome = inf.nextLine();
            Loggin.setRegister(register);
            Loggin.setName(nome);
            Salving.lerInfos();
            rnome = Loggin.getName();
            System.out.println("Sua senha: ");
            senha = inf.nextLine();
        } while (Objects.equals(nome, senha) || Objects.equals(nome, rnome));

        boolean ida = false;

        while (!ida || age > 100 || age < 8) {
            if (age > 100) {
                System.out.println("Você não pode colocar mais que 100 anos ou menos que 8 anos!!");
            }
            try {
                System.out.println("Sua idade: ");
                age = inf.nextInt();
                ida = true;
            } catch (InputMismatchException e) {
                String erro = inf.nextLine();
                System.out.println("Você só pode colocar Numeros!!");
            }
        }

        int p = 0;
        boolean pai = false;
        while (!pai || p > 3 || p < 1) {
            try {
                System.out.println("Seu pais:");
                System.out.println("1 - Brasil");
                System.out.println("2 - Desativado");
                System.out.println("3 - Desativado");
                p = inf.nextInt();
                pai = true;
                switch (p) {
                    case 1: pais = "Brasil"; break;
                    case 2:
                    case 3: System.out.println("desativado..."); break;
                    default: System.out.println("Opção invalido!!");
                }
            } catch (InputMismatchException e) {
                String erro = inf.nextLine();
                System.out.println("Você só pode colocar Numeros!!");
            }
        }

        Loggin register = new Loggin(age, pais, nome, senha);
    }
}
