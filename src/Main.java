import java.util.Scanner;

public class Main {
    public static int baris;
    public static int kolom;
    public static boolean flag = false;
    public static char pemenang;
    public static Scanner scanner = new Scanner(System.in);

    public static char maps[][] = {
            { '-', '-', '-' },
            { '-', '-', '-' },
            { '-', '-', '-' }
    };

    public static void printfMaps() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.err.print(maps[i][j] + " ");
            }
            System.err.println("");
        }
    }

    public static void gantiMaps(int angka) {
        if (angka % 2 != 0)
            maps[baris - 1][kolom - 1] = 'O';
        else
            maps[baris - 1][kolom - 1] = 'X';
    }

    public static void cekMenag() {

        for (int i = 0; i < 3; i++) {
            if (maps[i][0] != '-' && maps[i][0] == maps[i][1] && maps[i][1] == maps[i][2]) {
                pemenang = maps[i][0];
                flag = true;
            }
            if (maps[0][i] != '-' && maps[0][i] == maps[1][i] && maps[1][i] == maps[2][i]) {
                pemenang = maps[0][i];
                flag = true;
            }
        }

        if (maps[0][0] != '-' && maps[0][0] == maps[1][1] && maps[1][1] == maps[2][2]) {
            pemenang = maps[0][0];
            flag = true;
        }
        if (maps[0][2] != '-' && maps[0][2] == maps[1][1] && maps[1][1] == maps[2][0]) {
            pemenang = maps[0][2];
            flag = true;
        }
    }

    public static void Game() {
        printfMaps();
        int i = 1;
        while (i <= 9 && flag == false) {
            int validasi;

            do {
                validasi = 0;
                if (i % 2 != 0) {
                    System.out.println("Playe 1 [O]");
                    System.out.print("Masukan baris dan kolomnya : ");
                    baris = scanner.nextInt();
                    kolom = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Playe 2 [X]");
                    System.out.print("Masukan baris dan kolomnya : ");
                    baris = scanner.nextInt();
                    kolom = scanner.nextInt();
                    scanner.nextLine();
                }

                if (baris < 1 || baris > 3 || kolom < 1 || kolom > 3) {
                    validasi = 1;
                } else if (maps[baris - 1][kolom - 1] != '-')
                    validasi = 2;

                if (validasi == 1)
                    System.out.println("Masukan koordinat yang benar");
                if (validasi == 2)
                    System.out.println("Koordinat tersebut sudah di isi");

            } while (validasi != 0);
            gantiMaps(i);
            printfMaps();
            cekMenag();
            i++;
        }
        if (pemenang == 'O')
            System.out.println("Pemenangnya adalah player 1");
        else if (pemenang == 'X')
            System.out.println("Pemenangnya adalah player 2");
        else
            System.out.println("Tidak ada yang menang");
    }

    public static void main(String[] args) {
        Game();
    }
}