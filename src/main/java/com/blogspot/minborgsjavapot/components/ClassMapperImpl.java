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
package com.blogspot.minborgsjavapot.components;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import static java.util.Objects.requireNonNull;

/**
 *
 * @author pemi
 */
public class ClassMapperImpl implements ClassMapper {

    private final Map<Class<?>, Object> map;

    public ClassMapperImpl() {
        this.map = new ConcurrentHashMap<>();
    }

    @Override
    public <K, V extends K> K put(Class<K> keyClass, V item) {
        requireNonNull(keyClass);
        requireNonNull(item);
        @SuppressWarnings("unchecked")
        // We know that it is a safe cast
        // because V extends K
        final K result = (K) map.put(keyClass, item);
        return result;
    }

    @Override
    public <K> K get(Class<K> clazz) {
        @SuppressWarnings("unchecked")
        // We know that it is a safe cast
        // because the previous put()
        // guarantees this
        final K result = (K) map.get(clazz);
        return result;
    }

}
