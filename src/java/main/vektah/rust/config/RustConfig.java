package vektah.rust.config;

public class RustConfig {
    private String cargoBinary;
    private String racerBinary;

    public RustConfig() {
        cargoBinary = "cargo";
        racerBinary = "racer";
    }

    public String getCargoBinary() {
        return cargoBinary;
    }

    public void setCargoBinary(String cargoBinary) {
        this.cargoBinary = cargoBinary;
    }

    public String getRacerBinary() {
        return racerBinary;
    }

    public void setRacerBinary(String racerBinary) {
        this.racerBinary = racerBinary;
    }
}
