package converter;

public class Conversion {
    private String conversionLabel;
    private Double conversionUnit;

    public Conversion(String conversionLabel, Double conversionUnit) {
        this.conversionLabel = conversionLabel;
        this.conversionUnit = conversionUnit;
    }

    public String getConversionLabel() {
        return conversionLabel;
    }

    public void setConversionLabel(String conversionLabel) {
        this.conversionLabel = conversionLabel;
    }

    public Double getConversionUnit() {
        return conversionUnit;
    }

    public void setConversionUnit(Double conversionUnit) {
        this.conversionUnit = conversionUnit;
    }
}