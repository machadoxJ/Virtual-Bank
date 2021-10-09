package info;

public class Bankinfo {

    public Bankinfo() {

    }

    public static double getSaldo() { return saldo; }

    public void setSaldo(double saldo) {
        Bankinfo.saldo = saldo;
    }

    public void adicionar(double adicionar) {
        saldo += adicionar;
    }

    public void retirar(double retirar) {
        saldo -= retirar;
    }

    public static Double saldo = 0.00;

}
