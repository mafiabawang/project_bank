public class TransaksiTransferOutPoket extends Transaksi{
    private String tujuanRek;
    public TransaksiTransferOutPoket(String tanggal, double jumlah, String tujuanRek) {
        super(tanggal, jumlah);
        this.tujuanRek = tujuanRek;
    }
    @Override
    public String toString() { return super.toString() + " \t=> (-) Transfer Out Poket to " + tujuanRek; }
}