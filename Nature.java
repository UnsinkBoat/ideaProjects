public class Nature extends Relationship implements Properties{


    public Nature(boolean[][] matrix) {
        super(matrix);
    }

    @Override
    public String outMatrix() {
        StringBuffer strbuffer = new StringBuffer();

        for(int i =1;i<matrix.length;i++) {
            strbuffer.append("\n");
            for (int j = 1; j < matrix.length; j++) {
                int m = matrix[i][j] ? 1 : 0;
                strbuffer.append(m + " ");
            }
        }

        return new String(strbuffer);
    }

    @Override
    final public boolean isReflexivity() {

       int i = 1;
       while(i<matrix.length && matrix[i][i]){
           i++;
       }

        return i>=matrix.length;

    }

    @Override
    final public boolean isIrreflexive() {

        int i = 1;
        while(i<matrix.length && !matrix[i][i]){
            i++;
        }

        return i>=matrix.length;
    }

    @Override
    final public boolean isSymmetry() {

        for(int i = 1;i<matrix.length;i++)
            for(int j = i;j<matrix.length;j++){
                if(matrix[i][j] != matrix[j][i]){
                    return false;
                }
            }


        return true;
    }

    @Override
    final public boolean isAntisymmetry() {

        for(int i = 1;i<matrix.length;i++){
            for(int j = i;j<matrix.length;j++){
                if( i!=j && matrix[i][j] && matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    final public boolean isTransitivity(){

        int count = 0;

        for(int i =1 ;i<matrix.length;i++)
            for(int j=1 ;j<matrix.length;j++){
                if(matrix[i][j]){
                    count++;
                }
            }

        if(count <3){
            return false;
        }

        for(int i = 1 ; i<matrix.length ;i++)
            for(int j = 1;j<matrix.length;j++)
                for(int k = 1;k<matrix.length;k++){
                    if(matrix[i][j] && matrix[j][k] && !matrix[i][k]){
                        return false;
                    }
                }

        return true;
    }

    final public void  intersection(Relationship relationship){
        for(int i =1;i<matrix.length;i++)
            for(int j =1 ;j<matrix.length;j++){
                matrix[i][j] = matrix[i][j]&&relationship.matrix[i][j];
            }
    }

    final public void union(Relationship relationship){
        for(int i =1;i<matrix.length;i++)
            for(int j =1 ;j<matrix.length;j++){
                matrix[i][j] = matrix[i][j]||relationship.matrix[i][j];
            }
    }

    final public void inverse(){
        for(int i = 1;i<matrix.length;i++)
            for(int j = i;j<matrix.length;j++){
                matrix[0][0] = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = matrix[0][0];
            }
    }

    final public void compound(Relationship relationship){
        boolean temp[][] = new boolean[matrix.length][matrix.length];
        for(int i = 1 ;i<matrix.length ;i++)
            for(int j = 1;j<matrix.length;j++){
                int row = 1 , col = 1;
                temp[i][j] = false;
                while(!temp[i][j] && row<matrix.length){
                    temp[i][j] = matrix[i][col]&&relationship.matrix[row][j];
                    row++;
                    col++;
                }
            }
        matrix = temp;
    }
}
