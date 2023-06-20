package br.com.carv.carstore.dto;

public class OwnerPostDTO {

    private String name;
    private String type;
    private String contactNumber;

    public OwnerPostDTO() { }

    public OwnerPostDTO(String name, String type, String contactNumber) {
        this.name = name;
        this.type = type;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
