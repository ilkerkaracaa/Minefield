import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int satir,sutun;
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz !\n");
        System.out.print("Satır sayısını giriniz : ");
        satir = input.nextInt();
        System.out.print("\nSütun sayısını giriniz : ");
        sutun = input.nextInt();
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++){
                System.out.print("- ");
            }
            System.out.println();
        }
        Minefield oyun = new Minefield(satir,sutun);
        oyun.run();
    }
}