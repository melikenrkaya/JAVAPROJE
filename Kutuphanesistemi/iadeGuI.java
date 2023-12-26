package Kutuphanesistemi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class iadeGuI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textsira;
	private JTextField textadi;
	private JTextField textsure;
	private JTextField textsayfsyi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iadeGuI frame = new iadeGuI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public iadeGuI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblsırası = new JLabel("Kitap No:");
		lblsırası.setFont(new Font("Serif", Font.PLAIN, 18));
		lblsırası.setBounds(207, 110, 110, 24);
		contentPane.add(lblsırası);
		
		JLabel lbladi = new JLabel("Kitap Adı:");
		lbladi.setFont(new Font("Serif", Font.PLAIN, 18));
		lbladi.setBounds(207, 152, 93, 24);
		contentPane.add(lbladi);
		
		JLabel lbltur = new JLabel("Kitap Türü:");
		lbltur.setFont(new Font("Serif", Font.PLAIN, 18));
		lbltur.setBounds(207, 190, 93, 24);
		contentPane.add(lbltur);
		
		JLabel lblsayfsayi = new JLabel("Sayfa Sayısı:");
		lblsayfsayi.setFont(new Font("Serif", Font.PLAIN, 18));
		lblsayfsayi.setBounds(207, 233, 93, 24);
		contentPane.add(lblsayfsayi);
		
		textsira = new JTextField();
		textsira.setBounds(321, 110, 150, 27);
		contentPane.add(textsira);
		textsira.setColumns(10);
		
		textadi = new JTextField();
		textadi.setBounds(321, 152, 150, 27);
		contentPane.add(textadi);
		textadi.setColumns(10);
		
		textsure = new JTextField();
		textsure.setBounds(321, 190, 150, 27);
		contentPane.add(textsure);
		textsure.setColumns(10);
		
		textsayfsyi = new JTextField();
		textsayfsyi.setBounds(321, 234, 150, 27);
		contentPane.add(textsayfsyi);
		textsayfsyi.setColumns(10);
		
		JButton btnNewButton = new JButton("İade Et");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kitapsayi,kitapismi,kitapturu,sayfasayi,sql_sorgu;
				kitapsayi=textsira.getText();
				kitapismi=textadi.getText();
				kitapturu=textsure.getText();
				sayfasayi=textsayfsyi.getText();
				baglanti.yap();
				sql_sorgu = "INSERT INTO kitaplar (Kitap_sayisi,Kitap_ismi,Kitap_turu,Sayfa_sayisi) VALUES("+kitapsayi+ ",'" + kitapismi + "'," + "'" + kitapturu + "'," + "" + sayfasayi + ")";
				baglanti.ekle(sql_sorgu);
	}
});
		btnNewButton.setBounds(320, 289, 110, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ÇIKIŞ YAP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI ekran= new LoginGUI();
				ekran.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(543, 410, 110, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("GERİ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgrnGUI ekran= new OgrnGUI();
				ekran.setVisible(true);
				setVisible(false);
			
			}
		});
		btnNewButton_2.setBounds(107, 410, 110, 30);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("KİTAP İADE EKRANI");
		lblNewLabel.setForeground(new Color(128, 0, 64));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 25));
		lblNewLabel.setBounds(207, 29, 264, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(getClass().getResource("a3.png")));
		lblNewLabel_4.setBounds(0, -2, 741, 500);
		contentPane.add(lblNewLabel_4);
		
		
	}
}
