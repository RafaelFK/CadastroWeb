
public interface ILeitor {
    /**
     * Lê um campo a partir de uma representação que foi armazenada
     * 
     * @param nomeDoCampo
     * @return uma String com o campo lido. Se não encontrar retorna "".
     */
    String leCampo( String nomeDoCampo );
    /**
     * Posiciona no próximo objeto a ser lido
     * 
     * @return Retorna true se existe objeto a ser lido, false caso o arquivo tenha cheagado ao fim.
     */
    boolean proximo();

    /**
     * Fecha o leitor e libera os recursos
     */
    void close();
}
