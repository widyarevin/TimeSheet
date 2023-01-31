package com.example.Timsheet.DTO;

public class DesignationDTO {
     
    public DesignationDTO(Integer id, String name ){
        Id = id;
        Nama = name;
     }

    private Integer Id;
    private String Nama;

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getNama() {
        return Nama;
    }
    public void setNama(String nama) {
        Nama = nama;
    }
}
