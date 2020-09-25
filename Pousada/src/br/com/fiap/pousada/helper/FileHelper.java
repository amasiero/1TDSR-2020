package br.com.fiap.pousada.helper;

import br.com.fiap.pousada.exception.LoadFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileHelper {

    public static Properties loadProperties() throws LoadFileException {
        try (FileInputStream fis = new FileInputStream("application.properties")){

            Properties props = new Properties();
            props.load(fis);

            return props;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new LoadFileException("Não foi possível carregar o arquivo application.properties");
        }
    }

}
