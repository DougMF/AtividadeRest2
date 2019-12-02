public class Sintaxe {
    
    //Analisa a equação informada para extrair seus termos e montar uma classe "Reta"
    public Reta extrairTermos(String equacao){
        Reta reta = new Reta();
        
        //Transforma a inequação em uma equação
        if(equacao.contains("<=")){
            equacao = equacao.replace("<", "");
            reta.tipo ='<';
        }else if(equacao.contains(">=")){            
            equacao = equacao.replace(">", "");           
            reta.tipo ='>';         
        }else if(equacao.contains("<")){            
            equacao = equacao.replace("<", "=");           
            reta.tipo ='<';         
        }else if(equacao.contains(">")){            
            equacao = equacao.replace(">", "=");           
            reta.tipo ='>';
        }else     
            reta.tipo ='=';

        //Verificação de sintaxe para separar os termos
        String termo = equacao.charAt(0) + "";

        for (int i = 1; i < equacao.length(); i++) {
            //Separa os termos pelo sinal
            if(equacao.charAt(i) == '-' || equacao.charAt(i) == '+'){
                reta.esq.add(analisarTermo(termo));
                termo = equacao.charAt(i) + ""; //Sinal do próximo termo
            }else if(equacao.charAt(i) == '='){ //Neste caso, o termo após o '=' sempre será um número
                reta.esq.add(analisarTermo(termo)); //Adiciona à esquerda o termo que foi analisado
                //Adiciona a direita o termo após o sinal de igual
                reta.dir.add(new Termo((Float.parseFloat(equacao.substring(i+1, equacao.length()))), ""));
                break;
            }else{
                //Monta o termo que será analisado futuramente
                termo += equacao.charAt(i);
            }
        }
        
        return reta;
    }
    
    //Analisa a string informada e extrai o termo para uma classe "Termo",
    public Termo analisarTermo(String termo){
        int sinal = 1;
        String var = "", num = "";
        float coef;
        
        //Define o sinal do termo
        if(termo.startsWith("-") || termo.startsWith("+")){
            sinal = Integer.parseInt(termo.charAt(0) + "1");
            termo = termo.substring(1, termo.length());
        }        
        
        //Separa letra de números
        for (int i = 0; i < termo.length(); i++) {
            try{
                //Verifica se o caractere é um número
                Float.parseFloat(termo.charAt(i) + "");
                num += termo.charAt(i);
            }catch(NumberFormatException nf){
                //O caractere é uma letra
                var += termo.charAt(i);
            }
        }
        
        if(num.isEmpty())
            coef = 1;
        else
            coef = Float.parseFloat(num);
        
        return new Termo(coef * sinal, var);
    }
}
