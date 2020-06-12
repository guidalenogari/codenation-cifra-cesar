package codenation;

import java.io.IOException;

// CLASSE TESTE DA PORRA TODA
public class Starter {

	public static void main(String[] args) throws IOException {
		
		
		String fraseOriginal = "wkh ehvw zdb wr pdnh brxu guhdpv frph wuxh lv wr zdnh xs. pxulho vlhehuw";

		CriptografiaController controller = new CriptografiaController();
		
		controller.setFraseOriginal(fraseOriginal.toCharArray());

		controller.setChave(3);
		
		String fraseDescriptografada = controller.descriptografar(controller.getChave(), fraseOriginal);

		//System.out.println("Frase Descriptografada: "); 
		//controller.printar(fraseDescriptografada);
		

	}


}
