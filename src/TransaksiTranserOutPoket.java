public class TransaksiTranserOutPoket extends Transaksi{
    private String tujuanRek;
    public TransaksiTranserOutPoket(String tanggal, double jumlah, String tujuanRek) {
        super(tanggal, jumlah);
        this.tujuanRek = tujuanRek;
    }
    @Override
    public String toString() { return super.toString() + " \t=> (-) Transfer Out Poket to " + tujuanRek; }
}