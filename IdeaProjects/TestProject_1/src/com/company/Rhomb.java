package com.company;

import java.io.*;

class Rhomb {
    public static void main(String[] args) throws Exception {

        System.out.print("Введите целое положительное число и нажмите Enter: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sSize = reader.readLine();
        int size = Integer.parseInt(sSize);

        System.out.println(""); // Отступ)

        // Вариант для нечётного числа
        // задаем массив и забиваем его значениями *
        char [][] x = new char [size][size];
        for (int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                x[a][b] = 'x';
            }
        }

        //Забиваем маленький массив нулями
        int n = size / 2;
        char [][] zagotovka = new char [n][n];
        char [][] triangleI = new char [n][n];
        for (int c = 0; c < n; c++) {
            for (int d = 0; d < n; d++) {
                zagotovka[c][d] = '0';
                triangleI[c][d] = zagotovka[c][d]; // начинаем работать с I треугольником
            }
        }

        //Получаем треугольник для I четверти
        for (int e = 0; e < n; e++) {
            for (int f = 0; f < e; f++) {
                triangleI[e][f] = 'x';
            }
        }

        //Меняем I четверть массива
        for (int k = 0; k < n; k++) {
            for (int l = n+1; l < size; l++) {
                x[k][l] = triangleI[k][l-n-1];
            }
        }

        //Задаём треугольник для III четверти. По факту - это транспонирование I.
        char[][] triangleIII = new char[n][n];
        for (int o = 0; o < n; o++) {
            for (int p = 0; p < n; p++) {
                triangleIII[o][p] = triangleI[p][o];
            }
        }

        //Меняем III четверть массива
        for (int r = n+1; r < size; r++) {
            for (int s = 0; s < n; s++) {
                x[r][s] = triangleIII[r-n-1][s];
            }
        }

        char[][] triangleIV = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                zagotovka[i][j] = 'x';
                triangleIV[i][j] = zagotovka[i][j]; // начинаем работать с IV треугольником. Забиавем x-ми
            }
        }

        //Получаем треугольник для IV четверти
        for (int g = n-1; g >= 0; g--) {
            for (int h = n-1; h >= n-g-1 ; h--) {
                triangleIV[g][h] = '0';
            }
        }

        //Меняем IV четверть массива
        for (int k = n+1; k < size; k++) {
            for (int l = n+1; l < size; l++) {
                x[k][l] = triangleIV[k-n-1][l-n-1];
            }
        }

        //Транспонируем IV треугольник в треугольник II
        char[][] triangleII = new char[n][n];
        for (int o = 0; o < n; o++) {
            for (int p = 0; p < n; p++) {
//                System.out.print(o);
//                System.out.print(p + " = ");
//                System.out.print(n-1 - o);
//                System.out.println(n-1 - p);
                triangleII[o][p] = triangleIV[n-1-o][n-1-p];
            }
        }

//        //Проверка. Выводим треугольник.
//        for (int t = 0; t < n; t++) {
//            for (int u = 0; u < n; u++) {
//                System.out.print(triangleII[t][u]);
//            }
//            System.out.println("");
//        }
//        System.out.println("");

        //Меняем II четверть массива
        for (int v = 0; v < n; v++) {
            for (int w = 0; w < n; w++) {
                x[v][w] = triangleII[v][w];
            }
        }

        //Вывод финальной картинки
        for (int t = 0; t < size; t++) {
            for (int u = 0; u < size; u++) {
                System.out.print(x[t][u]);
            }
            System.out.println("");
        }
    }
}
