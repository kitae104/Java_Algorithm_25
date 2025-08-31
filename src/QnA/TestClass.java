package QnA;

public class TestClass {

    private int n; // 물건들의 수

    public static void main(String[] args) {
        TestClass tc = new TestClass();
        tc.setN(10);
        tc.print();
    }

    public void setN(int n){
        int k = 10;
        this.n = n;
    }

    public void print(){
        System.out.println(n);
    }

}
