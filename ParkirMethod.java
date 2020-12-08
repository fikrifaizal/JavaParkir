/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkir;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import setParkir.*;

/**
 *
 * @author Fikri
 */

public class ParkirMethod {
    Scanner string = new Scanner(System.in);
    Scanner integer = new Scanner(System.in);
    durasi lama = new durasi();
    
    private static String currency(int duit){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(localeID);
        return formatter.format(duit);
    }
    
    void datang(){
        System.out.print("Selamat datang di Taman Parkir UIN SUKA\n*Maksimal lama parkir adalah 24 jam");
        System.out.print("*Tarif dua jam pertama motor adalah Rp2.000,00 dan Tarif selanjutnya Rp500,00 per jam\n");
        System.out.print("*Tarif dua jam pertama mobil adalah Rp5.000,00 dan Tarif selanjutnya Rp1.000,00 per jam\n");
        System.out.println("*Kapasitas parkir adalah 20 motor dan 5 mobil\n");
    }
    
    void enter(){
        System.out.print("tekan enter...");
        String enter = string.nextLine();
        System.out.println("=================================================================================\n");
    }
    
    int jenis(){
        int pilih=0;
        for(int i = 0; i < 100; i++){
            System.out.println("Pilih tipe kendaraan: (Isi angka 1 atau 2)");
            System.out.print("1. Motor\n2. Mobil\ntipe: ");
            pilih = integer.nextInt();
            if(pilih == 1){
                break;
            }
            else if(pilih == 2){
                break;  
            }
            else{
                System.out.println("Input yang anda masukan salah");
            }
        }
        return pilih;
    }
    
    void printCode(String kode){
        System.out.println("=================================================================================");
        System.out.println("Kode anda: " + kode);
        enter();
    }
    
    protected String tanggal(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    protected String jam(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    int harga(int jam, int tipe){
        int bayar = 0;
        if(tipe == 1){
            bayar += 5000;
            if(jam >= 2){
                bayar += 1000*jam;
            }
        }
        else if(tipe == 2){
            bayar += 2000;
            if(jam >= 2){
                bayar += 500*jam;
            }
        }
        return bayar;
    }
    
    void cek(String cek){
        for(int i = 0; i < 1000; i ++){
            System.out.print("Masukkan kode: ");
            String kode = string.nextLine();
            if(kode.equals(cek)){
                System.out.println("-✓-Kode benar-✓-");
                break;
            }
            else{
                System.out.println("---Kode salah, mohon diulangi---");
            }
        }
    }
    
    int cekExit(int mobil, int motor){
        int tambah = 0;
        for(int i = 0; i < 20; i++){
            if(mobil != 0){
                tambah++;
            }
        }
        for(int i = 0; i < 19; i++){
            if(motor != 0){
                tambah++;
            }
        }
        return tambah;
    }
    
    void exit(int kendaraan){
        if(kendaraan > 0){
            System.out.print("Tidak bisa menutup sistem, ");
            System.out.println("Masih terdapat kendaraan yang terparkir");
            System.out.println("=================================================================================\n");
            
        }
        else{
            System.out.println("\n\nSistem akan berhenti\nTerima kasih");
            System.exit(0);
        }
    }
    
    int denda(int waktu){
        int fine = 1000;
        if(waktu > 24){
            int fine2 = waktu - 24;
            fine += 500*fine2;
        }
        else if(waktu == 24){
            fine = 1000;
        }
        else{
            fine = 0;
        }
        return fine;
    }
    
    void keluar(String nopol, String jam, int parkir, int tipe){
        String waktu2 = tanggal() + " " + jam();
        
        int hour = lama.jam(parkir);
        int minute = lama.menit(parkir);
        
        System.out.println("Nomor polisi\t: " + nopol.toUpperCase());
        System.out.println("Waktu masuk\t: " + jam);
        System.out.println("Waktu keluar\t: " + waktu2);
        System.out.println("Durasi parkir\t: " + hour + " jam " + minute + " menit");
        System.out.println("Biaya parkir\t: " + currency(harga(hour, tipe)));
        
        if(hour > 24){
            System.out.println("Waktu parkir anda melebihi batas waktu");
            System.out.println("Anda dikenai denda sebesar " + currency(denda(hour)));
        }
        else if(hour == 24){
            System.out.println("Waktu parkir anda melebihi batas waktu");
            System.out.println("Anda dikenai denda sebesar " + currency(denda(hour)));
        }
        else{
            System.out.println("");
        }
        
        int x = harga(hour, tipe) + denda(hour);
        System.out.println("Total biaya\t: " + currency(x));
        System.out.println("=================================================================================");
        enter();
    }
    
}
