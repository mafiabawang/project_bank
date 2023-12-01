public class TransaksiTransferOutUser extends Transaksi{
    private String tujuanRek, tujuanNama;
    public TransaksiTransferOutUser(String tanggal, double jumlah, String tujuanRek, String tujuanNama) {
        super(tanggal, jumlah);
        this.tujuanRek = tujuanRek;
        this.tujuanNama = tujuanNama;
    }

    @Override
    public String toString() { return super.toString() + " \t=> (-) Transfer Out User " + tujuanNama + " to " + tujuanRek; }
}