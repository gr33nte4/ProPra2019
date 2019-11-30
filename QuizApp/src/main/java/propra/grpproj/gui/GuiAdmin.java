package propra.grpproj.gui; 

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GuiAdmin {

	private JFrame frmAdmin;
	private JTable tablePubs, tableQuestions;
	private JTextField tfQAQuestion, tfQAAnswerA, tfQAAnswerB, tfQAAnswerC, tfQAAnswerD, tfQAExplanation;
	private JTextField tfQEQuestion;
	private JTextField tfQEAsnwerA;
	private JTextField tfQEAnswerB;
	private JTextField tfQEAnswerC;
	private JTextField tfQEAnswerD;
	private JTextField tfQEExplanation;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiAdmin window = new GuiAdmin();
					window.frmAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiAdmin() {
		

	/**
	 * Initialize the contents of the frame.
	 */
		frmAdmin = new JFrame();
		frmAdmin.getContentPane().setEnabled(false);
		frmAdmin.setTitle("KROMBACHER Kneipenquiz");
		frmAdmin.setForeground(new Color(255, 255, 255));
		frmAdmin.getContentPane().setBackground(Color.WHITE);
		frmAdmin.setBackground(new Color(255, 255, 255));
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		
		/**
		 * Inititalize header
		 */
		JPanel pHeader = new JPanel();
		pHeader.setBackground(new Color(255, 255, 255));
		GridBagLayout gbl_pHeader = new GridBagLayout();
		gbl_pHeader.columnWidths = new int[] {0};
		gbl_pHeader.rowHeights = new int[] {0};
		gbl_pHeader.columnWeights = new double[]{0.0, 0.0};
		gbl_pHeader.rowWeights = new double[]{0.0};
		pHeader.setLayout(gbl_pHeader);
		
		JLabel lblHeader = new JLabel(showLogo());
		lblHeader.setLabelFor(lblHeader);
						
		GridBagConstraints gbc_lblHeader = new GridBagConstraints();
		gbc_lblHeader.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblHeader.gridx = 1;
		gbc_lblHeader.gridy = 0;
		pHeader.add(lblHeader, gbc_lblHeader);
		
		
		/**
		 * Initialize content
		 */
		JPanel pContent = new JPanel();
		pContent.setBackground(new Color(255, 255, 255));
		frmAdmin.getContentPane().add(pContent, BorderLayout.CENTER);
		GridBagLayout gbl_pContent = new GridBagLayout();
		gbl_pContent.columnWidths = new int[] {0};
		gbl_pContent.rowHeights = new int[] {0};
		gbl_pContent.columnWeights = new double[]{1.0};
		gbl_pContent.rowWeights = new double[]{1.0, 0.0};
		pContent.setLayout(gbl_pContent);
		
		
		/**
		 * CardLayout for lists -> pCardLayoutList and cardLayout1
		 */
		JPanel pCardLayoutList = new JPanel();
		GridBagConstraints gbc_pCardLayoutList = new GridBagConstraints();
		gbc_pCardLayoutList.insets = new Insets(5, 5, 5, 5);
		gbc_pCardLayoutList.fill = GridBagConstraints.BOTH;
		gbc_pCardLayoutList.gridx = 0;
		gbc_pCardLayoutList.gridy = 0;
		pContent.add(pCardLayoutList, gbc_pCardLayoutList);
		pCardLayoutList.setBackground(new Color(255, 255, 255));
		pCardLayoutList.setLayout(new CardLayout());
		CardLayout cardLayout1 = (CardLayout) pCardLayoutList.getLayout();
		/**
		 * cards for cardLayout1
		 */
		
		/**
		 * Panel clear for start		
		 */
		JPanel pClear1 = new JPanel();
		pClear1.setBackground(new Color(255, 255, 255));
		pCardLayoutList.add(pClear1, "pClear1");
		
		/**
		 * Panel for pubs
		 */
		JPanel pPubList = new JPanel();
		pPubList.setBackground(new Color(255, 255, 255));
		pCardLayoutList.add(pPubList, "pPubList");
		GridBagLayout gbl_pPubList = new GridBagLayout();
		gbl_pPubList.columnWidths = new int[] {0};
		gbl_pPubList.rowHeights = new int[] {0};
		gbl_pPubList.columnWeights = new double[]{1.0};
		gbl_pPubList.rowWeights = new double[]{0.0,1.0};
		pPubList.setLayout(gbl_pPubList);
		
		JLabel lblOverviewPubs = new JLabel("Übersicht der registrierten Kneipen");
		lblOverviewPubs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOverviewPubs.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblOverviewPubs = new GridBagConstraints();
		gbc_lblOverviewPubs.insets = new Insets(5, 5, 5, 5);
		gbc_lblOverviewPubs.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOverviewPubs.gridx = 0;
		gbc_lblOverviewPubs.gridy = 0;
		pPubList.add(lblOverviewPubs, gbc_lblOverviewPubs);
		
		tablePubs = new JTable() {
			public boolean isCellEditable(int x, int y) {
				return false;
			}
		};
		tablePubs.setShowVerticalLines(false);
		tablePubs.setColumnSelectionAllowed(true);
		tablePubs.setAutoCreateRowSorter(true);
		tablePubs.setModel(new DefaultTableModel(
			new Object[][] {
				{1, "Golfe", Boolean.TRUE, "", "", "bliblablubb"},
				{2, "Willis Eck", Boolean.FALSE, "", "", "Adresse"},
				{3, "Dorfkneipe Krombach", Boolean.TRUE, "", "", "Hinten links"}
			},
			new String[] {
				"KneipenID", "Kneipenname", "freigegeben", "BenutzerID", "Benutzername", "Adresse"
			}
		));
		
		JScrollPane scrollPanePubs = new JScrollPane(tablePubs);
		GridBagConstraints gbc_scrollPanePubs = new GridBagConstraints();
		gbc_scrollPanePubs.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPanePubs.fill = GridBagConstraints.BOTH;
		gbc_scrollPanePubs.gridx = 0;
		gbc_scrollPanePubs.gridy = 1;
		pPubList.add(scrollPanePubs, gbc_scrollPanePubs);
		
		
		/**
		 * Panel for questions
		 **/ 
		JPanel pQuestionsList = new JPanel();
		pQuestionsList.setBackground(new Color(255,255,255));
		pCardLayoutList.add(pQuestionsList, "pQuestionsList");
		GridBagLayout gbl_pQuestionsList = new GridBagLayout();
		gbl_pQuestionsList.columnWidths = new int[] {0};
		gbl_pQuestionsList.rowHeights = new int[] {0};
		gbl_pQuestionsList.columnWeights = new double[]{1.0};
		gbl_pQuestionsList.rowWeights = new double[]{0.0,1.0};
		pQuestionsList.setLayout(gbl_pQuestionsList);
		
		JLabel lblQuestionsList = new JLabel("Fragen");
		lblQuestionsList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuestionsList.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblQuestionsList = new GridBagConstraints();
		gbc_lblQuestionsList.insets = new Insets(5, 5, 5, 5);
		gbc_lblQuestionsList.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblQuestionsList.gridx = 0;
		gbc_lblQuestionsList.gridy = 0;
		pQuestionsList.add(lblQuestionsList, gbc_lblQuestionsList);
		
		tableQuestions = new JTable(){
			public boolean isCellEditable(int x, int y) {
				return false;
			}
		};
		tableQuestions.setBackground(new Color(255, 255, 255));
		tableQuestions.setShowVerticalLines(false);
		tableQuestions.setColumnSelectionAllowed(true);
		tableQuestions.setAutoCreateRowSorter(true);
		tableQuestions.setModel(new DefaultTableModel(
			new Object[][] {
				{1, "Golfe", Boolean.TRUE, "bliblablubb"},
				{2, "Willis Eck", Boolean.FALSE, "Adresse"}
			},
			new String[] {
				"Id", "Frage", "Antwort A", "Antwort B", "Antwort C", "Antwort D", "Richtige Antwort", "Erläuterung"
			}
		));
		
		JScrollPane scrollPaneQuestions = new JScrollPane(tableQuestions);
		GridBagConstraints gbc_scrollPaneQuestions = new GridBagConstraints();
		gbc_scrollPaneQuestions.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPaneQuestions.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneQuestions.gridx = 0;
		gbc_scrollPaneQuestions.gridy = 1;
		pQuestionsList.add(scrollPaneQuestions, gbc_scrollPaneQuestions);
		
		
		/**
		 * CardLayout for input -> pCardLayoutInput and cardLayout2
		 */
		JPanel pCardLayoutInput = new JPanel();
		GridBagConstraints gbc_pCardLayoutInput = new GridBagConstraints();
		gbc_pCardLayoutInput.insets = new Insets(5, 5, 5, 5);
		gbc_pCardLayoutInput.fill = GridBagConstraints.BOTH;
		gbc_pCardLayoutInput.gridx = 0;
		gbc_pCardLayoutInput.gridy = 1;
		pContent.add(pCardLayoutInput, gbc_pCardLayoutInput);
		pCardLayoutInput.setBackground(new Color(255, 255, 255));
		pCardLayoutInput.setLayout(new CardLayout(0, 0));
		CardLayout cardLayout2 = (CardLayout) pCardLayoutInput.getLayout();
		
		/**
		 * cards for cardLayout2
		 */
		
		/**
		 * Panel clear for start
		 */
		JPanel pClear2 = new JPanel();
		pClear2.setBackground(new Color(255, 255, 255));
		pCardLayoutInput.add(pClear2, "pClear2");
		
		/**
		 * panel for adding a question
		 */
		JPanel pQuestionAdd = new JPanel();
		pCardLayoutInput.add(pQuestionAdd, "pQuestionAdd");
		pQuestionAdd.setBackground(new Color(255, 255, 255));
		GridBagLayout gbl_pQuestionAdd = new GridBagLayout();
		gbl_pQuestionAdd.rowHeights = new int[] {0};
		gbl_pQuestionAdd.columnWidths = new int[] {0};
		gbl_pQuestionAdd.columnWeights = new double[]{0.0, 1.0};
		gbl_pQuestionAdd.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		pQuestionAdd.setLayout(gbl_pQuestionAdd);
		
		JLabel lblQuestionAdd = new JLabel("Frage hinzufügen");
		lblQuestionAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblQuestionAdd = new GridBagConstraints();
		gbc_lblQuestionAdd.anchor = GridBagConstraints.EAST;
		gbc_lblQuestionAdd.insets = new Insets(5, 5, 5, 5);
		gbc_lblQuestionAdd.gridx = 0;
		gbc_lblQuestionAdd.gridy = 0;
		pQuestionAdd.add(lblQuestionAdd, gbc_lblQuestionAdd);
		
		JLabel lblQACorrectAnswer = new JLabel("richtige Antwort");
		GridBagConstraints gbc_lblQACorrectAnswer = new GridBagConstraints();
		gbc_lblQACorrectAnswer.anchor = GridBagConstraints.WEST;
		gbc_lblQACorrectAnswer.insets = new Insets(0, 0, 5, 5);
		gbc_lblQACorrectAnswer.gridx = 0;
		gbc_lblQACorrectAnswer.gridy = 6;
		pQuestionAdd.add(lblQACorrectAnswer, gbc_lblQACorrectAnswer);
		
		JComboBox<String> cbQACorrectAnswer = new JComboBox<String>();
		cbQACorrectAnswer.setModel(new DefaultComboBoxModel<String>(new String[] {"A", "B", "C", "D"}));
		cbQACorrectAnswer.setSelectedIndex(0);
		GridBagConstraints gbc_cbQACorrectAnswer = new GridBagConstraints();
		gbc_cbQACorrectAnswer.insets = new Insets(5, 5, 5, 5);
		gbc_cbQACorrectAnswer.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbQACorrectAnswer.gridx = 1;
		gbc_cbQACorrectAnswer.gridy = 6;
		pQuestionAdd.add(cbQACorrectAnswer, gbc_cbQACorrectAnswer);
		
		JLabel lblQAQuestion = new JLabel("Frage");
		GridBagConstraints gbc_lblQAQuestion = new GridBagConstraints();
		gbc_lblQAQuestion.anchor = GridBagConstraints.WEST;
		gbc_lblQAQuestion.insets = new Insets(5, 5, 5, 5);
		gbc_lblQAQuestion.gridx = 0;
		gbc_lblQAQuestion.gridy = 1;
		pQuestionAdd.add(lblQAQuestion, gbc_lblQAQuestion);
		
		tfQAQuestion = new JTextField();
		GridBagConstraints gbc_tfQAQuestion = new GridBagConstraints();
		gbc_tfQAQuestion.insets = new Insets(5, 5, 5, 5);
		gbc_tfQAQuestion.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQAQuestion.gridx = 1;
		gbc_tfQAQuestion.gridy = 1;
		pQuestionAdd.add(tfQAQuestion, gbc_tfQAQuestion);
		tfQAQuestion.setColumns(10);
		
		JLabel lblQAAnswerA = new JLabel("Antwort A");
		GridBagConstraints gbc_lblQAAnswerA = new GridBagConstraints();
		gbc_lblQAAnswerA.anchor = GridBagConstraints.WEST;
		gbc_lblQAAnswerA.insets = new Insets(5, 5, 5, 5);
		gbc_lblQAAnswerA.gridx = 0;
		gbc_lblQAAnswerA.gridy = 2;
		pQuestionAdd.add(lblQAAnswerA, gbc_lblQAAnswerA);
		
		tfQAAnswerA = new JTextField();
		GridBagConstraints gbc_tfQAAnswerA = new GridBagConstraints();
		gbc_tfQAAnswerA.insets = new Insets(5, 5, 5, 0);
		gbc_tfQAAnswerA.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQAAnswerA.gridx = 1;
		gbc_tfQAAnswerA.gridy = 2;
		pQuestionAdd.add(tfQAAnswerA, gbc_tfQAAnswerA);
		tfQAAnswerA.setColumns(10);
		
		JLabel lblQAAnswerB = new JLabel("Antwort B");
		GridBagConstraints gbc_lblQAAnswerB = new GridBagConstraints();
		gbc_lblQAAnswerB.anchor = GridBagConstraints.WEST;
		gbc_lblQAAnswerB.insets = new Insets(5, 5, 5, 5);
		gbc_lblQAAnswerB.gridx = 0;
		gbc_lblQAAnswerB.gridy = 3;
		pQuestionAdd.add(lblQAAnswerB, gbc_lblQAAnswerB);
		
		tfQAAnswerB = new JTextField();
		GridBagConstraints gbc_tfQAAnswerB = new GridBagConstraints();
		gbc_tfQAAnswerB.insets = new Insets(5, 5, 5, 0);
		gbc_tfQAAnswerB.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQAAnswerB.gridx = 1;
		gbc_tfQAAnswerB.gridy = 3;
		pQuestionAdd.add(tfQAAnswerB, gbc_tfQAAnswerB);
		tfQAAnswerB.setColumns(10);
		
		JLabel lblAnswerC = new JLabel("Antwort C");
		GridBagConstraints gbc_lblAnswerC = new GridBagConstraints();
		gbc_lblAnswerC.anchor = GridBagConstraints.WEST;
		gbc_lblAnswerC.insets = new Insets(5, 5, 5, 5);
		gbc_lblAnswerC.gridx = 0;
		gbc_lblAnswerC.gridy = 4;
		pQuestionAdd.add(lblAnswerC, gbc_lblAnswerC);
		
		tfQAAnswerC = new JTextField();
		GridBagConstraints gbc_tfQAAnswerC = new GridBagConstraints();
		gbc_tfQAAnswerC.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQAAnswerC.insets = new Insets(5, 5, 5, 0);
		gbc_tfQAAnswerC.gridx = 1;
		gbc_tfQAAnswerC.gridy = 4;
		pQuestionAdd.add(tfQAAnswerC, gbc_tfQAAnswerC);
		tfQAAnswerC.setColumns(10);
		
		JLabel lblQAAnswerD = new JLabel("Antwort D");
		GridBagConstraints gbc_lblQAAnswerD = new GridBagConstraints();
		gbc_lblQAAnswerD.anchor = GridBagConstraints.WEST;
		gbc_lblQAAnswerD.insets = new Insets(5, 5, 5, 5);
		gbc_lblQAAnswerD.gridx = 0;
		gbc_lblQAAnswerD.gridy = 5;
		pQuestionAdd.add(lblQAAnswerD, gbc_lblQAAnswerD);
		
		tfQAAnswerD = new JTextField();
		GridBagConstraints gbc_tfQAAnswerD = new GridBagConstraints();
		gbc_tfQAAnswerD.insets = new Insets(5, 5, 5, 0);
		gbc_tfQAAnswerD.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQAAnswerD.gridx = 1;
		gbc_tfQAAnswerD.gridy = 5;
		pQuestionAdd.add(tfQAAnswerD, gbc_tfQAAnswerD);
		tfQAAnswerD.setColumns(10);
		gbc_cbQACorrectAnswer.anchor = GridBagConstraints.WEST;
		gbc_cbQACorrectAnswer.insets = new Insets(5, 5, 5, 5);
		gbc_cbQACorrectAnswer.gridx = 0;
		gbc_cbQACorrectAnswer.gridy = 6;
		
		JLabel lblQAExplanation = new JLabel("Erläuterung");
		GridBagConstraints gbc_lblQAExplanation = new GridBagConstraints();
		gbc_lblQAExplanation.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblQAExplanation.insets = new Insets(5, 5, 5, 5);
		gbc_lblQAExplanation.gridx = 0;
		gbc_lblQAExplanation.gridy = 7;
		pQuestionAdd.add(lblQAExplanation, gbc_lblQAExplanation);
		
		tfQAExplanation = new JTextField();
		GridBagConstraints gbc_tfQAExplanation = new GridBagConstraints();
		gbc_tfQAExplanation.insets = new Insets(5, 5, 5, 0);
		gbc_tfQAExplanation.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQAExplanation.gridx = 1;
		gbc_tfQAExplanation.gridy = 7;
		pQuestionAdd.add(tfQAExplanation, gbc_tfQAExplanation);
		tfQAExplanation.setColumns(10);
		
		JButton bQuestionAddNow = new JButton("Frage hinzufügen");
		bQuestionAddNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // Speichern bzw. Einlesen der Eingaben !!!!
				
				
				tfQAQuestion.setText("");
				tfQAAnswerA.setText("");
				tfQAAnswerB.setText("");
				tfQAAnswerC.setText("");
				tfQAAnswerD.setText("");
				tfQAExplanation.setText("");
				cbQACorrectAnswer.setSelectedIndex(0);
			}
		});
		GridBagConstraints gbc_bQuestionAddNow = new GridBagConstraints();
		gbc_bQuestionAddNow.anchor = GridBagConstraints.EAST;
		gbc_bQuestionAddNow.insets = new Insets(5, 5, 0, 0);
		gbc_bQuestionAddNow.gridx = 1;
		gbc_bQuestionAddNow.gridy = 8;
		pQuestionAdd.add(bQuestionAddNow, gbc_bQuestionAddNow);
		
		
		/**
		 * panel for editing question
		 */
		JPanel pQuestionEdit = new JPanel();
		pQuestionEdit.setBackground(new Color(255, 255, 255));
		pCardLayoutInput.add(pQuestionEdit, "pQuestionEdit");
		GridBagLayout gbl_pQuestionEdit = new GridBagLayout();
		gbl_pQuestionEdit.columnWidths = new int[] {0};
		gbl_pQuestionEdit.rowHeights = new int[] {0};
		gbl_pQuestionEdit.columnWeights = new double[]{0.0, 1.0};
		gbl_pQuestionEdit.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		pQuestionEdit.setLayout(gbl_pQuestionEdit);
		
		JLabel lblQuestionEdit = new JLabel("Frage bearbeiten");
		lblQuestionEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblQuestionEdit = new GridBagConstraints();
		gbc_lblQuestionEdit.insets = new Insets(5, 5, 5, 5);
		gbc_lblQuestionEdit.anchor = GridBagConstraints.WEST;
		gbc_lblQuestionEdit.gridx = 0;
		gbc_lblQuestionEdit.gridy = 0;
		pQuestionEdit.add(lblQuestionEdit, gbc_lblQuestionEdit);
		
		JLabel lblQEID = new JLabel("ID");
		GridBagConstraints gbc_lblQEID = new GridBagConstraints();
		gbc_lblQEID.insets = new Insets(5, 5, 5, 5);
		gbc_lblQEID.anchor = GridBagConstraints.WEST;
		gbc_lblQEID.gridx = 0;
		gbc_lblQEID.gridy = 1;
		pQuestionEdit.add(lblQEID, gbc_lblQEID);
		
		JComboBox<Integer> cbQEID = new JComboBox<Integer>();
		cbQEID.setSelectedIndex(-1);
		GridBagConstraints gbc_cbQEID = new GridBagConstraints();
		gbc_cbQEID.insets = new Insets(5, 5, 5, 5);
		gbc_cbQEID.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbQEID.gridx = 1;
		gbc_cbQEID.gridy = 1;
		pQuestionEdit.add(cbQEID, gbc_cbQEID);
		
		JLabel lblQEQuestion = new JLabel("Frage");
		GridBagConstraints gbc_lblQEQuestion = new GridBagConstraints();
		gbc_lblQEQuestion.anchor = GridBagConstraints.WEST;
		gbc_lblQEQuestion.insets = new Insets(5, 5, 5, 5);
		gbc_lblQEQuestion.gridx = 0;
		gbc_lblQEQuestion.gridy = 2;
		pQuestionEdit.add(lblQEQuestion, gbc_lblQEQuestion);
		
		tfQEQuestion = new JTextField();
		tfQEQuestion.setText("");
		GridBagConstraints gbc_tfQEQuestion = new GridBagConstraints();
		gbc_tfQEQuestion.insets = new Insets(5, 5, 5, 5);
		gbc_tfQEQuestion.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQEQuestion.gridx = 1;
		gbc_tfQEQuestion.gridy = 2;
		pQuestionEdit.add(tfQEQuestion, gbc_tfQEQuestion);
		tfQEQuestion.setColumns(10);
		
		JLabel lblQEAnswerA = new JLabel("Antwort A");
		GridBagConstraints gbc_lblQEAnswerA = new GridBagConstraints();
		gbc_lblQEAnswerA.anchor = GridBagConstraints.WEST;
		gbc_lblQEAnswerA.insets = new Insets(5, 5, 5, 5);
		gbc_lblQEAnswerA.gridx = 0;
		gbc_lblQEAnswerA.gridy = 3;
		pQuestionEdit.add(lblQEAnswerA, gbc_lblQEAnswerA);
		
		tfQEAsnwerA = new JTextField();
		GridBagConstraints gbc_tfQEAsnwerA = new GridBagConstraints();
		gbc_tfQEAsnwerA.insets = new Insets(5, 5, 5, 5);
		gbc_tfQEAsnwerA.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQEAsnwerA.gridx = 1;
		gbc_tfQEAsnwerA.gridy = 3;
		pQuestionEdit.add(tfQEAsnwerA, gbc_tfQEAsnwerA);
		tfQEAsnwerA.setColumns(10);
		
		JLabel lblQEAnswerB = new JLabel("Antwort B");
		GridBagConstraints gbc_lblQEAnswerB = new GridBagConstraints();
		gbc_lblQEAnswerB.anchor = GridBagConstraints.WEST;
		gbc_lblQEAnswerB.insets = new Insets(5, 5, 5, 5);
		gbc_lblQEAnswerB.gridx = 0;
		gbc_lblQEAnswerB.gridy = 4;
		pQuestionEdit.add(lblQEAnswerB, gbc_lblQEAnswerB);
		
		tfQEAnswerB = new JTextField();
		GridBagConstraints gbc_tfQEAnswerB = new GridBagConstraints();
		gbc_tfQEAnswerB.insets = new Insets(5, 5, 5, 5);
		gbc_tfQEAnswerB.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQEAnswerB.gridx = 1;
		gbc_tfQEAnswerB.gridy = 4;
		pQuestionEdit.add(tfQEAnswerB, gbc_tfQEAnswerB);
		tfQEAnswerB.setColumns(10);
		
		JLabel lblQEAnswerC = new JLabel("Antwort C");
		GridBagConstraints gbc_lblQEAnswerC = new GridBagConstraints();
		gbc_lblQEAnswerC.anchor = GridBagConstraints.WEST;
		gbc_lblQEAnswerC.insets = new Insets(5, 5, 5, 5);
		gbc_lblQEAnswerC.gridx = 0;
		gbc_lblQEAnswerC.gridy = 5;
		pQuestionEdit.add(lblQEAnswerC, gbc_lblQEAnswerC);
		
		tfQEAnswerC = new JTextField();
		GridBagConstraints gbc_tfQEAnswerC = new GridBagConstraints();
		gbc_tfQEAnswerC.insets = new Insets(5, 5, 5, 5);
		gbc_tfQEAnswerC.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQEAnswerC.gridx = 1;
		gbc_tfQEAnswerC.gridy = 5;
		pQuestionEdit.add(tfQEAnswerC, gbc_tfQEAnswerC);
		tfQEAnswerC.setColumns(10);
		
		JLabel lblQEAnswerD = new JLabel("Antwort D");
		GridBagConstraints gbc_lblQEAnswerD = new GridBagConstraints();
		gbc_lblQEAnswerD.anchor = GridBagConstraints.WEST;
		gbc_lblQEAnswerD.insets = new Insets(5, 5, 5, 5);
		gbc_lblQEAnswerD.gridx = 0;
		gbc_lblQEAnswerD.gridy = 6;
		pQuestionEdit.add(lblQEAnswerD, gbc_lblQEAnswerD);
		
		tfQEAnswerD = new JTextField();
		GridBagConstraints gbc_tfQEAnswerD = new GridBagConstraints();
		gbc_tfQEAnswerD.insets = new Insets(5, 5, 5, 5);
		gbc_tfQEAnswerD.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQEAnswerD.gridx = 1;
		gbc_tfQEAnswerD.gridy = 6;
		pQuestionEdit.add(tfQEAnswerD, gbc_tfQEAnswerD);
		tfQEAnswerD.setColumns(10);
		
		JLabel lblQECorrectAnswer = new JLabel("richtige Antwort");
		GridBagConstraints gbc_lblQECorrectAnswer = new GridBagConstraints();
		gbc_lblQECorrectAnswer.anchor = GridBagConstraints.WEST;
		gbc_lblQECorrectAnswer.insets = new Insets(5, 5, 5, 5);
		gbc_lblQECorrectAnswer.gridx = 0;
		gbc_lblQECorrectAnswer.gridy = 7;
		pQuestionEdit.add(lblQECorrectAnswer, gbc_lblQECorrectAnswer);
		
		JComboBox cbQECorrectAnswer = new JComboBox();
		cbQECorrectAnswer.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		GridBagConstraints gbc_cbQECorrectAnswer = new GridBagConstraints();
		gbc_cbQECorrectAnswer.anchor = GridBagConstraints.WEST;
		gbc_cbQECorrectAnswer.insets = new Insets(5, 5, 5, 5);
		gbc_cbQECorrectAnswer.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbQECorrectAnswer.gridx = 1;
		gbc_cbQECorrectAnswer.gridy = 7;
		pQuestionEdit.add(cbQECorrectAnswer, gbc_cbQECorrectAnswer);
		
		JLabel lblQEExplanastion = new JLabel("Erl\u00E4uterung");
		GridBagConstraints gbc_lblQEExplanastion = new GridBagConstraints();
		gbc_lblQEExplanastion.anchor = GridBagConstraints.WEST;
		gbc_lblQEExplanastion.insets = new Insets(5, 5, 5, 5);
		gbc_lblQEExplanastion.gridx = 0;
		gbc_lblQEExplanastion.gridy = 8;
		pQuestionEdit.add(lblQEExplanastion, gbc_lblQEExplanastion);
		
		tfQEExplanation = new JTextField();
		GridBagConstraints gbc_tfQEExplanation = new GridBagConstraints();
		gbc_tfQEExplanation.insets = new Insets(5, 5, 5, 5);
		gbc_tfQEExplanation.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQEExplanation.gridx = 1;
		gbc_tfQEExplanation.gridy = 8;
		pQuestionEdit.add(tfQEExplanation, gbc_tfQEExplanation);
		tfQEExplanation.setColumns(10);
		
		JButton bQEDelete = new JButton("Frage löschen");
		bQEDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Löschen der Frage anhand der ID !!!!
				
				
				tfQAQuestion.setText("");
				tfQAAnswerA.setText("");
				tfQAAnswerB.setText("");
				tfQAAnswerC.setText("");
				tfQAAnswerD.setText("");
				tfQAExplanation.setText("");
				cbQACorrectAnswer.setSelectedIndex(0);
			}
		});
		GridBagConstraints gbc_bQEDelete = new GridBagConstraints();
		gbc_bQEDelete.anchor = GridBagConstraints.WEST;
		gbc_bQEDelete.insets = new Insets(5, 5, 5, 5);
		gbc_bQEDelete.gridx = 0;
		gbc_bQEDelete.gridy = 9;
		pQuestionEdit.add(bQEDelete, gbc_bQEDelete);
		
		JButton bQuestionSave = new JButton("Speichern");
		bQuestionSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Speichern bzw. Einlesen der Eingaben !!!!
				
				
				tfQAQuestion.setText("");
				tfQAAnswerA.setText("");
				tfQAAnswerB.setText("");
				tfQAAnswerC.setText("");
				tfQAAnswerD.setText("");
				tfQAExplanation.setText("");
				cbQACorrectAnswer.setSelectedIndex(0);
			}
		});
		GridBagConstraints gbc_bQuestionSave = new GridBagConstraints();
		gbc_bQuestionSave.insets = new Insets(5, 5, 0, 0);
		gbc_bQuestionSave.anchor = GridBagConstraints.EAST;
		gbc_bQuestionSave.gridx = 1;
		gbc_bQuestionSave.gridy = 9;
		pQuestionEdit.add(bQuestionSave, gbc_bQuestionSave);
		
		/**
		 * Panel for editing, deleting and unblock pubs
		 */
		JPanel pPubEdit = new JPanel();
		pPubEdit.setBackground(new Color(255, 255, 255));
		pCardLayoutInput.add(pPubEdit, "pPubEdit");
		GridBagLayout gbl_pPubEdit = new GridBagLayout();
		gbl_pPubEdit.columnWidths = new int[] {0};
		gbl_pPubEdit.rowHeights = new int[] {0};
		gbl_pPubEdit.columnWeights = new double[]{0.0};
		gbl_pPubEdit.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pPubEdit.setLayout(gbl_pPubEdit);
		
		JLabel lblPubEdit = new JLabel("Kneipe bearbeiten");
		lblPubEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblPubEdit = new GridBagConstraints();
		gbc_lblPubEdit.insets = new Insets(5, 5, 5, 5);
		gbc_lblPubEdit.anchor = GridBagConstraints.WEST;
		gbc_lblPubEdit.gridx = 0;
		gbc_lblPubEdit.gridy = 0;
		pPubEdit.add(lblPubEdit, gbc_lblPubEdit);
		
/*		JLabel lbluestion = new JLabel("Frage");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		pQuestionEdit.add(lblNewLabel, gbc_lblNewLabel);*/
		
				
		
		/**
		 * Initialize menu
		 */
		JPanel pMenu = new JPanel();
		pMenu.setBackground(new Color(255, 255, 255));
		
		GridBagLayout gbl_pMenu = new GridBagLayout();
		gbl_pMenu.columnWidths = new int[] {0};
		gbl_pMenu.rowHeights = new int[] {0};
		gbl_pMenu.columnWeights = new double[]{1.0};
		gbl_pMenu.rowWeights = new double[]{1.0, 1.0};
		pMenu.setLayout(gbl_pMenu);
		
		/**
		 * panel for pubs
		 */
		JPanel pMenuPub = new JPanel();
		GridBagConstraints gbc_pMenuPub = new GridBagConstraints();
		gbc_pMenuPub.insets = new Insets(5, 5, 5, 5);
		gbc_pMenuPub.fill = GridBagConstraints.BOTH;
		gbc_pMenuPub.gridx = 0;
		gbc_pMenuPub.gridy = 0;
		pMenu.add(pMenuPub, gbc_pMenuPub);
		GridBagLayout gbl_pMenuPub = new GridBagLayout();
		gbl_pMenuPub.columnWidths = new int[] {0};
		gbl_pMenuPub.rowHeights = new int[] {0};
		gbl_pMenuPub.columnWeights = new double[]{0.0};
		gbl_pMenuPub.rowWeights = new double[]{0.0, 0.0};
		pMenuPub.setLayout(gbl_pMenuPub);
		
		JLabel lblKneipenverwaltung = new JLabel("Kneipenverwaltung");
		lblKneipenverwaltung.setHorizontalAlignment(SwingConstants.CENTER);
		lblKneipenverwaltung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblKneipenverwaltung = new GridBagConstraints();
		gbc_lblKneipenverwaltung.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblKneipenverwaltung.insets = new Insets(5, 5, 5, 5);
		gbc_lblKneipenverwaltung.gridx = 0;
		gbc_lblKneipenverwaltung.gridy = 0;
		pMenuPub.add(lblKneipenverwaltung, gbc_lblKneipenverwaltung);
		
		JButton bPubEdit = new JButton("Kneipe bearbeiten");
		bPubEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 cardLayout1.show(pCardLayoutList, "pPubList");
				 cardLayout2.show(pCardLayoutInput, "pPubEdit");
			}
		});
		GridBagConstraints gbc_bPubEdit = new GridBagConstraints();
		gbc_bPubEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_bPubEdit.insets = new Insets(5, 5, 5, 5);
		gbc_bPubEdit.gridx = 0;
		gbc_bPubEdit.gridy = 1;
		pMenuPub.add(bPubEdit, gbc_bPubEdit);
		
		/*
		 * panel for Questions
		 */
		JPanel pMenuQuestions = new JPanel();
		GridBagConstraints gbc_pMenuQuestions = new GridBagConstraints();
		gbc_pMenuQuestions.insets = new Insets(5, 5, 5, 5);
		gbc_pMenuQuestions.fill = GridBagConstraints.BOTH;
		gbc_pMenuQuestions.gridx = 0;
		gbc_pMenuQuestions.gridy = 1;
		pMenu.add(pMenuQuestions, gbc_pMenuQuestions);
		
		GridBagLayout gbl_pMenuQuestions = new GridBagLayout();
		gbl_pMenuQuestions.columnWidths = new int[] {0};
		gbl_pMenuQuestions.rowHeights = new int[] {0};
		gbl_pMenuQuestions.columnWeights = new double[]{1.0};
		gbl_pMenuQuestions.rowWeights = new double[]{0.0, 0.0, 0.0};
		pMenuQuestions.setLayout(gbl_pMenuQuestions);
		
		JLabel lblQuizfragen = new JLabel("Quizfragen");
		lblQuizfragen.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuizfragen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblQuizfragen = new GridBagConstraints();
		gbc_lblQuizfragen.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblQuizfragen.insets = new Insets(5, 5, 5, 5);
		gbc_lblQuizfragen.gridx = 0;
		gbc_lblQuizfragen.gridy = 0;
		pMenuQuestions.add(lblQuizfragen, gbc_lblQuizfragen);
		
		JButton bQuestionAdd = new JButton("Frage hinzufügen");
		bQuestionAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 cardLayout1.show(pCardLayoutList, "pQuestionsList");
				 cardLayout2.show(pCardLayoutInput, "pQuestionAdd");
			}
		});
		GridBagConstraints gbc_bQuestionAdd = new GridBagConstraints();
		gbc_bQuestionAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_bQuestionAdd.insets = new Insets(5, 5, 5, 5);
		gbc_bQuestionAdd.gridx = 0;
		gbc_bQuestionAdd.gridy = 1;
		pMenuQuestions.add(bQuestionAdd, gbc_bQuestionAdd);
		
		JButton bQuestionEdit = new JButton("Frage bearbeiten / l\u00F6schen");
		bQuestionEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 cardLayout1.show(pCardLayoutList, "pQuestionsList");
				 cardLayout2.show(pCardLayoutInput, "pQuestionEdit");
			}
		});
		GridBagConstraints gbc_bQuestionEdit = new GridBagConstraints();
		gbc_bQuestionEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_bQuestionEdit.insets = new Insets(5, 5, 5, 5);
		gbc_bQuestionEdit.gridx = 0;
		gbc_bQuestionEdit.gridy = 2;
		pMenuQuestions.add(bQuestionEdit, gbc_bQuestionEdit);
		
		
		
		frmAdmin.getContentPane().add(pHeader, BorderLayout.NORTH);
		frmAdmin.getContentPane().add(pMenu, BorderLayout.WEST);
		frmAdmin.getContentPane().add(pContent, BorderLayout.CENTER);
		frmAdmin.pack();
		frmAdmin.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
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


}
