import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        printMenu();
        
        try (Scanner scanner = new Scanner(System.in)) {
            int menu = scanner.nextInt();
            
            while (menu != 7) {
                switch (menu) {
                    case 1 -> {
                        System.out.print("n = ");
                        int n = scanner.nextInt();
                        countOdd(n);
                    }
                    case 2 -> {
                        System.out.print("n = ");
                        int n = scanner.nextInt();
                        printStairs(n);
                    }
                    case 3 -> {
                        System.out.print("n = ");
                        int n = scanner.nextInt();
                        removeOdd(n);
                    }
                    case 4 -> {
                        System.out.print("Masukkan jumlah porsi: ");
                        int n = scanner.nextInt();
                        int[] bill = new int[n];
                        for (int i = 0; i < n; i++) {
                            System.out.print("Masukkan biaya porsi ke-" + (i + 1) + ": ");
                            bill[i] = scanner.nextInt();
                        }
                        System.out.print("Masukkan nomor porsi yang tidak dimakan: ");
                        int k = scanner.nextInt();
                        System.out.print("Masukkan biaya yang harus dibayar: ");
                        int b = scanner.nextInt();
                        splitBill(n, bill, k, b);
                    }
                    case 5 -> {
                        System.out.print("n = ");
                        int n = scanner.nextInt();
                        printNumbers(n);
                    }
                    case 6 -> {
                        System.out.print("Masukkan deret angka: ");
                        scanner.nextLine();
                        String str = scanner.nextLine();
                        summaryRandom(str);
                    }
                    default -> System.out.println("Menu tidak valid");
                }
                
                System.out.println();
                printMenu();
                menu = scanner.nextInt();
            }
            System.out.println("Terima kasih!");
        }
        
    }

    public static void printMenu() {
        System.out.println("1. Count Odd");
        System.out.println("2. Print Stairs");
        System.out.println("3. Remove Odd");
        System.out.println("4. Split Bill");
        System.out.println("5. Print Numbers");
        System.out.println("6. Summary Random");
        System.out.println("7. Exit");
        System.out.print("Pilih menu: ");
    }
    
    /**
     * Menghitung Bilangan Ganjil
     * Diberikan sebuah angka “n”, buatlah deret angka acak sebanyak “n” buah 
     * dan hitunglah summary dari nilai ganjil.
     * 
     * Constraints: -100 <= n <= 100
     */
    public static void countOdd(int n) {
        int sum = 0;
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            int rand = (int) (Math.random() * 100);
            list[i] = rand;
            if (rand % 2 != 0) {
                sum += rand;
            }
        }

        System.out.println("list = " + Arrays.toString(list));
        System.out.println("sum = " + sum);
        
    }

    /**
     * Menampilkan anak tangga
     * Buatlah sebuah kode untuk menampilkan anak tangga rata kanan
     * berukuran “n” menggunakan # dan spasi.
     * 
     * Constraints: 0 < n < 100
     */
    public static void printStairs(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    /**
     *  Menghilangkan angka pada posisi ganjil
     * Diberikan sebuah angka “n”, buatlah deret angka acak sebanyak “n” 
     * dan buang lah nilai yang ada pada posisi ganjil.
     * 
     * Constraints: -100 <= n <= 100
     */
    public static void removeOdd(int n) {
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            int rand = (int) (Math.random() * 100);
            list[i] = rand;
        }

        System.out.println("list = " + Arrays.toString(list));

        ArrayList<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((i+1) % 2 == 0) {
                evenList.add(list[i]);
            }
        }

        System.out.println("result = " + evenList);
    }

    /**
     *  Membagi Biaya Bayar
     * Asep and Rudi sedang makan siang di kantin, rudi memesan ‘n’ porsi makanan. Mereka
     * akan membagi 2 biaya yang harus dibayar hanya untuk masakan yang mereka makan.
     * Rudi bertugas untuk menghitung biaya yang harus Asep keluarkan. Anda harus
     * memastikan bahwa biaya yang diminta oleh rudi kepada asep sudah benar.
     * 
     * Sebagai contoh, asumsikan biaya masakan untuk 3 porsi makanan adalah [2, 4, 6], Asep
     * tidak memakan makanan yang ke - 2 yang bernilai k = bill[2] = 6. Jika perhitungan rudi
     * benar asep harus membayar sebesar b=[2+4]/2 = 3. Jika Rudi memasukkan biaya
     * makanan ke-2 maka perhitungannya (2+4+6) /2 = 6. Dalam kasus ke 2, rudi harus
     * mengembalikan 3 kepada Asep.
     * 
     * Contoh Input Format:
     * n = 3
     * bill = [2, 4, 6]
     * k = 2
     * b = 6
     * 
     * Contoh Output Format:
     * - Jika perhitungan rudi benar, maka tampilkan “Bon Appetit”
     * - Jika tidak, tampilkan selisih biaya yang harus dikembalikan oleh rudi kepada asep.
     */
    public static void splitBill(int n, int[] bill, int k, int b) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i != k) {
                sum += bill[i];
            }
        }

        int half = sum / 2;
        if (half == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println("Kembalian: " + (b - half));
        }
    }

    /**
     *  Menampilkan Deret Angka
     * Buatlah kode pemrograman untuk menampilkan deret angka 
     * yang tertera di bawah sebanyak nilai yang diinput oleh user.
     * 
     * Jika user memasukkan nilai 10, maka buatlah deret angka
     * sebanyak 10 angka ke samping
     * 
     * Contoh Output Format:
     * Deret 1: 0 1 4 9 16 25 36 49 64 81 100 dst…
     * Deret 2: 1 2 5 10 17 26 37 50 65 82 dst…
     * Deret 3: 0 1 1 2 3 5 8 13 21 34 55 dst…
     * Deret 4: 0 0 1 2 4 7 12 20 33 54 dst…
     */
    public static void printNumbers(int n) {
        int[] deret1 = new int[n];
        int[] deret2 = new int[n];
        int[] deret3 = new int[n];
        int[] deret4 = new int[n];

        for (int i = 0; i < n; i++) {
            deret1[i] = i * i;
            deret2[i] = i * (i + 1) - i + 1;
            deret3[i] = fibonacci(i);
            deret4[i] = fibonacciModified(i);
        }

        System.out.println("Deret 1: " + Arrays.toString(deret1));
        System.out.println("Deret 2: " + Arrays.toString(deret2));
        System.out.println("Deret 3: " + Arrays.toString(deret3));
        System.out.println("Deret 4: " + Arrays.toString(deret4));
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static int fibonacciModified(int n) {
        if (n <= 1) {
            return 0;
        }
        int a = 0, b = 0;
        for (int i = 2; i <= n; i++) {
            int temp = a + b + 1;
            a = b;
            b = temp;
        }
        return b;
    }

    /**
     * Summary nilai random
     * Diberikan sebuah string deret angka acak oleh user berisi
     * huruf dan angka dipisahkan oleh spasi dan koma, hitunglah nilai2 berikut:
     * - Nilai total dari deret angka
     * - Nilai terbesar
     * - Nilai terkecil
     * - Nilai rata-rata
     * 
     * Contoh Input Format:
     * str = "20,21, 80a,21, 5d5, 31 22, b1j11, 324 213”
     * 
     * Contoh Output Format:
     * deret = 20 + 21 + 80 + 21+ 55 + 31 + 22 + 111 + 324 + 213
     * sum = 798
     * max = 324
     * min = 20
     * avg = 79.8
     */
    public static void summaryRandom(String str) {
        String[] tempArr = str.split("[, ]+");  
    
        List<Integer> numbers = new ArrayList<>();
        for (String element : tempArr) {
            String num = element.replaceAll("[^0-9-]", ""); 
            if (!num.isEmpty()) {
                numbers.add(Integer.valueOf(num));
            }
        }
    
        if (numbers.isEmpty()) {
            System.out.println("Tidak ada angka valid dalam string.");
            return;
        }
    
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
    
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                sb.append(" + ");
            }
            sum += numbers.get(i);
            max = Math.max(max, numbers.get(i));
            min = Math.min(min, numbers.get(i));
        }
    
        double avg = (double) sum / numbers.size();
        
        System.out.println("Deret angka: " + sb.toString());
        System.out.println("Nilai total dari deret angka: " + sum);
        System.out.println("Nilai terbesar: " + max);
        System.out.println("Nilai terkecil: " + min);
        System.out.println("Nilai rata-rata: " + avg);
    }
}    
    
