public class User {
    private String idUser, nama, password;
    public User(String idUser, String nama, String password){
        this.idUser = idUser;
        this.nama = nama;
        this.password = password;
    }

    public String getIdUser() { return idUser; }
    public String getNama() { return nama; }
    public String getPassword() { return password; }
}