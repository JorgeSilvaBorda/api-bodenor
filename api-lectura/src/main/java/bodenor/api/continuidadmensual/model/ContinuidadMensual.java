package bodenor.api.continuidadmensual.model;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ApplicationScoped
@Entity(name = "CONTINUIDADMENSUAL")
public class ContinuidadMensual implements Serializable{
    @Id
    @Column(name = "NUMREMARCADOR")
    private Integer numremarcador;
    @Id
    @Column(name = "ANIO")
    private Integer anio;
    @Id
    @Column(name = "MES")
    private Integer mes;
    
    @Column(name = "TIMELECTURAINI")
    private String timelecturaini;
    @Column(name = "TIMELECTURAFIN")
    private String timelecturafin;
    @Column(name = "LECTURAINI")
    private Double lecturaini;
    @Column(name = "LECTURAFIN")
    private Double lecturafin;
    @Column(name = "CONSUMOMES")
    private Double consumomes;

    public ContinuidadMensual(Integer numremarcador, Integer anio, Integer mes, String timelecturaini, String timelecturafin, Double lecturaini, Double lecturafin, Double consumomes) {
        this.numremarcador = numremarcador;
        this.anio = anio;
        this.mes = mes;
        this.timelecturaini = timelecturaini;
        this.timelecturafin = timelecturafin;
        this.lecturaini = lecturaini;
        this.lecturafin = lecturafin;
        this.consumomes = consumomes;
    }

    public ContinuidadMensual(Integer numremarcador, Integer anio, Integer mes, String timelecturaini, Double lecturaini) {
        this.numremarcador = numremarcador;
        this.anio = anio;
        this.mes = mes;
        this.timelecturaini = timelecturaini;
        this.lecturaini = lecturaini;
    }
    
    public ContinuidadMensual(Integer numremarcador, Integer anio, Integer mes) {
        this.numremarcador = numremarcador;
        this.anio = anio;
        this.mes = mes;
    }

    public ContinuidadMensual() {
    }

    public Integer getNumremarcador() {
        return numremarcador;
    }

    public void setNumremarcador(Integer numremarcador) {
        this.numremarcador = numremarcador;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public String getTimelecturaini() {
        return timelecturaini;
    }

    public void setTimelecturaini(String timelecturaini) {
        this.timelecturaini = timelecturaini;
    }

    public String getTimelecturafin() {
        return timelecturafin;
    }

    public void setTimelecturafin(String timelecturafin) {
        this.timelecturafin = timelecturafin;
    }

    public Double getLecturaini() {
        return lecturaini;
    }

    public void setLecturaini(Double lecturaini) {
        this.lecturaini = lecturaini;
    }

    public Double getLecturafin() {
        return lecturafin;
    }

    public void setLecturafin(Double lecturafin) {
        this.lecturafin = lecturafin;
    }

    public Double getConsumomes() {
        return consumomes;
    }

    public void setConsumomes(Double consumomes) {
        this.consumomes = consumomes;
    }
    
    public String toCsv(){
        return this.numremarcador + ";" + this.anio + ";" + this.mes + ";" + this.timelecturaini + ";" + this.lecturaini + ";" + this.timelecturafin + ";" + this.lecturafin + ";" + this.consumomes;
    }
    
    
}
