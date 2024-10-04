package ru.urfu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lab5 {
    //число зарегистрированных отказов
    private int _Q = 5;

    //число экспериментов
    private int _N = 1000;

    //среднее время восстановления Tv, с
    private double _minTv = 0.7d;
    private double _maxTv = 1.2d;
    private int _stepsTv = 100;

    //допустимое время восстановления, с
    private double _Tdopv = 0.85d;

    //фактическая продолжительность преобразования i-го
    //входного набора данных Tpi, с
    private double _minTpi = 9.0d;
    private double _maxTpi = 14.0d;
    private int _stepsTpi = 200;

    //допустимое время преобразования i-го
    //входного набора данных, с
    private double _Tdoppi = 12.0d;

    //базовые критерии надежности
    private double _basicCriteria = 0.95d;

    private double GetH0401() {
        return 1 - (double)_Q/_N;
    }

    private double GetH0501() {
        double _Tv = 0;
        //Сперва расчитаем сумму Tvi
        for (int _n = 0; _n <= _N; _n++) {
            //Время восстановление после i-го рассказа получаем рандомно
            //Для этого находим рандомное значение от 0 до 100
            //с помощью random.nextInt(101), где число 0 включено, а 101 исключено
            //умножаем его на шаг и прибавляем минимальное значение Tv
            _Tv += new Random().nextInt(_stepsTv+1) * (_maxTv - _minTv) / _stepsTv + _minTv;
        }
        //Затем разделим полученную сумму на число восстановлений
        _Tv /= _N;

        return _Tv <= _Tdopv ? 1 : _Tdopv/_Tv;
    }

    private double GetH0502() {
        //Сперва найдем сумму Qpi для шага N
        double _sumQpi = 0;
        for (int _sn = _N; _sn >= 0; _sn--) {
            //Сперва расчитаем H0502
            //Для этого получим рандомное Tpi в заданном диапазоне
            double _Tpi = new Random().nextInt(_stepsTpi + 1) * (_maxTpi - _minTpi) / _stepsTpi + _minTpi;
            //Затем расчитаем H0502 по формуле
            double _Qpi = _Tpi <= _Tdoppi ? 1 : _Tdoppi/_Tpi;
            //Теперь прибавим это к общей сумме Qpi
            _sumQpi += _Qpi;
        }
        //Далее полученную сумму разделим на кол-во значений (_N)
        return _sumQpi / _N;
    }

    private double CalculateMetriks(List<Double> _metriksData){
        //Получим сумму метрик
        double _sumM = 0;
        for (double _mdata : _metriksData) {
            _sumM += _mdata;
        }
        //Разделим на количесво метрик
        return _sumM/_metriksData.size();
    }

    private double GetAbsolutCriteriaFactor(double _m4, double _m5) {
        return (_m4 + _m5) / 2;
    }

    private double GetRelativeCriteriaFactor(double _absolutCriteria) {
        return _absolutCriteria / _basicCriteria;
    }

    private double GetQualityFactor(double _absolutCriteria, double _relativeCriteria) {
        return (_absolutCriteria + _relativeCriteria + _basicCriteria) / 3;
    }

    public void run() {


        //Функционирование в заданных режимах (4)
        List<Double> _mData1 = new ArrayList<>();
        _mData1.add(GetH0401());

        //Обеспечение обработки заданного объема информации (5)
        List<Double> _mData2 = new ArrayList<>();
        _mData2.add(GetH0501());
        _mData2.add(GetH0502());

        System.out.println("H0401 = " + _mData1.get(0));
        System.out.println("H0501 = " + _mData2.get(0));
        System.out.println("H0502 = " + _mData2.get(1));

        double _m4 = CalculateMetriks(_mData1);
        double _m5 = CalculateMetriks(_mData2);
        System.out.println("\nФункционирование в заданных режимах = " + _m4);
        System.out.println("Обеспечение обработки заданного объема информации = " + _m5);


        double _absolutCriteria = GetAbsolutCriteriaFactor(_m4,_m5);
        System.out.println("\nАбсолютные показатели критериев = " + _absolutCriteria);
        double _relativeCriteria = GetRelativeCriteriaFactor(_absolutCriteria);
        System.out.println("Относительные показатели критериев = " + _relativeCriteria);

        System.out.println("\nФактор надежности = " + GetQualityFactor(_absolutCriteria, _relativeCriteria));
    }
}
