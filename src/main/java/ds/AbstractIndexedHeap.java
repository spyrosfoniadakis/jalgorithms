/*
 * Copyright 2019 the original author or authors.
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
package ds;

/**
 * @author Spyros Foniadakis
 */
public abstract class AbstractIndexedHeap extends AbstractHeap implements IndexedHeapCollection {

    @Override
    public int getParentIndexOf(final int index) {
        if (index == 0){
            return -1;
        }
        return index >> 1;
    }

    @Override
    public int getLeftChildIndexOf(final int index) {
        int childIndex =  (index != 0) ? index << 1 : 1;
        return (childIndex < this.size) ? childIndex : -1;
    }

    @Override
    public int getRightChildIndexOf(final int index) {
        int childIndex =  (index != 0) ? (index << 1) + 1 : 2;
        return (childIndex < this.size) ? childIndex : -1;
    }
}
