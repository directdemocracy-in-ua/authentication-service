package ua.in.directdemocracy.service.api.authentication;

import java.io.Serializable;

public final class UserId implements Serializable{
    
    private static final long serialVersionUID = -4231940982203530742L;
    
    private final String value;
    
    public UserId(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserId other = (UserId) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    
    
}
