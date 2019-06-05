package br.com.moviestore.dto;

public class FilmeDTO {
	
	private static int qtCopias;

	public static int getQtCopias() {
		return qtCopias;
	}

	public static void setQtCopias(int qtCopias) {
		FilmeDTO.qtCopias = qtCopias;
	}

}
