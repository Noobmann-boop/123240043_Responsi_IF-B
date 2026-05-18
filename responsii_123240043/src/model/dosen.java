/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lab Informatika
 */
public class dosen {
    private int id;
    private String nama;
    private String nidn;
    
    public dosen (int id, String nama, String nidn ){
        this.id=id;
        this.nama=nama;
        this.nidn=nidn;
        
    }
    public dosen (String nama, String nidn ){
        this.nama=nama;
        this.nidn=nidn;
        
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

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    @Override
    public String toString() {
        return "dosen{id=" + id + ",nama='" + nama + "',nidn='" + nidn + "'}";
    }
}
