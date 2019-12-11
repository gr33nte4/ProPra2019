package propra.grpproj.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuiMenu {

	private JFrame frame;
	private JTextField tfUserName;
	private JTextField tfPW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMenu window = new GuiMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/**
		 * Inititalize header
		 */	
		JPanel pHeader = new JPanel();
		pHeader.setBackground(new Color(255, 255, 255));
		GridBagLayout gbl_pHeader = new GridBagLayout();
		gbl_pHeader.columnWidths = new int[] {0};
		gbl_pHeader.rowHeights = new int[] {0};
		gbl_pHeader.columnWeights = new double[]{0};
		gbl_pHeader.rowWeights = new double[]{0};
		pHeader.setLayout(gbl_pHeader);

		JLabel lblHeaderDas = new JLabel("Das");
		lblHeaderDas.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblHeaderDas.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblHeaderDas = new GridBagConstraints();
		gbc_lblHeaderDas.insets = new Insets(5, 5, 5, 5);
		gbc_lblHeaderDas.gridx = 0;
		gbc_lblHeaderDas.gridy = 0;
		pHeader.add(lblHeaderDas, gbc_lblHeaderDas);
		
		JLabel lblHeaderKneipenquiz = new JLabel("- Kneipenquiz");
		lblHeaderKneipenquiz.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblHeaderKneipenquiz.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblHeaderKneipenquiz = new GridBagConstraints();
		gbc_lblHeaderKneipenquiz.gridx = 2;
		gbc_lblHeaderKneipenquiz.gridy = 0;
		pHeader.add(lblHeaderKneipenquiz, gbc_lblHeaderKneipenquiz);
								
		JLabel lblHeaderIcon = new JLabel(showLogo());
		lblHeaderIcon.setLabelFor(lblHeaderIcon);
		GridBagConstraints gbc_lblHeaderIcon = new GridBagConstraints();
		gbc_lblHeaderIcon.insets = new Insets(5, 50, 5, 50);
		gbc_lblHeaderIcon.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblHeaderIcon.gridx = 1;
		gbc_lblHeaderIcon.gridy = 0;
		pHeader.add(lblHeaderIcon, gbc_lblHeaderIcon);
		
		
		/**
		 * Initialize loginpanel
		 */
		JPanel pUserLoginInput = new JPanel();
		pUserLoginInput.setBackground(new Color(255, 255, 255));
		
		GridBagLayout gbl_pUserLoginInput = new GridBagLayout();
		gbl_pUserLoginInput.columnWidths = new int[] {0};
		gbl_pUserLoginInput.rowHeights = new int[] {0, 0, 0, 0};
		gbl_pUserLoginInput.columnWeights = new double[]{1.0, 1.0};
		gbl_pUserLoginInput.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		pUserLoginInput.setLayout(gbl_pUserLoginInput);
		
		
		JLabel lblText = new JLabel("Willkommen im Hauptmenue!");
		GridBagConstraints gbc_lblText = new GridBagConstraints();
		gbc_lblText.insets = new Insets(5, 5, 5, 0);
		gbc_lblText.gridwidth = 2;
		gbc_lblText.fill = GridBagConstraints.CENTER;
		gbc_lblText.gridx = 0;
		gbc_lblText.gridy = 0;
		pUserLoginInput.add(lblText, gbc_lblText);

		JLabel lblUserName = new JLabel("Benutzername");
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.anchor = GridBagConstraints.EAST;
		gbc_lblUserName.insets = new Insets(5, 5, 5, 5);
		gbc_lblUserName.gridx = 0;
		gbc_lblUserName.gridy = 1;
		pUserLoginInput.add(lblUserName, gbc_lblUserName);
		
		tfUserName = new JTextField();
		GridBagConstraints gbc_tfUserName = new GridBagConstraints();
		gbc_tfUserName.anchor = GridBagConstraints.WEST;
		gbc_tfUserName.insets = new Insets(5, 5, 5, 5);
		gbc_tfUserName.gridx = 1;
		gbc_tfUserName.gridy = 1;
		pUserLoginInput.add(tfUserName, gbc_tfUserName);
		tfUserName.setColumns(10);
		
		JLabel lblPW = new JLabel("Passwort");
		GridBagConstraints gbc_lblPW = new GridBagConstraints();
		gbc_lblPW.insets = new Insets(5, 5, 5, 5);
		gbc_lblPW.anchor = GridBagConstraints.EAST;
		gbc_lblPW.gridx = 0;
		gbc_lblPW.gridy = 2;
		pUserLoginInput.add(lblPW, gbc_lblPW);
		
		tfPW = new JTextField();
		GridBagConstraints gbc_tfPW = new GridBagConstraints();
		gbc_tfPW.insets = new Insets(5, 5, 5, 5);
		gbc_tfPW.anchor = GridBagConstraints.WEST;
		gbc_tfPW.gridx = 1;
		gbc_tfPW.gridy = 2;
		pUserLoginInput.add(tfPW, gbc_tfPW);
		tfPW.setColumns(10);
		

		frame.getContentPane().add(pHeader, BorderLayout.NORTH);
		frame.getContentPane().add(pUserLoginInput, BorderLayout.CENTER);
		
		JButton bLogin = new JButton("Login");
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfUserName.getText();
				String pw = tfPW.getText();
				
			}
		});
		GridBagConstraints gbc_bLogin = new GridBagConstraints();
		gbc_bLogin.gridwidth = 2;
		gbc_bLogin.insets = new Insets(5, 5, 5, 5);
		gbc_bLogin.gridx = 0;
		gbc_bLogin.gridy = 3;
		pUserLoginInput.add(bLogin, gbc_bLogin);
		
		frame.pack();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	/**
	 * load picture into header.
	 */
	private ImageIcon showLogo() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(getClass().getResource("iconKrombacher.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon imageIcon = new ImageIcon(img);
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(555, 110, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		
		return imageIcon;
	}
	
	
	public JFrame getFrame() {
		return frame;
	}

}