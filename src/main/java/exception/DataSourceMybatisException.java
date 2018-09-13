package exception;

public class DataSourceMybatisException extends Exception {

    private static final long serialVersionUID = 1L;
    private String message;

    public DataSourceMybatisException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
