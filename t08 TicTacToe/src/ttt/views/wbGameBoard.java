package ttt.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class wbGameBoard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmFNew;
	private JMenuItem mntmFRestart;
	private JMenuItem mntmFExit;
	private JMenuItem mntmHAbout;
	private JButton btnNW;
	private JButton btnN;
	private JButton btnNE;
	private JButton btnW;
	private JButton btnC;
	private JButton btnE;
	private JButton btnSW;
	private JButton btnS;
	private JButton btnSE;
	private List<JButton> lstButtons;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private GroupLayout gl_contentPane;
	private Icon xbut;
	private Icon obut;
	private String playerTurn;
	private String strTip;
	private ButtonHandler btnHandler;
	private RadioHandler rdoHandler;
	private JRadioButton rbPlayer2;
	private JRadioButton rbPlayer1;
	private final String PLAYERX = "x";
	private final String PLAYERO = "o";
	private final ButtonGroup bgpPlayerTurn = new ButtonGroup();
	private final ButtonGroup bgpButtons = new ButtonGroup();
	private final String WINSETS = "123,456,789,147,258,369,159,357";
	private Color clrWinner;
	private JLabel lblNewLabel;
	private boolean blnPlayGame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wbGameBoard frame = new wbGameBoard();
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
	public wbGameBoard() {
		initComponents();
		createEvents();
	}
	
	/**
	 * Initialize components
	 */
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setVisible(true);
		
		/**
		 * Define Menu
		 */
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		mnFile.setPreferredSize(new Dimension(75, 22));
		menuBar.add(mnFile);
		
		mntmFNew = new JMenuItem("New Game");
		mntmFNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("NNNNNNN Start new game.");
				newGame(lstButtons);
			}
		});
		mnFile.add(mntmFNew);
		
		mntmFRestart = new JMenuItem("Restart Game");
		mnFile.add(mntmFRestart);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		mntmFExit = new JMenuItem("Exit");
		mnFile.add(mntmFExit);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setPreferredSize(new Dimension(390, 14));
		menuBar.add(lblNewLabel);
		
		mnHelp = new JMenu("Help");
		mnHelp.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mnHelp);
		
		mntmHAbout = new JMenuItem("About");
		mnHelp.add(mntmHAbout);

		/**
		 * Define icons for players
		 */
		xbut = new ImageIcon(wbGameBoard.class.getResource("/ttt/resources/X.png"));
		obut = new ImageIcon(wbGameBoard.class.getResource("/ttt/resources/O.png"));

		/**
		 * Define Panel Components
		 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnHandler = new ButtonHandler();
		rdoHandler = new RadioHandler();
		
		lstButtons = new ArrayList<JButton>();
		clrWinner = Color.GREEN;

		btnNW = new JButton("");
		bgpButtons.add(btnNW);
		btnNW.setMinimumSize(new Dimension(89, 39));
		btnNW.setPreferredSize(new Dimension(89, 39));
		btnNW.addActionListener(btnHandler);
		lstButtons.add(btnNW);
		
		btnN = new JButton("");
		bgpButtons.add(btnN);
		btnN.setMinimumSize(new Dimension(89, 39));
		btnN.setPreferredSize(new Dimension(89, 39));
		btnN.addActionListener(btnHandler);
		lstButtons.add(btnN);
		
		btnNE = new JButton("");
		bgpButtons.add(btnNE);
		btnNE.setMinimumSize(new Dimension(89, 39));
		btnNE.setPreferredSize(new Dimension(89, 39));
		btnNE.addActionListener(btnHandler);
		lstButtons.add(btnNE);
		
		btnW = new JButton("");
		bgpButtons.add(btnW);
		btnW.setMinimumSize(new Dimension(89, 39));
		btnW.setPreferredSize(new Dimension(89, 39));
		btnW.addActionListener(btnHandler);
		lstButtons.add(btnW);
		
		btnC = new JButton("");
		bgpButtons.add(btnC);
		btnC.setMinimumSize(new Dimension(89, 39));
		btnC.setPreferredSize(new Dimension(89, 39));
		btnC.addActionListener(btnHandler);
		lstButtons.add(btnC);

		btnE = new JButton("");
		bgpButtons.add(btnE);
		btnE.setMinimumSize(new Dimension(89, 39));
		btnE.setPreferredSize(new Dimension(89, 39));
		btnE.addActionListener(btnHandler);
		lstButtons.add(btnE);

		btnSW = new JButton("");
		bgpButtons.add(btnSW);
		btnSW.setMinimumSize(new Dimension(89, 39));
		btnSW.setPreferredSize(new Dimension(89, 39));
		btnSW.addActionListener(btnHandler);
		lstButtons.add(btnSW);
		
		btnS = new JButton("");
		bgpButtons.add(btnS);
		btnS.setMinimumSize(new Dimension(89, 39));
		btnS.setPreferredSize(new Dimension(89, 39));
		btnS.addActionListener(btnHandler);
		lstButtons.add(btnS);
		
		btnSE = new JButton("");
		bgpButtons.add(btnSE);
		btnSE.setMinimumSize(new Dimension(89, 39));
		btnSE.setPreferredSize(new Dimension(89, 39));
		btnSE.addActionListener(btnHandler);
		lstButtons.add(btnSE);
		
		JLabel lblPlayer1 = new JLabel("");
		lblPlayer1.setVerticalTextPosition(SwingConstants.TOP);
		lblPlayer1.setVerticalAlignment(SwingConstants.TOP);
		lblPlayer1.setMinimumSize(new Dimension(130, 55));
		lblPlayer1.setIcon(xbut);
		
		JLabel lblPlayer2 = new JLabel("");
		lblPlayer2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPlayer2.setHorizontalTextPosition(SwingConstants.LEADING);
		lblPlayer2.setVerticalTextPosition(SwingConstants.TOP);
		lblPlayer2.setVerticalAlignment(SwingConstants.TOP);
		lblPlayer2.setMinimumSize(new Dimension(130, 55));
		lblPlayer2.setIcon(obut);
		
		rbPlayer1 = new JRadioButton("<html><u>Player 1</u></html>");
		bgpPlayerTurn.add(rbPlayer1);
		rbPlayer1.addItemListener(rdoHandler);
		rbPlayer1.setSelected(true);
		rbPlayer1.setVerticalTextPosition(SwingConstants.TOP);
		rbPlayer1.setVerticalAlignment(SwingConstants.TOP);
		rbPlayer1.setMinimumSize(new Dimension(100, 59));
		
		rbPlayer2 = new JRadioButton("<html><u>Player 2</u></html>");
		bgpPlayerTurn.add(rbPlayer2);
		rbPlayer2.addItemListener(rdoHandler);
		rbPlayer2.setHorizontalAlignment(SwingConstants.TRAILING);
		rbPlayer2.setVerticalAlignment(SwingConstants.TOP);
		rbPlayer2.setVerticalTextPosition(SwingConstants.TOP);
		rbPlayer2.setMinimumSize(new Dimension(100, 59));
		
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSW, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnW, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNW, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
							.addComponent(btnNE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(119))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(lblPlayer1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addComponent(rbPlayer1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(rbPlayer2, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlayer2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(46))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rbPlayer1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rbPlayer2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPlayer1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlayer2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNW, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnW, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSW, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		
		playerTurn = PLAYERX; // who starts?  {x|o}
		blnPlayGame = true;
	}
	
	/**
	 * 
	 */
	private void createEvents() {
		
		
	}
	
	private class RadioHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == rbPlayer1 && rbPlayer1.isSelected()) {
				playerTurn = PLAYERX;
				System.out.println("Player X's turn!");
			}
			else if (e.getSource() == rbPlayer2 && rbPlayer2.isSelected()) {
				playerTurn = PLAYERO;
				System.out.println("Player O's turn!");
			}
			
		}
		
	}

	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = new JButton();
			if (blnPlayGame == false) {
				return;
			}

			if (e.getSource() == btnNW) { 
				System.out.println("NW button!");
				b = btnNW;
			}
			if (e.getSource() == btnN) { 
				System.out.println("N button!");
				b = btnN;
			}
			if (e.getSource() == btnNE) { 
				System.out.println("NE button!");
				b = btnNE;
			}
			if (e.getSource() == btnW) { 
				System.out.println("W button!");
				b = btnW;
			}
			if (e.getSource() == btnC) { 
				System.out.println("C button!");
				b = btnC;
			}
			if (e.getSource() == btnE) { 
				System.out.println("E button!");
				b = btnE;
			}
			if (e.getSource() == btnSW) { 
				System.out.println("SW button!");
				b = btnSW;
			}
			if (e.getSource() == btnS) { 
				System.out.println("S button!");
				b = btnS;
			}
			if (e.getSource() == btnSE) { 
				System.out.println("SE button!");
				b = btnSE;
			}
			
			if (b.getToolTipText() != null) {
				strTip = b.getToolTipText();
			}
			else {
				strTip = "";
			}
			switch (strTip) {
			case PLAYERX:
			case PLAYERO:
				System.out.println("Space already marked with "+strTip+". Please mark another box.");
				break;
			default:
				b.setText(playerTurn);
				b.setToolTipText(playerTurn);
				if (playerTurn == PLAYERX) {
					b.setIcon(xbut);
					checkWinner(lstButtons, playerTurn);
					playerTurn = PLAYERO;
					rbPlayer1.setSelected(false);
					rbPlayer2.setSelected(true);
				}
				else {
					b.setIcon(obut);
					checkWinner(lstButtons, playerTurn);
					playerTurn = PLAYERX;
					rbPlayer1.setSelected(true);
					rbPlayer2.setSelected(false);
				}
			}
			//System.out.println("tooltip of button is: "+b.getToolTipText());

			/**
			 * Check if there's a winner
			 */
			//checkWinner(lstButtons);
		}
		
	}
	
	/**
	 * Check buttons list to see if there's a winner
	 * @param List lstb all 9 TTT buttons as an ArrayList
	 * @param String player current player, as String "x" or String "o"
	 * @return void 
	 */
	private void checkWinner(List<JButton> lstb, String player) {

		String strBoardState = "";
		String strP1 = "";
		String strP2 = "";
		String[] p = new String[10];
		boolean blnIsWinner = false;

		
		int i=1;
		for(JButton jb: lstb) {
			if (jb.getToolTipText() == null) {
				strBoardState += " ";
			}
			else {
				strBoardState += jb.getToolTipText();
				if (jb.getToolTipText()==PLAYERX) {
					strP1 += String.valueOf(i);
				}
				else {
					strP2 += String.valueOf(i);
				}
			}
			p[i] = jb.getToolTipText();
			i++;
		}
		//System.out.println("State of game is: " + strBoardState + ", " + strP1 + ", " + strP2);
		
		if (p[1]==player && p[2]==player && p[3]==player) { // 123
			btnNW.setBackground(clrWinner);
			btnN.setBackground(clrWinner);
			btnNE.setBackground(clrWinner);
			blnIsWinner = true;
		}
		if (p[4]==player && p[5]==player && p[6]==player) { // 456
			btnW.setBackground(clrWinner);
			btnC.setBackground(clrWinner);
			btnE.setBackground(clrWinner);
			blnIsWinner = true;
		}
		if (p[7]==player && p[8]==player && p[9]==player) { // 789
			btnSW.setBackground(clrWinner);
			btnS.setBackground(clrWinner);
			btnSE.setBackground(clrWinner);
			blnIsWinner = true;
		}
		if (p[1]==player && p[4]==player && p[7]==player) { // 147
			btnNW.setBackground(clrWinner);
			btnW.setBackground(clrWinner);
			btnSW.setBackground(clrWinner);
			blnIsWinner = true;
		}
		if (p[2]==player && p[5]==player && p[8]==player) { // 258
			btnN.setBackground(clrWinner);
			btnC.setBackground(clrWinner);
			btnS.setBackground(clrWinner);
			blnIsWinner = true;
		}
		if (p[3]==player && p[6]==player && p[9]==player) { // 369
			btnNE.setBackground(clrWinner);
			btnE.setBackground(clrWinner);
			btnSE.setBackground(clrWinner);
			blnIsWinner = true;
		}
		if (p[1]==player && p[5]==player && p[9]==player) { // 159
			btnNW.setBackground(clrWinner);
			btnC.setBackground(clrWinner);
			btnSE.setBackground(clrWinner);
			blnIsWinner = true;
		}
		if (p[3]==player && p[5]==player && p[7]==player) { // 357
			btnNE.setBackground(clrWinner);
			btnC.setBackground(clrWinner);
			btnSW.setBackground(clrWinner);
			blnIsWinner = true;
		}

		if (blnIsWinner) {
			endGame(); // disable Buttons and show message
			System.out.println("Game won by "+ player);
		}

		
	}
	
	private void newGame(List<JButton> lstb) {
		for(JButton jb: lstb) {
			jb.setToolTipText("");
			jb.setIcon(null);
			jb.setText("");
			jb.setBackground(getBackground());
			jb.setEnabled(true);
		}
		blnPlayGame = true;
	}
	
	private void endGame() {
		blnPlayGame = false;
	}
}
