/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodenor.api.lectura.model;

import java.math.BigDecimal;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LecturaCircutorCVMC10 extends Lectura{

    private Double item49;
    private Double item50;
    private Double item95;
    private Double item96;

    public LecturaCircutorCVMC10() {
        
    }

    public LecturaCircutorCVMC10(String origen, Integer numremarcador, String timestamp, String ip, Double item49, Double item50, Double item95, Double item96) {
        super(origen, numremarcador, timestamp, ip);
        this.item49 = item49;
        this.item50 = item50;
        this.item95 = item95;
        this.item96 = item96;
    }
    
    public LecturaCircutorCVMC10(String origen, String timestamp, Integer numremarcador, Double item49, Double item50, Double item95, Double item96) {
        super(origen, timestamp, numremarcador);
        this.item49 = item49;
        this.item50 = item50;
        this.item95 = item95;
        this.item96 = item96;
    }
    
    public LecturaCircutorCVMC10(String origen, Integer numremarcador, String timestamp, String ip){
        super(origen, numremarcador, timestamp, ip);
    }
    
    public LecturaCircutorCVMC10(String origen, String timestamp, Integer numremarcador){
        super(origen, timestamp, numremarcador);
    }

    public Integer getNumremarcador() {
        return super.getNumremarcador();
    }

    public void setNumremarcador(int numremarcador) {
        super.setNumremarcador(numremarcador);
    }

    public String getTimestamp() {
        return super.getTimestamp();
    }

    public void setTimestamp(String timestamp) {
        super.setTimestamp(timestamp);
    }

    public Double getItem49() {
        return item49;
    }

    public void setItem49(Double item49) {
        this.item49 = item49;
    }

    public Double getItem50() {
        return item50;
    }

    public void setItem50(Double item50) {
        this.item50 = item50;
    }

    public Double getItem95() {
        return item95;
    }

    public void setItem95(Double item95) {
        this.item95 = item95;
    }

    public Double getItem96() {
        return item96;
    }

    public void setItem96(Double item96) {
        this.item96 = item96;
    }
    
    public String getIp() {
        return super.getIp();
    }

    public void setIp(String ip) {
        super.setIp(ip);
    }
    
    public Double getEnergia() {
        if (this.item96 >= 0) {
            return (this.item95 * 65536) + this.item96;
        } else {
            return (this.item95 * 65536) + (this.item96 + 65536);
        }
    }
    
    public Double getPotencia() {
        if (this.item50 >= 0) {
            return (((double) this.item49 * 65536) + (double) this.item50) / 1000;
        } else {
            return (((double) this.item49 * 65536) + ((double) this.item50 + 65536)) / 1000;
        }
    }
    
    public String toCsv(){
        return this.getOrigen() + ";" + this.getTimestamp() + ";" + this.getNumremarcador();
    }
    
    @Override
    public String toString(){
        return getNumremarcador() + ";" + getTimestamp() + ";" + getIp() + ";" + this.item49 + ";" + this.item50 + ";" + this.item95 + ";" + this.item96;
    }
    
}
