class Solution {
    public int hIndex(int[] citations) {

        int hIndex = 0;
        for(int h=1;h<=citations.length;h++){
            int count =0;
            for(int citation : citations){
                if(citation >=h){
                    count++;
                }
            
            }
            if(count >=h){
                hIndex =h;
            }
        }
        
        return hIndex;
        
    }
}