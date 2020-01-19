import java.util.Map;

public class 柱状图中最大的矩形 {
    public static void main(String[] args) {
        int[] heights={2,1,2};
        System.out.println(largestRectangleArea(heights));
    }



    public static int largestRectangleArea(int[] heights) {
        if(heights.length==0)
            return 0;
        int[] left=new int[heights.length];
        int[] right=new int[heights.length];
        left[0]=-1;
        right[heights.length-1]=heights.length;
        for(int i=1;i<heights.length;i++){
            int p=i-1;
            while(p>=0&&heights[p]>=heights[i]){
                p=left[p];
            }
            left[i]=p;
        }
        for(int j=heights.length-1;j>=0;j--){
            int r=j+1;
            while(r<heights.length&&heights[r]>=heights[j]){
                r=right[r];
            }
            right[j]=r;
        }
        int res=0;
        for(int i=0;i<heights.length;i++){
            int area=(right[i]-left[i]-1)*heights[i];
            res=Math.max(res,area);
        }
        return res;
    }
}
