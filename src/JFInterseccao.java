import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFInterseccao extends javax.swing.JFrame {
    
    DefaultTableModel modeloRetas;
    DefaultTableModel modeloSimplex;
    int indice = 0; //Índice a ser exibido nas tabelas
    ArrayList<Reta> retas = new ArrayList<>();
    Sintaxe sintaxe;
    Operacoes operacoes;
    
    public JFInterseccao() {
        initComponents();
        //Cor de fundo: branco
        getContentPane().setBackground(Color.white);
        //Centraliza a tela
        this.setLocationRelativeTo(null);
        
        //Desativa o botão "Simplex"
        jBSimplex.setEnabled(false);
        
        modeloRetas = (DefaultTableModel) jTRetas.getModel();
        modeloSimplex = (DefaultTableModel) jTSimplex.getModel();
        sintaxe = new Sintaxe();
        operacoes = new Operacoes();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTFReta = new javax.swing.JTextField();
        jBSimplex = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTRetas = new javax.swing.JTable();
        jBInserir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTSimplex = new javax.swing.JTable();
        jBLimpar = new javax.swing.JButton();
        jBLerArquivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jTFReta.setBorder(javax.swing.BorderFactory.createTitledBorder("Reta"));
        jTFReta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFRetaKeyPressed(evt);
            }
        });

        jBSimplex.setText("Simplex");
        jBSimplex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSimplexActionPerformed(evt);
            }
        });

        jTRetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "indice", "reta"
            }
        ));
        jScrollPane1.setViewportView(jTRetas);

        jBInserir.setText("Inserir");
        jBInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInserirActionPerformed(evt);
            }
        });

        jTSimplex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "x", "y"
            }
        ));
        jScrollPane2.setViewportView(jTSimplex);

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        jBLerArquivo.setText("Ler do arquivo");
        jBLerArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLerArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTFReta, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSimplex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBLerArquivo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTFReta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSimplex)
                    .addComponent(jBInserir)
                    .addComponent(jBLimpar)
                    .addComponent(jBLerArquivo))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSimplexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSimplexActionPerformed
        //Adiciona as colunas para as variáveis de folga de cada equação 
        for (int i = 0; i < indice; i++) {            
            modeloSimplex.addColumn("v" + (i+1));
        }
        
        modeloSimplex.addColumn("R");
        
        //Linha que será adicionada na tabela
        String [] linha = new String[indice+3];
        
        //Verifica se as equações precisam de uma variável de folga e o qual tipo
        for (int i = 0; i < indice; i++) {
            String pontoX = "";
            String pontoY = "";
            String vi = "";
            
            verificarVF(retas.get(i));
            pontoX = retas.get(i).esq.get(0)+"";
            pontoY = retas.get(i).esq.get(1)+"";
            vi = retas.get(i).esq.get(2)+"";
                  
            //System.out.println("teste: "+retas.get(i).dir);
            modeloSimplex.addRow(new String []{pontoX,pontoY,vi});
        }
        
    }//GEN-LAST:event_jBSimplexActionPerformed
      
    //Adiciona uma variável de folga à equação, se necessário
    public void verificarVF(Reta reta){
        if(reta.tipo == '>')
            reta.esq.add(new Termo(-1, "vf"));
        else if(reta.tipo == '<')
            reta.esq.add(new Termo(1, "vf"));        
    }
    
    private void jBInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInserirActionPerformed
        inserirReta(jTFReta.getText());        
    }//GEN-LAST:event_jBInserirActionPerformed

    public void inserirReta(String reta){
        reta = reta.replaceAll(" ", "").toLowerCase();
                
        if((reta.contains("<=") || reta.contains(">=") || reta.contains("=")) 
                && !reta.endsWith("=") && !reta.startsWith("=")){
            indice++;
            modeloRetas.addRow(new String[]{indice+"",reta});
            //Monta uma classe "Reta" para cada reta e adiciona na lista de retas
            retas.add(sintaxe.extrairTermos(reta));
            jTFReta.setText("");
            jBSimplex.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(this, "Uma inequação ou uma inequação deve ser digitada!");
            jTFReta.requestFocus();
        }
    }
    
    private void jTFRetaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFRetaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            inserirReta(jTFReta.getText());
        }
    }//GEN-LAST:event_jTFRetaKeyPressed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        modeloRetas.setRowCount(0);
        modeloSimplex.setRowCount(0);
        jTFReta.setText("");
        retas.clear();
        indice = 0;
    }//GEN-LAST:event_jBLimparActionPerformed

    private void jBLerArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLerArquivoActionPerformed
        try {
            BufferedReader br = new BufferedReader(new FileReader("retas"));
            String reta;
            
            while((reta = br.readLine()) != null){
                inserirReta(reta);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JFInterseccao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JFInterseccao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBLerArquivoActionPerformed
    
    //Cria uma cópia da reta para preservar a reta original
    public Reta copiarReta(Reta reta){
        Reta copiaReta = new Reta();
        ArrayList<Termo> esq = new ArrayList<>();
        ArrayList<Termo> dir = new ArrayList<>();
        
        //Copia o lado esquerdo
        for (int i = 0; i < reta.esq.size(); i++) {
            esq.add(new Termo(reta.esq.get(i).coef, reta.esq.get(i).var));
        }
        
        //Copia o lado direito
        for (int i = 0; i < reta.dir.size(); i++) {
            dir.add(new Termo(reta.dir.get(i).coef, reta.dir.get(i).var));
        }
        
        copiaReta.esq = esq;
        copiaReta.dir = dir;
        
        return copiaReta;
    }    
    
    public static void main(String args[]) {        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFInterseccao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFInterseccao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFInterseccao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFInterseccao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFInterseccao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBInserir;
    private javax.swing.JButton jBLerArquivo;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jBSimplex;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFReta;
    private javax.swing.JTable jTRetas;
    private javax.swing.JTable jTSimplex;
    // End of variables declaration//GEN-END:variables
}
