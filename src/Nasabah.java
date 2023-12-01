import java.util.ArrayList;
public class Nasabah extends User{
    private ArrayList<Tabungan> listsTabungan;
    private double totalSaldo = 0;
    public Nasabah(String idUser, String username, String nama, String password, String noRek) {
        super(idUser, username, nama, password);
        listsTabungan = new ArrayList<>();
        listsTabungan.add(new Tabungan(noRek));
    }

    public void tambahTabungan(String noRek){ listsTabungan.add(new Tabungan(noRek)); }
    public Tabungan getTabungan(String noRek){
        for (Tabungan tabungan : listsTabungan) if(tabungan.getNoRek().equals(noRek)) return tabungan;

        return null;
    }

    public void cekSaldoKeseluruhan(){
        for (Tabungan tabungan : listsTabungan) totalSaldo += tabungan.getSaldo();
        System.out.println("Saldo keseluruhan " + getNama() + " : " + totalSaldo);
    }

    public void cekMutasiRekening(String noRek){
        Tabungan tabungan = getTabungan(noRek);
        if (tabungan != null){ tabungan.mutasiRekening(); }
        else { System.out.println("Tabungan dengan nomor rekening " + noRek + " tidak ditemukan."); }
    }

    public String getNoRek(){ //untuk fitur otomatis penambahan Rekening
        return listsTabungan.get(0).getNoRek();
    }
}