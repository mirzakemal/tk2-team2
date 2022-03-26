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

        /* Block inputan */
        Scanner input = new Scanner(System.in);  //membuat object scanner baru
        System.out.println("Masukan nama anda [1-25]:"); //menampilkan perintah input nama
        String nama = input.nextLine(); //menangkap inputan nama
        if(nama.length() < 1 || nama.length() > 25) //melakukan cek apakah jumlahkarakter antara 1- 25
            throw new RuntimeException("Range karakter yang diinput 1-25"); //jika tidak maka ditampilkan pesan error
        System.out.println("Masukan NIM anda [10]:"); //Jika ya, dilanjutkan mengisikan NIM 10 karakter
        String nim = input.nextLine();
        if (nim.length() != 10 ) throw new RuntimeException("NIM harus memiliki 10 karakter"); //Jika tidak 10 karakter akan muncul pesan error

        System.out.println("Masukan sembarang angka [5-20]:"); //Memasukkan angka antara 5-20, angka ini akan digunakan sebagai limit/batas akhir dari perulangan
        int inputAngka = Integer.parseInt(input.nextLine()); //menangkap inputan dalam bentuk string kemudian diubah tipe datanya menjadi int
        if(inputAngka < 5 || inputAngka > 20) throw new RuntimeException("Range angka yang diinput 5-20"); //melakukan pengecekan angka, jika tidak diantara 5-20 akan muncul pesan error

        /* deklarasi variable */
        int prev = 1; //variable untuk fibbonacci
        int next = 1; //variable untuk fibbonacci
        boolean finish = false; //variable perulangan
        int jumlahGenap = 0, jumlahGanjil = 0, jumlahFibonacci = 2; //variabel penampungan
        int totalFibonacci = 0; //variabel penampungan

        //deklarasi ArrayList untuk menampung deret bilangan, ada 3 deret yg akan diisi  genap, ganjil, fibonacci
        ArrayList<Integer> genap = new ArrayList<>();
        ArrayList<Integer> ganjil = new ArrayList<>();
        ArrayList<Integer> fibonacci = new ArrayList<>();

        //memasukkan nilai awal untuk deret fibonacci
        fibonacci.add(prev);
        fibonacci.add(next);

        /* memulai proses perhitungan deret */
        int i = 0; //set variable i (variable perulangan) dengan nilai 0
        do { //memulai perulangan
            i++;
            if(i % 2 == 0 && genap.size() < inputAngka){ // jika i habis di modulus 2 dan panjang dari arrayList genap kurang dari variable inputAngka maka i dimasukkan dalam arrayList genap kemudian ditambah 1
                genap.add(i);
                jumlahGenap+=i;
            }else if(ganjil.size() < inputAngka) { // jika i tidak habis di modulus 2 maka cek apakah arrayList Ganjil panjangnya < inputAngka, jika ya maka i dimasukkan di ArrayList Ganjil kemudian nilai i ditambah 1
                ganjil.add(i);
                jumlahGanjil+=i;
            }
            if(fibonacci.size() < inputAngka){ // melakukan pengecekan apakah fibonacci panjangnya < 20, jika ya
                totalFibonacci = prev + next; // menentukan bilangan selanjutnya dengan menjumlahkan variable prev dan next sehingga didapatkan suku baru
                fibonacci.add(totalFibonacci); //memasukkan hasil penjumlahan (suku baru) ke arrayList fibonacci
                prev = next; // karena fibonacci adalah penjumlahan kedua bilangan sebelumnya, maka kursornya maju, variable prev nilainya sama dengan next
                next = totalFibonacci; // sementara variable next berisi suku baru hasil perhitungan di awal
                jumlahFibonacci += totalFibonacci; // panjang fibbonaci bertambah sebanyak suku baru
            }
            //condition control: jika semua kondisi terpenuhi maka variable finish akan bernilai trua dan perulangan akan berhenti
            if(genap.size() == inputAngka && genap.size() == inputAngka && fibonacci.size() == inputAngka){
                finish = true;
            }
        }
        while (!finish); // akhir dari perulangan

        /* block untuk print hasil perulangan */
        System.out.println(inputAngka + " Bilangan Genap: ");
        System.out.println(genap.toString().substring(1, genap.toString().length() - 1)); //substring() untuk menghilangkan tanda kurung di awal dan akhir deret
        System.out.println("Hasil penjumlahan = " + jumlahGenap);
        System.out.println(inputAngka + " Bilangan Ganjil: ");
        System.out.println(ganjil.toString().substring(1, ganjil.toString().length() - 1));
        System.out.println("Hasil penjumlahan = " + jumlahGanjil);
        System.out.println(inputAngka + " Bilangan Fibonacci: ");
        System.out.println(fibonacci.toString().substring(1, fibonacci.toString().length() - 1));
        System.out.println("Hasil penjumlahan = " + jumlahFibonacci);

        /* block untuk mengulangi proses */
        System.out.println("Apakah anda ingin mengulang [y/t]");
        String ulang = input.nextLine();
        if(ulang.equalsIgnoreCase("y"))setVariable();
    }
}
