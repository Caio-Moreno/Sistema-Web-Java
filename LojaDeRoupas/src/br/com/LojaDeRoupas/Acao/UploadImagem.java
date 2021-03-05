package br.com.LojaDeRoupas.Acao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadImagem implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		         
		        /*Identifica se o formulario é do tipo multipart/form-data*/
		        if (ServletFileUpload.isMultipartContent(request)) {
		            try {
		                /*Faz o parse do request*/
		                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		 
		                /*Escreve a o arquivo na pasta img*/
		                for (FileItem item : multiparts) {
		                    if (!item.isFormField()) {
		                        item.write(new File(request.getServletContext().getRealPath("img")+ File.separator + "uploadfile"));
		                    }
		                }
		 
		                request.setAttribute("message", "Arquivo carregado com sucesso");
		            } catch (Exception ex) {
		                request.setAttribute("message", "Upload de arquivo falhou devido a "+ ex);
		            }
		 
		        } else {
		            request.setAttribute("message","Desculpe este Servlet lida apenas com pedido de upload de arquivos");
		        }
		 
		       
		        
		        return "redirect:entrada?acao=ProdutoConsultar";
		    }
	
	}


