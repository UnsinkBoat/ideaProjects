public final class Closure extends Nature{


    public Closure(boolean[][] matrix) {
        super(matrix);
    }
    //自反闭包
    public void reflexivity(){
        if(isReflexivity()){
            return;
        }
        for(int i = 1 ;i<matrix.length;i++){
            matrix[i][i] = true;
        }
    }
    //对称闭包
    public void symmetry(){
        if(isSymmetry()){
            return;
        }
        for(int i =1;i<matrix.length;i++)
            for(int j =1;j<matrix.length;j++){
                if(matrix[i][j]!=matrix[j][i])
                    matrix[i][j] = matrix[j][i] = true;
            }
    }
    //传递闭包
    public void transitivity(){
        while(!isTransitivity()) {
            for (int i = 1; i < matrix.length; i++)
                for (int j = 1; j < matrix.length; j++)
                    for (int k = 1; k < matrix.length; k++) {
                        if (matrix[i][j] && matrix[j][k]) {
                            matrix[i][k] = true;
                        }
                    }
        }
    }
}
