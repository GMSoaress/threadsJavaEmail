import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TelaDados extends JDialog {


    private JPanel jPanel = new JPanel(new GridBagLayout()); /* Painel de componentes */

    private JLabel descricaoHora = new JLabel("Nome");
    private JTextField descricaoData = new JTextField();

    private JLabel descricaoHora2 = new JLabel("E-mail ");
    private JTextField descricaoData2 = new JTextField();

    private JButton jButton = new JButton("Add Lista");
    private JButton jButton2 = new JButton("Parar");

    private ImplementacaoFila fila = new ImplementacaoFila();


    public TelaDados(){
        setTitle("DATA E HORA");
        setSize(new Dimension(240, 240));
        setLocationRelativeTo(null);
        setResizable(false);

        GridBagConstraints gridBagConstraints = new GridBagConstraints(); /* Controlador de posicionamento */
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 10 ,5, 5);
        gridBagConstraints.anchor = GridBagConstraints.WEST;


        /* Tela 1 */
        descricaoHora.setPreferredSize(new Dimension(200, 25));
        jPanel.add(descricaoHora, gridBagConstraints);

        descricaoData.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy ++;
        jPanel.add(descricaoData, gridBagConstraints);

        /* Tela 2 */
        descricaoHora2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy ++;
        jPanel.add(descricaoHora2, gridBagConstraints);

        descricaoData2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy ++;
        jPanel.add(descricaoData2, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;


        /* Botão Start */
        jButton.setPreferredSize(new Dimension(100, 25));
        gridBagConstraints.gridy ++;
        jPanel.add(jButton, gridBagConstraints);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { /* Executa clique no botão */
                ObjetoFila objetoFila = new ObjetoFila();
                objetoFila.setNome(descricaoData.getText());
                objetoFila.setEmail(descricaoData2.getText());

                fila.add(objetoFila);
                
            }
        });


        /* Botão Stop */
        jButton2.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridx ++;
        jPanel.add(jButton2, gridBagConstraints);

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        fila.start();
        add(jPanel, BorderLayout.WEST);
        setVisible(true); /* Torna a tela visivel para   o usuario */
    }
}
