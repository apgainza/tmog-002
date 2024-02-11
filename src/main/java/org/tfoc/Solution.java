package org.tfoc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The class containing the solution to this exercise
 */
public class Solution {

    public static boolean isValid(String s) {
        Map<String, String> mapPatternCaracteres = Map.of(
                "(", ")",
                "{", "}",
                "[", "]"
        );

        Map<Integer, Boolean> mapCaracterUsed = new HashMap<>();

        char[] chainCaracteres = s.toCharArray();
        int lengthChain = chainCaracteres.length;

        for (int i = 0; i < chainCaracteres.length; i++) {
            mapCaracterUsed.put(i, false);
        }

        for (Map.Entry<Integer, Boolean> entry : mapCaracterUsed.entrySet()) {
            Integer key = entry.getKey();
            Boolean value = entry.getValue();
            String chainCaractere = "" + chainCaracteres[key];

            if (!mapPatternCaracteres.containsKey(chainCaractere) &&
                    !mapPatternCaracteres.containsValue(chainCaractere)) {
                break;
            }

            String keyCaracterClose = mapPatternCaracteres.get(chainCaractere);

            if (!value) {
                boolean fincCaracterClose = false;
                for (int i = key + 1; i < lengthChain; i++) {
                    if (Objects.nonNull(keyCaracterClose)) {
                        String chainCaractere1 = "" + chainCaracteres[i];
                        if (keyCaracterClose.equals(chainCaractere1)) {
                            mapCaracterUsed.put(i, true);
                            fincCaracterClose = true;
                            break;
                        }
                    }
                }

                if (fincCaracterClose)
                    entry.setValue(true);

            }

        }

        return mapCaracterUsed.values().stream().allMatch(Boolean::booleanValue);
    }

}
