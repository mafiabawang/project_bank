public class TransaksiTarik extends Transaksi {
    public TransaksiTarik(String tanggal, double jumlah) { super(tanggal, jumlah); }

    @Override
    public String toString() { return super.toString() + " \t=> (-) Tarik"; }
}