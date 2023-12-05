import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void setorTunai(Scanner scanner, Nasabah nasabah){
        System.out.print("Masukkan nomer poket untuk setor tunai: ");
        Tabungan cekTabungan = nasabah.getTabungan(scanner.next());

        if (cekTabungan != null){
            System.out.print("Masukkan jumlah setoran: ");
            double jumlah = scanner.nextDouble();
            if (jumlah % 50000 == 0) cekTabungan.setor(jumlah);
            else System.out.println("Mohon maaf, setor hanya bisa pada pecahan 50k dan 100k");
        } else { System.out.println("Tabungan dengan nomor rekening tidak ditemukan."); }
    }

    public static void tarikTunai(Scanner scanner, Nasabah nasabah) {
        System.out.print("Masukkan nomer poket untuk tarik tunai: ");
        Tabungan cekTabungan = nasabah.getTabungan(scanner.next());

        if (cekTabungan != null){
            System.out.print("Masukkan jumlah penarikan: ");
            double jumlah = scanner.nextDouble();
            if (jumlah % 50000 == 0) {
                cekTabungan.tarik(jumlah);
                int convertInt = (int) jumlah;
                pecahanUang(convertInt);
            }
            else System.out.println("Mohon maaf, tarik hanya bisa pada pecahan 50k dan 100k");
        } else { System.out.println("Tabungan dengan nomor rekening tidak ditemukan."); }
    }

    public static void pecahanUang(int jml){
        int[] jumlahPecahan = new int[2];
        int[] nilaiPecahan = { 100000, 50000 };

        for (int i = 0; i < nilaiPecahan.length; i++){
            jumlahPecahan[i] = jml / nilaiPecahan[i];
            jml %= nilaiPecahan[i];
        }

        for (int i = 0; i < nilaiPecahan.length; i++)
            System.out.println("Jumlah pecahan uang " + nilaiPecahan[i] + ": " + jumlahPecahan[i]);
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

    public static void cekSaldoKeseluruhan(Nasabah nasabah){
        System.out.println("Saldo keseluruhan " + nasabah.getNama() + " : " + nasabah.cekSaldoKeseluruhan());
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
            System.out.print("Masukkan username penerima: ");
            String usernameTujuan = scanner.next();
            Nasabah nasabahTujuan = bank.getNasabah(usernameTujuan);

            if (nasabahTujuan != null){
                System.out.print("Masukkan nomer poket penerima: ");
                String nomerTujuan = scanner.next();
                Tabungan poketKe = nasabahTujuan.getTabungan(nomerTujuan);

                if (poketKe != null){
                    System.out.print("Masukkan jumlah transfer: ");
                    double jumlah = scanner.nextDouble();
                    poketDari.transferOutUser(poketKe, jumlah, nasabahTujuan.getNama());
                    poketKe.transferInUser(poketDari, jumlah, nasabah.getNama());
                } else { System.out.println("Tabungan dengan nomor rekening " + nomerTujuan + " tidak ditemukan."); }
            } else { System.out.println("Nasabah yang memiliki username " + usernameTujuan + " tidak ditemukan"); }
        } else { System.out.println("Tabungan dengan nomor rekening " + nomerAsal + " tidak ditemukan."); }
    }

    public static void lihatDataNasabah(Bank bank){
        ArrayList<Nasabah> listsNasabah = bank.getListsNasabah();
        System.out.println("Master Data Nasabah");
        System.out.println("-------------------------------------------------");
        System.out.println("| idUser \t\t| Username \t| Nama \t\t\t\t|");
        System.out.println("-------------------------------------------------");
        for (Nasabah nasabah : listsNasabah)
            System.out.println("| " + nasabah.getIdUser() + " \t| " + nasabah.getUsername() + " \t| " + nasabah.getNama() + " \t|");
        System.out.println("-------------------------------------------------");
    }

    public static void lihatDataTabungan(Bank bank){
        ArrayList<Nasabah> listsNasabah = bank.getListsNasabah();
        System.out.println("Master Data Tabungan");
        System.out.println("---------------------------------");
        System.out.println("| Username \t| Nomer Rekening \t|");
        System.out.println("---------------------------------");
        for (Nasabah nasabah : listsNasabah){
            ArrayList<Tabungan> listsTabungan = nasabah.getListsTabungan();
            for (Tabungan tabungan : listsTabungan)
                System.out.println("| " + nasabah.getUsername() + " \t| " + tabungan.getNoRek() + " \t| ");
        }
        System.out.println("---------------------------------");
    }

    private static void tambahNasabah(Scanner scanner, Bank bank){
        System.out.print("Masukkan idUser: ");
        String idUser = scanner.nextLine();
        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();
        System.out.print("Masukkan No Rek: ");
        String noRek = scanner.nextLine();
        bank.tambahNasabah(idUser, username, nama, password, noRek);
    }

    public static void hapusPoket(Scanner scanner, Nasabah nasabah){
        System.out.print("Masukkan nomor poket yang akan dihapus: ");
        String rekTujuan = scanner.nextLine();

        Tabungan tabungan = nasabah.getTabungan(rekTujuan);
        if (tabungan != null){
            if (tabungan.getSaldo() > 0) System.out.println("Mohon maaf rekening ini masih memiliki saldo");
            else nasabah.hapusRek(tabungan);
        } else { System.out.println("Nomer Poket tidak tersedia"); }
    }

    public static void gantiPassword(Scanner scanner, Nasabah nasabah){
        System.out.print("Masukkan Passowrd Lama: ");
        String passwordLama = scanner.nextLine();

        if (nasabah.getPassword().equals(passwordLama)){
            System.out.print("Masukkan Passowrd Baru: ");
            String passwordBaru = scanner.nextLine();
            System.out.print("Konfirmasi Password Baru: ");
            String passKonfirmasi = scanner.nextLine();

            if (passwordBaru.equals(passKonfirmasi)) nasabah.setPassword(passwordBaru);
            else System.out.println("Password tidak sama");
        } else { System.out.println("Passowrd Lama Salah"); }
    }

    public static void gantiProfile(Scanner scanner, Nasabah nasabah){
        System.out.print("Masukkan username baru: ");
        String usernameBaru = scanner.nextLine();
        System.out.print("Masukkan Nama baru: ");
        String namaBaru = scanner.nextLine();

        if (!(nasabah.getUsername().equals(usernameBaru) && nasabah.getNama().equals(namaBaru))) {
            nasabah.setUsername(usernameBaru);
            nasabah.setNama(namaBaru);
        } else System.out.println("Data tidak ada yang berubah");
    }

    public static void hapusNasabah(Scanner scanner, Bank bank){
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        Nasabah cekNasabah = bank.getNasabah(username);

        if (cekNasabah != null){
            if (cekNasabah.cekSaldoKeseluruhan() > 0) System.out.println("Mohon maaf tidak bisa dihapus, karena masih ada saldo di tabungan Nasabah ini");
            else bank.hapusNasabah(cekNasabah);
        }
        else System.out.println("Nasabah dengan username tersebut tidak ada");
    }

    public static void cekMutasiNasabah(Scanner scanner, Bank bank){
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        Nasabah cekNasabah = bank.getNasabah(username);

        if (cekNasabah != null) cekNasabah.cekMutasiRekeningbyUsername(username);
        else System.out.println("Nasabah dengan username tersebut tidak ada");
    }

    private static void adminMenu(Scanner scanner, Bank bank){
        int choice;
        do {
            System.out.println("PILIH MENU");
            System.out.println("1.  TAMBAH NASABAH");
            System.out.println("2.  LIHAT DATA NASABAH");
            System.out.println("3.  LIHAT DATA TABUNGAN");
            System.out.println("4.  HAPUS NASABAH");
            System.out.println("5.  MELIHAT TRANSAKSI BEDASARKAN NASABAH");
            System.out.println("0.  LOGOUT ACCOUNT ADMIN");

            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    tambahNasabah(scanner, bank);
                    break;
                case 2:
                    lihatDataNasabah(bank);
                    break;
                case 3:
                    lihatDataTabungan(bank);
                    break;
                case 4:
                    hapusNasabah(scanner, bank);
                    break;
                case 5:
                    cekMutasiNasabah(scanner, bank);
                case 0:
                    System.out.println("Exit Admin Menu");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (choice != 0);
    }

    private static void nasabahMenu(Scanner scanner, Nasabah nasabah, Bank bank){
        int choice;
        do {
            System.out.println("PILIH MENU");
            System.out.println("1.  SETOR TUNAI");
            System.out.println("2.  TARIK TUNAI");
            System.out.println("3.  CEK SALDO POKET TERTENTU");
            System.out.println("4.  MUTASI POKET TERTENTU");
            System.out.println("5.  CEK SALDO KESELURUHAN");
            System.out.println("6.  TAMBAH POKET");
            System.out.println("7.  TRANSFER ANTAR POKET");
            System.out.println("8.  TRANSFER BEDA USER");
            System.out.println("9.  UPDATE PROFILE");
            System.out.println("10. GANTI PASSWORD");
            System.out.println("11. HAPUS POKET");
            System.out.println("0.  LOGOUT ACCOUNT NASABAH");

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
                    cekSaldoKeseluruhan(nasabah);
                    break;
                case 6:
                    nasabah.tambahTabungan();
                    break;
                case 7:
                    transferAntarPoket(scanner, nasabah);
                    break;
                case 8:
                    transferBedaUser(scanner, nasabah, bank);
                    break;
                case 9:
                    gantiProfile(scanner, nasabah);
                    break;
                case 10:
                    gantiPassword(scanner, nasabah);
                    break;
                case 11:
                    hapusPoket(scanner, nasabah);
                    break;
                case 0:
                    System.out.println("Exit Nasabah Menu");
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
        bank.tambahNasabah("n3122510642", "kebo24", "Brodin Pallapa", "kebo1927", "3122510642001");
        bank.tambahAdmin("a230001","admin", "Brodin", "RasakanAbadi");
        System.out.println("-----Selamat Datang di BANK JAVA-----");
        int choice;
        do {
            System.out.println("1. Admin Login");
            System.out.println("2. Nasabah Login");
            System.out.println("0. Exit");
            System.out.print("Pilih Menu Login: ");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.print("Masukkan username Anda : ");
                    String adminname = scanner.next();
                    System.out.print("Masukkan Password Anda : ");
                    String adminpass = scanner.next();
                    Admin adminLogin = bank.getAdmin(adminname, adminpass);

                    if (adminLogin != null) adminMenu(scanner, bank);
                    else System.out.println("Mohon Maaf Adminname & Adminpass Salah");
                    break;
                case 2:
                    System.out.print("Masukkan username Anda : ");
                    String username = scanner.next();
                    System.out.print("Masukkan Password Anda : ");
                    String password = scanner.next();
                    Nasabah nasabahLogin = bank.getNasabah(username, password);

                    if (nasabahLogin != null) nasabahMenu(scanner, nasabahLogin, bank);
                    else System.out.println("Mohon Maaf Username & Password Salah");
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