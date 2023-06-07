import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Cursos extends JFrame implements ActionListener { // isso
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
	private JMenuItem sairMenuItem;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmAluno;
	private JMenu mnNewMenu_5;
	private JMenuItem mntmDesenvolvedores;
	private TextArea txtMostrar;
	private JComboBox cmbCampus;
	private JLabel lblNome;
	private TextArea txtMostrar2;
	private JComboBox cmbCurso;
	private JLabel lblCurso;
	private JLabel lblDiciplinas;
	private JLabel lblRgc;
	private JLabel lblRgc_1;
	private JEditorPane edpCurso2;
	private JLabel lblCurso_1;
	private JLabel lblRgc_2;
	private JButton btnConsultar;
	private JButton btnLimpar;
	private JButton btnLimpar2;
	private JButton btnConsultar2;
	private JTextField txtId;
	private JTextField txtId2;

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
		
		sairMenuItem = new JMenuItem("Sair");
		mnNewMenu_3.add(sairMenuItem);
		
		sairMenuItem.addActionListener(new ActionListener() {       // fechar tudo
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
		
		mnNewMenu_4 = new JMenu("Aluno");
		menuBar_1.add(mnNewMenu_4);
		
		mntmAluno = new JMenuItem("Aluno");
		mntmAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal p = new TelaPrincipal();                     // tela aluno
				p.setVisible(true);
				
			}
		});
		mnNewMenu_4.add(mntmAluno);
		
		mnNewMenu_5 = new JMenu("Help");
		menuBar_1.add(mnNewMenu_5);
		
		mntmDesenvolvedores = new JMenuItem("Desenvolvedores");
		mntmDesenvolvedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help h = new Help();                                     // tela help
				h.setVisible(true);
				
			}
		});
		mnNewMenu_5.add(mntmDesenvolvedores);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		tabbedPane.addTab("Cursos", null, panel, null);
		panel.setLayout(null);
		
		txtMostrar = new TextArea();
		txtMostrar.setBounds(28, 238, 670, 146);
		panel.add(txtMostrar);
		
		cmbCampus = new JComboBox();
		cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"Compus disponiveis", "São Paulo", "Pirassununga", "Guarulhos"}));
		cmbCampus.setBounds(150, 85, 548, 34);
		panel.add(cmbCampus);
		
		lblNome = new JLabel("Campus");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNome.setBounds(28, 84, 137, 34);
		panel.add(lblNome);
		
		cmbCurso = new JComboBox();
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] {"Cursos Disponiveis", "Ciências de Computação", "Ciência de Dados", "Engenharia de Computação"}));
		cmbCurso.setBounds(150, 153, 548, 34);
		panel.add(cmbCurso);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblCurso.setBounds(28, 152, 137, 34);
		panel.add(lblCurso);
		
		lblDiciplinas = new JLabel("Diciplinas");
		lblDiciplinas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblDiciplinas.setBounds(264, 198, 137, 34);
		panel.add(lblDiciplinas);
		
		
		lblRgc = new JLabel("RGC");
		lblRgc.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblRgc.setBounds(333, 11, 137, 34);
		panel.add(lblRgc);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setEnabled(false);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					 btnConsultar.setEnabled(false);

				        // Adiciona um ouvinte de ação ao botão Consultar
				        btnConsultar.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent e) {
				                // Lógica para consultar o ID
				                String id = txtId.getText();
				                // Realiza a consulta...
				            }
				        });

				        // Adicione os componentes ao frame...

				        pack();
				        setVisible(true);
				    }
		});
		
			
		btnConsultar.setBounds(585, 417, 89, 23);
		panel.add(btnConsultar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtId.setText("");  			//Limpa o campo com o ID do curso
				cmbCampus.setSelectedIndex(0); 	//Limpa a seleção da Combo box dos campus
				cmbCurso.setSelectedIndex(0);  	//Limpa a seleção da combo box do nome do curso
				txtMostrar.setText("");  		//Limpa o campo com os nomes das disciplinas referentes ao curso
				
			}
		});
		btnLimpar.setBounds(463, 417, 89, 23);
		panel.add(btnLimpar);
		
		txtId = new JTextField();
		txtId.setBounds(387, 11, 252, 28);
		panel.add(txtId);
		txtId.setColumns(10);
		txtId.getDocument().addDocumentListener(new DocumentListener() { // isso
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateButtonState();
            }
        });
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Consultas", null, panel_1, null);
		panel_1.setLayout(null);
		
		txtMostrar2 = new TextArea();
		txtMostrar2.setBounds(28, 181, 670, 188);
		panel_1.add(txtMostrar2);
		
		lblRgc_1 = new JLabel("RGC");
		lblRgc_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblRgc_1.setBounds(251, 11, 137, 34);
		panel_1.add(lblRgc_1);
		
		edpCurso2 = new JEditorPane();
		edpCurso2.setBounds(148, 76, 550, 34);
		panel_1.add(edpCurso2);
		
		lblCurso_1 = new JLabel("Curso");
		lblCurso_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblCurso_1.setBounds(28, 76, 137, 34);
		panel_1.add(lblCurso_1);
		
		lblRgc_2 = new JLabel("Alunos Matriculados");
		lblRgc_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblRgc_2.setBounds(99, 138, 154, 37);
		panel_1.add(lblRgc_2);
		
		btnLimpar2 = new JButton("Limpar");
		btnLimpar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtId2.setText("");  			//Limpando campo do ID do curso
				edpCurso2.setText(""); 			//Limpando o campo do Nome do curso
				txtMostrar2.setText(""); 		//Limpando a Text Area com o nome dos alunos matriculados no curso referido
				
				
				
			}
		});
		btnLimpar2.setBounds(478, 413, 89, 23);
		panel_1.add(btnLimpar2);
		
		btnConsultar2 = new JButton("Consultar");
		btnConsultar2.setEnabled(false);
		btnConsultar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    // Adiciona um ouvinte de ação ao botão Consultar  <-- esta dando erro
				
			                // Lógica para consultar o ID
			                String id = txtId2.getText();
			                // Realiza a consulta...
			            

			        // Adicione os componentes ao frame

			        pack();
			        setVisible(true);
			    }
	});
				
		btnConsultar2.setBounds(596, 413, 89, 23);
		panel_1.add(btnConsultar2) ;
		
		txtId2 = new JTextField();
		txtId2.setBounds(302, 11, 315, 28);
		panel_1.add(txtId2);
		txtId2.setColumns(10);
		txtId2.getDocument().addDocumentListener(new DocumentListener() {         //<-      isso
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateButtonState2();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateButtonState2();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateButtonState2();
            }
        });
		}
	
		                                      //                                                   <-- tudo isso
	private void updateButtonState() {
        String id = txtId.getText();
        btnConsultar.setEnabled(!id.isEmpty());
    }
	private void updateButtonState2() {
        String id = txtId2.getText();
        btnConsultar2.setEnabled(!id.isEmpty());
    }

    public static void main1(String[] args) {
        SwingUtilities.invokeLater(() -> new Cursos());
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
