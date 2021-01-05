package frontEnd;

import javax.swing.*;
import java.awt.*;

public class Janela {

    JFrame mytela;

    public Janela() {
        JFrame mytela  = new JFrame("Gerencias de contas");
  

        mytela.setBounds(100, 100, 600, 400);
        mytela.getContentPane().setBackground(Color.WHITE);

        mytela.setVisible(true);

    }
}