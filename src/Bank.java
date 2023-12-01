import java.util.ArrayList;
public class Bank {
    private ArrayList<Nasabah> listsNasabah;
    public Bank() { listsNasabah = new ArrayList<>(); }

    public void tambahNasabah(String idUser, String username, String nama, String password, String noRek){ listsNasabah.add(new Nasabah(idUser, username, nama, password, noRek)); }

    public Nasabah getNasabah(String username, String password){ // validasi login Nasabah
        for (Nasabah nasabah : listsNasabah)
            if (nasabah.getUsername().equals(username) && nasabah.getPassword().equals(password))
                return nasabah;

        return null;
    }

    public Nasabah getNasabah(String username){
        for (Nasabah nasabah : listsNasabah)
            if (nasabah.getUsername().equals(username))
                return nasabah;

        return null;
    }
}