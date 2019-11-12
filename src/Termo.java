public class Termo {
    public float coef; //Coeficiente
    public String var ; //Parte literal (variável)
    
    public Termo(float coef, String var){
        //Ex.: 0y = 0
        if(coef == 0 && !var.equals("")) var = "";
        
        this.coef = coef;
        this.var = var;
    }
    
    //Mostra o termo completo
    @Override
    public String toString(){        
        if(coef > 0) return "+" + coef + var;
        return coef + var;
    }
}
