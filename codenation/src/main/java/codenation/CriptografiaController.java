package codenation;

import java.io.IOException;


public class CriptografiaController  {
	
	Integer chave;
	

	char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	
	char[] fraseOriginal ;
	
	char[] fraseCriptografada ;
	
	String conteudoArquivo = "{\r\n" + 
							 "		\"numero_casas\":3,\r\n" + 
							 "		\"token\":\"9054bd0b8cb45d43683f6e0e56c03247f3aa2e2f\",\r\n" + 
							 "		\"cifrado\":\"wkh ehvw zdb wr pdnh brxu guhdpv frph wuxh lv wr zdnh xs. pxulho vlhehuw\",\r\n" + 
							 "		\"decifrado\":\"\",\r\n" + 
							 "		\"resumo_criptografico\":\"\"\r\n" + 
							 "	}";

	
	public void criptografar(char[] parametro) {
		
		char[] aux = parametro;

		if (parametro.length > 0) {
			
			for (int i = 0; i < parametro.length; i++) {
				
				for (int j = 0; j < this.alfabeto.length; j++) {
					
					if(parametro[i] == alfabeto[j]) {
						
						if (alfabeto[j] == 'Z') {
							
							aux[i] = 'A' ;
							
						}else {
							
							aux[i] = alfabeto[j + this.chave] ;
							
						}
						break;
	
					}
						
				}

			}
			
		}
		
		this.fraseCriptografada = aux;

	}
	

	
	public String descriptografar(int chave, String parametro) throws IOException{
		
		IniciarCodenation codenation = new IniciarCodenation();

	      
	    int tamanhoTexto = parametro.length();
	      
		StringBuilder texto = new StringBuilder();


	      for(int c = 0; c < tamanhoTexto; c++){

	    	 int caracterDecifrado = ((int) parametro.charAt(c)) - chave;

	    	 switch (caracterDecifrado) {
				case 29:
					texto.append(" ");
					break;
				case 95:
					texto.append("y");
					break;
				case 43:
					texto.append(".");
					break;
	
				default:
					while(caracterDecifrado < 32 )
				    	 caracterDecifrado += 94;
	
				     texto.append( (char)caracterDecifrado );
				     break;
			}
	         
	      }
	      
	      String novoArquivoSHA1 = "{" + 
	      		"		\"numero_casas\":3,\r\n" + 
	      		"		\"token\":\"9054bd0b8cb45d43683f6e0e56c03247f3aa2e2f\",\r\n" + 
	      		"		\"cifrado\":\"wkh ehvw zdb wr pdnh brxu guhdpv frph wuxh lv wr zdnh xs. pxulho vlhehuw\",\r\n" + 
	      		"		\"decifrado\":\""  +texto.toString() + "\",\r\n" + 
	      		"		\"resumo_criptografico\":\"\"\r\n" + 
	      		"	}";
	      
	      
	      codenation.salvaArquivoJSON(novoArquivoSHA1);

	      return texto.toString();
	   }
	
	public void printar(char[] arrayParametro) {

		String parametro = "";

		parametro = percorrerArray(arrayParametro);
		
		printar(parametro);
		
	}
	
	public void printar(String parametro) {
	
			System.out.println(parametro);
	}
	
	
	public String percorrerArray(char[] arrayParametro) {
		
		String parametro = "";
		
		for( int i = 0 ; i < arrayParametro.length ; i ++) {
			
			parametro += arrayParametro[i];
			
		}
		
		return parametro;
	}

	public Integer getChave() {
		return chave;
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}

	public char[] getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(char[] alfabeto) {
		this.alfabeto = alfabeto;
	} 
	
	public char[] getFraseCriptografada() {
		return fraseCriptografada;
	}

	public char[] getFraseOriginal() {
		return fraseOriginal;
	}

	public void setFraseOriginal(char[] fraseOriginal) {
		this.fraseOriginal = fraseOriginal;
	}
	


}
