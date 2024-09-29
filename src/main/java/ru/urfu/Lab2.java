package ru.urfu;

import java.util.ArrayList;
import java.util.Arrays;

public class Lab2 {
    public static Double getDivSum(double m, double n) {
        int i = 1;
        double sum = 0;
        while (i <= n) {
            sum = sum + (1 / (m - i));
            i++;
        }
        return sum;
    }

    public static Integer getSum(ArrayList<Integer> list) {
        int n = list.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.valueOf(list.get(i));
        }
        return sum;
    }

    public static Integer getSumWithI(ArrayList<Integer> list) {
        int n = list.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.valueOf(list.get(i) * (i + 1));
        }
        return sum;
    }

    // Запуск
    public void run() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(9, 12, 11, 4, 7, 2, 5, 8, 5, 7, 1, 6, 1, 9, 4, 1, 3, 3, 6, 1, 11, 33, 7, 91, 2, 1));
        int n = list.size();
        double sumX = getSum(list);
        double sumIX = getSumWithI(list);
        double A = sumIX / sumX;

        if (A <= (n + 1) / 2) {
            System.out.println("Решения нет");
        } else {
            int i = n + 1;
            double fn = getDivSum(i, n);
            double gn = n / (i - A);
            while (fn > gn) {
                i = i + 1;
                fn = getDivSum(i, n);
                gn = n / (i - A);
            }

            System.out.println("Сумма X = " + sumX);
            System.out.println("Сумма iX = " + sumIX);

            double B = i - 2;
            System.out.printf("Общее число ошибок в программе B = %.2f\n", B);

            double K = n / ((B + 1) * sumX - sumIX);
            System.out.printf("Коэффициент пропорциональности K = %.9f\n", K);

            double xn1 = 1 / (K * (B - n));
            System.out.printf("Среднее время до появления следующей ошибки = %.2f\n", xn1);

            double tk = getDivSum(6, 5) / K;
            System.out.printf("Время до окончания тестирования = %.2f\n", tk);
        }
    }
}
