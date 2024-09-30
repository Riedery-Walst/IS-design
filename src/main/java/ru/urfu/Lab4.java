package ru.urfu;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lab4 {
    public void TernaryOperator1(boolean _flag) {
        System.out.println("Ternary Operator 1:");
        Number _n1 = _flag ? new Integer(1) : new Double(2.0d);
        System.out.println(_n1);
        Number _n2;
        if (_flag)
            _n2 = Double.valueOf(new Integer(1).intValue());
        else
            _n2 = Double.valueOf(new Double(2.0d).doubleValue());
        System.out.println(_n2);
    }

    public void TernaryOperator2(boolean _flag1, boolean _flag2) {
        System.out.println("Ternary Operator 2:");
        Number _n1 = _flag1 ? 1 : _flag2 ? 2 : null;
        System.out.println(_n1);
        Number _n2;
        if (_flag1)
            _n2 = Integer.valueOf(1);
        else if (_flag2)
            _n2 = Integer.valueOf(Integer.valueOf(2).intValue());
        else
            _n2 = Integer.valueOf(((Integer)null).intValue());
        System.out.println(_n2);
    }

    public final double[] _vals = new double[] {1.0d, 2.0d, 3.0d};
    public double GetVal(int _idx) {
        return (_idx < 0 || _idx >= _vals.length) ? null : _vals[_idx];
    }

    public String GetDate1() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    public final DateFormat _format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public String GetDate2() {
        return _format.format(new Date());
    }


    public void run() {
        TernaryOperator1(true);
        TernaryOperator2(true, false);
        System.out.println("Get Value: " + GetVal(2));
        System.out.println("Get Date 1: " + GetDate1());
        System.out.println("Get Date 2: " + GetDate2());
        System.out.println("Get BigDecimal from 1.1d: " + new BigDecimal(1.1d));

        BigDecimal _d1 = new BigDecimal("1.1");
        BigDecimal _d2 = new BigDecimal("1.10");
        System.out.println(_d1 + " == " + _d2 + " : " + _d1.equals(_d2));

        System.out.println("Test printf and println: ");
        System.out.printf("%s\n", "str#1");
        System.out.println("str#2");
    }
}
