package com.ershov.vd.SECourseProject.Service1;

import lombok.*;

import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.round;

@Data
@NoArgsConstructor
public class Cargo {
    private Type type;
    private double weightOrPieces;

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static Random random = new Random(2021);

    public Cargo(Type type, double weightOrPieces) {
        this.type = type;
        if (type == Type.CONTAINER) {
            if (!(weightOrPieces % 1 == 0)) {
                throw new IllegalArgumentException("The Cargo is a container and the number must be whole");
            }
        }
        this.weightOrPieces = weightOrPieces;
    }

    public void autoGenerate() {
        generateType();
        generateWeightOrPieces();
    }

    private void generateType() {
        this.type = Type.values()[random.nextInt(3)];
    }

    private void generateWeightOrPieces() {
        if (getType() == Type.CONTAINER) {
            this.weightOrPieces = abs(random.nextInt() % 100);
        } else {
            this.weightOrPieces = abs((round(random.nextDouble() * 1_000_000.0) / 1_000.0));
        }
    }

    public enum Type {
        LOOSE,
        LIQUID,
        CONTAINER,
    }


}
