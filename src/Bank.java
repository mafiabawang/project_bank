import java.util.ArrayList;
public class Bank {
    private ArrayList<Nasabah> listsNasabah;
    private ArrayList<Admin> listsAdmin;
    public Bank() {
        listsNasabah = new ArrayList<>();
        listsAdmin = new ArrayList<>();
    }

    public void tambahNasabah(String idUser, String username, String nama, String password, String noRek){
        listsNasabah.add(new Nasabah(idUser, username, nama, password, noRek));
    }

    public void tambahAdmin(String idUser, String username, String nama, String password){
        listsAdmin.add(new Admin(idUser, username, nama, password));
    }

    public Nasabah getNasabah(String username, String password){ // validasi login Nasabah
        for (Nasabah nasabah : listsNasabah)
            if (nasabah.getUsername().equals(username) && nasabah.getPassword().equals(password))
                return nasabah;

        return null;
    }

    public Admin getAdmin(String username, String password){ // validasi login Admin
        for (Admin admin : listsAdmin)
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password))
                return admin;

        return null;
    }

    public Nasabah getNasabah(String username){ // validasi nasabah ketika transfer beda user
        for (Nasabah nasabah : listsNasabah)
            if (nasabah.getUsername().equals(username))
                return nasabah;

        return null;
    }

    public ArrayList<Nasabah> getListsNasabah() { return listsNasabah; }
    public void hapusNasabah(Nasabah nasabah){ listsNasabah.remove(nasabah); }
}