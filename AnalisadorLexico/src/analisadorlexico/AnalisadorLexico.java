/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisadorlexico;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Eduardo Gonçalves da Silva
 */
public class AnalisadorLexico {
    
    public static void main(String[] args) throws IOException {
        int coluna; //Marca a posição no vetor
        int l = 0;
        char linhaChar[]; //vai guardar as linha em char
        
        try{//Tratamento de Erro
            FileInputStream entrada = new FileInputStream("E:\\Eduardo\\Eduardo\\Semestres\\6 Semestre\\Compiladores\\Projetos\\AnalisadorLexico\\Codigo.txt"); //abre o arquivo
            InputStreamReader tabela = new InputStreamReader(entrada);//abre para leituda do arquivo (ele lê bytes e os decodifica em caracteres usando um especificado charset)
            BufferedReader lerTabela = new BufferedReader(tabela);//Lê texto de um fluxo de entrada de caracteres, armazenando caracteres em buffer para fornecer uma leitura eficiente de caracteres, matrizes e linhas
            
            String linha = lerTabela.readLine(); //pega a primeira linha
            System.out.println("Tokens \t\t\t Lexemas \t\t\t Posição");
           
            while(linha != null){ //Enquanto houver linha no arquivo
                coluna = 0;
                linha += ' ';
                String lexema = "";
                
                linhaChar = linha.toCharArray(); //Transforma a String em vetor de char
                
                q0(linhaChar,coluna,l,lexema); //Começa na posição zero
   
                linha = lerTabela.readLine(); //pega a proxima linha
                l++;
                
            }
            
            entrada.close();
        }catch(FileNotFoundException e){
            System.out.println("Erro em abrir o arquivo");
        }
    }
    
    //Estado inicial
    public static void q0(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 's':
                lexema += 's'; 
                coluna++;
                q1(vetor,coluna,l,lexema);
                break;
            case 'e':
                lexema += 'e'; 
                coluna++;
                q6(vetor,coluna,l,lexema);
                break;
            case 'r':
                lexema += 'r'; 
                coluna++;
                q14(vetor,coluna,l,lexema);
                break;
            case 'w':
                lexema += 'w'; 
                coluna++;
                q18(vetor,coluna,l,lexema);
                break;
            case 'i':
                lexema += 'i'; 
                coluna++;
                q23(vetor,coluna,l,lexema);               
                break;
            case '/':
                lexema += '/'; 
                coluna++;
                q36(vetor,coluna,l,lexema);  
                break;
            case '*':
                lexema += '*'; 
                coluna++;
                q35(vetor,coluna,l,lexema);  
                break;
            case '-':
                lexema += '-'; 
                coluna++;
                q34(vetor,coluna,l,lexema);
                break;
            case '+':
                lexema += '+'; 
                coluna++;
                q33(vetor,coluna,l,lexema);
                break;
            case ';':
                lexema += ';'; 
                coluna++;
                q13(vetor,coluna,l,lexema);
                break;
            case ')':
                lexema += ')'; 
                coluna++;
                q12(vetor,coluna,l,lexema);
                break;
            case '(':
                lexema += '('; 
                coluna++;
                q11(vetor,coluna,l,lexema);
                break;
            case ']':
                lexema += ']'; 
                coluna++;
                q10(vetor,coluna,l,lexema);
                break;
            case '[':
                lexema += '['; 
                coluna++;
                q9(vetor,coluna,l,lexema);
                break;
            case '>':
                lexema += '>'; 
                coluna++;
                q37(vetor,coluna,l,lexema);
                break;
            case '<':
                lexema += '<'; 
                coluna++;
                q38(vetor,coluna,l,lexema);
                break;
            case '=':
                lexema += '='; 
                coluna++;
                q39(vetor,coluna,l,lexema);
                break;
            case ' ':
                if(coluna + 1 != vetor.length){
                    coluna++;
                    q0(vetor,coluna,l,lexema);
                }
                break;
            case '\t'://reconhecer tabulação
                coluna++;
                q0(vetor,coluna,l,lexema);
                break;
            default:
                switch(verifChar(vetor,coluna)){
                    case 1: 
                        lexema += vetor[coluna];
                        coluna++;
                        q40(vetor, coluna,l,lexema);
                        break;
                    case 2:
                        q41(vetor,coluna,l,lexema);
                        break;
                    case 3:
                        System.out.print("Erro Lexico \t\t ");
                        System.out.print("Caractere não esperado: " + vetor[coluna]);
                        System.out.print("\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                        System.out.println("");
                        lexema="";
                        coluna++;
                        q0(vetor,coluna,l,lexema);
                    break;
                    default:
                        System.out.println("Erro q0");
                }
        }
    }
    
    //verifica numero, letra ou caractere especial
    public static int verifChar(char[] vetor, int coluna){        
        if (Character.isDigit(vetor[coluna])) {
            return 1;
        } else if (Character.isLetter(vetor[coluna])) {
            return 2;
        } else {
            return 3;
        }
    }
    
    //estado do comando start (t)
    public static void q1(char[] vetor, int coluna, int l, String lexema){
         switch(vetor[coluna]){
            case 't':
                lexema+= 't';
                coluna++;
                q2(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
    //estado do comando start (a)
    public static void q2(char[] vetor, int coluna, int l, String lexema){
         switch(vetor[coluna]){
            case 'a':
                lexema+= 'a';
                coluna++;
                q3(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
    //estado do comando start (r)
    public static void q3(char[] vetor, int coluna, int l, String lexema){
         switch(vetor[coluna]){
            case 'r':
                lexema+= 'r';
                coluna++;
                q4(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
    //estado do comando start (t)
    public static void q4(char[] vetor, int coluna, int l, String lexema){
         switch(vetor[coluna]){
            case 't':
                lexema+= 't';
                coluna++;
                q5(vetor, coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
    //estado final do comando start. Onde imprime na tela e verifica se é o comando "start"
    public static void q5(char[] vetor, int coluna, int l, String lexema){
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema);
                break;
            case 3:
                switch(lexema.length()){
                    case 5://verifica se é o tokens start ou um id com final start
                        System.out.print("tk_inicio \t\t ");
                        System.out.print(lexema);
                        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                        System.out.println("");
                        lexema = "";
                        q0(vetor,coluna,l,lexema);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema);
                }
                break;
            default:
                System.out.println("Erro no q5");
        }
    }
    
     //estado do comando end (n)
    public static void q6(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 'n':
                lexema+= 'n';
                coluna++;
                q7(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
   
    //estado do comando end (d)
    public static void q7(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 'd':
                lexema+= 'd';
                coluna++;
                q8(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
   
    //estado final do comando end. Onde imprime na tela e verifica se é o comando "end"
    public static void q8(char[] vetor, int coluna, int l, String lexema){
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema);
                break;
            case 3:
                switch(lexema.length()){
                    case 3://verifica se é o tokens end ou um id com final end
                        System.out.print("tk_fim \t\t\t ");
                        System.out.print(lexema);
                        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length()));
                        System.out.println("");
                        lexema = "";
                        q0(vetor,coluna,l,lexema);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema);
                }
                break;
            default:
                System.out.println("Erro no q8");
        }
    }
    
     //estado final do comando [
    public static void q9(char[] vetor, int coluna, int l, String lexema){       
        System.out.print("tk_abre_co \t\t ");
        System.out.print(lexema);
        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
        System.out.println("");
        lexema = "";
        q0(vetor,coluna,l,lexema);   
    }
    
     //estado final do comando ]
    public static void q10(char[] vetor, int coluna, int l, String lexema){       
        System.out.print("tk_fecha_co \t\t ");
        System.out.print(lexema);
        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
        System.out.println("");
        lexema = "";
        q0(vetor,coluna,l,lexema);         
    }
    
     //estado final do comando (
    public static void q11(char[] vetor, int coluna, int l, String lexema){       
        System.out.print("tk_abre_pa \t\t ");
        System.out.print(lexema);
        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
        System.out.println("");
        lexema = "";
        q0(vetor,coluna,l,lexema);        
    }
    
     //estado final do comando )
    public static void q12(char[] vetor, int coluna, int l, String lexema){       
        System.out.print("tk_fecha_pa \t\t ");
        System.out.print(lexema);
        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
        System.out.println("");
        lexema = "";
        q0(vetor,coluna,l,lexema);      
    }
    
    //estado final do comando ;
    public static void q13(char[] vetor, int coluna, int l, String lexema){       
        System.out.print("tk_ponto_virgula \t ");
        System.out.print(lexema);
        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
        System.out.println("");
        lexema = "";
        q0(vetor,coluna,l,lexema);          
    }
    
    //estado do comando read (e)
    public static void q14(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 'e':
                lexema+= 'e';
                coluna++;
                q15(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
    //estado do comando read (a)
    public static void q15(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 'a':
                lexema+= 'a';
                coluna++;
                q16(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
    //estado do comando read (d)
    public static void q16(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 'd':
                lexema+= 'd';
                coluna++;
                q17(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
    //estado final do comando read. Onde imprime na tela e verifica se é o comando "read"
    public static void q17(char[] vetor, int coluna, int l, String lexema){
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema);
                break;
            case 3:
                switch(lexema.length()){
                    case 4://verifica se é o tokens read ou um id com final read
                        System.out.print("tk_ler \t\t\t ");
                        System.out.print(lexema);
                        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                        System.out.println("");
                        lexema = "";
                        q0(vetor,coluna,l,lexema);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema);
                }
                break;
            default:
                System.out.println("Erro no q17");
        }
    }
    
    //estado do comando write (r)
    public static void q18(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 'r':
                lexema+= 'r';
                coluna++;
                q19(vetor,coluna,l,lexema);
                break;
            case 'h':
                lexema+= 'h';
                coluna++;
                q29(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
    //estado do comando write (i)
    public static void q19(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 'i':
                lexema+= 'i';
                coluna++;
                q20(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
    //estado do comando write (t)
    public static void q20(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 't':
                lexema+= 't';
                coluna++;
                q21(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
    //estado do comando write (e)
    public static void q21(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 'e':
                lexema+= 'e';
                coluna++;
                q22(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
    //estado final do comando write. Onde imprime na tela e verifica se é o comando "write"
    public static void q22(char[] vetor, int coluna, int l, String lexema){
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema);
                break;
            case 3:
                switch(lexema.length()){
                    case 5://verifica se é o tokens write ou um id com final write
                        System.out.print("tk_escreve \t\t ");
                        System.out.print(lexema);
                        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                        System.out.println("");
                        lexema = "";
                        q0(vetor,coluna,l,lexema);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema);
                }
                break;
            default:
                System.out.println("Erro no q22");
        }
    }
    
     //estado do comando int, ou if e ifno
    public static void q23(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 'n':
                lexema+= 'n';
                coluna++;
                q24(vetor,coluna,l,lexema);
                break;
            case 'f':
                lexema+= 'f';
                coluna++;
                q26(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
    //estado do comando int (t)
    public static void q24(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 't':
                lexema+= 't';
                coluna++;
                q25(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
     //estado final do comando int. Onde imprime na tela e verifica se é o comando "int"
    public static void q25(char[] vetor, int coluna, int l, String lexema){
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema);
                break;
            case 3:
                switch(lexema.length()){
                    case 3://verifica se é o tokens int ou um id com final int
                        System.out.print("tk_int \t\t\t ");
                        System.out.print(lexema);
                        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                        System.out.println("");
                        lexema = "";
                        q0(vetor,coluna,l,lexema);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema);
                }
                break;
            default:
                System.out.println("Erro no q25");
        }
    }
    //estado final do comando if. Onde imprime na tela e verifica se é o comando "if"
    public static void q26(char[] vetor, int coluna, int l, String lexema){
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                switch(vetor[coluna]){//verifica se é o ifno
                    case 'n':
                        lexema+= 'n';
                        coluna++;
                        q27(vetor,coluna,l,lexema);
                        break;
                    default:
                        q0(vetor, coluna,l,lexema);
                }
                break;
            case 3:
                switch(lexema.length()){
                    case 2://verifica se é o tokens if ou um id com final if
                        System.out.print("tk_se \t\t\t ");
                        System.out.print(lexema);
                        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                        System.out.println("");
                        lexema = "";
                        q0(vetor,coluna,l,lexema);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema);
                }
                break;
            default:
                System.out.println("Erro no q26");
        }
    }
    
     //estado do comando ifno (o)
    public static void q27(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 'o':
                lexema+= 'o';
                coluna++;
                q28(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
    //estado final do comando ifno. Onde imprime na tela e verifica se é o comando "ifno"
    public static void q28(char[] vetor, int coluna, int l, String lexema){
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema);
                break;
            case 3:
                switch(lexema.length()){
                    case 4://verifica se é o tokens ifno ou um id com final ifno
                        System.out.print("tk_senao \t\t ");
                        System.out.print(lexema);
                        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                        System.out.println("");
                        lexema = "";
                        q0(vetor,coluna,l,lexema);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema);
                }
                break;
            default:
                System.out.println("Erro no q28");
        }
    }
     //estado do comando while (i)
    public static void q29(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 'i':
                lexema+= 'i';
                coluna++;
                q30(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
     //estado do comando while  (l)
    public static void q30(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 'l':
                lexema+= 'l';
                coluna++;
                q31(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
     //estado do comando while  (e)
    public static void q31(char[] vetor, int coluna, int l, String lexema){
        switch(vetor[coluna]){
            case 'e':
                lexema+= 'e';
                coluna++;
                q32(vetor,coluna,l,lexema);
                break;
            default:
                q41(vetor,coluna,l,lexema);
        }
    }
    
     //estado final do comando while. Onde imprime na tela e verifica se é o comando "while"
    public static void q32(char[] vetor, int coluna, int l, String lexema){
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema);
                break;
            case 3:
                switch(lexema.length()){
                    case 5://verifica se é o tokens write ou um id com final write
                        System.out.print("tk_enquanto \t\t ");
                        System.out.print(lexema);
                        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                        System.out.println("");
                        lexema = "";
                        q0(vetor,coluna,l,lexema);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema);
                }
                break;
            default:
                System.out.println("Erro no q32");
        }
    }
    
    //estado final do comando +
    public static void q33(char[] vetor, int coluna, int l, String lexema){       
        System.out.print("tk_adicao \t\t ");
        System.out.print(lexema);
        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
        System.out.println("");
        lexema = "";
        q0(vetor,coluna,l,lexema);             
    }
    //estado final do comando -
    public static void q34(char[] vetor, int coluna, int l, String lexema){       
        System.out.print("tk_subtracao \t\t ");
        System.out.print(lexema);
        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
        System.out.println("");
        lexema = "";
        q0(vetor,coluna,l,lexema);          
    }
    
    //estado final do comando *
    public static void q35(char[] vetor, int coluna, int l, String lexema){       
        System.out.print("tk_multiplicacao \t ");
        System.out.print(lexema);
        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
        System.out.println("");
        lexema = "";
        q0(vetor,coluna,l,lexema);        
    }
    
    //estado final do comando /
    public static void q36(char[] vetor, int coluna, int l, String lexema){       
        System.out.print("tk_divisão \t\t ");
        System.out.print(lexema);
        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
        System.out.println("");
        lexema = "";
        q0(vetor,coluna,l,lexema);            
    }
    
    //estado final do comando >
    public static void q37(char[] vetor, int coluna, int l, String lexema){       
        System.out.print("tk_maior \t\t ");
        System.out.print(lexema);
        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
        System.out.println("");
        lexema = "";
        q0(vetor,coluna,l,lexema);             
    }
    
      //estado final do comando <
    public static void q38(char[] vetor, int coluna, int l, String lexema){       
        System.out.print("tk_menor \t\t ");
        System.out.print(lexema);
        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
        System.out.println("");
        lexema = "";
        q0(vetor,coluna,l,lexema);         
    }
    
      //estado final do comando =
    public static void q39(char[] vetor, int coluna, int l, String lexema){       
        System.out.print("tk_atribuicao \t\t ");
        System.out.print(lexema);
        System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
        System.out.println("");
        lexema = "";
        q0(vetor,coluna,l,lexema);
                    
    }
    
     //estado do num. Verifica se é um num e imprime na tela
    public static void q40(char[] vetor, int coluna, int l, String lexema){
        switch(verifChar(vetor,coluna)){
            case 1: 
                lexema += vetor[coluna];
                coluna++;
                q40(vetor, coluna,l,lexema);
                break;
            case 2:
                System.out.println("Erro: Id não pode começar com numero!!!!");
                break;
            case 3:
                System.out.print("num \t\t\t ");
                    System.out.print(lexema);
                    System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                    System.out.println("");
                    lexema="";
                    q0(vetor,coluna,l,lexema);
                break;
            default:
                System.out.println("Erro q40");
        }
    }  
   
    //estado do id. Verifica se é um id e imprime na tela
    public static void q41(char[] vetor, int coluna, int l, String lexema){
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                lexema += vetor[coluna];
                coluna++;
                q41(vetor, coluna,l,lexema);
                break;
            case 3:
                System.out.print("id \t\t\t ");
                    System.out.print(lexema);
                    System.out.print("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                    System.out.println("");
                    lexema="";
                    q0(vetor,coluna,l,lexema);
                break;
            default:
                System.out.println("Erro q41");
        }
    }  
}
