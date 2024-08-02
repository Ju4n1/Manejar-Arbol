package Programa;

import java.awt.EventQueue;
import TDAArbol.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import TDALista.*;


/**
 * Clase GUI modela la interfaz gráfica de la aplicacion.
 * 
 * @author Juan cruz Feuilles
 *
 */
public class GUI {

	private JFrame frmAr;
	private JTextField textField;
	private JTextField textField_1;
	private Aplicacion E1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String salida;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmAr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAr = new JFrame();
		frmAr.setTitle("Arbolator 2000");
		frmAr.setBounds(100, 100, 800, 600);
		frmAr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAr.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Mostrar mapeo");
		
		JButton btnCrearrbol = new JButton("Crear \u00C1rbol");
		
		JButton btnNewButton = new JButton("Mapear \u00E1rbol");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    salida=E1.altYprof();
				JOptionPane.showMessageDialog(null,"El mapeo se creó con éxito");
				btnNewButton_1.setEnabled(true);
			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(10, 517, 142, 23);
		frmAr.getContentPane().add(btnNewButton);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(377, 62, 380, 420);
		frmAr.getContentPane().add(textArea_1);
		
	
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
         textArea_1.setText(textArea_1.getText()+"\n"+salida);                                         }
		});
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(186, 517, 142, 23);
		frmAr.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Mostrar Niveles");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			           Tree<Integer>arbol=E1.getTree();
				        String s=textArea_1.getText()+"\n"+"Niveles:"+"\n"+E1.nivel(arbol);
			            textArea_1.setText(s);
			
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(10, 300, 149, 23);
		frmAr.getContentPane().add(btnNewButton_2);
		
		
		JButton btnNewButton_5 = new JButton("Espejo ME");
		btnNewButton_5.setEnabled(false);
		btnNewButton_5.setBounds(25, 366, 100, 23);
		frmAr.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("Mostrar PreOrden");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  Tree<Integer>arbol=E1.getTree();
			  String s=textArea_1.getText()+"\n"+E1.preOrd(arbol)+"\n";
					 
				    textArea_1.setText(s);
				
			                    		
			}
		});
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(10, 253, 149, 23);
		frmAr.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Mostrar PosOrden");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tree<Integer>arbol=E1.getTree();   
				String s=textArea_1.getText()+"\n"+E1.posOrd(arbol)+"\n";
			      textArea_1.setText(s);
			}
		});
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setBounds(10, 207, 149, 23);
		frmAr.getContentPane().add(btnNewButton_4);
		
		JButton btnAgregarElemento = new JButton("Agregar elemento");
		btnAgregarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			     
				  String rot,rotP; 
				  
				  rot=textField_1.getText();
				  rotP=textField.getText();
			     
			     if (rot.equals("")||rotP.equals(""))
			    	 
			    	 JOptionPane.showMessageDialog(null,"Por favor verifique que ingreso un entero en los campos de texto ''Rotulo Elemento'' y ''Rotulo Padre''");	 
			    

			     else
			     try{     
			         E1.insertar(Integer.parseInt(rotP), Integer.parseInt(rot));
			         JOptionPane.showMessageDialog(null,"se agregó el elemento con éxito");
			         
			         textField.setText(null);
			         textField_1.setText(null);}
		       	catch(InvalidPositionException e){JOptionPane.showMessageDialog(null,"Verifique que el rotulo padre pertenezca al árbol");}
			}
		});
		btnAgregarElemento.setEnabled(false);
		btnAgregarElemento.setBounds(112, 158, 142, 23);
		frmAr.getContentPane().add(btnAgregarElemento);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(220, 127, 108, 20);
		frmAr.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
	    textField_1.setBounds(44, 127, 108, 20);
		frmAr.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(28, 428, 86, 20);
		frmAr.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(135, 428, 86, 20);
		frmAr.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		

		
		
		JButton btnAncestroComn = new JButton("Ancestro Com\u00FAn");
		btnAncestroComn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rot1,rot2;
				
				rot1=textField_2.getText();
				rot2=textField_3.getText();
				
               if (rot1.equals("")||rot2.equals(""))
			    	 
			    	 JOptionPane.showMessageDialog(null,"Por favor verifique que ingreso un entero en los campos de texto ''Rotulo 1'' y ''Rotulo 2''");	 
				
               else
				try{
				   String s=textArea_1.getText()+"\n"+"El ancestro común entre "+rot1+" y "+rot2+" es: "+E1.AncestroComun(Integer.parseInt(rot1),Integer.parseInt(rot2));
				   textArea_1.setText(s);
				   textField_2.setText(null);
				   textField_3.setText(null);
				   }
				catch(InvalidPositionException e1){JOptionPane.showMessageDialog(null,"Verifique que los rotulos ingresados sean enteros y pertenezcan al árbol para buscar su ancestro común");}
				
				}
		});
		btnAncestroComn.setEnabled(false);
		btnAncestroComn.setBounds(52, 459, 144, 23);
		frmAr.getContentPane().add(btnAncestroComn);
		
		JLabel lblRotulo = new JLabel("Rotulo 1");
		lblRotulo.setBounds(44, 415, 46, 14);
		frmAr.getContentPane().add(lblRotulo);
		
		JLabel lblRotulo_1 = new JLabel("Rotulo 2");
		lblRotulo_1.setBounds(155, 415, 46, 14);
		frmAr.getContentPane().add(lblRotulo_1);
		
		JLabel lblRotuloElemento = new JLabel("Rotulo elemento");
		lblRotuloElemento.setBounds(51, 112, 108, 14);
		frmAr.getContentPane().add(lblRotuloElemento);
		
		JLabel lblRotuloPadre = new JLabel("Rotulo padre");
		lblRotuloPadre.setBounds(235, 112, 108, 14);
		frmAr.getContentPane().add(lblRotuloPadre);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setEnabled(false);
		
		
		
		btnCrearrbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (textField_1.getText().equals(""))
					
					JOptionPane.showMessageDialog(null, "Ingrese un rotulo para la raíz en el campo de texto ''Rotulo elemento''");
				else{	
					 
					 int raiz=Integer.parseInt(textField_1.getText());
                     E1=new Aplicacion(raiz);
				    
                     textField.setEnabled(true);
				     btnAgregarElemento.setEnabled(true);
				     btnNewButton_4.setEnabled(true);
				     btnNewButton_3.setEnabled(true);
				     btnNewButton_2.setEnabled(true);
				    
				     btnNewButton.setEnabled(true);
				     textField_1.setText(null);
				     textField.setText(null);
				     textField.setText(null);
				     btnCrearrbol.setEnabled(false);
				     btnReiniciar.setEnabled(true);
				     textField_2.setEnabled(true);
				     textField_3.setEnabled(true);
				     textField_4.setEnabled(true);
				     btnAncestroComn.setEnabled(true);
				     btnNewButton_5.setEnabled(true);
			    

				     JOptionPane.showMessageDialog(null, "El árbol se creó con éxito");
				    }
				}
		});
		btnCrearrbol.setBounds(130, 40, 108, 23);
		frmAr.getContentPane().add(btnCrearrbol);
		
		
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int i= JOptionPane.showConfirmDialog(null, "Desea reinciar la aplicación, considere que perderá los datos cargados en el árbol");
				
				if(i==0)
				
			    	{E1=null;
				     btnCrearrbol.setEnabled(true);
				     textField.setEnabled(false);
				     btnAgregarElemento.setEnabled(false);
				     btnNewButton_4.setEnabled(false);
				     btnNewButton_3.setEnabled(false);
				     btnNewButton_2.setEnabled(false);
				     btnNewButton_1.setEnabled(false);
				     btnNewButton.setEnabled(false);
				     textField_1.setText(null);
				     textField.setText(null);
				     textArea_1.setText(null);
				     textField_2.setEnabled(false);
				     textField_3.setEnabled(false);
				     textField_4.setEnabled(false);
				     btnAncestroComn.setEnabled(false);
				     btnCrearrbol.setEnabled(true);
			         btnReiniciar.setEnabled(false);
			         btnNewButton_5.setEnabled(false);}
				}
		});
		btnReiniciar.setBounds(508, 517, 89, 23);
		frmAr.getContentPane().add(btnReiniciar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  
			  int i= JOptionPane.showConfirmDialog(null, "Desea cerrar la aplicación");
			 
			  if(i==0)
			      System.exit(0);
			}
		});
		btnCerrar.setBounds(616, 517, 89, 23);
		frmAr.getContentPane().add(btnCerrar);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(135, 367, 103, 20);
		frmAr.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblMltiploEsjejo = new JLabel("M\u00FAltiplo Espejo");
		lblMltiploEsjejo.setBounds(150, 352, 88, 14);
		frmAr.getContentPane().add(lblMltiploEsjejo);
		
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tree<Integer>t1=E1.espejo(Integer.parseInt(textField_4.getText()));
				
				String arbol=E1.nivel(t1);
				
			
			
				 String s=textArea_1.getText()+"\n"+"Espejo mutiplicado por "+textField_4.getText() +" por niveles:"+"\n"+arbol;
				 textField_4.setText(null);
				 textArea_1.setText(s);
			
			}
		});
		
		
		
		
		
		
		
		
	}
}
