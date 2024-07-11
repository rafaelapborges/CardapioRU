package restauranteuniversitario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class janelaInicial extends JFrame {
    
    BancoDeDados b1 = new BancoDeDados();
    
    public janelaInicial(){
        
         // Definindo o comportamento padrão da janela quando ela for fechada
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Criando um título para a janela
        setTitle("Restaurante Universitário - UFJ");
        
        // Definindo o tamanho da janela
        setSize(600,400);
        
        // Centralizando a janela na tela
        this.setLocationRelativeTo(null);
        
        // Criando o painel principal (contêiner da janela)
        JPanel painelPrincipal = new JPanel();
        
         // Definindo-o como painel principal 
        setContentPane(painelPrincipal);
        
        // Definindo o layout de posicionamento como GridLayout
        painelPrincipal.setLayout(new GridLayout(1,2));
        
        // Criando dois sub-painéis para editar o contentPane
        JPanel painelEsquerdo = new JPanel(new GridLayout(2,1));
        JPanel painelDireito = new JPanel();
        painelPrincipal.add(painelEsquerdo);
        painelPrincipal.add(painelDireito);
        
        // Definindo uma imagem como ícone em um label
        ImageIcon imagem1P1 = new ImageIcon("resources/Restaurante_parte1.png");
        JLabel labelDeImagem1P1 = new JLabel(imagem1P1);
        ImageIcon imagem1P2 = new ImageIcon("resources/Restaurante_parte2.png");
        JLabel labelDeImagem1P2 = new JLabel(imagem1P2);
        
        // Adicionando a imagem ao painel esquerdo
        painelEsquerdo.add(labelDeImagem1P1);
        painelEsquerdo.add(labelDeImagem1P2);
        
        // Componentes adicionais para o painelDireito
        JButton btIniciarSessao = new JButton("INICIAR SESSÃO");
        btIniciarSessao.setForeground(Color.BLUE);
        ImageIcon imagem2 = new ImageIcon("resources/imagemAuxiliarEspecial.png");
        // Obs: Vários labels com a mesma imagem são criados para adicionar mais de uma vez no GridLayout
        ImageIcon imagem3 = new ImageIcon("resources/imagemAuxiliar.png");
        JLabel labelDeImagem2 = new JLabel(imagem2);
        JLabel labelDeImagem3 = new JLabel(imagem3); 
        JLabel labelDeImagem4 = new JLabel(imagem3);
        
        // Definindo o painelDireito como GridLayout e adicionando os respectivos componentes
        painelDireito.setLayout(new GridLayout(4,1));
        painelDireito.add(labelDeImagem2 );
        painelDireito.add(labelDeImagem3);
        painelDireito.add(btIniciarSessao);
        painelDireito.add(labelDeImagem4);
        
        // Programando ações: Botão "INICIAR SESSÃO"
        btIniciarSessao.addActionListener((ActionEvent e) -> {
            
            // Fechar a janela anterior
            dispose();
            
            // Criando uma nova janela ao clicar no botão
            JFrame janelaSessao = new JFrame("Bem-vindo...");
            janelaSessao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janelaSessao.setSize(600, 400);
            janelaSessao.setLocationRelativeTo(null);
            
            // Criando um painel para a janela de sessão
            JPanel pnPSessao = new JPanel();
            janelaSessao.setContentPane(pnPSessao);
            pnPSessao.setLayout(new GridLayout(1,3));
            
            // Criando componentes para a janela de sessão
            JPanel pnVazio1 = new JPanel();
            pnVazio1.setBackground(Color.WHITE);
            JPanel pnVazio2 = new JPanel();
            pnVazio2.setBackground(Color.WHITE);
            JPanel pnVazio3 = new JPanel();
            pnVazio3.setBackground(Color.WHITE);
            
            JButton btVerCardapio = new JButton("VER CARDÁPIO");
            btVerCardapio.setBackground(new Color(138,43,226));
            btVerCardapio.setForeground(Color.WHITE);
            
            JButton btAlterarCardapio = new JButton("ALTERAR CARDÁPIO");
            btAlterarCardapio.setBackground(new Color(138,43,226));
            btAlterarCardapio.setForeground(Color.WHITE);
            
            ImageIcon quadroUm = new ImageIcon("resources/painelNovo.png");
            JLabel lbQuadroUm = new JLabel(quadroUm);
            ImageIcon quadroTres = new ImageIcon("resources/painelNovo2.png");
            JLabel lbQuadroTres = new JLabel(quadroTres);
            
            JPanel painelAuxiliar = new JPanel(new GridLayout(5,1));
            
            painelAuxiliar.add(pnVazio1);
            painelAuxiliar.add(btVerCardapio);
            painelAuxiliar.add(pnVazio2);
            painelAuxiliar.add(btAlterarCardapio);
            painelAuxiliar.add(pnVazio3);
            
            // Adicionando os componentes ao gridLayout da janela
            pnPSessao.add(lbQuadroUm);
            pnPSessao.add(painelAuxiliar);
            pnPSessao.add(lbQuadroTres);
            
            // Tornando a janela visível
            janelaSessao.setVisible(true); // Exibe a nova janela
            
            // Programando ações: Botão "Ver Cardápio"
            btVerCardapio.addActionListener((ActionEvent e1) -> {
                
                if(b1.verificarBanco()==0){
                    JOptionPane.showMessageDialog(null, "ERRO! NENHUM CARDÁPIO CADASTRADO.");
                }else{
                // Criando uma nova janela para a exibição do cardápio
                JFrame janelaVerCardapio = new JFrame("Ver Cardápio...");
                janelaVerCardapio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                janelaVerCardapio.setSize(600, 400);
                janelaVerCardapio.setLocationRelativeTo(null);
                
                // Criando um novo painel de fundo e definindo seu tamanho
                JPanel painelCardapio = new JPanel();
                painelCardapio.setPreferredSize(new Dimension(600,400));
                
                // Adicionando ao contentPane e definindo o layout como BorderLayout
                janelaVerCardapio.setContentPane(painelCardapio);
                painelCardapio.setLayout(new BorderLayout());
                
                // Criando sub-painéis para manipulação de dados e design
                JPanel painelSuperior = new JPanel(new GridLayout(1,5));
                painelSuperior.setPreferredSize(new Dimension(600,20));
                JPanel painelInferior = new JPanel();
                painelInferior.setPreferredSize(new Dimension(600,20));
                JPanel painelCentral = new JPanel(new GridLayout(1,5));
                painelCentral.setPreferredSize(new Dimension(600, 360));
                
                // Definindo os locais onde ficarão os novos painéis a partir do BorderLayout
                painelCardapio.add(painelSuperior, BorderLayout.NORTH);
                painelCardapio.add(painelCentral, BorderLayout.CENTER);
                painelCardapio.add(painelInferior, BorderLayout.SOUTH);
                
                // Criando componentes para o painelSuperior
                JLabel lbSegunda = new JLabel("SEGUNDA-FEIRA");
                JLabel lbTerca = new JLabel("TERÇA-FEIRA");
                JLabel lbQuarta = new JLabel("QUARTA-FEIRA");
                JLabel lbQuinta = new JLabel("QUINTA-FEIRA");
                JLabel lbSexta = new JLabel("SEXTA-FEIRA");
                
                // Definindo cores visíveis
                lbSegunda.setForeground(Color.WHITE);
                lbTerca.setForeground(Color.WHITE);
                lbQuarta.setForeground(Color.WHITE);
                lbQuinta.setForeground(Color.WHITE);
                lbSexta.setForeground(Color.WHITE);
                
                // Adicionando os componentes aos seus respectivos locais no GridLayout
                painelSuperior.add(lbSegunda);
                painelSuperior.add(lbTerca);
                painelSuperior.add(lbQuarta);
                painelSuperior.add(lbQuinta);
                painelSuperior.add(lbSexta);
                
                // Definindo cores para os painéis inferior e superior
                painelInferior.setBackground(new Color(138,43,226));
                painelSuperior.setBackground(new Color(138,43,226));
                
                // Definindo um label para o painelInferior
                JLabel lbInferior = new JLabel("PARA SAIR DO SISTEMA, FECHE A JANELA...");
                lbInferior.setForeground(Color.WHITE);
                painelInferior.add(lbInferior);
                
                // Criando sub-painéis do painelcentral para adicionar os dados do banco de dados
                JPanel pnSegunda = new JPanel();
                JPanel pnTerca = new JPanel();
                JPanel pnQuarta = new JPanel();
                JPanel pnQuinta = new JPanel();
                JPanel pnSexta = new JPanel();
                
                // Definindo áreas de texto onde o cardápio de cada dia da semana será mostrado (sem disponibilidade pra edição)
                JTextArea taSegunda = new JTextArea();
                JTextArea taTerca = new JTextArea();
                JTextArea taQuarta = new JTextArea();
                JTextArea taQuinta = new JTextArea();
                JTextArea taSexta = new JTextArea();
                taSegunda.setEditable(false);
                taTerca.setEditable(false);
                taQuarta.setEditable(false);
                taQuinta.setEditable(false);
                taSexta.setEditable(false);
                
                // Adicionando ao conteúdo do banco de dados
                taSegunda.setText(b1.mostrarSegunda());
                taTerca.setText(b1.mostrarTerca());
                taQuarta.setText(b1.mostrarQuarta());
                taQuinta.setText(b1.mostrarQuinta());
                taSexta.setText(b1.mostrarSexta());
                
                // Adicionando as áreas de texto aos respectivos painéis
                pnSegunda.add(taSegunda);
                pnTerca.add(taTerca);
                pnQuarta.add(taQuarta);
                pnQuinta.add(taQuinta);
                pnSexta.add(taSexta);
                
                // Adicionando os sub-painéis ao painelCentral
                painelCentral.add(pnSegunda);
                painelCentral.add(pnTerca);
                painelCentral.add(pnQuarta);
                painelCentral.add(pnQuinta);
                painelCentral.add(pnSexta);
                
                // Tornando a janela visível
                janelaVerCardapio.setVisible(true); // Exibe a nova janela
                }
            });
            
            // Programando ações: Botão "Alterar Cardápio"
            btAlterarCardapio.addActionListener((ActionEvent e1) -> {
                
                JFrame janelaAlterarCardapio = new JFrame();
                janelaAlterarCardapio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janelaAlterarCardapio.setSize(600, 400);
                janelaAlterarCardapio.setLocationRelativeTo(null);
                janelaAlterarCardapio.setTitle("Alterando cardápio...");
                
                // Criando um novo painel de fundo e definindo seu tamanho
                JPanel painelAlterarCardapio = new JPanel();
                painelAlterarCardapio.setPreferredSize(new Dimension(600,400));
                
                // Adicionando ao contentPane e definindo o layout como BorderLayout
                janelaAlterarCardapio.setContentPane(painelAlterarCardapio);
                painelAlterarCardapio.setLayout(new BorderLayout());
                
                // Criando sub-painéis para manipulação de dados e design
                JPanel painelSuperior = new JPanel(new GridLayout(1,5));
                painelSuperior.setPreferredSize(new Dimension(600,20));
                JPanel painelInferior = new JPanel(new GridLayout(2,1));
                painelInferior.setPreferredSize(new Dimension(600,40));
                JPanel painelCentral = new JPanel(new GridLayout(1,5));
                painelCentral.setPreferredSize(new Dimension(600, 340));
                
                // Criando componentes para o painelSuperior
                JLabel lbSegunda = new JLabel("SEGUNDA-FEIRA");
                JLabel lbTerca = new JLabel("TERÇA-FEIRA");
                JLabel lbQuarta = new JLabel("QUARTA-FEIRA");
                JLabel lbQuinta = new JLabel("QUINTA-FEIRA");
                JLabel lbSexta = new JLabel("SEXTA-FEIRA");
                
                // Mudando a cor pra ficar visível
                lbSegunda.setForeground(Color.WHITE);
                lbTerca.setForeground(Color.WHITE);
                lbQuarta.setForeground(Color.WHITE);
                lbQuinta.setForeground(Color.WHITE);
                lbSexta.setForeground(Color.WHITE);
                
                // Adicionando os componentes aos seus respectivos locais no GridLayout
                painelSuperior.add(lbSegunda);
                painelSuperior.add(lbTerca);
                painelSuperior.add(lbQuarta);
                painelSuperior.add(lbQuinta);
                painelSuperior.add(lbSexta);
                
                // Definindo cor para o painel superior
                painelSuperior.setBackground(new Color(138,43,226));
                
                // Definindo os locais onde ficarão os novos painéis a partir do BorderLayout
                painelAlterarCardapio.add(painelSuperior, BorderLayout.NORTH);
                painelAlterarCardapio.add(painelCentral, BorderLayout.CENTER);
                painelAlterarCardapio.add(painelInferior, BorderLayout.SOUTH);
                
                // Definindo áreas de texto onde o cardápio de cada dia da semana será digitado
                JTextArea taSegunda = new JTextArea();
                JTextArea taTerca = new JTextArea();
                JTextArea taQuarta = new JTextArea();
                JTextArea taQuinta = new JTextArea();
                JTextArea taSexta = new JTextArea();
                
                // Adicionando ao painelCentral
                painelCentral.add(taSegunda);
                painelCentral.add(taTerca);
                painelCentral.add(taQuarta);
                painelCentral.add(taQuinta);
                painelCentral.add(taSexta);
                
                 // Criando botões: "Voltar", "Apagar tudo", "Pronto"
                JButton btVoltar = new JButton("VOLTAR");
                btVoltar.setForeground(Color.WHITE);
                btVoltar.setBackground(new Color(138,43,226));
                JButton btPronto = new JButton("PRONTO");
                btPronto.setForeground(Color.WHITE);
                btPronto.setBackground(new Color(138,43,226));
                JButton btApagarTudo = new JButton("APAGAR TUDO");
                btApagarTudo.setForeground(Color.WHITE);
                btApagarTudo.setBackground(new Color(138,43,226));
                
                JLabel lbAuxiliar = new JLabel("PARA SAIR DO SISTEMA, FECHE A JANELA...");
                lbAuxiliar.setForeground(Color.WHITE);
                JPanel painelAuxiliar1 = new JPanel(new GridLayout(1,3));
                JPanel painelAuxiliar2 = new JPanel();
                painelAuxiliar2.setBackground(new Color(138,43,226));
                
                // Adicionando os respectivos componentes a cada um dos painéis auxiliares
                painelAuxiliar1.add(btVoltar);
                painelAuxiliar1.add(btPronto);
                painelAuxiliar1.add(btApagarTudo);
                painelAuxiliar2.add(lbAuxiliar);
                
                // Adicionando tudo ao painel inferior
                painelInferior.add(painelAuxiliar1);
                painelInferior.add(painelAuxiliar2);
                
            
                // Programando ações: Botão "Apagar tudo"
                btApagarTudo.addActionListener((ActionEvent e2) -> {
                    b1.deletarBanco();
                    taSegunda.setText("");
                    taTerca.setText("");
                    taQuarta.setText("");
                    taQuinta.setText("");
                    taSexta.setText("");
                    if(b1.verificarBanco()!= 0){
                    JOptionPane.showMessageDialog(null,"ATENÇÃO! VOCÊ APAGOU TODOS OS DADOS.");
                    }else{
                        JOptionPane.showMessageDialog(null,"NÃO É POSSÍVEL APAGAR, POIS O CARDÁPIO ESTÁ VAZIO.");
                    }
                });
                
                btVoltar.addActionListener((ActionEvent e2) -> {
                    janelaAlterarCardapio.dispose();
                });
                btPronto.addActionListener((ActionEvent e2) -> {
                    
                    if((taSegunda.getText()== null) || (taTerca.getText()== null) || (taQuarta.getText().isEmpty()) || (taQuinta.getText().isEmpty()) || (taSexta.getText().isEmpty())){
                        JOptionPane.showMessageDialog(null, "ERRO! PREENCHA TODOS OS CAMPOS ANTES DE SALVAR.");
                    } else{
                        b1.adicionarItens(taSegunda.getText());
                        b1.adicionarItens(taTerca.getText());
                        b1.adicionarItens(taQuarta.getText());
                        b1.adicionarItens(taQuinta.getText());
                        b1.adicionarItens(taSexta.getText());
                        JOptionPane.showMessageDialog(null, "OS ITENS FORAM ADICIONADOS COM SUCESSO.");
                    }
                   
                });
                
                janelaAlterarCardapio.setVisible(true); // Exibe a nova janela
                
            });
            
            
        });
        
    }
}
