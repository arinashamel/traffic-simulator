package swe39;

import jdistlib.Poisson;
import jdistlib.rng.QRandomEngine;

class ProbabilitySystem {
    public static void main(String[] args){

        QRandomEngine engn = new QRandomEngine();
        double nums = Poisson.random(80, 60);
        System.out.println("Number generated: " + nums);
    }
}