import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import br.edu.fatec.controller.AlunoController;
import br.edu.fatec.model.Aluno;
import br.edu.fatec.model.Campus;
import br.edu.fatec.model.Curso;
import br.edu.fatec.model.Ufs;

public class TelaPrincipal extends JFrame {

	private final ButtonGroup Periodo = new ButtonGroup();
	private JButton btnConsultar;
	private JButton btnExcluir;
	private JButton btnExcluir_1;
	private JButton btnLimpar;
	private JButton btnLimpar_1;
	private JButton btnNewButton;
	private JButton btnSalvar;
	private JButton btnSalvar_1;
	private JButton btnSalvar_3;
	private JButton btnSalvar_4;
	private JButton btnSalvar_5;
	private JButton btnSalvar_6;
	private JComboBox<String> comboBox_3;
	private JComboBox<String> comboBox_4;
	private JComboBox<String> comboBox_5;
	private JComboBox<String> cboxCampus;
	private JComboBox<String> cboxCurso;
	private JComboBox<String> cboxUf;
	private JEditorPane editorPane_10;
	private JEditorPane editorPane_11;
	private JEditorPane editorPane_12;
	private JEditorPane editorPane_13;
	private JEditorPane editorPane_14;
	private JEditorPane editorPane_8;
	private JEditorPane editorPane_9;
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
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_6;
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
		mnNewMenu.add(mntmNewMenuItem_6);

		mnNewMenu_1 = new JMenu("Cursos");
		menuBar.add(mnNewMenu_1);

		mntmNewMenuItem_3 = new JMenuItem("Cursos");
		mnNewMenu_1.add(mntmNewMenuItem_3);

		mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem_2 = new JMenuItem("Desenvolvedores");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane_1, BorderLayout.CENTER);

		panel_3 = new JPanel();
		tabbedPane_1.addTab("Dados do Aluno", null, panel_3, null);
		panel_3.setLayout(null);

		lblNome = new JLabel("RGM");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome.setBounds(308, 22, 57, 34);
		panel_3.add(lblNome);

		lblNome_2 = new JLabel("Nome");
		lblNome_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_2.setBounds(21, 87, 107, 34);
		panel_3.add(lblNome_2);

		lblNome_1 = new JLabel("CPF");
		lblNome_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_1.setBounds(385, 143, 107, 34);
		panel_3.add(lblNome_1);

		lblNome_3 = new JLabel("Data de Nascimento");
		lblNome_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_3.setBounds(21, 143, 137, 34);
		panel_3.add(lblNome_3);

		lblNome_4 = new JLabel("Endereço");
		lblNome_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_4.setBounds(21, 198, 137, 34);
		panel_3.add(lblNome_4);

		lblNome_5 = new JLabel("Municipio");
		lblNome_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_5.setBounds(21, 254, 137, 34);
		panel_3.add(lblNome_5);

		lblNome_6 = new JLabel("UF");
		lblNome_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_6.setBounds(308, 254, 57, 34);
		panel_3.add(lblNome_6);

		lblNome_7 = new JLabel("Tel.(DDD)");
		lblNome_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_7.setBounds(408, 254, 107, 34);
		panel_3.add(lblNome_7);

		lblNome_8 = new JLabel("E-mail");
		lblNome_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_8.setBounds(21, 311, 107, 34);
		panel_3.add(lblNome_8);
		
		cboxUf = new JComboBox<String>();
		cboxUf.setBounds(341, 259, 57, 27);
		panel_3.add(cboxUf);

		lblNome_9 = new JLabel("Dados do Aluno");
		lblNome_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_9.setBounds(266, 54, 182, 34);
		panel_3.add(lblNome_9);

		lblNome_10 = new JLabel("Dados do Curso");
		lblNome_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_10.setBounds(256, 348, 182, 34);
		panel_3.add(lblNome_10);

		lblNome_11 = new JLabel("Curso");
		lblNome_11.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_11.setBounds(21, 399, 137, 34);
		panel_3.add(lblNome_11);

		cboxCurso = new JComboBox<String>();
		cboxCurso.setBounds(89, 400, 579, 34);
		panel_3.add(cboxCurso);

		cboxCampus = new JComboBox<String>();
		cboxCampus.setBounds(89, 453, 579, 34);
		panel_3.add(cboxCampus);

		lblNome_12 = new JLabel("Campus");
		lblNome_12.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_12.setBounds(10, 452, 137, 34);
		panel_3.add(lblNome_12);

		rdbMatutino = new JRadioButton("Matutino");
		rdbMatutino.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		Periodo.add(rdbMatutino);
		rdbMatutino.setBounds(289, 504, 109, 23);
		panel_3.add(rdbMatutino);

		rdbVespertino = new JRadioButton("Vespertino");
		rdbVespertino.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		Periodo.add(rdbVespertino);
		rdbVespertino.setBounds(406, 504, 109, 23);
		panel_3.add(rdbVespertino);

		rdbNoturno = new JRadioButton("Noturno");
		rdbNoturno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		Periodo.add(rdbNoturno);
		rdbNoturno.setBounds(536, 504, 109, 23);
		panel_3.add(rdbNoturno);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(601, 554, 89, 23);
		panel_3.add(btnSalvar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(366, 554, 89, 23);
		panel_3.add(btnLimpar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(236, 554, 89, 23);
		panel_3.add(btnExcluir);

		lblNome_21 = new JLabel("Periodo");
		lblNome_21.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_21.setBounds(10, 498, 137, 34);
		panel_3.add(lblNome_21);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(485, 554, 89, 23);
		panel_3.add(btnConsultar);
		
		textFRm = new JTextField();
		textFRm.setEnabled(false);
		textFRm.setEditable(false);
		textFRm.setBounds(379, 23, 289, 34);
		panel_3.add(textFRm);
		textFRm.setColumns(10);
		
		textFNome = new JTextField();
		textFNome.setColumns(10);
		textFNome.setBounds(74, 87, 594, 34);
		panel_3.add(textFNome);
		
		textFDNascimento = new JTextField();
		textFDNascimento.setColumns(10);
		textFDNascimento.setBounds(156, 143, 191, 34);
		panel_3.add(textFDNascimento);
		
		textFCpf = new JTextField();
		textFCpf.setColumns(10);
		textFCpf.setBounds(438, 143, 230, 34);
		panel_3.add(textFCpf);
		
		textFEndereco = new JTextField();
		textFEndereco.setColumns(10);
		textFEndereco.setBounds(89, 198, 579, 34);
		panel_3.add(textFEndereco);
		
		textFEmail = new JTextField();
		textFEmail.setColumns(10);
		textFEmail.setBounds(74, 311, 594, 34);
		panel_3.add(textFEmail);
		
		textFMunicipio = new JTextField();
		textFMunicipio.setColumns(10);
		textFMunicipio.setBounds(89, 254, 209, 34);
		panel_3.add(textFMunicipio);
		
		textFTelefone = new JTextField();
		textFTelefone.setColumns(10);
		textFTelefone.setBounds(485, 254, 182, 34);
		panel_3.add(textFTelefone);
		
		JLabel lblNome_8_1 = new JLabel("Ano");
		lblNome_8_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_8_1.setBounds(21, 22, 33, 34);
		panel_3.add(lblNome_8_1);
		
		JLabel lblNome_8_2 = new JLabel("Semestre");
		lblNome_8_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_8_2.setBounds(127, 22, 65, 34);
		panel_3.add(lblNome_8_2);
		
		textFAno = new JTextField();
		textFAno.setText("2023");
		textFAno.setEnabled(false);
		textFAno.setEditable(false);
		textFAno.setColumns(10);
		textFAno.setBounds(56, 23, 65, 34);
		panel_3.add(textFAno);
		
		textFSemestre = new JTextField();
		textFSemestre.setText("2");
		textFSemestre.setEnabled(false);
		textFSemestre.setEditable(false);
		textFSemestre.setColumns(10);
		textFSemestre.setBounds(194, 23, 72, 34);
		panel_3.add(textFSemestre);

		panel_4 = new JPanel();
		tabbedPane_1.addTab("Notas e Faltas", null, panel_4, null);
		panel_4.setLayout(null);

		lblNome_13 = new JLabel("RGM");
		lblNome_13.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_13.setBounds(337, 25, 57, 34);
		panel_4.add(lblNome_13);

		editorPane_8 = new JEditorPane();
		editorPane_8.setBounds(404, 25, 197, 34);
		panel_4.add(editorPane_8);

		lblNome_14 = new JLabel("Nome");
		lblNome_14.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_14.setBounds(10, 103, 107, 34);
		panel_4.add(lblNome_14);

		lblNome_15 = new JLabel("Curso");
		lblNome_15.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_15.setBounds(10, 169, 137, 34);
		panel_4.add(lblNome_15);

		editorPane_10 = new JEditorPane();
		editorPane_10.setBounds(97, 169, 593, 34);
		panel_4.add(editorPane_10);

		lblNome_16 = new JLabel("Desciplina");
		lblNome_16.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_16.setBounds(20, 295, 137, 34);
		panel_4.add(lblNome_16);

		comboBox_3 = new JComboBox<>();
		comboBox_3.setBounds(97, 300, 581, 27);
		panel_4.add(comboBox_3);

		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(420, 343, 113, 27);
		panel_4.add(comboBox_4);

		lblNome_17 = new JLabel("Semestre");
		lblNome_17.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_17.setBounds(293, 338, 137, 34);
		panel_4.add(lblNome_17);

		lblNome_18 = new JLabel("Nota");
		lblNome_18.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_18.setBounds(207, 406, 137, 34);
		panel_4.add(lblNome_18);

		comboBox_5 = new JComboBox();
		comboBox_5.setBounds(273, 411, 113, 27);
		panel_4.add(comboBox_5);

		lblNome_19 = new JLabel("Faltas");
		lblNome_19.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_19.setBounds(441, 406, 137, 34);
		panel_4.add(lblNome_19);

		editorPane_11 = new JEditorPane();
		editorPane_11.setBounds(527, 406, 137, 34);
		panel_4.add(editorPane_11);

		btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.setBounds(602, 541, 89, 23);
		panel_4.add(btnSalvar_1);

		btnLimpar_1 = new JButton("Limpar");
		btnLimpar_1.setBounds(489, 541, 89, 23);
		panel_4.add(btnLimpar_1);

		btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.setBounds(242, 541, 89, 23);
		panel_4.add(btnExcluir_1);

		editorPane_13 = new JEditorPane();
		editorPane_13.setBounds(97, 103, 593, 34);
		panel_4.add(editorPane_13);

		lblNome_22 = new JLabel("Dados para registro");
		lblNome_22.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_22.setBounds(293, 255, 137, 34);
		panel_4.add(lblNome_22);

		btnSalvar_6 = new JButton("Consultar");
		btnSalvar_6.setBounds(376, 541, 89, 23);
		panel_4.add(btnSalvar_6);

		panel_6 = new JPanel();
		tabbedPane_1.addTab("Boletim", null, panel_6, null);
		panel_6.setLayout(null);

		editorPane_12 = new JEditorPane();
		editorPane_12.setBounds(330, 25, 197, 34);
		panel_6.add(editorPane_12);

		lblNome_20 = new JLabel("RGM");
		lblNome_20.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_20.setBounds(263, 25, 57, 34);
		panel_6.add(lblNome_20);

		lblNome_23 = new JLabel("Nome");
		lblNome_23.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_23.setBounds(21, 82, 107, 34);
		panel_6.add(lblNome_23);

		editorPane_9 = new JEditorPane();
		editorPane_9.setBounds(83, 82, 593, 34);
		panel_6.add(editorPane_9);

		lblNome_24 = new JLabel("Registro de notas e faltas");
		lblNome_24.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_24.setBounds(246, 190, 240, 34);
		panel_6.add(lblNome_24);

		txtMostrar = new TextArea();
		txtMostrar.setBounds(21, 230, 670, 258);
		panel_6.add(txtMostrar);

		editorPane_14 = new JEditorPane();
		editorPane_14.setBounds(83, 143, 593, 34);
		panel_6.add(editorPane_14);

		lblNome_25 = new JLabel("Curso");
		lblNome_25.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome_25.setBounds(21, 143, 107, 34);
		panel_6.add(lblNome_25);

		btnSalvar_3 = new JButton("Consultar");
		btnSalvar_3.setBounds(587, 544, 89, 23);
		panel_6.add(btnSalvar_3);

		btnSalvar_4 = new JButton("Limpar");
		btnSalvar_4.setBounds(459, 544, 89, 23);
		panel_6.add(btnSalvar_4);

		btnSalvar_5 = new JButton("PDF");
		btnSalvar_5.setBounds(10, 557, 89, 23);
		panel_6.add(btnSalvar_5);
		
		
		
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
		

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AlunoController al = AlunoController.getInstance();
					String rm = al.salvaAluno(
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
					textFRm.setText(rm);
					JOptionPane.showMessageDialog(null, "Aluno salvo com rm: "+rm+"\npressione limpar para salvar proximo aluno");
					btnSalvar.setEnabled(false);
					
				}catch(Exception err) {
					JOptionPane.showMessageDialog(null, err.getMessage());

				}

				
			}
		});
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AlunoController al = AlunoController.getInstance();
			        ImageIcon icon = new ImageIcon("src/images/icons8-look-for-32.png");
			        String entrada = (String)JOptionPane.showInputDialog(null,"Cpf-11 caracteres \nRm-12 caracteres",
			        		"Pesquisa de aluno", JOptionPane.INFORMATION_MESSAGE, icon,null,"");

			        if(entrada != null) {
			        	String[] options = al.retornaBuscaAluno(entrada);
			        	entrada = (String)JOptionPane.showInputDialog(null,"Alunos encontrados",
			        			"Pesquisa de aluno", JOptionPane.QUESTION_MESSAGE,icon, options, options[2]);			        	
			        }
			        
			        String array[] = new String[3];
			        array = entrada.split(" - ");
			        JOptionPane.showMessageDialog(null, array[0]);
			        Aluno aluno = al.buscaPorRm(array[0]);
					textFCpf.setText(aluno.getCpf()); //cpf
					textFEmail.setText(aluno.getEmail()); //email
					textFNome.setText(aluno.getNome()); // nome
					textFDNascimento.setText(aluno.getData_nascimento()); //data_nascimento
					textFEndereco.setText(aluno.getEndereco()); //endereco
					textFMunicipio.setText(aluno.getMunicipio()); //municipio
					textFTelefone.setText(aluno.getTelefone());//telefone
					textFRm.setText(aluno.getRm()); //rm
			        
			    }
				catch(Exception err) {
					JOptionPane.showMessageDialog(null, err.getMessage());
				}
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFCpf.setText(""); //cpf
				textFEmail.setText(""); //email
				textFNome.setText(""); // nome
				textFDNascimento.setText(""); //data_nascimento
				textFEndereco.setText(""); //endereco
				textFMunicipio.setText(""); //municipio
				textFTelefone.setText("");//telefone
				textFRm.setText(""); //rm
				btnSalvar.setEnabled(true);

				
			}
		});
		
	}
}
