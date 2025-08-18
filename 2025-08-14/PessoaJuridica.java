public class PessoaJuridica extends Pessoa {
    private Integer numberOfEmployees;

    public PessoaJuridica(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double taxPercentage() {
        if (this.getNumberOfEmployees() > 10) {
            return 0.14;
        }
        else {
            return 0.16;
        }
    }

    @Override
    public double taxPaid() {
        if  (this.getAnualIncome() < 0) {
            System.out.println("The anual income can not be negative");
            return 0;
        }

        return this.getAnualIncome() * this.taxPercentage();
    }
}
