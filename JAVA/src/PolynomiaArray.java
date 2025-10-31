public class PolynomiaArray {
    private int [] coefficient;      // 다항식의 계수 배열

    PolynomiaArray() {                  // 영(zero) 상수 항으로 1항식 생성
        ;
    }

    PolynomiaArray(int [] coefficient) {   // 계수의 배열로 다항식 생성
        setCoefficient(coefficient);
    }

    PolynomiaArray add(PolynomiaArray aPoly) {   // 두 다항식 덧셈
        int newLength   = Math.max(coefficient.length, aPoly.getCoefficient().length);   // 두식 중 고차항
        int [] newArray = new int [newLength];                        // 정수 배열을 생성
        PolynomiaArray newPolynomialArray = new PolynomiaArray(newArray);   // 초기 다항식 생성

        if (coefficient.length > aPoly.getCoefficient().length) {   // 첫번째 다항식이 고차식
            int i, j;
            for (i = 0; i < coefficient.length - aPoly.getCoefficient().length; i++) {   // 항 갯수의 차
                newArray[i] = coefficient[i];         // 고차식을 그대로
            }
            for (j = 0; i < coefficient.length; i++, j++) {      // 나머지 차 항을 덧셈
                newArray[i] = coefficient[i] + aPoly.getCoefficient()[j];
            }
        }
        else {                                          // 두번째 다항식이 고차식
            ;
        }

        return newPolynomialArray;      // 결과 다항식 리턴
    }

    PolynomiaArray neg() {   // 모든 계수의 부호(-/+)를 각각 반대로 변환
        int newLength   = coefficient.length;   // 배열 크기
        int [] newArray = new int [newLength];                        // 정수 배열을 생성
        PolynomiaArray newPolynomialArray = new PolynomiaArray(newArray);   // 초기 다항식 생성

        for (int i = 0; i < coefficient.length; i++) {   // 항 갯수의 차
            newPolynomialArray.getCoefficient()[i] = -1 * this.getCoefficient()[i];
        }

        return newPolynomialArray;      // 결과 다항식 리턴
    }

    public int [] getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int [] coefficient) {
        this.coefficient = coefficient;
    }

    /** 객체를 문자열로 표시 */
    public String toString() {
        int thisDegree = this.coefficient.length - 1;

        if (thisDegree == 0)
            return "" + coefficient[0];      // 상수 단 항

        String buff = "";
        for (int i = 0; i < thisDegree + 1; i++) {
            if (this.coefficient[i] != 0) {
                if      (i == thisDegree)     buff += " + " + coefficient[i];         // 상수항
                else if (i == thisDegree - 1) buff += " + " + coefficient[i] + "x";      // 1차항
                else                    buff += " + " + coefficient[i] + "x^" + (thisDegree - i);
            }
        }

        buff = buff.replace(" 1x",  " x");
        buff = buff.replace("-1x", "-x");
        buff = buff.substring(3);
        buff = buff.replace("+ -",  "- ");

        return buff;
    }
}