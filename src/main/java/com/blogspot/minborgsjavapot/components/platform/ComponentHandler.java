/**
 *
 * Copyright (c) 2006-2015, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.blogspot.minborgsjavapot.components.platform;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import static java.util.Objects.requireNonNull;
import static java.util.Objects.requireNonNull;

/**
 *
 * @author pemi
 */
public class ComponentHandler implements ClassMapper<Component> {

    private final Map<Class<? extends Component>, Component> map;

    public ComponentHandler() {
        this.map = new ConcurrentHashMap<>();
    }

    @Override
    public <K extends Component, V extends K> K put(Class<K> keyClass, V item) {
        requireNonNull(keyClass);
        requireNonNull(item);
        item.added();
        @SuppressWarnings("unchecked")
        // We know that it is a safe cast
        // because V extends K
        final K result = (K) map.put(keyClass, item);
        if (result != null) {
            result.removed();
        }
        return result;
    }

    @Override
    public <K extends Component> K get(Class<K> clazz) {
        @SuppressWarnings("unchecked")
        final K result = (K) map.get(clazz);
        return result;
    }

}
