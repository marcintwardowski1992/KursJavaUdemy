public class Butelka {

    public int zawartosc;
    public int pojemnosc;

    public Butelka(int zawartosc) {
        this.zawartosc = zawartosc;
        this.pojemnosc = przypisaniePojemości(zawartosc);
    }

    Butelka(int ileLitrów, int pojemnosc){
        this.zawartosc = ileLitrów;
        this.pojemnosc = pojemnosc;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public int getZawartosc(){
        return zawartosc;
    }

    boolean wlej(int ilośćLitrowDoWlania){
        if (ilośćLitrowDoWlania<=this.pojemnosc-this.zawartosc) {
            this.zawartosc += ilośćLitrowDoWlania;
            return true;
        }else
            return false;

    }
    boolean wylej(int ilośćLitrowDoWylania){
        if (ilośćLitrowDoWylania <= zawartosc) {
            this.zawartosc -= ilośćLitrowDoWylania;
            return true;
        }else
            return false;


    }
    void przelej(int ilośćPrzelania, Butelka gdzie){
        if (this.wylej(ilośćPrzelania))
        {
            gdzie.wlej(ilośćPrzelania);
        }

        else
            System.out.println("Za mało wody do przelania");
    }
    void przelejIleMoszna(Butelka gdzie){

        int ileWlezie=0;

        if(gdzie.pojemnosc-gdzie.zawartosc>=this.zawartosc){
             ileWlezie = this.zawartosc;
        }else {
            ileWlezie=gdzie.pojemnosc-gdzie.zawartosc;
        }
        this.wylej(ileWlezie);
        gdzie.wlej(ileWlezie);

    }

    public static int losowankoZawartosci(){
        return 1 +  (int) (Math.random() * (10-1));
    }
    public static int przypisaniePojemości(int ilośćNalania){

        if (ilośćNalania<=5){
            return 5;
        }else {
            return 10;
        }
    }



    public static void main(String[] args) {


        Butelka[] butelka = new Butelka[10]; // sa nulowe


        //petla tworzaca wszystkie te butelki na raz

        for (int i =0; i<butelka.length; i++){
            butelka[i]=new Butelka(losowankoZawartosci());
            System.out.println("Butelka Nr: "+  i +" jest o pojemności " + butelka[i].getPojemnosc()+ " L " +  " i ma nalane  " + butelka[i].getZawartosc() + " L ");

        }

        butelka[0].wlej(10);

        System.out.println(" ");
        System.out.println(butelka[0].getZawartosc());

        butelka[0].wylej(1);
        System.out.println(" ");
        System.out.println(butelka[0].getZawartosc());
        System.out.println(" ");

        butelka[2].przelej(1,butelka[1]);
        System.out.println(butelka[1].getZawartosc());

        System.out.println(" ");


        System.out.println(butelka[8].getZawartosc());
        System.out.println(butelka[9].getZawartosc());
        System.out.println(" ");
        butelka[8].przelejIleMoszna(butelka[9]);
        System.out.println(butelka[8].getZawartosc());
        System.out.println(butelka[9].getZawartosc());

        for (int i =0; i<butelka.length; i++) {

            System.out.println("Butelka Nr: "+  i + " ma pojemnosc  " + butelka[i].getZawartosc() + " L ");

        }


    }

}
