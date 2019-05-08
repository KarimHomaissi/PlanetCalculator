
package planet;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class PlanetCalculator extends JFrame implements ItemListener,ActionListener{

    JRadioButton r1,r2,r3,r4,r5,r6;
    JTextField t1;
    JButton b1;
    Double result;
    String planeta;
    ButtonGroup bg;
    JLabel lbl = new JLabel("");
    
    
    public PlanetCalculator(){
        super("Planet Calculator!!!");
        this.result = 0.0;
        this.config();
        this.componentes();
        setVisible(true);
    }
    
    public final void config(){
        setSize(300,160);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        Image icone = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("icon.png"));  
        setIconImage(icone);
    }
    
    public final void componentes(){
        
        
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new GridLayout(2,3));
        
        JLabel l1 = new JLabel("Peso na Terra (kg): ");
        JLabel l2 = new JLabel("Selecione o Planeta: ");
        l1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        l2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        
        t1 = new JTextField(12);
        t1.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                try{
                   Double.parseDouble(""+e.getKeyChar());
                }catch(NumberFormatException n){
                    t1.setText(null);
                }
            }
        });
        b1 = new JButton("Calcular Peso");
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        
        r1 = new JRadioButton("Mercúrio");
        r2 = new JRadioButton("Marte");
        r3 = new JRadioButton("Saturno");
        r4 = new JRadioButton("Vênus");
        r5 = new JRadioButton("Júpiter");
        r6 = new JRadioButton("Urano");
        
        r1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        r2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        r3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        r4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        r5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        r6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        bg.add(r5);
        bg.add(r6);
        
        r1.addItemListener(this);
        r2.addItemListener(this);
        r3.addItemListener(this);
        r4.addItemListener(this);
        r5.addItemListener(this);
        r6.addItemListener(this);
        
        p1.add(l1, FlowLayout.LEFT);
        
        p2.add(t1);
        p2.add(b1);
        p2.add(lbl);
        p2.add(l2);
        
        p3.add(r1);
        p3.add(r2);
        p3.add(r3);
        p3.add(r4);
        p3.add(r5);
        p3.add(r6);
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
    }
    
    @Override
    public void itemStateChanged(ItemEvent ie) {
        
        if(r1.isSelected()){
            planeta = "Mercurio";
            result = 0.37;
        }else if(r2.isSelected()){
            planeta = "Marte";
            result = 0.38;
        }else if(r3.isSelected()){
            planeta = "Saturno";
            result = 1.15;
        }else if(r4.isSelected()){
            planeta = "Venus";
            result = 0.88;
        }else if(r5.isSelected()){
            planeta = "Jupiter";
            result = 2.64;
        }else if(r6.isSelected()){
            planeta = "Urano";
            result = 1.17;
        }
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            if(planeta != null){
                
                try{
                    result *= Double.parseDouble(t1.getText());
                    JOptionPane.showMessageDialog(null, "O seu peso em "+planeta+" é: "+result+" kg");
                    lbl.setText(null);
                    lbl.setBorder(null);
                    setSize(300,160);
                }catch(NumberFormatException e){
                    setSize(300,180);
                    lbl.setText("Insira um valor válido no Campo!!");
                    lbl.setForeground(Color.RED);
                    lbl.setBorder(BorderFactory.createEtchedBorder(Color.red, Color.red));
                    lbl.setFont(new Font("Arial",Font.PLAIN,14));
                    t1.setText(null);
                }
                
            }else{
                    setSize(300,180);
                    lbl.setText("Selecione um Planeta Válido");
                    lbl.setForeground(Color.RED);
                    lbl.setBorder(BorderFactory.createEtchedBorder(Color.red, Color.red));
                    lbl.setFont(new Font("Arial",Font.PLAIN,14));
            }
        }
    }
    
    public static void main(String[] args) {
        PlanetCalculator pc = new PlanetCalculator();
    }
}
