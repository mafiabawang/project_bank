import java.util.Scanner;
public class Main {
    public static void setorTunai(Scanner scanner, Nasabah nasabah){
        System.out.print("Masukkan nomer poket untuk setor tunai: ");
        Tabungan cekTabungan = nasabah.getTabungan(scanner.next());

        if (cekTabungan != null){
            System.out.print("Masukkan jumlah setoran: ");
            cekTabungan.setor(scanner.nextDouble());
        } else { System.out.println("Tabungan dengan nomor rekening tidak ditemukan."); }
    }

    public static void tarikTunai(Scanner scanner, Nasabah nasabah) {
        System.out.print("Masukkan nomer poket untuk tarik tunai: ");
        Tabungan cekTabungan = nasabah.getTabungan(scanner.next());

        if (cekTabungan != null){
            System.out.print("Masukkan jumlah penarikan: ");
            cekTabungan.tarik(scanner.nextDouble());
        } else { System.out.println("Tabungan dengan nomor rekening tidak ditemukan."); }
    }

    public static void cekSaldoPoket(Scanner scanner, Nasabah nasabah){
        System.out.print("Masukkan nomer poket untuk cekSaldo: ");
        Tabungan cekTabungan = nasabah.getTabungan(scanner.next());

        if (cekTabungan != null){
            System.out.println("Saldo Akhir: " + cekTabungan.getSaldo());
        } else { System.out.println("Tabungan dengan nomor rekening tidak ditemukan."); }
    }

    public static void cekMutasiPoket(Scanner scanner, Nasabah nasabah){
        System.out.print("Masukkan nomer poket untuk melihat history: ");
        nasabah.cekMutasiRekening(scanner.next());
    }

    public static void main(String[] args){
        System.out.println("-----Selamat Datang di BANK JAVA-----");
        Scanner scanner = new Scanner(System.in);
        Nasabah nasabah = new Nasabah("n3122510641", "Yaafi Effendi", "kambing1927");
        nasabah.tambahTabungan("3122510641001");

        int choice;
        do {
            System.out.println("PILIH MENU");
            System.out.println("1. SETOR TUNAI");
            System.out.println("2. TARIK TUNAI");
            System.out.println("3. CEK SALDO POKET TERTENTU");
            System.out.println("4. MUTASI POKET TERTENTU");
            System.out.println("0. KELUAR");

            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    setorTunai(scanner, nasabah);
                    break;
                case 2:
                    tarikTunai(scanner, nasabah);
                    break;
                case 3:
                    cekSaldoPoket(scanner, nasabah);
                    break;
                case 4:
                    cekMutasiPoket(scanner, nasabah);
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan layanan BANK JAVA.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (choice != 0);
    }
}