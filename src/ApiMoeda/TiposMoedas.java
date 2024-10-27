package ApiMoeda;

public class TiposMoedas {

    private double USD;
    private double BRL;
    private double PHP;

    // Métodos para BRL
    public double getBRL() {
        return BRL;
    }

    public void setBRL(double brl) {
        this.BRL = brl;
    }

    // Métodos para USD
    public double getUSD() {
        return USD;
    }

    public void setUSD(double usd) {
        this.USD = usd;
    }

    // Métodos para PHP
    public double getPHP() {
        return PHP;
    }

    public void setPHP(double php) {
        this.PHP = php;
    }

    @Override
    public String toString() {
        return "Moedas {" +
                "USD = " + USD +
                ", BRL = " + BRL +
                ", PHP = " + PHP +
                '}';
    }
}

