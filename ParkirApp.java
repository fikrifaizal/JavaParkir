/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkir;

/**
 *
 * @author Asus
 */

import java.util.Scanner;

public class ParkirApp {
    public static void main(String[] args) {
        ParkirMethod well = new ParkirMethod();
        ParkirData cek = new ParkirData();
        Scanner ini = new Scanner(System.in);
        int kode = 0;
        while(kode != 3471){
            well.datang();
            int x = cek.motor();
            int y = cek.mobil();
            
            System.out.println("Silahkan input nomor polisi atau plat nomor anda");
            System.out.print("nomor: ");
            String nomor1 = ini.nextLine();
            String waktu1 = well.tanggal() + " " + well.jam();
            System.out.println("Waktu Sekarang adalah " + waktu1);
            System.out.println("");
            
            int periksa = cek.nopol(nomor1, waktu1);
            if(periksa == 3){
                int jenis = well.jenis();
                
                if(jenis == 1){
                    if(x == 0){
                        System.out.println("Parkir penuh, mohon pergi!");
                        well.enter();
                    }
                    else{
                        cek.login(nomor1, waktu1, jenis);
                    }
                }
                else if(jenis == 2){
                    if(y == 0){
                        System.out.println("Parkir penuh, mohon pergi!");
                        well.enter();
                    }
                    else{
                        cek.login(nomor1, waktu1, jenis);
                    }
                }
            }
        }
    }
}
