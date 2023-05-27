import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Cursos extends JFrame {
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuBar menuBar_1;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmAluno;
	private JMenu mnNewMenu_5;
	private JMenuItem mntmDesenvolvedores;
	private TextArea txtMostrar;
	private JComboBox comboBox;
	private JLabel lblNome;
	private TextArea txtMostrar_1;
	private JComboBox comboBox_1;
	private JLabel lblCurso;
	private JLabel lblDiciplinas;
	private JEditorPane editorPane;
	private JLabel lblRgc;
	private JEditorPane editorPane_1;
	private JLabel lblRgc_1;
	private JEditorPane editorPane_2;
	private JLabel lblCurso_1;
	private JLabel lblRgc_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cursos frame = new Cursos();
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
	public Cursos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 565);
		
		menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		mnNewMenu_3 = new JMenu("Curso");
		menuBar_1.add(mnNewMenu_3);
		
		mntmNewMenuItem = new JMenuItem("Sair");
		mnNewMenu_3.add(mntmNewMenuItem);
		
		mnNewMenu_4 = new JMenu("Aluno");
		menuBar_1.add(mnNewMenu_4);
		
		mntmAluno = new JMenuItem("Aluno");
		mnNewMenu_4.add(mntmAluno);
		
		mnNewMenu_5 = new JMenu("Help");
		menuBar_1.add(mnNewMenu_5);
		
		mntmDesenvolvedores = new JMenuItem("Desenvolvedores");
		mnNewMenu_5.add(mntmDesenvolvedores);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		tabbedPane.addTab("Cursos", null, panel, null);
		panel.setLayout(null);
		
		txtMostrar = new TextArea();
		txtMostrar.setBounds(28, 238, 670, 146);
		panel.add(txtMostrar);
		
		comboBox = new JComboBox();
		comboBox.setBounds(150, 85, 548, 34);
		panel.add(comboBox);
		
		lblNome = new JLabel("Campus");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome.setBounds(28, 84, 137, 34);
		panel.add(lblNome);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(150, 153, 548, 34);
		panel.add(comboBox_1);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblCurso.setBounds(28, 152, 137, 34);
		panel.add(lblCurso);
		
		lblDiciplinas = new JLabel("Diciplinas");
		lblDiciplinas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblDiciplinas.setBounds(264, 198, 137, 34);
		panel.add(lblDiciplinas);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(441, 11, 197, 34);
		panel.add(editorPane);
		
		lblRgc = new JLabel("RGC");
		lblRgc.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblRgc.setBounds(333, 11, 137, 34);
		panel.add(lblRgc);
		
		btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(585, 417, 89, 23);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.setBounds(463, 417, 89, 23);
		panel.add(btnNewButton_1);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Consultas", null, panel_1, null);
		panel_1.setLayout(null);
		
		txtMostrar_1 = new TextArea();
		txtMostrar_1.setBounds(28, 181, 670, 188);
		panel_1.add(txtMostrar_1);
		
		editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(361, 11, 197, 34);
		panel_1.add(editorPane_1);
		
		lblRgc_1 = new JLabel("RGC");
		lblRgc_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblRgc_1.setBounds(251, 11, 137, 34);
		panel_1.add(lblRgc_1);
		
		editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(148, 76, 550, 34);
		panel_1.add(editorPane_2);
		
		lblCurso_1 = new JLabel("Curso");
		lblCurso_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblCurso_1.setBounds(28, 76, 137, 34);
		panel_1.add(lblCurso_1);
		
		lblRgc_2 = new JLabel("Alunos Matriculados");
		lblRgc_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblRgc_2.setBounds(99, 138, 154, 37);
		panel_1.add(lblRgc_2);
		
		btnNewButton_2 = new JButton("Limpar");
		btnNewButton_2.setBounds(478, 413, 89, 23);
		panel_1.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Consultar");
		btnNewButton_3.setBounds(596, 413, 89, 23);
		panel_1.add(btnNewButton_3);
		
	
	}
}
