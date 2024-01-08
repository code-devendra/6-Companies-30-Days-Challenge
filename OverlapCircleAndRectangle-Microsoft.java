class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                int c1 = i - xCenter;
                int c2 = j - yCenter;
                if(c1*c1 + c2*c2 <= radius*radius) {
                    return true;
                }
            }
        }
        return false;
        
    }
}
