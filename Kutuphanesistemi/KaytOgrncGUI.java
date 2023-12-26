package Kutuphanesistemi;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class KaytOgrncGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ogrncino;
	private JPasswordField ogrencipass;
	private JTextField txtsoyad;
	private JTextField txtisim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KaytOgrncGUI frame = new KaytOgrncGUI();
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
	public KaytOgrncGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblogrnno = new JLabel("Öğrenci Numarası:");
		lblogrnno.setBounds(151, 237, 137, 27);
		lblogrnno.setFont(new Font("Serif", Font.PLAIN, 17));
		contentPane.add(lblogrnno);
		
		JLabel lblogrpass = new JLabel("Öğrenci Şifresi:");
		lblogrpass.setBounds(151, 120, 129, 27);
		lblogrpass.setFont(new Font("Serif", Font.PLAIN, 17));
		contentPane.add(lblogrpass);
		
		JLabel bilgi = new JLabel("(İlk defa oluşturuyorsanız şifreniz  T.C. kimliğinizin son 3 hanesi.)");
		bilgi.setBounds(151, 275, 405, 39);
		contentPane.add(bilgi);
		
		ogrncino = new JTextField();
		ogrncino.setBounds(291, 240, 186, 27);
		contentPane.add(ogrncino);
		ogrncino.setColumns(10);
		
		ogrencipass = new JPasswordField();
		ogrencipass.setBounds(291, 123, 186, 27);
		contentPane.add(ogrencipass);
		
		txtsoyad = new JTextField();
		txtsoyad.setBounds(291, 199, 186, 27);
		contentPane.add(txtsoyad);
		txtsoyad.setColumns(10);
		
		txtisim = new JTextField();
		txtisim.setBounds(291, 161, 186, 27);
		contentPane.add(txtisim);
		txtisim.setColumns(10);
		
		JLabel lbisim = new JLabel("Öğrenci Adı:");
		lbisim.setBounds(151, 158, 137, 23);
		lbisim.setFont(new Font("Serif", Font.PLAIN, 17));
		contentPane.add(lbisim);
		
		JLabel lblsoyad = new JLabel("Öğrenci Soyadı:");
		lblsoyad.setBounds(151, 199, 139, 27);
		lblsoyad.setFont(new Font("Serif", Font.PLAIN, 17));
		contentPane.add(lblsoyad);
		JButton btnNewButton = new JButton("GERİ");
		btnNewButton.setBounds(101, 374, 110, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI ekran3 = new LoginGUI();
				ekran3.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("İLERİ");
		btnNewButton_1.setBounds(593, 374, 110, 30);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI ekran4 = new LoginGUI();
				ekran4.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Kaydet");
		btnNewButton_2.setBounds(551, 177, 110, 30);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						String isim,soyisim,ogrncno,sql_sorgu;
								isim=txtisim.getText();
								soyisim=txtsoyad.getText();
								ogrncno=ogrncino .getText();
								String sifre2 =new String( ogrencipass.getPassword());
								ResultSet myRs = baglanti2.yap();

								sql_sorgu = "INSERT INTO user (password,isim,soyisim,ogrno) VALUES ("+
								sifre2+ ",'" + isim + "','" + soyisim + "'," + ogrncno + ")";
							;
								baglanti2.ekle(sql_sorgu);
								//System.out.println(sql_sorgu);
							
								
								if (txtisim.getText().length()==0 || txtsoyad.getText().length()==0)
								{
									mesaj.showMsg("Lütfen tüm alanları doldurunuz.");
								}
								else if (ogrncino.getText().length()==0 || ogrencipass.getText().length()==0)
								{
									mesaj.showMsg("Lütfen tüm alanları doldurunuz.");
								}
								else {
									
								}
								
			}});
	
		
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("KAYIT EKRANI");
		lblNewLabel.setBounds(291, 63, 177, 27);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 23));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 751, 500);
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("kutup.png")));
		contentPane.add(lblNewLabel_1);
		
	}
	}
