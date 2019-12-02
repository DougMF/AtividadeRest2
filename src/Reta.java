
import java.util.ArrayList;

public class Reta {
    ArrayList<Termo> esq = new ArrayList(); //Lado à esquerda da inigualdade
    ArrayList<Termo> dir = new ArrayList(); //Lado à direita da inigualdade
    char tipo; //<,> ou =
    
    //Mostra a inequação completa
    @Override
    public String toString(){
        return esq.toString() + tipo + "=" + dir.toString();
    }
}
