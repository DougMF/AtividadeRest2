import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
    Reta funcaoObj = new Reta();
    Sintaxe sintaxe;
    Operacoes operacoes;
    int colunaAtual, linhaAtual;
    float matriz[][];
    
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
        jBInserirObj = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTSimplex = new javax.swing.JTable();
        jBLimpar = new javax.swing.JButton();
        jBLerArquivo = new javax.swing.JButton();
        jTFFuncaoObj = new javax.swing.JTextField();
        jBInserirRest = new javax.swing.JButton();
        jLFuncObj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jTFReta.setBorder(javax.swing.BorderFactory.createTitledBorder("Restrição"));
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

        jBInserirObj.setText("Inserir");
        jBInserirObj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInserirObjActionPerformed(evt);
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

        jTFFuncaoObj.setBorder(javax.swing.BorderFactory.createTitledBorder("Função objetivo"));

        jBInserirRest.setText("Inserir");
        jBInserirRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInserirRestActionPerformed(evt);
            }
        });

        jLFuncObj.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLFuncObj.setText("Função objetivo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBSimplex))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTFFuncaoObj, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBInserirObj)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLFuncObj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBLerArquivo)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTFReta, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBInserirRest)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBInserirObj)
                            .addComponent(jTFFuncaoObj))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFReta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBInserirRest)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLerArquivo)
                    .addComponent(jBSimplex)
                    .addComponent(jBLimpar)
                    .addComponent(jLFuncObj))
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
        
        //Verifica se as equações precisam de uma variável de folga e o qual tipo
        for (int i = 0; i < indice; i++) {
            String pontoX = "";
            String pontoY = "";
            String vi = "";         
            
            verificarVF(retas.get(i));
            pontoX = retas.get(i).esq.get(0).coef+"";
            pontoY = retas.get(i).esq.get(1).coef+"";
            vi = retas.get(i).esq.get(2).coef+"";
            
            //System.out.println("teste: "+retas.get(i).dir);    
            modeloSimplex.addRow(new String[]{pontoX, pontoY});           
                        
            //colocando o valor de vi na coluna correta
            modeloSimplex.setValueAt(vi, i, i+2);
            //colocando o valor da direita da reta na coluna R da tabela
            modeloSimplex.setValueAt(retas.get(i).dir.get(0).coef, i, indice+2);
            
            for (int x = 0; x < modeloSimplex.getColumnCount(); x++) {
                if(modeloSimplex.getValueAt(i, x) == null)
                    modeloSimplex.setValueAt("0", i, x);
            }            
        }
        
        modeloSimplex.addRow(new String[]{funcaoObj.esq.get(0).coef+"",funcaoObj.esq.get(1).coef+""});
        for (int x = 2; x < modeloSimplex.getColumnCount(); x++) {
            modeloSimplex.setValueAt("0", modeloSimplex.getRowCount() -1,x );
        }
        montarMatriz();
    }//GEN-LAST:event_jBSimplexActionPerformed
      
    //Adiciona uma variável de folga à equação, se necessário
    public void verificarVF(Reta reta){
        if(reta.tipo == '>')
            reta.esq.add(new Termo(-1, "vf"));
        else if(reta.tipo == '<')
            reta.esq.add(new Termo(1, "vf"));        
    }
    
    private void jBInserirObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInserirObjActionPerformed
        if(!jTFFuncaoObj.getText().isEmpty()){        
            String funcObj = jTFFuncaoObj.getText();            
            jLFuncObj.setText("Função objetivo: " + funcObj);
            funcObj = jTFFuncaoObj.getText() + "=0";
            funcObj = funcObj.replaceAll(" ", "").toLowerCase().replace("z=", "");
            
            funcaoObj = sintaxe.extrairTermos(funcObj);
            System.out.println(""+funcaoObj);
            jBInserirObj.setEnabled(false);
            
            //trocar valores para negativo
            funcaoObj.esq.get(0).coef *= -1;
            funcaoObj.esq.get(1).coef *= -1;
        }else
            JOptionPane.showMessageDialog(this, "Uma equação deve ser informada!");
        
        
    }//GEN-LAST:event_jBInserirObjActionPerformed

    public void montarMatriz(){
        matriz = new float[modeloSimplex.getRowCount()][modeloSimplex.getColumnCount()];
        
        for (int i = 0; i < modeloSimplex.getRowCount(); i++) {
            for (int j = 0; j < modeloSimplex.getColumnCount(); j++) {
                matriz[i][j] = Float.parseFloat(modeloSimplex.getValueAt(i,  j)+"");
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
        
    }
    
    //Dividir a coluna "resultado" pela coluna do pivot
    public void dividirResultadoPivo(){
        
    }
    
    //Diagonalizar a matriz
    public void diagonalizar(){
        
    }
    
    //Tornar o pivô um dividindo sua linha por ele mesmo
    public void tornarPivoUm(){
        
    }
            
    public void inserirReta(String reta){
        reta = reta.replaceAll(" ", "").toLowerCase();
                
        if((reta.contains("<=") || reta.contains(">=")) 
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
        modeloSimplex.setColumnCount(2);
        jBSimplex.setEnabled(false);
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

    private void jBInserirRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInserirRestActionPerformed
        inserirReta(jTFReta.getText());    
    }//GEN-LAST:event_jBInserirRestActionPerformed
    
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
    private javax.swing.JButton jBInserirObj;
    private javax.swing.JButton jBInserirRest;
    private javax.swing.JButton jBLerArquivo;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jBSimplex;
    private javax.swing.JLabel jLFuncObj;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFFuncaoObj;
    private javax.swing.JTextField jTFReta;
    private javax.swing.JTable jTRetas;
    private javax.swing.JTable jTSimplex;
    // End of variables declaration//GEN-END:variables
}
