public class TransaksiTransferInUser extends Transaksi{
    private String dariRek, dariNama;
    public TransaksiTransferInUser(String tanggal, double jumlah, String dariRek, String dariNama) {
        super(tanggal, jumlah);
        this.dariRek = dariRek;
        this.dariNama = dariNama;
    }

    @Override
    public String toString() { return super.toString() + " \t=> (+) Transfer In User " + dariNama + " from " + dariRek; }
}