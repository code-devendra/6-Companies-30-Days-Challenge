class DataStream {
    private int value;
    private int k;
    private int lastCount;
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.lastCount = 0;
    }
    
    public boolean consec(int num) {
        lastCount = (num == value)? lastCount+1 : 0;
        return lastCount >= k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
