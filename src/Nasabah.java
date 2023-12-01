import java.util.ArrayList;
public class Nasabah extends User{
    private ArrayList<Tabungan> listsTabungan;
    public Nasabah(String idUser, String nama, String password) {
        super(idUser, nama, password);
        listsTabungan = new ArrayList<>();
    }

    public void tambahTabungan(String noRek){ listsTabungan.add(new Tabungan(noRek)); }
    public Tabungan getTabungan(String noRek){
        for (Tabungan tabungan : listsTabungan) if(tabungan.getNoRek().equals(noRek)) return tabungan;

        return null;
    }

    public void cekMutasiRekening(String noRek){
        Tabungan tabungan = getTabungan(noRek);
        if (tabungan != null){ tabungan.mutasiRekening(); }
        else { System.out.println("Tabungan dengan nomor rekening " + noRek + " tidak ditemukan."); }
    }
}