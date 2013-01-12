package com.jayway.lab.numberclassification;

public class NumberClassifier {

    /**
     * Number classification has the following rules:
     *
     * <ol>
     *     <li># must be greater than 0</li>
     *     <li>If <code>(sum of all factors of a #) == 2#</code> the number is considered <tt>perfect</tt>.</li>
     *     <li>If <code>(sum of all factors of a #) > 2#</code> the number is considered <tt>abundant</tt>.</li>
     *     <li>If <code>(sum of all factors of a #) < 2#</code> the number is considered <tt>deficient</tt>.</li>
     * </ol
     *<p>
     * For example consider 6:<br>
     * <code>1+2+3+6 = 12 = 2*6 => <tt>perfect</tt>
     * </p>
     * <p>and 28:<br>
     * <code>1+2+4+7+14+28 = 56 = 2*28 => <tt>perfect</tt>
     * </p>
     * <p>17:<br>
     *  <code>1+2+4+7+14+28 = 56 = 2*28 => <tt>perfect</tt>
     *  </p>
     * <p>12:<br>
     * <code>1+2+4+6+12 = 25 > 2*12 => <tt>abundant</tt>
     * </p>
     * <p>15:<br>
     * <code>1+3+5+15 = 23 < 2*15 => <tt>deficient</tt>
     * </p>
     *
     * More info:<br>
     * <a href="http://en.wikipedia.org/wiki/Perfect_number">Perfect Numbers</a><br>
     * <a href="http://en.wikipedia.org/wiki/Abundant_number">Abundant Numbers</a><br>
     * <a href="http://en.wikipedia.org/wiki/Deficient_number">Deficient Numbers</a><br>
     *
     * @param number
     * @return
     */
    public Classification classify(int number) {
        if(number <= 0) throw new IllegalArgumentException("Number must be greater than 0");
        return null;
    }

}
