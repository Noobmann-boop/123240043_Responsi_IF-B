/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lab Informatika
 */
public class mahasiswa {
    private int id;
    private String nama;
    private String nim;
    private String angkatan;
    
    public mahasiswa(int id, String nama, String nim, String angkatan){
        this.id=id;
        this.nama=nama;
        this.nim=nim;
        this.angkatan=angkatan;
    }
    public mahasiswa(String nama, String nim, String angkatan){
        this.nama=nama;
        this.nim=nim;
        this.angkatan=angkatan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }
    
    @Override
    public String toString() {
        return "mahasiswa{id=" + id + ",nama='" + nama + "',nim='" + nim + "',angkatan='" + angkatan + "'}";
    }
}
