package com.company;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Locale;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        setVariable();
    }

    public static void setVariable(){
        // write your code here
        Scanner input = new Scanner(System.in); //object scanner baru
        System.out.println("Masukan nama anda [1-25]:");
        String nama = input.nextLine();
        if(nama.length() < 1 || nama.length() > 25) throw new RuntimeException("Range karakter yang diinput 1-25");
        System.out.println("Masukan NIM anda [10]:");
        String nim = input.nextLine();
        if (nim.length() != 10 ) throw new RuntimeException("NIM harus memiliki 10 karakter");
        System.out.println("Masukan sembarang angka:");
        int inputAngka = Integer.parseInt(input.nextLine());
        if(inputAngka < 5 || inputAngka > 20) throw new RuntimeException("Range angka yang diinput 5-20");
        int prev = 1;
        int next = 1;
        boolean finish = false;
        int jumlahGenap = 0, jumlahGanjil = 0, jumlahFibonacci = 2;
        int totalFibonacci = 0;
        ArrayList<Integer> genap = new ArrayList<>();
        ArrayList<Integer> ganjil = new ArrayList<>();
        ArrayList<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(prev);
        fibonacci.add(next);
        int i = 0;
        do {
            i++;
            if(i % 2 == 0 && genap.size() < 20){
                genap.add(i);
                jumlahGenap+=i;
            }else if(ganjil.size() < 20) {
                ganjil.add(i);
                jumlahGanjil+=i;
            }
            if(fibonacci.size() < 20){
                totalFibonacci = prev + next;
                fibonacci.add(totalFibonacci);
                prev = next;
                next = totalFibonacci;
                jumlahFibonacci += totalFibonacci;
            }
            if(genap.size() == 20 && genap.size() == 20 && fibonacci.size() == 20){
                finish = true;
            }
        }
        while (!finish);
        System.out.println(inputAngka + " Bilangan Genap: ");
        System.out.println(genap.toString().substring(1, genap.toString().length() - 1));
        System.out.println("Hasil penjumlahan = " + jumlahGenap);
        System.out.println(inputAngka + " Bilangan Ganjil: ");
        System.out.println(ganjil.toString().substring(1, ganjil.toString().length() - 1));
        System.out.println("Hasil penjumlahan = " + jumlahGanjil);
        System.out.println(inputAngka + " Bilangan Fibonacci: ");
        System.out.println(fibonacci.toString().substring(1, fibonacci.toString().length() - 1));
        System.out.println("Hasil penjumlahan = " + jumlahFibonacci);
        System.out.println("Apakah anda ingin mengulang [y/t]");
        String ulang = input.nextLine();
        if(ulang.equalsIgnoreCase("y"))setVariable();
    }
}
