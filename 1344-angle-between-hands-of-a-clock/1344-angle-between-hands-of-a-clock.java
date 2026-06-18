class Solution {
    public double angleClock(int hour, int minutes) {
        double mDeg = 6.0 * minutes;
        double hDeg = 30.0 * (hour % 12) + 0.5 * minutes;
        double delta = Math.abs(hDeg - mDeg);
        return Math.min(delta, 360.0 - delta);
    }
}