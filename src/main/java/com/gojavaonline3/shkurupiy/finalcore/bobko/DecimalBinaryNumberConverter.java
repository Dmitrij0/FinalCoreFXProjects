package com.gojavaonline3.shkurupiy.finalcore.bobko;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalBinaryNumberConverter implements DecimalBinaryNumber {

    private int value;

    DecimalBinaryNumberConverter() {
        this.value = 0;
    }

    DecimalBinaryNumberConverter(String literal) {
        this.value = parseValue(literal);
    }

    @Override
    public String getBinaryValue() {
        if (this.value == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        int currentValue = this.value;
        while (currentValue > 0) {
            res.append(currentValue % 2);
            currentValue /= 2;
        }
        res.reverse();
        return res.toString();
    }

    @Override
    public String getDecimalValue() {
        return ((Integer) this.value).toString();
    }

    @Override
    public void setValue(String literal) {
        this.value = parseValue(literal);
    }

    private int parseValue(String strValue) throws IllegalArgumentException {
        if (strValue.isEmpty()) {
            throw new IllegalArgumentException();
        }
        int value;

        try {
            value = Integer.parseInt(strValue);
            if (value < 0) {
                throw new IllegalArgumentException("Value must be positive");
            }
        } catch (NumberFormatException e) {
            Pattern pattern = Pattern.compile("^0[bB]([01]+$)");
            Matcher matcher = pattern.matcher(strValue);

            if (matcher.find()) {
                return binaryToDecimal(matcher.group(1));
            } else {
                throw new IllegalArgumentException("Not contain a binary number");
            }

        }

        return value;
    }

    private int binaryToDecimal(String binaryString) {
        char[] binary = new char[binaryString.length()];
        binaryString.getChars(0, binaryString.length(), binary, 0);
        int result = 0;

        for (int i = binary.length - 1, j = 0; i >= 0; i--, j++) {
            int currentbit = 0;
            if (binary[i] == '1') {
                currentbit = 1;
            }
            result += currentbit * Math.pow(2, j);
        }

        return result;
    }

}
