package Model;

import java.sql.Date;

public class CMSUser {
    private int ID;
    private String name;
    private String email;
    private String password;
    private String city;
    private Date dateOfAdding;
    private String pictureURL;
    private boolean isAdmin;

    public CMSUser(int ID, String name, String email,
                   String password, String city, Date dateOfAdding,
                   String pictureURL, boolean isAdmin) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.city = city;
        this.dateOfAdding = dateOfAdding;
        this.pictureURL = pictureURL;
        this.isAdmin = isAdmin;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public Date getDateOfAdding() {
        return dateOfAdding;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getRole() {
        if(isAdmin){
            return "Admin";
        }else{
            return "Mentor";
        }
    }
}
