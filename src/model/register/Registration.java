package model.register;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import static model.data.Registration.*;

public class Registration {

    private final Scanner sc = new Scanner(System.in);
    private final model.data.Registration registrationinfo = new model.data.Registration();

    public void register() {
        String name = "nome";
        String password = "senha";
        String registeredname = "register";
        //Irá criar um nome e uma senha.
        do {
            //Caso o nome e a senha sejam iguais.
            if (Objects.equals(name, password)) System.out.println("O nome e senha não podem ser iguais!!");
            //Caso o nome já tenha sido registrado.
            if (Objects.equals(name, registeredname)) System.out.println("Esse nome já foi registrado!");

            System.out.println("Seu Nome: ");
            name = sc.nextLine();

            //Vai ver se o nome já foi registrado
            registrationinfo.setRegister("s");
            registrationinfo.setName(name);
            model.saving.Saving.readData();
            registeredname = getName();

            System.out.println("Sua senha: ");
            password = sc.nextLine();

        } while (Objects.equals(name, password) || Objects.equals(name, registeredname));
        registrationinfo.setName(name);
        registrationinfo.setPassword(password);
        age();
    }
    public void age() {
        boolean erroage = false;
        int age = 0;
        //Irá criar uma idade.
        while (!erroage || age > 80 || age < 8) {
            //Caso a idade for acima de 80 ou menor que 8.
            if (age > 100) System.out.println("Você não pode colocar mais que 100 anos ou menos que 8 anos!!");
            //Caso coloque letra envez de numeros.
            try {
                System.out.println("Sua idade: ");
                age = sc.nextInt();
                erroage = true;
            } catch (InputMismatchException e) { sc.nextLine(); System.out.println("Você só pode colocar Números!!"); }
        }
        registrationinfo.setAge(age);
        country();
    }
    public void country() {
        boolean errocountry = false;
        String country = null;
        int p = 0;
        //Irá criar um pais.
        while (!errocountry || p > 3 || p < 1) {
            //Caso coloque letra envez de numeros.
            try {
                System.out.println("Seu pais:");
                System.out.println("1 - Brasil");
                System.out.println("2 - Chile");
                System.out.println("3 - Argentina");
                p = sc.nextInt();
                errocountry = true;
                switch (p) {
                    case 1: country = "Brasil";
                    case 2: country = "Chile";
                    case 3: country = "Argentina";
                    default: System.out.println("Opção invalido!!");
                }
            } catch (InputMismatchException e) { sc.nextLine(); System.out.println("Você só pode colocar Números!!"); }
        }
        registrationinfo.setCountry(country);
    }
}
