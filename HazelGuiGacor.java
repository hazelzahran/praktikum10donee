import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HazelGuiGacor extends JFrame {
    private JTextField tfNama, tfTglLahir, tfNoPendaftaran, tfNoTelp, tfEmail;
    private JTextArea taAlamat;

    public HazelGuiGacor() {
        setTitle("Form Daftar Ulang Mahasiswa Baru - HazelGuiGacor");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 5, 5));

        tfNama = new JTextField();
        tfTglLahir = new JTextField();
        tfNoPendaftaran = new JTextField();
        tfNoTelp = new JTextField();
        taAlamat = new JTextArea();
        tfEmail = new JTextField();

        JButton btnSubmit = new JButton("Submit");

        add(new JLabel("Nama Lengkap"));
        add(tfNama);
        add(new JLabel("Tanggal Lahir"));
        add(tfTglLahir);
        add(new JLabel("Nomor Pendaftaran"));
        add(tfNoPendaftaran);
        add(new JLabel("No. Telp"));
        add(tfNoTelp);
        add(new JLabel("Alamat"));
        add(new JScrollPane(taAlamat));
        add(new JLabel("E-mail"));
        add(tfEmail);
        add(new JLabel(""));
        add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isFormValid()) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin data yang Anda isi sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        Mahasiswa mhs = new Mahasiswa(
                            tfNama.getText(),
                            tfTglLahir.getText(),
                            tfNoPendaftaran.getText(),
                            tfNoTelp.getText(),
                            taAlamat.getText(),
                            tfEmail.getText()
                        );
                        tampilkanData(mhs);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    private boolean isFormValid() {
        return !tfNama.getText().isEmpty() &&
               !tfTglLahir.getText().isEmpty() &&
               !tfNoPendaftaran.getText().isEmpty() &&
               !tfNoTelp.getText().isEmpty() &&
               !taAlamat.getText().isEmpty() &&
               !tfEmail.getText().isEmpty();
    }

    private void tampilkanData(Mahasiswa mhs) {
        JFrame frame = new JFrame("Data Mahasiswa");
        JTextArea area = new JTextArea(mhs.getDataLengkap());
        area.setEditable(false);
        frame.add(new JScrollPane(area));
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new HazelGuiGacor();
    }
}
