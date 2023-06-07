import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;

import br.edu.fatec.controller.AlunoController;
import br.edu.fatec.model.Aluno;
import br.edu.fatec.model.Campus;
import br.edu.fatec.model.Curso;
import br.edu.fatec.model.Disciplina;
import br.edu.fatec.model.Ufs;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;

public class TelaPrincipal extends JFrame {

	private final ButtonGroup Periodo = new ButtonGroup();
	private JButton btnConsultar;
	private JButton btnExcluir;
	private JButton btnLimpar;
	private JButton btnNewButton;
	private JButton btnSalvar;
	private JButton btnConsultar_3;
	private JButton btnLimpar_3;
	private JButton btnSalvar_5;
	private JComboBox<String> cboxDisciplina;
	private JComboBox<String> cboxCampus;
	private JComboBox<String> cboxCurso;
	private JComboBox<String> cboxUf;
	private JLabel lblNome;
	private JLabel lblNome_1;
	private JLabel lblNome_10;
	private JLabel lblNome_11;
	private JLabel lblNome_12;
	private JLabel lblNome_13;
	private JLabel lblNome_14;
	private JLabel lblNome_15;
	private JLabel lblNome_16;
	private JLabel lblNome_17;
	private JLabel lblNome_18;
	private JLabel lblNome_19;
	private JLabel lblNome_2;
	private JLabel lblNome_20;
	private JLabel lblNome_21;
	private JLabel lblNome_22;
	private JLabel lblNome_23;
	private JLabel lblNome_24;
	private JLabel lblNome_25;
	private JLabel lblNome_3;
	private JLabel lblNome_4;
	private JLabel lblNome_5;
	private JLabel lblNome_6;
	private JLabel lblNome_7;
	private JLabel lblNome_8;
	private JLabel lblNome_9;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_6;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel dadosDoAluno;
	private JPanel notasEFaltas;
	private JPanel boletim;
	private JRadioButton rdbMatutino;
	private JRadioButton rdbNoturno;
	private JRadioButton rdbVespertino;
	private JTabbedPane tabbedPane;
	private JTabbedPane tabbedPane_1;
	private JTextField textFCpf;
	private JTextField textFDNascimento;
	private JTextField textFEmail;
	private JTextField textFEndereco;
	private JTextField textFMunicipio;
	private JTextField textFNome;
	private JTextField textFRm;
	private JTextField textFTelefone;
	private TextArea txtMostrar;
	private JTextField textFAno;
	private JTextField textFSemestre;
	private JTextField textFRm_2;
	private JTextField textFNome_2;
	private JTextField textFCurso_2;
	private JTextField textFieldAno_2;
	private JTextField textFieldSemestre_2;
	private JTextField textFNota_2;
	private JTextField textFFaltas_2;
	private JTextField textFRm_3;
	private JTextField textFNome_3;
	private JTextField textFCurso_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 690);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Alunos");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Novo");
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem_6 = new JMenuItem("Sair");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_6);

		mnNewMenu_1 = new JMenu("Cursos");
		menuBar.add(mnNewMenu_1);

		mntmNewMenuItem_3 = new JMenuItem("Cursos");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cursos c = new Cursos();
				c.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem_2 = new JMenuItem("Desenvolvedores");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help h = new Help();
				h.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane_1, BorderLayout.CENTER);

		dadosDoAluno = new JPanel();
		tabbedPane_1.addTab("Dados do Aluno", null, dadosDoAluno, null);
		dadosDoAluno.setLayout(null);

		lblNome = new JLabel("RGM");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome.setBounds(308, 22, 57, 34);
		dadosDoAluno.add(lblNome);

		lblNome_2 = new JLabel("Nome");
		lblNome_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_2.setBounds(21, 87, 107, 34);
		dadosDoAluno.add(lblNome_2);

		lblNome_1 = new JLabel("CPF");
		lblNome_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_1.setBounds(385, 143, 107, 34);
		dadosDoAluno.add(lblNome_1);

		lblNome_3 = new JLabel("Data de Nascimento");
		lblNome_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_3.setBounds(21, 143, 137, 34);
		dadosDoAluno.add(lblNome_3);

		lblNome_4 = new JLabel("Endereço");
		lblNome_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_4.setBounds(21, 198, 137, 34);
		dadosDoAluno.add(lblNome_4);

		lblNome_5 = new JLabel("Municipio");
		lblNome_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_5.setBounds(21, 254, 137, 34);
		dadosDoAluno.add(lblNome_5);

		lblNome_6 = new JLabel("UF");
		lblNome_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_6.setBounds(308, 254, 57, 34);
		dadosDoAluno.add(lblNome_6);

		lblNome_7 = new JLabel("Tel.(DDD)");
		lblNome_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_7.setBounds(408, 254, 107, 34);
		dadosDoAluno.add(lblNome_7);

		lblNome_8 = new JLabel("E-mail");
		lblNome_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_8.setBounds(21, 311, 107, 34);
		dadosDoAluno.add(lblNome_8);
		
		cboxUf = new JComboBox<String>();
		cboxUf.setBounds(341, 259, 57, 27);
		dadosDoAluno.add(cboxUf);

		lblNome_9 = new JLabel("Dados do Aluno");
		lblNome_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_9.setBounds(266, 54, 182, 34);
		dadosDoAluno.add(lblNome_9);

		lblNome_10 = new JLabel("Dados do Curso");
		lblNome_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_10.setBounds(256, 348, 182, 34);
		dadosDoAluno.add(lblNome_10);

		lblNome_11 = new JLabel("Curso");
		lblNome_11.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_11.setBounds(21, 399, 137, 34);
		dadosDoAluno.add(lblNome_11);

		cboxCurso = new JComboBox<String>();
		cboxCurso.setBounds(89, 400, 579, 34);
		dadosDoAluno.add(cboxCurso);

		cboxCampus = new JComboBox<String>();
		cboxCampus.setBounds(89, 453, 579, 34);
		dadosDoAluno.add(cboxCampus);

		lblNome_12 = new JLabel("Campus");
		lblNome_12.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_12.setBounds(10, 452, 137, 34);
		dadosDoAluno.add(lblNome_12);

		rdbMatutino = new JRadioButton("Matutino");
		rdbMatutino.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		Periodo.add(rdbMatutino);
		rdbMatutino.setBounds(289, 504, 109, 23);
		dadosDoAluno.add(rdbMatutino);

		rdbVespertino = new JRadioButton("Vespertino");
		rdbVespertino.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		Periodo.add(rdbVespertino);
		rdbVespertino.setBounds(406, 504, 109, 23);
		dadosDoAluno.add(rdbVespertino);

		rdbNoturno = new JRadioButton("Noturno");
		rdbNoturno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		Periodo.add(rdbNoturno);
		rdbNoturno.setBounds(536, 504, 109, 23);
		dadosDoAluno.add(rdbNoturno);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(601, 554, 89, 23);
		dadosDoAluno.add(btnSalvar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(366, 554, 89, 23);
		dadosDoAluno.add(btnLimpar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(236, 554, 89, 23);
		dadosDoAluno.add(btnExcluir);

		lblNome_21 = new JLabel("Periodo");
		lblNome_21.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_21.setBounds(10, 498, 137, 34);
		dadosDoAluno.add(lblNome_21);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(485, 554, 89, 23);
		dadosDoAluno.add(btnConsultar);
		
		textFRm = new JTextField();
		textFRm.setEnabled(false);
		textFRm.setEditable(false);
		textFRm.setBounds(379, 23, 289, 34);
		dadosDoAluno.add(textFRm);
		textFRm.setColumns(10);
		textFRm.setText("");
		
		textFNome = new JTextField();
		textFNome.setColumns(10);
		textFNome.setBounds(74, 87, 594, 34);
		dadosDoAluno.add(textFNome);
		
		textFDNascimento = new JTextField();
		textFDNascimento.setColumns(10);
		textFDNascimento.setBounds(156, 143, 191, 34);
		dadosDoAluno.add(textFDNascimento);
		
		textFCpf = new JTextField();
		textFCpf.setColumns(10);
		textFCpf.setBounds(438, 143, 230, 34);
		dadosDoAluno.add(textFCpf);
		
		textFEndereco = new JTextField();
		textFEndereco.setColumns(10);
		textFEndereco.setBounds(89, 198, 579, 34);
		dadosDoAluno.add(textFEndereco);
		
		textFEmail = new JTextField();
		textFEmail.setColumns(10);
		textFEmail.setBounds(74, 311, 594, 34);
		dadosDoAluno.add(textFEmail);
		
		textFMunicipio = new JTextField();
		textFMunicipio.setColumns(10);
		textFMunicipio.setBounds(89, 254, 209, 34);
		dadosDoAluno.add(textFMunicipio);
		
		textFTelefone = new JTextField();
		textFTelefone.setColumns(10);
		textFTelefone.setBounds(485, 254, 182, 34);
		dadosDoAluno.add(textFTelefone);
		
		JLabel lblNome_8_1 = new JLabel("Ano");
		lblNome_8_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_8_1.setBounds(21, 22, 33, 34);
		dadosDoAluno.add(lblNome_8_1);
		
		JLabel lblNome_8_2 = new JLabel("Semestre");
		lblNome_8_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_8_2.setBounds(127, 22, 65, 34);
		dadosDoAluno.add(lblNome_8_2);
		
		textFAno = new JTextField();
		textFAno.setText("2023");
		textFAno.setEnabled(false);
		textFAno.setEditable(false);
		textFAno.setColumns(10);
		textFAno.setBounds(56, 23, 65, 34);
		dadosDoAluno.add(textFAno);
		
		textFSemestre = new JTextField();
		textFSemestre.setText("2");
		textFSemestre.setEnabled(false);
		textFSemestre.setEditable(false);
		textFSemestre.setColumns(10);
		textFSemestre.setBounds(194, 23, 72, 34);
		dadosDoAluno.add(textFSemestre);

		notasEFaltas = new JPanel();
		tabbedPane_1.addTab("Notas e Faltas", null, notasEFaltas, null);
		notasEFaltas.setLayout(null);

		lblNome_13 = new JLabel("RGM");
		lblNome_13.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_13.setBounds(337, 25, 57, 34);
		notasEFaltas.add(lblNome_13);

		lblNome_14 = new JLabel("Nome");
		lblNome_14.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_14.setBounds(10, 103, 107, 34);
		notasEFaltas.add(lblNome_14);

		lblNome_15 = new JLabel("Curso");
		lblNome_15.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_15.setBounds(10, 169, 137, 34);
		notasEFaltas.add(lblNome_15);

		lblNome_16 = new JLabel("Desciplina");
		lblNome_16.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_16.setBounds(20, 295, 137, 34);
		notasEFaltas.add(lblNome_16);

		cboxDisciplina = new JComboBox<String>();
		cboxDisciplina.setBounds(97, 300, 581, 27);
		notasEFaltas.add(cboxDisciplina);

		lblNome_17 = new JLabel("Semestre");
		lblNome_17.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_17.setBounds(242, 340, 63, 34);
		notasEFaltas.add(lblNome_17);

		lblNome_18 = new JLabel("Nota");
		lblNome_18.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_18.setBounds(208, 406, 38, 34);
		notasEFaltas.add(lblNome_18);

		lblNome_19 = new JLabel("Faltas");
		lblNome_19.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_19.setBounds(441, 406, 50, 34);
		notasEFaltas.add(lblNome_19);

		lblNome_22 = new JLabel("Dados para registro");
		lblNome_22.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_22.setBounds(293, 255, 137, 34);
		notasEFaltas.add(lblNome_22);
		
		textFRm_2 = new JTextField();
		textFRm_2.setEnabled(false);
		textFRm_2.setEditable(false);
		textFRm_2.setColumns(10);
		textFRm_2.setBounds(389, 25, 289, 34);
		notasEFaltas.add(textFRm_2);
		
		textFNome_2 = new JTextField();
		textFNome_2.setEnabled(false);
		textFNome_2.setEditable(false);
		textFNome_2.setColumns(10);
		textFNome_2.setBounds(57, 103, 621, 34);
		notasEFaltas.add(textFNome_2);
		
		textFCurso_2 = new JTextField();
		textFCurso_2.setEnabled(false);
		textFCurso_2.setEditable(false);
		textFCurso_2.setColumns(10);
		textFCurso_2.setBounds(57, 169, 621, 34);
		notasEFaltas.add(textFCurso_2);
		
		textFieldAno_2 = new JTextField();
		textFieldAno_2.setText("2023");
		textFieldAno_2.setEnabled(false);
		textFieldAno_2.setEditable(false);
		textFieldAno_2.setColumns(10);
		textFieldAno_2.setBounds(57, 341, 87, 34);
		notasEFaltas.add(textFieldAno_2);
		
		JLabel lblNome_17_1 = new JLabel("Ano");
		lblNome_17_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_17_1.setBounds(30, 340, 38, 34);
		notasEFaltas.add(lblNome_17_1);
		
		textFieldSemestre_2 = new JTextField();
		textFieldSemestre_2.setText("2");
		textFieldSemestre_2.setEnabled(false);
		textFieldSemestre_2.setEditable(false);
		textFieldSemestre_2.setColumns(10);
		textFieldSemestre_2.setBounds(307, 341, 87, 34);
		notasEFaltas.add(textFieldSemestre_2);
		
		textFNota_2 = new JTextField();
		textFNota_2.setBounds(245, 414, 86, 20);
		notasEFaltas.add(textFNota_2);
		textFNota_2.setColumns(10);
		
		textFFaltas_2 = new JTextField();
		textFFaltas_2.setColumns(10);
		textFFaltas_2.setBounds(489, 414, 86, 20);
		notasEFaltas.add(textFFaltas_2);
		
		JButton btnExcluir_2 = new JButton("Excluir");
		btnExcluir_2.setBounds(224, 540, 89, 23);
		notasEFaltas.add(btnExcluir_2);
		
		JButton btnLimpar_2 = new JButton("Limpar");
		btnLimpar_2.setBounds(354, 540, 89, 23);
		notasEFaltas.add(btnLimpar_2);
		
		JButton btnConsultar_2 = new JButton("Consultar");
		btnConsultar_2.setBounds(473, 540, 89, 23);
		notasEFaltas.add(btnConsultar_2);
		
		JButton btnSalvar_2 = new JButton("Salvar");
		btnSalvar_2.setBounds(589, 540, 89, 23);
		notasEFaltas.add(btnSalvar_2);

		boletim = new JPanel();
		tabbedPane_1.addTab("Boletim", null, boletim, null);
		boletim.setLayout(null);

		lblNome_20 = new JLabel("RGM");
		lblNome_20.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_20.setBounds(263, 25, 57, 34);
		boletim.add(lblNome_20);

		lblNome_23 = new JLabel("Nome");
		lblNome_23.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_23.setBounds(21, 82, 107, 34);
		boletim.add(lblNome_23);

		lblNome_24 = new JLabel("Registro de notas e faltas");
		lblNome_24.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_24.setBounds(246, 190, 240, 34);
		boletim.add(lblNome_24);

		txtMostrar = new TextArea();
		txtMostrar.setBounds(21, 230, 670, 258);
		boletim.add(txtMostrar);

		lblNome_25 = new JLabel("Curso");
		lblNome_25.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_25.setBounds(21, 143, 107, 34);
		boletim.add(lblNome_25);

		btnConsultar_3 = new JButton("Consultar");
		btnConsultar_3.setBounds(587, 544, 89, 23);
		boletim.add(btnConsultar_3);

		btnLimpar_3 = new JButton("Limpar");
		btnLimpar_3.setBounds(459, 544, 89, 23);
		boletim.add(btnLimpar_3);

		btnSalvar_5 = new JButton("PDF");
		btnSalvar_5.setBounds(10, 557, 89, 23);
		boletim.add(btnSalvar_5);
		
		textFRm_3 = new JTextField();
		textFRm_3.setEnabled(false);
		textFRm_3.setEditable(false);
		textFRm_3.setColumns(10);
		textFRm_3.setBounds(330, 26, 289, 34);
		boletim.add(textFRm_3);
		
		textFNome_3 = new JTextField();
		textFNome_3.setEnabled(false);
		textFNome_3.setEditable(false);
		textFNome_3.setColumns(10);
		textFNome_3.setBounds(70, 89, 621, 34);
		boletim.add(textFNome_3);
		
		textFCurso_3 = new JTextField();
		textFCurso_3.setEnabled(false);
		textFCurso_3.setEditable(false);
		textFCurso_3.setColumns(10);
		textFCurso_3.setBounds(70, 155, 621, 34);
		boletim.add(textFCurso_3);
		
		
		// ComboBox UfsCampusCursos
		List<Ufs> lUfs = null;
		List<Campus> lCampus;
		List<Curso> lCursos;
		try {
			AlunoController al = AlunoController.getInstance() ;
			lUfs = al.getlUfs();
			lCampus = al.getlCampus();
			lCursos = al.getlCursos();
			for(Ufs item: lUfs){
				this.cboxUf.addItem(item.getAbreviacao());
			}
			for(Campus item: lCampus){
				this.cboxCampus.addItem(item.getNome());
			}
			for(Curso item: lCursos){
				this.cboxCurso.addItem(item.getNome());
			}
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		// end ComboBox UfsCampusCursos
		
		// Painel DadosDoAluno
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAluno();
			}
		});
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarAluno();
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampoAluno();
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirAluno();
			}
		});
		
		// end Painel DadosDoAluno
		
		// Painel NotasEFaltas
		cboxDisciplina.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pegarNotaEFalta();
			}
			
		});
		
		btnSalvar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AlunoController al = AlunoController.getInstance();
					String rm = textFRm.getText();
					String nome_curso = (String)cboxDisciplina.getSelectedItem();
					String ano_matricula = textFieldAno_2.getText();
					String semestre_matricula = textFieldSemestre_2.getText();
					String nota = textFNota_2.getText();
					String falta = textFFaltas_2.getText();
					al.atualizaNotasEFalatas(rm, nome_curso, ano_matricula, semestre_matricula, nota, falta);
					JOptionPane.showMessageDialog(null, "Nota e falta alterada");
				} catch(Exception err) {
					JOptionPane.showMessageDialog(null, err.getMessage());
				}
			}
		});
		
		btnConsultar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarAluno();
			}
		});
		
		btnLimpar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampoAluno();
			}
		});
		
		btnExcluir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirAluno();

			}
		});
		// end Painel NotasEFaltas
		
		// Painel Boletim
		btnConsultar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				;
			}
		});
		
		// end Painel Boletim
		
	}
	
	/**Método que trata os dados e os envia para o controller
	*/
	private void salvarAluno() {
		try {
			AlunoController al = AlunoController.getInstance();
			String rm = al.alteraSalvaAluno(
					textFRm.getText(),
					textFCpf.getText(), //cpf
					textFEmail.getText(), //email
					textFNome.getText(), // nome
					textFDNascimento.getText(), //data_nascimento
					textFEndereco.getText(), //endereco
					textFMunicipio.getText(), //municipio
					cboxUf.getSelectedIndex()+1, //UF
					cboxCurso.getSelectedIndex()+1, //curso
					cboxCampus.getSelectedIndex()+1, //campus
					textFAno.getText(), //ano_matricula
					textFSemestre.getText(), //semestre_matricula
					textFTelefone.getText() //telefone
					);

			// Painel DadosDoAluno
			textFRm.setText(rm);
			btnSalvar.setText("Alterar");
			// Painel NotasEFaltas
			textFRm_2.setText(rm);
			textFNome_2.setText(textFNome.getText());
			textFCurso_2.setText((String)cboxCurso.getSelectedItem());
			// Painel Boletim
			textFRm_3.setText(rm);
			textFNome_3.setText(textFNome.getText());
			textFCurso_3.setText((String)cboxCurso.getSelectedItem());


		}catch(Exception err) {
			JOptionPane.showMessageDialog(null, err.getMessage());

		}
	}
	
	/**Método que trata os dados e os envia para o controller
	*/
	public void consultarAluno() {
		try {
			AlunoController al = AlunoController.getInstance();
	        ImageIcon icon = new ImageIcon("src/images/icons8-look-for-32.png");
	        String entrada = (String)JOptionPane.showInputDialog(null,"Cpf-11 caracteres \nRm-12 caracteres",
	        		"Pesquisa de aluno", JOptionPane.INFORMATION_MESSAGE, icon,null,"");

	        if(entrada != null) {
	        	String[] options = al.buscaResultadoResumido(entrada);
	        	entrada = (String)JOptionPane.showInputDialog(null,"Alunos encontrados",
	        			"Pesquisa de aluno", JOptionPane.QUESTION_MESSAGE,icon, options, options[0]);			        	
	        	if (entrada != null) {
	        		limparCampoAluno();
	        		String array[] = new String[3];
	        		array = entrada.split(" - ");
	        		Aluno aluno = al.buscaPorRm(array[0]);

	        		//painel dados do aluno
	        		textFCpf.setText(aluno.getCpf()); //cpf
	        		textFEmail.setText(aluno.getEmail()); //email
	        		textFNome.setText(aluno.getNome()); // nome
	        		textFDNascimento.setText(aluno.getData_nascimento()); //data_nascimento
	        		textFEndereco.setText(aluno.getEndereco()); //endereco
	        		textFMunicipio.setText(aluno.getMunicipio()); //municipio
	        		textFTelefone.setText(aluno.getTelefone());//telefone
	        		textFRm.setText(aluno.getRm()); //rm
	        		btnSalvar.setText("Alterar");
	        		
	        		// painel notas e faltas
	        		textFRm_2.setText(aluno.getRm());
	        		textFNome_2.setText(aluno.getNome());
	        		textFCurso_2.setText(array[2]);
	        		carregarDisciplinas(al,aluno.getRm());
	        		// Painel Boletim
	    			textFRm_3.setText(textFRm.getText());
	    			textFNome_3.setText(textFNome.getText());
	    			textFCurso_3.setText(textFCurso_2.getText());
	    			boletim(textFRm.getText());
	        	}
	        }
	    }
		catch(Exception err) {
			JOptionPane.showMessageDialog(null, "erro na view");
		}
	}
	
	private void carregarDisciplinas(AlunoController al, String rm) {
		try {
			List<Disciplina> lDisc = al.buscaDisciplinaCursada(rm);
			if(lDisc.size()>0) {
				DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cboxDisciplina.getModel();
				for(Disciplina item: lDisc){
					model.addElement(item.getNome());
				}
				textFieldAno_2.setText(lDisc.get(0).getAno());
				textFieldSemestre_2.setText(lDisc.get(0).getSemestre());
			}
		} catch(Exception err) {
			JOptionPane.showMessageDialog(null, err.getMessage());
		}
	}
	
	public void limparCampoAluno() {
		textFCpf.setText(""); //cpf
		textFEmail.setText(""); //email
		textFNome.setText(""); // nome
		textFDNascimento.setText(""); //data_nascimento
		textFEndereco.setText(""); //endereco
		textFMunicipio.setText(""); //municipio
		textFTelefone.setText("");//telefone
		textFRm.setText(""); //rm
		textFAno.setText("2023");
		textFSemestre.setText("2");
		btnSalvar.setText("Salvar");
		
	 	// painel notas e faltas
    	textFRm_2.setText("");
    	textFNome_2.setText("");
    	textFCurso_2.setText("");
    	textFieldAno_2.setText("2023");
    	textFieldSemestre_2.setText("2");
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cboxDisciplina.getModel();
		model.removeAllElements();
		
		// Painel Boletim
		textFRm_3.setText("");
    	textFNome_3.setText("");
    	textFCurso_3.setText("");
		
	}
	
	public void excluirAluno() {
		if(!textFRm.getText().equals("")) {
			try {
				AlunoController al = AlunoController.getInstance();
				JOptionPane.showMessageDialog(null, "Aluno Excluido");
				al.excluiAluno(textFRm.getText());
				limparCampoAluno();

			} catch(Exception err) {
				JOptionPane.showMessageDialog(null, err.getMessage());
			}
		}
	}
	
	public void pegarNotaEFalta() {
		try {
			AlunoController al = AlunoController.getInstance();
			String rm = textFRm.getText();
			String nome_curso = (String)cboxDisciplina.getSelectedItem();
			String ano_matricula = textFieldAno_2.getText();
			String semestre_matricula = textFieldSemestre_2.getText();
			String[] res = al.buscaNotasEFaltas(rm, nome_curso, ano_matricula, semestre_matricula);
			textFNota_2.setText(res[0]);
			textFFaltas_2.setText(res[1]);
			boletim(rm);
			
		} catch(Exception err) {
			JOptionPane.showMessageDialog(null, err.getMessage());
		}
	}
	
	public void boletim(String rm) {
		try {
			AlunoController al = AlunoController.getInstance();
			List<String> res = new ArrayList<>();
			res = al.mostraBoletim(rm);
			txtMostrar.setText(String.join("\n", res) );
			
		} catch(Exception err) {
			JOptionPane.showMessageDialog(null, err.getMessage());
		}
	}
}
