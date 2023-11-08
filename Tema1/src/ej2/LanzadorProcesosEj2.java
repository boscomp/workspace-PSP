package ej2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LanzadorProcesosEj2 {

	public static void main(String[] args) {

		try {

			Process proceso = Runtime.getRuntime().exec("cmd /c dir");

			InputStream inputStream = proceso.getInputStream();

			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			int caracter;

			while ((caracter = bufferedReader.read()) != -1) {

				System.out.print((char) caracter);

			}

			bufferedReader.close();

			inputStreamReader.close();

			inputStream.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
