/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkir;

import java.util.Scanner;
import setParkir.*;

/**
 *
 * @author Asus
 */

public class ParkirData {
    Scanner in = new Scanner(System.in);
    kode code = new kode();
    durasi waktu = new durasi();
    String[][] motor = new String[20][3];
    int[] motor2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    String[][] mobil = new String[5][3];
    int[] mobil2 = {0,0,0,0,0};
    ParkirMethod well = new ParkirMethod();
    int kapaMotor = 20;
    int kapaMobil = 5;
    
    int nopol(String polisi, String jam){
        int min = 0;
        int x = 0;
        for(int i = 0; i < 20; i++){
            if(polisi.equals(motor[i][0])){
                System.out.println("Nomor Polisi cocok");
                well.cek(motor[i][2]);
                System.out.print("Tipe\t\t: motor\n");
                well.keluar(motor[i][0], motor[i][1], motor2[i], 1);
                motor2[i] = 0;
                kapaMotor += 1;
                break;
            }
            else if(polisi.equals(mobil[min][0])){
                System.out.println("Nomor Polisi cocok");
                well.cek(mobil[min][2]);
                System.out.print("Tipe\t\t: mobil\n");
                well.keluar(mobil[min][0], mobil[min][1], mobil2[min], 2);
                mobil2[min] = 0;
                kapaMobil += 1;
                break;
            }
            else if(polisi.equals("3471")){
                int dicek = 0;
                int ngecek;
                for(int j = 0; j < 19; j++){
                    ngecek = well.cekExit(mobil2[min], motor2[j]);
                    dicek += ngecek;
                }
                well.exit(dicek);
                break;
            }
            else{
                if(min < 4){
                    min++;
                }
                else{
                    x = 3;
                }
            }
        }
        return x;
    }
    void login(String polisi, String jam, int jenis){
        int ulangan = 0;
        String kode = code.kode();
        if(jenis == 2){
            for(int n = 0; n < 5; n++){
                if(mobil2[n] == 0){
                    well.printCode(kode);
                    mobil[n][0] = polisi;
                    mobil[n][1] = jam;
                    mobil[n][2] = kode;
                    mobil2[n] = waktu.timeBegin();
                    kapaMobil -= 1;
                    break;
                }
            }
        }
        else if(jenis == 1){
            for(int n = 0; n < 20; n++){
                if(motor2[n] == 0){
                    well.printCode(kode);
                    motor[n][0] = polisi;
                    motor[n][1] = jam;
                    motor[n][2] = kode;
                    motor2[n] = waktu.timeBegin();
                    kapaMotor -= 1;
                    break;
                }
            }
        }
    }
    
    int motor(){
        System.out.println("Parkir motor = " + kapaMotor);
        return kapaMotor;
    }
    
    int mobil(){
        System.out.println("Parkir mobil = " + kapaMobil);
        return kapaMobil;
    }
}
