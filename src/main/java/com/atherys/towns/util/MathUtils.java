package com.atherys.towns.util;

import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;

public class MathUtils {

    public static Vector2i vec3iToVec2i(Vector3i vector3i) {
        return Vector2i.from(vector3i.getX(), vector3i.getZ());
    }

    public static boolean vectorFitsInRange(Vector3d vec, Vector3i lower, Vector3i upper) {
        return fitsInRange(vec.getX(), lower.getX(), upper.getX()) &&
                fitsInRange(vec.getY(), lower.getY(), upper.getY()) &&
                fitsInRange(vec.getZ(), lower.getZ(), upper.getZ());
    }

    public static boolean vectorFitsInRange(Vector3i vec, Vector3i lower, Vector3i upper) {
        return fitsInRange(vec.getX(), lower.getX(), upper.getX()) &&
                fitsInRange(vec.getY(), lower.getY(), upper.getY()) &&
                fitsInRange(vec.getZ(), lower.getZ(), upper.getZ());
    }

    public static boolean vectorFitsInRange(Vector2i vec, Vector2i lower, Vector2i upper) {
        return fitsInRange(vec.getX(), lower.getX(), upper.getX()) &&
                fitsInRange(vec.getY(), lower.getY(), upper.getY());
    }

    public static boolean vectorXZFitsInRange(Vector3d position, Vector2i lower, Vector2i upper) {
        return fitsInRange(position.getX(), lower.getX(), upper.getX()) &&
                fitsInRange(position.getZ(), lower.getY(), upper.getY());
    }

    public static boolean vectorXZFitsInRange(Vector3i position, Vector2i lower, Vector2i upper) {
        return fitsInRange(position.getX(), lower.getX(), upper.getX()) &&
                fitsInRange(position.getZ(), lower.getY(), upper.getY());
    }

    public static boolean fitsInRange(int number, int lower, int upper) {
        return number >= lower && number <= upper;
    }

    public static boolean fitsInRange(double number, int lower, int upper) {
        return number >= lower && number <= upper;
    }

    public static boolean overlaps(Vector2i rectASouthWest, Vector2i rectANorthEast, Vector2i rectBSouthWest, Vector2i rectBNorthEast) {
        return rectASouthWest.getX() < rectBNorthEast.getX() &&
               rectANorthEast.getX() > rectBSouthWest.getX() &&
               rectANorthEast.getY() > rectBSouthWest.getY() &&
               rectASouthWest.getY() < rectBNorthEast.getY();
    }

    public static boolean borders(Vector2i rectASouthWest, Vector2i rectANorthEast, Vector2i rectBSouthWest, Vector2i rectBNorthEast) {
        boolean withinX = ((rectBSouthWest.getX() >= rectASouthWest.getX() && rectBSouthWest.getX() <= rectANorthEast.getX()) ||
                           (rectBNorthEast.getX() >= rectASouthWest.getX() && rectBNorthEast.getX() <= rectANorthEast.getX()));

        boolean withinY = ((rectBNorthEast.getY() >= rectASouthWest.getY() && rectBNorthEast.getY() <= rectANorthEast.getY()) ||
                           (rectBSouthWest.getY() >= rectASouthWest.getY() && rectBSouthWest.getY() <= rectANorthEast.getY()));

        return ((Math.abs(rectASouthWest.getY() - rectBNorthEast.getY()) == 1 && withinX) ||
                (Math.abs(rectASouthWest.getX() - rectBNorthEast.getX()) == 1 && withinY) ||
                (Math.abs(rectANorthEast.getY() - rectBSouthWest.getY()) == 1 && withinX) ||
                (Math.abs(rectANorthEast.getX() - rectBSouthWest.getX()) == 1 && withinY));
    }
}
