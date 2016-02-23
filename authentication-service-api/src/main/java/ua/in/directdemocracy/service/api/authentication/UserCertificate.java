package ua.in.directdemocracy.service.api.authentication;

public class UserCertificate {

    private CertificateId id;
    private String format;
    private String encoding;
    private String value;
    
    
    public CertificateId getId() {
        return id;
    }

    public void setId(CertificateId id) {
        this.id = id;
    }
    
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getEncoding() {
        return encoding;
    }
    
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
}
