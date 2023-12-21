class Transpose{
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6}};
        int[][] transpose = new int[3][2];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                transpose[i][j]=matrix[j][i];  
                System.out.print(transpose[i][j]+" ");         
            }
            System.out.println();
        }
    }
}