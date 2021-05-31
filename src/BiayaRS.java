import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class BiayaRS {
    private JPanel BiayaRS;
    private JTextField tfnama;
    private JTextField tfharga;
    private JTextField tfjmlhari;
    private JTextField textHasil;
    private JButton CEKButton;
    private JButton BATALButton;
    private JButton KELUARButton;
    private JComboBox<String> cbkamar;
    private JTextArea textTamp;
    private JTextArea textnb;
    int harga;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cek Biaya Rawat Inap Pasien");
        frame.setContentPane(new BiayaRS().BiayaRS);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public BiayaRS() {
        cbkamar.addItem("Pilih Kamar");
        cbkamar.addItem("Umum");
        cbkamar.addItem("Kelas I");
        cbkamar.addItem("Kelas II");
        cbkamar.addItem("Kelas III");
        cbkamar.addItem("VIP");
        cbkamar.addItem("ICU");

        CEKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tfnama.getText().equals("") || !tfjmlhari.getText().equals("")) {
                    Data data = new Data();
                    int Harga = data.getHarga();
                    int Hari = data.getHari();
                    int Hasil = data.getHasil();

                    Harga = Integer.parseInt(tfharga.getText());
                    Hari = Integer.parseInt(tfjmlhari.getText());
                    Hasil = Harga * Hari;

                    if (Hasil <= 0) {
                        textTamp.setText("Pasien atas nama " + tfnama.getText()
                                + "\ntidak memiliki tanggungan apapun di Rumah Sakit ini \nkarena pasien tidak dirawat inap. Terimakasih.");
                    } else {
                        textTamp.setText("Pasien atas nama " + tfnama.getText() + "\nsejauh ini memiliki tanggungan biaya \nsebesar Rp" + Hasil + ". Terimakasih.");
                    }
                    textHasil.setText(String.valueOf(Hasil));
                } else {
                    textTamp.setText("Field tidak boleh kosong!");
                }
            }
        });
        BATALButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfnama.setText("");
                cbkamar.setSelectedIndex(0);
                tfharga.setText("");
                tfjmlhari.setText("");
                textHasil.setText("");
                textTamp.setText("");
            }
        });
        KELUARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        tfnama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = tfnama.getText();
            }
        });

        cbkamar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kamar = (String) cbkamar.getSelectedItem();
                switch (kamar) {
                    case "Pilih Kamar":
                        textTamp.setText("");
                        break;
                    case "Umum":
                        textTamp.setText("");
                        harga = 150000;
                        tfharga.setText(String.valueOf(harga));
                        break;
                    case "Kelas I":
                        textTamp.setText("");
                        harga = 750000;
                        tfharga.setText(String.valueOf(harga));
                        break;
                    case "Kelas II":
                        textTamp.setText("");
                        harga = 650000;
                        tfharga.setText(String.valueOf(harga));
                        break;
                    case "Kelas III":
                        textTamp.setText("");
                        harga = 250000;
                        tfharga.setText(String.valueOf(harga));
                        break;
                    case "VIP":
                        textTamp.setText("");
                        harga = 1500000;
                        tfharga.setText(String.valueOf(harga));
                        break;
                    case "ICU":
                        textTamp.setText("");
                        harga = 1250000;
                        tfharga.setText(String.valueOf(harga));
                        break;
                }
            }
        });

        tfjmlhari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hari = Integer.parseInt(tfjmlhari.getText());
                if(hari<0){
                    tfjmlhari.setEditable(false);
                }
                else{
                    tfjmlhari.setEditable(true);
                }

            }
        });
        textnb.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                textnb.setText("Perhatian! Harga kamar untuk \nsetiap ruang adalah sama.");
                super.componentResized(e);
            }
        });
    }
}
