package Kutuphanesistemi;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class PersonelGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelim2=new DefaultTableModel();
	Object [] kolonlar= {"Kitap_sayisi","Kitap_ismi","Kitap_turu","Sayfa_sayisi"};
	Object [] satirlar= new Object[4];
	private JTextField txktpsays;
	private JTextField txtkitapadı;
	private JTextField txtktptur;
	private JTextField txtsayfasysı;
	private JTextField txt_adsorgu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonelGUI frame = new PersonelGUI();
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
	public PersonelGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 131, 359, 251);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim2.setColumnIdentifiers(kolonlar);
		
		table.setModel(modelim2);
	
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.getColumnModel().getColumn(0).setMinWidth(23);
		table.getColumnModel().getColumn(1).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setMinWidth(23);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(2).setMinWidth(23);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setMinWidth(23);
		table.setBounds(127, 88, 297, 162);
		scrollPane.setViewportView(table);
		//contentPane.add(table);
		
		JButton btnListele = new JButton("Listele");
		btnListele.setBounds(452, 131, 175, 29);
		btnListele.setFont(new Font("Serif", Font.BOLD, 20));
		btnListele.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				modelim2.setRowCount(0);
				ResultSet myRs = baglanti.yap();
				
				try {
					while(myRs.next()) {
						satirlar[0]=myRs.getString("Kitap_sayisi");
						satirlar[1]=myRs.getString("Kitap_ismi");
						satirlar[2]=myRs.getString("Kitap_turu");
						satirlar[3]=myRs.getString("Sayfa_sayisi");
						modelim2.addRow(satirlar);
					}
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
				
				table.setModel(modelim2);
			}});
		contentPane.add(btnListele);
		
		
		txktpsays = new JTextField();
		txktpsays.setBounds(541, 171, 86, 20);
		contentPane.add(txktpsays);
		txktpsays.setColumns(10);
		
		txtkitapadı = new JTextField();
		txtkitapadı.setBounds(541, 202, 86, 20);
		contentPane.add(txtkitapadı);
		txtkitapadı.setColumns(10);
		
		txtktptur = new JTextField();
		txtktptur.setBounds(541, 233, 86, 20);
		contentPane.add(txtktptur);
		txtktptur.setColumns(10);
		
		txtsayfasysı = new JTextField();
		txtsayfasysı.setBounds(541, 264, 86, 20);
		contentPane.add(txtsayfasysı);
		txtsayfasysı.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Kİtap Ekle");
		btnNewButton_1.setBounds(452, 309, 104, 21);
		btnNewButton_1.setFont(new Font("Serif", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kitapsayi,kitapismi,kitapturu,sayfasayi,sql_sorgu;
						kitapsayi=txktpsays.getText();
						kitapismi=txtkitapadı.getText();
						kitapturu=txtktptur.getText();
						sayfasayi=txtsayfasysı.getText();
						
						sql_sorgu = "INSERT INTO kitaplar (Kitap_sayisi,Kitap_ismi,Kitap_turu,Sayfa_sayisi) VALUES("+kitapsayi+ ",'" + kitapismi + "'," + "'" + kitapturu + "'," + "" + sayfasayi + ")";
						baglanti.ekle(sql_sorgu);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Güncelle");
		btnNewButton.setBounds(518, 359, 89, 23);
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kitapsayi,kitapismi,kitapturu,sayfasayi,sql_sorgu;
				kitapsayi=txktpsays.getText();
				kitapismi=txtkitapadı.getText();
				kitapturu=txtktptur.getText();
				sayfasayi=txtsayfasysı.getText();
				
				sql_sorgu = "UPDATE kitaplar SET kitap_sayisi =" +kitapsayi+ "," +
						"kitap_ismi ='" + kitapismi + "',kitap_turu ='" + kitapturu + "',sayfa_sayisi =" + sayfasayi + " WHERE kitap_sayisi ="+kitapsayi;
				baglanti.update(sql_sorgu);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("ÇIKIŞ");
		btnNewButton_3.setBounds(88, 415, 89, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI ekran3 = new LoginGUI();
				ekran3.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Kitap Sil");
		btnNewButton_2.setBounds(559, 309, 104, 20);
		btnNewButton_2.setFont(new Font("Serif", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kitapsayi,sql_sorgu;
				kitapsayi=txktpsays.getText();
				sql_sorgu = "DELETE FROM kitaplar WHERE kitap_sayisi ="+kitapsayi;
				baglanti.sil(sql_sorgu);
			}
		});
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Kitap No:");
		lblNewLabel.setBounds(456, 174, 69, 14);
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 12));
		contentPane.add(lblNewLabel);
		
		JLabel lblKitapAd = new JLabel("Kitap Adı\r\n:");
		lblKitapAd.setBounds(456, 205, 69, 14);
		lblKitapAd.setFont(new Font("Georgia", Font.PLAIN, 12));
		contentPane.add(lblKitapAd);
		
		JLabel lblKitapTr = new JLabel("Kitap Türü:\r\n");
		lblKitapTr.setBounds(456, 235, 69, 17);
		lblKitapTr.setFont(new Font("Georgia", Font.PLAIN, 12));
		contentPane.add(lblKitapTr);
		
		JLabel lblSayfa = new JLabel("Sayfa Sayısı:");
		lblSayfa.setBounds(456, 264, 111, 20);
		lblSayfa.setFont(new Font("Georgia", Font.PLAIN, 12));
		contentPane.add(lblSayfa);
		
		txt_adsorgu = new JTextField();
		txt_adsorgu.setBounds(207, 71, 89, 20);
		contentPane.add(txt_adsorgu);
		txt_adsorgu.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Kategori:");
		lblNewLabel_1.setBounds(171, 46, 76, 14);
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(231, 42, 100, 22);
		comboBox.setFont(new Font("Serif", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kitap No", "Kitap İsmi", "Kİtap Türü", "Sayfa Sayısı"}));
		contentPane.add(comboBox);
		
		JButton btnNewButton_4 = new JButton("Sorgula");
		btnNewButton_4.setBounds(207, 97, 89, 23);
		btnNewButton_4.setFont(new Font("Serif", Font.PLAIN, 13));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim2.setRowCount(0);
				String sql_sorgu=null;
				String kategori = txt_adsorgu.getText();
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
						modelim2.addRow(satirlar);
					}
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
				
				table.setModel(modelim2);
		}
			
		});
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 752, 500);
		lblNewLabel_2.setIcon(new ImageIcon((getClass().getResource("arkplan.jpg"))));
		contentPane.add(lblNewLabel_2);
		
		
		
			table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txktpsays.setText((String) modelim2.getValueAt(table.getSelectedRow(), 0));
				txtkitapadı.setText((String) modelim2.getValueAt(table.getSelectedRow(), 1));
				txtktptur.setText((String) modelim2.getValueAt(table.getSelectedRow(), 2));
				txtsayfasysı.setText((String) modelim2.getValueAt(table.getSelectedRow(), 3));
			}
		});
	}
}
