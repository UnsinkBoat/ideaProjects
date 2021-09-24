import java.util.Arrays;

public class SpecificRS extends Nature {

    public SpecificRS(boolean[][] matrix) {
        super(matrix);
    }

    public boolean compatible(){
        return isReflexivity()&&isSymmetry();
    }

    public boolean equivalence(){
        return compatible()&&isTransitivity();
    }

    public boolean partialOrder(){
        return isReflexivity()&&isAntisymmetry()&&isTransitivity();
    }

    public void divide(){
        if(equivalence()) {
            for(int i =1;i<matrix.length;i++){
                System.out.print("等价类【"+i+"】：");
                for(int j=1;j<matrix.length;j++) {
                    if (matrix[i][j] == true)
                        System.out.print(" " + j);
                }
                System.out.println();
            }

        }
        else{
            System.out.println("不是等价关系，划分失败");
        }
    }

    public int minimum() {
        if (partialOrder()) {
            int[] temp = new int[matrix.length];
            for (int j = 1; j < matrix.length; j++) {
                for (int i = 1; i < matrix.length; i++)
                    if (matrix[i][j])
                        temp[j]++;
            }
            int min = matrix.length,flag =0;
            for(int j=1;j<matrix.length;j++) {
                if (temp[j] < min){
                    min = temp[j];
                    flag =0;
                }else if(temp[j]==min){
                    flag =1;
                }
            }

            if(flag==0)
                return min;

            System.out.println("不存在极小值");
            return -1;

        }else{
            System.out.println("不是等价关系，无法求极值");
            return -1;
        }
    }


    public int maximum() {
        if (partialOrder()) {
            int[] temp = new int[matrix.length];
            for (int j = 1; j < matrix.length; j++) {
                for (int i = 1; i < matrix.length; i++)
                    if (matrix[i][j])
                        temp[j]++;
            }
            int max = 1,flag =0;
            for(int j=1;j<matrix.length;j++) {
                if (temp[j] > max){
                    max = temp[j];
                    flag =0;
                }else if(temp[j]==max){
                    flag =1;
                }
            }

            if(flag==0)
                return max;

            System.out.println("不存在极大值");
            return -1;

        }else{
            System.out.println("不是等价关系，无法求极值");
            return -1;
        }
    }

}
