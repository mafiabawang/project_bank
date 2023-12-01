public class TransaksiTransferInPoket extends Transaksi{
    private String dariRek;
    public TransaksiTransferInPoket(String tanggal, double jumlah, String dariRek) {
        super(tanggal, jumlah);
        this.dariRek = dariRek;
    }

    @Override
    public String toString() { return super.toString() + " \t=> (+) Transfer In Poket From " + dariRek; }
}