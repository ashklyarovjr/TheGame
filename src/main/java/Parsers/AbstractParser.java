package Parsers;


public abstract class AbstractParser {
    private String filePath;

    public AbstractParser() {
        super();
    }

    public AbstractParser(String filePath) {
        setFilePath(filePath);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
