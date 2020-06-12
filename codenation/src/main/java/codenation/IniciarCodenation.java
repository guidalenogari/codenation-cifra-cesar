package codenation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class IniciarCodenation {

    public final static void main(String[] args) throws Exception, IOException  {
    	
    	String token = "9054bd0b8cb45d43683f6e0e56c03247f3aa2e2f";
    	
    	String retornohttp = "";
    	
    	retornohttp = consumoHttp(token);
    	
        System.out.println("----------------------------------------");
    	System.out.println(retornohttp);
    	
    	salvaArquivoJSON(retornohttp);
    	
    	iniciaDescriptografia();
  
    }
    

    public static void iniciaDescriptografia() throws IOException {
    	
    	
    	String fraseOriginal = "wkh ehvw zdb wr pdnh brxu guhdpv frph wuxh lv wr zdnh xs. pxulho vlhehuw";

		CriptografiaController controller = new CriptografiaController();
		
		controller.setFraseOriginal(fraseOriginal.toCharArray());

		controller.setChave(3);
		
		String fraseDescriptografada = controller.descriptografar(controller.getChave(), fraseOriginal);

		System.out.println("Frase Descriptografada: "); 
		controller.printar(fraseDescriptografada);
    	
    }
    
    public static String consumoHttp(String token ) throws ClientProtocolException, 
                                                                                IOException {

    	CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpGet getHttp = new HttpGet("https://api.codenation.dev/v1/challenge"
            		                    + "/dev-ps/generate-data?token=" + token);

            System.out.println("Executando Request do Http: " + getHttp.getRequestLine());

            ResponseHandler<String> resposta = new ResponseHandler<String>() {

                
                public String handleResponse(
                        final HttpResponse respostaHandle) throws ClientProtocolException, IOException {
                    int status = respostaHandle.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entidade = respostaHandle.getEntity();
                        return entidade != null ? EntityUtils.toString(entidade) : null;
                    } else {
                        throw new ClientProtocolException("Erro de Resposta inesperado: " + status);
                    }
                }

            };
            String corpoDeResposta = httpclient.execute(getHttp, resposta);

            return corpoDeResposta;
            
        } finally {
            httpclient.close();
        }
    	
    }
    
    
    public static void salvaArquivoJSON (String retornohttp) throws IOException {
    	
    	String diretorioArquivo = "C:\\Users\\Guilherme\\eclipse-workspace\\codenation\\src\\main\\resources\\answer.json";
    	
    	FileWriter arquivo = new FileWriter(diretorioArquivo);
    	
    	PrintWriter gravarArquivo = new PrintWriter(arquivo);
    	
    	gravarArquivo.printf(retornohttp);
    	
    	arquivo.close();
    	 
        System.out.printf("Conteúdo foi gravado com sucesso no arquivo: ", diretorioArquivo);
    	

    }
    

}