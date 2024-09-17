package oop.creationaldesignpatterns.builder;

public class House {
    private Foundation foundation;
    private Walls walls;
    private Roof roof;

    // Private constructor to enforce builder usage
    private House(Builder builder){

    }

    // Getters
    public Foundation getFoundation() {
        return foundation;
    }
    public Walls getWalls() {
        return walls;
    }
    public Roof getRoof() {
        return roof;
    }

    public static class Builder {
        private Foundation foundation;
        private Walls walls;
        private Roof roof;

        // Setters for each component that will return the builder instance
        // to be able to chain methods
        public Builder buildFoundation(Foundation foundation){
            this.foundation = foundation;
            return this;
        }
        public Builder buildWalls(Walls walls){
            this.walls = walls;
            return this;
        }
        public Builder buildRoof(Roof roof){
            this.roof = roof;
            return this;
        }

        // Build method that will return the new House object
        public House build() {
            return new House(this);
        }
    }
}
