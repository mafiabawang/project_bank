public class Transaksi {
    private String tanggal;
    private double jumlah;
    public Transaksi(String tanggal, double jumlah){
        this.tanggal = tanggal;
        this.jumlah = jumlah;
    }

    @Override
    public String toString() { return tanggal + " : " + jumlah; }
}