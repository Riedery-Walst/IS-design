package ru.urfu;
import java.util.Map;
public class Lab3 {
    static double[] V = {5.0, 7.0, 9.0, 11.0};
    static double[] B = {0.0, 2.0, 5.0, 4.0};
    public static double lambda = 1.53;

    public void run() {
        // Выполняем задание 1 и 2
        executeTask1And2();

        // Выполняем задание 3
        executeTask3();
    }

    private void executeTask1And2() {
        double lambda = 1.53;
        int c = 20; //Число целей
        int p = 30; //Кол-во измерений параметра
        int opt = 10; //Кол-во отслеживаемых параметров
        int rpp = 3; //Кол-во расчитываемых параметров по каждой цели
        int in = c * p * opt; //Входные параметры
        System.out.println("Задание 1");
        System.out.println("Количество входных параметров: " + in);
        int out = c * rpp; //Выходные параметры
        System.out.println("Количество выходных параметров: " + out);
        int n2 = in + out; //Суммарное кол-во расчитываемых параметров
        System.out.println("Суммарное кол-во расчитываемых параметров: " + n2);
        double V = 0, B = 0;
        V = (n2 + 2) * ((Math.log(n2 + 2)) / Math.log(2)); //Потенциальный объем программы
        System.out.printf("Потенциальный объем программы: %.2f\n", V);
        B = Math.pow(V, 2) / (3000 * lambda); //Потенциальное кол-во ошибок
        System.out.printf("Потенциальное количество ошибок %.2f\n", B);

        // Задание 2
        double k = 0, N = 0, P = 0, tk = 0, vk = 4, m = 15;
        System.out.println("\nЗадание 2");
        k = n2 / 8;
        if (k > 8) {
            k = n2 / 8 + n2 / (8 * 8);
        }
        System.out.println("Число модулей: " + k);

        N = 220 * k + k * Math.log(k) / Math.log(2);
        System.out.printf("Длина программы: %.2f\n", N);
        V = k * 220 * (Math.log(48) / Math.log(2));
        System.out.printf("Объем ПО: %.2f\n", V);

        P = 3 * N / 8;
        System.out.printf("Количество команд ассамблера: %.2f\n", P);

        tk = 3 * N / (8 * m * vk);
        System.out.printf("Календарное время программирования: %.2f\n", tk);

        B = V / 3000;
        System.out.printf("Потенциальное количество ошибок: %.2f\n", B);
    }

    private void executeTask3() {
        System.out.println("\nЗадание 3");
        System.out.println("c(л,R) = 1 / (л * R)");
        System.out.printf("R0 = %.5f\n", getR(0, 1));
        System.out.printf("R1 = %.5f\n", getR(1, 1));
        System.out.printf("R2 = %.5f\n", getR(2, 1));
        System.out.printf("R3 = %.5f\n", getR(3, 1));
        System.out.printf("R4 = %.5f\n", getR(4, 1));
        System.out.println();
        System.out.println("c(л,R) = 1 / (л + R)");
        System.out.printf("R0 = %.5f\n", getR(0, 2));
        System.out.printf("R1 = %.5f\n", getR(1, 2));
        System.out.printf("R2 = %.5f\n", getR(2, 2));
        System.out.printf("R3 = %.5f\n", getR(3, 2));
        System.out.printf("R4 = %.5f\n", getR(4, 2));
        System.out.println();
        System.out.println("c(л,R) = 1/л + 1/R");
        System.out.printf("R0 = %.5f\n", getR(0, 3));
        System.out.printf("R1 = %.5f\n", getR(1, 3));
        System.out.printf("R2 = %.5f\n", getR(2, 3));
        System.out.printf("R3 = %.5f\n", getR(3, 3));
        System.out.printf("R4 = %.5f\n", getR(4, 3));
        System.out.println();
        System.out.printf("c4 = %.5f\n", getC3(getR(4, 3)));
        double b5 = getC3(getR(4, 3)) * 15;
        System.out.printf("B5 = %.2f\n", b5);
    }

    public static double getC1(double r) {
        return 1.0 / (lambda * r);
    }

    public static double getC2(double r) {
        return 1.0 / (lambda + r);
    }

    public static double getC3(double r) {
        return 1.0 / lambda + 1.0 / r;
    }

    public static double sum(double[] d, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += d[i];
        }
        return sum;
    }

    public static double getSumBC(int n, int type) {
        double s = 0;
        for (int i = n; i > 0; i--) {
            s += getBC(i, type);
        }
        return s;
    }
    public static double getBC(int n, int type) {
        double bc = 0;
        if (type == 1) {
            bc = B[n - 1] / getC1(getR(n - 1, 1));
        } else if (type == 2) {
            bc = B[n - 1] / getC2(getR(n - 1, 2));
        } else if (type == 3) {
            bc = B[n - 1] / getC3(getR(n - 1, 3));
        }
        return bc;
    }

    public static double getR(int n, int type) {
        double r = 1000.0;
        if (n != 0) {
            r = getR(n - 1, type) * Math.abs((1 + (sum(V, n) - getSumBC(n, type)) / 1000));
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println("\nЗапуск Lab3:");
        Lab3 lab3 = new Lab3();
        lab3.run();
    }
}