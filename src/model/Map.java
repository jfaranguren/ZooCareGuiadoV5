package model;

/**
 * The Map class represents a 2D grid structure used to model a zoo map.
 * It contains constants for different types of cells (e.g., available spaces,
 * veterinary clinics, and non-enabled spaces)
 * and provides methods to initialize and manage the map.
 * 
 * The map is represented as a 10x10 grid, where each cell is a string
 * indicating its type.
 */
public class Map {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    private final int ROWS = 10;
    private final int COLUMNS = 10;

    private final String AVAILABLE = "D ";
    private final String VETERINARY_CLINIC = "CV";
    private final String NOT_ENABLED = "  ";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    private String[][] map;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    public Map() {

        map = new String[ROWS][COLUMNS];

        initializeMap();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Initializes the zoo map.
     *
     * The method must:
     * 1. Identify positions that are not enabled for construction.
     * 2. Mark enabled positions as AVAILABLE (D).
     * 3. Locate the Veterinary Clinic in its corresponding positions.
     */
    private void initializeMap() {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i % 3 == 0 || j % 3 == 0) {
                    map[i][j] = NOT_ENABLED;
                } else {
                    map[i][j] = AVAILABLE;
                }
            }
        }

        initializeVeterinaryClinic();
    }

    /**
     * Places the Veterinary Clinic on the map.
     *
     * The clinic always occupies:
     * (1,1), (1,2), (2,1), (2,2)
     */
    private void initializeVeterinaryClinic() {

        // map[1][1] = VETERINARY_CLINIC;
        // map[1][2] = VETERINARY_CLINIC;
        // map[2][1] = VETERINARY_CLINIC;
        // map[2][2] = VETERINARY_CLINIC;

        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                map[i][j] = VETERINARY_CLINIC;
            }
        }

    }

    /**
     * Calculates the number of positions currently available
     * for the construction of habitats.
     *
     * @return number of available positions.
     */
    public int countAvailablePositions() {

        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals(AVAILABLE)) {
                    count++;
                }

            }

        }

        return count;
    }

    /**
     * Returns a text representation of the complete zoo map,
     * including row and column indexes.
     *
     * @return map represented as a String.
     */
    public String getMapAsString() {

        String result = "";

        // Add column headers
        result += "\t";
        for (int col = 0; col < map[0].length; col++) {
            if (col < 10) {
                result += "|0" + col + "|\t";
            } else {
                result += "|" + col + "|\t";
            }
        }
        result += "\n";

        // Add horizontal separator
        result += "\t";
        for (int col = 0; col < map[0].length; col++) {
            result += "____\t";
        }
        result += "\n";

        // Add rows with row headers and cell values
        for (int i = 0; i < map.length; i++) {

            // Row header
            if (i < 10) {
                result += "|0" + i + "|";
            } else {
                result += "|" + i + "|";
            }

            // Cell values
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != null) {
                    result += "\t|" + map[i][j] + "|";
                }
            }
            result += "\n";
        }

        return result;
    }

    /**
     * Returns the content of a specific map position.
     *
     * @param row    row index.
     * @param column column index.
     * @return content of the position.
     */
    public String getPosition(int row, int column) {

        return map[row][column];
    }
}