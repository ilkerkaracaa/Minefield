import java.util.Random;
import java.util.Scanner;

public class Minefield {
    int satir;
    int sutun;

    int acilanKutu = 0;

    int mayinlar = 0;

    Minefield(int satir, int sutun){
        this.satir = satir;
        this.sutun = sutun;
    }

    void run(){
        int[][] gösterenDizi = new int[this.satir][this.sutun];
        int[][] mayinSayaci = new int[this.satir][this.sutun];
        for (int i = 0; i < this.satir; i++){
            for (int j = 0; j < this.sutun; j++){
                gösterenDizi[i][j] = 0;
            }
        }
        for (int i = 0; i < this.satir; i++){
            for (int j = 0; j < this.sutun; j++){
                mayinSayaci[i][j] = 0;
            }
        }
        Scanner input = new Scanner(System.in);
        int[][] anaArray = new int[this.satir][this.sutun];
        for (int i = 0; i < this.satir; i++){
            for (int j = 0; j < this.sutun; j++){
                anaArray[i][j] = 0;
            }
        }

        int[][] mayinArray = new int[this.satir][this.sutun];
        int mayinSayisi = (this.satir * this.sutun)/4;
        Random rand = new Random();
        for (int i = 0; i < mayinSayisi; i++){
            int mayinSatir = 0, mayinSutun = 0;
            mayinSatir = rand.nextInt(this.satir);
            mayinSutun = rand.nextInt(this.sutun);
            if (mayinArray[mayinSatir][mayinSutun] == 1){
                mayinSatir = rand.nextInt(this.satir);
                mayinSutun = rand.nextInt(this.sutun);
            }
            mayinArray[mayinSatir][mayinSutun] = 1;
        }

        for (int i = 0; i < this.satir; i++){
            for (int j = 0; j < this.sutun; j++){
                if (mayinArray[i][j] == 1){
                    anaArray[i][j] = 1;
                }
            }
        }


        boolean kontrol = true;
        while (kontrol){
            System.out.print("=======================================\n");
            /*for (int i = 0; i < this.satir; i++){
                for (int j = 0; j < this.sutun; j++){
                    if (anaArray[i][j] == 1){
                        System.out.print("* ");
                        continue;
                    }
                    System.out.print("- ");
                }
                System.out.println();
            }*/

            int satir, sutun;
            System.out.print("Satır Giriniz : ");
            satir = input.nextInt();
            System.out.print("Sütun Giriniz : ");
            sutun = input.nextInt();
            if (satir < 0 || satir >= this.satir || sutun < 0 || sutun >= this.sutun){
                System.out.println("Hatalı Tuşlama Yaptınız!");
                continue;
            } else {
                if (anaArray[satir][sutun] == 1){
                    gösterenDizi[satir][sutun] = 2;
                    for (int i = 0; i < this.satir; i++){
                        for (int j = 0; j < this.sutun; j++){
                            if (i == satir && j == sutun){
                                System.out.print("M ");
                                continue;
                            } else if (gösterenDizi[i][j] == 1) {
                                System.out.print(mayinSayaci[i][j] + " ");
                                continue;
                            }
                            System.out.print("- ");
                        }
                        System.out.println();
                    }
                    System.out.print("=======================================\n");
                    System.out.println("Game Over!!");
                    System.out.print("=======================================\n");
                    for (int i = 0; i < this.satir; i++) {
                        for (int j = 0; j < this.sutun; j++) {
                            if (anaArray[i][j] == 1) {
                                System.out.print("M ");
                                continue;
                            } else if (gösterenDizi[i][j] == 1){
                                System.out.print(mayinSayaci[i][j] + " ");
                                continue;
                            }
                            System.out.print("- ");
                        }
                        System.out.println();

                        kontrol = false;
                    }
                } else{
                    gösterenDizi[satir][sutun] = 1;
                    int fullMayinSayisi = 0;
                    for (int i = 0; i < this.satir; i++){
                        for (int j = 0; j < this.sutun; j++){
                            if (anaArray[i][j] == 1){
                                fullMayinSayisi++;
                            }
                        }
                    }
                    acilanKutu++;
                    if (acilanKutu == (this.satir*this.sutun)-fullMayinSayisi){
                        int donguMayinn = 0;
                        for (int k = satir -1; k <= satir + 1; k++){
                            for (int n = sutun -1; n <= sutun + 1; n++){
                                if (n == -1){
                                    n++;
                                }

                                if (k == -1){
                                    k++;
                                }
                                if (n == this.sutun){
                                    break;
                                }

                                if (k == anaArray.length){
                                    break;
                                }

                                if (anaArray[k][n] == 1){
                                    donguMayinn++;
                                }
                                mayinlar += donguMayinn;
                                mayinSayaci[satir][sutun] = donguMayinn;
                                /*
                                 * satir = 1
                                 * sutun = 1
                                 * k = 0
                                 * n = 0
                                 */
                            }
                        }
                        System.out.print("=======================================\n");
                        System.out.println("Tebrikler Oyunu Kazandınız !");
                        System.out.print("=======================================\n");
                        for (int i = 0; i < this.satir; i++){
                            for (int j = 0; j < this.sutun; j++){
                                if (anaArray[i][j] == 1){
                                    System.out.print("M ");
                                    continue;
                                } else if (gösterenDizi[i][j] == 1) {
                                    System.out.print(mayinSayaci[i][j] + " ");
                                    continue;
                                }
                            }
                            System.out.println();
                        }
                        kontrol = false;
                        break;
                    }
                    System.out.print("=======================================\n");
                    int donguMayin = 0;
                    for (int i = 0; i < this.satir; i++){
                        for (int j = 0; j < this.sutun; j++){
                            if (i == satir && j == sutun){
                                for (int k = satir -1; k <= satir + 1; k++){
                                    for (int n = sutun -1; n <= sutun + 1; n++){
                                        if (n == -1){
                                            n++;
                                        }

                                        if (k == -1){
                                            k++;
                                        }
                                        if (n == this.sutun){
                                            break;
                                        }

                                        if (k == anaArray.length){
                                            break;
                                        }

                                        if (anaArray[k][n] == 1){
                                            donguMayin++;
                                        }
                                        mayinlar += donguMayin;
                                        mayinSayaci[satir][sutun] = donguMayin;
                                        /*
                                         * satir = 1
                                         * sutun = 1
                                         * k = 0
                                         * n = 0
                                         */
                                    }
                                }
                            }
                        }
                    }



                    /*if (i == satir && j == sutun){
                        System.out.print(donguMayin + " ");
                        continue;
                    }*/

                    for (int i = 0; i < this.satir; i++){
                        for (int j = 0; j < this.sutun; j++){
                            if (gösterenDizi[i][j] == 1){
                                System.out.print(mayinSayaci[i][j] + " ");
                                continue;
                            }
                            System.out.print("- ");
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
