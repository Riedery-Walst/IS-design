import java.util.Map;
public class Lab33 {
    static double[] V = {5.0,7.0,9.0,11.0};
    static double[] B = {0.0,2.0,5.0,4.0};

    public static double lambda = 1.53;

    public static double getC1(double r){
        double c1 = 1.0/(lambda*r*1.0);
        return c1;
    }

    public static double getC2(double r){
        double c2 = 1.0/(lambda*1.0+r*1.0);
        return c2;
    }

    public static double getC3(double r){
        double c3 = 1.0/lambda + 1.0/r;
        return c3;
    }

    public static double sum(double[] d, int k){
        double sum = 0;
        for(int i = 0; i < k; i++){
            sum = sum + d[i];
        }
        return sum;
    }

    public static double getSumBC(int n, int type){
        double s = 0;
        for(int i = n; i > 0; i--){
            s = s + getBC(i,type);
        }
        return s;
    }

    public static double getBC(int n, int type){
        double bc = 0;
        if(type==1){
            bc = B[n-1]/getC1(getR(n-1,1));
        } else if (type==2){
            bc = B[n-1]/getC2(getR(n-1,1));
        } else if(type==2){
            bc = B[n-1]/getC3(getR(n-1,1));
        }

        return bc;
    }

    public static double getR(int n, int type){
        double r = 0;
        if(n==0){
            r = 1000.0;
        }else{
            r = getR(n-1,type)*Math.abs((1 + (sum(V,n) - getSumBC(n,type))/1000));
        }
        return r;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("c(л,R) = 1 / (л * R)");
        System.out.printf("R0 = %.5f\n",getR(0,1));
        System.out.printf("R1 = %.5f\n",getR(1,1));
        System.out.printf("R2 = %.5f\n",getR(2,1));
        System.out.printf("R3 = %.5f\n",getR(3,1));
        System.out.printf("R4 = %.5f\n",getR(4,1));
        System.out.println();
        System.out.println("c(л,R) = 1 / (л + R)");
        System.out.printf("R0 = %.5f\n",getR(0,2));
        System.out.printf("R1 = %.5f\n",getR(1,2));
        System.out.printf("R2 = %.5f\n",getR(2,2));
        System.out.printf("R3 = %.5f\n",getR(3,2));
        System.out.printf("R4 = %.5f\n",getR(4,2));
        System.out.println();
        System.out.println("c(л,R) = 1/л + 1/R");
        System.out.printf("R0 = %.5f\n",getR(0,3));
        System.out.printf("R1 = %.5f\n",getR(1,3));
        System.out.printf("R2 = %.5f\n",getR(2,3));
        System.out.printf("R3 = %.5f\n",getR(3,3));
        System.out.printf("R4 = %.5f\n",getR(4,3));
        System.out.println();
        System.out.printf("c4 = %.5f\n",getC3(getR(4,3)));
        double b5 = getC3(getR(4,3))*15;
        System.out.printf("B5 = %.2f\n",b5);

    }

}
