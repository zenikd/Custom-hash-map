public class EqualHash {
    int a;
    EqualHash(int a ){
        this.a = a;
    }
    @Override
    public int hashCode() {
        return 1;
    }

    public int getA() {
        return a;
    }
}
