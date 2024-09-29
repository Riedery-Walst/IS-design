package ru.urfu;

public class Lab3 {
    public void run() {
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

        //Задание 2
        double k = 0, i = 0, N = 0, P = 0, tn = 0, tk = 0, vk = 4, m = 15;
        System.out.println("\nЗадание 2");
        k = n2 / 8;
        if (k > 8) {
            i = (Math.log(n2) / Math.log(2)) / 3 + 1;
            k = n2 / 8 + n2 / (8 * 8);
            System.out.println("Число модулей: " + k);
        } else {
            System.out.println("Число модулей: " + k);
        }

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

        tn = tk / (2 * Math.log(B)) / 8;
        System.out.println(tn);

        System.out.printf("Начальная надежность ПО: %.2f\n", tn);
    }
}
