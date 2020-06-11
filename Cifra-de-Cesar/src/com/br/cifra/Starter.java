package com.br.cifra;


public class Starter {

	public static void main(String[] args) {
		
		
		String fraseOriginal = "OI ME CHAMO HECTINHO";

		CriptografiaController controller = new CriptografiaController();
		
		controller.setFraseOriginal(fraseOriginal.toCharArray());

		controller.setChave(1);
				
		controller.criptografar(controller.getFraseOriginal());
		
		System.out.println("Frase Original: "); 
		controller.printar(fraseOriginal);
		System.out.println("\n");
		
		System.out.println("Frase Criptografada: "); 
		controller.printar(controller.getFraseCriptografada());

	
	}

}
