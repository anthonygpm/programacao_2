public class PessoaFisica extends Pessoa{
    private Double healthExpendures;

    public PessoaFisica(String name, Double anualIncome,Double healthExpendures) {
        super(name, anualIncome);
        this.healthExpendures = healthExpendures;
    }

    public Double getHealthExpendures() {
        return healthExpendures;
    }

    public void setHealthExpendures(Double healthExpendures) {
        this.healthExpendures = healthExpendures;
    }

    @Override
    public double taxPercentage() {
        if (this.getAnualIncome() < 20000.00) {
            return 0.15;
        }
        else {
            return 0.25;
        }
    }

    @Override
    public double taxPaid() {
        if (this.getAnualIncome() < 0) {
            System.out.println("The income can not be negative");
            return 0;
        }

        return (this.getAnualIncome() * taxPercentage()) - (this.getHealthExpendures() * 0.5);
    }

}
