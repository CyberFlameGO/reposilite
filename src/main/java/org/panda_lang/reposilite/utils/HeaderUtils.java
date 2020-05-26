/*
 * Copyright (c) 2020 Dzikoysk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.reposilite.utils;

import org.panda_lang.utilities.commons.StringUtils;

import java.util.HashMap;
import java.util.Map;

public final class HeaderUtils {

    public static Map<String, String> parseContentDisposition(String contentDisposition) {
        String[] elements = contentDisposition.split(";");
        Map<String, String> parsed = new HashMap<>(elements.length + 1);

        for (String element : elements) {
            String[] entry = StringUtils.splitFirst(element, "=");

            if (entry.length == 1) {
                parsed.put(element, StringUtils.EMPTY);
                continue;
            }

            parsed.put(entry[0], entry[1].substring(1, entry[1].length() - 1));
        }

        return parsed;
    }

}
