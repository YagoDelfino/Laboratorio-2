import java.util.Objects;

public class Fracao {

    private int numerador;
    private int denominador;
    private boolean positiva;
    private boolean redutivel;

    /**
     * Construtor.
     * O sinal da fração é passado no parâmetro específico.
     *
     * @param numerador O numerador (inteiro não-negativo)
     * @param denominador O denominador (inteiro positivo)
     * @param positiva se true, a fração será positiva; caso contrário, será negativa
     */
    public Fracao(int numerador, int denominador, boolean positiva) {
        this.numerador = numerador;
        this.denominador = denominador;
        this.positiva = positiva;
    }

    /**
     * @return um double com o valor numérico desta fração
     */
    public double getValorNumerico() {

        return this.positiva ? ((double)this.numerador/this.denominador): (-(double)this.numerador/this.denominador);
    }

    /**
     * Retorna uma fração que é equivalente a esta fração (this),
     * e que é irredutível (numerador e denominador primos entre si).
     * Em outras palavras, retorna a fração geratriz desta fração.
     *
     * @return uma fração irredutível equivalente a esta;
     *         no caso desta fração JÁ SER ela própria irredutível, retorna this
     */
    public Fracao getFracaoGeratriz() {
        int cont = 2;
        int numerador = 0, denominador = 0;

        numerador = this.numerador;
        denominador = this.denominador;


        while(cont <=numerador && cont <=denominador)
        {
            this.redutivel = true;
            if(numerador % cont == 0 && denominador % cont ==0){
                numerador/=cont;
                denominador /= cont;
            }
            else cont++;
        }

        Fracao fracaoGeratriz = new Fracao(numerador,denominador,this.positiva);
        return this.redutivel ? fracaoGeratriz : this;
    }

    public int getNumerador() {
        return this.numerador;
    }

    public int getDenominador() {
        return this.denominador;
    }

    public boolean isPositiva() {
        return this.numerador == 0 ? this.positiva = false: this.positiva;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        Fracao fracao = (Fracao) o;
        return (fracao.getValorNumerico() == this.getValorNumerico());
    }
}
