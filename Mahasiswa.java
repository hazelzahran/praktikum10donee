public class Mahasiswa {
    private String nama;
    private String tglLahir;
    private String noPendaftaran;
    private String noTelp;
    private String alamat;
    private String email;

    public Mahasiswa(String nama, String tglLahir, String noPendaftaran,
                     String noTelp, String alamat, String email) {
        this.nama = nama;
        this.tglLahir = tglLahir;
        this.noPendaftaran = noPendaftaran;
        this.noTelp = noTelp;
        this.alamat = alamat;
        this.email = email;
    }

    public String getDataLengkap() {
        return String.format("Nama       : %s\nTgl Lahir  : %s\nNo. Daftar : %s\nNo. Telp   : %s\nAlamat     : %s\nE-mail     : %s",
                             nama, tglLahir, noPendaftaran, noTelp, alamat, email);
    }
}
