class Liczba {
    int a;
    int ileDzielnikow;
    public Liczba(){
        this.ileDzielnikow=0;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public boolean czyPierwsza(int a){
        for(int i=1; i<=a; i++){
            if((a%i)==0){
                ileDzielnikow++;
            }
        }
        if(ileDzielnikow==2){
            return true;
        }
        else{
            return false;
        }
    }
}
