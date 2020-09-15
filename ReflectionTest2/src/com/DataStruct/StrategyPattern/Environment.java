package com.DataStruct.StrategyPattern;

public class Environment {
        private Strategy strategy;
        public Environment(Strategy strategy){
            this.strategy = strategy;
        }

        public void setStrategy(Strategy strategy){
            this.strategy = strategy;
        }

        public Strategy getStrategy(){
            return this.strategy;
        }

        public int caculcate(int a, int b){
            return this.strategy.caculate(a,b);
        }
}
