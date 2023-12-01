public class TransaksiSetor extends Transaksi {
    public TransaksiSetor(String tanggal, double jumlah) { super(tanggal, jumlah); }

    @Override
    public String toString() { return super.toString() + " \t=> (+) Setor"; }
}