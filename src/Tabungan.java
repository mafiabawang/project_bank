import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class Tabungan {
    private String noRek;
    private double saldo;
    private ArrayList<Transaksi> listsTransaksi;
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
    String formattedDate = currentDate.format(formatter);
    public Tabungan(String noRek){
        this.noRek = noRek;
        this.saldo = 0;
        listsTransaksi = new ArrayList<>();
    }

    public String getNoRek() { return noRek; }
    public double getSaldo() { return saldo; }

    public void setor(double jumlah){
        saldo += jumlah;
        listsTransaksi.add(new TransaksiSetor(formattedDate, jumlah));
    }

    public void tarik(double jumlah){
        if (saldo >= jumlah){
            saldo -= jumlah;
            listsTransaksi.add(new TransaksiTarik(formattedDate, jumlah));
        } else { System.out.println("Saldo tidak mencukupi"); }
    }

    public void transferInPoket(Tabungan poket, double jumlah){
        saldo += jumlah;
        listsTransaksi.add(new TransaksiTransferInPoket(formattedDate, jumlah, poket.getNoRek()));
    }

    public void transferOutPoket(Tabungan poket, double jumlah){
        if (saldo >= jumlah){
            saldo -= jumlah;
            listsTransaksi.add(new TransaksiTransferOutPoket(formattedDate, jumlah, poket.getNoRek()));
        } else { System.out.println("Saldo tidak mencukupi"); }
    }

    public void transferInUser(Tabungan poket, double jumlah, String fromRek){
        saldo += jumlah;
        listsTransaksi.add(new TransaksiTransferInUser(formattedDate, jumlah, poket.getNoRek(), fromRek));
    }

    public void transferOutUser(Tabungan poket, double jumlah, String toRek){
        if (saldo >= jumlah){
            saldo -= jumlah;
            listsTransaksi.add(new TransaksiTransferOutUser(formattedDate, jumlah, poket.getNoRek(), toRek));
        } else { System.out.println("Saldo tidak mencukupi"); }
    }

    public void mutasiRekening() {
        System.out.println("Mutasi Rekening " + noRek + ":");
        for (Transaksi transaksi : listsTransaksi){ System.out.println(transaksi); }
    }
}