package Kutuphanesistemi;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import Kutuphanesistemi.mesaj;
import java.awt.Toolkit;






public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static String ogrno;
	static String sifre;
	private JPasswordField passfldogrncisifre;
	private JPasswordField passpersonelsifre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */public LoginGUI() {
			setResizable(false);
			setFont(new Font("Dialog", Font.BOLD, 14));
			setTitle("KÜTÜPHANE SİSTEMİ");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 750, 500);
			JPanel w_pane = new JPanel();
			
			w_pane.setBackground(SystemColor.controlHighlight);
			w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(w_pane);
			w_pane.setLayout(null);
			
			JTabbedPane w_tabbpane = new JTabbedPane(JTabbedPane.TOP);
			w_tabbpane.setBounds(32, 137, 635, 244);
			w_pane.add(w_tabbpane);
			
			JPanel panel = new JPanel();
			panel.setLocation(30, 25);
			panel.setForeground(UIManager.getColor("Button.foreground"));
			panel.setBackground(SystemColor.window);
			w_tabbpane.addTab("Öğrenci Girişi", null, panel, null);
			panel.setLayout(null);
			
			JLabel lblogrncno = new JLabel("Öğrenci Numarası:");
			lblogrncno.setBounds(34, 21, 176, 29);
			lblogrncno.setFont(new Font("Serif", Font.PLAIN, 18));
			panel.add(lblogrncno);
			
			JLabel lbogrnsifre = new JLabel("Öğrenci Şifresi:");
			lbogrnsifre.setBounds(34, 58, 176, 29);
			lbogrnsifre.setFont(new Font("Serif", Font.PLAIN, 18));
			panel.add(lbogrnsifre);
			
			JTextField txfldogrncino = new JTextField();
			txfldogrncino.setBounds(176, 24, 326, 29);
			panel.add(txfldogrncino);
			txfldogrncino.setColumns(10);
			
			JButton btnogrngris = new JButton("Giriş");
			btnogrngris.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ogrno = txfldogrncino.getText();
					String sifre = new String(passfldogrncisifre.getPassword());
	
					String sql_sorgu = "select count(password) as giris from user where ogrno ='"+ogrno+
							"' and password = '"+ sifre+"'";
					ResultSet myRs = baglanti2.yap();
					
					myRs=baglanti2.sorgula(sql_sorgu);
	
					if (txfldogrncino.getText().length()==0 || passfldogrncisifre.getText().length()==0)
					{
						mesaj.showMsg("Lütfen tüm alanları doldurunuz.");
					}
					else {
						try {
					while(myRs.next()) {
						if(myRs.getInt("giris")==1) {
							OgrnGUI ekran= new OgrnGUI();
							ekran.setVisible(true);
							setVisible(false);
						}
					
					}}catch(Exception e2) {
						e2.printStackTrace();
					}}
					
				}});
			
			
			
			btnogrngris.setBounds(173, 111, 153, 44);
			btnogrngris.setForeground(SystemColor.textText);
			btnogrngris.setBackground(SystemColor.menu);
			btnogrngris.setFont(new Font("Serif", Font.BOLD, 20));
			panel.add(btnogrngris);
			
			JButton btnKaytOl = new JButton("Kayıt Ol");
			btnKaytOl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ResultSet myRs = baglanti2.yap();
					try {
							KaytOgrncGUI ekran1= new KaytOgrncGUI();
							ekran1.setVisible(true);
							setVisible(false);
					}
					catch (Exception e2) {
							// TODO: handle exception
						e2.printStackTrace();	
					}
				}
			});
			btnKaytOl.setBounds(349, 111, 153, 44);
			btnKaytOl.setForeground(SystemColor.textText);
			btnKaytOl.setFont(new Font("Serif", Font.BOLD, 20));
			btnKaytOl.setBackground(SystemColor.menu);
			panel.add(btnKaytOl);
			
			passfldogrncisifre = new JPasswordField();
			passfldogrncisifre.setBounds(176, 65, 326, 35);
			panel.add(passfldogrncisifre);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(SystemColor.text);
			w_tabbpane.addTab("Personel Girişi", null, panel_1, null);
			panel_1.setLayout(null);
			
			JLabel lblpersnelAd = new JLabel(" Personel T.C. :");
			lblpersnelAd.setFont(new Font("Serif", Font.PLAIN, 18));
			lblpersnelAd.setBounds(25, 24, 176, 29);
			panel_1.add(lblpersnelAd);
			
			passpersonelsifre = new JPasswordField();
			passpersonelsifre.setBounds(163, 64, 326, 29);
			panel_1.add(passpersonelsifre);
			
			JTextField txtfldpersonelad = new JTextField();
			txtfldpersonelad.setColumns(10);
			txtfldpersonelad.setBounds(163, 27, 326, 29);
			panel_1.add(txtfldpersonelad);
			
			JLabel lblPersonelsifre = new JLabel(" Personel Şifresi:");
			lblPersonelsifre.setFont(new Font("Serif", Font.PLAIN, 18));
			lblPersonelsifre.setBounds(25, 64, 176, 29);
			panel_1.add(lblPersonelsifre);
			
			JButton bttnpersonelgiris = new JButton("Giriş");
			bttnpersonelgiris.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String personeltc = txtfldpersonelad.getText();
					String sifre2 =new String( passpersonelsifre.getPassword());
					
					String sql_sorgu = "select count(admin) as giris from idari where tcno ='"+personeltc+
							"' and sifre = '"+ sifre2+"'";
					ResultSet myRs = baglanti3.yap();
					
					myRs=baglanti3.sorgula(sql_sorgu);
					if (txtfldpersonelad.getText().length()==0 || passpersonelsifre.getText().length()==0)
					{
						mesaj.showMsg("Lütfen tüm alanları doldurunuz.");
					}
					else {
						try {
					while(myRs.next()) {
						if(myRs.getInt("giris")==1) {
							PersonelGUI ekran= new PersonelGUI();
							ekran.setVisible(true);
							setVisible(false);
						}
					
					}}catch(Exception e2) {
						e2.printStackTrace();
					}}
					}});
				
			bttnpersonelgiris.setForeground(SystemColor.textText);
			bttnpersonelgiris.setFont(new Font("Serif", Font.BOLD, 20));
			bttnpersonelgiris.setBackground(SystemColor.menu);
			bttnpersonelgiris.setBounds(255, 112, 135, 45);
			panel_1.add(bttnpersonelgiris);
			
		
				
			JLabel lblNewLabel = new JLabel("Kütüphane Otomasyonuna Hoşgeldiniz");
			lblNewLabel.setBounds(147, 78, 446, 34);
			lblNewLabel.setForeground(new Color(220, 20, 60));
			w_pane.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Serif", Font.BOLD, 26));
			
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("a1.png")));
			lblNewLabel_2.setBounds(0, 0, 741, 500);
			w_pane.add(lblNewLabel_2);
		}	
}
		


	