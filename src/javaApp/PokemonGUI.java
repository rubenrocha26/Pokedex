package javaApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*public class PokemonGUI {
    private Pokemon[] pokedex;
    public PokemonGUI(Pokemon[] pokedex) {
        this.pokedex = pokedex;

        // Janela Principal
        JFrame frame = new JFrame("Pokedex");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Painel
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        frame.add(panel);
        placeComponents(panel);
        //Exibir a janela
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        //Campo User Input
        JLabel userLabel = new JLabel("Enter Pokemon Name:");
        userLabel.setBounds(10, 20, 150, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(160, 20, 165, 25);
        panel.add(userText);

        //Search Button
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(160, 60, 100, 25);
        panel.add(searchButton);

        //Label for Search result
        JLabel resultLabel = new JLabel("");
        resultLabel.setForeground(Color.black);
        resultLabel.setBounds(10, 100, 350, 25);
        panel.add(resultLabel);

        //Search Button function
        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String pokemonName = userText.getText();
                boolean found = false;

                for (Pokemon p : pokedex) {
                    if (p.getPokemonName().equalsIgnoreCase(pokemonName)) {
                        resultLabel.setText(p.getPokemonName() + " is a " + p.getPokemonType() + " Pokémon at level " + p.getPokemonLevel());
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    resultLabel.setText("Pokémon not found in the Pokédex.");
                }
            }
        });
    }
}*/
