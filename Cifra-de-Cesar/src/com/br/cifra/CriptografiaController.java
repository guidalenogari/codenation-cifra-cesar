package com.br.cifra;

public class CriptografiaController {
	
	Integer chave;
	
	char[] alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	char[] fraseOriginal ;
	
	char[] fraseCriptografada ;
	
	
	
	
	
	public void criptografar(char[] parametro) {
		
		char[] aux = parametro;

		// "OI ME CHAMO HECTINHO"
		
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
