package ua.in.directdemocracy.service.api.authentication;

public class DigitalSignature {

    private String encoding;
    private String value;
    private CertificateId cerificateId;
    
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

    public CertificateId getCerificateId() {
        return cerificateId;
    }

    public void setCerificateId(CertificateId cerificateId) {
        this.cerificateId = cerificateId;
    }
    
}
