package home_work_6;

public class WorkWithAnArrays {

    public int[] CheckLastFourAndReturnArray(int[] arr){
        int lastFour = -1;
        int[] resultArr;

        if (arr.length == 0) {
            throw new RuntimeException();
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 4){
                lastFour = i;
            }
        }

        if (lastFour != -1){
            resultArr = new int[arr.length - lastFour - 1];
            for (int i = lastFour + 1, j = 0; i < arr.length; i++, j++) {
                resultArr[j] = arr[i];
            }
        } else {
            throw new RuntimeException();
        }
        return resultArr;
    }

    public boolean CheckUnitsAndFoursAndReturnBoolean (int[] arr){
        if(arr.length == 0){
            return false;
        }
        for (int i = 0; i < arr.length; i++){
            if(arr[i] != 1 || arr[i] != 4){
                return false;
            }
        }
        return true;
    }
}
