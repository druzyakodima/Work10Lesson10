public class TestException {
    public static void main(String[] args) throws MyArraySizeException {
        String[][] arr4x4 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] arr2x2 = {{"1", "2", "3", "4"},
                {"1", "2", "a", "4"}
        };

        try {
            testArrayException(arr4x4);
            testArrayException(arr2x2);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void testArrayException(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int result = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException("Неподходящий массив");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    result += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Неподходящий символ находиться в массиве %d, в ячейке %d", i, j));
                }
            }
        }
        System.out.println(result);
    }
}
