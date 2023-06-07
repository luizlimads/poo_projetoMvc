import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Help extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JLabel lblEquipe;
	private JLabel lblConceio;
	private JLabel lblGustavo;
	private JLabel lblLuiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
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
	public Help() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 366);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem = new JMenuItem("Sair");
		mnNewMenu_2.add(mntmNewMenuItem);
		
		mnNewMenu = new JMenu("Aluno");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_1 = new JMenuItem("Aluno");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mnNewMenu_1 = new JMenu("Curso");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEquipe = new JLabel("Equipe");
		lblEquipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblEquipe.setBounds(46, 11, 326, 34);
		contentPane.add(lblEquipe);
		
		lblConceio = new JLabel("Conceição ");
		lblConceio.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblConceio.setBounds(46, 78, 137, 34);
		contentPane.add(lblConceio);
		
		lblGustavo = new JLabel("Gustavo");
		lblGustavo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblGustavo.setBounds(46, 136, 137, 34);
		contentPane.add(lblGustavo);
		
		lblLuiz = new JLabel("Luiz");
		lblLuiz.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblLuiz.setBounds(46, 195, 137, 34);
		contentPane.add(lblLuiz);
	}

}
