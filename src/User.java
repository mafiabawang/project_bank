public class User {
    private String idUser, username, nama, password;
    public User(String idUser, String username, String nama, String password){
        this.idUser = idUser;
        this.username = username;
        this.nama = nama;
        this.password = password;
    }

    public String getIdUser() { return idUser; }
    public String getUsername(){ return username; }
    public String getNama() { return nama; }
    public String getPassword() { return password; }

    public void setNama(String nama) { this.nama = nama; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
}