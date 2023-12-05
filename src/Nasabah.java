import java.math    .BigInteger;
import java.util.ArrayList;
public class Nasabah extends User{
    private ArrayList<Tabungan> listsTabungan;
    private int pin, tries;
    private double totalSaldo;
    private boolean isBlokir;
    public Nasabah(String idUser, String username, String nama, String password, String noRek) {
        super(idUser, username, nama, password);
        listsTabungan = new ArrayList<>();
        listsTabungan.add(new Tabungan(noRek));
    }

    public void tambahTabungan(){
        BigInteger convertInt = new BigInteger(cekNoRek()).add(BigInteger.ONE);
        listsTabungan.add(new Tabungan(convertInt.toString()));
    }
    public Tabungan getTabungan(String noRek){
        for (Tabungan tabungan : listsTabungan) if(tabungan.getNoRek().equals(noRek)) return tabungan;

        return null;
    }

    public double cekSaldoKeseluruhan(){
        totalSaldo = 0;
        for (Tabungan tabungan : listsTabungan) totalSaldo += tabungan.getSaldo();
        return totalSaldo;
    }

    public void cekMutasiRekening(String noRek){
        Tabungan tabungan = getTabungan(noRek);
        if (tabungan != null){ tabungan.mutasiRekening(); }
        else { System.out.println("Tabungan dengan nomor rekening " + noRek + " tidak ditemukan."); }
    }

    public String cekNoRek(){ return listsTabungan.get(listsTabungan.size() - 1).getNoRek(); } //untuk fitur otomatis penambahan Rekening
    public void hapusRek(Tabungan tabungan){ listsTabungan.remove(tabungan); }
    public ArrayList<Tabungan> getListsTabungan() { return listsTabungan; }

    public void cekMutasiRekeningbyUsername(String username){
        if (getUsername().equals(username)){
            System.out.println("Mutasi Rekening untuk Nasabah " + getNama() + ":");
            System.out.println("=========================");
            for (Tabungan tabungan : listsTabungan){
                System.out.println("=========================");
                tabungan.mutasiRekening();
                System.out.println("=========================");
            }
            System.out.println("=========================");
        } else { System.out.println("Username Tidak ada"); }
    }
}