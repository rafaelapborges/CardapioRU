package restauranteuniversitario;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    
    List<String> banco;
    
    public BancoDeDados(){
        banco = new ArrayList<>();
    }
    
    public void adicionarItens(String item){
        banco.add(item);
    }
    
    public String mostrarSegunda(){
       String segunda = banco.get(0);
       return segunda;
    }
    public String mostrarTerca(){
       String terca = banco.get(1);
       return terca;
    }
    public String mostrarQuarta(){
       String quarta = banco.get(2);
       return quarta;
    }
    public String mostrarQuinta(){
       String quinta = banco.get(3);
       return quinta;
    }
    public String mostrarSexta(){
       String sexta = banco.get(4);
       return sexta;
    }
    public void deletarBanco(){
        banco.clear();
    }
    public int verificarBanco(){
        return banco.size();
    }
}
