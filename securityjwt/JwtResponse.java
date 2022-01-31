package pl.kurs.schooldiary.securityjwt;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String jwttoken;


    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getJwttoken() {
        return jwttoken;
    }
}
