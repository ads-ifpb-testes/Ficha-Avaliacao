package exceptions;

public class CampoVazioException extends Exception {
    public CampoVazioException (){
        super("Campo Obrigatorio nao preechido!");
    }
}
