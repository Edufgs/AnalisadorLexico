package analisadorlexico;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Eduardo Gonçalves da Silva
 */
public class AnalisadorLexico {
    
    public static void main(String[] args) {
        int coluna; //Marca a posição no vetor
        int l = 0;//marca a linha
        char linhaChar[]; //vai guardar as linha em vetor de char
        
        //Terminal para digitar o comando do compilador
        System.out.println("Terminal:");
        Scanner scann = new Scanner(System.in);
        String comando = scann.nextLine();
        String comandoVetor[] = comando.split(" ");//separa o comando digitado em palavras no vetor
        System.out.println("");
        
        //verifica se está correto o comando
        if(comandoVetor[0].equals("compilador") == false){
            System.out.println("Comando não é reconhecido!!!");
            exit(0);
        }    
        
        try{//Tratamento de Erro
            FileInputStream entrada = new FileInputStream("E:\\Eduardo\\Eduardo\\Semestres\\6 Semestre\\Compiladores\\Projetos\\AnalisadorLexico\\" + comandoVetor[comandoVetor.length -1]); //abre o arquivo
            InputStreamReader codigo = new InputStreamReader(entrada);//abre para leituda do arquivo (ele lê bytes e os decodifica em caracteres usando um especificado charset)
            BufferedReader lerCodigo = new BufferedReader(codigo);//Lê texto de um fluxo de entrada de caracteres, armazenando caracteres em buffer para fornecer uma leitura eficiente de caracteres, matrizes e linhas
            
            //abrindo arquivo para ser gravado a tabela            
            FileWriter tabela = new FileWriter("E:\\\\Eduardo\\\\Eduardo\\\\Semestres\\\\6 Semestre\\\\Compiladores\\\\Projetos\\\\AnalisadorLexico\\\\Tabela.txt");
            tabela.write("Tokens \t\t\t Lexemas \t\t\t Posição "); //grava o inicio da tabela no arquivo
            
            //le o codigo digitado
            String linha = lerCodigo.readLine(); //pega a primeira linha
                
            while(linha != null){ //Enquanto houver linha no arquivo
                coluna = 0;//coluna começa no inicio
                linha += ' ';//adiciona espaço para saber o final da linha
                String lexema = "";//limpa a String que guarda os lexemas para imprimir na tabela
                linhaChar = linha.toCharArray(); //Transforma a String em vetor de char
                q0(linhaChar,coluna,l,lexema,tabela); //Começa na posição zero
                linha = lerCodigo.readLine(); //pega a proxima linha
                l++;//vai para proxima linha
            }
            
            entrada.close();//fecha o arquivo fonte
            tabela.close();//fecha a tabela 
            System.out.println("");
            
            //imprime a tabela se for pedida
            tabelaToken(comandoVetor,linha);
        }catch(FileNotFoundException e){
            System.out.println("Erro em abrir o arquivo");
        }catch(IOException e){
            System.out.println("Erro:" + e);
        }finally{
            System.out.println("\nAnalisado com sucesso!!!\n");
        }
    }

    public static void tabelaToken(String[] comandoVetor,String linha) throws FileNotFoundException, IOException{
        if(comandoVetor[1].equals("-lt")==true){
                FileInputStream abreTabela = new FileInputStream("E:\\\\Eduardo\\\\Eduardo\\\\Semestres\\\\6 Semestre\\\\Compiladores\\\\Projetos\\\\AnalisadorLexico\\\\Tabela.txt"); //abre o arquivo
                InputStreamReader tabelab = new InputStreamReader(abreTabela);//abre para leituda do arquivo (ele lê bytes e os decodifica em caracteres usando um especificado charset)
                BufferedReader lerTabela = new BufferedReader(tabelab);//Lê texto de um fluxo de entrada de caracteres, armazenando caracteres em buffer para fornecer uma leitura eficiente de caracteres, matrizes e linhas
       
                linha = lerTabela.readLine();//pega a proxima linha
                while(linha != null){
                    System.out.println(linha);//imprime a linha
                    linha = lerTabela.readLine();//pega a proxima linha
                }
                abreTabela.close();
            }
    }
    //Estado inicial
    public static void q0(char[] vetor, int coluna, int l, String lexema, FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 's':
                lexema += 's'; 
                coluna++;
                q1(vetor,coluna,l,lexema,tabela);
                break;
            case 'e':
                lexema += 'e'; 
                coluna++;
                q6(vetor,coluna,l,lexema, tabela);
                break;
            case 'r':
                lexema += 'r'; 
                coluna++;
                q14(vetor,coluna,l,lexema, tabela);
                break;
            case 'w':
                lexema += 'w'; 
                coluna++;
                q18(vetor,coluna,l,lexema, tabela);
                break;
            case 'i':
                lexema += 'i'; 
                coluna++;
                q23(vetor,coluna,l,lexema, tabela);               
                break;
            case '/':
                lexema += '/'; 
                coluna++;
                q36(vetor,coluna,l,lexema, tabela);  
                break;
            case '*':
                lexema += '*'; 
                coluna++;
                q35(vetor,coluna,l,lexema, tabela);  
                break;
            case '-':
                lexema += '-'; 
                coluna++;
                q34(vetor,coluna,l,lexema, tabela);
                break;
            case '+':
                lexema += '+'; 
                coluna++;
                q33(vetor,coluna,l,lexema, tabela);
                break;
            case ';':
                lexema += ';'; 
                coluna++;
                q13(vetor,coluna,l,lexema, tabela);
                break;
            case ')':
                lexema += ')'; 
                coluna++;
                q12(vetor,coluna,l,lexema, tabela);
                break;
            case '(':
                lexema += '('; 
                coluna++;
                q11(vetor,coluna,l,lexema, tabela);
                break;
            case ']':
                lexema += ']'; 
                coluna++;
                q10(vetor,coluna,l,lexema, tabela);
                break;
            case '[':
                lexema += '['; 
                coluna++;
                q9(vetor,coluna,l,lexema, tabela);
                break;
            case '>':
                lexema += '>'; 
                coluna++;
                q37(vetor,coluna,l,lexema, tabela);
                break;
            case '<':
                lexema += '<'; 
                coluna++;
                q38(vetor,coluna,l,lexema, tabela);
                break;
            case '=':
                lexema += '='; 
                coluna++;
                q39(vetor,coluna,l,lexema, tabela);
                break;
            case ' ':
                if(coluna + 1 != vetor.length){
                    coluna++;
                    q0(vetor,coluna,l,lexema, tabela);
                }
                break;
            case '\t'://reconhecer tabulação
                coluna++;
                q0(vetor,coluna,l,lexema, tabela);
                break;
            default:
                switch(verifChar(vetor,coluna)){
                    case 1: 
                        lexema += vetor[coluna];
                        coluna++;
                        q40(vetor, coluna,l,lexema, tabela);
                        break;
                    case 2:
                        q41(vetor,coluna,l,lexema, tabela);
                        break;
                    case 3:
                        //imprime na tela
                        System.out.print("Erro Lexico \t\t ");
                        System.out.print("Caractere não esperado: " + vetor[coluna]);
                        System.out.print("\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                        System.out.println("");
                        
                        //imprimir no arquivo
                        tabela.write("\nErro Lexico \t\t ");
                        tabela.write("Caractere não esperado: " + vetor[coluna]);
                        tabela.write("\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                        lexema="";
                        coluna++;
                        q0(vetor,coluna,l,lexema, tabela);
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
    public static void q1(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
         switch(vetor[coluna]){
            case 't':
                lexema+= 't';
                coluna++;
                q2(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
    //estado do comando start (a)
    public static void q2(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
         switch(vetor[coluna]){
            case 'a':
                lexema+= 'a';
                coluna++;
                q3(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
    //estado do comando start (r)
    public static void q3(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
         switch(vetor[coluna]){
            case 'r':
                lexema+= 'r';
                coluna++;
                q4(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
    //estado do comando start (t)
    public static void q4(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
         switch(vetor[coluna]){
            case 't':
                lexema+= 't';
                coluna++;
                q5(vetor, coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
    //estado final do comando start. Onde imprime na tela e verifica se é o comando "start"
    public static void q5(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema,tabela);
                break;
            case 3:
                switch(lexema.length()){
                    case 5://verifica se é o tokens start ou um id com final start
                        tabela.write("\ntk_inicio \t\t ");
                        tabela.write(lexema);
                        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
       
                        lexema = "";
                        q0(vetor,coluna,l,lexema,tabela);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema,tabela);
                }
                break;
            default:
                System.out.println("Erro no q5");
        }
    }
    
     //estado do comando end (n)
    public static void q6(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 'n':
                lexema+= 'n';
                coluna++;
                q7(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
   
    //estado do comando end (d)
    public static void q7(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 'd':
                lexema+= 'd';
                coluna++;
                q8(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
   
    //estado final do comando end. Onde imprime na tela e verifica se é o comando "end"
    public static void q8(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema,tabela);
                break;
            case 3:
                switch(lexema.length()){
                    case 3://verifica se é o tokens end ou um id com final end
                        tabela.write("\ntk_fim \t\t\t ");
                        tabela.write(lexema);
                        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length()));
       
                        lexema = "";
                        q0(vetor,coluna,l,lexema,tabela);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema,tabela);
                }
                break;
            default:
                System.out.println("Erro no q8");
        }
    }
    
     //estado final do comando [
    public static void q9(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{       
        tabela.write("\ntk_abre_co \t\t ");
        tabela.write(lexema);
        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da
        lexema = "";
        q0(vetor,coluna,l,lexema,tabela);   
    }
    
     //estado final do comando ]
    public static void q10(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{       
        tabela.write("\ntk_fecha_co \t\t ");
        tabela.write(lexema);
        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da
        lexema = "";
        q0(vetor,coluna,l,lexema,tabela);         
    }
    
     //estado final do comando (
    public static void q11(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{       
        tabela.write("\ntk_abre_pa \t\t ");
        tabela.write(lexema);
        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da
        lexema = "";
        q0(vetor,coluna,l,lexema,tabela);        
    }
    
     //estado final do comando )
    public static void q12(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{       
        tabela.write("\ntk_fecha_pa \t\t ");
        tabela.write(lexema);
        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da
        lexema = "";
        q0(vetor,coluna,l,lexema,tabela);      
    }
    
    //estado final do comando ;
    public static void q13(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{       
        tabela.write("\ntk_ponto_virgula \t ");
        tabela.write(lexema);
        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da
        lexema = "";
        q0(vetor,coluna,l,lexema,tabela);          
    }
    
    //estado do comando read (e)
    public static void q14(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 'e':
                lexema+= 'e';
                coluna++;
                q15(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
    //estado do comando read (a)
    public static void q15(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 'a':
                lexema+= 'a';
                coluna++;
                q16(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
    //estado do comando read (d)
    public static void q16(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 'd':
                lexema+= 'd';
                coluna++;
                q17(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
    //estado final do comando read. Onde imprime na tela e verifica se é o comando "read"
    public static void q17(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema,tabela);
                break;
            case 3:
                switch(lexema.length()){
                    case 4://verifica se é o tokens read ou um id com final read
                        tabela.write("\ntk_ler \t\t\t ");
                        tabela.write(lexema);
                        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
       
                        lexema = "";
                        q0(vetor,coluna,l,lexema,tabela);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema,tabela);
                }
                break;
            default:
                System.out.println("Erro no q17");
        }
    }
    
    //estado do comando write (r)
    public static void q18(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 'r':
                lexema+= 'r';
                coluna++;
                q19(vetor,coluna,l,lexema,tabela);
                break;
            case 'h':
                lexema+= 'h';
                coluna++;
                q29(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
    //estado do comando write (i)
    public static void q19(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 'i':
                lexema+= 'i';
                coluna++;
                q20(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
    //estado do comando write (t)
    public static void q20(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 't':
                lexema+= 't';
                coluna++;
                q21(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
    //estado do comando write (e)
    public static void q21(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 'e':
                lexema+= 'e';
                coluna++;
                q22(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
    //estado final do comando write. Onde imprime na tela e verifica se é o comando "write"
    public static void q22(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema,tabela);
                break;
            case 3:
                switch(lexema.length()){
                    case 5://verifica se é o tokens write ou um id com final write
                        tabela.write("\ntk_escreve \t\t ");
                        tabela.write(lexema);
                        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
       
                        lexema = "";
                        q0(vetor,coluna,l,lexema,tabela);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema,tabela);
                }
                break;
            default:
                System.out.println("Erro no q22");
        }
    }
    
     //estado do comando int, ou if e ifno
    public static void q23(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 'n':
                lexema+= 'n';
                coluna++;
                q24(vetor,coluna,l,lexema,tabela);
                break;
            case 'f':
                lexema+= 'f';
                coluna++;
                q26(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
    //estado do comando int (t)
    public static void q24(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 't':
                lexema+= 't';
                coluna++;
                q25(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
     //estado final do comando int. Onde imprime na tela e verifica se é o comando "int"
    public static void q25(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema,tabela);
                break;
            case 3:
                switch(lexema.length()){
                    case 3://verifica se é o tokens int ou um id com final int
                        tabela.write("\ntk_int \t\t\t ");
                        tabela.write(lexema);
                        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
       
                        lexema = "";
                        q0(vetor,coluna,l,lexema,tabela);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema,tabela);
                }
                break;
            default:
                System.out.println("Erro no q25");
        }
    }
    //estado final do comando if. Onde imprime na tela e verifica se é o comando "if"
    public static void q26(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                switch(vetor[coluna]){//verifica se é o ifno
                    case 'n':
                        lexema+= 'n';
                        coluna++;
                        q27(vetor,coluna,l,lexema,tabela);
                        break;
                    default:
                        q0(vetor, coluna,l,lexema,tabela);
                }
                break;
            case 3:
                switch(lexema.length()){
                    case 2://verifica se é o tokens if ou um id com final if
                        tabela.write("\ntk_se \t\t\t ");
                        tabela.write(lexema);
                        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
       
                        lexema = "";
                        q0(vetor,coluna,l,lexema,tabela);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema,tabela);
                }
                break;
            default:
                System.out.println("Erro no q26");
        }
    }
    
     //estado do comando ifno (o)
    public static void q27(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 'o':
                lexema+= 'o';
                coluna++;
                q28(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
    //estado final do comando ifno. Onde imprime na tela e verifica se é o comando "ifno"
    public static void q28(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema,tabela);
                break;
            case 3:
                switch(lexema.length()){
                    case 4://verifica se é o tokens ifno ou um id com final ifno
                        tabela.write("\ntk_senao \t\t ");
                        tabela.write(lexema);
                        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
       
                        lexema = "";
                        q0(vetor,coluna,l,lexema,tabela);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema,tabela);
                }
                break;
            default:
                System.out.println("Erro no q28");
        }
    }
     //estado do comando while (i)
    public static void q29(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 'i':
                lexema+= 'i';
                coluna++;
                q30(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
     //estado do comando while  (l)
    public static void q30(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 'l':
                lexema+= 'l';
                coluna++;
                q31(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
     //estado do comando while  (e)
    public static void q31(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(vetor[coluna]){
            case 'e':
                lexema+= 'e';
                coluna++;
                q32(vetor,coluna,l,lexema,tabela);
                break;
            default:
                q41(vetor,coluna,l,lexema,tabela);
        }
    }
    
     //estado final do comando while. Onde imprime na tela e verifica se é o comando "while"
    public static void q32(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                q0(vetor, coluna,l,lexema,tabela);
                break;
            case 3:
                switch(lexema.length()){
                    case 5://verifica se é o tokens write ou um id com final write
                        tabela.write("\ntk_enquanto \t\t ");
                        tabela.write(lexema);
                        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
       
                        lexema = "";
                        q0(vetor,coluna,l,lexema,tabela);
                    break;
                    default:
                     q41(vetor,coluna,l,lexema,tabela);
                }
                break;
            default:
                System.out.println("Erro no q32");
        }
    }
    
    //estado final do comando +
    public static void q33(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{       
        tabela.write("\ntk_adicao \t\t ");
        tabela.write(lexema);
        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da
        lexema = "";
        q0(vetor,coluna,l,lexema,tabela);             
    }
    //estado final do comando -
    public static void q34(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{       
        tabela.write("\ntk_subtracao \t\t ");
        tabela.write(lexema);
        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da
        lexema = "";
        q0(vetor,coluna,l,lexema,tabela);          
    }
    
    //estado final do comando *
    public static void q35(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{       
        tabela.write("\ntk_multiplicacao \t ");
        tabela.write(lexema);
        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da
        lexema = "";
        q0(vetor,coluna,l,lexema,tabela);        
    }
    
    //estado final do comando /
    public static void q36(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{       
        tabela.write("\ntk_divisão \t\t ");
        tabela.write(lexema);
        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da
        lexema = "";
        q0(vetor,coluna,l,lexema,tabela);            
    }
    
    //estado final do comando >
    public static void q37(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{       
        tabela.write("\ntk_maior \t\t ");
        tabela.write(lexema);
        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da
        lexema = "";
        q0(vetor,coluna,l,lexema,tabela);             
    }
    
      //estado final do comando <
    public static void q38(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{       
        tabela.write("\ntk_menor \t\t ");
        tabela.write(lexema);
        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da
        lexema = "";
        q0(vetor,coluna,l,lexema,tabela);         
    }
    
      //estado final do comando =
    public static void q39(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{       
        tabela.write("\ntk_atribuicao \t\t ");
        tabela.write(lexema);
        tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da
        lexema = "";
        q0(vetor,coluna,l,lexema,tabela);
                    
    }
    
     //estado do num. Verifica se é um num e imprime na tela
    public static void q40(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(verifChar(vetor,coluna)){
            case 1: 
                lexema += vetor[coluna];
                coluna++;
                q40(vetor, coluna,l,lexema,tabela);
                break;
            case 2:
                //imprime na tela
                System.out.print("Erro: Id não pode começar com numero!!!!");
                System.out.println("\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                //imprime na tabela
                tabela.write("\nErro: Id não pode começar com numero!!!!");
                tabela.write("\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                break;
            case 3:
                tabela.write("\nnum \t\t\t ");
                tabela.write(lexema);
                tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                lexema="";
                q0(vetor,coluna,l,lexema,tabela);
                break;
            default:
                System.out.println("Erro q40");
        }
    }  
   
    //estado do id. Verifica se é um id e imprime na tela
    public static void q41(char[] vetor, int coluna, int l, String lexema,FileWriter tabela) throws IOException{
        switch(verifChar(vetor,coluna)){
            case 1: case 2:
                lexema += vetor[coluna];
                coluna++;
                q41(vetor, coluna,l,lexema,tabela);
                break;
            case 3:
                tabela.write("\nid \t\t\t ");
                tabela.write(lexema);
                tabela.write("\t\t\t\t Linha " + l + " Coluna " + (coluna - lexema.length())); //diminui o tanto de caractere para mostar o começo da palavra
                lexema="";
                q0(vetor,coluna,l,lexema,tabela);
                break;
            default:
                System.out.println("Erro q41");
        }
    }  
}
