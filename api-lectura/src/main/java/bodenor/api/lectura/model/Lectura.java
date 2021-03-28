
package bodenor.api.lectura.model;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public abstract class Lectura {
    private String origen;
    private String timestamp;
    private Integer numremarcador;
    
    private String ip;

    public Lectura() {
    }
    
    public Lectura(Lectura lectura){
        this.origen = lectura.origen;
        this.numremarcador = lectura.getNumremarcador();
        this.timestamp = lectura.getTimestamp();
        this.ip = lectura.getIp();
    }

    public Lectura(String origen, Integer numremarcador, String timestamp, String ip) {
        this.origen = origen;
        this.numremarcador = numremarcador;
        this.timestamp = timestamp;
        this.ip = ip;
    }
    
    public Lectura(String origen, String timestamp, Integer numremarcador) {
        this.origen = origen;
        this.numremarcador = numremarcador;
        this.timestamp = timestamp;
    }
    
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Integer getNumremarcador() {
        return numremarcador;
    }

    public void setNumremarcador(Integer numremarcador) {
        this.numremarcador = numremarcador;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public abstract Double getEnergia();
    
    public abstract Double getPotencia();
    
    public abstract String toCsv();
}
