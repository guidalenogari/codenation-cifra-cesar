package codenation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class envioArquivoJSON {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		
		
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost arquivoDeEnvio = new HttpPost("https://api.codenation.dev/v1/challenge/"
										 + "dev-ps/submit-solution?token=9054bd0b8cb45d43683f6e0e56c03247f3aa2e2f");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addTextBody("answer", "yes", ContentType.TEXT_PLAIN);
		
		System.out.println("Iniciando a criação do post:");

		
		File arquivo = new File("C:/Users/Guilherme/eclipse-workspace/codenation/src/main/resources/answer.json");
		builder.addBinaryBody(
		    "answer",
		    new FileInputStream(arquivo),
		    ContentType.APPLICATION_OCTET_STREAM,
		    arquivo.getName()
		);
		
		System.out.println("Finalizou a criação do post:");

		HttpEntity multipart = builder.build();
		arquivoDeEnvio.setEntity(multipart);

		CloseableHttpResponse resposta = httpClient.execute(arquivoDeEnvio);
		
		System.out.println("Enviou o Json com o seguinte codigo:");
		System.out.println(arquivo.toString());
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo));
		 String linha;
		 while ((linha = bufferedReader.readLine()) != null) {
		   System.out.println(linha);
		 }
		
		System.out.println("Imprimindo a resposta da requisição: ");
		HttpEntity respostaEntity = resposta.getEntity();
		String responseString = EntityUtils.toString(respostaEntity, "UTF-8");
		System.out.println(responseString);

	}

}
