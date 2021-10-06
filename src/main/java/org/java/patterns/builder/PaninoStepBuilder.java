package org.java.patterns.builder;

import java.util.ArrayList;
import java.util.List;

//    PaninoStepBuilder.newBuilder()
//            .paninoCalled("fds")
//            .breadType("DSa")
//            .fish("Dsa")
//            .addVegetable("fds")
//            .noVegetablesPlease().build()


public class PaninoStepBuilder {

    public static FirstNameStep newBuilder() {
        return new Steps();
    }

    private PaninoStepBuilder() {
    }

    /**
     * First Builder Step in charge of the Panino name.
     * Next Step available : BreadTypeStep
     */
    public static interface FirstNameStep {
        BreadTypeStep paninoCalled(String name);
    }

    /**
     * This step is in charge of the BreadType.
     * Next Step available : MainFillingStep
     */
    public static interface BreadTypeStep {
        MainFillingStep breadType(String breadType);
    }

    /**
     * This step is in charge of setting the main filling (meat or fish).
     * Meat choice : Next Step available : CheeseStep
     * Fish choice : Next Step available : VegetableStep
     */
    public static interface MainFillingStep {
        CheeseStep meat(String meat);

        VegetableStep fish(String fish);
    }

    /**
     * This step is in charge of the cheese.
     * Next Step available : VegetableStep
     */
    public static interface CheeseStep {
        VegetableStep noCheesePlease();

        VegetableStep withCheese(String cheese);
    }

    /**
     * This step is in charge of vegetables.
     * Next Step available : BuildStep
     */
    public static interface VegetableStep {
        BuildStep noMoreVegetablesPlease();

        BuildStep noVegetablesPlease();

        VegetableStep addVegetable(String vegetable);
    }

    /**
     * This is the final step in charge of building the Panino Object.
     * Validation should be here.
     */
    public static interface BuildStep {
        Panino build();
    }

    private static class Steps implements FirstNameStep, BreadTypeStep, MainFillingStep, CheeseStep, VegetableStep, BuildStep {

        private String name;
        private String breadType;
        private String meat;
        private String fish;
        private String cheese;
        private final List<String> vegetables = new ArrayList<String>();

        public BreadTypeStep paninoCalled(String name) {
            this.name = name;
            return this;
        }

        public MainFillingStep breadType(String breadType) {
            this.breadType = breadType;
            return this;
        }

        public CheeseStep meat(String meat) {
            this.meat = meat;
            return this;
        }

        public VegetableStep fish(String fish) {
            this.fish = fish;
            return this;
        }

        public BuildStep noMoreVegetablesPlease() {
            return this;
        }

        public BuildStep noVegetablesPlease() {
            return this;
        }

        public VegetableStep addVegetable(String vegetable) {
            this.vegetables.add(vegetable);
            return this;
        }

        public VegetableStep noCheesePlease() {
            return this;
        }

        public VegetableStep withCheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        public Panino build() {
            Panino panino = new Panino(name);
            panino.setBreadType(breadType);
            if (fish != null) {
                panino.setFish(fish);
            } else {
                panino.setMeat(meat);
            }
            if (cheese != null) {
                panino.setCheese(cheese);
            }
            if (!vegetables.isEmpty()) {
                panino.setVegetables(vegetables);
            }
            return panino;
        }

    }
}


