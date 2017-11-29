import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class InputPane extends JPanel
{
    public InputPane(MazeShower maze)
    { 
        this.setBounds(0,0,250,500); 
        this.setLayout(new GridLayout(5,1));
        //TODO:: Create generate, solve, and size buttons.
        JButton generate = new JButton("Generate");
        generate.addActionListener(new AbstractAction(){
            public void actionPerformed(ActionEvent e)
            {
                maze.generate();
            }
        });
        JButton solve = new JButton("Solve");
        solve.addActionListener(new AbstractAction(){
            public void actionPerformed(ActionEvent e)
            {
                maze.solve();
            }
        });
        JButton genSmall = new JButton("Small");
        genSmall.addActionListener(new AbstractAction(){
            public void actionPerformed(ActionEvent e)
            {
                maze.setSize(25);
            }
        });
        JButton genMed = new JButton("Medium");
        genMed.addActionListener(new AbstractAction(){
            public void actionPerformed(ActionEvent e)
            {
                maze.setSize(49);
            }
        });
        JButton genLrg  = new JButton("Large");
        genLrg.addActionListener(new AbstractAction(){
            public void actionPerformed(ActionEvent e)
            {
                maze.setSize(99);
            }
        });
        this.add(generate);
        this.add(solve);
        this.add(genSmall);
        this.add(genMed);
        this.add(genLrg);
        this.setVisible(true);
    }
}
