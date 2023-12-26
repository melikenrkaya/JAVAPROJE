package Kutuphanesistemi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class OGrsistmGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelim3=new DefaultTableModel();
	Object [] kolonlar= {"Kitap_sayisi","Kitap_ismi","Kitap_turu","Sayfa_sayisi"};
	Object [] satirlar= new Object[4];
	private JTextField textadi;
	private JTextField textField_1;
	private JTextField textadsorgu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OGrsistmGUI frame = new OGrsistmGUI();
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
	public OGrsistmGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		textadsorgu = new JTextField();
		textadsorgu.setBounds(32, 211, 86, 20);
		contentPane.add(textadsorgu);
		textadsorgu.setColumns(10);
		
		JButton btnNewButton = new JButton("Kitap Listesini Göster");
		btnNewButton.setBounds(32, 144, 167, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelim3.setRowCount(0);
				ResultSet myRs = baglanti.yap();
				
				try {
					while(myRs.next()) {
						satirlar[0]=myRs.getString("Kitap_sayisi");
						satirlar[1]=myRs.getString("Kitap_ismi");
						satirlar[2]=myRs.getString("Kitap_turu");
						satirlar[3]=myRs.getString("Sayfa_sayisi");
						modelim3.addRow(satirlar);
					}
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
				
				table.setModel(modelim3);
			}});
		contentPane.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Kitap Sıra No:");
		lblNewLabel_4.setBounds(596, 100, 100, 15);
		lblNewLabel_4.setFont(new Font("Serif", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_4);
		//contentPane.add(table);
		
		textadi = new JTextField();
		textadi.setBounds(596, 120, 115, 20);
		contentPane.add(textadi);
		textadi.setColumns(10);
		
		btnNewButton.setFont(new Font("Serif", Font.PLAIN, 13));
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(64, 179, 100, 21);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kitap Sıra No", "Kitap İsmi", "Kİtap Türü", "Sayfa Sayısı"}));
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("AL");
		btnNewButton_1.setBounds(596, 152, 110, 30);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kitapsayi,sql_sorgu;
				kitapsayi=textadi.getText();
				baglanti.yap();
				sql_sorgu = "DELETE FROM kitaplar WHERE kitap_sayisi ="+kitapsayi;
				baglanti.sil(sql_sorgu);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Aldığınız kitabı seçtikten sonra almak istiyorsanız kitap al 'a basmanız yeterli olucak.");
		lblNewLabel.setBounds(10, 427, 393, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Bul");
		btnNewButton_2.setBounds(170, 177, 60, 21);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim3.setRowCount(0);
				String sql_sorgu=null;
				String kategori = textadsorgu.getText();
				ResultSet myRs=null;
				int secilen=comboBox.getSelectedIndex(); 
				if(secilen==0) {
					 sql_sorgu="select * from kitaplar where kitap_sayisi like '" + kategori+ "%'";
				}else if(secilen==1) {
					 sql_sorgu="select * from kitaplar where kitap_ismi like '" + kategori+ "%'";
				}
				else if(secilen==2) {
					 sql_sorgu="select * from kitaplar where kitap_turu like '" + kategori+ "%'";
				}
				else if(secilen==3) {
					 sql_sorgu="select * from kitaplar where sayfa_sayisi like '" + kategori+ "%'";
				}
				
				myRs=baglanti.sorgula(sql_sorgu);
				try {
					while(myRs.next()) {
						satirlar[0]=myRs.getString("Kitap_sayisi");
						satirlar[1]=myRs.getString("Kitap_ismi");
						satirlar[2]=myRs.getString("Kitap_turu");
						satirlar[3]=myRs.getString("Sayfa_sayisi");
						modelim3.addRow(satirlar);
					}
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
				
				table.setModel(modelim3);
		}
			
		});
		
			

		btnNewButton_2.setFont(new Font("Serif", Font.PLAIN, 13));
		contentPane.add(btnNewButton_2);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 38, 337, 279);
		contentPane.add(scrollPane);
		modelim3.setColumnIdentifiers(kolonlar);
		
		table = new JTable();
		
		table.setModel(modelim3);
		table.setBounds(44, 150, 152, 45);
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Kategori:");
		lblNewLabel_1.setBounds(10, 179, 61, 16);
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Çıkış");
		btnNewButton_3.setBounds(386, 386, 110, 30);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI ekran4 = new LoginGUI();
				ekran4.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Geri");
		btnNewButton_4.setBounds(272, 386, 110, 30);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgrnGUI ekran4 = new OgrnGUI();
				ekran4.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 741, 500);
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("a4.png")));
		contentPane.add(lblNewLabel_2);
		
		
		
		
		
		
		//contentPane.add(table);
	}
}
