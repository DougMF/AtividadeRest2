
import java.util.ArrayList;

public class Operacoes {
    public float [] compararRetas(Reta reta1, Reta reta2){
        //Isola uma variável da equação 1
        isolarVariavel(reta1.esq, reta1.dir);
        //Substitui na segunda equação a variável isolada na primeira equação
        substituirVariavel(reta1.esq.get(0).var, reta1.dir, reta2.esq);                    
        //Soma os termos do lado esquerdo da equação 2
        somarTermos(reta2.esq);
        //Isola a variável da equação 2                               
        isolarVariavel(reta2.esq, reta2.dir);
        /*Se o coeficiente do termo for 0, significa que na substituição da 
        primeira equação na segunda, os termos se anularam, ou seja, as retas
        são parelelas*/
        if(reta2.esq.isEmpty())
            return null;        
        else{
            //Soma os termos do lado direito da equação 2
            somarTermos(reta2.dir);
            //Substitui na equação modificada da reta 1 o valor da variável isolada na equação 2
            substituirVariavel(reta2.esq.get(0).var, reta2.dir, reta1.dir);
            //Soma os termos do lado direito da equação modificada da reta 1
            somarTermos(reta1.dir);
            
            float [] resultado = new float[2];
            resultado [0] = reta1.dir.get(0).coef;
            resultado [1] = reta2.dir.get(0).coef;
            
            return resultado;
        }
    }
    
    public void isolarVariavel(ArrayList<Termo> esq, ArrayList<Termo> dir){
        String var = "";
        Termo termo = null;
        int i;
        
        //Escolhe a variável a ser isolada
        for (i = 0; i < esq.size(); i++) {
            if(!esq.get(i).var.isEmpty()){
                var = esq.get(i).var;
                termo = esq.get(i);
                break;
            }
        }               
        
        //Retas paralelas
        if(termo.coef == 0){
            esq.clear();
            return;
        }
        
        //Passa todos os outros termos para o outro lado da equação
        for (i = 0; i < esq.size(); i++) {
            if(!esq.get(i).var.equals(var)){
                dir.add(inverterSinal(esq.get(i)));
            }
        }
        
        //Remove do lado esquerdo todos os temos que foram passados para o outro lado
        esq.clear();
        esq.add(termo);
        
        //Passa o coeficiente dividindo, se houver (!=1){
        if(termo.coef != 1){
            for (i = 0; i < dir.size(); i++) {
                dir.get(i).coef /= termo.coef;
            }
        }else return;
        
        //Remove do lado esquerdo o coeficiente que foi passado para o lado direito
        esq.get(0).coef = 1;
    }
    
    public void substituirVariavel(String var, ArrayList<Termo> polinomio, ArrayList<Termo> esq){
        int i, j;
        float coef;
        
        for (i = 0; i < esq.size(); i++) {
            //Substitui a variável pelo poliômio que ela representa (multiplica o coeficiente pelo polinônio)
            if(esq.get(i).var.equals(var)){
                //Se o coeficiente não for 1, multiplica os termos
                if(esq.get(i).coef != 1){
                    coef = esq.get(i).coef;
                    
                    for (j = 0; j < polinomio.size()-1; j++)
                        esq.add(new Termo(coef * polinomio.get(j).coef, polinomio.get(i).var));                                        
                    esq.get(i).coef *= polinomio.get(j).coef;
                }else{ //Se o coeficiente for 1, apenas substitui a variável pelo polinômio
                    for (j = 0; j < polinomio.size()-1; j++)
                        esq.add(new Termo(polinomio.get(j).coef, polinomio.get(j).var));
                    esq.get(i).coef = polinomio.get(j).coef;                   
                }
                
                esq.get(i).var = polinomio.get(j).var;
            }
        }
    }
    
    public Termo inverterSinal(Termo termo){        
        return new Termo(termo.coef * -1, termo.var);
    }
    
    public void somarTermos(ArrayList<Termo> lado){
        for (int i = 0, j; i < lado.size(); i++) {
            for (j = i + 1; j < lado.size(); j++) {
                if(lado.get(i).var.equals(lado.get(j).var)){
                    lado.get(i).coef += lado.get(j).coef;
                    lado.remove(j);
                    j--;
                }
            }
        }
    }
    
    public float substituirVariaveis(float x, float y, ArrayList<Termo> formula){        
        float soma = 0;
        
        //Resolve as operações com x e y subtituídos na inequação de cada reta
        for (Termo esq : formula) {
            if(esq.var.equals("x"))
                soma += esq.coef * x; //ex.: 2x -> 2*4 se x = 4
            else
                soma += esq.coef * y; //ex.: 2y -> 2*4 se y = 4
        }
        System.out.println(soma);
        return soma;
    }
    
    public boolean verificarPonto(float [] ponto, ArrayList<Reta> retas){        
        float soma;
        
        for (int i = 0; i < retas.size(); i++) {
            //Substitui x e y na fórmula
            soma = substituirVariaveis(ponto[0], ponto[1], retas.get(i).esq);            
            
            //Se o resultado da subtituição dos pontos não corresponder à inequação,
            //retorna false (ponto não pertence à área)
            if(retas.get(i).tipo == '<')
                if(soma > retas.get(i).dir.get(0).coef)
                    return false;
            else
                if(soma < retas.get(i).dir.get(0).coef)
                    return false;            
        }           
        
        return true;
    }
}
