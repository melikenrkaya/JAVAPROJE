package Kutuphanesistemi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class OgrnGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OgrnGUI frame = new OgrnGUI();
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
	public OgrnGUI() {
		setTitle("KÜTÜPHANE ÖĞRENCİ SİSTEMİ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOŞGELDİNİZ");
		lblNewLabel.setBounds(273, 64, 228, 42);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("KİTAP AL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OGrsistmGUI ekran5= new OGrsistmGUI();
				ekran5.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 17));
		btnNewButton.setBounds(29, 196, 171, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("KİTAP İADE ET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iadeGuI ekran6= new iadeGuI();
				ekran6.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Serif", Font.BOLD, 17));
		btnNewButton_1.setBounds(29, 257, 171, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Geri");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI ekran= new LoginGUI();
				ekran.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(29, 403, 110, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Çıkış");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI ekran1= new LoginGUI();
				ekran1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(531, 403, 110, 30);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("a2.png")));
		lblNewLabel_1.setBounds(0, 0, 741, 500);
		contentPane.add(lblNewLabel_1);
	}
}
