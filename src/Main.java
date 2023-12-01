import java.math.BigInteger;
import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);

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
        System.out.print("Masukkan nomer poket untuk Mutasi: ");
        nasabah.cekMutasiRekening(scanner.next());
    }

    public static void tambahTabungan(Nasabah nasabah){
        BigInteger convertInt = new BigInteger(nasabah.getNoRek()).add(BigInteger.ONE);
        nasabah.tambahTabungan(convertInt.toString());
    }

    public static void transferAntarPoket(Scanner scanner, Nasabah nasabah){
        System.out.print("Masukkan nomer poket asal: ");
        String nomerAsal = scanner.next();
        Tabungan poketDari = nasabah.getTabungan(nomerAsal);

        if (poketDari != null) {
            System.out.print("Masukkan nomer poket penerima: ");
            String nomerTujuan = scanner.next();
            Tabungan poketKe = nasabah.getTabungan(nomerTujuan);

            if (poketKe != null) {
                System.out.print("Masukkan jumlah transfer: ");
                double jumlah = scanner.nextDouble();
                poketDari.transferOutPoket(poketKe, jumlah);
                poketKe.transferInPoket(poketDari,jumlah);
            } else { System.out.println("Tabungan dengan nomor rekening " + nomerTujuan + " tidak ditemukan."); }
        } else { System.out.println("Tabungan dengan nomor rekening " + nomerAsal + " tidak ditemukan."); }
    }

    public static void transferBedaUser(Scanner scanner, Nasabah nasabah, Bank bank){
        System.out.print("Masukkan nomer poket asal: ");
        String nomerAsal = scanner.next();
        Tabungan poketDari = nasabah.getTabungan(nomerAsal);

        if (poketDari != null){
            System.out.print("Masukkan nama Nasabah penerima: ");
            String namaTujuan = scanner.next();
            Nasabah nasabahTujuan = bank.getNasabah(namaTujuan);

            if (nasabahTujuan != null){
                System.out.print("Masukkan nomer poket penerima: ");
                String nomerTujuan = scanner.next();
                Tabungan poketKe = nasabahTujuan.getTabungan(nomerTujuan);

                if (poketKe != null){
                    System.out.print("Masukkan jumlah transfer: ");
                    double jumlah = scanner.nextDouble();
                    poketDari.transferOutUser(poketKe, jumlah, nasabahTujuan);
                    poketKe.transferInUser(poketDari, jumlah, nasabah);
                } else { System.out.println("Tabungan dengan nomor rekening " + nomerTujuan + " tidak ditemukan."); }
            } else { System.out.println("Nasabah yang memiliki username " + namaTujuan + " tidak ditemukan"); }
        } else { System.out.println("Tabungan dengan nomor rekening " + nomerAsal + " tidak ditemukan."); }
    }

    private static void customerMenu(Scanner scanner, Nasabah nasabah, Bank bank){
        int choice;
        do {
            System.out.println("PILIH MENU");
            System.out.println("1. SETOR TUNAI");
            System.out.println("2. TARIK TUNAI");
            System.out.println("3. CEK SALDO POKET TERTENTU");
            System.out.println("4. MUTASI POKET TERTENTU");
            System.out.println("5. CEK SALDO KESELURUHAN");
            System.out.println("6. TAMBAH POKET");
            System.out.println("7. TRANSFER ANTAR POKET");
            System.out.println("8. TRANSFER BEDA USER");
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
                case 5:
                    nasabah.cekSaldoKeseluruhan();
                    break;
                case 6:
                    tambahTabungan(nasabah);
                    break;
                case 7:
                    transferAntarPoket(scanner, nasabah);
                    break;
                case 8:
                    transferBedaUser(scanner, nasabah, bank);
                    break;
                case 0:
                    System.out.println("Exit Customer Menu");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (choice != 0);
    }

    public static void main(String[] args){
        Bank bank = new Bank();
        bank.tambahNasabah("n3122510641", "acid24", "Yaafi Effendi", "kambing1234", "3122510641001");
        bank.tambahNasabah("n3122510642", "kebo24", "Kebo Acid", "kebo1927", "3122510642001");

        Admin admin = new Admin("a230001","admin", "Brodin", "Rasakan Abadi");
        System.out.println("-----Selamat Datang di BANK JAVA-----");
        int choice;
        do {
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    break;
                case 2:
                    System.out.print("Masukkan username Anda : ");
                    String username = scanner.next();
                    System.out.print("Masukkan Password Anda : ");
                    String password = scanner.next();
                    Nasabah nasabahLogin = bank.getNasabah(username, password);

                    if (nasabahLogin != null){
                        customerMenu(scanner, nasabahLogin, bank);
                    } else { System.out.println("Mohon Maaf Username & Password Salah"); }
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan layanan BANK JAVA.");
                    break;
                default:
                    System.out.println("Mohon maaf, harap masukkan input angka positif ");
                    break;
            }
        } while (choice != 0);
    }
}