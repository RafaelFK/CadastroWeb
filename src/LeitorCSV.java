import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LeitorCSV implements ILeitor {

    private Scanner arquivo;
    private String campoAtual[];

    public LeitorCSV( String nomeArquivo ) throws FileNotFoundException  {
        arquivo = new Scanner( new File( nomeArquivo ) );
        arquivo.useDelimiter( "[\n]" );

//        if( arquivo.hasNext() )
//            //arquivo.next();
//        else
//            throw new Exception( "Arquivo vazio" );
    }

    @Override
    public String leCampo( String nomeDoCampo ) {
        if( nomeDoCampo.equals( "nome" ) ) {
            return campoAtual[0];
        } else if( nomeDoCampo.equals( "ementa" ) ) {
            return campoAtual[1];
        } else if( nomeDoCampo.equals( "codigo" ) ) {
            return campoAtual[2];
        } else
            return "";
    }

    @Override
    public boolean proximo() {
        if( arquivo.hasNext() ) {

            String linhaAtual = arquivo.next();
            
            campoAtual = linhaAtual.split( "," );

            return true;
        } else
            return false;
    }

    @Override
    public void close() {
        arquivo.close();
    }

}