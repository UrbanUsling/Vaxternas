package Inlämning1;

import java.text.DecimalFormat;

public class Palm extends LängdBeroende {
    /*Implementerar Längdberoende och är växt samtidigt. HÄR kapslas allt relevant in för denna specifika
    växttyp. Variablerna kan bara definieras här. Definitionen static ska användas sparsamt.
    Den ärver metoder som en växt behöver, dock definieras kroppen här inne för denna typ.
    Den kommunicerar med VattenTyper för att få rätt enum av vätska
     */
    private String namn;
    private double längd;
    private double vattenmängd;
    private double m = 0;
    private double k = 0.5;
    //5 skyddade variabler. 2 sista initieras och ändrar inte värde;
    DecimalFormat df = new DecimalFormat("###.##");//klass för att begränsa decimaler
    public Palm(String namn, double längd){//2 av variablerna initieras vid konstruktoranrop som parametrar
        this.namn=namn;
        this.längd = längd;
        vattenmängd = setVattenmängd(längd, k, m);//metodanrop i superklassen som ger objektet rätt vattenmängd
    }

    @Override//är denna metod som körs vid anrop och inte en i superklass
    public String getDos() {//String som skriver ut beräknad vattenmängd av rätt vattentyp. Anrop av emun
        return df.format(vattenmängd) + " liter "+ VattenTyper.KRN.getString();
    }

    @Override
    public String getNamn() {
        return this.namn.toLowerCase();
    }
    //Metod med kropp för att få ut namnet på objekt i små bokstäver för jämförelser
    public double getLängd(){return längd;}
    public double getVattenmängd(){return vattenmängd;}//Dessa två metoder finns för testkörning
}