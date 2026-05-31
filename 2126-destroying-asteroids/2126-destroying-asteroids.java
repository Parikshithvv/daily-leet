class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long curmass = mass;
        for(int asteroid : asteroids){
           if (curmass < asteroid) {
                return false;
            }
            curmass += asteroid;
        }
        return true;
        }
        
    }
