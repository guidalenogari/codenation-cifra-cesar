package codenation;

import java.math.BigInteger;
import java.security.MessageDigest;

public class ConversorSHA1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String arquivoOriginal = "{\r\n" + 
				"	\"numero_casas\":3,\r\n" + 
				"	\"token\":\"9054bd0b8cb45d43683f6e0e56c03247f3aa2e2f\",\r\n" + 
				"	\"cifrado\":\"wkh ehvw zdb wr pdnh brxu guhdpv frph wuxh lv wr zdnh xs. pxulho vlhehuw\",\r\n" + 
				"	\"decifrado\":\"the best way to make your dreams come true is to wake up. muriel siebert\",\r\n" + 
				"	\"resumo_criptografico\"" + 
				"}";
		
		String mensagemSha1 = "";
		
		try {
			
			
			MessageDigest mDigest = MessageDigest.getInstance("SHA-1");
			
			mDigest.reset();
			mDigest.update(arquivoOriginal.getBytes("utf8"));
			mensagemSha1 = String.format("%040x", new BigInteger(1, mDigest.digest()));
			

			System.out.println( 
					"O Codigo abaixo em formato original: " + 
					"{\r\n" + 
					"	\"numero_casas\":3,\r\n" + 
					"	\"token\":\"9054bd0b8cb45d43683f6e0e56c03247f3aa2e2f\",\r\n" + 
					"	\"cifrado\":\"wkh ehvw zdb wr pdnh brxu guhdpv frph wuxh lv wr zdnh xs. pxulho vlhehuw\",\r\n" + 
					"	\"decifrado\":\"the best way to make your dreams come true is to wake up. muriel siebert\",\r\n" + 
					"	\"resumo_criptografico\":\"\"\r\n" + 
					"}\n"
					
					);
			
			System.out.println( "Código original em formato SHA-1: " );
			System.out.println( mensagemSha1 );

			// With Apache commons
			mensagemSha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex( arquivoOriginal );



		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
